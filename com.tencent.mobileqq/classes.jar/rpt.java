import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class rpt
  implements View.OnClickListener
{
  public rpt(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramView.putInt("funcall_tip_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 4);
    paramView.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rpt
 * JD-Core Version:    0.7.0.1
 */