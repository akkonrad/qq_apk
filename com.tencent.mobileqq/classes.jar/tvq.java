import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class tvq
  implements CompoundButton.OnCheckedChangeListener
{
  public tvq(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    default: 
      return;
    }
    TroopAssistantManager.a().a(this.a.app, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvq
 * JD-Core Version:    0.7.0.1
 */