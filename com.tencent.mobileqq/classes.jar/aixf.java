import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public class aixf
  extends Handler
{
  public aixf(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.a.r)) {
      localBundle.putString("bid", this.a.r);
    }
    if ((this.a.jdField_b_of_type_AndroidWidgetTextView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    int i;
    for (String str = "interestcircle";; str = "qqbuluo")
    {
      localBundle.putString("from", str);
      localBundle.putString("uin", this.a.app.getCurrentAccountUin());
      localBundle.putString("title", TroopBarUtils.a(this.a.a).trim());
      localBundle.putString("content", TroopBarUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText).trim());
      switch (paramMessage.what)
      {
      case 3: 
      default: 
        i = 3;
        TroopBarPublishUtils.a(this.a, 1, i, localBundle);
        return;
      }
    }
    localBundle.putString("clicktype", "music");
    if ((this.a.jdField_b_of_type_AndroidWidgetTextView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 2;
      label210:
      if (!TextUtils.isEmpty(this.a.r)) {
        break label259;
      }
    }
    label259:
    for (paramMessage = "0";; paramMessage = this.a.r)
    {
      ReportController.b(null, "dc00899", "pub_page_new", "", "pub_page", "Clk_music", i, 0, paramMessage, "", "", "");
      i = 4;
      break;
      i = 1;
      break label210;
    }
    if ((this.a.jdField_b_of_type_AndroidWidgetTextView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 2;
      if (!TextUtils.isEmpty(this.a.r)) {
        break label340;
      }
    }
    label340:
    for (paramMessage = "0";; paramMessage = this.a.r)
    {
      ReportController.b(null, "dc00899", "pub_page_new", "", "pub_page", "Clk_record", i, 0, paramMessage, "", "", "");
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixf
 * JD-Core Version:    0.7.0.1
 */