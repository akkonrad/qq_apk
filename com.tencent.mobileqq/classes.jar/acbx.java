import android.os.Bundle;
import com.tencent.mobileqq.apollo.task.OnAddOrDeleGameListener;
import com.tencent.mobileqq.emosm.web.MessengerService;

class acbx
  implements OnAddOrDeleGameListener
{
  acbx(acbw paramacbw) {}
  
  public void a(long paramLong, String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramLong == 0L) {}
    for (int i = 0;; i = 1)
    {
      localBundle.putInt("result", i);
      localBundle.putString("message", paramString);
      this.a.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.a.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbx
 * JD-Core Version:    0.7.0.1
 */