import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class hfd
  implements Runnable
{
  public hfd(String paramString) {}
  
  public void run()
  {
    File localFile = new File(this.a);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      boolean bool = localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.VoiceIntro", 2, "delete result=" + bool + " f.path=" + this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfd
 * JD-Core Version:    0.7.0.1
 */