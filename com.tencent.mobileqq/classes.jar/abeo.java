import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.armap.ShopScanDragView;

public class abeo
  implements Animator.AnimatorListener
{
  public abeo(ShopScanDragView paramShopScanDragView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ShopScanDragView.a(this.a).setAlpha(1.0F);
    ShopScanDragView.b(this.a).setAlpha(0.0F);
    ShopScanDragView.a(this.a).setVisibility(0);
    ShopScanDragView.b(this.a).setVisibility(4);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ShopScanDragView.a(this.a).setAlpha(1.0F);
    ShopScanDragView.b(this.a).setAlpha(0.0F);
    ShopScanDragView.a(this.a).setVisibility(0);
    ShopScanDragView.b(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ShopScanDragView.a(this.a).setAlpha(0.0F);
    ShopScanDragView.a(this.a).setVisibility(0);
    ShopScanDragView.b(this.a).setAlpha(1.0F);
    ShopScanDragView.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abeo
 * JD-Core Version:    0.7.0.1
 */