import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import java.util.Iterator;
import java.util.List;

public class vyi
  implements Runnable
{
  public vyi(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    if (PublicAccountManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != 0L) {}
    for (;;)
    {
      return;
      Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (((localObject2 instanceof MessageForStructing)) || ((localObject2 instanceof MessageForPubAccount)))
          {
            localObject2 = ((ChatMessage)localObject2).getExtInfoFromExtStr("pa_msgId");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              try
              {
                long l = Long.parseLong((String)localObject2);
                if (l > 0L)
                {
                  PublicAccountManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, l);
                  return;
                }
              }
              catch (Exception localException) {}
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyi
 * JD-Core Version:    0.7.0.1
 */