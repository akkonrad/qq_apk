import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

public class nba
  implements UpCallBack
{
  public nba(StoryVideoFileObject paramStoryVideoFileObject) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadUploadResult.c = paramSendResult.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadUploadResult.a = paramSendResult.c;
      this.a.b();
      StoryVideoFileObject.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramSendResult.jdField_b_of_type_Int == StoryUploadProcessor.a(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      StoryVideoFileObject.a(this.a);
      SLog.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramSendResult = new ErrorMessage(paramSendResult.jdField_b_of_type_Int, paramSendResult.a);
    StoryVideoFileObject.a(this.a, paramSendResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nba
 * JD-Core Version:    0.7.0.1
 */