import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;

public class jqg
  implements Runnable
{
  public jqg(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.a.b, 4, "onWindowFocusChangedRunnable, nfonWindowFocus[" + this.a.j + "->true]");
    }
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqg
 * JD-Core Version:    0.7.0.1
 */