import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class smx
  extends FavEmoRoamingObserver
{
  public smx(FavEmosmManageActivity paramFavEmosmManageActivity) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.app.removeObserver(this);
    this.a.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smx
 * JD-Core Version:    0.7.0.1
 */