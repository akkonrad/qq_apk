import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class acbt
  implements Runnable
{
  acbt(acbg paramacbg, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject2;
    ApolloFavActionData localApolloFavActionData;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      localApolloFavActionData = ((ApolloDaoManager)localObject2).a(this.jdField_a_of_type_Long);
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("seq", this.jdField_a_of_type_Long);
          if (localApolloFavActionData != null) {
            continue;
          }
          localJSONObject.put("ret", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "del fav but local has not the action");
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("Q.emoji.web.MessengerService", 2, "delFavAction json error + " + localJSONException.toString());
          return;
          ((ApolloDaoManager)localObject2).b(localApolloFavActionData);
          localJSONException.put("ret", 0);
          MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
          if (localMqqHandler == null) {
            continue;
          }
          Object localObject1 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          ((ApolloInfo)localObject1).a = ((ApolloDaoManager)localObject2).a(this.jdField_a_of_type_Int);
          ((ApolloInfo)localObject1).b = localApolloFavActionData.text;
          ((ApolloInfo)localObject1).d = localApolloFavActionData.textType;
          localObject2 = localMqqHandler.obtainMessage(66);
          ((Message)localObject2).obj = localObject1;
          ((Message)localObject2).arg1 = 1;
          ((Message)localObject2).sendToTarget();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.emoji.web.MessengerService", 2, "del fav action success +" + localJSONException.toString());
          continue;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("delFavAction", localJSONObject.toString());
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
        if (this.jdField_a_of_type_Int == localApolloFavActionData.acitonId) {
          continue;
        }
        localJSONObject.put("ret", 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.web.MessengerService", 2, "del fav action fail +" + localJSONObject.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbt
 * JD-Core Version:    0.7.0.1
 */