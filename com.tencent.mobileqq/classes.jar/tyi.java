import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class tyi
  implements Runnable
{
  tyi(tyh paramtyh, TroopUploadingThread.UploadState paramUploadState) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Tyh.a.c) {}
    do
    {
      return;
      this.jdField_a_of_type_Tyh.a.o();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a == 1)
      {
        this.jdField_a_of_type_Tyh.a.m();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 2);
    String str = AvatarWallAdapter.a(this.jdField_a_of_type_Tyh.a.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b);
    QQToast.a(BaseApplication.getContext(), 1, str, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tyi
 * JD-Core Version:    0.7.0.1
 */