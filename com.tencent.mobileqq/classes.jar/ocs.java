import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.biz.qqstory.takevideo.EditVideoButton;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.image.URLImageView;
import cooperation.qzone.widget.FastAnimationDrawable;

public class ocs
  implements Runnable
{
  public ocs(EditGifImage paramEditGifImage) {}
  
  public void run()
  {
    FastAnimationDrawable localFastAnimationDrawable = this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable;
    this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
    this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = this.a.b;
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
    this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
    this.a.b = localFastAnimationDrawable;
    this.a.d = true;
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocs
 * JD-Core Version:    0.7.0.1
 */