import android.app.Activity;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.mp.mobileqq_mp.SubscribeRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import mqq.app.NewIntent;

public class vhr
  implements PopupMenuDialog.OnClickActionListener
{
  public vhr(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Activity paramActivity, AbsStructMsg paramAbsStructMsg) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (StructingMsgItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("msg_template_id");
    int i = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "PubAccountFollowSvc.subscribe");
    mobileqq_mp.SubscribeRequest localSubscribeRequest = new mobileqq_mp.SubscribeRequest();
    localSubscribeRequest.msg_id.set(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
    localSubscribeRequest.index.set(paramMenuItem.a);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
      l1 = l2;
    }
    catch (Exception paramMenuItem)
    {
      label108:
      break label108;
    }
    localSubscribeRequest.template_id.set(str);
    localSubscribeRequest.puin.set(l1);
    localNewIntent.setObserver(new vhs(this, str));
    localNewIntent.putExtra("data", localSubscribeRequest.toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a.startServlet(localNewIntent);
    StructingMsgItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vhr
 * JD-Core Version:    0.7.0.1
 */