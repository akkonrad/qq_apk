import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;
import com.tencent.av.ui.redbag.ResultData;

public class kee
  implements Runnable
{
  public kee(AVRedBagMgr.TestFlag paramTestFlag, AVRedBagMgr paramAVRedBagMgr) {}
  
  public void run()
  {
    ResultData localResultData = new ResultData(this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a, this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a().getCurrentAccountUin(), this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a());
    localResultData.c = this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.a;
    localResultData.d = this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.b;
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a(this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a(), localResultData, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kee
 * JD-Core Version:    0.7.0.1
 */