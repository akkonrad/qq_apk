import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayBasePanel;
import com.tencent.qphone.base.util.QLog;

class afcq
  implements Runnable
{
  afcq(afcp paramafcp, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Afcp.a.e == 1) {}
    do
    {
      return;
      if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Afcp.a) != null)
      {
        NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Afcp.a).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "mDisplayModel == null ！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afcq
 * JD-Core Version:    0.7.0.1
 */