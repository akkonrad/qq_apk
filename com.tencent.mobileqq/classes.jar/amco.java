import com.tencent.widget.ListView;

public class amco
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private int b;
  
  private amco(ListView paramListView) {}
  
  public amco a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentWidgetListView.setSelectionFromTop(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amco
 * JD-Core Version:    0.7.0.1
 */