import android.graphics.Bitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ulh
  implements PreloadManager.OnGetPathListener
{
  ulh(ulg paramulg) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      Object localObject = paramPathResult + File.separator;
      localObject = (String)localObject + "aio.png";
      localObject = SafeBitmapFactory.decodeFile((String)localObject, ImageUtil.a((String)localObject, (int)(CustomizeStrategyFactory.a * 47.0F + 0.5D)));
      if (localObject != null) {
        this.a.a.icon = ((Bitmap)localObject);
      }
      this.a.a.resPath = paramPathResult;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "VOICE_LOCK_RES info.icon=" + this.a.a.icon + ",resPath=" + this.a.a.resPath);
      }
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
    CustomizeStrategyFactory.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ulh
 * JD-Core Version:    0.7.0.1
 */