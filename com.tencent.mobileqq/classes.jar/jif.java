import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.OnGetSink;

public class jif
  implements BaseGaInvite.GetGaFaceRunnable.OnGetSink
{
  public jif(BaseGaInvite paramBaseGaInvite) {}
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.a.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramBitmap = BaseGaInvite.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a.jdField_b_of_type_AndroidWidgetTextView, paramString, this.a.jdField_b_of_type_Int, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_ArrayOfLong);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramBitmap);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jif
 * JD-Core Version:    0.7.0.1
 */