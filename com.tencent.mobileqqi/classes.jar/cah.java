import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class cah
  extends FriendListObserver
{
  public cah(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    Card localCard;
    if ((paramBoolean) && (AddRequestActivity.a(this.a) != null) && (AddRequestActivity.a(this.a).equals(paramString)))
    {
      localCard = ((FriendManager)this.a.b.getManager(8)).a(paramString);
      if (localCard != null)
      {
        if ((AddRequestActivity.a(this.a) == null) || (AddRequestActivity.a(this.a).msg == null) || (!AddRequestActivity.a(this.a).msg.friend_info.has()) || (AddRequestActivity.a(this.a).msg.friend_info.msg_joint_friend.has() != true)) {
          break label215;
        }
        AddRequestActivity.b(this.a).setText(AddRequestActivity.a(this.a).msg.friend_info.msg_joint_friend.get());
        AddRequestActivity.b(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "Card find Uin :" + paramString + "age:" + localCard.age + "gender:" + localCard.shGender);
      }
      return;
      label215:
      AddRequestActivity.b(this.a).setVisibility(8);
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean)
    {
      if (AddRequestActivity.a(this.a) != null) {
        AddRequestActivity.a(this.a).dismiss();
      }
      this.a.a(2130837947, this.a.getString(2131561435));
      return;
    }
    if (AddRequestActivity.a(this.a) != null) {
      AddRequestActivity.a(this.a).dismiss();
    }
    this.a.a(2130837958, this.a.getString(2131561910));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cah
 * JD-Core Version:    0.7.0.1
 */