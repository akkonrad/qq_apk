import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qphone.base.util.QLog;

public class jxw
  implements Runnable
{
  public jxw(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "RemoveTipsRunnale Run");
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxw
 * JD-Core Version:    0.7.0.1
 */