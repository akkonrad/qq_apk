package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.RecommendItem;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.fn;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.ArrayList;

final class qk
  extends bo
{
  qk(MyMbSubPageActivity paramMyMbSubPageActivity)
  {
    super(paramMyMbSubPageActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int j = 0;
    int i = 0;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      this.a.dismissDialog();
      Object localObject;
      if (paramMessage.arg1 == 0)
      {
        paramMessage = fn.a().c();
        if ((paramMessage != null) && (paramMessage.mMbInfoItems != null)) {
          while (i < paramMessage.mMbInfoItems.size())
          {
            localObject = (MbInfoResult.MbInfoItem)paramMessage.mMbInfoItems.get(i);
            MyMbSubPageActivity.access$100(this.a, MyMbSubPageActivity.access$000(this.a), (MbInfoResult.MbInfoItem)localObject, i);
            i += 1;
          }
        }
      }
      else
      {
        paramMessage = (d)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0))
        {
          d.a(this.a.getResources(), paramMessage);
          this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
          return;
          this.a.dismissDialog();
          if (paramMessage.arg1 == 0)
          {
            MyMbSubPageActivity.access$202(this.a, (RealNameStatusResult)paramMessage.obj);
            paramMessage = new Intent(this.a, RealNameProtectActivity.class);
            paramMessage.putExtra("realname_result", MyMbSubPageActivity.access$200(this.a));
            this.a.startActivityForResult(paramMessage, 0);
            return;
          }
          paramMessage = (d)paramMessage.obj;
          this.a.showUserDialog(paramMessage.c);
          return;
          this.a.dismissDialog();
          e.c("K_MSG_GETEVALACCOUNTRESULT");
          if (paramMessage.arg1 != 0)
          {
            localObject = (d)paramMessage.obj;
            MyMbSubPageActivity.access$300(this.a, (d)localObject, paramMessage);
            return;
          }
          if (paramMessage.arg1 == 0)
          {
            MyMbSubPageActivity.access$402(this.a, (EvalAccountResult)paramMessage.obj);
            LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.refresh_menu"));
            i = j;
            while (i < MyMbSubPageActivity.access$400(this.a).mRecommends.size())
            {
              paramMessage = (EvalAccountResult.RecommendItem)MyMbSubPageActivity.access$400(this.a).mRecommends.get(i);
              if (paramMessage.mRecommendId == 4) {
                MyMbSubPageActivity.access$500(this.a, paramMessage.mDetails);
              }
              i += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qk
 * JD-Core Version:    0.7.0.1
 */