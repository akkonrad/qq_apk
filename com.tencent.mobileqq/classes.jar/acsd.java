import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import java.util.LinkedHashMap;

class acsd
  implements Runnable
{
  acsd(acsc paramacsc, LinkedHashMap paramLinkedHashMap, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acsc.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_Acsc.a.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    this.jdField_a_of_type_Acsc.a.i();
    if ((this.jdField_a_of_type_Int == -1) || (this.b == -1))
    {
      this.jdField_a_of_type_Acsc.a.setSelect(0);
      return;
    }
    if ((this.jdField_a_of_type_Acsc.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) || (this.jdField_a_of_type_Acsc.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.h()))
    {
      this.jdField_a_of_type_Acsc.a.setPos(this.jdField_a_of_type_Int, this.b);
      return;
    }
    this.jdField_a_of_type_Acsc.a.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsd
 * JD-Core Version:    0.7.0.1
 */