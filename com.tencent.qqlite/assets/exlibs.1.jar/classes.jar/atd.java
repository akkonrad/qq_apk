import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;

class atd
  implements Runnable
{
  atd(atc paramatc, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_Atc.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Atc.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
      this.jdField_a_of_type_Atc.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_Atc.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      return;
    }
    this.jdField_a_of_type_Atc.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atd
 * JD-Core Version:    0.7.0.1
 */