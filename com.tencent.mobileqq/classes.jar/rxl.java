import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QAVHrMeeting;

public final class rxl
  implements DialogInterface.OnClickListener
{
  public rxl(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxl
 * JD-Core Version:    0.7.0.1
 */