import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.qphone.base.util.QLog;

class adrx
  implements Runnable
{
  adrx(adrw paramadrw) {}
  
  public void run()
  {
    PresenceInterfaceImpl.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicPresenceInterfaceImpl, true);
    PresenceInterfaceImpl.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.a.jdField_a_of_type_ComTencentMobileqqHotpicPresenceInterfaceImpl.a.b(-11);
    QLog.d("PresenceInterfaceImpl", 2, "saveUserPermission false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrx
 * JD-Core Version:    0.7.0.1
 */