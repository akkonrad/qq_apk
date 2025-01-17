package dov.com.tencent.biz.qqstory.takevideo.interact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.utils.StringUtil;

public abstract class InteractPasterItem
  implements TextWatcher, TextView.OnEditorActionListener
{
  protected EditText a;
  protected TextView a;
  protected InteractPasterItem.InteractPasterEditListener a;
  
  @NonNull
  public static InteractPasterItem a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unSupport interactType:" + paramInt);
    }
    return new RatePasterItem();
  }
  
  protected abstract View a();
  
  public abstract InteractPasterItem.InteractPasterInfo a();
  
  public void a() {}
  
  public void a(Context paramContext, InteractPasterItem.InteractPasterInfo paramInteractPasterInfo, EditText paramEditText, TextView paramTextView, InteractPasterItem.InteractPasterEditListener paramInteractPasterEditListener)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterEditListener = paramInteractPasterEditListener;
  }
  
  protected void a(CharSequence paramCharSequence, int paramInt)
  {
    int i = StringUtil.b(paramCharSequence.toString());
    if (paramInt - i <= 6)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(i / 2), Integer.valueOf(paramInt / 2) }));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetEditText.getText().clear();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.interact.InteractPasterItem
 * JD-Core Version:    0.7.0.1
 */