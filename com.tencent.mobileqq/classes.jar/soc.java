import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;

public class soc
  implements View.OnClickListener
{
  public soc(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent().getExtras();
    paramView.putString("uin", AppConstants.az);
    paramView.putInt("uintype", -1);
    paramView.putString("uinname", "日迹");
    this.a.a.a(ForwardAbility.ForwardAbilityType.m.intValue(), paramView);
    StoryReportor.a("plus_shoot", "clk_option", 0, 0, new String[] { "", "", "", "" });
    StoryReportor.a("plus_shoot", "exp_tip", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     soc
 * JD-Core Version:    0.7.0.1
 */