import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import java.util.List;

public class abzx
  extends FavEmoRoamingObserver
{
  public abzx(FavroamingManager paramFavroamingManager) {}
  
  public void a(List paramList)
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.removeObserver(FavroamingManager.a(this.a));
    ThreadManager.post(new abzy(this, paramList), 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a == null) {}
    while (!paramBoolean) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abzx
 * JD-Core Version:    0.7.0.1
 */