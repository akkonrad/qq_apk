import com.tencent.mobileqq.ar.ARLBSObserver;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudLBSLocationCheckCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;

public class aaev
  extends ARLBSObserver
{
  public aaev(ARCloudFileUpload paramARCloudFileUpload) {}
  
  public void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult)
  {
    if (ARCloudFileUpload.a(this.a) != null) {
      ARCloudFileUpload.a(this.a).a(paramARCloudLBSLocationCheckResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaev
 * JD-Core Version:    0.7.0.1
 */