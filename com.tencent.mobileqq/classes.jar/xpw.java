import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

class xpw
  implements View.OnLayoutChangeListener
{
  xpw(xpv paramxpv) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.e.removeOnLayoutChangeListener(this);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.e.setText("美容度" + this.a.jdField_a_of_type_Int + "%");
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.e.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpw
 * JD-Core Version:    0.7.0.1
 */