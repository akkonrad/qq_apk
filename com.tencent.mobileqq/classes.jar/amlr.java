import android.text.TextUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class amlr
  implements Runnable
{
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public amlr(PhotoPlusManager paramPhotoPlusManager, List paramList, boolean paramBoolean)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager, this.jdField_a_of_type_JavaUtilList);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved stickers = null");
    return;
    if (!FileUtils.a())
    {
      QLog.e("PhotoPlusManager", 1, "sdcard unavailable");
      return;
    }
    int i = 0;
    label58:
    Sticker localSticker;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localSticker = (Sticker)this.jdField_a_of_type_JavaUtilList.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved sticker:" + localSticker);
      }
      str = PhotoPlusManager.a + localSticker.getZipFilePath();
      if (new File(str).exists()) {
        break label177;
      }
      PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager, localSticker.url, str, localSticker.md5);
    }
    for (;;)
    {
      i += 1;
      break label58;
      break;
      label177:
      Object localObject2 = localSticker.getUnzippedDir();
      Object localObject1 = PhotoPlusManager.a + (String)localObject2 + localSticker.getImageFileName();
      localObject2 = PhotoPlusManager.a + (String)localObject2 + localSticker.getThumbImageFileName();
      localObject1 = new File((String)localObject1);
      localObject2 = new File((String)localObject2);
      if ((!((File)localObject1).exists()) || (!((File)localObject2).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoPlusManager", 2, "[updateStickerResource] zip exist but resource not exist:" + localSticker.getZipFilePath());
        }
        if (TextUtils.isEmpty(localSticker.md5))
        {
          this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(str);
        }
        else
        {
          localObject1 = PortalUtils.a(str);
          if (localSticker.md5.equalsIgnoreCase((String)localObject1))
          {
            this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(str);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoPlusManager", 2, "[updateStickerResource] checkMd5 failed: " + str);
            }
            FileUtils.d(str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlr
 * JD-Core Version:    0.7.0.1
 */