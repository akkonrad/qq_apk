import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class agsk
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public agsk(VipPhotoViewForSimple paramVipPhotoViewForSimple) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 1000L) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = l;
      } while ((paramView == null) || (!(paramView.getTag() instanceof DataTag)));
      paramView = (DataTag)paramView.getTag();
    } while (paramView == null);
    int i = paramView.a;
    paramView = VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple).a.a;
    switch (i)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "View.OnClickListener click type is photo wall view");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a, "CliOper", "", "", "card_mall", "0X80066C4", 0, 0, "1", "", "", "");
    VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple, VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agsk
 * JD-Core Version:    0.7.0.1
 */