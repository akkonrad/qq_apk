package tmsdk.common.c.a;

public class d
{
  public static final String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.d
 * JD-Core Version:    0.7.0.1
 */