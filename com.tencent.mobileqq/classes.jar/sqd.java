import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class sqd
  implements IIconListener
{
  public sqd(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.a.a != null) && (this.a.a.a.actionId == paramInt1) && (paramInt2 == 200) && (paramBitmap != null)) {
      this.a.a.a(this.a.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sqd
 * JD-Core Version:    0.7.0.1
 */