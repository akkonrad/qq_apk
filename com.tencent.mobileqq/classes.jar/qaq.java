import android.os.Bundle;
import android.os.Handler;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qaq
  implements BusinessObserver
{
  public qaq(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (!paramBoolean)
    {
      ToastUtil.a().a(this.a.getString(2131427804));
      DeviceMsgSettingActivity.a(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      ToastUtil.a().a(this.a.getString(2131427804));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          ToastUtil.a().a(this.a.getString(2131427804));
          this.a.jdField_a_of_type_AndroidOsHandler.post(new qar(this));
          return;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle == null)
        {
          ToastUtil.a().a(this.a.getString(2131427807));
          DeviceMsgSettingActivity.a(this.a);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        LogUtility.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
        ToastUtil.a().a(this.a.getString(2131427804));
        continue;
        paramInt = 0;
      }
      while (paramInt < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(paramInt);
        qat localqat = new qat(this.a, null);
        localqat.jdField_a_of_type_Int = localJSONObject.getInt("id");
        localqat.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
        localqat.b = localJSONObject.getInt("enable");
        this.a.jdField_a_of_type_JavaUtilArrayList.add(localqat);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qaq
 * JD-Core Version:    0.7.0.1
 */