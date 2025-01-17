package cooperation.qzone.util;

import anar;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkState
{
  public static final int NET_TYPE_2G = 3;
  public static final int NET_TYPE_3G = 2;
  public static final int NET_TYPE_4G = 4;
  public static final int NET_TYPE_UNKNOWN = 0;
  public static final int NET_TYPE_WIFI = 1;
  private static final String TAG = "NetworkState";
  private static Map mApnMap = new HashMap();
  private static INetEventHandler netEventHandler;
  private static List observers = new ArrayList();
  private static String providerName;
  
  static
  {
    netEventHandler = new anar();
    mApnMap.put("unknown", Integer.valueOf(0));
    mApnMap.put("cmnet", Integer.valueOf(1));
    mApnMap.put("cmwap", Integer.valueOf(2));
    mApnMap.put("3gnet", Integer.valueOf(3));
    mApnMap.put("3gwap", Integer.valueOf(4));
    mApnMap.put("uninet", Integer.valueOf(5));
    mApnMap.put("uniwap", Integer.valueOf(6));
    mApnMap.put("wifi", Integer.valueOf(7));
    mApnMap.put("ctwap", Integer.valueOf(8));
    mApnMap.put("ctnet", Integer.valueOf(9));
    mApnMap.put("cmcc", Integer.valueOf(10));
    mApnMap.put("unicom", Integer.valueOf(11));
    mApnMap.put("cmct", Integer.valueOf(12));
    registerReceiver();
  }
  
  public static String IntAddr2Ip(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".").append(paramInt >> 8 & 0xFF).append(".").append(paramInt >> 16 & 0xFF).append(".").append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static void addListener(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (observers)
    {
      if (!observers.contains(paramNetworkStateListener)) {
        observers.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public static String getAPN()
  {
    Object localObject;
    if (AppNetConnInfo.isWifiConn()) {
      localObject = "wifi";
    }
    String str;
    do
    {
      return localObject;
      str = AppNetConnInfo.getCurrentAPN();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return "unknown";
  }
  
  public static int getApnValue()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return 0;
      localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    } while ((localNetworkInfo == null) || (!localNetworkInfo.isConnectedOrConnecting()));
    if (1 == localNetworkInfo.getType()) {
      return 4;
    }
    int i = 5;
    if (mApnMap.get(localNetworkInfo.getExtraInfo()) != null) {
      i = ((Integer)mApnMap.get(localNetworkInfo.getExtraInfo())).intValue();
    }
    switch (i)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  public static boolean getIsUnicomNetWork()
  {
    String str = getAPN();
    if (TextUtils.isEmpty(str)) {}
    while ((!str.equalsIgnoreCase("UNIWAP")) && (!str.equalsIgnoreCase("UNINET")) && (!str.equalsIgnoreCase("3GWAP")) && (!str.equalsIgnoreCase("3GNET")) && (!str.equalsIgnoreCase("WONET"))) {
      return false;
    }
    return true;
  }
  
  public static int getNetworkType()
  {
    int i = 0;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 0;
    case 1: 
      return 3;
    case 2: 
      return 2;
    }
    return 4;
  }
  
  public static String getProviderName()
  {
    String str;
    if (TextUtils.isEmpty(providerName))
    {
      str = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getSubscriberId();
      if ((str != null) && (!"".equals(str))) {
        break label46;
      }
      providerName = "unknown";
    }
    for (;;)
    {
      return providerName;
      label46:
      if ((str.startsWith("46000")) || (str.startsWith("46002"))) {
        providerName = "ChinaMobile";
      } else if (str.startsWith("46001")) {
        providerName = "ChinaUnicom";
      } else if (str.startsWith("46003")) {
        providerName = "ChinaTelecom";
      } else {
        providerName = "unknown";
      }
    }
  }
  
  public static boolean isMobile()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean isNetSupport()
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean isWap()
  {
    if (AppNetConnInfo.isMobileConn())
    {
      try
      {
        i = ((Integer)mApnMap.get(AppNetConnInfo.getCurrentAPN())).intValue();
        switch (i)
        {
        default: 
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = 5;
        }
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static boolean isWifiConn()
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  private static void notifyObservers(boolean paramBoolean)
  {
    synchronized (observers)
    {
      NetworkState.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkState.NetworkStateListener[observers.size()];
      observers.toArray(arrayOfNetworkStateListener);
      if (arrayOfNetworkStateListener != null)
      {
        int j = arrayOfNetworkStateListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfNetworkStateListener[i].onNetworkConnect(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public static void registerReceiver()
  {
    try
    {
      AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), netEventHandler);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void removeListener(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    synchronized (observers)
    {
      observers.remove(paramNetworkStateListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.util.NetworkState
 * JD-Core Version:    0.7.0.1
 */