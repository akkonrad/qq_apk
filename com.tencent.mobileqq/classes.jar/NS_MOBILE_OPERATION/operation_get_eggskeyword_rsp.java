package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_get_eggskeyword_rsp
  extends JceStruct
{
  static GuidePaster cache_guidePaster;
  static Map cache_mapKeyWord;
  static Map cache_mapKeyWordEggs;
  public GuidePaster guidePaster;
  public int ifOpenEntrance;
  public Map mapKeyWord;
  public Map mapKeyWordEggs;
  public long updatetime;
  
  public operation_get_eggskeyword_rsp() {}
  
  public operation_get_eggskeyword_rsp(int paramInt, Map paramMap1, Map paramMap2, GuidePaster paramGuidePaster, long paramLong)
  {
    this.ifOpenEntrance = paramInt;
    this.mapKeyWordEggs = paramMap1;
    this.mapKeyWord = paramMap2;
    this.guidePaster = paramGuidePaster;
    this.updatetime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ifOpenEntrance = paramJceInputStream.read(this.ifOpenEntrance, 0, true);
    if (cache_mapKeyWordEggs == null)
    {
      cache_mapKeyWordEggs = new HashMap();
      ImageSummaryList localImageSummaryList = new ImageSummaryList();
      cache_mapKeyWordEggs.put("", localImageSummaryList);
    }
    this.mapKeyWordEggs = ((Map)paramJceInputStream.read(cache_mapKeyWordEggs, 1, false));
    if (cache_mapKeyWord == null)
    {
      cache_mapKeyWord = new HashMap();
      cache_mapKeyWord.put("", "");
    }
    this.mapKeyWord = ((Map)paramJceInputStream.read(cache_mapKeyWord, 2, false));
    if (cache_guidePaster == null) {
      cache_guidePaster = new GuidePaster();
    }
    this.guidePaster = ((GuidePaster)paramJceInputStream.read(cache_guidePaster, 3, false));
    this.updatetime = paramJceInputStream.read(this.updatetime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ifOpenEntrance, 0);
    if (this.mapKeyWordEggs != null) {
      paramJceOutputStream.write(this.mapKeyWordEggs, 1);
    }
    if (this.mapKeyWord != null) {
      paramJceOutputStream.write(this.mapKeyWord, 2);
    }
    if (this.guidePaster != null) {
      paramJceOutputStream.write(this.guidePaster, 3);
    }
    paramJceOutputStream.write(this.updatetime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_get_eggskeyword_rsp
 * JD-Core Version:    0.7.0.1
 */