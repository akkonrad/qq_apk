package cooperation.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;

public class TroopManageCmd
  extends RemoteCommand
{
  private QQAppInterface a;
  
  public TroopManageCmd(QQAppInterface paramQQAppInterface)
  {
    super("troop.manage.get_app_interface_data");
    this.a = paramQQAppInterface;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_rsp_upgrade_troop_url", IndividuationUrlHelper.a("vipUpGroupLimit"));
    return localBundle;
  }
  
  protected Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param_rsp_troop_owmer_field", ((TroopGagMgr)this.a.getManager(47)).a(paramBundle.getString("req_troop_uin")));
    return localBundle;
  }
  
  protected Bundle a(Bundle paramBundle, int paramInt)
  {
    String str = null;
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    if (paramInt == 5) {
      str = ContactUtils.g(this.a, paramBundle.getString("req_troop_uin"), paramBundle.getString("memUin"));
    }
    for (;;)
    {
      localBundle.putString("param_rsp_nick", str);
      return localBundle;
      if (paramInt == 6) {
        str = ContactUtils.j(this.a, paramBundle.getString("memUin"));
      }
    }
  }
  
  protected Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle = new Bundle();
    paramBundle.putInt("rep_unique_title_flag", ((TroopManager)this.a.getManager(51)).a());
    return paramBundle;
  }
  
  protected Bundle c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("set_unique_title_flag");
    paramBundle = new Bundle();
    ((TroopManager)this.a.getManager(51)).a(i);
    return paramBundle;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if ((paramBundle == null) || (this.a == null)) {
      return null;
    }
    try
    {
      paramOnInvokeFinishLinstener = new Bundle();
      i = paramBundle.getInt("req_sub_cmd", 0);
      switch (i)
      {
      case 1: 
        paramBundle = b(paramBundle);
      }
    }
    catch (Exception paramBundle)
    {
      int i;
      if (!QLog.isColorLevel()) {
        break label198;
      }
      QLog.d("TroopManageCmd", 2, "invoke Exception hanppend! ExceptionClass = + " + paramBundle.getClass().getName() + "msg = " + paramBundle.getMessage());
      ReportController.b(this.a, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "plugin_cmd_exp", 0, 0, paramBundle.getClass().getName(), null, null, null);
      return null;
    }
    return a(paramBundle, i);
    return c(paramBundle);
    return a(paramBundle);
    paramBundle = (TroopInfo)paramBundle.getSerializable("troopInfo");
    ((TroopManager)this.a.getManager(51)).b(paramBundle);
    return paramOnInvokeFinishLinstener;
    return a();
    label198:
    paramBundle = paramOnInvokeFinishLinstener;
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop.TroopManageCmd
 * JD-Core Version:    0.7.0.1
 */