import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner;

public class nah
  implements Runnable
{
  public nah(PreloadDownloaderManager paramPreloadDownloaderManager) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.b();
    this.a.jdField_a_of_type_JavaLangRunnable = null;
    CacheCleaner.a().a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nah
 * JD-Core Version:    0.7.0.1
 */