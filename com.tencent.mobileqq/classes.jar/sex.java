import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.vas.VasExtensionObserver;

public class sex
  extends VasExtensionObserver
{
  public sex(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sex
 * JD-Core Version:    0.7.0.1
 */