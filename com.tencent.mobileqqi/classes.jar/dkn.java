import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.activity.RegisterActivity;

public class dkn
  implements DialogInterface.OnClickListener
{
  public dkn(RegisterActivity paramRegisterActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity.startActivity(localIntent);
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity.a.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dkn
 * JD-Core Version:    0.7.0.1
 */