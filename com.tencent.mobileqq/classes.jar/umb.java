import android.content.DialogInterface;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;

public class umb
  extends DialogUtil.DialogOnClickAdapter
{
  public umb(PlusPanel paramPlusPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umb
 * JD-Core Version:    0.7.0.1
 */