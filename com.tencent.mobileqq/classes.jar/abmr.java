import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class abmr
  implements Runnable
{
  public abmr(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.d(this.a.jdField_a_of_type_JavaLangString);
    if (this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
      this.a.runOnUiThread(new abms(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abmr
 * JD-Core Version:    0.7.0.1
 */