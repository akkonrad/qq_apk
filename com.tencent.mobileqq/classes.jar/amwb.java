import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class amwb
  implements DialogInterface.OnClickListener
{
  public amwb(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.stopPlay();
    QzoneWebMusicJsPlugin.access$300(this.a, "cancel");
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$902(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwb
 * JD-Core Version:    0.7.0.1
 */