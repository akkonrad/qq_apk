import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class pbf
  implements View.OnClickListener
{
  public pbf(HotchatPlugin paramHotchatPlugin, String paramString, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginHotchatPlugin.a(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      paramView = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface();
      if ((paramView instanceof NearbyAppInterface)) {
        ((NearbyAppInterface)paramView).reportClickEvent("dc00899", "grp_lbs", "", "hot_create", "clk_create", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbf
 * JD-Core Version:    0.7.0.1
 */