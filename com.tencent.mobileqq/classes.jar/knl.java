import android.widget.LinearLayout;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;

public class knl
  implements BounceScrollView.OnScrollChangedListener
{
  public knl(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() - this.a.b * (1.0D - LebaSearchPluginManagerActivity.jdField_a_of_type_Double) + 56.0F * this.a.jdField_a_of_type_Float);
    this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setMaxOverScrollY(paramInt1);
    if (LebaSearchPluginManagerActivity.a(this.a))
    {
      this.a.a(paramInt2);
      LebaSearchPluginManagerActivity.b(this.a, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knl
 * JD-Core Version:    0.7.0.1
 */