import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QAVHrMeeting.OnGetNickNameOfMaskDisc;

public final class rxr
  implements QAVHrMeeting.OnGetNickNameOfMaskDisc
{
  public rxr(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsBundle.putInt("MeetingStasks", paramInt);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxr
 * JD-Core Version:    0.7.0.1
 */