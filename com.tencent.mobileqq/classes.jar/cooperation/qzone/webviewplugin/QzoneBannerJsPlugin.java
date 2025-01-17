package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneBannerJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private String a;
  
  public QzoneBannerJsPlugin()
  {
    this.jdField_a_of_type_JavaLangString = QzoneBannerJsPlugin.class.getSimpleName();
  }
  
  private JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
        paramString = null;
      }
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null)) {
      paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    }
    while (paramJsBridgeListener != null)
    {
      paramString1 = paramJsBridgeListener.getTag(2131362662);
      if ((paramString1 != null) && ((paramString1 instanceof QzoneBannerJsPlugin.WebViewBannerInterface)))
      {
        paramString1 = (QzoneBannerJsPlugin.WebViewBannerInterface)paramString1;
        if ((!"setBannerHeight".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {
          break label344;
        }
        paramJsBridgeListener = a(paramVarArgs[0]);
        if (paramJsBridgeListener != null) {
          break label176;
        }
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "setBannerHeight 方法参数错误！！！！");
        return false;
        paramJsBridgeListener = null;
      }
      else
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "webViewBannerInterface error o=" + paramString1);
        return false;
      }
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleJsRequest webView==null");
    return false;
    label176:
    double d = paramJsBridgeListener.optDouble("height");
    if (d <= 0.0D) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "setBannerHeight 方法参数错误 height<=0 ！！！！  )");
    }
    int i;
    for (;;)
    {
      return true;
      i = paramJsBridgeListener.optInt("unit");
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "setBannerHeight height:" + d + ",unit:" + i);
      if (i == 1) {
        paramString1.setBannerHeight((int)d);
      } else if (i == 2) {
        paramString1.setBannerHeight((int)ViewUtils.a((float)d));
      } else if (i == 3) {
        paramString1.setBannerHeight((int)(d * ViewUtils.a()));
      } else {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "setBannerHeight 方法参数错误 :unit= " + i);
      }
    }
    label344:
    if ("closeBanner".equals(paramString3))
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "closeBanner:");
      paramString1.j();
      return true;
    }
    if (("enableGesture".equals(paramString3)) && (paramVarArgs.length >= 1))
    {
      paramJsBridgeListener = a(paramVarArgs[0]);
      if (paramJsBridgeListener == null) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "enableGesture 方法参数错误！！！！");
      }
      for (;;)
      {
        return true;
        boolean bool = paramJsBridgeListener.optBoolean("enable");
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "enableGesture enable:" + bool);
        paramString1.c(bool);
      }
    }
    if (("getBannerData".equals(paramString3)) && (paramVarArgs.length >= 1))
    {
      paramString2 = a(paramVarArgs[0]);
      if (paramString2 == null) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "getBannerData 方法参数错误！！！！");
      }
      for (;;)
      {
        return true;
        paramString2 = paramString2.optString("callback");
        if (TextUtils.isEmpty(paramString2)) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "getBannerData 方法参数错误！！！！");
        }
        paramString1 = paramString1.a();
        paramJsBridgeListener.a(paramString2, new String[] { paramString1 });
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "getBannerData " + paramString1);
      }
    }
    if (("qbossReport".equals(paramString3)) && (paramVarArgs.length >= 1))
    {
      paramJsBridgeListener = a(paramVarArgs[0]);
      if (paramJsBridgeListener == null) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "qbossReport 方法参数错误！！！！");
      }
      for (;;)
      {
        return true;
        paramString2 = paramJsBridgeListener.optString("sQBosstrace");
        if (TextUtils.isEmpty(paramString2)) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "qbossReport 方法参数错误！！！！");
        }
        i = paramJsBridgeListener.optInt("type");
        paramString1.a(i, paramString2);
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "qbossReport type:" + i + ",qBosstrace:" + paramString2);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneBannerJsPlugin
 * JD-Core Version:    0.7.0.1
 */