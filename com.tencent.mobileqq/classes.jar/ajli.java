import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase.OnEditItemListener;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.TextViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ajli
  implements TextWatcher
{
  public ajli(TextItem paramTextItem, TextItem.TextViewHolder paramTextViewHolder, TextInfo paramTextInfo) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
      i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b();
      j -= i;
      k = paramInt3 - paramInt2;
      if (k > j)
      {
        QQToast.a(TextItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem), "最多可以输入500个字", 1).a();
        paramInt2 = j + paramInt2;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.removeTextChangedListener(this);
        CharSequence localCharSequence = paramCharSequence.subSequence(0, paramInt1 + paramInt2);
        paramCharSequence = paramCharSequence.subSequence(paramInt1 + paramInt3, paramCharSequence.length());
        paramCharSequence = localCharSequence.toString() + paramCharSequence.toString();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setText(paramCharSequence);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.addTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a.setSelection(paramInt1 + paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(i, i + paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int = (paramInt2 + paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.b(paramCharSequence);
      }
    }
    for (;;)
    {
      QLog.i("xmediaEditor", 1, "onTextChanged, mData.position:" + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.c + ", text:" + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString + ",Listener:" + toString());
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(i, i + k);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int = (paramInt1 + k);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.b(paramCharSequence.toString());
      continue;
      i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(i, i + paramInt3 - paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int = (paramInt1 + paramInt3);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.b(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajli
 * JD-Core Version:    0.7.0.1
 */