import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Comparator;

public class acsh
  implements Comparator
{
  public acsh(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public int a(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if (paramFileManagerEntity2.srvTime > paramFileManagerEntity1.srvTime) {
      return 1;
    }
    if (paramFileManagerEntity2.srvTime < paramFileManagerEntity1.srvTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsh
 * JD-Core Version:    0.7.0.1
 */