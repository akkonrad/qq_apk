import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import mqq.os.MqqHandler;

public class akql
  implements URLDrawable.URLDrawableListener
{
  public akql(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a.sendMessage(this.a.a.obtainMessage(103, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akql
 * JD-Core Version:    0.7.0.1
 */