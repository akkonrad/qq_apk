import com.tencent.av.ui.GAudioMembersCtrlActivity;

public class jur
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public jur(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt2;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jur
 * JD-Core Version:    0.7.0.1
 */