import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqUploadFileObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class ajpd
  extends TroopFileProtocol.ReqUploadFileObserver
{
  public ajpd(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      String str = paramBundle.getString("itemKey");
      if (str == null) {
        return;
      }
      paramBundle = UUID.fromString(str);
      try
      {
        paramBundle = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(paramBundle);
        if (paramBundle == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + str);
          }
          TroopTechReportUtils.a(TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.q);
          return;
        }
      }
      finally {}
    }
    finally {}
    if (!paramBoolean)
    {
      ReportController.b((QQAppInterface)this.b.get(), "P_CliOper", "Grp_files", "", "file", "fail_upload", 0, 0, l + "", "", "", "");
      paramUploadFileRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.f, 3, 207);
      this.a.a(paramBundle, 3, paramUploadFileRspBody);
      if (QLog.isDevelopLevel()) {
        QLog.w("TroopFileTransferManager", 2, "onReqResendFileResult,errCode=" + paramInt);
      }
      TroopTechReportUtils.a(TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.v);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopFileTransferManager", 4, String.format("onRspUpload - retCode: %d", new Object[] { Integer.valueOf(i) }));
    }
    if (i < 0)
    {
      paramInt = 207;
      switch (i)
      {
      default: 
      case -134: 
      case -1: 
      case -107: 
      case -102: 
      case -2: 
      case -36: 
      case -20001: 
      case -20000: 
      case -403: 
      case -25126: 
      case -312: 
      case -136: 
      case -139: 
      case -138: 
        for (;;)
        {
          paramUploadFileRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.f, 3, paramInt);
          this.a.a(paramBundle, 3, paramUploadFileRspBody);
          TroopTechReportUtils.a(TroopTechReportUtils.TroopFileReportResultCode.c, i);
          return;
          paramInt = 202;
          continue;
          paramInt = 208;
          continue;
          new Handler(Looper.getMainLooper()).postDelayed(new ajpe(this, paramBundle), 1000L);
          return;
          if (paramBundle.BusId != 104)
          {
            paramBundle.BusId = 104;
            this.a.b(paramBundle);
            return;
          }
          paramInt = 204;
          continue;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
        }
      }
      paramUploadFileRspBody = paramUploadFileRspBody.str_client_wording.get();
      paramUploadFileRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.f, 3, 704, paramUploadFileRspBody);
      this.a.a(paramBundle, 3, paramUploadFileRspBody);
      return;
    }
    paramBundle.FilePath = paramUploadFileRspBody.str_file_id.get();
    paramBundle.UploadIp = paramUploadFileRspBody.str_upload_ip.get();
    paramBundle.CheckKey = paramUploadFileRspBody.bytes_check_key.get().toByteArray();
    paramBundle.BusId = paramUploadFileRspBody.uint32_bus_id.get();
    if (!this.a.a(paramBundle)) {
      this.a.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool[2].a(new TroopFileTransferManager.TaskHttpUpload(this.a, paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpd
 * JD-Core Version:    0.7.0.1
 */