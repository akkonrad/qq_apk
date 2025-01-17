package com.tencent.mobileqq.apollo.process.sso;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class CmGameServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServlet", 2, "[onReceive]");
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      Object localObject = CmGameUtil.a();
      if (localObject == null) {
        QLog.e("cmgame_process.CmGameServlet", 1, "app is null.");
      }
      do
      {
        return;
        localObject = (CmGameSSoHandler)((AppInterface)localObject).getBusinessHandler(0);
      } while (localObject == null);
      ((CmGameSSoHandler)localObject).a(paramIntent, paramFromServiceMsg, arrayOfByte);
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServlet", 2, "[onSend]");
    }
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    if (!TextUtils.isEmpty(str))
    {
      paramPacket.setSSOCommand(str);
      paramPacket.setTimeout(l);
      if (arrayOfByte != null)
      {
        paramIntent = new byte[arrayOfByte.length + 4];
        PkgTools.a(paramIntent, 0, arrayOfByte.length + 4);
        PkgTools.a(paramIntent, 4, arrayOfByte, arrayOfByte.length);
        paramPacket.putSendData(paramIntent);
      }
    }
    else
    {
      return;
    }
    paramIntent = new byte[4];
    PkgTools.a(paramIntent, 0, 4L);
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.sso.CmGameServlet
 * JD-Core Version:    0.7.0.1
 */