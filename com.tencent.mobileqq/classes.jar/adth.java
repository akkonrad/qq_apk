import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

public class adth
  extends WtloginListener
{
  public adth(LoginKeyHelper paramLoginKeyHelper, String paramString) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    super.OnException(paramErrMsg, paramInt, paramWUserSigInfo);
    if (QLog.isColorLevel()) {
      QLog.i("XProxy", 2, "获取Now结合版A1票据返回异常，cmd = " + paramInt + " errmsg = " + paramErrMsg.getMessage());
    }
    LoginKeyHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper, this.jdField_a_of_type_JavaLangString, false, paramInt);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$AccountInfo.a = this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.jdField_a_of_type_Long = System.currentTimeMillis();
      LoginKeyHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper, this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("XProxy", 2, "获取Now结合版A1票据返回失败，retCode = " + paramInt2);
    }
    LoginKeyHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper, this.jdField_a_of_type_JavaLangString, false, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adth
 * JD-Core Version:    0.7.0.1
 */