import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.viewplugin.ViewPluginLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class paf
  implements AsyncBack
{
  public paf(ViewPluginLoader paramViewPluginLoader, QQAppInterface paramQQAppInterface) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
        str = paramString.optString("url");
        paramInt = paramString.optInt("filesize");
        if ((str != null) && (str.endsWith("patch")))
        {
          FileUtils.a(OfflineEnvHelper.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a) + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a);
          this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.b();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a();
        return;
      }
      if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
      {
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     paf
 * JD-Core Version:    0.7.0.1
 */