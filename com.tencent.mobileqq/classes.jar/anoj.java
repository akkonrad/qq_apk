import android.support.annotation.NonNull;
import dov.com.qq.im.capture.text.PinYinSpan.OnPinYinDrawListener;
import dov.com.qq.im.capture.text.SupernaturalTextItem;

public class anoj
  implements PinYinSpan.OnPinYinDrawListener
{
  public anoj(SupernaturalTextItem paramSupernaturalTextItem) {}
  
  @NonNull
  public String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    return paramString2.toUpperCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anoj
 * JD-Core Version:    0.7.0.1
 */