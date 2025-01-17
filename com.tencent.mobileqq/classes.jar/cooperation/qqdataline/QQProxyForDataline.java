package cooperation.qqdataline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQProxyForDataline
{
  public static void a(Context paramContext, Bundle paramBundle, String paramString)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - startQlink failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), "加载失败，请重试", 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, DatalineBridgeActivity.class);
    localIntent.putExtra("componetname", paramString);
    if (paramBundle != null) {
      localIntent.putExtra("_param_", paramBundle);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqdataline.QQProxyForDataline
 * JD-Core Version:    0.7.0.1
 */