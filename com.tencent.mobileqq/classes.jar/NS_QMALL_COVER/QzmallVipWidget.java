package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallVipWidget
  extends JceStruct
{
  public String strRedpointTrace = "";
  
  public QzmallVipWidget() {}
  
  public QzmallVipWidget(String paramString)
  {
    this.strRedpointTrace = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strRedpointTrace = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strRedpointTrace != null) {
      paramJceOutputStream.write(this.strRedpointTrace, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallVipWidget
 * JD-Core Version:    0.7.0.1
 */