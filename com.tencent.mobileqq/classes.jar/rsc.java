import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.qphone.base.util.QLog;

public class rsc
  implements Runnable
{
  public rsc(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    BaseChatPie.b(this.a);
    try
    {
      this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843959);
      this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843960);
      this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837580);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.aio.BaseChatPie", 2, "emo qvip_emoji_aio_face_new_default_fail, e=" + localException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "emo qvip_emoji_aio_face oom, e= " + localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsc
 * JD-Core Version:    0.7.0.1
 */