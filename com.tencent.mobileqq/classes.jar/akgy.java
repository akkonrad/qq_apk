import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class akgy
  implements HostnameVerifier
{
  public akgy(HttpCommunicator paramHttpCommunicator, String paramString, HttpMsg paramHttpMsg) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.jdField_a_of_type_JavaLangString, paramSSLSession);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, "httpsSSLProcess,HostnameVerifier", "reqhost = " + this.jdField_a_of_type_JavaLangString + ",address = " + paramSSLSession.getPeerHost() + "result:isverify = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgy
 * JD-Core Version:    0.7.0.1
 */