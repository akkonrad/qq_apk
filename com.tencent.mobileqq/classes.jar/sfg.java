import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class sfg
  implements View.OnClickListener
{
  public sfg(ChatTextSizeSettingActivity paramChatTextSizeSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.a = 0;
    }
    for (;;)
    {
      this.a.a(this.a.a);
      ReportController.b(this.a.app, "CliOper", "", "", "Trends_tab", "Font_size", 0, 0, Integer.toString(this.a.a), "", "", "");
      return;
      this.a.a = 1;
      continue;
      this.a.a = 2;
      continue;
      this.a.a = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfg
 * JD-Core Version:    0.7.0.1
 */