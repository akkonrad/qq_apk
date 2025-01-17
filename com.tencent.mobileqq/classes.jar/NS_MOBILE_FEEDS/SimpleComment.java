package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SimpleComment
  extends JceStruct
{
  static ArrayList cache_reply_ids = new ArrayList();
  public long id;
  public ArrayList reply_ids;
  
  static
  {
    cache_reply_ids.add(Long.valueOf(0L));
  }
  
  public SimpleComment() {}
  
  public SimpleComment(long paramLong, ArrayList paramArrayList)
  {
    this.id = paramLong;
    this.reply_ids = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, false);
    this.reply_ids = ((ArrayList)paramJceInputStream.read(cache_reply_ids, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    if (this.reply_ids != null) {
      paramJceOutputStream.write(this.reply_ids, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.SimpleComment
 * JD-Core Version:    0.7.0.1
 */