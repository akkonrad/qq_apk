import android.view.View;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicInteger;

public class aogc
  implements ActionSheet.OnButtonClickListener
{
  public aogc(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.a.a.b.get() == 4) {
      this.a.a(false);
    }
    this.a.a.a("FlowCameraActivity");
    this.a.b();
    FlowCameraMqqAction.b("", "0X800656F", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogc
 * JD-Core Version:    0.7.0.1
 */