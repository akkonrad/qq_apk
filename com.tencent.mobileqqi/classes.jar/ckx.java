import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;

public class ckx
  extends TroopQZoneUploadAlbumObserver
{
  public ckx(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return;
    }
    paramObject = (String)paramObject;
    this.a.a(8, paramObject, -2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ckx
 * JD-Core Version:    0.7.0.1
 */