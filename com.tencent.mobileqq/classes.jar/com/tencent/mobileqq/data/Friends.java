package com.tencent.mobileqq.data;

import QQService.EVIPSPEC;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.PrimaryKeyJoinColumn;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

@PrimaryKeyJoinColumn
public class Friends
  extends Entity
  implements Cloneable
{
  public static final int CLIENT_DEFAULT = 0;
  public static final int CLIENT_IPHONE = 3;
  public static final int CLIENT_MOBILE = 2;
  public static final int CLIENT_PC = 1;
  public static final int FRIEND_TYPE_QIM = 1;
  public static final int GATHER_TYPE_GATHERED = 1;
  public static final int GATHER_TYPE_NORMAL = 0;
  public static final int GATHER_TYPE_RECOMMENDED = 2;
  private static final long LOGIN_TYPE_OFFLINE = 10L;
  public static int MULTI_FLAGS_MASK_OLYMPICTORCH = 2;
  public static int MULTI_FLAGS_MASK_SHIELD = 1;
  public static final int NET_2G = 2;
  public static final int NET_3G = 3;
  public static final int NET_4G = 4;
  public static final int NET_UNKNOW = 0;
  public static final int NET_WIFI = 1;
  public static final int TERM_TYPE_ANDROID_PAD = 68104;
  public static final int TERM_TYPE_AOL_CHAOJIHUIYUAN = 73730;
  public static final int TERM_TYPE_AOL_HUIYUAN = 73474;
  public static final int TERM_TYPE_AOL_SQQ = 69378;
  public static final int TERM_TYPE_CAR = 65806;
  public static final int TERM_TYPE_HRTX_IPHONE = 66566;
  public static final int TERM_TYPE_HRTX_PC = 66561;
  public static final int TERM_TYPE_MC_3G = 65795;
  public static final int TERM_TYPE_MISRO_MSG = 69634;
  public static final int TERM_TYPE_MOBILE_ANDROID = 65799;
  public static final int TERM_TYPE_MOBILE_ANDROID_NEW = 72450;
  public static final int TERM_TYPE_MOBILE_HD = 65805;
  public static final int TERM_TYPE_MOBILE_HD_NEW = 71426;
  public static final int TERM_TYPE_MOBILE_IPAD = 68361;
  public static final int TERM_TYPE_MOBILE_IPAD_NEW = 72194;
  public static final int TERM_TYPE_MOBILE_IPHONE = 67586;
  public static final int TERM_TYPE_MOBILE_OTHER = 65794;
  public static final int TERM_TYPE_MOBILE_PC = 65793;
  public static final int TERM_TYPE_MOBILE_WINPHONE_NEW = 72706;
  public static final int TERM_TYPE_QQ_FORELDER = 70922;
  public static final int TERM_TYPE_QQ_SERVICE = 71170;
  public static final int TERM_TYPE_TV_QQ = 69130;
  public static final int TERM_TYPE_WIN8 = 69899;
  public static final int TERM_TYPE_WINPHONE = 65804;
  public long abilityBits;
  public int age;
  public String alias;
  @Deprecated
  public byte cNetwork = 0;
  public byte cSpecialFlag;
  public long datetime;
  public byte detalStatusFlag;
  public int eNetwork = 0;
  @Deprecated
  public short faceid;
  public int friendType;
  public byte gathtertype = 0;
  public byte gender;
  public int groupid = -1;
  @Deprecated
  public int hollywoodVipInfo;
  public int iTermType;
  @Deprecated
  public byte isIphoneOnline;
  @Deprecated
  public boolean isMqqOnLine;
  @Deprecated
  public byte isRemark = 1;
  public long lastLoginType;
  public int mComparePartInt;
  public String mCompareSpell;
  @Deprecated
  public byte memberLevel;
  public int multiFlags;
  public volatile String name;
  public int namePlateOfKingDan;
  public boolean namePlateOfKingDanDisplatSwitch;
  public long namePlateOfKingGameId;
  public long namePlateOfKingLoginTime;
  @notColumn
  public int netTypeIconId;
  public int qqVipInfo;
  public String recommReason;
  public String remark;
  @Deprecated
  public byte[] richBuffer;
  @notColumn
  @Deprecated
  public RichStatus richStatus;
  @Deprecated
  public long richTime;
  public long showLoginClient;
  @Deprecated
  public String signature;
  public String smartRemark;
  @Deprecated
  public byte sqqOnLineState;
  @Deprecated
  public byte sqqtype;
  @Deprecated
  public byte status = 10;
  public String strMasterUin = "";
  @notColumn
  public String strTermDesc;
  public int superQqInfo;
  public int superVipInfo;
  @unique
  public String uin;
  
  public static boolean isValidUin(long paramLong)
  {
    return paramLong > 10000L;
  }
  
  public static boolean isValidUin(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("Q.contacttab.", 2, "Friends clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
    this.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
    this.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
    this.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
    this.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
    this.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
    this.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
    this.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
    this.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
    this.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
    this.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
    this.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
    this.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
    this.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
    this.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
    this.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
    this.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
    this.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
    this.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
    this.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
    this.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
    this.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
    return true;
  }
  
  public String getFriendName()
  {
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    return this.uin;
  }
  
  public String getFriendNick()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    return this.uin;
  }
  
  public String getFriendNickWithAlias()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    if (!TextUtils.isEmpty(this.alias)) {
      return this.alias;
    }
    return this.uin;
  }
  
  public String getFriendNickWithoutUin()
  {
    String str = "";
    if (!TextUtils.isEmpty(this.remark)) {
      str = this.remark;
    }
    while (TextUtils.isEmpty(this.name)) {
      return str;
    }
    return this.name;
  }
  
  public long getLastLoginType()
  {
    if (this.lastLoginType == 0L) {
      return 10L;
    }
    return this.lastLoginType;
  }
  
  public int getNetWorkType()
  {
    int j = 2;
    OnlineStatusIconHelper localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
    int i;
    if (this.eNetwork == 0)
    {
      if ((this.iTermType == 69378) || (this.iTermType == 73474) || (this.iTermType == 73730)) {
        i = 0;
      }
      do
      {
        return i;
        i = j;
      } while (1 != localOnlineStatusIconHelper.a(this.iTermType, 1));
    }
    if (1 != localOnlineStatusIconHelper.a(this.iTermType, 1)) {
      i = j;
    }
    switch (this.netTypeIconId)
    {
    case 2: 
    case 5: 
    case 6: 
    default: 
      if ((this.netTypeIconId == 7) || (this.netTypeIconId == 8) || (this.netTypeIconId == 9)) {}
      switch (this.netTypeIconId)
      {
      default: 
        return this.eNetwork;
      }
    case 1: 
      return 1;
    case 3: 
      return 3;
    case 4: 
      return 4;
    case 7: 
      return 7;
    case 8: 
      return 8;
    }
    return 9;
    return 7;
    return 8;
    return 9;
  }
  
  public int getServiceLevel(EVIPSPEC paramEVIPSPEC)
  {
    switch (paramEVIPSPEC.value())
    {
    default: 
      return 0;
    case 1: 
      return this.qqVipInfo & 0xFFFF;
    case 2: 
      return this.superQqInfo & 0xFFFF;
    }
    return this.superVipInfo & 0xFFFF;
  }
  
  public int getServiceType(EVIPSPEC paramEVIPSPEC)
  {
    switch (paramEVIPSPEC.value())
    {
    default: 
      return 0;
    case 1: 
      return (this.qqVipInfo & 0xFF0000) >>> 16;
    case 2: 
      return (this.superQqInfo & 0xFF0000) >>> 16;
    }
    return (this.superVipInfo & 0xFF0000) >>> 16;
  }
  
  public boolean isFriend()
  {
    return this.groupid >= 0;
  }
  
  public boolean isServiceEnabled(EVIPSPEC paramEVIPSPEC)
  {
    boolean bool = true;
    switch (paramEVIPSPEC.value())
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while ((this.qqVipInfo & 0xFF000000) != 0);
        return false;
      } while ((this.superQqInfo & 0xFF000000) != 0);
      return false;
    } while ((this.superVipInfo & 0xFF000000) != 0);
    return false;
  }
  
  public boolean isShield()
  {
    return (this.multiFlags & MULTI_FLAGS_MASK_SHIELD) > 0;
  }
  
  public void setOlympicTorchFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.multiFlags |= MULTI_FLAGS_MASK_OLYMPICTORCH;
      return;
    }
    this.multiFlags &= (MULTI_FLAGS_MASK_OLYMPICTORCH ^ 0xFFFFFFFF);
  }
  
  public void setShieldFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.multiFlags |= MULTI_FLAGS_MASK_SHIELD;
      return;
    }
    this.multiFlags &= (MULTI_FLAGS_MASK_SHIELD ^ 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.Friends
 * JD-Core Version:    0.7.0.1
 */