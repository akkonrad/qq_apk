import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class dlx
  implements DialogInterface.OnClickListener
{
  dlx(dlv paramdlv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dlx
 * JD-Core Version:    0.7.0.1
 */