import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.PlusPanel;

public class umd
  implements DialogInterface.OnClickListener
{
  public umd(PlusPanel paramPlusPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umd
 * JD-Core Version:    0.7.0.1
 */