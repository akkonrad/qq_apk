import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class ztb
  implements Runnable
{
  public ztb(DatalineMessageManager paramDatalineMessageManager, DataLineMsgRecord paramDataLineMsgRecord, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time = MessageCache.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq = ((int)this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time);
      }
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_Int);
      localRecentUser.type = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_Int;
      localRecentUser.lastmsgtime = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time;
      localRecentUserProxy.a(localRecentUser);
      DatalineMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, localEntityManager);
      long l = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
      localEntityManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l);
      }
      return;
    }
    finally
    {
      localEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ztb
 * JD-Core Version:    0.7.0.1
 */