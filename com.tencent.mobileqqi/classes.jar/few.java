import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import protocol.KQQConfig.GetResourceRespInfo;

public class few
  implements Runnable
{
  public few(ConfigHandler paramConfigHandler, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    File localFile = new File(AppConstants.aQ);
    try
    {
      if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a, new URL(this.jdField_a_of_type_JavaLangString), localFile))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(1, true, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(1, false, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(1, false, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     few
 * JD-Core Version:    0.7.0.1
 */