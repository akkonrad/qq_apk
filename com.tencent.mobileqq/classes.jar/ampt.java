import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qqfav.widget.QfavJumpActivity;

public class ampt
  implements DialogInterface.OnClickListener
{
  public ampt(QfavJumpActivity paramQfavJumpActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QfavJumpActivity.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ampt
 * JD-Core Version:    0.7.0.1
 */