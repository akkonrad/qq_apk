import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class zco
  implements Runnable
{
  public zco(DataLineHandler paramDataLineHandler, FromServiceMsg paramFromServiceMsg, int paramInt, long paramLong) {}
  
  public void run()
  {
    cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null) {}
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b.a().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
      if (localObject != null) {
        break;
      }
      return;
      localObject = null;
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer() != null)
      {
        int i = this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer().length - 4;
        if (i >= 0)
        {
          localObject = new byte[i];
          PkgTools.a((byte[])localObject, 0, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer(), 4, i);
        }
      }
      else if (localObject != null)
      {
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
    if (localRspBody.msg_file_query_rsp.int32_ret_code.get() == 0)
    {
      localRspBody.msg_file_query_rsp.msg_file_info.str_file_name.get();
      localRspBody.msg_file_query_rsp.msg_file_info.uint64_file_size.get();
      localInvalidProtocolBufferMicroException.md5 = localRspBody.msg_file_query_rsp.msg_file_info.bytes_10m_md5.get().toByteArray();
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b.a().a(this.jdField_a_of_type_Int).a(localInvalidProtocolBufferMicroException.msgId, localInvalidProtocolBufferMicroException.serverPath, localInvalidProtocolBufferMicroException.md5);
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(localInvalidProtocolBufferMicroException);
      return;
    }
    DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler, localInvalidProtocolBufferMicroException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zco
 * JD-Core Version:    0.7.0.1
 */