import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;

class xqh
  implements Runnable
{
  xqh(xqg paramxqg) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onResourceDownload update filterpager begin");
    }
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_Xqf.a, (VideoFilterViewPager)this.a.jdField_a_of_type_Xqf.a.a(2131368994));
    this.a.jdField_a_of_type_Xqf.a.a = new xqi(this);
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_Xqf.a).setViewPagerItemVisiableChangeListener(this.a.jdField_a_of_type_Xqf.a.a);
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_Xqf.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools.a());
    FilterDesc localFilterDesc = NewFlowCameraActivity.a(this.a.jdField_a_of_type_Xqf.a).a(NewFlowCameraActivity.a(this.a.jdField_a_of_type_Xqf.a).getCurrentItem());
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools.a(localFilterDesc);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onResourceDownload update filterpager end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqh
 * JD-Core Version:    0.7.0.1
 */