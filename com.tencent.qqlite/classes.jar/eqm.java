import com.tencent.mobileqq.app.AppConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class eqm
  implements Runnable
{
  public void run()
  {
    File[] arrayOfFile;
    do
    {
      try
      {
        Thread.sleep(3000L);
        File localFile = new File(AppConstants.aB);
        if (!localFile.isDirectory()) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
      arrayOfFile = localInterruptedException.listFiles(new eqn(this));
    } while ((arrayOfFile == null) || (arrayOfFile.length < 100));
    Object localObject = new ArrayList(arrayOfFile.length);
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(Long.valueOf(arrayOfFile[i].lastModified()));
      i += 1;
    }
    Collections.sort((List)localObject);
    long l = ((Long)((List)localObject).get(((List)localObject).size() - 100)).longValue();
    j = arrayOfFile.length;
    i = 0;
    while (i < j)
    {
      localObject = arrayOfFile[i];
      if (((File)localObject).lastModified() < l) {
        ((File)localObject).deleteOnExit();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqm
 * JD-Core Version:    0.7.0.1
 */