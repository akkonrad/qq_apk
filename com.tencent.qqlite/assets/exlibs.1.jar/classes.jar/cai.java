import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class cai
  extends MessageObserver
{
  public cai(DiscussChatPie paramDiscussChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.a.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.a.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = DiscussChatPie.d(this.a).a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        MultiMsgManager.a().a(DiscussChatPie.e(this.a), paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 3000) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      this.a.a(196608);
      return;
      QQToast.a(DiscussChatPie.c(this.a), 2131363138, 1).b(DiscussChatPie.b(this.a).getTitleBarHeight());
      continue;
      QQToast.a(DiscussChatPie.e(this.a), 2131363139, 1).b(DiscussChatPie.d(this.a).getTitleBarHeight());
      continue;
      DialogUtil.a(DiscussChatPie.f(this.a), 230, "发送失败", DiscussChatPie.g(this.a).getString(2131363680), new caj(this, paramString1), null).show();
      continue;
      try
      {
        if (!DiscussChatPie.h(this.a).isFinishing()) {
          DialogUtil.a(DiscussChatPie.i(this.a), 230, "发送失败", DiscussChatPie.j(this.a).getString(2131363140), new cak(this, paramString1), null).show();
        }
      }
      catch (Throwable paramString1) {}
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      this.a.C();
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.a(65536);
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    MultiMsgManager.a().b("send struct msg  ");
    MultiMsgManager.a().c();
    MultiMsgManager.a().a("all cost time ");
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.k = true;
    this.a.a(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cai
 * JD-Core Version:    0.7.0.1
 */