import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class eod
  implements View.OnClickListener
{
  public eod(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    if ((MessageSearchDialog.a(this.a) != null) && (MessageSearchDialog.a(this.a).isShowing())) {
      MessageSearchDialog.a(this.a).dismiss();
    }
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem == null) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 2131231190: 
      paramView = new Bundle();
      paramView.putInt("forward_type", -1);
      paramView.putString("forward_text", ((MessageItem)localObject).a.msg);
      localObject = new Intent(MessageSearchDialog.a(this.a), ForwardRecentActivity.class);
      ((Intent)localObject).putExtras(paramView);
      ((Activity)MessageSearchDialog.a(this.a)).startActivityForResult((Intent)localObject, 21);
      return;
    }
    ((ClipboardManager)MessageSearchDialog.a(this.a).getSystemService("clipboard")).setText(((MessageItem)localObject).a.msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eod
 * JD-Core Version:    0.7.0.1
 */