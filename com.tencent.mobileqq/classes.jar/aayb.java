import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeArkBabyQReplyByServerHandler;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.SearchArkBabyQInfo;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import java.lang.ref.WeakReference;

public class aayb
  implements ArkMessageServerLogic.IAnalyzeArkBabyQReplyByServerHandler
{
  public aayb(ArkRecommendLogic paramArkRecommendLogic, WeakReference paramWeakReference1, WeakReference paramWeakReference2, SessionInfo paramSessionInfo) {}
  
  public void a(String paramString, Object paramObject, ArkMessageServerLogic.SearchArkBabyQInfo paramSearchArkBabyQInfo, boolean paramBoolean)
  {
    ArkAppCenter.a().postDelayed(new aayc(this, paramSearchArkBabyQInfo, paramBoolean), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayb
 * JD-Core Version:    0.7.0.1
 */