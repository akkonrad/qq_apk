import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.widget.QQToast;

public class zcx
  implements Runnable
{
  public zcx(DiscussionHandler paramDiscussionHandler, String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, this.jdField_a_of_type_JavaLangString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcx
 * JD-Core Version:    0.7.0.1
 */