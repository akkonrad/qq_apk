import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloViewController.PlayActionData;
import com.tencent.util.WeakReferenceHandler;

public class yue
  implements OnApolloViewListener
{
  public yue(ApolloViewController paramApolloViewController, DisplayMetrics paramDisplayMetrics, ApolloViewController.PlayActionData paramPlayActionData) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.b != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a != null) && (ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController) != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.b.onExecDispose();
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a.onExecDispose();
      Message localMessage = ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).obtainMessage(19, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData.c, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData.jdField_b_of_type_Float);
      }
      ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yue
 * JD-Core Version:    0.7.0.1
 */