package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Wifi_V2
  extends JceStruct
{
  public int iRssi;
  public String strMac = "";
  
  public Wifi_V2() {}
  
  public Wifi_V2(String paramString, int paramInt)
  {
    this.strMac = paramString;
    this.iRssi = paramInt;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.strMac, "strMac");
    paramStringBuilder.display(this.iRssi, "iRssi");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strMac = paramJceInputStream.readString(0, true);
    this.iRssi = paramJceInputStream.read(this.iRssi, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strMac, 0);
    paramJceOutputStream.write(this.iRssi, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.Wifi_V2
 * JD-Core Version:    0.7.0.1
 */