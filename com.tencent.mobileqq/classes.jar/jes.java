import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.GMemoryMonitor;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class jes
  implements ComponentCallbacks2
{
  public jes(GMemoryMonitor paramGMemoryMonitor) {}
  
  private void a(int paramInt)
  {
    VideoController localVideoController = this.a.a.a();
    if (localVideoController != null) {
      localVideoController.a("lowMemoryLevel", String.valueOf(paramInt));
    }
    try
    {
      ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      localVideoController = localVideoController.a("availMem", String.valueOf(localMemoryInfo.availMem / 1048576L)).a("threshold", String.valueOf(localMemoryInfo.threshold / 1048576L));
      if (localMemoryInfo.lowMemory) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localVideoController.a("lowMemory", String.valueOf(paramInt));
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AVLog.e("GMemoryMonitor", localThrowable.getMessage());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GMemoryMonitor", 2, "onConfigurationChanged called");
    }
  }
  
  public void onLowMemory()
  {
    QLog.d("GMemoryMonitor", 1, "onLowMemory called");
    this.a.a(-10, this.a.a.e);
    a(-10);
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt >= 15) {
      VideoNodeManager.a(41, paramInt);
    }
    if (paramInt == 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GMemoryMonitor", 2, "onTrimMemory called ,level = " + paramInt);
      }
      this.a.a(paramInt, this.a.a.e);
      ((VideoNodeReporter)this.a.a.a(4)).a(27, paramInt);
      a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jes
 * JD-Core Version:    0.7.0.1
 */