import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahlq
  implements Runnable
{
  public ahlq(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager) {}
  
  public void run()
  {
    this.a.setVisibility(0);
    List localList = CaptureVideoFilterManager.a().b();
    this.a.a.clear();
    int i = 0;
    if (i < localList.size())
    {
      if (i != 0)
      {
        FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)localList.get(i);
        if (!localFilterCategoryItem.a()) {
          this.a.a.add(localFilterCategoryItem);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.a.a.add(localList.get(i));
      }
    }
    CaptureVideoFilterViewPager.a(this.a).a();
    if (CaptureVideoFilterManager.a().a() == null) {
      this.a.setCurrentItem(CaptureVideoFilterViewPager.a(this.a).a() * 50, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "CaptureVideoFilterViewPager update size=" + this.a.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlq
 * JD-Core Version:    0.7.0.1
 */