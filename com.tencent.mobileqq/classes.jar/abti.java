import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;

public class abti
  implements Runnable
{
  public abti(ContactSyncManager paramContactSyncManager) {}
  
  public void run()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ContactSync.Manager", 2, "onQQContactRefreshed | syncAllContacts exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abti
 * JD-Core Version:    0.7.0.1
 */