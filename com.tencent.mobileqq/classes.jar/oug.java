import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.ErrMsg;

public class oug
  extends WtloginObserver
{
  public oug(QRLoginActivity paramQRLoginActivity) {}
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginActivity", 2, "OnCloseCode userAccount=" + paramString + " ret=" + paramInt);
    }
    paramArrayOfByte1 = null;
    paramString = paramArrayOfByte1;
    if (paramInt == 0)
    {
      paramString = paramArrayOfByte1;
      if (paramWUserSigInfo != null) {
        paramString = WtloginHelper.getLoginTlvValue(paramWUserSigInfo, 54);
      }
    }
    paramArrayOfByte1 = new Message();
    paramWUserSigInfo = new Bundle();
    paramWUserSigInfo.putInt("ret", paramInt);
    paramWUserSigInfo.putByteArray("errMsg", paramArrayOfByte2);
    if (paramString != null) {
      paramWUserSigInfo.putByteArray("devInfo", paramString);
    }
    paramArrayOfByte1.setData(paramWUserSigInfo);
    paramArrayOfByte1.what = 2;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayOfByte1);
  }
  
  public void OnException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginActivity", 2, "OnException e=" + paramString);
    }
    paramString = new Message();
    paramString.what = 3;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginActivity", 2, "OnVerifyCode userAccount=" + paramString + " ret=" + paramInt);
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.jdField_a_of_type_JavaLangString = paramString;
    paramErrMsg = null;
    paramString = paramErrMsg;
    if (paramArrayList != null)
    {
      paramString = paramErrMsg;
      if (paramArrayList.size() > 0)
      {
        paramString = new ByteArrayOutputStream();
        int i = 0;
        for (;;)
        {
          if (i < paramArrayList.size()) {
            try
            {
              paramString.write(HexUtil.hexStr2Bytes((String)paramArrayList.get(i)));
              i += 1;
            }
            catch (Throwable paramErrMsg)
            {
              for (;;)
              {
                paramErrMsg.printStackTrace();
              }
            }
          }
        }
        paramString = paramString.toByteArray();
      }
    }
    paramArrayList = new Message();
    paramErrMsg = new Bundle();
    paramErrMsg.putInt("ret", paramInt);
    paramErrMsg.putByteArray("tlv", paramString);
    paramErrMsg.putByteArray("appName", paramArrayOfByte1);
    paramErrMsg.putByteArray("errMsg", paramArrayOfByte2);
    paramArrayList.setData(paramErrMsg);
    paramArrayList.what = 1;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oug
 * JD-Core Version:    0.7.0.1
 */