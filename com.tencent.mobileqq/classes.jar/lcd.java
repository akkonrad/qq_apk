import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask.Query;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class lcd
  implements QueryTask.Query
{
  public char[] a(SmallEmoticonInfo paramSmallEmoticonInfo)
  {
    try
    {
      int i = Integer.parseInt(paramSmallEmoticonInfo.a.eId);
      int j = Integer.parseInt(paramSmallEmoticonInfo.a.epId);
      Object localObject = EmosmUtils.a(j, i);
      paramSmallEmoticonInfo = new char[5];
      paramSmallEmoticonInfo[0] = 20;
      paramSmallEmoticonInfo[1] = localObject[3];
      paramSmallEmoticonInfo[2] = localObject[2];
      paramSmallEmoticonInfo[3] = localObject[1];
      paramSmallEmoticonInfo[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((EmoticonManager)((AppRuntime)localObject).getManager(13)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramSmallEmoticonInfo[1] = 511;
        }
      }
      return paramSmallEmoticonInfo;
    }
    catch (NumberFormatException paramSmallEmoticonInfo)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcd
 * JD-Core Version:    0.7.0.1
 */