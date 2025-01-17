import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public final class acdg
  extends AsyncTask
{
  public acdg(Bundle paramBundle, MessengerService paramMessengerService, URLDrawable paramURLDrawable, QQAppInterface paramQQAppInterface, PicMessageExtraData paramPicMessageExtraData) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    paramVarArgs = ((MessageForPic)this.jdField_a_of_type_ComTencentImageURLDrawable.getTag()).path;
    paramVarArgs = EmojiStickerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramVarArgs);
    if (paramVarArgs != null)
    {
      AIOGalleryUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    if (!AbsDownloader.a(paramVarArgs)) {
      return Integer.valueOf(1);
    }
    paramVarArgs = AbsDownloader.a(paramVarArgs);
    if (paramVarArgs != null) {}
    label293:
    label304:
    for (paramVarArgs = SecUtil.getFileMd5(paramVarArgs.getAbsolutePath());; paramVarArgs = null)
    {
      if ((paramVarArgs == null) || ("".equals(paramVarArgs))) {
        return Integer.valueOf(1);
      }
      FileUtils.c(AppConstants.aU + ".nomedia");
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      int i;
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.isDiyDouTu()))
      {
        i = 1;
        if (i == 0) {
          break label304;
        }
        localStringBuilder = new StringBuilder().append("_diydoutu@");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId)) {
          break label293;
        }
        str1 = "0";
      }
      label217:
      for (String str1 = str1;; str1 = "")
      {
        paramVarArgs = AppConstants.aU + str2 + paramVarArgs + str1 + ".jpg";
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(paramVarArgs);
          return Integer.valueOf(EmojiStickerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramVarArgs, null, this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData));
        }
        catch (IOException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          QLog.d("EmojiStickerManager", 1, paramVarArgs, new Object[0]);
          return Integer.valueOf(1);
        }
        i = 0;
        break;
        str1 = this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId;
        break label217;
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    int j = -1;
    int i;
    if (paramInteger.intValue() == 0) {
      i = 0;
    }
    for (;;)
    {
      paramInteger = new Bundle();
      paramInteger.putInt("result", i);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramInteger);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      i = j;
      if (paramInteger.intValue() != 2)
      {
        i = j;
        if (paramInteger.intValue() == 1) {
          i = -2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acdg
 * JD-Core Version:    0.7.0.1
 */