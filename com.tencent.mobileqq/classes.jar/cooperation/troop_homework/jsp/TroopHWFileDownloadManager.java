package cooperation.troop_homework.jsp;

import android.content.Context;
import android.os.Process;
import anfn;
import anfo;
import anfp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import java.io.File;
import java.util.HashMap;

public class TroopHWFileDownloadManager
{
  public static final String a;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new anfp(this);
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  private TMAssistantDownloadSettingClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadSettingClient;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private String jdField_b_of_type_JavaLangString;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopHWFileDownloadManager.class.getName();
  }
  
  public TroopHWFileDownloadManager(Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = (AppConstants.aI + "/tencent/TMAssistantSDK/Download/" + paramContext.getPackageName() + "/");
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext()).getDownloadSDKClient(jdField_a_of_type_JavaLangString + Process.myPid());
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKSettingClient();
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new anfo(this, paramString), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2, TroopHWFileDownloadManager.OnDownloadStateListener paramOnDownloadStateListener)
  {
    String str = paramString2.substring(paramString2.lastIndexOf("/") + 1);
    File localFile = new File(paramString2);
    if (localFile.exists())
    {
      if (paramOnDownloadStateListener != null)
      {
        paramOnDownloadStateListener.a(paramString1, localFile.length(), localFile.length());
        paramOnDownloadStateListener.a(paramString1, 3, 0, null, paramString2);
      }
      return;
    }
    if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, paramOnDownloadStateListener);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    }
    ThreadManager.post(new anfn(this, paramString1, str), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWFileDownloadManager
 * JD-Core Version:    0.7.0.1
 */