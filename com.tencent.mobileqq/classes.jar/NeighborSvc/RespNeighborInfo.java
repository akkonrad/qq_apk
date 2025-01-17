package NeighborSvc;

import NeighborComm.MerchantType;
import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespNeighborInfo
  extends JceStruct
{
  static int cache_eMerchantType;
  static byte[] cache_vFaceID;
  static byte[] cache_vIntroContent;
  static VipBaseInfo cache_vipBaseInfo;
  public byte bIsSingle;
  public byte cAge = -1;
  public byte cGroupId;
  public byte cSex = -1;
  public int eMerchantType = MerchantType.MerchantType_Nomal.value();
  public int iDistance;
  public int iRank;
  public int iVoteIncrement = -1;
  public long lNBID;
  public int lTime;
  public long lTotalVisitorsNum;
  public int nFaceNum;
  public short shIntroType;
  public String strCertification = "";
  public String strCompanyName = "";
  public String strDescription = "";
  public String strNick = "";
  public String strPYFaceUrl = "";
  public String strPYName = "";
  public String strSchoolName = "";
  public byte[] vFaceID;
  public byte[] vIntroContent;
  public VipBaseInfo vipBaseInfo;
  
  public RespNeighborInfo() {}
  
  public RespNeighborInfo(long paramLong1, int paramInt1, int paramInt2, String paramString1, byte paramByte1, byte paramByte2, byte paramByte3, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6, int paramInt4, String paramString7, short paramShort, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt5, byte paramByte4, int paramInt6, long paramLong2, VipBaseInfo paramVipBaseInfo)
  {
    this.lNBID = paramLong1;
    this.iDistance = paramInt1;
    this.lTime = paramInt2;
    this.strDescription = paramString1;
    this.cGroupId = paramByte1;
    this.cSex = paramByte2;
    this.cAge = paramByte3;
    this.strPYFaceUrl = paramString2;
    this.strSchoolName = paramString3;
    this.strCompanyName = paramString4;
    this.strPYName = paramString5;
    this.eMerchantType = paramInt3;
    this.strNick = paramString6;
    this.nFaceNum = paramInt4;
    this.strCertification = paramString7;
    this.shIntroType = paramShort;
    this.vIntroContent = paramArrayOfByte1;
    this.vFaceID = paramArrayOfByte2;
    this.iVoteIncrement = paramInt5;
    this.bIsSingle = paramByte4;
    this.iRank = paramInt6;
    this.lTotalVisitorsNum = paramLong2;
    this.vipBaseInfo = paramVipBaseInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lNBID = paramJceInputStream.read(this.lNBID, 0, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 1, true);
    this.lTime = paramJceInputStream.read(this.lTime, 2, true);
    this.strDescription = paramJceInputStream.readString(3, false);
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 4, false);
    this.cSex = paramJceInputStream.read(this.cSex, 5, false);
    this.cAge = paramJceInputStream.read(this.cAge, 6, false);
    this.strPYFaceUrl = paramJceInputStream.readString(7, false);
    this.strSchoolName = paramJceInputStream.readString(8, false);
    this.strCompanyName = paramJceInputStream.readString(9, false);
    this.strPYName = paramJceInputStream.readString(10, false);
    this.eMerchantType = paramJceInputStream.read(this.eMerchantType, 11, false);
    this.strNick = paramJceInputStream.readString(12, false);
    this.nFaceNum = paramJceInputStream.read(this.nFaceNum, 13, false);
    this.strCertification = paramJceInputStream.readString(14, false);
    this.shIntroType = paramJceInputStream.read(this.shIntroType, 15, false);
    if (cache_vIntroContent == null)
    {
      cache_vIntroContent = (byte[])new byte[1];
      ((byte[])cache_vIntroContent)[0] = 0;
    }
    this.vIntroContent = ((byte[])paramJceInputStream.read(cache_vIntroContent, 16, false));
    if (cache_vFaceID == null)
    {
      cache_vFaceID = (byte[])new byte[1];
      ((byte[])cache_vFaceID)[0] = 0;
    }
    this.vFaceID = ((byte[])paramJceInputStream.read(cache_vFaceID, 17, false));
    this.iVoteIncrement = paramJceInputStream.read(this.iVoteIncrement, 18, false);
    this.bIsSingle = paramJceInputStream.read(this.bIsSingle, 19, false);
    this.iRank = paramJceInputStream.read(this.iRank, 20, false);
    this.lTotalVisitorsNum = paramJceInputStream.read(this.lTotalVisitorsNum, 21, false);
    if (cache_vipBaseInfo == null) {
      cache_vipBaseInfo = new VipBaseInfo();
    }
    this.vipBaseInfo = ((VipBaseInfo)paramJceInputStream.read(cache_vipBaseInfo, 22, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lNBID, 0);
    paramJceOutputStream.write(this.iDistance, 1);
    paramJceOutputStream.write(this.lTime, 2);
    if (this.strDescription != null) {
      paramJceOutputStream.write(this.strDescription, 3);
    }
    paramJceOutputStream.write(this.cGroupId, 4);
    paramJceOutputStream.write(this.cSex, 5);
    paramJceOutputStream.write(this.cAge, 6);
    if (this.strPYFaceUrl != null) {
      paramJceOutputStream.write(this.strPYFaceUrl, 7);
    }
    if (this.strSchoolName != null) {
      paramJceOutputStream.write(this.strSchoolName, 8);
    }
    if (this.strCompanyName != null) {
      paramJceOutputStream.write(this.strCompanyName, 9);
    }
    if (this.strPYName != null) {
      paramJceOutputStream.write(this.strPYName, 10);
    }
    paramJceOutputStream.write(this.eMerchantType, 11);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 12);
    }
    paramJceOutputStream.write(this.nFaceNum, 13);
    if (this.strCertification != null) {
      paramJceOutputStream.write(this.strCertification, 14);
    }
    paramJceOutputStream.write(this.shIntroType, 15);
    if (this.vIntroContent != null) {
      paramJceOutputStream.write(this.vIntroContent, 16);
    }
    if (this.vFaceID != null) {
      paramJceOutputStream.write(this.vFaceID, 17);
    }
    paramJceOutputStream.write(this.iVoteIncrement, 18);
    paramJceOutputStream.write(this.bIsSingle, 19);
    paramJceOutputStream.write(this.iRank, 20);
    paramJceOutputStream.write(this.lTotalVisitorsNum, 21);
    if (this.vipBaseInfo != null) {
      paramJceOutputStream.write(this.vipBaseInfo, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NeighborSvc.RespNeighborInfo
 * JD-Core Version:    0.7.0.1
 */