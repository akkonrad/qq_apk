package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.ShieldFriendStoryEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.RegionDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class StoryListUtils
{
  public static String a;
  public static final int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 120, 200, 320, 512, 640, 750, 1000 };
    jdField_a_of_type_JavaLangString = Integer.toString(jdField_a_of_type_ArrayOfInt[0]);
  }
  
  public static float a(long paramLong)
  {
    return (float)(NetConnInfoCenter.getServerTimeMillis() - paramLong) / 3600000.0F;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 5;
    case 0: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
      return 1;
    case 3: 
    case 6: 
      return 2;
    }
    return 3;
  }
  
  public static int a(View paramView)
  {
    if ((paramView == null) || (!paramView.isShown())) {}
    int[] arrayOfInt;
    int j;
    do
    {
      return 2147483647;
      arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      i = paramView.getHeight();
      j = UIUtils.b(paramView.getContext()) / 2;
    } while (i <= 0);
    int i = Math.min(Math.abs(j - arrayOfInt[1]), Math.abs(j - (arrayOfInt[1] + i)));
    SLog.b("Q.qqstory.home.StoryListUtils", "getDistanceToCenterY=" + i);
    return i;
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2, Map paramMap, Transformation paramTransformation)
  {
    long l = System.currentTimeMillis();
    if (paramDrawable == null)
    {
      paramDrawable = null;
      return paramDrawable;
    }
    Object localObject;
    float f2;
    float f1;
    if ((paramDrawable instanceof RegionDrawable))
    {
      localObject = (RegionDrawable)paramDrawable;
      if ((((RegionDrawable)localObject).getBitmap() != null) && (!((RegionDrawable)localObject).getBitmap().isRecycled()))
      {
        f2 = ((RegionDrawable)localObject).getBitmap().getWidth();
        f1 = ((RegionDrawable)localObject).getBitmap().getHeight();
        label67:
        if ((paramInt1 > 0) && (paramInt2 > 0)) {
          break label347;
        }
        paramInt1 = (int)f2;
        paramInt2 = (int)f1;
        label83:
        if (paramMap == null) {
          break label414;
        }
      }
    }
    label414:
    for (Bitmap localBitmap = (Bitmap)paramMap.get("w=" + paramInt1 + "h=" + paramInt2);; localBitmap = null)
    {
      for (;;)
      {
        if (localBitmap != null) {
          localObject = localBitmap;
        }
        try
        {
          if (localBitmap.isRecycled())
          {
            InfoPrinter.b("Q.qqstory.home.StoryListUtils", new Object[] { "drawable2Bitmap need create width=", Integer.valueOf(paramInt1), ",height=", Integer.valueOf(paramInt2) });
            localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
            localObject = localBitmap;
            if (paramMap != null)
            {
              paramMap.put("w=" + paramInt1 + "h=" + paramInt2, localBitmap);
              localObject = localBitmap;
            }
          }
          if (localObject != null)
          {
            ((Bitmap)localObject).eraseColor(0);
            paramMap = new Canvas((Bitmap)localObject);
            paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
            paramDrawable.draw(paramMap);
          }
          SLog.a("Q.qqstory.home.StoryListUtils", "drawable2Bitmap:width=%d,height=%d,cost time=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis() - l));
          paramDrawable = (Drawable)localObject;
          if (paramTransformation == null) {
            break;
          }
          return paramTransformation.a((Bitmap)localObject);
        }
        catch (OutOfMemoryError paramDrawable)
        {
          label347:
          SLog.e("Q.qqstory.home.StoryListUtils", "drawable2Bitmap out off memory width=" + paramInt1 + ",height=" + paramInt2);
          return null;
        }
      }
      f2 = ((RegionDrawable)localObject).getIntrinsicWidth();
      f1 = ((RegionDrawable)localObject).getIntrinsicHeight();
      break label67;
      f2 = paramDrawable.getIntrinsicWidth();
      f1 = paramDrawable.getIntrinsicHeight();
      break label67;
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(f2 / f1 * paramInt2);
        break label83;
      }
      paramInt2 = (int)(f1 / f2 * paramInt1);
      break label83;
    }
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "未知时区";
      }
      break;
    }
    do
    {
      return localObject2;
      localObject1 = "东西十二区";
      break;
      localObject1 = "西十一区";
      break;
      localObject1 = "西十区";
      break;
      localObject1 = "西九区";
      break;
      localObject1 = "西八区";
      break;
      localObject1 = "西七区";
      break;
      localObject1 = "西六区";
      break;
      localObject1 = "西五区";
      break;
      localObject1 = "西四区";
      break;
      localObject1 = "西三区";
      break;
      localObject1 = "西二区";
      break;
      localObject1 = "西一区";
      break;
      localObject1 = "零时区";
      break;
      localObject1 = "东一区";
      break;
      localObject1 = "东二区";
      break;
      localObject1 = "东三区";
      break;
      localObject1 = "东四区";
      break;
      localObject1 = "东五区";
      break;
      localObject1 = "东六区";
      break;
      localObject1 = "东七区";
      break;
      localObject1 = "东八区";
      break;
      localObject1 = "东九区";
      break;
      localObject1 = "东十区";
      break;
      localObject1 = "东十一区";
      break;
      localObject1 = "东西十二区";
      break;
      localObject1 = "西十一区";
      break;
      localObject2 = localObject1;
    } while (!paramBoolean);
    return "时区·" + (String)localObject1;
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, TimeZone.getDefault().getRawOffset(), false);
  }
  
  public static String a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramLong1 == -1L) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramBoolean) && (TimeZone.getDefault().getRawOffset() / 3600000 != (int)(paramLong2 / 3600000L))) {
      localStringBuilder.append("当地 ");
    }
    Calendar localCalendar = Calendar.getInstance();
    long l = NetConnInfoCenter.getServerTimeMillis();
    if ((l - paramLong1) / 1000L < 60L) {
      localStringBuilder.append("刚刚");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localCalendar.setTimeInMillis(l);
      int i = localCalendar.get(1);
      int j = localCalendar.get(6);
      localCalendar.setTimeInMillis(paramLong1);
      int k = localCalendar.get(1);
      int m = localCalendar.get(6);
      localCalendar.add(6, 1);
      int n = localCalendar.get(6);
      if (paramBoolean)
      {
        TimeZone localTimeZone = TimeZone.getDefault();
        localTimeZone.setRawOffset((int)paramLong2);
        localCalendar.setTimeZone(localTimeZone);
      }
      localCalendar.setTimeInMillis(paramLong1);
      int i1 = localCalendar.get(1);
      int i2 = localCalendar.get(2) + 1;
      int i3 = localCalendar.get(5);
      int i4 = localCalendar.get(11);
      int i5 = localCalendar.get(12);
      if (m == j) {
        localStringBuilder.append(String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Integer.valueOf(i4), Integer.valueOf(i5) }));
      } else if (n == j) {
        localStringBuilder.append("昨天 ").append(String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Integer.valueOf(i4), Integer.valueOf(i5) }));
      } else if (k == i) {
        localStringBuilder.append(String.format(Locale.getDefault(), "%d月%d日 %02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5) }));
      } else {
        localStringBuilder.append(String.format(Locale.getDefault(), "%d年%d月%d日", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) }));
      }
    }
  }
  
  public static void a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, boolean paramBoolean)
  {
    if (paramInt1 + paramInt3 > paramBitmap1.getWidth()) {
      throw new IllegalArgumentException("x + width must be <= bitmap.width()");
    }
    if (paramInt2 + paramInt4 > paramBitmap1.getHeight()) {
      throw new IllegalArgumentException("y + height must be <= bitmap.height()");
    }
    if ((!paramBitmap1.isMutable()) && (paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == paramBitmap1.getWidth()) && (paramInt4 == paramBitmap1.getHeight()) && ((paramMatrix == null) || (paramMatrix.isIdentity()))) {
      return;
    }
    Canvas localCanvas = new Canvas();
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    RectF localRectF1 = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      paramMatrix = null;
      localCanvas.setBitmap(paramBitmap2);
      localCanvas.drawBitmap(paramBitmap1, localRect, localRectF1, paramMatrix);
      localCanvas.setBitmap(null);
      return;
    }
    if (!paramMatrix.rectStaysRect()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      RectF localRectF2 = new RectF();
      paramMatrix.mapRect(localRectF2, localRectF1);
      localCanvas.translate(-localRectF2.left, -localRectF2.top);
      localCanvas.concat(paramMatrix);
      paramMatrix = new Paint();
      paramMatrix.setFilterBitmap(paramBoolean);
      if (paramInt1 != 0) {
        paramMatrix.setAntiAlias(true);
      }
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((QQStoryManager)paramQQAppInterface.getManager(180)).a(false);
    paramQQAppInterface = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QQStoryUserInfo localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
      if (localQQStoryUserInfo != null) {
        paramQQAppInterface.add(localQQStoryUserInfo.uin);
      }
    }
    a(paramQQAppInterface);
  }
  
  public static void a(String paramString)
  {
    SLog.b("Q.qqstory.home.StoryListUtils", "reportLiveVideoHaveRead uid=" + paramString);
    new WatchVideoHandler().a("0", paramString, 100, true, -1L);
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    SLog.b("Q.qqstory.home.StoryListUtils", "reportShieldFriendStory:" + paramArrayList.size());
    ShieldFriendStoryEvent localShieldFriendStoryEvent = new ShieldFriendStoryEvent();
    localShieldFriendStoryEvent.a = paramArrayList;
    Dispatchers.get().dispatch(localShieldFriendStoryEvent);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str;
    if (paramString.startsWith("file://")) {
      str = paramString.replaceFirst("file://", "");
    }
    for (;;)
    {
      return new File(str).exists();
      str = paramString;
      if (paramString.startsWith("file:")) {
        str = paramString.replaceFirst("file:", "");
      }
    }
  }
  
  public static int b(View paramView)
  {
    if ((paramView == null) || (!paramView.isShown())) {}
    int[] arrayOfInt;
    do
    {
      return 2147483647;
      arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      i = paramView.getHeight();
    } while (i <= 0);
    int i = Math.min(Math.abs(0 - arrayOfInt[1]), Math.abs(0 - (arrayOfInt[1] + i)));
    SLog.b("Q.qqstory.home.StoryListUtils", "getDistanceToTop=" + i);
    return i;
  }
  
  public static String b(long paramLong)
  {
    if (paramLong == -1L) {
      return "(Unknown Time)";
    }
    Calendar localCalendar = Calendar.getInstance();
    long l = NetConnInfoCenter.getServerTimeMillis();
    if ((l - paramLong) / 1000L < 60L) {
      return "刚刚";
    }
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2) + 1;
    int k = localCalendar.get(5);
    int m = localCalendar.get(6);
    int n = localCalendar.get(11);
    int i1 = localCalendar.get(12);
    localCalendar.setTimeInMillis(l);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(6);
    if (m == i3) {
      return String.format(Locale.getDefault(), "今天 %02d:%02d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
    }
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.add(6, 1);
    if (localCalendar.get(6) == i3) {
      return String.format(Locale.getDefault(), "昨天 %02d:%02d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
    }
    if (i != i2) {
      return String.format(Locale.getDefault(), "%d年%d月%d日", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    }
    return String.format(Locale.getDefault(), "%d月%d日 %02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(i1) });
  }
  
  public static int c(View paramView)
  {
    if ((paramView == null) || (!paramView.isShown())) {}
    int[] arrayOfInt;
    int j;
    do
    {
      return 2147483647;
      arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      i = paramView.getHeight();
      j = UIUtils.b(paramView.getContext());
    } while (i <= 0);
    int i = Math.min(Math.abs(j - arrayOfInt[1]), Math.abs(j - (arrayOfInt[1] + i)));
    SLog.b("Q.qqstory.home.StoryListUtils", "getDistanceToBottom=" + i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils
 * JD-Core Version:    0.7.0.1
 */