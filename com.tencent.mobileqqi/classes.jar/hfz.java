import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class hfz
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfz
 * JD-Core Version:    0.7.0.1
 */