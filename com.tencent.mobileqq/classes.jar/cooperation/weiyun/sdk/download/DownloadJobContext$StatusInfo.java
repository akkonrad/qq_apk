package cooperation.weiyun.sdk.download;

public final class DownloadJobContext$StatusInfo
  implements Cloneable
{
  public volatile int a;
  public long a;
  public DownloadJobContext a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c = "";
  public String d = "";
  
  public DownloadJobContext$StatusInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public StatusInfo a()
  {
    try
    {
      StatusInfo localStatusInfo = (StatusInfo)super.clone();
      return localStatusInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 3) || ((this.jdField_a_of_type_Int == 1) && ((this.jdField_b_of_type_Int == 1810003) || (this.jdField_b_of_type_Int == 1810004)));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int != 1810003) && (this.jdField_b_of_type_Int != 1810004);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int == 1) && ((this.jdField_b_of_type_Int == 1810003) || (this.jdField_b_of_type_Int == 1810004));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.DownloadJobContext.StatusInfo
 * JD-Core Version:    0.7.0.1
 */