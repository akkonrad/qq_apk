import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

public class ehp
  implements View.OnClickListener
{
  public ehp(AIOImageListScene paramAIOImageListScene) {}
  
  public void onClick(View paramView)
  {
    AIOImageListScene.a(this.a, ((TextView)paramView).getText().toString());
    AIOImageListScene.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehp
 * JD-Core Version:    0.7.0.1
 */