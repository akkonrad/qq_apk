import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.tribe.videoupload.TribeVideoFileObject;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

public class aitc
  implements UpCallBack
{
  public aitc(TribeVideoFileObject paramTribeVideoFileObject) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramSendResult.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramSendResult.c;
      TribeVideoFileObject.a(this.a);
      TribeVideoFileObject.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramSendResult.jdField_b_of_type_Int == StoryUploadProcessor.a(940010)) && (TribeVideoFileObject.a(this.a).getAndIncrement() < 2))
    {
      TribeVideoFileObject.b(this.a);
      SLog.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    TribeVideoFileObject.c(this.a);
    paramSendResult = new ErrorMessage(paramSendResult.jdField_b_of_type_Int, paramSendResult.a);
    TribeVideoFileObject.a(this.a, paramSendResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitc
 * JD-Core Version:    0.7.0.1
 */