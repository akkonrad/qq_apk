import android.os.Bundle;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONObject;

public class yqc
  implements Runnable
{
  public yqc(CmGameServerQIPCModule paramCmGameServerQIPCModule, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      if (localJSONObject != null)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("resData", localJSONObject.toString());
        localObject = EIPCResult.createSuccessResult((Bundle)localObject);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessCmGameServerQIPCModule.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_GET_ACTION_DATA callbackResult retJson:" + localJSONObject });
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameServerQIPCModule", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqc
 * JD-Core Version:    0.7.0.1
 */