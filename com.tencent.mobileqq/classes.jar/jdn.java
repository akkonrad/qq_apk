import com.tencent.av.VideoController;
import com.tencent.av.utils.PhoneStatusMonitor;

public class jdn
  implements Runnable
{
  public jdn(VideoController paramVideoController) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = new jdy(this.a);
    this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor = new PhoneStatusMonitor(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdn
 * JD-Core Version:    0.7.0.1
 */