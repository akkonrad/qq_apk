import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class aomp
  implements ViewPager.OnPageChangeListener
{
  public int a;
  
  public aomp(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageScrollStateChanged state: " + paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageScrolled position: " + paramInt1 + ", positionOffset: " + paramFloat + ", positionOffsetPixels: " + paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageSelected l " + this.jdField_a_of_type_Int + ",n " + paramInt);
      }
    }
    Object localObject;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageSelected l " + this.jdField_a_of_type_Int + ",n" + paramInt);
      }
      FlowCameraMqqAction.a("", "0X8007804", "", "", "", "");
      this.jdField_a_of_type_Int = paramInt;
      View localView = CaptureVideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager).a(paramInt);
      if (localView != null)
      {
        localObject = (Runnable)localView.getTag();
        if (localObject != null)
        {
          localView.removeCallbacks((Runnable)localObject);
          localView.setTag(null);
        }
        CaptureVideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager, localView, paramInt, false);
      }
      localView = CaptureVideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager).a(paramInt - 1);
      localObject = CaptureVideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager).a(paramInt + 1);
      if (localView != null)
      {
        localView.removeCallbacks((Runnable)localView.getTag());
        localView.clearAnimation();
      }
    } while (localObject == null);
    ((View)localObject).removeCallbacks((Runnable)((View)localObject).getTag());
    ((View)localObject).clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomp
 * JD-Core Version:    0.7.0.1
 */