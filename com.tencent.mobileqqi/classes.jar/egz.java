import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;

public class egz
  implements View.OnClickListener
{
  public egz(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onClick(View paramView)
  {
    paramView = (AIOImageInfo)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(AIOGalleryScene.a(this.a).b());
    if ((paramView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()))
    {
      this.a.a(true);
      this.a.jdField_a_of_type_Ehd = new ehd(this.a, null);
      this.a.jdField_a_of_type_Ehd.jdField_a_of_type_Long = paramView.a.jdField_a_of_type_Long;
      this.a.jdField_a_of_type_Ehd.jdField_a_of_type_Int = paramView.a.d;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.a.jdField_a_of_type_Ehd.jdField_a_of_type_Long, this.a.jdField_a_of_type_Ehd.jdField_a_of_type_Int, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     egz
 * JD-Core Version:    0.7.0.1
 */