package com.tencent.biz.qqstory.view.asyncImageLoader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.TaskQueue;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class ImageLoader
  implements Handler.Callback, Task.TaskStateListener
{
  private int jdField_a_of_type_Int = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private TaskQueue jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue;
  private WeakHashMap jdField_a_of_type_JavaUtilWeakHashMap;
  private boolean jdField_a_of_type_Boolean;
  private Handler b;
  
  public ImageLoader()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue = new TaskQueue();
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  public ImageLoader(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ImageLoader_" + paramString);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue = new TaskQueue();
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  private void a(int paramInt, Task paramTask)
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageAtFrontOfQueue(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramTask));
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramTask));
  }
  
  public abstract LruCache a();
  
  public abstract Task a(ImageView paramImageView, Object paramObject);
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(ImageView paramImageView)
  {
    Task localTask = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a(paramImageView);
    this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (localTask != null)
    {
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "ImageView have been set,cancal task for this:", Integer.valueOf(paramImageView.hashCode()), " source:", localTask.jdField_a_of_type_JavaLangObject });
      localTask.b();
    }
  }
  
  public void a(ImageView paramImageView, Object paramObject)
  {
    a(paramImageView, paramObject, new ColorDrawable(-3289651), 0);
  }
  
  public void a(ImageView paramImageView, Object paramObject, Drawable paramDrawable, int paramInt)
  {
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "attachView:", paramObject, " ----hash:", Integer.valueOf(paramImageView.hashCode()) });
    this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (paramObject.toString().equals(paramImageView.getTag(2131362363))) {
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "target have been set view,so dont need attach view" });
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.b(paramImageView);
      if (localObject != null)
      {
        if (paramObject.equals(((Task)localObject).jdField_a_of_type_JavaLangObject))
        {
          InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "task running no need to do again:", ((Task)localObject).jdField_a_of_type_JavaLangObject });
          return;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a(paramImageView);
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "cancel: ", ((Task)localObject).jdField_a_of_type_JavaLangObject });
        ((Task)localObject).b();
      }
      localObject = (Drawable)a().get(paramObject);
      if (localObject != null)
      {
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "hit the cache:", paramObject });
        if ((localObject instanceof BitmapDrawable))
        {
          Bitmap localBitmap = ((BitmapDrawable)localObject).getBitmap();
          if (localBitmap != null) {
            InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(localBitmap.getRowBytes() * localBitmap.getHeight()), ",h=", Integer.valueOf(localBitmap.getHeight()), ",w=", Integer.valueOf(localBitmap.getWidth()), ",key=", paramObject });
          }
        }
        while ((this.jdField_a_of_type_Boolean) && (paramInt == 0))
        {
          InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "save to waiting queue:", paramObject });
          paramImageView.setImageDrawable(paramDrawable);
          InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def o= ", paramImageView.getTag(2131362363), " and change to: ", paramObject.toString(), " view hash:" + paramImageView.hashCode() });
          paramImageView.setTag(2131362363, null);
          this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, localObject);
          return;
          InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(1024), ",key= ", paramObject });
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI cache o= ", paramImageView.getTag(2131362363), " and change to: ", paramObject.toString(), " view hash:" + paramImageView.hashCode() });
        paramImageView.setTag(2131362363, paramObject.toString());
        return;
      }
      paramImageView.setImageDrawable(paramDrawable);
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def 2 o= ", paramImageView.getTag(2131362363), " and change to: ", paramObject.toString(), " view hash:" + paramImageView.hashCode() });
      paramImageView.setTag(2131362363, null);
      localObject = a(paramImageView, paramObject);
      if (localObject == null)
      {
        InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "generateTask failed!!" });
        return;
      }
      ((Task)localObject).jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderImageLoader = this;
      ((Task)localObject).b = paramDrawable;
      ((Task)localObject).jdField_a_of_type_Int = paramInt;
      ((Task)localObject).a(this);
      ((Task)localObject).jdField_a_of_type_JavaLangObject = paramObject;
      InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "this need request hash:", Integer.valueOf(paramImageView.hashCode()) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a(paramImageView, (Task)localObject);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a((Task)localObject);
    a(1, (Task)localObject);
  }
  
  public void a(Task paramTask)
  {
    this.b.sendMessage(this.b.obtainMessage(3, paramTask));
  }
  
  public void a(Task paramTask, String paramString)
  {
    InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:,case:", paramTask.a(), paramString });
    this.b.sendMessage(this.b.obtainMessage(2, paramTask));
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "pause ui task" });
    this.b.removeMessages(4);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "resume ui task" });
    this.b.removeMessages(4);
    if (this.jdField_a_of_type_JavaUtilWeakHashMap.size() > 0) {
      this.b.sendMessage(this.b.obtainMessage(4));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a() > 0)
    {
      ListIterator localListIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a();
      int i = 2;
      if ((localListIterator.hasPrevious()) && (i > 0))
      {
        Map.Entry localEntry = (Map.Entry)localListIterator.previous();
        localListIterator.remove();
        if (((WeakReference)localEntry.getValue()).get() != null) {
          this.b.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localEntry.getKey()));
        }
        for (;;)
        {
          i -= 1;
          break;
          ((Task)localEntry.getKey()).b();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    do
    {
      do
      {
        return true;
        paramMessage = (Task)paramMessage.obj;
        if (!paramMessage.a())
        {
          paramMessage.a();
          return true;
        }
        InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "子线程里执行取消:", paramMessage.a() });
        paramMessage.c();
        return true;
        paramMessage = (Task)paramMessage.obj;
        InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED:", paramMessage.a() });
        if (!paramMessage.a())
        {
          InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED post ui:", paramMessage.a() });
          paramMessage.a(this.jdField_a_of_type_JavaUtilWeakHashMap, this.jdField_a_of_type_Boolean);
          localObject = (ImageView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null)
          {
            InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "completed the request,hash: ", Integer.valueOf(localObject.hashCode()) });
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a((ImageView)localObject);
          }
          if (paramMessage.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            a().put(paramMessage.jdField_a_of_type_JavaLangObject, paramMessage.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
        }
        for (;;)
        {
          paramMessage.c();
          if (this.jdField_a_of_type_Boolean) {
            break;
          }
          this.b.sendMessage(this.b.obtainMessage(5));
          return true;
          InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED have been cancel:", paramMessage.a() });
        }
        paramMessage = (Task)paramMessage.obj;
        InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:", paramMessage.a() });
        localObject = (ImageView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a((ImageView)localObject);
          ((ImageView)localObject).setImageDrawable(paramMessage.b);
          InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", ((ImageView)localObject).getTag(2131362363), " and change to: default", " view hash:" + localObject.hashCode() });
          ((ImageView)localObject).setTag(2131362363, null);
        }
        paramMessage.c();
        return true;
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "HANDLE_WAITING_UI_TASK" });
      } while (this.jdField_a_of_type_Boolean);
      paramMessage = this.jdField_a_of_type_JavaUtilWeakHashMap.entrySet().iterator();
      i = 3;
      for (;;)
      {
        if (paramMessage.hasNext())
        {
          localObject = (Map.Entry)paramMessage.next();
          ImageView localImageView = (ImageView)((Map.Entry)localObject).getKey();
          if (localImageView != null)
          {
            localImageView.setImageDrawable((Drawable)((Map.Entry)localObject).getValue());
            InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localImageView.getTag(2131362363), " and change to: wait", " view hash:" + localImageView.hashCode() });
            localImageView.setTag(2131362363, null);
            paramMessage.remove();
          }
          i -= 1;
          if (i > 0) {}
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilWeakHashMap.size() <= 0) {
            break;
          }
          this.b.sendMessageDelayed(this.b.obtainMessage(4), 16L);
          return true;
        }
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a() <= 0);
    paramMessage = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a();
    int i = 2;
    label637:
    if ((paramMessage.hasPrevious()) && (i > 0))
    {
      localObject = (Map.Entry)paramMessage.previous();
      paramMessage.remove();
      if (((WeakReference)((Map.Entry)localObject).getValue()).get() == null) {
        break label710;
      }
      this.b.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, ((Map.Entry)localObject).getKey()));
    }
    for (;;)
    {
      i -= 1;
      break label637;
      break;
      label710:
      ((Task)((Map.Entry)localObject).getKey()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.asyncImageLoader.ImageLoader
 * JD-Core Version:    0.7.0.1
 */