import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import java.util.ArrayList;
import java.util.Iterator;

public class ajoe
  implements Runnable
{
  public ajoe(TroopAppMgr paramTroopAppMgr, ArrayList paramArrayList, EntityManager paramEntityManager) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, localTroopAIOAppInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoe
 * JD-Core Version:    0.7.0.1
 */