package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CustomCover
  extends JceStruct
{
  public String imageUrl = "";
  public String thumbUrl = "";
  
  public CustomCover() {}
  
  public CustomCover(String paramString1, String paramString2)
  {
    this.thumbUrl = paramString1;
    this.imageUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.thumbUrl = paramJceInputStream.readString(0, false);
    this.imageUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.thumbUrl != null) {
      paramJceOutputStream.write(this.thumbUrl, 0);
    }
    if (this.imageUrl != null) {
      paramJceOutputStream.write(this.imageUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.CustomCover
 * JD-Core Version:    0.7.0.1
 */