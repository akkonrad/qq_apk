import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallFacade;

public class wqb
  implements Runnable
{
  public wqb(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localQCallFacade != null)
      {
        int i = localQCallFacade.a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new wqc(this, i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqb
 * JD-Core Version:    0.7.0.1
 */