package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.data.FilterCategory;
import java.util.ArrayList;

public class FilterProviderPagerAdapter
  extends PagerAdapter
{
  public static final int a;
  public static final int b = AIOUtils.a(0.0F, BaseApplication.getContext().getResources());
  private Context jdField_a_of_type_AndroidContentContext;
  public SparseArray a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public int c;
  
  static
  {
    jdField_a_of_type_Int = AIOUtils.a(7.0F, BaseApplication.getContext().getResources());
  }
  
  public FilterProviderPagerAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "instantiateItem position = " + paramInt);
    }
    Object localObject2 = (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GridView(this.jdField_a_of_type_AndroidContentContext);
      ((GridView)localObject1).setNumColumns(4);
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setVerticalSpacing(b);
      ((GridView)localObject1).setHorizontalSpacing(b);
      ((GridView)localObject1).setClipToPadding(false);
      ((GridView)localObject1).setPadding(jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int + jdField_a_of_type_Int + AIOUtils.a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      localObject2 = new FilterProviderGridAdapter(this.jdField_a_of_type_AndroidContentContext, this.c);
      ((FilterProviderGridAdapter)localObject2).a(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a);
      ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
      ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    paramViewGroup.addView((View)localObject1, -1, -1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */