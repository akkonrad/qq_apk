import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agjb
  implements OnCompositionLoadedListener
{
  public agjb(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    long l = 0L;
    if (paramLottieComposition != null)
    {
      l = paramLottieComposition.getDuration() + 100L;
      Object localObject = paramLottieComposition.getBounds();
      int i = AIOUtils.a(30.0F, this.a.getResources());
      float f1 = i / ((Rect)localObject).width();
      float f2 = i / ((Rect)localObject).height();
      localObject = new LottieDrawable();
      ((LottieDrawable)localObject).setComposition(paramLottieComposition);
      ((LottieDrawable)localObject).setScale(f1, f2);
      ((LottieDrawable)localObject).playAnimation();
      ScanTorchActivity.d(this.a).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject, null, null);
    }
    for (;;)
    {
      paramLottieComposition = ObjectAnimator.ofFloat(ScanTorchActivity.d(this.a), "alpha", new float[] { 1.0F, 0.0F, 1.0F });
      paramLottieComposition.setDuration(300L);
      paramLottieComposition.setRepeatCount(2);
      paramLottieComposition.setStartDelay(l);
      paramLottieComposition.start();
      ScanTorchActivity.a(this.a, ScanTorchActivity.d(this.a), true, false);
      if (!this.a.b()) {
        ScanTorchActivity.a(this.a, ScanTorchActivity.e(this.a), false, true);
      }
      return;
      QLog.e("ScanTorchActivity", 1, "loadFlashLightSVGDrawable fail, use static resource.");
      ScanTorchActivity.d(this.a).setCompoundDrawablesWithIntrinsicBounds(0, 2130842226, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjb
 * JD-Core Version:    0.7.0.1
 */