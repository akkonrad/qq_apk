import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.QLog;

class vfg
  implements Runnable
{
  vfg(vff paramvff, ProgressPieDrawable paramProgressPieDrawable) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.setVisible(false, true);
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleItemBuilder", 2, "[onProgressCompleted] set ProgressPieDrawable invisible,ppd = " + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfg
 * JD-Core Version:    0.7.0.1
 */