import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.WebViewDownloadListener;
import com.tencent.smtt.sdk.WebView;

public class aljb
  implements Runnable
{
  public aljb(WebViewDownloadListener paramWebViewDownloadListener, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (this.jdField_a_of_type_JavaLangString != null) && (CallBackEvent.a().a())) {}
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a(WebViewDownloadListener.jdField_a_of_type_JavaLangString, "doJsCallBack >>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljb
 * JD-Core Version:    0.7.0.1
 */