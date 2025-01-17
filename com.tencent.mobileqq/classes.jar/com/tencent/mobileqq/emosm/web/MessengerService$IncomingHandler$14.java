package com.tencent.mobileqq.emosm.web;

import acbg;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class MessengerService$IncomingHandler$14
  extends IPicDownloadListener
{
  public MessengerService$IncomingHandler$14(acbg paramacbg, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt, Bundle paramBundle, MessengerService paramMessengerService, Map paramMap, FavroamingDBManager paramFavroamingDBManager, EntityManager paramEntityManager, VipComicMqqManager paramVipComicMqqManager, QQAppInterface paramQQAppInterface) {}
  
  public void onDone(List paramList1, List paramList2)
  {
    if (paramList2 != null) {}
    do
    {
      Object localObject2;
      do
      {
        try
        {
          if (!paramList2.isEmpty())
          {
            this.val$result.put("code", 1);
            this.val$result.put("message", "not all success");
            this.val$data.put("failedNum", paramList2.size());
            if (paramList1 != null)
            {
              this.val$data.put("succeedNum", paramList1.size());
              this.val$data.put("remainNum", this.val$remainNum - paramList1.size());
            }
            this.val$result.put("data", this.val$data);
            this.val$reqbundle.putString("result", this.val$result.toString());
            this.val$service.a(this.val$reqbundle);
            if ((paramList2 == null) || (paramList2.isEmpty())) {
              continue;
            }
            paramList2 = paramList2.iterator();
            while (paramList2.hasNext())
            {
              localObject1 = (CustomEmotionData)paramList2.next();
              localObject2 = (VipComicFavorEmoStructMsgInfo)this.val$emoStructMsgInfoMap.get(((CustomEmotionData)localObject1).md5);
              this.val$fdb.a((CustomEmotionData)localObject1);
              if (localObject2 != null) {
                this.val$entityManager.b((Entity)localObject2);
              }
            }
          }
        }
        catch (JSONException paramList1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
            }
            return;
            this.val$result.put("code", 0);
            this.val$result.put("message", "ok");
            this.val$data.put("failedNum", 0);
          }
        }
        catch (Exception paramList1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.i("Q.emoji.web.MessengerService", 2, paramList1.getMessage());
          return;
        }
      } while ((paramList1 == null) || (paramList1.isEmpty()));
      paramList2 = new ArrayList();
      Object localObject1 = paramList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CustomEmotionData)((Iterator)localObject1).next();
        localObject2 = (VipComicFavorEmoStructMsgInfo)this.val$emoStructMsgInfoMap.get(((CustomEmotionData)localObject2).md5);
        if (localObject2 != null) {
          paramList2.add(localObject2);
        }
      }
      this.val$vipComicMqqManager.a(paramList2, true);
      paramList2 = this.val$qqApp.getHandler(ChatActivity.class);
      if (paramList2 != null) {
        paramList2.obtainMessage(10).sendToTarget();
      }
      paramList2 = (FavroamingManager)this.val$qqApp.getManager(102);
    } while (paramList2 == null);
    paramList2.a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.14
 * JD-Core Version:    0.7.0.1
 */