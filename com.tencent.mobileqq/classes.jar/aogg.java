import android.graphics.drawable.Drawable;
import android.widget.TextView;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicInteger;

public class aogg
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  final int[] jdField_a_of_type_ArrayOfInt = { 255, 191, 127, 63, 0, 63, 127, 191 };
  
  public aogg(FlowCameraActivity2 paramFlowCameraActivity2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramFlowCameraActivity2.a.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int %= 32;
  }
  
  public void run()
  {
    Drawable[] arrayOfDrawable = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.b.getCompoundDrawables();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.v();
    }
    if (arrayOfDrawable[0] != null) {
      arrayOfDrawable[0].setAlpha(this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_Int / 4)]);
    }
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.a.b.get() == 2) && (arrayOfDrawable[0] != null))
    {
      arrayOfDrawable[0].setAlpha(255);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.a(arrayOfDrawable[0], -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogg
 * JD-Core Version:    0.7.0.1
 */