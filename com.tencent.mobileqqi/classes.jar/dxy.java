import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import java.util.ArrayList;

class dxy
  implements DialogInterface.OnClickListener
{
  dxy(dxw paramdxw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ArrayList();
    paramDialogInterface.add(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember.a);
    this.a.jdField_a_of_type_Dxu.a.i = this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember.a;
    ((TroopHandler)this.a.jdField_a_of_type_Dxu.a.b.a(19)).a(TroopMemberListActivity.a(this.a.jdField_a_of_type_Dxu.a), paramDialogInterface);
    this.a.jdField_a_of_type_Dxu.a.e();
    this.a.jdField_a_of_type_Dxu.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxy
 * JD-Core Version:    0.7.0.1
 */