import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment.SearchActivityInterface;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity.MyFlingGestureHandler;

public class agdd
  implements BaseOCRTextSearchFragment.SearchActivityInterface
{
  public agdd(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
      this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      return;
      this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$MyFlingGestureHandler.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agdd
 * JD-Core Version:    0.7.0.1
 */