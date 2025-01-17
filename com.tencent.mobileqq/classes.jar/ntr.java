import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class ntr
  extends SimpleJob
{
  public ntr(QQStoryMainController paramQQStoryMainController) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    FileUtils.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ((PreloadDownloaderManager)SuperManager.a(6)).c();
    VideoViewFactory.a(this.a.jdField_a_of_type_AndroidAppActivity);
    PngQuantUtils.a(QQStoryContext.a());
    ((VideoServerInfoManager)SuperManager.a(4)).c();
    StoryUploadProcessor.q();
    paramJobContext = (StoryConfigManager)SuperManager.a(10);
    paramJobContext.c();
    paramJobContext.d();
    SLog.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(StoryVideoUploadManager.a()) });
    StoryMsgNotification.a().a(this.a.jdField_a_of_type_AndroidAppActivity, 3);
    SLog.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SLog.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    SLog.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.a.b = PtvFilterSoLoad.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    SLog.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    SLog.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.jdField_a_of_type_AndroidAppActivity);
    SLog.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntr
 * JD-Core Version:    0.7.0.1
 */