package a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class f
  extends JceStruct
{
  static byte[] g;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public byte[] f = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
    if (g == null)
    {
      g = (byte[])new byte[1];
      ((byte[])g)[0] = 0;
    }
    this.f = ((byte[])paramJceInputStream.read(g, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != 0) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != 0) {
      paramJceOutputStream.write(this.c, 2);
    }
    paramJceOutputStream.write(this.d, 3);
    if (this.e != 0) {
      paramJceOutputStream.write(this.e, 4);
    }
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     a.e.f
 * JD-Core Version:    0.7.0.1
 */