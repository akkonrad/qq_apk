package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class operation_forward_req
  extends JceStruct
{
  static Map cache_busi_param;
  static Map cache_photoids;
  static ArrayList cache_srcImages;
  static ArrayList cache_srcSubid = new ArrayList();
  public int appid;
  public Map busi_param;
  public String category = "";
  public String dstAlbumId = "";
  public int dstAlbumType;
  public int iUrlInfoFrm;
  public int isverified;
  public int operatemask;
  public long ownUin;
  public Map photoids;
  public String reason = "";
  public int source;
  public String srcAbstract = "";
  public String srcId = "";
  public ArrayList srcImages;
  public int srcPicNum;
  public ArrayList srcSubid;
  public String srcTitle = "";
  public int subid;
  public long uin;
  
  static
  {
    cache_srcSubid.add("");
    cache_srcImages = new ArrayList();
    cache_srcImages.add("");
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_photoids = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    cache_photoids.put("", localArrayList);
  }
  
  public operation_forward_req() {}
  
  public operation_forward_req(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, ArrayList paramArrayList1, String paramString2, String paramString3, String paramString4, ArrayList paramArrayList2, int paramInt3, int paramInt4, int paramInt5, String paramString5, int paramInt6, String paramString6, int paramInt7, Map paramMap1, Map paramMap2, int paramInt8)
  {
    this.appid = paramInt1;
    this.subid = paramInt2;
    this.uin = paramLong1;
    this.ownUin = paramLong2;
    this.srcId = paramString1;
    this.srcSubid = paramArrayList1;
    this.reason = paramString2;
    this.srcTitle = paramString3;
    this.srcAbstract = paramString4;
    this.srcImages = paramArrayList2;
    this.srcPicNum = paramInt3;
    this.source = paramInt4;
    this.isverified = paramInt5;
    this.category = paramString5;
    this.operatemask = paramInt6;
    this.dstAlbumId = paramString6;
    this.dstAlbumType = paramInt7;
    this.busi_param = paramMap1;
    this.photoids = paramMap2;
    this.iUrlInfoFrm = paramInt8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.subid = paramJceInputStream.read(this.subid, 1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, false);
    this.ownUin = paramJceInputStream.read(this.ownUin, 3, false);
    this.srcId = paramJceInputStream.readString(4, false);
    this.srcSubid = ((ArrayList)paramJceInputStream.read(cache_srcSubid, 5, false));
    this.reason = paramJceInputStream.readString(6, false);
    this.srcTitle = paramJceInputStream.readString(7, false);
    this.srcAbstract = paramJceInputStream.readString(8, false);
    this.srcImages = ((ArrayList)paramJceInputStream.read(cache_srcImages, 9, false));
    this.srcPicNum = paramJceInputStream.read(this.srcPicNum, 10, false);
    this.source = paramJceInputStream.read(this.source, 11, false);
    this.isverified = paramJceInputStream.read(this.isverified, 12, false);
    this.category = paramJceInputStream.readString(13, false);
    this.operatemask = paramJceInputStream.read(this.operatemask, 14, false);
    this.dstAlbumId = paramJceInputStream.readString(15, false);
    this.dstAlbumType = paramJceInputStream.read(this.dstAlbumType, 16, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 17, false));
    this.photoids = ((Map)paramJceInputStream.read(cache_photoids, 18, false));
    this.iUrlInfoFrm = paramJceInputStream.read(this.iUrlInfoFrm, 19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.subid, 1);
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.ownUin, 3);
    if (this.srcId != null) {
      paramJceOutputStream.write(this.srcId, 4);
    }
    if (this.srcSubid != null) {
      paramJceOutputStream.write(this.srcSubid, 5);
    }
    if (this.reason != null) {
      paramJceOutputStream.write(this.reason, 6);
    }
    if (this.srcTitle != null) {
      paramJceOutputStream.write(this.srcTitle, 7);
    }
    if (this.srcAbstract != null) {
      paramJceOutputStream.write(this.srcAbstract, 8);
    }
    if (this.srcImages != null) {
      paramJceOutputStream.write(this.srcImages, 9);
    }
    paramJceOutputStream.write(this.srcPicNum, 10);
    paramJceOutputStream.write(this.source, 11);
    paramJceOutputStream.write(this.isverified, 12);
    if (this.category != null) {
      paramJceOutputStream.write(this.category, 13);
    }
    paramJceOutputStream.write(this.operatemask, 14);
    if (this.dstAlbumId != null) {
      paramJceOutputStream.write(this.dstAlbumId, 15);
    }
    paramJceOutputStream.write(this.dstAlbumType, 16);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 17);
    }
    if (this.photoids != null) {
      paramJceOutputStream.write(this.photoids, 18);
    }
    paramJceOutputStream.write(this.iUrlInfoFrm, 19);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_forward_req
 * JD-Core Version:    0.7.0.1
 */