import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.nearby.NearbyProxy;

public class aemr
  implements Runnable
{
  public aemr(NearbyProxy paramNearbyProxy, Context paramContext) {}
  
  public void run()
  {
    ((NowProxy)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy.a.getManager(181)).a(this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemr
 * JD-Core Version:    0.7.0.1
 */