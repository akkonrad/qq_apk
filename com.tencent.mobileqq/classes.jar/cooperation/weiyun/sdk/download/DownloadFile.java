package cooperation.weiyun.sdk.download;

import android.text.TextUtils;

public class DownloadFile
  implements Cloneable
{
  public final int a;
  public final long a;
  public DownloadFile.DownloadServerInfo a;
  public final String a;
  public final int b;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public String f;
  public final String g;
  
  private DownloadFile(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
    this.d = paramString4;
    this.e = paramString5;
    this.g = paramString6;
  }
  
  public static DownloadFile a(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString5)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)) || (paramLong < 0L)) {
      throw new IllegalArgumentException("The params fileName, pDirKey, fileId, sha and fileSize should be valid.");
    }
    return new DownloadFile(paramInt1, paramString1, paramString2, paramString3.toLowerCase(), paramLong, paramInt2, paramString4, paramString5, paramString6);
  }
  
  public DownloadFile a()
  {
    try
    {
      DownloadFile localDownloadFile = (DownloadFile)super.clone();
      return localDownloadFile;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString4))) {
      return;
    }
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile$DownloadServerInfo = new DownloadFile.DownloadServerInfo(this, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.DownloadFile
 * JD-Core Version:    0.7.0.1
 */