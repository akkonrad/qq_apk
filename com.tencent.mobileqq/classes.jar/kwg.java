import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import java.net.URL;

public class kwg
  implements PublicAccountImageDownListener
{
  public kwg(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    ReadInJoyNativeAdFragment.b(this.a, 2);
    ReadInJoyNativeAdFragment.a(this.a).setPublicAccountImageDownListener(null);
    ReadInJoyNativeAdFragment.a(this.a, null);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    ReadInJoyNativeAdFragment.b(this.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kwg
 * JD-Core Version:    0.7.0.1
 */