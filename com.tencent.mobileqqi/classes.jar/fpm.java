import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import java.util.concurrent.Executor;

public class fpm
  implements Executor
{
  final fpo jdField_a_of_type_Fpo = new fpo(30);
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  protected int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Fpo.a();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_Fpo.a();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null) {
        QQAnimationDrawable.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Fpo.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.jdField_a_of_type_Fpo.a(new fpn(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpm
 * JD-Core Version:    0.7.0.1
 */