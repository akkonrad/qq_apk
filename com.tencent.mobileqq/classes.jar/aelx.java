import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.ViewHolder;

public class aelx
  extends AnimatorListenerAdapter
{
  public aelx(NearbyFragmentEnterAdapter paramNearbyFragmentEnterAdapter, NearbyFragmentEnterAdapter.ViewHolder paramViewHolder, URLDrawable paramURLDrawable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter$ViewHolder.b.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter$ViewHolder.b, "alpha", new float[] { 0.2F, 1.0F });
      paramAnimator.setInterpolator(new DecelerateInterpolator());
      paramAnimator.setDuration(300L).start();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter$ViewHolder.b.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aelx
 * JD-Core Version:    0.7.0.1
 */