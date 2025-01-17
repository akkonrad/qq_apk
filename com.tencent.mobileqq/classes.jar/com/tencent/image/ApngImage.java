package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

public class ApngImage
  implements Runnable
{
  public static final int CAN_PLAY_TAG_AIO = 0;
  public static int DECRYPTTYPE_DECRYPT = 1;
  public static final int DENSITY_NONE = 0;
  public static final int ERROR_CODE_SUCCESS = 0;
  private static final int IMAGE_INFO_INDEX_CURRENTFRAM = 3;
  private static final int IMAGE_INFO_INDEX_ERRORCODE = 5;
  private static final int IMAGE_INFO_INDEX_FRAMECOUNT = 2;
  private static final int IMAGE_INFO_INDEX_FRAMEDELAY = 4;
  private static final int IMAGE_INFO_INDEX_HEIGHT = 1;
  private static final int IMAGE_INFO_INDEX_WIDTH = 0;
  private static int IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 262144;
  public static final String KEY_DECRYPTTYPE = "key_decryptType";
  public static final String KEY_DOUBLE_BITMAP = "key_double_bitmap";
  public static final String KEY_DRAW_ROUND = "key_draw_round";
  public static final String KEY_GET_RESET_LOOP = "key_get_reset_loop";
  public static final String KEY_LOOP = "key_loop";
  public static final String KEY_ONCE_CLEAR = "key_once_clear";
  public static final String KEY_STOP_ON_FIRST = "key_stop_on_first";
  public static final String KEY_TAGID_ARR = "key_tagId_arr";
  public static final String KEY_TAGNAME = "key_name";
  public static final String KEY_USE_RECT = "key_use_rect";
  private static final int PENDING_ACTION_CAPACITY = 100;
  private static final String TAG = "ApngImage";
  public static ArrayList<Integer> canDecodeIDs = new ArrayList();
  private static ArgumentsRunnable<WeakReference<ApngImage>> sAccumulativeRunnable;
  private static Handler sHandler;
  protected static boolean sPaused = false;
  protected static final ArrayList<WeakReference<ApngImage>> sPendingActions = new ArrayList(105)
  {
    private void ensureCapacity()
    {
      int i = size();
      if (i > 100) {
        removeRange(0, i - 100 - 1);
      }
    }
    
    public boolean add(WeakReference<ApngImage> paramAnonymousWeakReference)
    {
      boolean bool = super.add(paramAnonymousWeakReference);
      ensureCapacity();
      return bool;
    }
  };
  public int apngLoop;
  private boolean cacheFirstFrame;
  private CopyOnWriteArrayList<WeakReference<AnimationCallback>> callbacks = new CopyOnWriteArrayList();
  protected long contentIndex;
  private Bitmap curFrame;
  public int currentApngLoop;
  protected int currentFrameDelay;
  int decryptType;
  Rect drawRect;
  protected File file;
  public Bitmap firstFrame;
  public int height = 0;
  private boolean mDecodeNextFrameEnd = true;
  protected int mDensity = 160;
  public boolean mDoubleBitmap;
  public boolean mDrawRoundCorner;
  private int mFrameCount = 0;
  public boolean mGetResetLoop;
  int[] mImageInfo = new int[6];
  boolean mIsInPendingAction = false;
  protected ArrayList<WeakReference<ApngDrawable.OnPlayRepeatListener>> mListener = new ArrayList();
  String mName;
  public boolean mOnceAndClear;
  public boolean mStopOnFirstFrame;
  int[] mTagIDArr = { 0 };
  long nativeFrameInfoInstance;
  long nativeImageInstance;
  private Bitmap nextFrame;
  private boolean onlyOneFrame = false;
  private Paint paint = new Paint();
  private Paint paintTransparentBlack = new Paint();
  boolean useRect;
  public int width = 0;
  
  public ApngImage(File paramFile, boolean paramBoolean)
    throws IOException
  {
    this.file = paramFile;
    init(paramBoolean);
  }
  
  public ApngImage(File paramFile, boolean paramBoolean, Bundle paramBundle)
    throws IOException
  {
    if (paramBundle != null)
    {
      this.apngLoop = paramBundle.getInt("key_loop", 0);
      this.decryptType = paramBundle.getInt("key_decryptType", this.decryptType);
      this.mName = paramBundle.getString("key_name");
      this.mOnceAndClear = paramBundle.getBoolean("key_once_clear", false);
      this.mDrawRoundCorner = paramBundle.getBoolean("key_draw_round", false);
      this.mGetResetLoop = paramBundle.getBoolean("key_get_reset_loop", true);
      bool1 = bool2;
      if (!this.mDrawRoundCorner) {
        if (!paramBundle.getBoolean("key_double_bitmap", false)) {
          break label272;
        }
      }
    }
    label272:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mDoubleBitmap = bool1;
      this.mStopOnFirstFrame = paramBundle.getBoolean("key_stop_on_first", false);
      int[] arrayOfInt = paramBundle.getIntArray("key_tagId_arr");
      if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
        this.mTagIDArr = paramBundle.getIntArray("key_tagId_arr");
      }
      this.useRect = paramBundle.getBoolean("key_use_rect", false);
      this.file = paramFile;
      init(paramBoolean);
      return;
    }
  }
  
  private void getImageInfo(File paramFile)
  {
    paramFile = paramFile.getAbsolutePath();
    if ((this.mImageInfo == null) || (this.mImageInfo.length != 6)) {
      this.mImageInfo = new int[6];
    }
    this.nativeImageInstance = nativeStartDecode(paramFile, this.mImageInfo, this.decryptType);
    if (this.mImageInfo[5] == 0)
    {
      this.width = this.mImageInfo[0];
      this.height = this.mImageInfo[1];
      this.mFrameCount = this.mImageInfo[2];
      if (QLog.isColorLevel()) {
        QLog.d("ApngImage", 2, "start decode success width = " + this.width + " height = " + this.height + " frameCount = " + this.mFrameCount);
      }
      return;
    }
    QLog.e("ApngImage", 1, "start decode error: " + this.mImageInfo[5]);
  }
  
  private void init(boolean paramBoolean)
    throws IOException
  {
    this.paint.setAntiAlias(true);
    this.paintTransparentBlack.setAntiAlias(true);
    this.paintTransparentBlack.setColor(0);
    this.cacheFirstFrame = paramBoolean;
    getImageInfo(this.file);
    initBitmap();
    if (!getNextFrame()) {
      this.onlyOneFrame = true;
    }
    applyNextFrame();
    if (paramBoolean) {
      this.firstFrame = this.curFrame;
    }
    if (this.onlyOneFrame)
    {
      this.firstFrame = this.curFrame;
      this.nextFrame = null;
    }
  }
  
  private void initBitmap()
  {
    if ((this.width > 0) && (this.height > 0)) {}
    try
    {
      this.curFrame = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
      if (QLog.isColorLevel()) {
        QLog.d("ApngImage", 2, "init curFrame success width = " + this.curFrame.getWidth() + " height = " + this.curFrame.getHeight());
      }
      if ((this.width > 0) && (this.height > 0)) {
        if (!this.mDoubleBitmap) {
          if (this.width * this.height > IMAGE_SIZE_DISABLE_DOUBLE_BUFFER) {
            break label194;
          }
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.nextFrame = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
          if (QLog.isColorLevel()) {
            QLog.d("ApngImage", 2, "init nextFrame success width = " + this.nextFrame.getWidth() + " height = " + this.nextFrame.getHeight());
          }
          label194:
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError3)
        {
          QLog.e("ApngImage", 1, "APNG buffer create OOM");
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        URLDrawable.clearMemoryCache();
        try
        {
          this.curFrame = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("ApngImage", 1, "APNG create Bitmap OOM");
        }
      }
    }
  }
  
  private void invalidateSelf()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            break label69;
          }
          ((AnimationCallback)localWeakReference.get()).invalidateSelf();
        }
      }
      finally {}
      return;
      label69:
      i += 1;
    }
  }
  
  public static native void nativeFreeFrame(long paramLong);
  
  public static native void nativeFreeImage(long paramLong);
  
  public static native long nativeGetNextFrame(long paramLong1, long paramLong2, Bitmap paramBitmap, int[] paramArrayOfInt);
  
  public static native long nativeStartDecode(String paramString, int[] paramArrayOfInt, int paramInt);
  
  public static final void pauseAll()
  {
    sPaused = true;
    synchronized (canDecodeIDs)
    {
      canDecodeIDs.clear();
      return;
    }
  }
  
  public static final void pauseByTag(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngImage", 2, "pauseByTag , conplayids:" + canDecodeIDs + ", tag:" + paramInt);
    }
    synchronized (canDecodeIDs)
    {
      paramInt = canDecodeIDs.indexOf(Integer.valueOf(paramInt));
      if (paramInt >= 0) {
        canDecodeIDs.remove(paramInt);
      }
      return;
    }
  }
  
  public static final void playByTag(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngImage", 2, "playByTag , conplayids:" + canDecodeIDs + ", tag:" + paramInt);
    }
    if (sPaused) {
      pauseAll();
    }
    if (!canDecodeIDs.contains(Integer.valueOf(paramInt))) {
      canDecodeIDs.add(Integer.valueOf(paramInt));
    }
    resumeAll();
  }
  
  public static final void resumeAll()
  {
    for (;;)
    {
      int i;
      try
      {
        sPaused = false;
        i = sPendingActions.size() - 1;
        if (i >= 0)
        {
          ApngImage localApngImage = (ApngImage)((WeakReference)sPendingActions.get(i)).get();
          if (localApngImage == null)
          {
            sPendingActions.remove(i);
          }
          else if (localApngImage.getIsEnable())
          {
            sPendingActions.remove(i);
            localApngImage.reDraw();
          }
        }
      }
      finally {}
      return;
      i -= 1;
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  private void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.callbacks;
    int i = 0;
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        if (i < this.callbacks.size())
        {
          localObject = (WeakReference)this.callbacks.get(i);
          if ((localObject == null) || (((WeakReference)localObject).get() == null))
          {
            localObject = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally {}
      try
      {
        ((CopyOnWriteArrayList)localObject).remove(i);
        i = j;
        i += 1;
      }
      finally
      {
        break;
      }
      ((AnimationCallback)((WeakReference)localObject).get()).scheduleSelf(paramRunnable, paramLong);
      continue;
      return;
    }
    throw paramRunnable;
  }
  
  public void addCallBack(AnimationCallback paramAnimationCallback)
  {
    if (paramAnimationCallback != null) {
      synchronized (this.callbacks)
      {
        this.callbacks.add(new WeakReference(paramAnimationCallback));
        return;
      }
    }
  }
  
  void addToPendingActions(ApngImage paramApngImage)
  {
    if (paramApngImage == null) {
      break label4;
    }
    label4:
    while (paramApngImage.mIsInPendingAction) {
      return;
    }
    int i = sPendingActions.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label52;
      }
      if ((ApngImage)((WeakReference)sPendingActions.get(i)).get() == paramApngImage) {
        break;
      }
      i -= 1;
    }
    label52:
    sPendingActions.add(new WeakReference(paramApngImage));
    paramApngImage.mIsInPendingAction = true;
  }
  
  public void applyNextFrame()
  {
    try
    {
      if (this.nextFrame != null)
      {
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        Canvas localCanvas = new Canvas(this.curFrame);
        this.curFrame.eraseColor(0);
        if (this.mDrawRoundCorner)
        {
          localPaint.setFilterBitmap(true);
          localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.width, this.height), this.width, this.height, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        localCanvas.drawBitmap(this.nextFrame, 0.0F, 0.0F, localPaint);
      }
      return;
    }
    finally {}
  }
  
  protected void doApplyNextFrame()
  {
    applyNextFrame();
    this.mDecodeNextFrameEnd = true;
    if (getIsEnable())
    {
      invalidateSelf();
      return;
    }
    addToPendingActions(this);
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    Object localObject = null;
    if ((paramCanvas == null) || (paramRect == null)) {}
    do
    {
      do
      {
        return;
        if ((this.apngLoop > 0) && (this.apngLoop <= this.currentApngLoop) && (this.mOnceAndClear))
        {
          paramCanvas.drawColor(16777215);
          return;
        }
        initHandlerAndRunnable();
        if ((!this.onlyOneFrame) && (paramBoolean)) {
          break;
        }
      } while (this.firstFrame == null);
      localBitmap1 = this.firstFrame;
      if (this.useRect) {
        localObject = this.drawRect;
      }
      paramCanvas.drawBitmap(localBitmap1, (Rect)localObject, paramRect, paramPaint);
      return;
      if (this.curFrame != null)
      {
        Bitmap localBitmap2 = this.curFrame;
        localObject = localBitmap1;
        if (this.useRect) {
          localObject = this.drawRect;
        }
        paramCanvas.drawBitmap(localBitmap2, (Rect)localObject, paramRect, paramPaint);
      }
      if (!getIsEnable()) {
        break label211;
      }
      if ((this.apngLoop <= 0) || (this.apngLoop > this.currentApngLoop)) {
        break;
      }
      if ((this.mStopOnFirstFrame) && (this.mImageInfo[3] == this.mFrameCount - 1))
      {
        executeNewTask();
        return;
      }
    } while (this.mOnceAndClear);
    addToPendingActions(this);
    return;
    executeNewTask();
    return;
    label211:
    addToPendingActions(this);
  }
  
  public void drawFrame(Canvas paramCanvas) {}
  
  protected void executeNewTask()
  {
    long l1;
    long l2;
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      l1 = SystemClock.uptimeMillis();
      l2 = getDelay();
    }
    try
    {
      Utils.executeAsyncTaskOnSerialExcuter(new DecodeNextFrameAsyncTask(l1 + l2), new Void[] { (Void)null });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("URLDrawable_", 2, "executeNewTask()", localRejectedExecutionException);
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.nativeFrameInfoInstance != 0L) {
        nativeFreeFrame(this.nativeFrameInfoInstance);
      }
      if (this.nativeImageInstance != 0L) {
        nativeFreeImage(this.nativeImageInstance);
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      super.finalize();
    }
  }
  
  public int getByteSize()
  {
    int j;
    if (this.onlyOneFrame) {
      j = Utils.getBitmapSize(this.firstFrame);
    }
    int i;
    do
    {
      return j;
      j = 0;
      if (this.curFrame != null) {
        j = 0 + Utils.getBitmapSize(this.curFrame);
      }
      i = j;
      if (this.nextFrame != null) {
        i = j + Utils.getBitmapSize(this.nextFrame);
      }
      j = i;
    } while (this.nativeFrameInfoInstance == 0L);
    return i + this.width * this.height * 4;
  }
  
  public Bitmap getCurrentFrame()
  {
    return this.curFrame;
  }
  
  public int getDelay()
  {
    return this.currentFrameDelay;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  final boolean getIsEnable()
  {
    if (sPaused) {}
    for (;;)
    {
      return false;
      if (this.mTagIDArr != null)
      {
        int i = 0;
        while (i < this.mTagIDArr.length)
        {
          if (canDecodeIDs.contains(Integer.valueOf(this.mTagIDArr[i]))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public int getLoopCount()
  {
    return this.mFrameCount;
  }
  
  protected boolean getNextFrame()
  {
    for (;;)
    {
      try
      {
        if (this.nativeImageInstance == 0L) {
          break label134;
        }
        if (this.nextFrame != null)
        {
          this.nativeFrameInfoInstance = nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.nextFrame, this.mImageInfo);
          if (this.mImageInfo[5] == 0)
          {
            this.currentFrameDelay = this.mImageInfo[4];
            bool = true;
            return bool;
          }
        }
        else
        {
          this.nativeFrameInfoInstance = nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.curFrame, this.mImageInfo);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label134;
        }
      }
      finally {}
      QLog.d("ApngImage", 2, "getNextFrame fail: " + this.mImageInfo[5]);
      label134:
      boolean bool = false;
    }
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(this.height, this.mDensity, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(this.width, this.mDensity, paramInt);
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  protected void initHandlerAndRunnable()
  {
    if (sHandler == null)
    {
      sHandler = new Handler();
      sAccumulativeRunnable = new DoAccumulativeRunnable(null);
    }
  }
  
  void onDecodeNextFrameCanceled()
  {
    if (QLog.isColorLevel()) {
      QLog.e("URLDrawable_", 2, "apng decode canceled. " + this.file);
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  void onDecodeNextFrameFailed(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("URLDrawable_", 2, "apng decode error. " + this.file, paramThrowable);
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  void onDecodeNextFrameSuccessed(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      long l = SystemClock.uptimeMillis();
      if (l < paramLong) {
        sHandler.postDelayed(this, paramLong - l);
      }
      for (;;)
      {
        if ((this.apngLoop <= 0) || (this.mFrameCount != this.mImageInfo[3] + 1)) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApngImage", 2, "apng mFrameCount:" + this.mFrameCount + ", current:" + this.mImageInfo[3]);
        }
        this.currentApngLoop += 1;
        if (this.currentApngLoop < this.apngLoop) {
          return;
        }
        synchronized (this.mListener)
        {
          int i = this.mListener.size() - 1;
          for (;;)
          {
            if (i >= 0)
            {
              ApngDrawable.OnPlayRepeatListener localOnPlayRepeatListener = (ApngDrawable.OnPlayRepeatListener)((WeakReference)this.mListener.get(i)).get();
              if (localOnPlayRepeatListener != null)
              {
                localOnPlayRepeatListener.onPlayRepeat(this.currentApngLoop);
                i -= 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("ApngImage", 2, "post task overtime: " + (l - paramLong));
                }
                sHandler.post(this);
                break;
              }
              this.mListener.remove(i);
            }
          }
        }
      }
    }
  }
  
  public void reDraw()
  {
    invalidateSelf();
    this.mIsInPendingAction = false;
  }
  
  public void removeCallBack(AnimationCallback paramAnimationCallback)
  {
    localCopyOnWriteArrayList = this.callbacks;
    int i = 0;
    Object localObject;
    for (;;)
    {
      int j;
      try
      {
        if (i < this.callbacks.size())
        {
          localObject = (WeakReference)this.callbacks.get(i);
          if ((localObject == null) || (((WeakReference)localObject).get() == null))
          {
            localObject = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally {}
      try
      {
        ((CopyOnWriteArrayList)localObject).remove(i);
        i = j;
      }
      finally
      {
        continue;
        continue;
      }
      i += 1;
    }
    if (((WeakReference)localObject).get() == paramAnimationCallback)
    {
      paramAnimationCallback = this.callbacks;
      paramAnimationCallback.remove(i);
      return;
      return;
    }
  }
  
  public void removeOnPlayRepeatListener(ApngDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    if (paramOnPlayRepeatListener != null) {
      for (;;)
      {
        int i;
        synchronized (this.mListener)
        {
          i = this.mListener.size() - 1;
          if (i >= 0)
          {
            if (((WeakReference)this.mListener.get(i)).get() == paramOnPlayRepeatListener) {
              this.mListener.remove(i);
            }
          }
          else {
            return;
          }
        }
        i -= 1;
      }
    }
  }
  
  public void replay()
  {
    this.currentApngLoop = 0;
    reDraw();
  }
  
  public void run()
  {
    sAccumulativeRunnable.add(new WeakReference[] { new WeakReference(this) });
  }
  
  public void setDensity(int paramInt)
  {
    this.mDensity = paramInt;
  }
  
  public void setOnPlayRepeatListener(ApngDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    ArrayList localArrayList;
    int k;
    int i;
    if (paramOnPlayRepeatListener != null)
    {
      localArrayList = this.mListener;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      int j = k;
      try
      {
        if (i < this.mListener.size())
        {
          if (((WeakReference)this.mListener.get(i)).get() != paramOnPlayRepeatListener) {
            break label83;
          }
          j = 1;
        }
        if (j == 0) {
          this.mListener.add(new WeakReference(paramOnPlayRepeatListener));
        }
        return;
      }
      finally {}
      return;
      label83:
      i += 1;
    }
  }
  
  class DecodeNextFrameAsyncTask
    extends AsyncTask<Void, Void, Object>
  {
    long nextFrameDrawingTime;
    
    public DecodeNextFrameAsyncTask(long paramLong)
    {
      this.nextFrameDrawingTime = paramLong;
    }
    
    protected Object doInBackground(Void... paramVarArgs)
    {
      try
      {
        boolean bool = ApngImage.this.getNextFrame();
        ApngImage.this.onDecodeNextFrameSuccessed(bool, this.nextFrameDrawingTime);
        return null;
      }
      catch (Throwable paramVarArgs) {}
      return paramVarArgs;
    }
    
    protected void onCancelled()
    {
      ApngImage.this.onDecodeNextFrameCanceled();
    }
    
    protected void onPostExecute(Object paramObject)
    {
      if ((paramObject instanceof Throwable)) {
        ApngImage.this.onDecodeNextFrameFailed((Throwable)paramObject);
      }
    }
  }
  
  private class DoAccumulativeRunnable
    extends ArgumentsRunnable<WeakReference<ApngImage>>
  {
    private long lastRefreshTime = 0L;
    
    private DoAccumulativeRunnable() {}
    
    protected void run(List<WeakReference<ApngImage>> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (WeakReference)paramList.next();
        if (localObject != null)
        {
          localObject = (ApngImage)((WeakReference)localObject).get();
          if (localObject != null) {
            ((ApngImage)localObject).doApplyNextFrame();
          }
        }
      }
      this.lastRefreshTime = SystemClock.uptimeMillis();
    }
    
    protected void submit()
    {
      long l = SystemClock.uptimeMillis();
      if ((this.lastRefreshTime == 0L) || (l - this.lastRefreshTime > 25L))
      {
        run();
        this.lastRefreshTime = l;
        return;
      }
      ApngImage.sHandler.postDelayed(this, 25L - (l - this.lastRefreshTime));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.ApngImage
 * JD-Core Version:    0.7.0.1
 */