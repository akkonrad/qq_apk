package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class QzoneVipPaymentJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private String a;
  
  private int a(int paramInt)
  {
    WebUiBaseInterface localWebUiBaseInterface = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
    int i = paramInt;
    if ((localWebUiBaseInterface instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)localWebUiBaseInterface).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, (byte)paramInt);
    }
    return i;
  }
  
  private String a(String paramString1, String paramString2)
  {
    return "qq_m_qq" + "-" + "2013" + "-" + paramString1.replaceAll("-", "_") + "-" + "2013" + "-" + paramString2.replaceAll("-", "_");
  }
  
  private void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2, int paramInt3, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      paramString = paramIntent;
      if (paramIntent == null) {
        paramString = new Intent();
      }
      paramString.putExtra("key_qzone_vip_open_back_need_check_vipinfo", false);
      paramActivity.setResult(0, paramString);
      paramActivity.finish();
    case 0: 
      return;
    case -5: 
      paramActivity.finish();
      return;
    }
    paramActivity.setResult(0, paramIntent);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        paramString1 = new JSONObject(paramString1);
        a(paramString1.optString("openUin"), paramString1.optString("openMonth"), paramString1.optString("openVipType"), paramString1.getBoolean("isAuto"), paramString1.optString("aid"));
        this.jdField_a_of_type_JavaLangString = paramString2;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null) {
          continue;
        }
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
        paramString2 = new QZoneClickReport.ReportInfo();
        paramString2.a("328");
        paramString2.a(Long.parseLong(paramString1));
        paramString2.b("10");
        paramString2.c("1");
        QZoneClickReport.startReportImediately(paramString1, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((localObject2 == null) || (((Activity)localObject2).isFinishing())) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    } while (localAppInterface == null);
    Intent localIntent = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
    String str2 = VipUtils.a(paramString4);
    String str1 = ((Activity)localObject2).getString(2131432640);
    String str3 = ((Activity)localObject2).getString(2131432642);
    paramString4 = "";
    Object localObject1 = "";
    if ("1".equals(paramString3))
    {
      paramString4 = "xxjzgw";
      str1 = ((Activity)localObject2).getString(2131432640);
      localObject1 = "1450000153";
    }
    for (;;)
    {
      try
      {
        paramString3 = new JSONObject();
        paramString3.put("offerId", localObject1);
        localObject1 = (TicketManager)localAppInterface.getManager(2);
        localObject2 = localAppInterface.getAccount();
        paramString3.put("userId", localObject2);
        paramString3.put("skey", ((TicketManager)localObject1).getSkey((String)localObject2));
        paramString3.put("serviceCode", paramString4);
        paramString3.put("serviceName", str1);
        paramString3.put("channel", "");
        paramString3.put("uint", str3);
        paramString3.put("openMonth", paramString2);
        paramString3.put("isCanChange", false);
        paramString3.put("autoPay", paramBoolean);
        paramString3.put("aid", str2);
        paramString3.put("pf", a(QUA.a(), str2));
        if ((!paramString1.equals(localAppInterface.getCurrentAccountUin())) && (!paramString1.equals("0")))
        {
          paramString3.put("provideUin", paramString1);
          paramString3.put("provideType", "uin");
        }
        paramString3.put("discountId", "");
        paramString3.put("other", "");
        paramString1 = new Bundle();
        paramString1.putInt("pay_requestcode", 4);
        paramString1.putString("json", paramString3.toString());
        localIntent.putExtras(paramString1);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.startActivityForResult(localIntent, (byte)16);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if ("2".equals(paramString3))
      {
        paramString4 = "XXJZGHH";
        str1 = ((Activity)localObject2).getString(2131432641);
        localObject1 = "1450001557";
      }
    }
  }
  
  private void b()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    localActivity.finish();
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      break label32;
    }
    label32:
    while (paramByte != 16) {
      return;
    }
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getExtras();
      if (localObject != null)
      {
        localActivity.setResult(paramInt, paramIntent);
        localObject = ((Bundle)localObject).getString("result");
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        paramInt = localJSONObject.getInt("resultCode");
        String str = localJSONObject.getString("resultMsg");
        int i = localJSONObject.getInt("payState");
        int j = localJSONObject.getInt("provideState");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localObject });
        }
        a(localActivity, paramInt, str, i, j, paramIntent);
        paramInt = 0;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        paramInt = 1;
        continue;
      }
      if (paramInt == 0) {
        break;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("key_qzone_vip_open_back_need_check_vipinfo", false);
      localActivity.setResult(0, paramIntent);
      localActivity.finish();
      return;
      paramInt = 1;
      continue;
      paramInt = 1;
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              if ((paramString3.equals("payVipDirectly")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
                try
                {
                  paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                  a(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
                  return true;
                }
                catch (Exception paramJsBridgeListener)
                {
                  paramJsBridgeListener.printStackTrace();
                  return true;
                }
              }
              if (paramString3.equals("closePayDialog"))
              {
                b();
                return true;
              }
              if (!paramString3.equals("SetNaviDeco")) {
                break;
              }
              bool1 = bool2;
            } while (paramVarArgs == null);
            bool1 = bool2;
          } while (TextUtils.isEmpty(paramVarArgs[0]));
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 7);
          paramJsBridgeListener.putExtra("navi_deco", paramVarArgs[0]);
          bool1 = bool2;
        } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null);
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null);
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null);
    QzonePluginProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount(), paramJsBridgeListener, a(9));
    return true;
    return false;
  }
  
  public boolean a(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934595L) && (paramMap != null))
    {
      ((Integer)paramMap.get("errorCode")).intValue();
      if (QLog.isColorLevel()) {
        QLog.e("QzoneVipPaymentJsPlugin", 2, "VasWebReport:EVENT_LOAD_ERROR");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin
 * JD-Core Version:    0.7.0.1
 */