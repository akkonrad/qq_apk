import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class ahzk
  implements Runnable
{
  public ahzk(ShortVideoPreDownloader paramShortVideoPreDownloader, ShortVideoDownloadInfo paramShortVideoDownloadInfo, MessageForShortVideo paramMessageForShortVideo, ShortVideoReq paramShortVideoReq) {}
  
  public void run()
  {
    ShortVideoPreDownloader.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.e + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahzk
 * JD-Core Version:    0.7.0.1
 */