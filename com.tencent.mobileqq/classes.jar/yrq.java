import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class yrq
  extends WtloginObserver
{
  public int a;
  public int b;
  
  public yrq(CmGameMainManager paramCmGameMainManager) {}
  
  public void OnGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      paramString = util.buf_to_string(paramArrayOfByte2);
      if (QLog.isColorLevel()) {
        QLog.i("cmgame_process.CmGameMainManager", 2, "OnGetOpenKeyWithoutPasswd token:" + paramString);
      }
      paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.a();
      if (paramArrayOfByte1 != null) {
        break label57;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label57:
        paramArrayOfByte2 = new JSONObject();
        paramArrayOfByte2.put("appId", paramLong2);
        paramArrayOfByte2.put("gameId", this.jdField_a_of_type_Int);
        paramArrayOfByte2.put("openKey", paramString);
        CmGameCmdChannel.a(paramArrayOfByte1).a(0, "cs.on_get_open_key.local", paramArrayOfByte2.toString(), this.b);
        paramArrayOfByte1 = ((ApolloDaoManager)paramArrayOfByte1.getManager(154)).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.a.game.gameId);
        if (paramArrayOfByte1 != null)
        {
          paramArrayOfByte1.openKey = paramString;
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "OpenKeyObserver error:", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yrq
 * JD-Core Version:    0.7.0.1
 */