import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class sux
  extends WebViewClient
{
  public sux(H5MagicPlayerActivity paramH5MagicPlayerActivity) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (this.a.a(paramString)) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sux
 * JD-Core Version:    0.7.0.1
 */