package com.tencent.qphone.base.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.util.HashMap;

public class FromServiceMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new FromServiceMsg.1();
  private static final String tag = "FromServiceMsg";
  private static final String version = "version";
  private int appId;
  private int appSeq = -1;
  public HashMap attributes = new HashMap();
  private String errorMsg = "";
  public Bundle extraData = new Bundle();
  private int flag;
  private byte fromVersion = 1;
  private MsfCommand msfCommand = MsfCommand.unknown;
  private byte[] msgCookie = new byte[0];
  private int resultCode;
  private String serviceCmd;
  private int ssoSeq = -1;
  private String uin;
  private byte[] wupBuffer = new byte[0];
  
  public FromServiceMsg()
  {
    try
    {
      this.extraData.putByte("version", this.fromVersion);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public FromServiceMsg(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.resultCode = 1001;
    this.appId = paramInt1;
    this.appSeq = paramInt2;
    this.uin = paramString1;
    this.serviceCmd = paramString2;
    try
    {
      this.extraData.putByte("version", this.fromVersion);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public FromServiceMsg(int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.resultCode = 1001;
    this.appId = paramInt1;
    this.appSeq = paramInt2;
    this.uin = paramString1;
    this.serviceCmd = paramString2;
    this.msgCookie = paramArrayOfByte;
    try
    {
      this.extraData.putByte("version", this.fromVersion);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public FromServiceMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public FromServiceMsg(String paramString1, String paramString2)
  {
    this(-1, -1, paramString1, paramString2);
    try
    {
      this.extraData.putByte("version", this.fromVersion);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public Object addAttribute(String paramString, Object paramObject)
  {
    return this.attributes.put(paramString, paramObject);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAppId()
  {
    return this.appId;
  }
  
  public int getAppSeq()
  {
    return this.appSeq;
  }
  
  public Object getAttribute(String paramString)
  {
    return this.attributes.get(paramString);
  }
  
  public Object getAttribute(String paramString, Object paramObject)
  {
    if (!this.attributes.containsKey(paramString)) {
      return paramObject;
    }
    return this.attributes.get(paramString);
  }
  
  public HashMap getAttributes()
  {
    return this.attributes;
  }
  
  public int getBusinessFailCode()
  {
    return this.resultCode;
  }
  
  public int getBusinessFailCode(int paramInt)
  {
    if (this.resultCode == -1) {
      return paramInt;
    }
    return this.resultCode;
  }
  
  public String getBusinessFailMsg()
  {
    return this.errorMsg;
  }
  
  public int getFlag()
  {
    return this.flag;
  }
  
  public byte getFromVersion()
  {
    return this.fromVersion;
  }
  
  public MsfCommand getMsfCommand()
  {
    return this.msfCommand;
  }
  
  public byte[] getMsgCookie()
  {
    return this.msgCookie;
  }
  
  public int getRequestSsoSeq()
  {
    return this.ssoSeq;
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
  
  public String getServiceCmd()
  {
    return this.serviceCmd;
  }
  
  public String getShortStringForLog()
  {
    try
    {
      int j = "FromServiceMsg".length();
      if (this.serviceCmd == null) {}
      for (int i = 4;; i = this.serviceCmd.length())
      {
        StringBuilder localStringBuilder = new StringBuilder(i + (j + 8 + 8 + 10 + 10 + 10 + 5 + 10 + 12) + 7 + 10 + 8 + 10 + 10);
        localStringBuilder.append("FromServiceMsg");
        localStringBuilder.append(" msName:");
        localStringBuilder.append(this.msfCommand);
        localStringBuilder.append(" ssoSeq:");
        localStringBuilder.append(getRequestSsoSeq());
        localStringBuilder.append(" serviceCmd:");
        localStringBuilder.append(this.serviceCmd);
        localStringBuilder.append(" appSeq:");
        localStringBuilder.append(this.appSeq);
        localStringBuilder.append(" failCode:");
        localStringBuilder.append(this.resultCode);
        return localStringBuilder.toString();
      }
      return "fsm getString error";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getStringForLog()
  {
    try
    {
      int j = "FromServiceMsg".length();
      int k = this.msfCommand.toString().length();
      int m = this.errorMsg.length();
      if (this.serviceCmd == null) {}
      for (int i = 4;; i = this.serviceCmd.length())
      {
        StringBuilder localStringBuilder = new StringBuilder(i + (j + 8 + k + 8 + 10 + 10 + 10 + 10 + m + 5 + 10 + 12) + 7 + 10 + 8 + 10 + 10);
        localStringBuilder.append("FromServiceMsg");
        localStringBuilder.append(" msName:");
        localStringBuilder.append(this.msfCommand);
        localStringBuilder.append(" ssoSeq:");
        localStringBuilder.append(getRequestSsoSeq());
        localStringBuilder.append(" failCode:");
        localStringBuilder.append(this.resultCode);
        localStringBuilder.append(" errorMsg:");
        localStringBuilder.append(this.errorMsg);
        localStringBuilder.append(" uin:");
        localStringBuilder.append(MsfSdkUtils.getShortUin(this.uin));
        localStringBuilder.append(" serviceCmd:");
        localStringBuilder.append(this.serviceCmd);
        localStringBuilder.append(" appId:");
        localStringBuilder.append(this.appId);
        localStringBuilder.append(" appSeq:");
        localStringBuilder.append(this.appSeq);
        return localStringBuilder.toString();
      }
      return "fsm getString error";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public byte[] getWupBuffer()
  {
    return this.wupBuffer;
  }
  
  public boolean isSuccess()
  {
    return this.resultCode == 1000;
  }
  
  public void putWupBuffer(byte[] paramArrayOfByte)
  {
    this.wupBuffer = paramArrayOfByte;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    try
    {
      this.appId = paramParcel.readInt();
      this.appSeq = paramParcel.readInt();
      this.resultCode = paramParcel.readInt();
      this.uin = paramParcel.readString();
      this.serviceCmd = paramParcel.readString();
      this.extraData.clear();
      this.extraData = paramParcel.readBundle();
      this.attributes.clear();
      paramParcel.readMap(this.attributes, getClass().getClassLoader());
      if (this.extraData.getByte("version") > 0)
      {
        this.msfCommand = ((MsfCommand)paramParcel.readSerializable());
        this.ssoSeq = paramParcel.readInt();
        this.errorMsg = paramParcel.readString();
        this.wupBuffer = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(this.wupBuffer);
        this.msgCookie = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(this.msgCookie);
        this.flag = paramParcel.readInt();
      }
      return;
    }
    catch (RuntimeException paramParcel)
    {
      Log.d("FromServiceMsg", "readFromParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
  
  public void setAppId(int paramInt)
  {
    this.appId = paramInt;
  }
  
  public void setAppSeq(int paramInt)
  {
    this.appSeq = paramInt;
  }
  
  public void setBusinessFail(int paramInt)
  {
    this.resultCode = paramInt;
  }
  
  public void setBusinessFail(int paramInt1, int paramInt2, String paramString)
  {
    this.resultCode = paramInt2;
    this.errorMsg = paramString;
  }
  
  public void setBusinessFail(int paramInt, String paramString)
  {
    this.resultCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public void setFromVersion(byte paramByte)
  {
    this.fromVersion = paramByte;
  }
  
  public void setMsfCommand(MsfCommand paramMsfCommand)
  {
    this.msfCommand = paramMsfCommand;
  }
  
  public void setMsgCookie(byte[] paramArrayOfByte)
  {
    this.msgCookie = paramArrayOfByte;
  }
  
  public void setMsgFail()
  {
    this.resultCode = 1001;
  }
  
  public void setMsgSuccess()
  {
    this.resultCode = 1000;
  }
  
  public void setRequestSsoSeq(int paramInt)
  {
    this.ssoSeq = paramInt;
  }
  
  public void setServiceCmd(String paramString)
  {
    this.serviceCmd = paramString;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public String toString()
  {
    try
    {
      int j = "FromServiceMsg".length();
      int k = this.msfCommand.toString().length();
      int m = this.errorMsg.length();
      if (this.serviceCmd == null) {}
      for (int i = 4;; i = this.serviceCmd.length())
      {
        StringBuilder localStringBuilder = new StringBuilder(i + (j + 8 + k + 8 + 10 + 10 + 10 + 10 + m + 5 + 10 + 12) + 7 + 10 + 8 + 10 + 10);
        localStringBuilder.append("FromServiceMsg");
        localStringBuilder.append(" msName:");
        localStringBuilder.append(this.msfCommand);
        localStringBuilder.append(" ssoSeq:");
        localStringBuilder.append(getRequestSsoSeq());
        localStringBuilder.append(" failCode:");
        localStringBuilder.append(this.resultCode);
        localStringBuilder.append(" errorMsg:");
        localStringBuilder.append(this.errorMsg);
        localStringBuilder.append(" uin:");
        localStringBuilder.append(this.uin);
        localStringBuilder.append(" serviceCmd:");
        localStringBuilder.append(this.serviceCmd);
        localStringBuilder.append(" appId:");
        localStringBuilder.append(this.appId);
        localStringBuilder.append(" appSeq:");
        localStringBuilder.append(this.appSeq);
        return localStringBuilder.toString();
      }
      return "fsm toString error";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.appId);
      paramParcel.writeInt(this.appSeq);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeString(this.uin);
      paramParcel.writeString(this.serviceCmd);
      paramParcel.writeBundle(this.extraData);
      paramParcel.writeMap(this.attributes);
      if (this.fromVersion > 0)
      {
        paramParcel.writeSerializable(this.msfCommand);
        paramParcel.writeInt(this.ssoSeq);
        paramParcel.writeString(this.errorMsg);
        paramParcel.writeInt(this.wupBuffer.length);
        paramParcel.writeByteArray(this.wupBuffer);
        paramParcel.writeInt(this.msgCookie.length);
        paramParcel.writeByteArray(this.msgCookie);
        paramParcel.writeInt(this.flag);
      }
      return;
    }
    catch (RuntimeException paramParcel)
    {
      Log.d("FromServiceMsg", "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.FromServiceMsg
 * JD-Core Version:    0.7.0.1
 */