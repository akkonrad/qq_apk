import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;

public class ksm
  implements View.OnClickListener
{
  public ksm(AccountDetailActivity paramAccountDetailActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksm
 * JD-Core Version:    0.7.0.1
 */