package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_memory_seal_off
  extends JceStruct
{
  public int action_type;
  public String action_url = "";
  public String button_text = "";
  public int memory_time;
  public String summary = "";
  
  public s_memory_seal_off() {}
  
  public s_memory_seal_off(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    this.memory_time = paramInt1;
    this.summary = paramString1;
    this.action_type = paramInt2;
    this.action_url = paramString2;
    this.button_text = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.memory_time = paramJceInputStream.read(this.memory_time, 0, false);
    this.summary = paramJceInputStream.readString(1, false);
    this.action_type = paramJceInputStream.read(this.action_type, 2, false);
    this.action_url = paramJceInputStream.readString(3, false);
    this.button_text = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.memory_time, 0);
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 1);
    }
    paramJceOutputStream.write(this.action_type, 2);
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 3);
    }
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_memory_seal_off
 * JD-Core Version:    0.7.0.1
 */