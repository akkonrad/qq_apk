import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.FastAnimationDrawable;
import dov.com.tencent.biz.qqstory.takevideo.EditGifImage;
import dov.com.tencent.biz.qqstory.takevideo.EditGifSpeedControl;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class anrb
  implements SeekBar.OnSeekBarChangeListener
{
  public anrb(EditGifSpeedControl paramEditGifSpeedControl) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NativeGifImage.QZONE_DELAY = (int)(this.a.jdField_a_of_type_Double * paramInt + this.a.g);
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a != null) {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a.a(NativeGifImage.QZONE_DELAY);
      }
      this.a.jdField_a_of_type_Boolean = true;
      this.a.e = NativeGifImage.QZONE_DELAY;
      this.a.d = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "onProgressChanged | delayTime:" + this.a.e + " barPosition:" + this.a.d);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrb
 * JD-Core Version:    0.7.0.1
 */