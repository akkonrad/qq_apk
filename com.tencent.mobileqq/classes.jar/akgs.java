import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.widget.QQToast;

public final class akgs
  implements Runnable
{
  public akgs(Context paramContext, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localFragmentActivity.getChatFragment() != null) && (localFragmentActivity.getChatFragment().a() != null))
      {
        localFragmentActivity.getChatFragment().a().R();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, this.jdField_a_of_type_JavaLangString, 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akgs
 * JD-Core Version:    0.7.0.1
 */