import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.QQToast;

public class yar
  extends Handler
{
  public yar(SelectMemberActivity paramSelectMemberActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.scrollTo(this.a.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width, 0);
        return;
      } while ((this.a.b == null) || (!this.a.b.isShowing()));
      this.a.b.dismiss();
      this.a.setResult(-1);
      if (!TextUtils.isEmpty(this.a.jdField_g_of_type_JavaLangString))
      {
        paramMessage = this.a.jdField_g_of_type_JavaLangString;
        QQToast.a(this.a, 2, paramMessage, 1500).b(this.a.getTitleBarHeight());
        postDelayed(new yas(this), 1500L);
        return;
      }
      if (this.a.jdField_g_of_type_Boolean) {}
      for (int i = 2131435998;; i = 2131435999)
      {
        paramMessage = this.a.getResources().getString(i);
        break;
      }
    } while ((this.a.b == null) || (!this.a.b.isShowing()));
    this.a.b.dismiss();
    String str = (String)paramMessage.obj;
    paramMessage = str;
    if (str == null) {
      paramMessage = this.a.getString(2131436000);
    }
    QQToast.a(this.a, 1, paramMessage, 1500).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yar
 * JD-Core Version:    0.7.0.1
 */