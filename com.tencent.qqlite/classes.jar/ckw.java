import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class ckw
  implements Runnable
{
  public ckw(qfileJumpActivity paramqfileJumpActivity) {}
  
  public void run()
  {
    StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_share_my_pc");
    Intent localIntent = this.a.getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    ((Bundle)localObject1).putString("leftBackText", "消息");
    ((Bundle)localObject1).putBoolean("isBack2Root", true);
    localObject2 = new Intent(this.a, LiteActivity.class);
    ((Intent)localObject2).addFlags(268435456);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).putExtra("dataline_share_finish", false);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtras(localIntent);
    ((Intent)localObject2).setAction(localIntent.getAction());
    ((Intent)localObject2).setType(localIntent.getType());
    this.a.startActivity((Intent)localObject2);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ckw
 * JD-Core Version:    0.7.0.1
 */