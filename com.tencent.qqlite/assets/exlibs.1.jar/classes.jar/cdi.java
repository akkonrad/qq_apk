import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

public class cdi
  implements TextWatcher
{
  public cdi(SearchContactsActivity paramSearchContactsActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    ImageButton localImageButton = this.a.jdField_a_of_type_AndroidWidgetImageButton;
    if (paramEditable.equals("")) {}
    for (int i = 8;; i = 0)
    {
      localImageButton.setVisibility(i);
      if (TextUtils.isEmpty(paramEditable)) {
        break;
      }
      this.a.g();
      this.a.b(paramEditable);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdi
 * JD-Core Version:    0.7.0.1
 */