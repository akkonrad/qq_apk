import com.tencent.av.VideoController;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.CharacterUtil;

public class kay
  implements QavInOutAnimation.QavOutAnimationListener
{
  public kay(VideoInviteActivity paramVideoInviteActivity, boolean paramBoolean) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131364247, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365414, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365413, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365411, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365409, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131364249, false);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h) {
        break label108;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 1, true);
      long l = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.b(3, l);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.g = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.a(l, 1);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.overridePendingTransition(0, 2131034269);
      return;
      label108:
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 1, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 0);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.b(248);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 1);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kay
 * JD-Core Version:    0.7.0.1
 */