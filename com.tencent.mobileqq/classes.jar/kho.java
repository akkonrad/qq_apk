import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;

public final class kho
  implements Runnable
{
  public kho(int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 12) || (this.jdField_a_of_type_Int == 25) || (this.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_Int == 43) || (this.jdField_a_of_type_Int == 56)) {
      VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
    int i = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).j();
    Object localObject;
    if (i == 2)
    {
      if ((this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 24)) || (this.jdField_a_of_type_JavaLangString == null) || (!LightalkBlueTipsBar.a())) {
        break label416;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      if (((SharedPreferences)localObject).getBoolean("lightalk_tip_" + this.b, false)) {
        break label416;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightalkBlueTipsBar", 2, "addBubbleVideoMsg() : TYPE_ON_SHOW =====>");
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("lightalk_tip_" + this.b, true);
      ((SharedPreferences.Editor)localObject).putString("Lightalk_tips_frdUin", this.c);
      ((SharedPreferences.Editor)localObject).commit();
    }
    label416:
    for (i = 1;; i = 0)
    {
      int j = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int k = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 6, true, null);
      if ((j != 0) && (j != k))
      {
        k = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (((j == 0) || (k == 0)) || ((!this.jdField_a_of_type_Boolean) && (i == 0)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          i = ((SharedPreferences)localObject).getInt("funcall_tip_" + this.c, 0);
          if (i < 3)
          {
            localObject = ((SharedPreferences)localObject).edit();
            ((SharedPreferences.Editor)localObject).putInt("funcall_tip_" + this.c, i + 1);
            ((SharedPreferences.Editor)localObject).commit();
          }
        }
      }
      return;
      if (i != 3) {
        break;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kho
 * JD-Core Version:    0.7.0.1
 */