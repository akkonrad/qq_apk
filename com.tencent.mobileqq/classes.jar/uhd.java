import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;

public class uhd
  extends VipBaseUpsImageUploadTask
{
  public uhd(VipProfileCardDiyActivity paramVipProfileCardDiyActivity, long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(paramLong, paramString1, paramArrayOfByte, paramString2);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 1001: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.k();
      } while (a() == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.a(this.jdField_a_of_type_JavaLangString, (UpsImageUploadResult)a(), this.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */