import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.qphone.base.util.QLog;

class acyv
  implements Runnable
{
  acyv(acyu paramacyu, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    QfavFilePreviewController.b(this.jdField_a_of_type_Acyu.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    QfavFilePreviewController.c(this.jdField_a_of_type_Acyu.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a) + ", port=" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a)) + ", key=" + QfavFilePreviewController.b(this.jdField_a_of_type_Acyu.a) + ", retCode =" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a)));
    }
    FilePreviewActivity.ControlerCallback localControlerCallback;
    if (1 == QfavFilePreviewController.b(this.jdField_a_of_type_Acyu.a))
    {
      localControlerCallback = this.jdField_a_of_type_Acyu.a.a;
      if (0L != QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a)) {
        break label320;
      }
    }
    for (;;)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a), String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a)), QfavFilePreviewController.a(this.jdField_a_of_type_Acyu.a), null, QfavFilePreviewController.b(this.jdField_a_of_type_Acyu.a), null, QfavFilePreviewController.c(this.jdField_a_of_type_Acyu.a));
      QfavFilePreviewController.b(this.jdField_a_of_type_Acyu.a, 3);
      return;
      label320:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyv
 * JD-Core Version:    0.7.0.1
 */