import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppInfo.AppDesc;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask.Result;
import java.util.HashMap;

class aavj
  implements Runnable
{
  aavj(aavi paramaavi, ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, aavx paramaavx) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_Int;
    ??? = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_a_of_type_JavaLangString;
    if (i == 0) {
      if (ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Aavx.c) >= 0) {
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateAppByName success, result=%s, app-name=%s, expect-ver=%s, local-ver=%s", new Object[] { ArkLocalAppMgr.UpdateAppByNameTask.Result.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Aavx.c, this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.jdField_b_of_type_JavaLangString }));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aavx.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Aavx.jdField_a_of_type_JavaLangString = ((String)???);
      if (i == 0) {
        this.jdField_a_of_type_Aavx.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo;
      }
      synchronized (ArkLocalAppMgr.a(this.jdField_a_of_type_Aavi.a))
      {
        ArkLocalAppMgr.a(this.jdField_a_of_type_Aavi.a).put(this.jdField_a_of_type_Aavx.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Aavx.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo);
        ArkLocalAppMgr.a(this.jdField_a_of_type_Aavi.a, this.jdField_a_of_type_Aavx);
        return;
        i = 6;
        ??? = null;
        ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateAppByName fail, invalid app version, result=%s, app-name=%s, expect-ver=%s, local-ver=%s", new Object[] { ArkLocalAppMgr.UpdateAppByNameTask.Result.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Aavx.c, this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.jdField_b_of_type_JavaLangString }));
        continue;
        String str = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.jdField_b_of_type_JavaLangString;
        if (??? != null)
        {
          localObject2 = ???;
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateAppByName fail, retCode=%d, app-name=%s, msg=%s", new Object[] { Integer.valueOf(i), str, localObject2 }));
          continue;
        }
        Object localObject2 = "unknown";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aavj
 * JD-Core Version:    0.7.0.1
 */