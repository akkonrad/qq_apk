import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.confess.ConfessShareHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;

public class abse
  implements Runnable
{
  public abse(ConfessPlugin paramConfessPlugin, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, String paramString4, String paramString5, String paramString6, int paramInt4, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin.mRuntime.a();
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin.mRuntime.a();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("activity=").append(localObject3).append("  app=").append(localObject4).append(" finishing?");
      if ((localObject3 == null) || (!((Activity)localObject3).isFinishing())) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ConfessPlugin", 2, bool);
      if ((localObject3 != null) && (localObject4 != null) && (!((Activity)localObject3).isFinishing())) {
        break;
      }
      ConfessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin);
      ConfessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin, false);
      return;
    }
    Bitmap localBitmap = ConfessShareHelper.a((AppInterface)localObject4, (Context)localObject3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONArray, this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin.a);
    if ((this.jdField_b_of_type_Int == 0) && (localBitmap != null)) {}
    for (Object localObject2 = ConfessShareHelper.b((AppInterface)localObject4, (Context)localObject3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONArray, this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin.a);; localObject2 = null)
    {
      if ((localBitmap == null) || ((this.jdField_b_of_type_Int == 0) && (localObject2 == null)))
      {
        ConfessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin);
        ConfessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin, false);
        ConfessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin, 0, 2131435303);
        return;
      }
      String str3 = ConfessShareHelper.a((AppInterface)localObject4, (Context)localObject3, localBitmap);
      String str1 = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_b_of_type_Int == 0)
      {
        localObject1 = ConfessShareHelper.a(str3, this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin.mRuntime.a());
        localObject2 = ConfessShareHelper.a(ConfessShareHelper.a((AppInterface)localObject4, (Context)localObject3, (Bitmap)localObject2), this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin.mRuntime.a());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = ((String)localObject2).replace("http://qqadapt.qpic.cn/qqshare/", "");
          str1 = Uri.parse(this.jdField_c_of_type_JavaLangString).buildUpon().appendQueryParameter("ct", (String)localObject3).build().toString();
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(str3)) || ((this.jdField_b_of_type_Int == 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))))
        {
          ConfessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin);
          ConfessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin, false);
          ConfessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin, 1, 2131430004);
          return;
        }
        localObject2 = this.jdField_d_of_type_JavaLangString;
        String str2 = this.e;
        if (QLog.isColorLevel()) {
          QLog.d("ConfessPlugin", 2, "processShare share_url_tmp:" + str1 + " remoteUrl:" + (String)localObject1 + " srcUrl:" + this.jdField_d_of_type_JavaLangString + " srcIconUrl:" + this.e);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        Object localObject5;
        if (this.jdField_b_of_type_Int == 0)
        {
          localObject5 = new HashMap();
          if ((localObject2 != null) && (((String)localObject2).length() > 30)) {
            ((HashMap)localObject5).put("srcUrl", localObject2);
          }
          if ((str2 != null) && (str2.length() > 30)) {
            ((HashMap)localObject5).put("srcIconUrl", str2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 30)) {
            ((HashMap)localObject5).put("remoteUrl", localObject1);
          }
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (!((HashMap)localObject5).isEmpty())
          {
            localObject4 = HttpUtil.a((HashMap)localObject5);
            localObject3 = (String)((HashMap)localObject4).get("remoteUrl");
            if (localObject3 != null) {
              localObject1 = localObject3;
            }
            localObject3 = (String)((HashMap)localObject4).get("srcUrl");
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
            localObject5 = (String)((HashMap)localObject4).get("srcIconUrl");
            localObject3 = localObject1;
            localObject4 = localObject2;
            if (localObject5 == null) {}
          }
        }
        for (localObject3 = localObject5;; localObject3 = str2)
        {
          ThreadManager.getUIHandler().post(new absf(this, str1, (String)localObject1, (String)localObject2, (String)localObject3, str3, localBitmap));
          return;
          localObject2 = localObject4;
          localObject1 = localObject3;
        }
        continue;
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abse
 * JD-Core Version:    0.7.0.1
 */