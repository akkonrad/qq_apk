import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class kjm
  implements DialogInterface.OnDismissListener
{
  public kjm(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PoiMapActivity.d(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setEnabled(false);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHandler().postDelayed(new kjn(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kjm
 * JD-Core Version:    0.7.0.1
 */