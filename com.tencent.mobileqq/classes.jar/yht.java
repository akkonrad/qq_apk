import android.text.TextUtils;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.PhoneContactAddMessage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yht
  implements Runnable
{
  public yht(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    ArrayList localArrayList;
    MessageForSystemMsg localMessageForSystemMsg;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      l = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      List localList = this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0, l);
      localArrayList = new ArrayList(localList.size());
      if ((localList == null) || (localList.size() <= 0)) {
        break label447;
      }
      int i = localList.size() - 1;
      if (i < 0) {
        break label447;
      }
      ??? = (MessageRecord)localList.get(i);
      if ((??? instanceof MessageForSystemMsg))
      {
        localMessageForSystemMsg = (MessageForSystemMsg)???;
        if (localMessageForSystemMsg.structMsg == null) {
          localMessageForSystemMsg.parse();
        }
        if ((localMessageForSystemMsg.structMsg.msg.sub_type.get() != 13) || (!NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter).b(String.valueOf(localMessageForSystemMsg.structMsg.req_uin.get())))) {}
      }
      else
      {
        i -= 1;
      }
    }
    String str;
    Object localObject3;
    if ((localMessageForSystemMsg.structMsg.msg.uint32_source_flag.get() & 0x8) == 8)
    {
      ??? = "";
      str = localMessageForSystemMsg.structMsg.msg.msg_source.get();
      l = localMessageForSystemMsg.structMsg.msg.uint64_discuss_uin.get();
      if (l != 0L)
      {
        ??? = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l));
        if (TextUtils.isEmpty((CharSequence)???))
        {
          localObject3 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
          if (localObject3 != null) {
            ((DiscussionHandler)localObject3).a(l);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        if (??? != null) {
          continue;
        }
        localObject3 = "";
        localConcurrentHashMap.put(Long.valueOf(l), localObject3);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "NewFriendMoreSysMsgAdapter source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(localMessageForSystemMsg.structMsg.msg.uint32_source_flag.get()), Long.valueOf(l), ???, str }));
      }
      localArrayList.add(new FriendSystemMessage(localMessageForSystemMsg));
      break;
      localObject3 = ???;
    }
    label447:
    ??? = NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter).a(true);
    if (((ArrayList)???).size() > 0) {
      localArrayList.addAll((Collection)???);
    }
    ??? = NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter).c();
    if ((??? != null) && (!((ArrayList)???).isEmpty()))
    {
      ??? = ((ArrayList)((ArrayList)???).clone()).iterator();
      while (((Iterator)???).hasNext()) {
        localArrayList.add(new PhoneContactAddMessage((PhoneContactAdd)((Iterator)???).next()));
      }
    }
    Collections.sort(localArrayList, NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter));
    this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new yhu(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yht
 * JD-Core Version:    0.7.0.1
 */