import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

public class zil
  implements Runnable
{
  public zil(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).iterator();
      if (localIterator.hasNext()) {
        ((PhoneContactManager.IPhoneContactListener)localIterator.next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zil
 * JD-Core Version:    0.7.0.1
 */