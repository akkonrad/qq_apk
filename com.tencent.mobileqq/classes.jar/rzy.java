import android.database.Cursor;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import mqq.os.MqqHandler;

public class rzy
  implements Runnable
{
  public rzy(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject1;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject1 = "ORDER BY time asc , longMsgIndex asc";
    }
    for (;;)
    {
      int i = this.b;
      label68:
      Object localObject3;
      String str;
      if (this.b < this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.l)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.d = true;
        localObject1 = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + (String)localObject1 + " limit " + i + "," + String.valueOf(8);
        localObject3 = MessageRecord.getTableName(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        str = MessageRecord.getOldTableName(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      }
      try
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.d) {}
        for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a((String)localObject3, str, (String)localObject1);; localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.a((String)localObject3, (String)localObject1))
        {
          localObject3 = localObject1;
          if (localObject1 != null)
          {
            ((Cursor)localObject1).getCount();
            localObject3 = localObject1;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(8);
          ((Message)localObject1).obj = localObject3;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject1);
          return;
          localObject1 = "ORDER BY shmsgseq";
          break;
          localObject1 = "ORDER BY shmsgseq";
          break;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.d = false;
          i = this.b - this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.l;
          break label68;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager == null) {
            break label306;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = null;
          continue;
          label306:
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzy
 * JD-Core Version:    0.7.0.1
 */