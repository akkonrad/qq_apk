import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.IRequestHandler;
import java.util.Comparator;

public class yoo
  implements Comparator
{
  public yoo(ApolloCmdChannel paramApolloCmdChannel) {}
  
  public int a(ApolloCmdChannel.IRequestHandler paramIRequestHandler1, ApolloCmdChannel.IRequestHandler paramIRequestHandler2)
  {
    return paramIRequestHandler1.a() - paramIRequestHandler2.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yoo
 * JD-Core Version:    0.7.0.1
 */