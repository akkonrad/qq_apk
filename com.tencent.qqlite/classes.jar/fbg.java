import android.content.Context;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;

public class fbg
  extends Toast
{
  public fbg(Context paramContext)
  {
    super(paramContext);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQToast", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fbg
 * JD-Core Version:    0.7.0.1
 */