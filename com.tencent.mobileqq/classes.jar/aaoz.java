import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class aaoz
  implements INetInfoHandler
{
  public aaoz(ArkAppEventObserverManager paramArkAppEventObserverManager) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2None mLastNetType=" + ArkAppEventObserverManager.a(this.a));
    }
    ArkAppCenter.a().post(new aapf(this));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2Wifi mLastNetType=" + ArkAppEventObserverManager.a(this.a));
    }
    ArkAppCenter.a().post(new aape(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Mobile mLastNetType=" + ArkAppEventObserverManager.a(this.a));
    }
    ArkAppCenter.a().post(new aapd(this));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Wifi mLastNetType=" + ArkAppEventObserverManager.a(this.a));
    }
    ArkAppCenter.a().post(new aapc(this));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2Mobile mLastNetType=" + ArkAppEventObserverManager.a(this.a));
    }
    ArkAppCenter.a().post(new aapb(this));
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2None mLastNetType=" + ArkAppEventObserverManager.a(this.a));
    }
    ArkAppCenter.a().post(new aapa(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaoz
 * JD-Core Version:    0.7.0.1
 */