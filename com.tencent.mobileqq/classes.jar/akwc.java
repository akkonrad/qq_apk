import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.ProgressPieDrawable;

public class akwc
  extends Handler
{
  public int a;
  
  public akwc(ProgressPieDrawable paramProgressPieDrawable) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.isVisible())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e);
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akwc
 * JD-Core Version:    0.7.0.1
 */