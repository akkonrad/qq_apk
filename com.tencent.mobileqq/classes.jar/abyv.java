import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.Callback;
import java.util.Iterator;
import java.util.LinkedList;

public class abyv
  implements Runnable
{
  public abyv(ChirpSoHandler paramChirpSoHandler) {}
  
  public void run()
  {
    synchronized (ChirpSoHandler.a(this.a))
    {
      Iterator localIterator = ChirpSoHandler.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((ChirpSoHandler.Callback)localIterator.next()).k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abyv
 * JD-Core Version:    0.7.0.1
 */