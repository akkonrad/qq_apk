import PersonalState.UserProfile;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.Comparator;

public class gmo
  implements Comparator
{
  public gmo(StatusManager paramStatusManager) {}
  
  public int a(UserProfile paramUserProfile1, UserProfile paramUserProfile2)
  {
    return (int)(paramUserProfile2.richTime - paramUserProfile1.richTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gmo
 * JD-Core Version:    0.7.0.1
 */