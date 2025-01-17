package com.tencent.av.ui;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.statistics.ReportController;

public class AVEffectReport
{
  static void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X8006F88", "0X8006F88", 0, 0, "", "", "", "");
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3)
  {
    String str2;
    Object localObject;
    String str1;
    switch (paramInt1)
    {
    default: 
      str2 = "0X8008395";
      localObject = str2;
      if (PtvTemplateManager.PtvTemplateInfo.isGesture(paramInt3))
      {
        str1 = "0X8008396";
        localObject = str2;
      }
      break;
    }
    for (;;)
    {
      str2 = String.valueOf(paramInt3);
      String str3 = String.valueOf(paramLong);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, paramInt2, 0, str2, "", str3, paramString);
      }
      if (!TextUtils.isEmpty(str1)) {
        ReportController.b(null, "dc00898", "", "", str1, str1, paramInt2, 0, str2, "", str3, paramString);
      }
      return;
      str1 = "0X8007F37";
      localObject = str1;
      if (PtvTemplateManager.PtvTemplateInfo.isGesture(paramInt3))
      {
        str2 = "0X80083AA";
        localObject = str1;
        str1 = str2;
        continue;
        str1 = "0X8007F31";
        localObject = str1;
        if (PtvTemplateManager.PtvTemplateInfo.isGesture(paramInt3))
        {
          str2 = "0X8008398";
          localObject = str1;
          str1 = str2;
          continue;
        }
      }
      str1 = null;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    String str = null;
    switch (paramInt1)
    {
    default: 
      str = "0X8007DBF";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        a(str, paramBoolean, paramLong);
      }
      return;
      if (paramInt2 == 4)
      {
        str = "0X8007F30";
        continue;
        if (paramInt2 == 4) {
          str = "0X8007F2A";
        }
      }
    }
  }
  
  public static void a(int paramInt, long paramLong)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "0X8006F87";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", String.valueOf(paramLong), "");
      }
      return;
      str = "0X8007F2B";
      continue;
      str = "0X8007F25";
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = DoodleLogic.a();
    if (!DoodleUtils.a()) {
      localObject = "0X80077BF";
    }
    for (;;)
    {
      a((String)localObject, paramBoolean, paramLong);
      return;
      if (!((DoodleLogic)localObject).a()) {
        localObject = "0X80077C0";
      } else if (!((DoodleLogic)localObject).b) {
        localObject = "0X80077BE";
      } else {
        localObject = "0X80077BD";
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    String str = null;
    switch (paramInt1)
    {
    default: 
      if (paramBoolean) {
        str = "0X8006F8D";
      }
      break;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        a(str, paramBoolean, paramLong);
      }
      return;
      if (paramInt2 == 4) {
        if (EffectFilterTools.a(paramContext))
        {
          str = "0X8007F2E";
        }
        else
        {
          str = "0X8007F2F";
          continue;
          if (paramInt2 == 4) {
            if (EffectFilterTools.a(paramContext))
            {
              str = "0X8007F28";
            }
            else
            {
              str = "0X8007F29";
              continue;
              str = "0X8006F8E";
            }
          }
        }
      }
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, long paramLong, boolean paramBoolean)
  {
    boolean bool;
    if (paramVideoAppInterface != null)
    {
      paramVideoAppInterface = (EffectSupportManager)paramVideoAppInterface.a(5);
      bool = paramVideoAppInterface.a(3, "normal");
      if (!paramVideoAppInterface.a(3, "interact")) {
        break label42;
      }
      paramVideoAppInterface = "0X8008023";
    }
    for (;;)
    {
      a(paramVideoAppInterface, paramBoolean, paramLong);
      return;
      label42:
      if (bool) {
        paramVideoAppInterface = "0X8008024";
      } else {
        paramVideoAppInterface = "0X8008132";
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, i, "", "", String.valueOf(paramLong), "");
      return;
    }
  }
  
  public static void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X8006F8F", "0X8006F8F", 0, 0, "", "", "", "");
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    Object localObject = "";
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (EffectFilterTools.a(paramContext))
      {
        i = j;
        if (GestureMgr.a().c()) {
          i = 1;
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      if (paramBoolean)
      {
        localObject = "0X8006F89";
        paramContext = (Context)localObject;
        if (i == 0) {
          break label163;
        }
        paramContext = "0X8008394";
      }
      break;
    }
    for (;;)
    {
      a((String)localObject, paramBoolean, paramLong);
      a(paramContext, paramBoolean, paramLong);
      return;
      paramContext = (Context)localObject;
      if (paramInt2 == 4)
      {
        paramContext = "0X8007F2C";
        if (i != 0)
        {
          paramContext = "0X80083A9";
          localObject = "0X8007F2C";
          continue;
          paramContext = (Context)localObject;
          if (paramInt2 == 4)
          {
            paramContext = "0X8007F26";
            if (i != 0)
            {
              paramContext = "0X8008397";
              localObject = "0X8007F26";
              continue;
              localObject = "0X8006F8A";
              break;
            }
          }
        }
      }
      label163:
      String str = "";
      localObject = paramContext;
      paramContext = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.AVEffectReport
 * JD-Core Version:    0.7.0.1
 */