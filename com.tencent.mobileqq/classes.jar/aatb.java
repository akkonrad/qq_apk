import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class aatb
  implements aath
{
  public aatb(ArkAppCGI paramArkAppCGI, aatj paramaatj) {}
  
  public void a(aati paramaati, boolean paramBoolean, byte[] arg3)
  {
    if ((paramBoolean) && (??? != null)) {
      ArkAppCGI.a(this.jdField_a_of_type_Aatj, ???);
    }
    synchronized (this.jdField_a_of_type_Aatj)
    {
      this.jdField_a_of_type_Aatj.jdField_a_of_type_JavaUtilArrayList.remove(paramaati);
      paramBoolean = this.jdField_a_of_type_Aatj.jdField_a_of_type_JavaUtilArrayList.isEmpty();
      if (paramBoolean) {
        this.jdField_a_of_type_Aatj.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback.a(true, this.jdField_a_of_type_Aatj.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aatj.b);
      }
      return;
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("queryActionAppNeedUpdate, subTask fail", new Object[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aatb
 * JD-Core Version:    0.7.0.1
 */