package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class NearbyDataManager
  implements Manager
{
  public static byte a;
  private int jdField_a_of_type_Int = 0;
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  
  static
  {
    jdField_a_of_type_Byte = 30;
  }
  
  public NearbyDataManager(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)NearbySPUtil.a(paramQQAppInterface.getCurrentAccountUin(), "nearby_usercard_tab_host", Integer.valueOf(0))).intValue();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)NearbySPUtil.a(paramQQAppInterface.getCurrentAccountUin(), "face_score_switch", Integer.valueOf(0))).intValue() == 1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)NearbySPUtil.a(paramQQAppInterface.getCurrentAccountUin(), "nearby_usercard_tab_guest", Integer.valueOf(-1))).intValue();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)NearbySPUtil.a(paramQQAppInterface.getCurrentAccountUin(), "nearby_usercard_publish", Integer.valueOf(0))).intValue() == 1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public oidb_0x8dd.SelfInfo a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), 4);
    if (localSharedPreferences != null)
    {
      oidb_0x8dd.SelfInfo localSelfInfo = new oidb_0x8dd.SelfInfo();
      localSelfInfo.bytes_nick.set(ByteStringMicro.copyFromUtf8(localSharedPreferences.getString("nick", "")));
      localSelfInfo.uint32_charm_level.set(localSharedPreferences.getInt("charm_level", 0));
      localSelfInfo.uint32_charm.set(localSharedPreferences.getInt("charm", 0));
      localSelfInfo.uint32_vote_num.set(localSharedPreferences.getInt("vote", 0));
      localSelfInfo.uint32_vote_increment.set(localSharedPreferences.getInt("vote_increment", 0));
      localSelfInfo.uint32_god_flag.set(localSharedPreferences.getInt("god_flag", 0));
      localSelfInfo.str_third_line_info.set(localSharedPreferences.getString("third_line", ""));
      localSelfInfo.str_third_line_icon.set(localSharedPreferences.getString("third_line_icon", ""));
      localSelfInfo.uint32_real_video_flag.set(localSharedPreferences.getInt("real_video_auth", 0));
      localSelfInfo.uint32_age.set(localSharedPreferences.getInt("age", 0));
      localSelfInfo.uint32_gender.set(localSharedPreferences.getInt("gender", 0));
      localSelfInfo.uint32_finish_task_num.set(localSharedPreferences.getInt("task_finished", 0));
      localSelfInfo.uint32_all_task_num.set(localSharedPreferences.getInt("task_total", 0));
      QLog.d("NearbyNiche", 2, "readSelfInfo" + localSelfInfo);
      return localSelfInfo;
    }
    QLog.d("NearbyNiche", 2, "readSelfInfo = null");
    return null;
  }
  
  public void a() {}
  
  public void a(NearbyAppInterface paramNearbyAppInterface, oidb_0x8dd.SelfInfo paramSelfInfo)
  {
    int i = 2;
    QLog.d("NearbyNiche", 2, "writeSelfInfo" + paramSelfInfo);
    if (paramSelfInfo == null) {}
    do
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramNearbyAppInterface.getCurrentAccountUin(), 4);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit().putString("nick", paramSelfInfo.bytes_nick.get().toStringUtf8()).putInt("charm_level", paramSelfInfo.uint32_charm_level.get()).putInt("charm", paramSelfInfo.uint32_charm.get()).putString("third_line", paramSelfInfo.str_third_line_info.get()).putString("third_line_icon", paramSelfInfo.str_third_line_icon.get()).putInt("god_flag", paramSelfInfo.uint32_god_flag.get()).putInt("real_video_auth", paramSelfInfo.uint32_real_video_flag.get()).putInt("gender", paramSelfInfo.uint32_gender.get()).putInt("age", paramSelfInfo.uint32_age.get()).putInt("task_finished", paramSelfInfo.uint32_finish_task_num.get()).putInt("task_total", paramSelfInfo.uint32_all_task_num.get());
        if (paramSelfInfo.uint32_vote_num.get() >= 0) {
          ((SharedPreferences.Editor)localObject).putInt("vote", paramSelfInfo.uint32_vote_num.get());
        }
        if (paramSelfInfo.uint32_vote_increment.get() >= 0) {
          ((SharedPreferences.Editor)localObject).putInt("vote_increment", paramSelfInfo.uint32_vote_increment.get());
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
    } while (paramSelfInfo.uint32_gender.get() == -1);
    switch (paramSelfInfo.uint32_gender.get())
    {
    }
    for (i = 0;; i = 1)
    {
      NearbySPUtil.a(paramNearbyAppInterface.getAccount(), "self_gender", Integer.valueOf(i));
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception paramString)
    {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.NearbyDataManager
 * JD-Core Version:    0.7.0.1
 */