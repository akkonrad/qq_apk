package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GetCommonUsedSystemEmojiStep
  extends AsyncStep
{
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.b.getApp().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
    long l = localSharedPreferences.getLong("lastRequestTime", 0L);
    EmoticonHandler localEmoticonHandler = (EmoticonHandler)this.a.b.a(12);
    File localFile1 = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v2_" + this.a.b.getCurrentAccountUin());
    File localFile2 = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v3_" + this.a.b.getCurrentAccountUin());
    if ((!localFile1.exists()) && (!localFile2.exists()))
    {
      QLog.d("QQInitHandler", 1, "GetCommonUsedSystemEmojiStep file and fileV2  not exsist");
      localEmoticonHandler.c();
      localSharedPreferences.edit().putLong("lastRequestTime", System.currentTimeMillis()).commit();
      return 7;
    }
    if ((localFile1.exists()) && (!localFile2.exists())) {
      ((CommonUsedSystemEmojiManager)this.a.b.getManager(171)).a(localFile1, localFile2);
    }
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() - l < 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "GetCommonUsedSystemEmojiStep send req");
      }
      localEmoticonHandler.c();
      localSharedPreferences.edit().putLong("lastRequestTime", System.currentTimeMillis()).commit();
      return 7;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetCommonUsedSystemEmojiStep updateCacheFromFile");
    }
    ((CommonUsedSystemEmojiManager)this.a.b.getManager(171)).b();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCommonUsedSystemEmojiStep
 * JD-Core Version:    0.7.0.1
 */