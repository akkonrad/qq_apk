import com.tencent.mobileqq.international.activity.FeedbackActivity;
import mqq.observer.AccountObserver;

public class gdw
  extends AccountObserver
{
  public gdw(FeedbackActivity paramFeedbackActivity, String paramString) {}
  
  public void onUpdateSTwxWeb(String paramString)
  {
    new gdx(this.jdField_a_of_type_ComTencentMobileqqInternationalActivityFeedbackActivity, null).execute(new String[] { "http://mma.qq.com/cgi-bin/support/upload_support", this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gdw
 * JD-Core Version:    0.7.0.1
 */