import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

public class vij
{
  public String a;
  SoftReference a;
  SoftReference b;
  
  public vij(String paramString, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramView);
    this.b = new SoftReference(paramViewGroup);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefSoftReference.get();
  }
  
  public ViewGroup a()
  {
    return (ViewGroup)this.b.get();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.b = new SoftReference(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vij
 * JD-Core Version:    0.7.0.1
 */