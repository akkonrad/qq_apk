import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class vrh
  extends SosoInterface.OnLocationListener
{
  public vrh(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onLocationFinish(): BEGIN errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString == null) {
        break label169;
      }
    }
    label169:
    for (String str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "onLocationFinish() latitude=" + paramSosoLbsInfo.a.a + ", longitude=" + paramSosoLbsInfo.a.a + ", address=" + str);
      }
      ((EnterpriseQQHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramSosoLbsInfo.a.a, paramSosoLbsInfo.a.jdField_b_of_type_Double, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrh
 * JD-Core Version:    0.7.0.1
 */