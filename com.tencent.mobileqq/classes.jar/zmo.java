import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import java.util.HashMap;

public class zmo
  implements Runnable
{
  public zmo(RouterHandler paramRouterHandler, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    Session localSession = (Session)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.get(Long.valueOf(this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(1, localSession, (float)((float)this.b * 1.0D / (float)this.c), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zmo
 * JD-Core Version:    0.7.0.1
 */