import com.tencent.mobileqq.nearby.now.model.LocalMediaInfo;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageUploader.OnResultListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aevo
  implements ImageUploader.OnResultListener
{
  public aevo(ImageFeedsUploader paramImageFeedsUploader) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("ImageFeedsUploader", 1, String.format("upload pic image: result=%d, url=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    ImageFeedsUploader.a(this.a).a = paramInt;
    ImageFeedsUploader.a(this.a).d = paramInt;
    ImageFeedsUploader.a(this.a).e = paramString;
    if (paramInt == 0)
    {
      ((LocalMediaInfo)ImageFeedsUploader.a(this.a).photoInfo.get(0)).d = paramString;
      ((LocalMediaInfo)ImageFeedsUploader.a(this.a).photoInfo.get(0)).a = true;
      ImageFeedsUploader.a(this.a).b = 2;
      this.a.a(ImageFeedsUploader.a(this.a), 3, null);
      return;
    }
    ImageFeedsUploader.a(this.a, ImageFeedsUploader.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevo
 * JD-Core Version:    0.7.0.1
 */