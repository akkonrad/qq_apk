package dov.com.qq.im.capture.music;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

public abstract class MusicDownloadListener
  extends DownloadListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    super.onCancel(paramDownloadTask);
    a(paramDownloadTask.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.jdField_a_of_type_JavaLangString;
    if (paramDownloadTask.a() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool, paramDownloadTask.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    a(2);
  }
  
  public void onNetWifi2Mobile()
  {
    super.onNetWifi2Mobile();
    a(1);
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    a(3);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
    int i = (int)paramDownloadTask.jdField_a_of_type_Float;
    a(paramDownloadTask.jdField_a_of_type_JavaLangString, i);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    super.onStart(paramDownloadTask);
    a(paramDownloadTask.jdField_a_of_type_JavaLangString, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.MusicDownloadListener
 * JD-Core Version:    0.7.0.1
 */