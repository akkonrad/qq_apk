import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import java.util.ArrayList;

public class aizd
  extends BroadcastReceiver
{
  public aizd(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("key_photo_delete_action".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      if ((i >= 0) && (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
        this.a.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    do
    {
      do
      {
        return;
        if (!"key_audio_delete_action".equals(paramContext)) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      } while (!this.a.k);
      TroopBarUtils.a(this.a.m, this.a.n, "del_record", this.a.o, "", "", "");
      return;
    } while (!"key_photo_add_action".equals(paramContext));
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizd
 * JD-Core Version:    0.7.0.1
 */