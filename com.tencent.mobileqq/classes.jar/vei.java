import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText;
import mqq.os.MqqHandler;

public class vei
  implements URLDrawable.DownloadListener
{
  public vei(ReplyTextItemBuilder paramReplyTextItemBuilder, MessageForReplyText paramMessageForReplyText, ver paramver, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mIsPlayedPicCommentAnimate) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.a instanceof MultiForwardActivity)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.uniseq))) {
      ThreadManager.getUIHandler().post(new vej(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vei
 * JD-Core Version:    0.7.0.1
 */