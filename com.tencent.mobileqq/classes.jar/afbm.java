import android.app.Activity;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserGalleryScene;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserModel;

public class afbm
  extends GalleryManager
{
  public afbm(NearbyProfilePicBrowserActivity paramNearbyProfilePicBrowserActivity) {}
  
  public AbstractAnimationManager a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return super.a(paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new NearbyProfilePicBrowserGalleryScene((PicBrowserActivity)paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    paramActivity = new PicBrowserModel(this.a, this.a.jdField_b_of_type_JavaUtilArrayList);
    paramActivity.a(this.a.jdField_b_of_type_Int);
    return paramActivity;
  }
  
  public AbstractImageListScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afbm
 * JD-Core Version:    0.7.0.1
 */