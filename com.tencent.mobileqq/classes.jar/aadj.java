import com.tencent.mobileqq.ar.FaceUIController;
import com.tencent.mobileqq.ar.ObjectBaseData;
import com.tencent.mobileqq.ar.ObjectSurfaceView;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.BaikeClickListener;
import com.tencent.qphone.base.util.QLog;

public class aadj
  implements ARTipsManager.BaikeClickListener
{
  public aadj(ObjectSurfaceView paramObjectSurfaceView, ObjectBaseData paramObjectBaseData) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "onContentClick wikiurl = " + this.jdField_a_of_type_ComTencentMobileqqArObjectBaseData.c);
    }
    ObjectSurfaceView.b(this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView, this.jdField_a_of_type_ComTencentMobileqqArObjectBaseData.c);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadj
 * JD-Core Version:    0.7.0.1
 */