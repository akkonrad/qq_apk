import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

public class scg
  extends MessageObserver
{
  public scg(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.c(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.d(this.a);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "onInsertIntoBlackList, isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.d(this.a)))) {
        ChatSettingActivity.a(this.a, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "onInsertIntoBlackList, mIsShield=" + ChatSettingActivity.a(this.a));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131434510, 1);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.c(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "onRemoveFromBlackList, isSuccess=" + paramBoolean);
    }
    ChatSettingActivity.d(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.d(this.a)))) {
        ChatSettingActivity.a(this.a, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "onRemoveFromBlackList, mIsShield=" + ChatSettingActivity.a(this.a));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131434510, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scg
 * JD-Core Version:    0.7.0.1
 */