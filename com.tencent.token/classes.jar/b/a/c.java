package b.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  static byte[] h;
  public long a = 0L;
  public String b = "";
  public long c = 0L;
  public byte[] d = null;
  public String e = "";
  public String f = "";
  public String g = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    if (h == null)
    {
      h = (byte[])new byte[1];
      ((byte[])h)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(h, 3, true));
    this.e = paramJceInputStream.readString(4, true);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     b.a.c
 * JD-Core Version:    0.7.0.1
 */