import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.widget.QQToast;

public class aipz
  implements Runnable
{
  public aipz(GroupPicUploadProcessor paramGroupPicUploadProcessor) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.sApplication, "WebP格式的图片不支持原图发送，请使用标清质量来发送。", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipz
 * JD-Core Version:    0.7.0.1
 */