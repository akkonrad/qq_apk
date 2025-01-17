package cooperation.qzone.gift;

import NS_MOBILE_TEMPLATE_GIFT.template_gift_get_send_status_rsp;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class QZoneCheckSendGiftServlet
  extends MSFServlet
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0))
    {
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), QZoneCheckSendGiftServlet.class);
      localNewIntent.putExtra("param_req_type", 110);
      localNewIntent.putExtra("ownUin", paramLong);
      localNewIntent.putExtra("friendList", paramArrayOfLong);
      paramQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = QZoneCheckSendGiftRequest.a(paramFromServiceMsg.getWupBuffer());
      if (paramFromServiceMsg != null)
      {
        long l = paramFromServiceMsg.uin;
        paramFromServiceMsg = paramFromServiceMsg.map_birth_friend_list_state;
        ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)getAppRuntime().getManager(84);
        if (localActivateFriendsManager != null) {
          localActivateFriendsManager.a(l, paramFromServiceMsg, 2);
        }
        notifyObserver(paramIntent, 110, true, null, ActivateFriendsObserver.class);
        QLog.i("QZoneCheckSendGiftServlet", 1, "onReceive success, friendMap size =" + paramFromServiceMsg.size());
        return;
      }
      QLog.i("QZoneCheckSendGiftServlet", 1, "onReceive response == null.");
      return;
    }
    if (paramFromServiceMsg == null)
    {
      QLog.e("QZoneCheckSendGiftServlet", 1, "onReceive fail, fromServiceMsg == null");
      return;
    }
    QLog.e("QZoneCheckSendGiftServlet", 1, "onReceive fail, the resultCode is " + paramFromServiceMsg.getResultCode());
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("ownUin", 0L);
    paramIntent = paramIntent.getLongArrayExtra("friendList");
    Object localObject = new ArrayList();
    int j;
    int i;
    if ((paramIntent != null) && (paramIntent.length > 0))
    {
      j = paramIntent.length;
      i = 0;
    }
    while (i < j)
    {
      ((ArrayList)localObject).add(Long.valueOf(paramIntent[i]));
      i += 1;
      continue;
      QLog.i("QZoneCheckSendGiftServlet", 1, "the friendList is null or it's length is zero");
    }
    QZoneCheckSendGiftRequest localQZoneCheckSendGiftRequest = new QZoneCheckSendGiftRequest(Long.valueOf(l).longValue(), new ArrayList((Collection)localObject), null);
    localObject = localQZoneCheckSendGiftRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(10000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localQZoneCheckSendGiftRequest.uniKey());
    paramPacket.putSendData(paramIntent);
    QLog.i("QZoneCheckSendGiftServlet", 1, "onSend success.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.gift.QZoneCheckSendGiftServlet
 * JD-Core Version:    0.7.0.1
 */