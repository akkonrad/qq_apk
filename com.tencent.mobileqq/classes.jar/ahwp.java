import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.TroopBatchAddFrdsSearchModelMember;
import com.tencent.mobileqq.search.searchengine.TroopBatchAddFrdsMultipleSearchEngine;
import java.util.Comparator;

public class ahwp
  implements Comparator
{
  public ahwp(TroopBatchAddFrdsMultipleSearchEngine paramTroopBatchAddFrdsMultipleSearchEngine) {}
  
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i = -1;
    paramIContactSearchModel1 = (TroopBatchAddFrdsSearchModelMember)paramIContactSearchModel1;
    paramIContactSearchModel2 = (TroopBatchAddFrdsSearchModelMember)paramIContactSearchModel2;
    FriendsManager localFriendsManager = (FriendsManager)this.a.a.getManager(50);
    boolean bool1 = localFriendsManager.b((String)paramIContactSearchModel1.a());
    boolean bool2 = localFriendsManager.b((String)paramIContactSearchModel2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localFriendsManager.c((String)paramIContactSearchModel1.a());
      bool2 = localFriendsManager.c((String)paramIContactSearchModel2.a());
      if ((!bool1) && (!bool2)) {
        return paramIContactSearchModel2.e() - paramIContactSearchModel1.e();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return paramIContactSearchModel2.e() - paramIContactSearchModel1.e();
    }
    if (bool1 != bool2)
    {
      if (bool2) {}
      for (;;)
      {
        return i;
        i = 1;
      }
    }
    return paramIContactSearchModel2.e() - paramIContactSearchModel1.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahwp
 * JD-Core Version:    0.7.0.1
 */