import java.io.File;
import java.util.Comparator;

class cyh
  implements Comparator
{
  cyh(cyg paramcyg) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() - paramFile1.lastModified() > 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cyh
 * JD-Core Version:    0.7.0.1
 */