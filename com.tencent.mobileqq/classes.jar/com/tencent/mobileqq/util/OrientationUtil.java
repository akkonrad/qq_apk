package com.tencent.mobileqq.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.util.VersionUtils;

public class OrientationUtil
{
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    int i = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getOrientation();
    switch (paramActivity.getResources().getConfiguration().orientation)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramActivity.setRequestedOrientation(i);
      return;
      if ((i == 0) || (i == 1) || (!VersionUtils.c())) {
        break;
      }
      i = 8;
      continue;
      if ((i != 0) && (i != 3) && (VersionUtils.c())) {
        i = 9;
      } else {
        i = 1;
      }
    }
  }
  
  public static void b(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.util.OrientationUtil
 * JD-Core Version:    0.7.0.1
 */