package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SSummaryCardRsp
  extends JceStruct
{
  static ArrayList cache_bgtype;
  static SUserLabel cache_label;
  static int cache_res = 0;
  static cardDiyTextInfo cache_stDiyText = new cardDiyTextInfo();
  static STRecommendInfo cache_stRecom;
  static ArrayList cache_wzryInfo;
  public long bgid;
  public ArrayList bgtype;
  public String bgurl = "";
  public int cardType;
  public long cardid;
  public long color;
  public int dynamicCardFlag;
  public String emsg = "";
  public String extInfo = "";
  public SUserLabel label;
  public int res;
  public cardDiyTextInfo stDiyText;
  public STRecommendInfo stRecom;
  public String strActiveCardUrl = "";
  public String strDiyDefaultText = "";
  public String strDrawerCard = "";
  public String strWzryHeroUrl = "";
  public String strZipUrl = "";
  public long styleid;
  public ArrayList wzryInfo;
  
  static
  {
    cache_label = new SUserLabel();
    cache_bgtype = new ArrayList();
    cache_bgtype.add(Integer.valueOf(0));
    cache_stRecom = new STRecommendInfo();
    cache_wzryInfo = new ArrayList();
    summaryCardWzryInfo localsummaryCardWzryInfo = new summaryCardWzryInfo();
    cache_wzryInfo.add(localsummaryCardWzryInfo);
  }
  
  public SSummaryCardRsp() {}
  
  public SSummaryCardRsp(int paramInt1, long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, SUserLabel paramSUserLabel, String paramString2, ArrayList paramArrayList1, int paramInt2, String paramString3, STRecommendInfo paramSTRecommendInfo, String paramString4, String paramString5, String paramString6, ArrayList paramArrayList2, cardDiyTextInfo paramcardDiyTextInfo, int paramInt3, String paramString7, String paramString8)
  {
    this.res = paramInt1;
    this.cardid = paramLong1;
    this.styleid = paramLong2;
    this.bgurl = paramString1;
    this.bgid = paramLong3;
    this.color = paramLong4;
    this.label = paramSUserLabel;
    this.emsg = paramString2;
    this.bgtype = paramArrayList1;
    this.dynamicCardFlag = paramInt2;
    this.strZipUrl = paramString3;
    this.stRecom = paramSTRecommendInfo;
    this.strActiveCardUrl = paramString4;
    this.strDrawerCard = paramString5;
    this.strWzryHeroUrl = paramString6;
    this.wzryInfo = paramArrayList2;
    this.stDiyText = paramcardDiyTextInfo;
    this.cardType = paramInt3;
    this.strDiyDefaultText = paramString7;
    this.extInfo = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.res = paramJceInputStream.read(this.res, 0, true);
    this.cardid = paramJceInputStream.read(this.cardid, 1, true);
    this.styleid = paramJceInputStream.read(this.styleid, 2, false);
    this.bgurl = paramJceInputStream.readString(3, false);
    this.bgid = paramJceInputStream.read(this.bgid, 4, false);
    this.color = paramJceInputStream.read(this.color, 5, false);
    this.label = ((SUserLabel)paramJceInputStream.read(cache_label, 6, false));
    this.emsg = paramJceInputStream.readString(7, false);
    this.bgtype = ((ArrayList)paramJceInputStream.read(cache_bgtype, 8, false));
    this.dynamicCardFlag = paramJceInputStream.read(this.dynamicCardFlag, 9, false);
    this.strZipUrl = paramJceInputStream.readString(10, false);
    this.stRecom = ((STRecommendInfo)paramJceInputStream.read(cache_stRecom, 11, false));
    this.strActiveCardUrl = paramJceInputStream.readString(12, false);
    this.strDrawerCard = paramJceInputStream.readString(13, false);
    this.strWzryHeroUrl = paramJceInputStream.readString(14, false);
    this.wzryInfo = ((ArrayList)paramJceInputStream.read(cache_wzryInfo, 15, false));
    this.stDiyText = ((cardDiyTextInfo)paramJceInputStream.read(cache_stDiyText, 16, false));
    this.cardType = paramJceInputStream.read(this.cardType, 17, false);
    this.strDiyDefaultText = paramJceInputStream.readString(18, false);
    this.extInfo = paramJceInputStream.readString(19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.res, 0);
    paramJceOutputStream.write(this.cardid, 1);
    paramJceOutputStream.write(this.styleid, 2);
    if (this.bgurl != null) {
      paramJceOutputStream.write(this.bgurl, 3);
    }
    paramJceOutputStream.write(this.bgid, 4);
    paramJceOutputStream.write(this.color, 5);
    if (this.label != null) {
      paramJceOutputStream.write(this.label, 6);
    }
    if (this.emsg != null) {
      paramJceOutputStream.write(this.emsg, 7);
    }
    if (this.bgtype != null) {
      paramJceOutputStream.write(this.bgtype, 8);
    }
    paramJceOutputStream.write(this.dynamicCardFlag, 9);
    if (this.strZipUrl != null) {
      paramJceOutputStream.write(this.strZipUrl, 10);
    }
    if (this.stRecom != null) {
      paramJceOutputStream.write(this.stRecom, 11);
    }
    if (this.strActiveCardUrl != null) {
      paramJceOutputStream.write(this.strActiveCardUrl, 12);
    }
    if (this.strDrawerCard != null) {
      paramJceOutputStream.write(this.strDrawerCard, 13);
    }
    if (this.strWzryHeroUrl != null) {
      paramJceOutputStream.write(this.strWzryHeroUrl, 14);
    }
    if (this.wzryInfo != null) {
      paramJceOutputStream.write(this.wzryInfo, 15);
    }
    if (this.stDiyText != null) {
      paramJceOutputStream.write(this.stDiyText, 16);
    }
    paramJceOutputStream.write(this.cardType, 17);
    if (this.strDiyDefaultText != null) {
      paramJceOutputStream.write(this.strDiyDefaultText, 18);
    }
    if (this.extInfo != null) {
      paramJceOutputStream.write(this.extInfo, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardRsp
 * JD-Core Version:    0.7.0.1
 */