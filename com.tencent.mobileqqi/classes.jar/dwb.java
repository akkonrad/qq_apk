import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class dwb
  implements View.OnClickListener
{
  dwb(dvy paramdvy, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dwb
 * JD-Core Version:    0.7.0.1
 */