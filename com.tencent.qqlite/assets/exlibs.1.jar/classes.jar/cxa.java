import com.tencent.mobileqq.app.SaveTrafficHandler;

public class cxa
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  public boolean b = false;
  
  public cxa(SaveTrafficHandler paramSaveTrafficHandler, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = false;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSaveTrafficHandler.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cxa
 * JD-Core Version:    0.7.0.1
 */