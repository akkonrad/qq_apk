import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

class vfw
  implements Runnable
{
  vfw(vft paramvft, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    FileUtils.a(new File(this.jdField_a_of_type_Vft.b), new File(ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfw
 * JD-Core Version:    0.7.0.1
 */