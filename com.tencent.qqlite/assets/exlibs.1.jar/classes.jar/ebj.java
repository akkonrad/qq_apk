import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.EditActivity;
import java.util.ArrayList;
import java.util.Collections;

class ebj
  implements Animation.AnimationListener
{
  ebj(ebi paramebi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    EditActivity.a(this.a.a).setVisibility(0);
    paramAnimation = new ArrayList();
    int i = 0;
    while (i < 6)
    {
      paramAnimation.add(Integer.valueOf(i));
      i += 1;
    }
    Collections.shuffle(paramAnimation);
    i = 0;
    if (i < 6)
    {
      View localView = EditActivity.a(this.a.a).getChildAt(((Integer)paramAnimation.get(i)).intValue());
      if (localView == null) {}
      for (;;)
      {
        i += 1;
        break;
        localView.postDelayed(new ebk(this, (ImageView)localView.findViewById(2131298235), (TextView)localView.findViewById(2131298236)), i * 100);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    EditActivity.a(this.a.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebj
 * JD-Core Version:    0.7.0.1
 */