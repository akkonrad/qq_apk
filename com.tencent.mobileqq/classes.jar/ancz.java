import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin;

public class ancz
  implements DialogInterface.OnClickListener
{
  public ancz(QzoneQunFeedJsPlugin paramQzoneQunFeedJsPlugin, String[] paramArrayOfString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QzoneQunFeedJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneQunFeedJsPlugin, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancz
 * JD-Core Version:    0.7.0.1
 */