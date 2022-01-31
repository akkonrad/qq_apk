import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.opengroup.AppUrlOpenGroup.RspBody;

public class aknl
  implements BusinessObserver
{
  public aknl(WebViewFragment paramWebViewFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, " checkAppUrl,onReceive:isSuccess=" + paramBoolean);
    }
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    while (!paramBoolean) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.i = true;
    paramBundle = paramBundle.getByteArray("data");
    Object localObject = new AppUrlOpenGroup.RspBody();
    try
    {
      ((AppUrlOpenGroup.RspBody)localObject).mergeFrom(paramBundle);
      this.a.m = ((AppUrlOpenGroup.RspBody)localObject).bytes_app_name.get().toStringUtf8();
      this.a.n = ((AppUrlOpenGroup.RspBody)localObject).bytes_company.get().toStringUtf8();
      this.a.p = ((AppUrlOpenGroup.RspBody)localObject).bytes_info_url.get().toStringUtf8();
      this.a.o = ((AppUrlOpenGroup.RspBody)localObject).bytes_share_url.get().toStringUtf8();
      if (this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      paramBundle = (TextView)this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363470);
      localObject = (TextView)this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363471);
      paramBundle.setText(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidWidgetTextView.getText());
      ((TextView)localObject).setText(2131433187);
      this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.setImageResource(2130839147);
      return;
    }
    catch (Exception paramBundle) {}catch (InvalidProtocolBufferMicroException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aknl
 * JD-Core Version:    0.7.0.1
 */