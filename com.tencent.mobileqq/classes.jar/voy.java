import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class voy
  implements DialogInterface.OnClickListener
{
  public voy(PhotoListPanel paramPhotoListPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListPanel", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     voy
 * JD-Core Version:    0.7.0.1
 */