import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;

public class amzd
  implements BusinessObserver
{
  public amzd(QZoneShareActivity paramQZoneShareActivity, String paramString, QZoneShareData paramQZoneShareData) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 1) && ((paramObject instanceof OpenID)))
    {
      paramObject = (OpenID)paramObject;
      if ((paramObject.openID != null) && (!paramObject.openID.equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzd
 * JD-Core Version:    0.7.0.1
 */