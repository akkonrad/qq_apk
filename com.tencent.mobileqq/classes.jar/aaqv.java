import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppInfo.ContextActionAppInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class aaqv
  implements Runnable
{
  public aaqv(ArkActionAppMgr paramArkActionAppMgr) {}
  
  public void run()
  {
    TreeMap localTreeMap = new TreeMap(new aaqw(this));
    ArkActionAppMgr.a(this.a, localTreeMap);
    if (localTreeMap.isEmpty())
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("updateLocalAppInfo, no action need update", new Object[0]));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Iterator localIterator = localTreeMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ArkAppInfo.ContextActionAppInfo localContextActionAppInfo = (ArkAppInfo.ContextActionAppInfo)localIterator.next();
      aarf localaarf = (aarf)localTreeMap.get(localContextActionAppInfo);
      localStringBuilder.append(String.format("%s.%s(%d-%d);", new Object[] { localContextActionAppInfo.a, localContextActionAppInfo.b, Long.valueOf(localaarf.a), Long.valueOf(localaarf.b) }));
    }
    ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("updateLocalAppInfo, actions=%s", new Object[] { localStringBuilder.toString() }));
    ArkActionAppMgr.b(this.a, localTreeMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqv
 * JD-Core Version:    0.7.0.1
 */