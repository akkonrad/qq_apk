package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.utils.PatchCommonUtil;
import com.tencent.kingkong.Utils;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdatePatchConfig
  extends Step
{
  @TargetApi(11)
  private void a(Context paramContext)
  {
    int i = 0;
    QLog.d("PatchLogTag", 1, "UpdatePatchConfig clearPatchConfig start.");
    for (;;)
    {
      try
      {
        Object localObject1 = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
        ((SharedPreferences.Editor)localObject1).clear();
        ((SharedPreferences.Editor)localObject1).commit();
        localObject1 = new File(PatchCommonUtil.a("dex", ""));
        if (((File)localObject1).exists())
        {
          localObject1 = ((File)localObject1).listFiles();
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int j = localObject1.length;
            if (i < j)
            {
              Object localObject2 = localObject1[i];
              if ((localObject2 == null) || (!localObject2.exists())) {
                break label200;
              }
              localObject2.delete();
              break label200;
            }
          }
        }
        localObject1 = paramContext.getSharedPreferences("QQDetectAttack", 0).edit();
        ((SharedPreferences.Editor)localObject1).clear();
        ((SharedPreferences.Editor)localObject1).commit();
        paramContext.getSharedPreferences("rqd_catcher_pref", 4).edit().clear().commit();
        return;
      }
      catch (Throwable paramContext)
      {
        QLog.d("PatchLogTag", 1, "UpdatePatchConfig clearPatchConfig exception=" + paramContext);
        return;
      }
      label200:
      i += 1;
    }
  }
  
  protected boolean a()
  {
    Context localContext = BaseApplicationImpl.sApplication.getApplicationContext();
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("sp_update_version", 0);
    String str1 = localSharedPreferences.getString("key_cur_version", "");
    String str2 = ApkUtils.a(localContext) + "." + ApkUtils.a(localContext);
    QLog.d("PatchLogTag", 1, "UpdatePatchConfig oldVersion=" + str1 + ", curVersion=" + str2);
    if (!str2.equals(str1))
    {
      a(localContext);
      localSharedPreferences.edit().putString("key_cur_version", str2).commit();
      Utils.a(localContext);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePatchConfig
 * JD-Core Version:    0.7.0.1
 */