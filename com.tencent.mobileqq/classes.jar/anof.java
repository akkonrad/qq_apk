import android.support.annotation.NonNull;
import dov.com.qq.im.capture.text.MidNightTextItem;
import dov.com.qq.im.capture.text.PinYinSpan.OnHanZiToPinYinListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class anof
  implements PinYinSpan.OnHanZiToPinYinListener
{
  public anof(MidNightTextItem paramMidNightTextItem) {}
  
  @NonNull
  public String a(@NonNull String paramString)
  {
    return MidNightTextItem.a().matcher(paramString).replaceAll(" ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anof
 * JD-Core Version:    0.7.0.1
 */