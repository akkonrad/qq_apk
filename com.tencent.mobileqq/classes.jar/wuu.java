import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class wuu
  extends PinnedDividerListView.DividerAdapter
{
  private wuu(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  public int a()
  {
    return 2130971503;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(((wuv)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString)).intValue();
    ((TextView)paramView).setText(((wuv)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return ((wuv)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((wuv)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    wuv localwuv = (wuv)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label107;
      }
      paramView = this.a.getLayoutInflater().inflate(a(), paramViewGroup, false);
    }
    label107:
    for (;;)
    {
      ((TextView)paramView).setText(localwuv.jdField_a_of_type_JavaLangString);
      for (;;)
      {
        paramView.setVisibility(0);
        return paramView;
        View localView = paramView;
        if (paramView == null)
        {
          localView = NewStyleCountryActivity.a(paramViewGroup, this.a.getLayoutInflater(), false);
          localView.setOnClickListener(this.a);
        }
        NewStyleCountryActivity.a(localView, localwuv);
        paramView = localView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wuu
 * JD-Core Version:    0.7.0.1
 */