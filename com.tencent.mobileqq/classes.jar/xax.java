import Wallet.WalletSkinRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler.SkinListener;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class xax
  implements BusinessObserver
{
  public xax(QWalletSkinHandler paramQWalletSkinHandler, QWalletSkinHandler.SkinListener paramSkinListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (WalletSkinRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("QWalletSkinHandler", 2, "updateCurWalletSkin get rsp:" + paramBundle + "|" + paramBoolean);
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      if (paramBundle.status == 0)
      {
        QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, 0);
        QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener);
      return;
    }
    QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xax
 * JD-Core Version:    0.7.0.1
 */