import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

public final class dwi
  implements Comparator
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    return -Long.valueOf(paramFileInfo1.b()).compareTo(Long.valueOf(paramFileInfo2.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dwi
 * JD-Core Version:    0.7.0.1
 */