import android.text.TextUtils;
import com.tencent.biz.webviewplugin.ReadInJoyWebRenderPlugin;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;

public class pcu
  implements Runnable
{
  public pcu(ReadInJoyWebRenderPlugin paramReadInJoyWebRenderPlugin) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(ReadInJoyWebRenderPlugin.a(this.a))) {
      SwiftOfflineDataUtils.a(ReadInJoyWebRenderPlugin.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcu
 * JD-Core Version:    0.7.0.1
 */