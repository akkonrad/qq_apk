package com.tencent.mobileqq.richmedia.dc;

import ahnl;
import ahnm;
import ahnn;
import ahno;
import ahnp;
import ahnq;
import ahnt;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class DCShortVideo
  extends DataCollector
  implements ReportEvent
{
  public DCShortVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new ahnp(this, paramInt, paramBoolean));
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new ahnn(this, paramAppInterface, paramInt1, paramInt3, paramString, paramInt2, paramLong));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new ahno(this, paramAppInterface, paramInt1, paramInt2, paramString));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, ahnt paramahnt)
  {
    paramahnt.f = paramInt1;
    if (paramInt2 == 0) {
      paramahnt.b = 0;
    }
    for (;;)
    {
      paramAppInterface = (NearbyCardManager)paramAppInterface.getManager(105);
      if (paramAppInterface != null)
      {
        paramahnt.d = paramAppInterface.a();
        paramahnt.e = paramAppInterface.b();
      }
      paramahnt.g = Calendar.getInstance().get(11);
      paramahnt.h = NetworkUtil.a(BaseApplication.getContext());
      return;
      if (paramInt2 == 3000)
      {
        paramahnt.b = 3000;
      }
      else
      {
        if (paramInt2 == 1)
        {
          if ((paramAppInterface instanceof QQAppInterface)) {
            switch (((QQAppInterface)paramAppInterface).b(paramString))
            {
            default: 
              paramahnt.b = 1;
            }
          }
          for (;;)
          {
            paramahnt.c = 0;
            TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(51);
            if (localTroopManager == null) {
              break;
            }
            paramString = localTroopManager.b(paramString);
            if (paramString == null) {
              break;
            }
            paramahnt.c = paramString.wMemberNum;
            break;
            paramahnt.b = 1;
            continue;
            paramahnt.b = 3;
            continue;
            paramahnt.b = 4;
            continue;
            paramahnt.b = 2;
            continue;
            paramahnt.b = 1;
          }
        }
        paramahnt.b = 9999;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramQQAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new ahnm(this, paramQQAppInterface, paramInt1, paramInt2, paramString, paramInt3));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString3, long paramLong, String paramString4)
  {
    if ((paramQQAppInterface != null) && (paramString1 != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new ahnl(this, paramString1, paramQQAppInterface, paramInt1, paramInt2, paramString2, paramLong, paramString4, paramBoolean1, paramInt3, paramString3, paramBoolean2));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong)
  {
    ThreadManager.getSubThreadHandler().post(new ahnq(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt7, paramInt8, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo
 * JD-Core Version:    0.7.0.1
 */