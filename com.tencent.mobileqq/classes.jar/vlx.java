import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.panel.PEPanel;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class vlx
  implements OnCompositionLoadedListener
{
  public vlx(PEPanel paramPEPanel, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo.PEPanel", 2, "composition is null ,return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" playLottieAnim onCompositionLoaded done ", new Object[0]));
    }
    Rect localRect = paramLottieComposition.getBounds();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.getResources().getDisplayMetrics().widthPixels;
    i = XPanelContainer.a;
    AIOUtils.a(40.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.getResources());
    float f = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.getResources().getDisplayMetrics().widthPixels / localRect.width();
    PEPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel, paramLottieComposition.getDuration() * 6L / 10L);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setComposition(paramLottieComposition);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScale(f);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(PEPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorUpdateListener(PEPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel.postDelayed(new vly(this), PEPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlx
 * JD-Core Version:    0.7.0.1
 */