import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public class kvj
  implements FMDialogUtil.FMDialogInterface
{
  public kvj(VideoCoverView paramVideoCoverView) {}
  
  public void a()
  {
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.a = true;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.b = true;
    if (this.a.jdField_a_of_type_Int == 5) {
      this.a.d();
    }
    for (;;)
    {
      AdvertisementStatistics.a().a(VideoCoverView.a(this.a).a.c, this.a.jdField_a_of_type_JavaLangString, true);
      return;
      this.a.b(VideoCoverView.a(this.a));
    }
  }
  
  public void b()
  {
    this.a.jdField_a_of_type_Int = 6;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.a = false;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.b = true;
    this.a.g();
    AdvertisementStatistics.a().a(VideoCoverView.a(this.a).a.c, this.a.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvj
 * JD-Core Version:    0.7.0.1
 */