import android.os.Bundle;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import java.util.Iterator;
import java.util.List;

class acbi
  implements Runnable
{
  acbi(acbg paramacbg, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject2 = LebaShowListManager.a().a();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = LebaShowListManager.a().a();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (LebaViewItem)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != this.jdField_a_of_type_Int));
    }
    for (int i = ((LebaViewItem)localObject2).jdField_a_of_type_Byte;; i = -1)
    {
      localObject1 = new Bundle();
      if (i == -1)
      {
        ((Bundle)localObject1).putInt("ret", 1);
        if (i != 0) {
          break label171;
        }
      }
      label171:
      for (i = 1;; i = 0)
      {
        ((Bundle)localObject1).putInt("type", i);
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
        ((Bundle)localObject1).putInt("ret", 0);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbi
 * JD-Core Version:    0.7.0.1
 */