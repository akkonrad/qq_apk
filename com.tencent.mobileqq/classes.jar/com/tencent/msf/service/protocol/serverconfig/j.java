package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class j
  extends JceStruct
{
  public String a = "";
  public int b;
  public byte c;
  public byte d;
  public byte e;
  public int f = 8;
  public byte g;
  public String h = "";
  public String i = "";
  
  public j() {}
  
  public j(String paramString1, int paramInt1, byte paramByte1, byte paramByte2, byte paramByte3, int paramInt2, byte paramByte4, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramByte1;
    this.d = paramByte2;
    this.e = paramByte3;
    this.f = paramInt2;
    this.g = paramByte4;
    this.h = paramString2;
    this.i = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    this.c = paramJceInputStream.read(this.c, 3, true);
    this.d = paramJceInputStream.read(this.d, 4, true);
    this.e = paramJceInputStream.read(this.e, 5, false);
    this.f = paramJceInputStream.read(this.f, 6, false);
    this.g = paramJceInputStream.read(this.g, 7, false);
    this.h = paramJceInputStream.readString(8, true);
    this.i = paramJceInputStream.readString(9, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
    paramJceOutputStream.write(this.f, 6);
    paramJceOutputStream.write(this.g, 7);
    paramJceOutputStream.write(this.h, 8);
    paramJceOutputStream.write(this.i, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.j
 * JD-Core Version:    0.7.0.1
 */