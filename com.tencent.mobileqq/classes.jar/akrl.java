import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.CallBack;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;

public class akrl
  implements WebSoService.CallBack
{
  public akrl(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.a = 10004;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akrl
 * JD-Core Version:    0.7.0.1
 */