import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class almo
  implements ActionSheet.OnButtonClickListener
{
  public almo(QidianProfileCardActivity paramQidianProfileCardActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (TextUtils.isEmpty(paramView))
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      if (paramView.equals(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getString(2131435871)))
      {
        QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      if (paramView.equals(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getString(2131435877)))
      {
        QidianProfileCardActivity.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
    } while (!paramView.equals(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getString(2131438731)));
    QidianProfileCardActivity.c(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     almo
 * JD-Core Version:    0.7.0.1
 */