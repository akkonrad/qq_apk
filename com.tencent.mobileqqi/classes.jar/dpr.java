import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class dpr
  implements BusinessObserver
{
  public dpr(SplashActivity paramSplashActivity, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("SplashActivity", 2, "success:" + String.valueOf(paramBoolean));
    if (!paramBoolean) {}
    do
    {
      for (;;)
      {
        return;
        if (paramBoolean) {
          try
          {
            paramBundle = paramBundle.getByteArray("data");
            if (paramBundle != null)
            {
              mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
              localFollowResponse.mergeFrom(paramBundle);
              paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
              if (paramInt == 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a(), 0).edit().putBoolean(String.valueOf(this.jdField_a_of_type_Int), true).commit();
                return;
              }
            }
          }
          catch (Exception paramBundle)
          {
            return;
          }
        }
      }
    } while (paramInt != 58);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dpr
 * JD-Core Version:    0.7.0.1
 */