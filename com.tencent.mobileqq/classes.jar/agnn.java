import android.content.res.Resources;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.utils.NetworkUtil;

public class agnn
  implements Runnable
{
  public agnn(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, PersonalityLabel paramPersonalityLabel) {}
  
  public void run()
  {
    PersonalityLabelGalleryActivity localPersonalityLabelGalleryActivity;
    if (!this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel, false);
      if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity)) {
        break label101;
      }
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.getResources().getString(2131433213));
      if ((this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel == null) || (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.getSize() <= 0)) {
        break label91;
      }
      i = 1;
      localPersonalityLabelGalleryActivity = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity;
      if (i == 0) {
        break label96;
      }
    }
    label91:
    label96:
    for (int i = 8;; i = 0)
    {
      localPersonalityLabelGalleryActivity.a(i, "加载失败", false);
      return;
      i = 0;
      break;
    }
    label101:
    PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agnn
 * JD-Core Version:    0.7.0.1
 */