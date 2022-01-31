import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aimi
  implements WtTicketPromise
{
  public aimi(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, Runnable paramRunnable) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkFileImportHandler", 2, "--- pskey invalid retry ---  ");
    }
    ThreadManager.executeOnNetWorkThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TeamWorkFileImportHandler", 2, "--- get pskey failed ---  " + paramErrMsg.getMessage());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TeamWorkFileImportHandler", 2, "--- get pskey timeout ---  " + paramErrMsg.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimi
 * JD-Core Version:    0.7.0.1
 */