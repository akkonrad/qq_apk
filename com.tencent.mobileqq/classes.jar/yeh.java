import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class yeh
  implements DialogInterface.OnClickListener
{
  public yeh(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = ShortVideoPreviewActivity.a(this.a);
    paramDialogInterface = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localObject = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    Intent localIntent = new Intent();
    localIntent.setClassName((String)localObject, paramDialogInterface);
    localIntent.addFlags(603979776);
    localIntent.putExtra("file_send_path", this.a.c);
    localIntent.putExtra("file_send_size", this.a.a);
    localIntent.putExtra("file_send_duration", this.a.jdField_b_of_type_Long);
    localIntent.putExtra("file_source", this.a.jdField_b_of_type_JavaLangString);
    this.a.startActivity(localIntent);
    ShortVideoPreviewActivity.a(this.a);
    localObject = new Intent("key_video_select_confirm_ok_click");
    ((Intent)localObject).putExtra("className", paramDialogInterface);
    this.a.sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yeh
 * JD-Core Version:    0.7.0.1
 */