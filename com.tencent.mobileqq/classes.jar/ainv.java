import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.text.TextUtils.LoadSysEmojiCallback;
import com.tencent.qphone.base.util.BaseApplication;

public final class ainv
  implements Runnable
{
  public ainv(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback) {}
  
  public void run()
  {
    Drawable localDrawable = TextUtils.b(BaseApplicationImpl.getContext().getResources(), this.jdField_a_of_type_Int);
    if ((localDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqTextTextUtils$LoadSysEmojiCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTextTextUtils$LoadSysEmojiCallback.a(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainv
 * JD-Core Version:    0.7.0.1
 */