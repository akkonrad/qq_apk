import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.mobileqq.widget.QQToast;

public class abel
  implements Runnable
{
  public abel(ShopScanActivity paramShopScanActivity) {}
  
  public void run()
  {
    QQToast.a(this.a.getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abel
 * JD-Core Version:    0.7.0.1
 */