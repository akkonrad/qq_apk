import java.util.Comparator;

public final class mqm
  implements Comparator
{
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return paramArrayOfByte1.length - paramArrayOfByte2.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqm
 * JD-Core Version:    0.7.0.1
 */