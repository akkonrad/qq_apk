package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import fma;
import java.io.File;
import java.util.ArrayList;

public class TroopProxyActivity
  extends PluginProxyActivity
{
  public static String a;
  public static ArrayList a;
  public static final String b = "troopUin";
  public static final String c = "uuid_key";
  public static final String d = "Url";
  public static final String e = "fileSize";
  public static final String f = "fileName";
  public static final String g = "bisID";
  public static final String h = "preview";
  public static final String i = "uploadUin";
  public static final String j = "deadTime";
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangString = "key_qun_id";
  }
  
  public static Dialog a(Activity paramActivity)
  {
    if (!PluginUtils.isPluginInstalled(paramActivity, "troop_plugin.apk", "107392"))
    {
      paramActivity = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492887));
      paramActivity.a("正在加载...");
      paramActivity.setOnDismissListener(new fma());
      return paramActivity;
    }
    try
    {
      PluginUtils.getInstallPath(paramActivity, "troop_plugin.apk").getCanonicalPath();
      return null;
    }
    catch (Exception paramActivity) {}
    return null;
  }
  
  public static Class a(String paramString)
  {
    if (paramString.equals("com.tencent.mobileqq.troop.activity.OpenTroopMemberListActivity")) {
      return TroopGPUProxyActivity.class;
    }
    return TroopProxyActivity.class;
  }
  
  public static void a(Activity paramActivity)
  {
    Dialog localDialog = a(paramActivity);
    a(paramActivity, new Intent(), localDialog, "com.tencent.mobileqq.troop.activity.FavOpenTroopActivity", null, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", null, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", null, paramInt);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "troop_plugin.apk";
    localPluginParams.d = "群资料卡";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString2;
    localPluginParams.e = paramString1;
    localPluginParams.jdField_a_of_type_JavaLangClass = a(localPluginParams.e);
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localPluginParams.jdField_b_of_type_Int = paramInt;
    localPluginParams.c = 10000;
    localPluginParams.f = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "Test.apk";
    localPluginParams.d = "测试";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.example.test.MainActivity";
    localPluginParams.jdField_a_of_type_JavaLangClass = a(localPluginParams.e);
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_b_of_type_Int = 0;
    localPluginParams.c = 10000;
    localPluginParams.f = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.OpenTroopInfoActivity", paramString, paramInt);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileUploadActivity", null, 0);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileViewerActivity", null, 0);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, String paramString, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.OpenTroopMemberListActivity", paramString, paramInt);
  }
  
  public String getPluginID()
  {
    return "troop_plugin.apk";
  }
  
  public Class getProxyActivity(String paramString)
  {
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.troop.TroopProxyActivity
 * JD-Core Version:    0.7.0.1
 */