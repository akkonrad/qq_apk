import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import mqq.os.MqqHandler;

class vzv
  implements Runnable
{
  vzv(vzs paramvzs) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null) {
      this.a.a.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
    }
    this.a.a.p(true);
    TroopChatPie.d(this.a.a).postDelayed(new vzw(this), 100L);
    if (!AnonymousChatHelper.a(this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      TroopChatPie.e(this.a.a).postDelayed(new vzx(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzv
 * JD-Core Version:    0.7.0.1
 */