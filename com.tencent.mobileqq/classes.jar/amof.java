import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qlink.QlinkStandardDialogActivity;

public class amof
  implements DialogInterface.OnClickListener
{
  public amof(QlinkStandardDialogActivity paramQlinkStandardDialogActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.app.getApp().getApplicationContext(), 1, this.jdField_a_of_type_JavaLangString, null, 3020, 0, this.b, null, null, "返回", null);
    localIntent.putExtra("_FROM_QLINK_", true);
    this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.startActivity(localIntent);
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amof
 * JD-Core Version:    0.7.0.1
 */