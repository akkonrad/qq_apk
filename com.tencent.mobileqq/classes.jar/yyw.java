import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class yyw
  implements View.OnClickListener
{
  public yyw(ApolloPanel paramApolloPanel, Bundle paramBundle, ApolloActionData paramApolloActionData) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null))
    {
      paramView = null;
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        paramView = this.jdField_a_of_type_AndroidOsBundle.getString("activityUrl");
      }
      Object localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.url;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] btn click, activityUrl=", localObject });
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
        paramView.putExtra("url", (String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
      }
      ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_flame_clickgain", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yyw
 * JD-Core Version:    0.7.0.1
 */