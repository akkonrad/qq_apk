import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.qphone.base.util.QLog;

public class fyt
  extends FMObserver
{
  public fyt(FileManagerRSCenter paramFileManagerRSCenter) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSCenter<FileAssistant>", 2, "recive TransferEnd, rmove task[" + String.valueOf(paramLong2) + "]!");
    }
    this.a.a(paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fyt
 * JD-Core Version:    0.7.0.1
 */