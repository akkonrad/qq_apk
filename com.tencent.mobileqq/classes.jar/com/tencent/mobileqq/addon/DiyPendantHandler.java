package com.tencent.mobileqq.addon;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.pendant.DiyAddonPbInfo.AddonGetDiyInfoReq;
import com.tencent.pb.pendant.DiyAddonPbInfo.AddonGetDiyInfoRsp;
import com.tencent.pb.pendant.DiyAddonPbInfo.AddonReqComm;
import com.tencent.pb.pendant.DiyAddonPbInfo.ReadAddonReq;
import com.tencent.pb.pendant.DiyAddonPbInfo.ReadAddonRsp;
import com.tencent.pb.pendant.DiyAddonUser.UserDiyInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiyPendantHandler
  extends BusinessHandler
{
  public DiyPendantHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("ReadDiyAddonInfo.1"))
    {
      bool = paramFromServiceMsg.isSuccess();
      localObject = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      if (QLog.isColorLevel()) {
        QLog.d("DiyPendantHandler", 2, "key_seq=" + (String)localObject + " isSuccess=" + bool + " resultCode=" + paramFromServiceMsg.getResultCode());
      }
      if (bool) {
        paramFromServiceMsg = new DiyAddonPbInfo.ReadAddonRsp();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          boolean bool;
          paramFromServiceMsg = (DiyAddonPbInfo.ReadAddonRsp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg != null) {
            if (paramFromServiceMsg.ret.get() != 0L)
            {
              QLog.d("DiyPendantHandler", 1, "fetch diy pendant info 回包 sso 成功 ，server 失败，ret = " + paramFromServiceMsg.ret.get());
              super.a(paramToServiceMsg, 1, false, null);
              return;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          Object localObject;
          for (;;)
          {
            QLog.e("DiyPendantHandler", 1, "fetch diy pendant info on response err", paramFromServiceMsg);
            paramFromServiceMsg = null;
          }
          if ((paramFromServiceMsg.rspcmd0x01.has()) && (paramFromServiceMsg.rspcmd0x01.userdiyinfo.has()))
          {
            paramObject = paramFromServiceMsg.rspcmd0x01.userdiyinfo.get();
            paramFromServiceMsg = new ArrayList();
            if (paramObject != null)
            {
              paramObject = paramObject.iterator();
              while (paramObject.hasNext())
              {
                localObject = (DiyAddonUser.UserDiyInfo)paramObject.next();
                if ((((DiyAddonUser.UserDiyInfo)localObject).uin.has()) && (((DiyAddonUser.UserDiyInfo)localObject).curid.has()))
                {
                  DiyPendantEntity localDiyPendantEntity = new DiyPendantEntity();
                  localDiyPendantEntity.uinAndDiyId = (((DiyAddonUser.UserDiyInfo)localObject).uin.get() + "_" + ((DiyAddonUser.UserDiyInfo)localObject).curid.get());
                  localDiyPendantEntity.diyId = ((DiyAddonUser.UserDiyInfo)localObject).curid.get();
                  localDiyPendantEntity.borderId = ((DiyAddonUser.UserDiyInfo)localObject).frameid.get();
                  localDiyPendantEntity.updateTs = ((DiyAddonUser.UserDiyInfo)localObject).updatets.get();
                  localDiyPendantEntity.setStickerInfoList(((DiyAddonUser.UserDiyInfo)localObject).stickerinfo.get());
                  paramFromServiceMsg.add(localDiyPendantEntity);
                }
              }
            }
            DiyPendantFetcher.a().a(this.b, true, paramFromServiceMsg);
            super.a(paramToServiceMsg, 1, true, paramFromServiceMsg);
            return;
          }
          super.a(paramToServiceMsg, 1, false, null);
          return;
        }
        super.a(paramToServiceMsg, 1, false, null);
        return;
        super.a(paramToServiceMsg, 1, false, null);
      } while (!QLog.isColorLevel());
      QLog.d("DiyPendantHandler", 2, "DiyText isSuccess is false sso通道  异常");
      return;
    }
    QLog.d("DiyPendantHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
  }
  
  public void a(List paramList, BusinessObserver paramBusinessObserver)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantHandler", 2, "try fetchDiyPendants: " + TextUtils.join(",", paramList));
    }
    DiyAddonPbInfo.AddonReqComm localAddonReqComm = new DiyAddonPbInfo.AddonReqComm();
    localAddonReqComm.platform.set(109L);
    localAddonReqComm.osver.set(Build.VERSION.RELEASE);
    localAddonReqComm.mqqver.set("7.6.3");
    DiyAddonPbInfo.AddonGetDiyInfoReq localAddonGetDiyInfoReq = new DiyAddonPbInfo.AddonGetDiyInfoReq();
    localAddonGetDiyInfoReq.uin.set(paramList);
    paramList = new DiyAddonPbInfo.ReadAddonReq();
    paramList.cmd.set(1);
    paramList.comm.set(localAddonReqComm);
    paramList.packetseq.set(System.currentTimeMillis());
    paramList.reqcmd0x01.set(localAddonGetDiyInfoReq);
    paramBusinessObserver = super.a("ReadDiyAddonInfo.1", paramBusinessObserver);
    paramBusinessObserver.putWupBuffer(paramList.toByteArray());
    super.b(paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantHandler
 * JD-Core Version:    0.7.0.1
 */