import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopItemInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.qphone.base.util.QLog;

public class wsd
  extends VasExtensionObserver
{
  public wsd(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    long l = paramObject.getLong("pendantId");
    paramObject.getInt("seriesId");
    Object localObject = paramObject.getString("uin");
    int i = paramObject.getInt("result");
    if ((l == -1L) || (localObject == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label455;
      }
      if (l != 0L) {
        break;
      }
      this.a.b.setVisibility(4);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.a.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.c = -1;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005FD4", "0X8005FD4", 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null)
      {
        paramObject = ((AvatarPendantManager)this.a.app.getManager(45)).a();
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(paramObject);
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_a_of_type_Boolean));
    localObject = IndividuationUrlHelper.a("linkPendantSet");
    paramObject = localObject;
    if (localObject != null) {
      paramObject = ((String)localObject).replace("[id]", String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_a_of_type_Int));
    }
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, "handlePendantAuth, mPendantInfo.isLink == true, jump to url =" + paramObject);
    }
    localObject = new Intent(this.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramObject);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("webStyle", "noBottomBar");
    this.a.startActivity((Intent)localObject);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8006517", "0X8006517", 0, 0, "", "", "", "");
    return;
    this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131434606);
    this.a.b.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    localObject = this.a.app;
    if (this.a.d) {}
    for (paramObject = "1";; paramObject = "0")
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005FD6", "0X8005FD6", 0, 0, paramObject, "", "", "");
      if (!this.a.d) {
        break;
      }
      this.a.d = false;
      break;
    }
    label455:
    paramObject = (PendantTipsInfo)paramObject.getSerializable("tipsInfo");
    if (paramObject != null)
    {
      this.a.a(paramObject, l, i);
      return;
    }
    QLog.e("IphoneTitleBarActivity", 1, "handlePendantAuth, tipsInfo == null, pendantId = " + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsd
 * JD-Core Version:    0.7.0.1
 */