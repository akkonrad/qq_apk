import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ahlw
  extends PagerAdapter
{
  public final SparseArray a;
  public ArrayList a;
  public final Map a;
  
  public ahlw(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i > 0) {
      return paramInt % i;
    }
    return -1;
  }
  
  @Nullable
  public View a(int paramInt)
  {
    return (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public FilterCategoryItem a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (FilterCategoryItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.a);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "destroyItem position: " + paramInt);
    }
    View localView = (View)paramObject;
    localView.removeCallbacks((Runnable)localView.getTag());
    localView.clearAnimation();
    paramViewGroup.removeView(localView);
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localView.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localView.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localView);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "instantiateItem position: " + paramInt);
    }
    FilterCategoryItem localFilterCategoryItem = a(paramInt);
    if (localFilterCategoryItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("VideoFilterViewPager", 2, "instantiateItem find data is null!");
      }
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localFilterCategoryItem.getClass());
    if (localObject1 != null) {}
    for (localObject1 = (View)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.getContext().getSystemService("layout_inflater")).inflate(2130968736, null);
        ((View)localObject2).setVisibility(8);
      }
      ((View)localObject2).setContentDescription(localFilterCategoryItem.b + "," + localFilterCategoryItem.f + "在使用");
      paramViewGroup.addView((View)localObject2);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof View)) && (paramObject == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlw
 * JD-Core Version:    0.7.0.1
 */