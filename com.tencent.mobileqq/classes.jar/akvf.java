import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.util.QLog;

public class akvf
  implements Runnable
{
  public akvf(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "onDismiss arrow postDelayed 500 run and set isLastDropDown false");
    }
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvf
 * JD-Core Version:    0.7.0.1
 */