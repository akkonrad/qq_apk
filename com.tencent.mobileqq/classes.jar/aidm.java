import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCServer;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.utils.ContactUtils;
import eipc.EIPCResult;

public class aidm
  extends QIPCModule
{
  public aidm(VideoPlayIPCServer paramVideoPlayIPCServer, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ("CMD_GET_NICK_NAME_BY_UIN".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putString("VALUE_USER_NICK_NAME", ContactUtils.b(localQQAppInterface, paramBundle.getString("VALUE_USER_UIN_TO_GET_NICK_NAME"), true));
      return EIPCResult.createSuccessResult(paramString);
    }
    if ("CMD_GET_CURRENT_NICK_NAME".equals(paramString))
    {
      paramString = localQQAppInterface.getCurrentNickname();
      paramBundle = new Bundle();
      paramBundle.putString("VALUE_GET_CURRENT_NICK_NAME", paramString);
      return EIPCResult.createSuccessResult(paramBundle);
    }
    if ("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT".equals(paramString))
    {
      paramString = paramBundle.getString("VALUE_MSG_FRIENDUIN");
      paramInt = paramBundle.getInt("VALUE_MSG_ISTROOP");
      paramBundle = paramBundle.getString("VALUE_MSG_VIDEO_ID");
      if (paramBundle != null)
      {
        RedBagVideoManager.a(localQQAppInterface).a(paramString, paramInt, paramBundle);
        VideoRedbagData.updateRewardStat(paramBundle);
      }
      return EIPCResult.createSuccessResult(new Bundle());
    }
    if ("CMD_QUERY_VIDEO_REDBAG_STAT".equals(paramString))
    {
      boolean bool = VideoRedbagData.queryRewardStat(paramBundle.getString("VALUE_MSG_VIDEO_ID"));
      paramString = new Bundle();
      paramString.putBoolean("VALUE_MSG_REDBAG_STAT", bool);
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aidm
 * JD-Core Version:    0.7.0.1
 */