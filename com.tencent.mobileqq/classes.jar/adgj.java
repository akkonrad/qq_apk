import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.List;

public class adgj
  implements Runnable
{
  public adgj(FMSettings paramFMSettings, Activity paramActivity, List paramList, FMSettingInterface.MoveFileCallback paramMoveFileCallback) {}
  
  public void run()
  {
    View localView = RelativeLayout.inflate(this.jdField_a_of_type_AndroidAppActivity, 2130970034, null);
    TextView localTextView = (TextView)localView.findViewById(2131366642);
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131368829)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131364117);
    localProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2130968844, "下载通知", this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_JavaLangString + '\n' + this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b, "取消", "确定", new adgk(this, localTextView, localProgressBar), new adgp(this)).addView(localView);
    FileManagerReporter.a("0X8005BE1");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adgj
 * JD-Core Version:    0.7.0.1
 */