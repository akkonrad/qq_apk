import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;
import java.util.Comparator;

public class zfo
  implements Comparator
{
  public zfo(HotchatSCMng paramHotchatSCMng) {}
  
  public int a(HotchatSCMng.HotchatNote paramHotchatNote1, HotchatSCMng.HotchatNote paramHotchatNote2)
  {
    if ((paramHotchatNote1 == null) || (paramHotchatNote2 == null)) {}
    do
    {
      return 0;
      if (paramHotchatNote1.a > paramHotchatNote2.a) {
        return 1;
      }
    } while (paramHotchatNote1.a >= paramHotchatNote2.a);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zfo
 * JD-Core Version:    0.7.0.1
 */