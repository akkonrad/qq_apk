import com.tencent.mfsdk.LeakInspector.DumpMemInfoHandler;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectorListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import java.util.ArrayList;
import java.util.List;

public class aies
  implements LeakInspector.InspectorListener
{
  public List a(String paramString)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new aiet(this, paramString));
    }
    paramString = new ArrayList(4);
    paramString.add(DumpMemInfoHandler.b());
    paramString.add(DumpMemInfoHandler.a());
    paramString.addAll(DumpMemInfoHandler.a());
    return paramString;
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new aieu(this, paramString1, paramBoolean, paramString2));
    }
  }
  
  public boolean a(LeakInspector.InspectUUID paramInspectUUID)
  {
    return InitMagnifierSDK.a(paramInspectUUID);
  }
  
  public boolean a(Object paramObject)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aies
 * JD-Core Version:    0.7.0.1
 */