import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class akmv
  implements TouchWebView.OnScrollChangedListener
{
  public akmv(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.a.b = paramInt2;
    this.a.a(this.a.b, this.a.f);
    paramView = this.a.a.a();
    if ((paramView != null) && (!TextUtils.isEmpty(this.a.d))) {
      paramView.a(this.a.d, new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(paramInt3), String.valueOf(paramInt4) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmv
 * JD-Core Version:    0.7.0.1
 */