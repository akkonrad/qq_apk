import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.util.BinderWarpper;
import dov.com.tencent.mobileqq.richmedia.ICallBack;
import dov.com.tencent.mobileqq.richmedia.LOG;
import dov.com.tencent.mobileqq.richmedia.RichmediaClient;

public class aoku
  implements ServiceConnection
{
  public aoku(RichmediaClient paramRichmediaClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LOG.a("PTV.RichmediaClient", "onServiceConnected");
    this.a.b = new Messenger(paramIBinder);
    paramComponentName = Message.obtain(null, 1);
    paramComponentName.replyTo = this.a.jdField_a_of_type_AndroidOsMessenger;
    paramIBinder = new BinderWarpper(this.a.jdField_a_of_type_DovComTencentMobileqqRichmediaICallBack.asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ICallBack_BinderWrapper", paramIBinder);
    paramComponentName.setData(localBundle);
    try
    {
      this.a.b.send(paramComponentName);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      LOG.b("PTV.RichmediaClient", "MSG_C2S_REGISTER_CLIENT send failed. e = " + paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoku
 * JD-Core Version:    0.7.0.1
 */