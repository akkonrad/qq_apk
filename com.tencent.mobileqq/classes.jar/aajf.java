import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.widget.ImageView;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class aajf
  implements ImageAssetDelegate
{
  aajf(aaje paramaaje) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if ((ImageView)this.a.a.e.get() != null)
    {
      String str = paramLottieImageAsset.getFileName();
      Bitmap localBitmap = (Bitmap)this.a.a.a.a.a.get(str);
      paramLottieImageAsset = localBitmap;
      if (localBitmap == null)
      {
        QLog.w(MainDownAni.a(), 1, "loadDownAnimation, 加载图片失败, image[" + str + "]");
        paramLottieImageAsset = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      }
      return paramLottieImageAsset;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajf
 * JD-Core Version:    0.7.0.1
 */