import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public final class utt
  implements Runnable
{
  public utt(Context paramContext, int paramInt, String paramString) {}
  
  public void run()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "fav action number is 144");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utt
 * JD-Core Version:    0.7.0.1
 */