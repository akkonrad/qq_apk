import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;

public class eue
  implements Runnable
{
  public eue(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void run()
  {
    NearFieldDiscussHandler localNearFieldDiscussHandler = (NearFieldDiscussHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(40);
    nearfield_discuss.LBSInfo localLBSInfo = CreateFaceToFaceDiscussionActivity.a(this.a);
    localNearFieldDiscussHandler.a(this.a.a.toString(), this.a.jdField_b_of_type_Int, localLBSInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eue
 * JD-Core Version:    0.7.0.1
 */