import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class blz
  extends FriendListObserver
{
  public blz(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a()
  {
    this.a.d();
  }
  
  void a(String paramString)
  {
    if (!paramString.equals(this.a.app.getAccount())) {
      return;
    }
    this.a.a.obtainMessage(1).sendToTarget();
    this.a.runOnUiThread(new bma(this));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((this.a.app.a() != null) && (this.a.app.a().equals(paramString)))
    {
      new Thread(new bmb(this, paramString)).start();
      return;
    }
    this.a.d();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("head", 2, "ContactsActivity.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a.sendEmptyMessage(1);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    do
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      if (paramMap.hasNext())
      {
        String str = (String)((Map.Entry)paramMap.next()).getKey();
        int i = this.a.app.b(str);
        if ((i == 1) || (i == 4)) {
          TroopAssistantManager.a().c(str, this.a.app);
        }
        for (;;)
        {
          this.a.d();
          break;
          if (i == 3) {
            TroopAssistantManager.a().b(str, this.a.app);
          }
        }
      }
    } while (!this.a.isResume());
    if (paramBoolean)
    {
      QQToast.a(this.a.app.a(), 2130838004, this.a.getString(2131363429), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.app.a(), 2130837994, this.a.getString(2131363430), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      new Thread(new bmc(this)).start();
    }
  }
  
  protected void c(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     blz
 * JD-Core Version:    0.7.0.1
 */