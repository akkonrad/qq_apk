import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;

public final class ajym
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    Object localObject;
    do
    {
      do
      {
        return paramDownloadParams;
        localObject = paramDownloadParams.tag;
        paramDownloadParams = paramBitmap;
      } while (!(localObject instanceof int[]));
      paramDownloadParams = paramBitmap;
    } while (((int[])localObject).length != 2);
    paramDownloadParams = (int[])localObject;
    float f2 = DeviceInfoUtil.a();
    float f1 = f2;
    if (f2 < 0.01F) {
      f1 = 1.0F;
    }
    paramDownloadParams[0] = ((int)(paramDownloadParams[0] / f1));
    paramDownloadParams[1] = ((int)(paramDownloadParams[1] / f1));
    return ImageUtil.a(paramBitmap, paramDownloadParams[0], paramDownloadParams[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajym
 * JD-Core Version:    0.7.0.1
 */