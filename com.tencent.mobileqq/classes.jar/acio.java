import android.support.v4.app.Fragment;
import android.widget.EditText;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.DeleteIconClickListener;

public class acio
  implements ExtendFriendVoiceView.DeleteIconClickListener
{
  public acio(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a()) {
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
    }
    this.a.b = "";
    ExtendFriendProfileEditFragment.b(this.a, 0);
    Fragment localFragment = this.a.getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).a = null;
    }
    ExtendFriendProfileEditFragment.a(this.a, null);
    ExtendFriendProfileEditFragment.c(this.a);
    if (ExtendFriendProfileEditFragment.b(this.a))
    {
      ExtendFriendProfileEditFragment.a(this.a, true);
      ExtendFriendProfileEditFragment.b(this.a);
    }
    do
    {
      return;
      ExtendFriendProfileEditFragment.a(this.a, false);
    } while ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString())));
    ExtendFriendProfileEditFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acio
 * JD-Core Version:    0.7.0.1
 */