import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.smtt.sdk.WebView;

public class ajlw
  implements Runnable
{
  public ajlw(TroopNoticeJsHandler paramTroopNoticeJsHandler, WebView paramWebView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript: " + this.jdField_a_of_type_JavaLangString + "(" + this.b + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlw
 * JD-Core Version:    0.7.0.1
 */