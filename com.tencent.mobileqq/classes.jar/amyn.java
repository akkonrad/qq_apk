import android.os.Bundle;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

public class amyn
  implements Runnable
{
  public amyn(RemoteRequestSender paramRemoteRequestSender, Bundle paramBundle) {}
  
  public void run()
  {
    RemoteRequestSender.a(this.jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender).a("cmd.gdtreport.webview", this.jdField_a_of_type_AndroidOsBundle, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyn
 * JD-Core Version:    0.7.0.1
 */