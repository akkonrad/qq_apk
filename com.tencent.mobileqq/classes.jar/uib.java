import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class uib
  extends AnimateUtils.AnimationAdapter
{
  public uib(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.jdField_f_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uib
 * JD-Core Version:    0.7.0.1
 */