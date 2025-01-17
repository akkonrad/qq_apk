import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.open.appcommon.AppClient;
import com.tencent.qphone.base.util.QLog;

public class gox
  extends StructMsgClickHandler
{
  public gox(AbsShareMsg paramAbsShareMsg, View paramView)
  {
    super(paramView);
  }
  
  public gox(AbsShareMsg paramAbsShareMsg, QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramQQAppInterface, paramView);
  }
  
  public boolean a(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3)[0];
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "SourceClickHandler click2YYB  appid = " + paramLong + "; packageName=" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new Bundle();
    paramString2.putString("packageName", paramString1);
    paramString2.putString("appId", paramLong + "");
    AppClient.b(paramActivity, paramString2);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "SourceClickHandler clickWebMsg  url = " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName);
    localIntent.putExtra("url", paramString);
    PublicAccountUtil.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "SourceClickHandler clickAppMsg url = " + paramString1 + ", actionData = " + paramString2 + ", actionDataA = " + paramString3);
    }
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3);
    paramString2 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    try
    {
      if (paramString2.getPackageInfo(paramString1[0], 1) != null)
      {
        paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
        if (!TextUtils.isEmpty(paramString1[1])) {
          paramString2.setData(Uri.parse(paramString1[1]));
        }
        try
        {
          ((StartAppCheckHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).b(paramString1[0].trim(), this.jdField_a_of_type_AndroidContentContext, paramString2);
          return true;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
          }
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramString1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gox
 * JD-Core Version:    0.7.0.1
 */