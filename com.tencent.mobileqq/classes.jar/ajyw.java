import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public final class ajyw
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    do
    {
      do
      {
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
        } while (((int[])localObject).length != 3);
        paramDownloadParams = (int[])localObject;
        if (paramDownloadParams[0] == 0) {
          paramDownloadParams[0] = paramBitmap.getWidth();
        }
        if (paramDownloadParams[1] == 0) {
          paramDownloadParams[1] = paramBitmap.getHeight();
        }
        paramBitmap = ImageUtil.c(paramBitmap, paramDownloadParams[2], paramDownloadParams[0], paramDownloadParams[1]);
        paramDownloadParams = paramBitmap;
      } while (paramBitmap != null);
      paramDownloadParams = paramBitmap;
    } while (!QLog.isDevelopLevel());
    QLog.w(URLDrawableDecodeHandler.a(), 2, "ROUND_CORNER_DECODER bitmap == null");
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyw
 * JD-Core Version:    0.7.0.1
 */