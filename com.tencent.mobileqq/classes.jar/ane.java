import com.qq.im.poi.LbsPackManager;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARMapEngine;

public class ane
  implements Runnable
{
  public ane(LbsPackManager paramLbsPackManager, ARMapActivity paramARMapActivity, String paramString) {}
  
  public void run()
  {
    ARMapEngine localARMapEngine = this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a;
    ARMapEngine.nativeRequestLbsPOIListByPid(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ane
 * JD-Core Version:    0.7.0.1
 */