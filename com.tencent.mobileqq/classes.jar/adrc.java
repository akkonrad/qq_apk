import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpic.HotPicTab;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class adrc
  extends BaseAdapter
{
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  boolean jdField_a_of_type_Boolean;
  
  public adrc(HotPicTab paramHotPicTab, List paramList, ArrayList paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramArrayList.clone());
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new adre(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab);
      paramView = LayoutInflater.from(HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab)).inflate(2130968648, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131363010));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = ((HotPicTagInfo)getItem(paramInt)).tagName;
      paramViewGroup = paramViewGroup.a;
      paramViewGroup.setText(str);
      paramViewGroup.setTextSize(2, HotPicTab.b());
      paramViewGroup.setTextColor(HotPicTab.c());
      paramViewGroup.setPadding(0, 0, 0, 0);
      paramViewGroup.setFocusable(true);
      paramViewGroup.setGravity(17);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue(), -1));
      paramView.setContentDescription(str);
      paramView.setFocusable(true);
      paramView.setOnHoverListener(new adrd(this));
      if (!HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab).contains(Integer.valueOf(paramInt)))
      {
        ReportController.b(null, "dc00898", "", "", "0X8008077", "0X8008077", 0, 0, paramInt + "", "", str, "");
        HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab).add(Integer.valueOf(paramInt));
      }
      return paramView;
      paramViewGroup = (adre)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrc
 * JD-Core Version:    0.7.0.1
 */