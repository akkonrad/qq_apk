import java.util.concurrent.ThreadFactory;

class hin
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    him.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + him.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hin
 * JD-Core Version:    0.7.0.1
 */