import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.theme.SkinEngine;
import mqq.os.MqqHandler;

public final class vqf
  implements Runnable
{
  public vqf(TextView paramTextView) {}
  
  public void run()
  {
    Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845881);
    Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845883);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable1);
    localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable2);
    ThreadManager.getUIHandler().post(new vqg(this, localStateListDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqf
 * JD-Core Version:    0.7.0.1
 */