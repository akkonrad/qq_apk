import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class hfg
  implements Runnable
{
  hfg(hfe paramhfe, Exception paramException) {}
  
  public void run()
  {
    this.jdField_a_of_type_Hfe.a.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport exception1" + this.jdField_a_of_type_JavaLangException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfg
 * JD-Core Version:    0.7.0.1
 */