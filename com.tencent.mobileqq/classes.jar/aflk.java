import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class aflk
  implements Runnable
{
  aflk(aflj paramaflj, List paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    List localList = NearbyMomentManager.a(this.jdField_a_of_type_Aflj.a, this.jdField_a_of_type_JavaUtilList);
    Object localObject;
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyMomentManager", 2, "momentFeedInfoList is null");
      }
      localObject = new ArrayList();
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new afll(this, (List)localObject));
      return;
      localObject = localList;
      if (QLog.isColorLevel())
      {
        QLog.i("NearbyMomentManager", 2, "momentFeedInfoList, size=" + this.jdField_a_of_type_JavaUtilList.size());
        localObject = localList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aflk
 * JD-Core Version:    0.7.0.1
 */