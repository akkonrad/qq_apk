import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class akic
  implements Runnable
{
  public akic(VasMonitorHandler paramVasMonitorHandler, AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool2 = true;
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
    boolean bool1;
    Object localObject3;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = true;
      localObject3 = VasQuickUpdateManager.a((AppRuntime)localObject1, "monitorAppid", bool1, null);
      if (localObject3 == null) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqVasVasMonitorHandler.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        localObject1 = ((JSONObject)localObject3).optJSONArray("allAppidControl");
        if (localObject1 == null) {
          break label229;
        }
        localObject1 = ((JSONArray)localObject1).optJSONObject(0);
        AtomicBoolean localAtomicBoolean = this.jdField_a_of_type_ComTencentMobileqqVasVasMonitorHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if ((localObject1 == null) || (!((JSONObject)localObject1).optBoolean("stopAllReport"))) {
          break label235;
        }
        bool1 = bool2;
        localAtomicBoolean.set(bool1);
        if (this.jdField_a_of_type_ComTencentMobileqqVasVasMonitorHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          return;
        }
        localObject3 = ((JSONObject)localObject3).optJSONArray("individualMonitorAppidList");
        if (localObject3 != null) {
          if (i < ((JSONArray)localObject3).length())
          {
            localObject1 = ((JSONArray)localObject3).optJSONObject(i);
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optString("appid");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                this.jdField_a_of_type_ComTencentMobileqqVasVasMonitorHandler.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject1);
              }
              i += 1;
              continue;
            }
            localObject1 = null;
            continue;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.i("VasMonitorHandler", 2, "parseBlackList err:" + localException.getMessage());
      }
      bool1 = false;
      break;
      label229:
      Object localObject2 = null;
      continue;
      label235:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akic
 * JD-Core Version:    0.7.0.1
 */