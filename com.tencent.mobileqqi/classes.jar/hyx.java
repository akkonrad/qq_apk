import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;

public abstract class hyx
{
  hyx(TraeAudioManager paramTraeAudioManager) {}
  
  public abstract String a();
  
  String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_OFF";
      continue;
      str = "STATE_TURNING_ON";
      continue;
      str = "STATE_ON";
      continue;
      str = "STATE_TURNING_OFF";
    }
  }
  
  public abstract void a();
  
  abstract void a(Context paramContext, Intent paramIntent);
  
  public void a(Context paramContext, Intent paramIntent, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + a(i));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + a(j));
      }
      if (i == 10) {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "    BT off");
        }
      }
    }
    while ((("android.bluetooth.device.action.ACL_CONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)) || (("android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)))
    {
      int i;
      int j;
      paramDeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
      do
      {
        return;
      } while ((i != 12) || (!QLog.isColorLevel()));
      QLog.w("TRAE", 2, "BT OFF-->ON,Visiable it...");
      return;
    }
    a(paramContext, paramIntent);
  }
  
  abstract void a(IntentFilter paramIntentFilter);
  
  public abstract boolean a();
  
  public abstract boolean a(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager);
  
  String b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "SCO_AUDIO_STATE_DISCONNECTED";
      continue;
      str = "SCO_AUDIO_STATE_CONNECTED";
      continue;
      str = "SCO_AUDIO_STATE_CONNECTING";
      continue;
      str = "SCO_AUDIO_STATE_ERROR";
    }
  }
  
  public void b(IntentFilter paramIntentFilter)
  {
    paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    a(paramIntentFilter);
  }
  
  String c(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_DISCONNECTED";
      continue;
      str = "STATE_CONNECTING";
      continue;
      str = "STATE_CONNECTED";
      continue;
      str = "STATE_DISCONNECTING";
    }
  }
  
  String d(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_DISCONNECTED";
      continue;
      str = "STATE_CONNECTING";
      continue;
      str = "STATE_CONNECTED";
      continue;
      str = "STATE_DISCONNECTING";
    }
  }
  
  String e(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 11: 
    default: 
      str = "unknow:" + paramInt;
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_AUDIO_CONNECTED";
      continue;
      str = "STATE_AUDIO_DISCONNECTED";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hyx
 * JD-Core Version:    0.7.0.1
 */