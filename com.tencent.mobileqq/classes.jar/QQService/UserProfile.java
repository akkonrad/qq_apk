package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserProfile
  extends JceStruct
{
  static int cache_eUserIdentityType = 0;
  static VipBaseInfo cache_stVipInfo;
  static byte[] cache_vC2CSign;
  static byte[] cache_vFaceID;
  static byte[] cache_vIntroContent = (byte[])new byte[1];
  static byte[] cache_vRichSign;
  public byte bAge = -1;
  public short bAvailableCnt;
  public short bCloseNeighborVote;
  public byte bConstellation;
  public byte bFavorited = -1;
  public byte bFavoritedMe = -1;
  public short bIsLastVoteCharged;
  public byte bSex = -1;
  public byte bSingle = -1;
  public short bTodayVotedCnt;
  public short bTollVoteCnt;
  public byte bVote = -1;
  public short bVoteCnt;
  public long dwLikeCustomId;
  public int eUserIdentityType = 0;
  public long lEctID;
  public int lTime = -1;
  public int nFaceNum;
  public short shIntroType;
  public VipBaseInfo stVipInfo;
  public String strNick = "";
  public long uSource;
  public byte[] vC2CSign;
  public byte[] vFaceID;
  public byte[] vIntroContent;
  public byte[] vRichSign;
  public short wFace;
  
  static
  {
    ((byte[])cache_vIntroContent)[0] = 0;
    cache_vFaceID = (byte[])new byte[1];
    ((byte[])cache_vFaceID)[0] = 0;
    cache_vRichSign = (byte[])new byte[1];
    ((byte[])cache_vRichSign)[0] = 0;
    cache_stVipInfo = new VipBaseInfo();
    cache_vC2CSign = (byte[])new byte[1];
    ((byte[])cache_vC2CSign)[0] = 0;
  }
  
  public UserProfile() {}
  
  public UserProfile(long paramLong1, int paramInt1, short paramShort1, byte paramByte1, byte paramByte2, String paramString, int paramInt2, int paramInt3, short paramShort2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte[] paramArrayOfByte3, byte paramByte7, VipBaseInfo paramVipBaseInfo, byte[] paramArrayOfByte4, short paramShort3, long paramLong2, short paramShort4, short paramShort5, short paramShort6, long paramLong3, short paramShort7, short paramShort8)
  {
    this.lEctID = paramLong1;
    this.lTime = paramInt1;
    this.wFace = paramShort1;
    this.bSex = paramByte1;
    this.bAge = paramByte2;
    this.strNick = paramString;
    this.nFaceNum = paramInt2;
    this.eUserIdentityType = paramInt3;
    this.shIntroType = paramShort2;
    this.vIntroContent = paramArrayOfByte1;
    this.vFaceID = paramArrayOfByte2;
    this.bVote = paramByte3;
    this.bSingle = paramByte4;
    this.bFavorited = paramByte5;
    this.bFavoritedMe = paramByte6;
    this.vRichSign = paramArrayOfByte3;
    this.bConstellation = paramByte7;
    this.stVipInfo = paramVipBaseInfo;
    this.vC2CSign = paramArrayOfByte4;
    this.bVoteCnt = paramShort3;
    this.uSource = paramLong2;
    this.bAvailableCnt = paramShort4;
    this.bTodayVotedCnt = paramShort5;
    this.bCloseNeighborVote = paramShort6;
    this.dwLikeCustomId = paramLong3;
    this.bTollVoteCnt = paramShort7;
    this.bIsLastVoteCharged = paramShort8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lEctID = paramJceInputStream.read(this.lEctID, 0, true);
    this.lTime = paramJceInputStream.read(this.lTime, 1, true);
    this.wFace = paramJceInputStream.read(this.wFace, 2, true);
    this.bSex = paramJceInputStream.read(this.bSex, 3, true);
    this.bAge = paramJceInputStream.read(this.bAge, 4, true);
    this.strNick = paramJceInputStream.readString(5, true);
    this.nFaceNum = paramJceInputStream.read(this.nFaceNum, 6, false);
    this.eUserIdentityType = paramJceInputStream.read(this.eUserIdentityType, 7, false);
    this.shIntroType = paramJceInputStream.read(this.shIntroType, 8, false);
    this.vIntroContent = ((byte[])paramJceInputStream.read(cache_vIntroContent, 9, false));
    this.vFaceID = ((byte[])paramJceInputStream.read(cache_vFaceID, 10, false));
    this.bVote = paramJceInputStream.read(this.bVote, 11, false);
    this.bSingle = paramJceInputStream.read(this.bSingle, 12, false);
    this.bFavorited = paramJceInputStream.read(this.bFavorited, 13, false);
    this.bFavoritedMe = paramJceInputStream.read(this.bFavoritedMe, 14, false);
    this.vRichSign = ((byte[])paramJceInputStream.read(cache_vRichSign, 15, false));
    this.bConstellation = paramJceInputStream.read(this.bConstellation, 16, false);
    this.stVipInfo = ((VipBaseInfo)paramJceInputStream.read(cache_stVipInfo, 17, false));
    this.vC2CSign = ((byte[])paramJceInputStream.read(cache_vC2CSign, 18, false));
    this.bVoteCnt = paramJceInputStream.read(this.bVoteCnt, 19, false);
    this.uSource = paramJceInputStream.read(this.uSource, 20, false);
    this.bAvailableCnt = paramJceInputStream.read(this.bAvailableCnt, 21, false);
    this.bTodayVotedCnt = paramJceInputStream.read(this.bTodayVotedCnt, 22, false);
    this.bCloseNeighborVote = paramJceInputStream.read(this.bCloseNeighborVote, 23, false);
    this.dwLikeCustomId = paramJceInputStream.read(this.dwLikeCustomId, 24, false);
    this.bTollVoteCnt = paramJceInputStream.read(this.bTollVoteCnt, 25, false);
    this.bIsLastVoteCharged = paramJceInputStream.read(this.bIsLastVoteCharged, 26, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lEctID, 0);
    paramJceOutputStream.write(this.lTime, 1);
    paramJceOutputStream.write(this.wFace, 2);
    paramJceOutputStream.write(this.bSex, 3);
    paramJceOutputStream.write(this.bAge, 4);
    paramJceOutputStream.write(this.strNick, 5);
    paramJceOutputStream.write(this.nFaceNum, 6);
    paramJceOutputStream.write(this.eUserIdentityType, 7);
    paramJceOutputStream.write(this.shIntroType, 8);
    if (this.vIntroContent != null) {
      paramJceOutputStream.write(this.vIntroContent, 9);
    }
    if (this.vFaceID != null) {
      paramJceOutputStream.write(this.vFaceID, 10);
    }
    paramJceOutputStream.write(this.bVote, 11);
    paramJceOutputStream.write(this.bSingle, 12);
    paramJceOutputStream.write(this.bFavorited, 13);
    paramJceOutputStream.write(this.bFavoritedMe, 14);
    if (this.vRichSign != null) {
      paramJceOutputStream.write(this.vRichSign, 15);
    }
    paramJceOutputStream.write(this.bConstellation, 16);
    if (this.stVipInfo != null) {
      paramJceOutputStream.write(this.stVipInfo, 17);
    }
    if (this.vC2CSign != null) {
      paramJceOutputStream.write(this.vC2CSign, 18);
    }
    paramJceOutputStream.write(this.bVoteCnt, 19);
    paramJceOutputStream.write(this.uSource, 20);
    paramJceOutputStream.write(this.bAvailableCnt, 21);
    paramJceOutputStream.write(this.bTodayVotedCnt, 22);
    paramJceOutputStream.write(this.bCloseNeighborVote, 23);
    paramJceOutputStream.write(this.dwLikeCustomId, 24);
    paramJceOutputStream.write(this.bTollVoteCnt, 25);
    paramJceOutputStream.write(this.bIsLastVoteCharged, 26);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.UserProfile
 * JD-Core Version:    0.7.0.1
 */