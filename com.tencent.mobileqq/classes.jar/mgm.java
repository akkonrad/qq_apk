import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.TabHolder;

public class mgm
  implements Animator.AnimatorListener
{
  public mgm(BaseTabbar.TabHolder paramTabHolder, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    BaseTabbar.TabHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder, this.jdField_a_of_type_Boolean);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BaseTabbar.TabHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder, this.jdField_a_of_type_Boolean);
    BaseTabbar.TabHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$TabHolder.b.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgm
 * JD-Core Version:    0.7.0.1
 */