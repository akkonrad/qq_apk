import com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame.TroopListAdapter;
import com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask;
import java.util.Comparator;

public class ewh
  implements Comparator
{
  private ewh(TroopListInnerFrame.TroopListAdapter paramTroopListAdapter) {}
  
  public int a(TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask paramTroopListItemWithMask1, TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask paramTroopListItemWithMask2)
  {
    return paramTroopListItemWithMask1.a - paramTroopListItemWithMask2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewh
 * JD-Core Version:    0.7.0.1
 */