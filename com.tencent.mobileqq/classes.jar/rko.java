import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class rko
  implements Runnable
{
  rko(rkn paramrkn, Card paramCard) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Rkn.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_Rkn.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_Rkn.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_Rkn.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
    {
      AddRequestActivity.a(this.jdField_a_of_type_Rkn.a.a).setText(this.jdField_a_of_type_Rkn.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
      AddRequestActivity.a(this.jdField_a_of_type_Rkn.a.a).setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "Card find Uin :" + this.jdField_a_of_type_Rkn.a.a.jdField_a_of_type_JavaLangString + "age:" + this.jdField_a_of_type_ComTencentMobileqqDataCard.age + "gender:" + this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender);
      }
      return;
      AddRequestActivity.a(this.jdField_a_of_type_Rkn.a.a).setVisibility(8);
      this.jdField_a_of_type_Rkn.a.a.a(this.jdField_a_of_type_ComTencentMobileqqDataCard);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rko
 * JD-Core Version:    0.7.0.1
 */