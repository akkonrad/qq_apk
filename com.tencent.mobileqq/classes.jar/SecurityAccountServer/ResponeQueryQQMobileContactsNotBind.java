package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeQueryQQMobileContactsNotBind
  extends JceStruct
{
  static ArrayList cache_BindFriendContacts;
  static ArrayList cache_BindNotFriendContacts;
  static byte[] cache_sessionSid = (byte[])new byte[1];
  public ArrayList BindFriendContacts;
  public ArrayList BindNotFriendContacts;
  public String MobileUniqueNo = "";
  public boolean isChangeDev;
  public long lastUsedFlag = 1L;
  public long nextFlag;
  public byte[] sessionSid;
  public long timeStamp;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
    cache_BindNotFriendContacts = new ArrayList();
    Object localObject = new NotBindContactNotFriendInfo();
    cache_BindNotFriendContacts.add(localObject);
    cache_BindFriendContacts = new ArrayList();
    localObject = new NotBindContactFriendInfo();
    cache_BindFriendContacts.add(localObject);
  }
  
  public ResponeQueryQQMobileContactsNotBind() {}
  
  public ResponeQueryQQMobileContactsNotBind(long paramLong1, byte[] paramArrayOfByte, ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.nextFlag = paramLong1;
    this.sessionSid = paramArrayOfByte;
    this.BindNotFriendContacts = paramArrayList1;
    this.BindFriendContacts = paramArrayList2;
    this.MobileUniqueNo = paramString;
    this.lastUsedFlag = paramLong2;
    this.timeStamp = paramLong3;
    this.isChangeDev = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 1, true));
    this.BindNotFriendContacts = ((ArrayList)paramJceInputStream.read(cache_BindNotFriendContacts, 2, true));
    this.BindFriendContacts = ((ArrayList)paramJceInputStream.read(cache_BindFriendContacts, 3, true));
    this.MobileUniqueNo = paramJceInputStream.readString(4, true);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 5, false);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 6, false);
    this.isChangeDev = paramJceInputStream.read(this.isChangeDev, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.sessionSid, 1);
    paramJceOutputStream.write(this.BindNotFriendContacts, 2);
    paramJceOutputStream.write(this.BindFriendContacts, 3);
    paramJceOutputStream.write(this.MobileUniqueNo, 4);
    paramJceOutputStream.write(this.lastUsedFlag, 5);
    paramJceOutputStream.write(this.timeStamp, 6);
    paramJceOutputStream.write(this.isChangeDev, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponeQueryQQMobileContactsNotBind
 * JD-Core Version:    0.7.0.1
 */