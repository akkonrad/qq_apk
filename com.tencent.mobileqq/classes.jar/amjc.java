import android.os.Bundle;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.buscard.BuscardPluginRemoteCommand;

public class amjc
  extends SosoInterface.OnLocationListener
{
  public amjc(BuscardPluginRemoteCommand paramBuscardPluginRemoteCommand, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      String str = paramSosoLbsInfo.a.d;
      paramSosoLbsInfo = paramSosoLbsInfo.a.e;
      this.jdField_a_of_type_AndroidOsBundle.putString("province", str);
      this.jdField_a_of_type_AndroidOsBundle.putString("city", paramSosoLbsInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener != null) {
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener.onInvokeFinish(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjc
 * JD-Core Version:    0.7.0.1
 */