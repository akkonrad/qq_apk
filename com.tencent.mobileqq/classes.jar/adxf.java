import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import org.json.JSONArray;
import org.json.JSONObject;

public class adxf
  implements PopupMenuDialog.OnClickActionListener
{
  public adxf(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject, Activity paramActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.a - 1;
    Object localObject1 = null;
    paramMenuItem = null;
    for (;;)
    {
      JSONArray localJSONArray;
      int j;
      try
      {
        String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
        localJSONArray = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("list");
        if (localJSONArray == null) {
          break;
        }
        if (i >= localJSONArray.length()) {
          return;
        }
        if (TextUtils.isEmpty(str)) {
          break label169;
        }
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(str, new String[] { String.valueOf(i + 1) });
        return;
      }
      catch (Exception localException1)
      {
        i = 0;
        localObject1 = paramMenuItem;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("UiApiPlugin", 2, "showPopupMenu Exception: " + localException1.getMessage());
          j = i;
          localObject1 = paramMenuItem;
        }
        switch (j)
        {
        default: 
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a().loadUrl((String)localObject1);
      return;
      label169:
      Object localObject2 = localJSONArray.optJSONObject(i);
      i = ((JSONObject)localObject2).optInt("target");
      paramMenuItem = (PopupMenuDialog.MenuItem)localObject1;
      try
      {
        localObject1 = ((JSONObject)localObject2).optString("jumpUrl");
        paramMenuItem = (PopupMenuDialog.MenuItem)localObject1;
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        j = i;
        if (!bool) {
          continue;
        }
        return;
      }
      catch (Exception localException2) {}
      paramMenuItem = new Bundle();
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity))
      {
        localObject2 = new Intent(((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtras(paramMenuItem);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject2).setFlags(0);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        return;
      }
      localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getClass());
      ((Intent)localObject2).putExtras(paramMenuItem);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).setFlags(0);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxf
 * JD-Core Version:    0.7.0.1
 */