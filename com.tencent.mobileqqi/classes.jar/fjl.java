import com.tencent.mobileqq.app.QPSafeCheckHandler;
import com.tencent.mobileqq.app.SafeCenterPushHandler;

public class fjl
  extends Thread
{
  public fjl(QPSafeCheckHandler paramQPSafeCheckHandler, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    SafeCenterPushHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQPSafeCheckHandler.b(this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjl
 * JD-Core Version:    0.7.0.1
 */