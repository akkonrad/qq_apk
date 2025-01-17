package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.OpenConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ControlPolicyUtil
{
  public static long a()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_tips_dialog_interval");
  }
  
  public static String a()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_myapp_download_url");
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str;
    if (paramInt2 == 2) {
      switch (paramInt1)
      {
      default: 
        str = "Common_GC_InstallYYB_Install_Words";
      }
    }
    for (;;)
    {
      return OpenConfig.a(CommonDataAdapter.a().a(), null).b(str);
      str = "Common_GC_InstallYYB_Install_Words";
      continue;
      str = "Common_GC_InstallYYB_Update_Words";
      continue;
      str = "Common_GC_UpdateYYB_Install_Words";
      continue;
      str = "Common_GC_UpdateYYB_Update_Words";
      continue;
      if (paramInt2 == 1) {
        switch (paramInt1)
        {
        case 2: 
        default: 
          str = null;
          break;
        case 1: 
          str = "Common_QQUpdate_InstallYYB_Update_Words";
          break;
        case 3: 
          str = "Common_QQUpdate_UpdateYYB_Update_Words";
          break;
        }
      } else {
        switch (paramInt1)
        {
        default: 
          str = "Common_InstallYYB_Install_Words";
          break;
        case 1: 
          str = "Common_InstallYYB_Install_Words";
          break;
        case 2: 
          str = "Common_InstallYYB_Update_Words";
          break;
        case 3: 
          str = "Common_UpdateYYB_Install_Words";
          break;
        case 4: 
          str = "Common_UpdateYYB_Update_Words";
        }
      }
    }
  }
  
  public static void a()
  {
    int i = 1;
    if (!OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_Show_Dialog_Flag")) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localObject = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0);
      localEditor = ((SharedPreferences)localObject).edit();
      if (OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_Dialog_Only_Once_Flag"))
      {
        localEditor.putBoolean("SP_Has_shown_Dialog", true);
        localEditor.commit();
        return;
      }
      j = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_Max_Count");
    } while ((j == -1) || (j == 0));
    int j = ((SharedPreferences)localObject).getInt("SP_Show_Dialog_Count", 0);
    Object localObject = ((SharedPreferences)localObject).getString("SP_Show_Dialog_Date", "");
    String str = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
    if (str.equals(localObject)) {
      i = j + 1;
    }
    localEditor.putInt("SP_Show_Dialog_Count", i);
    localEditor.putString("SP_Show_Dialog_Date", str);
    localEditor.commit();
  }
  
  public static void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0).edit();
    localEditor.putLong("SP_Lastest_require_time", paramLong);
    localEditor.commit();
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    long l = localSharedPreferences.getLong("SP_Lastest_require_time", paramLong);
    if (paramLong - l >= b())
    {
      localEditor.putLong("SP_Lastest_require_time", paramLong);
      localEditor.commit();
    }
    while (paramLong == l) {
      return true;
    }
    return false;
  }
  
  public static long b()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_require_root_interval");
  }
  
  public static void b()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int j = localSharedPreferences.getInt("tmast_wake_times", 0);
    if (!b(localSharedPreferences.getLong("tmast_wake_last_time", 0L))) {}
    for (;;)
    {
      localEditor.putInt("tmast_wake_times", i + 1);
      localEditor.putLong("tmast_wake_last_time", System.currentTimeMillis());
      return;
      i = j;
    }
  }
  
  public static boolean b()
  {
    DownloadInfo localDownloadInfo = DownloadManager.a().a("1101070898");
    Object localObject = "";
    if (localDownloadInfo != null) {
      localObject = localDownloadInfo.k;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists())) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean b(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date(System.currentTimeMillis()));
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(new Date(paramLong));
    return (localCalendar2.get(1) == localCalendar1.get(1)) && (localCalendar2.get(6) - localCalendar1.get(6) == 0);
  }
  
  public static boolean c()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_root_autoinstall_flag") <= 0;
  }
  
  public static boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (AppUtil.a("com.tencent.android.qqdownloader") > 4001126)
    {
      bool1 = bool2;
      if (OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_QQ_CARRY_IDENTITY")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean e()
  {
    Object localObject = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_Release_Control").trim();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      do
      {
        return true;
      } while (((String)localObject).equals("-1"));
      if (((String)localObject).equals("-2")) {
        return false;
      }
      localObject = ((String)localObject).split(";");
    } while (localObject == null);
    String str1 = String.valueOf(CommonDataAdapter.a().a());
    if (str1 == null) {
      return false;
    }
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label115;
      }
      String str2 = localObject[i];
      if ((str2.length() == 2) && (str1.endsWith(str2))) {
        break;
      }
      i += 1;
    }
    label115:
    return false;
  }
  
  public static boolean f()
  {
    if (!OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_Show_Dialog_Flag")) {}
    int i;
    int j;
    do
    {
      boolean bool;
      do
      {
        return false;
        localObject = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0);
        bool = ((SharedPreferences)localObject).getBoolean("SP_Has_shown_Dialog", false);
        if (!OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_Dialog_Only_Once_Flag")) {
          break;
        }
      } while (bool);
      return true;
      i = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_Max_Count");
      LogUtility.c("OpenConfig-MyAppApi", " maxCount = " + i);
      if ((i == -1) || (i == 0)) {
        return true;
      }
      j = ((SharedPreferences)localObject).getInt("SP_Show_Dialog_Count", 0);
      Object localObject = ((SharedPreferences)localObject).getString("SP_Show_Dialog_Date", "");
      if (!new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())).equals(localObject)) {
        break;
      }
    } while (j >= i);
    return true;
    return true;
  }
  
  public static boolean g()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_MyAppDownload_Flag");
  }
  
  public static boolean h()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_Detail_Page");
  }
  
  public static boolean i()
  {
    boolean bool2 = false;
    boolean bool3 = OpenConfig.a(CommonDataAdapter.a().a(), null).c("Common_tmast_wake");
    long l1 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_wake_limite");
    long l2 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_wake_interval") * 1000L;
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().a().getSharedPreferences("share_myAppApi", 0);
    int i = localSharedPreferences.getInt("tmast_wake_times", 0);
    long l3 = localSharedPreferences.getLong("tmast_wake_last_time", 0L);
    boolean bool4 = b(l3);
    if (!bool4) {
      i = 0;
    }
    LogUtility.c("TAMST_WAKE", ">>allowTmastWake allowWake = " + bool3 + " wakeLimit = " + l1 + " wakeInterval = " + l2 + " wakeTimes = " + i + " isToday = " + bool4);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (i < l1) {
        if (System.currentTimeMillis() - l3 <= l2)
        {
          bool1 = bool2;
          if (bool4) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean j()
  {
    return OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_yyb_wifi_download_Switch");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.ControlPolicyUtil
 * JD-Core Version:    0.7.0.1
 */