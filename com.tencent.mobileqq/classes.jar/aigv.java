import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.statistics.battery.BatteryIPCModule;
import com.tencent.mobileqq.statistics.battery.BatteryLog;
import com.tencent.mobileqq.statistics.battery.BatteryStatsImpl;
import com.tencent.mobileqq.statistics.battery.HighFrequencyDetector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aigv
  extends aigp
  implements Handler.Callback, HookMethodCallback
{
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = 30000L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long = 600000L;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_c_of_type_Long = 7200000L;
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public aigv(BatteryStatsImpl paramBatteryStatsImpl, String paramString)
  {
    super(paramBatteryStatsImpl, paramString);
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 1) && (this.jdField_a_of_type_Array2dOfJavaLangString[0].length >= 1))
    {
      this.jdField_a_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][0]).intValue() * 1000L);
      this.jdField_a_of_type_Long *= 10L;
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 2) && (this.jdField_a_of_type_Array2dOfJavaLangString[1].length >= 2))
    {
      this.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][0]).intValue();
      this.jdField_b_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][1]).intValue() * 60 * 1000L);
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 3) && (this.jdField_a_of_type_Array2dOfJavaLangString[2].length >= 2))
    {
      this.jdField_b_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[2][0]).intValue();
      this.jdField_c_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[2][1]).intValue() * 60 * 1000L);
    }
  }
  
  private final void a(aigx paramaigx, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramaigx.b);
    localBundle.putString("key_tag", paramaigx.jdField_a_of_type_JavaLangString);
    localBundle.putInt("key_flag", paramaigx.jdField_a_of_type_Int);
    localBundle.putLong("key_time", paramaigx.a());
    if (!BatteryStatsImpl.a())
    {
      BatteryIPCModule.a().a(localBundle);
      return;
    }
    a(localBundle);
  }
  
  private final void a(boolean paramBoolean)
  {
    HashMap localHashMap2 = this.jdField_b_of_type_JavaUtilHashMap;
    long l2 = 0L;
    long l1 = 0L;
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      int k;
      try
      {
        HashMap localHashMap1 = this.jdField_b_of_type_JavaUtilHashMap;
        localObject2 = localHashMap1.values().iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aigw)((Iterator)localObject2).next();
          k = ((aigw)localObject3).jdField_a_of_type_JavaUtilHashSet.size();
          if ((((aigw)localObject3).jdField_a_of_type_Int & 0x1) <= 0) {
            break label506;
          }
          j = 1;
          localObject3 = ((aigw)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label511;
          }
          localObject4 = (Pair)((Iterator)localObject3).next();
          l2 += ((Long)((Pair)localObject4).second).longValue();
          if (j == 0) {
            break label503;
          }
          l1 = ((Long)((Pair)localObject4).second).longValue() + l1;
          break label503;
          localHashMap1 = this.jdField_c_of_type_JavaUtilHashMap;
          continue;
        }
        localObject3 = this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
        if (!paramBoolean) {
          break label522;
        }
        localObject2 = "fg30WlCount";
        BatteryStatsImpl.b((BatteryStatsImpl)localObject3, new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l2), "|", String.valueOf(l1) });
        Object localObject4 = localHashMap1.keySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label494;
        }
        String str1 = (String)((Iterator)localObject4).next();
        localObject3 = (aigw)localHashMap1.get(str1);
        StringBuilder localStringBuilder = BatteryLog.a();
        localObject2 = ((aigw)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(String.valueOf(((Pair)localObject5).first)).append(",").append(String.valueOf(((Pair)localObject5).second));
          i += 1;
          if (i >= ((aigw)localObject3).jdField_a_of_type_JavaUtilHashSet.size()) {
            break label519;
          }
          localStringBuilder.append("#");
          break label519;
        }
        Object localObject5 = this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
        if (paramBoolean)
        {
          localObject2 = "fg30WlUse";
          String str2 = ((aigw)localObject3).jdField_a_of_type_JavaLangString.replace("|", "_");
          if ((((aigw)localObject3).jdField_a_of_type_Int & 0x1) <= 0) {
            break label529;
          }
          localObject3 = "1";
          BatteryStatsImpl.b((BatteryStatsImpl)localObject5, new String[] { localObject2, "|", str2, "|", localObject3, "|", str1, "|", localStringBuilder.toString() });
          continue;
        }
        localObject2 = "bg5WlUse";
      }
      finally {}
      continue;
      label494:
      localObject1.clear();
      return;
      label503:
      continue;
      label506:
      int j = 0;
      continue;
      label511:
      i += k;
      continue;
      label519:
      continue;
      label522:
      Object localObject2 = "bg5WlCount";
      continue;
      label529:
      Object localObject3 = "0";
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    int i = paramBundle.getInt("key_action");
    if ((this.jdField_a_of_type_Boolean) && ((i == 3) || (i == 4) || (i == 5)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BatteryStats", 2, new Object[] { "WakeLock.onOtherProcReport:action=", Integer.valueOf(i), ", tag=", paramBundle.getString("key_tag"), ", stack=", paramBundle.getString("key_stack"), ", time=", Long.valueOf(paramBundle.getLong("key_time")) });
      }
      String str = paramBundle.getString("key_stack");
      if (i == 3) {
        synchronized (this.jdField_b_of_type_JavaUtilHashMap)
        {
          aigw localaigw2;
          aigw localaigw1;
          if (this.jdField_b_of_type_Boolean)
          {
            localaigw2 = (aigw)this.jdField_b_of_type_JavaUtilHashMap.get(str);
            localaigw1 = localaigw2;
            if (localaigw2 == null)
            {
              localaigw1 = new aigw(this, null);
              localaigw1.jdField_a_of_type_Int = paramBundle.getInt("key_flag");
              localaigw1.jdField_a_of_type_JavaLangString = paramBundle.getString("key_tag");
              this.jdField_b_of_type_JavaUtilHashMap.put(str, localaigw1);
            }
            localaigw1.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          if ((this.jdField_c_of_type_Boolean) && (this.d))
          {
            localaigw2 = (aigw)this.jdField_c_of_type_JavaUtilHashMap.get(str);
            localaigw1 = localaigw2;
            if (localaigw2 == null)
            {
              localaigw1 = new aigw(this, null);
              localaigw1.jdField_a_of_type_Int = paramBundle.getInt("key_flag");
              localaigw1.jdField_a_of_type_JavaLangString = paramBundle.getString("key_tag");
              this.jdField_c_of_type_JavaUtilHashMap.put(str, localaigw1);
            }
            localaigw1.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          return;
        }
      }
      if (i == 4)
      {
        BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wlNotRelease", "|", paramBundle.getString("key_stack"), "|", paramBundle.getString("key_tag"), "|", paramBundle.getInt("key_flag") + "", "|", paramBundle.getLong("key_time") + "" });
        return;
      }
      if (i == 5) {
        BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wlTimeout", "|", paramBundle.getString("key_stack"), "|", paramBundle.getString("key_tag"), "|", paramBundle.getInt("key_flag") + "", "|", paramBundle.getLong("key_time") + "" });
      }
    }
  }
  
  public void a(String paramString, Object paramObject1, Object[] paramArrayOfObject, Object paramObject2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      return;
    }
    Object localObject2;
    Object localObject3;
    label291:
    Object localObject4;
    label330:
    long l;
    label530:
    do
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          if ("newWakeLock".equals(paramString))
          {
            paramObject1 = new WeakReference((PowerManager.WakeLock)paramObject2);
            paramObject2 = new aigx(this);
            paramObject2.jdField_a_of_type_Int = ((Integer)paramArrayOfObject[0]).intValue();
            paramObject2.jdField_a_of_type_JavaLangString = ((String)paramArrayOfObject[1]);
            paramObject2.b = BatteryStatsImpl.a().toString();
            paramObject2.c = String.valueOf(paramObject2.hashCode());
            this.jdField_a_of_type_JavaUtilHashMap.put(paramObject1, paramObject2);
            BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { paramString, "|", paramObject2.c, "|", String.valueOf(paramObject2.jdField_a_of_type_Int), "|", paramObject2.jdField_a_of_type_JavaLangString, "|", paramObject2.b });
            return;
          }
        }
        if (!"acquire".equals(paramString)) {
          break;
        }
        paramObject2 = BatteryStatsImpl.a().toString();
        localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          localObject3 = (aigx)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if (((WeakReference)localObject2).get() == paramObject1)
          {
            if (paramArrayOfObject == null) {
              break label1221;
            }
            if (paramArrayOfObject.length == 0)
            {
              break label1221;
              localObject4 = ((aigx)localObject3).a(paramObject2);
              BatteryStatsImpl localBatteryStatsImpl = this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
              String str = ((aigx)localObject3).c;
              if (!((Boolean)((Pair)localObject4).first).booleanValue()) {
                break label1229;
              }
              paramString = paramObject2;
              Object localObject1;
              BatteryStatsImpl.a(localBatteryStatsImpl, new String[] { "wl_usg", "|", str, "|0|", paramString, "|", String.valueOf(((Pair)localObject4).second), "|", String.valueOf(localObject1) });
              paramString = ((aigx)localObject3).a((PowerManager.WakeLock)paramObject1, paramObject2, localObject1);
              if (!((Boolean)paramString.first).booleanValue()) {
                break label530;
              }
              localObject4 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
              ((Message)localObject4).obj = localObject2;
              this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject4, this.jdField_a_of_type_Long);
            }
            for (;;)
            {
              if (paramString.second == null) {
                break label652;
              }
              BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, 4, 0, 0, "Acquire " + ((aigx)localObject3).jdField_a_of_type_JavaLangString + " too frequently", HighFrequencyDetector.a((List)paramString.second));
              break;
              l = ((Long)paramArrayOfObject[0]).longValue();
              break label291;
              if (l >= this.jdField_a_of_type_Long)
              {
                BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wl_alm", "|", ((aigx)localObject3).c, "|0|", String.valueOf(((Pair)localObject4).second) });
                BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, 4, 1, 0, "Acquire " + ((aigx)localObject3).jdField_a_of_type_JavaLangString + " too long time", "CallStack: " + ((aigx)localObject3).b);
              }
            }
          }
          else if (((WeakReference)localObject2).get() == null)
          {
            if (((aigx)localObject3).a())
            {
              BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, 4, 2, 1, "WakeLock " + ((aigx)localObject3).jdField_a_of_type_JavaLangString + " not release", "CreateStack: " + ((aigx)localObject3).b);
              BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wl_alm", "|", ((aigx)localObject3).c, "|1" });
              a((aigx)localObject3, 4);
            }
            ((aigx)localObject3).a();
            localIterator.remove();
          }
        }
      }
    } while (!"release".equals(paramString));
    label652:
    paramObject2 = BatteryStatsImpl.a().toString();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label824:
    label880:
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = (WeakReference)localIterator.next();
      paramString = (aigx)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (((WeakReference)localObject2).get() == paramObject1)
      {
        if (paramArrayOfObject == null) {
          break label1236;
        }
        if (paramArrayOfObject.length == 0)
        {
          break label1236;
          localObject3 = paramString.a((PowerManager.WakeLock)paramObject1, i);
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, localObject2);
            BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wl_tm", "|", paramString.c, "|", String.valueOf(((Pair)localObject3).second) });
            a(paramString, 3);
          }
          localObject2 = paramString.a(paramObject2);
          localObject3 = this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
          localObject4 = paramString.c;
          if (!((Boolean)((Pair)localObject2).first).booleanValue()) {
            break label1242;
          }
        }
      }
    }
    label1221:
    label1229:
    label1236:
    label1242:
    for (paramString = paramObject2;; paramString = "")
    {
      BatteryStatsImpl.a((BatteryStatsImpl)localObject3, new String[] { "wl_usg", "|", localObject4, "|1|", paramString, "|", String.valueOf(((Pair)localObject2).second), "|", String.valueOf(i) });
      break label824;
      i = ((Integer)paramArrayOfObject[0]).intValue();
      break label880;
      if (((WeakReference)localObject2).get() != null) {
        break label824;
      }
      if (paramString.a())
      {
        BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, 4, 2, 1, "WakeLock " + paramString.jdField_a_of_type_JavaLangString + " not release", "CreateStack: " + paramString.b);
        BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wl_alm", "|", paramString.c, "|1" });
        a(paramString, 4);
      }
      paramString.a();
      localIterator.remove();
      break label824;
      break;
      l = -1L;
      break label291;
      paramString = "";
      break label330;
      i = -1;
      break label880;
    }
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!"acquire".equals(paramMethodHookParam.method.getName())) {
      a(paramMethodHookParam.method.getName(), paramMethodHookParam.thisObject, paramMethodHookParam.args, paramMethodHookParam.result);
    }
  }
  
  public void b()
  {
    super.b();
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      this.jdField_c_of_type_JavaUtilHashMap.clear();
      return;
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ("acquire".equals(paramMethodHookParam.method.getName())) {
      a(paramMethodHookParam.method.getName(), paramMethodHookParam.thisObject, paramMethodHookParam.args, paramMethodHookParam.result);
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        JavaHookBridge.findAndHookMethod(PowerManager.class, "newWakeLock", new Object[] { Integer.TYPE, String.class, this });
        JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "acquire", new Object[] { this });
        JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "acquire", new Object[] { Long.TYPE, this });
        JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "release", new Object[] { Integer.TYPE, this });
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("BatteryStats", 2, "", localThrowable);
  }
  
  public void e()
  {
    super.e();
    if ((BatteryStatsImpl.a()) && (this.jdField_a_of_type_Boolean) && (BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl))) {
      a(true);
    }
  }
  
  public void f()
  {
    super.f();
    if ((BatteryStatsImpl.a()) && (this.jdField_a_of_type_Boolean) && (BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl))) {
      a(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramMessage = (WeakReference)paramMessage.obj;
        paramMessage = (aigx)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessage);
        if (paramMessage != null)
        {
          a(paramMessage, 5);
          BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wl_alm", "|", paramMessage.c, "|0|0" });
          BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, 4, 1, 0, "Acquire " + paramMessage.jdField_a_of_type_JavaLangString + " too long time", "CallStack: " + paramMessage.b);
        }
        while (!QLog.isColorLevel()) {
          return false;
        }
        BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, "wake lock is lost ?");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aigv
 * JD-Core Version:    0.7.0.1
 */