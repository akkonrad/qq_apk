package com.tencent.mobileqq.emosm.web;

import acbg;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class MessengerService$IncomingHandler$11
  extends IPicDownloadListener
{
  public MessengerService$IncomingHandler$11(acbg paramacbg, Bundle paramBundle, FavroamingDBManager paramFavroamingDBManager, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void onDone(List paramList1, List paramList2)
  {
    int i = 0;
    if (paramList2 != null)
    {
      try
      {
        if (paramList2.isEmpty()) {
          break label183;
        }
        j = paramList2.size();
        if ((paramList1 == null) || (paramList1.isEmpty())) {
          break label152;
        }
        i = paramList1.size();
        this.val$reqbundle.putInt("result", 2);
      }
      catch (JSONException paramList1)
      {
        for (;;)
        {
          int j;
          Object localObject;
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
          }
          return;
          this.val$reqbundle.putInt("result", 1);
        }
      }
      catch (Exception paramList1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
        return;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("succeedNum", i);
      ((JSONObject)localObject).put("failedNum", j);
      this.val$reqbundle.putString("data", ((JSONObject)localObject).toString());
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        localObject = (CustomEmotionData)paramList2.next();
        this.val$fdb.a((CustomEmotionData)localObject);
      }
    }
    label152:
    label183:
    do
    {
      this.val$reqbundle.putInt("result", 0);
      this.val$service.a(this.val$reqbundle);
      this.val$service.getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
      paramList2 = this.val$qqApp.getHandler(ChatActivity.class);
      if (paramList2 != null) {
        paramList2.obtainMessage(10).sendToTarget();
      }
      paramList2 = (FavroamingManager)this.val$qqApp.getManager(102);
    } while ((paramList2 == null) || (paramList1 == null) || (paramList1.isEmpty()));
    paramList2.a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.11
 * JD-Core Version:    0.7.0.1
 */