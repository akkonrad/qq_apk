import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bxo
  extends ClickableSpan
{
  String jdField_a_of_type_JavaLangString;
  
  public bxo(AboutActivity paramAboutActivity, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, QQBrowserActivity.class);
    paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.b.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.startActivity(paramView.putExtra("url", this.jdField_a_of_type_JavaLangString));
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16754769);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bxo
 * JD-Core Version:    0.7.0.1
 */