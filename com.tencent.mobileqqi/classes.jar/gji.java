import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;

public class gji
  extends Handler
{
  public gji(ProfileHeaderView paramProfileHeaderView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (ProfileHeaderView.b == paramMessage.what)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView handleMessage msg what is check tips time=" + this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.j(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gji
 * JD-Core Version:    0.7.0.1
 */