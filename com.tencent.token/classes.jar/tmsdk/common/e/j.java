package tmsdk.common.e;

public class j
{
  public static int a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return -1;
      if ((paramString.startsWith("46000")) || (paramString.startsWith("46002")) || (paramString.startsWith("46007"))) {
        return 0;
      }
      if (paramString.startsWith("46001")) {
        return 1;
      }
    } while (!paramString.startsWith("46003"));
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.e.j
 * JD-Core Version:    0.7.0.1
 */