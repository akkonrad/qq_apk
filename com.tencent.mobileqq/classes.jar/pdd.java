import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class pdd
  implements Runnable
{
  public pdd(Share paramShare, String paramString1, String paramString2, String paramString3, ApplicationInfo paramApplicationInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(Share.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina download image:" + this.jdField_a_of_type_JavaLangString);
    }
    String str = ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, null);
    if (QLog.isColorLevel()) {
      QLog.d(Share.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina path:" + str);
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", this.b + this.c);
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
    }
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(Share.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdd
 * JD-Core Version:    0.7.0.1
 */