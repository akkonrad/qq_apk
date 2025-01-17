package cooperation.troop;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import mqq.app.AppRuntime;

public class NearbyVideoProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyVideoProxyBroadcastReceiver", 2, "sendPluginBroadcast:" + paramIntent.getAction());
    }
    Intent localIntent = new Intent(paramIntent.getAction());
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("action", paramIntent.getAction());
    paramIntent = new IPluginManager.PluginParams(1);
    paramIntent.b = "nearby_video_chat_plugin.apk";
    paramIntent.d = "附近的人随机视频聊";
    paramIntent.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramIntent.e = "com.tencent.mobileqq.nearbyvideochat.service.NearbyVideoMsgBroadcastReceiver";
    paramIntent.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramContext, paramIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyVideoProxyBroadcastReceiver", 2, "onReceive:" + paramIntent.getAction());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop.NearbyVideoProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */