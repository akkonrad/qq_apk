import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class os
  implements BusinessObserver
{
  public os(Context paramContext, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362453);
    }
    for (;;)
    {
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          ((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).mergeFrom(paramBundle);
          if ((((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).ret_info.has()) && (((mobileqq_mp.RetInfo)((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get() == 0))
          {
            paramBundle = new AccountDetail((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject);
            localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).createEntityManager();
            if (localObject != null) {
              ((EntityManager)localObject).b(paramBundle);
            }
          }
          else
          {
            PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362453);
          }
        }
        else
        {
          PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362453);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     os
 * JD-Core Version:    0.7.0.1
 */