package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileInfoRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.RspBody;

public abstract class TroopFileProtocol$GetOneFileInfoObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0) {
      a(false, paramInt, null);
    }
    for (;;)
    {
      return;
      paramBundle = new oidb_0x6d8.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d8.GetFileInfoRspBody)paramBundle.file_info_rsp.get();
        if (!paramArrayOfByte.int32_ret_code.has()) {
          break label103;
        }
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          paramArrayOfByte = (group_file_common.FileInfo)paramArrayOfByte.file_info.get();
          if (paramArrayOfByte == null) {
            continue;
          }
          a(true, 0, paramArrayOfByte);
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, null);
        return;
      }
    }
    a(false, paramArrayOfByte.int32_ret_code.get(), null);
    return;
    label103:
    a(false, -1, null);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol.GetOneFileInfoObserver
 * JD-Core Version:    0.7.0.1
 */