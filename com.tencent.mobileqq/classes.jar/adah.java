import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadListener;
import java.io.File;

public class adah
  implements WyDownloader.IDownloadListener
{
  public adah(WeiYunLogicCenter paramWeiYunLogicCenter, String paramString, int paramInt, Object paramObject) {}
  
  public void a(String paramString, long paramLong, float paramFloat) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    int i;
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists()))
    {
      i = 1;
      if (i == 0) {
        break label128;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb onSucceed. filePath[" + paramString2 + "]");
      }
      WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter).a().a(true, 39, new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), paramString2, this.jdField_a_of_type_JavaLangObject });
    }
    label128:
    while (!QLog.isColorLevel())
    {
      return;
      i = 0;
      break;
    }
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb onFailed: errcode[" + paramInt + "], errmsg[" + paramString3 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adah
 * JD-Core Version:    0.7.0.1
 */