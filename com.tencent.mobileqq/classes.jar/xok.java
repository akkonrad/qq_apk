import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class xok
  implements DialogInterface.OnClickListener
{
  public xok(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("608", "7", "2", true);
    EditLocalVideoActivity.b(this.a, "an_yuanshipin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xok
 * JD-Core Version:    0.7.0.1
 */