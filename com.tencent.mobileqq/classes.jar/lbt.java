import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lbt
  implements ActionSheet.OnButtonClickListener
{
  public lbt(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity, boolean paramBoolean1, long paramLong, boolean paramBoolean2, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.jdField_a_of_type_Boolean = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        ForwardSdkShareOption.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity, true, "shareToQQ", this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.moveTaskToBack(true);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.finish();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.d();
      if (this.b) {
        PublicAccountReportUtils.a(null, "", "0X8008661", "0X8008661", 0, 0, this.jdField_a_of_type_Int + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbt
 * JD-Core Version:    0.7.0.1
 */