import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.guild.GuildMultiActivity;

public class jja
  implements Runnable
{
  public jja(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      SessionInfo localSessionInfo = SessionMgr.a().a(this.a.e);
      if (localSessionInfo != null)
      {
        localSessionInfo.a.f = true;
        if (this.a.a.h() == 1) {}
        GuildMultiActivity.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jja
 * JD-Core Version:    0.7.0.1
 */