import com.tencent.mobileqq.troop.widget.TroopPickerViewHelper;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout.PickerViewAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ajuj
  implements WheelPickerLayout.PickerViewAdapter
{
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private final DateFormat jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("M月d日");
  private Date jdField_a_of_type_JavaUtilDate;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ajuj(TroopPickerViewHelper paramTroopPickerViewHelper, WheelPickerLayout paramWheelPickerLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = paramWheelPickerLayout;
    this.jdField_a_of_type_JavaUtilDate = new Date();
    paramWheelPickerLayout = Calendar.getInstance();
    paramWheelPickerLayout.setTime(this.jdField_a_of_type_JavaUtilDate);
    paramWheelPickerLayout.set(13, 0);
    paramWheelPickerLayout.set(14, 0);
    int i = paramWheelPickerLayout.get(11);
    if (i >= TroopPickerViewHelper.a(paramTroopPickerViewHelper))
    {
      paramWheelPickerLayout.add(5, 1);
      paramWheelPickerLayout.set(11, TroopPickerViewHelper.b(paramTroopPickerViewHelper));
      paramWheelPickerLayout.set(12, 0);
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilDate = paramWheelPickerLayout.getTime();
      return;
      if (i < TroopPickerViewHelper.b(paramTroopPickerViewHelper))
      {
        paramWheelPickerLayout.set(11, TroopPickerViewHelper.b(paramTroopPickerViewHelper));
        paramWheelPickerLayout.set(12, 0);
      }
      else
      {
        i = paramWheelPickerLayout.get(12);
        paramWheelPickerLayout.add(12, TroopPickerViewHelper.c(paramTroopPickerViewHelper) - i % TroopPickerViewHelper.c(paramTroopPickerViewHelper));
      }
    }
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(this.jdField_a_of_type_JavaUtilDate);
    if (paramInt > 0) {
      localCalendar.add(5, paramInt);
    }
    long l1 = this.jdField_a_of_type_JavaUtilDate.getTime();
    long l2 = localCalendar.getTimeInMillis();
    int i = (int)((l2 - l1) / 86400000L);
    paramInt = i;
    if (!this.jdField_a_of_type_Boolean) {
      paramInt = i + 1;
    }
    if (paramInt != 0) {
      localStringBuilder.append(this.jdField_a_of_type_JavaTextDateFormat.format(Long.valueOf(l2))).append(" ");
    }
    switch (paramInt)
    {
    default: 
      localStringBuilder.append(b(localCalendar.get(7)));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("今天");
      continue;
      localStringBuilder.append("明天");
      continue;
      localStringBuilder.append("后天");
    }
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "星期天";
    case 2: 
      return "星期一";
    case 3: 
      return "星期二";
    case 4: 
      return "星期三";
    case 5: 
      return "星期四";
    case 6: 
      return "星期五";
    }
    return "星期六";
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return TroopPickerViewHelper.d(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper);
    case 1: 
      paramInt = a(new int[] { this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(0) }).get(11);
      return TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper) - paramInt + 1;
    }
    return (60 - a(new int[] { this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(0), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(1) }).get(12)) / TroopPickerViewHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper);
  }
  
  public int a(Calendar paramCalendar, int paramInt)
  {
    paramInt = a(new int[] { paramInt }).get(11);
    paramInt = paramCalendar.get(11) - paramInt;
    if (paramInt > 0) {
      return paramInt;
    }
    return 0;
  }
  
  public int a(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    long l = a(new int[] { paramInt1, paramInt2 }).get(12);
    paramInt1 = (int)((paramCalendar.get(12) - l) / TroopPickerViewHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper));
    if (paramInt1 > 0) {
      return paramInt1;
    }
    return 0;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return a(paramInt2);
    case 1: 
      return String.format("%d点", new Object[] { Integer.valueOf(a(new int[] { this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(0), paramInt2 }).get(11)) });
    }
    return String.format("%d分", new Object[] { Integer.valueOf(a(new int[] { this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(0), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(1), paramInt2 }).get(12)) });
  }
  
  public Calendar a(int... paramVarArgs)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(this.jdField_a_of_type_JavaUtilDate);
    if (paramVarArgs[0] > 0)
    {
      localCalendar.add(5, paramVarArgs[0]);
      localCalendar.set(11, TroopPickerViewHelper.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper));
      localCalendar.set(12, 0);
    }
    if ((paramVarArgs.length > 1) && (paramVarArgs[1] > 0))
    {
      localCalendar.add(11, paramVarArgs[1]);
      localCalendar.set(12, 0);
    }
    if (paramVarArgs.length > 2) {
      localCalendar.add(12, paramVarArgs[2] * TroopPickerViewHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper));
    }
    return localCalendar;
  }
  
  public int[] a(long paramLong)
  {
    int[] arrayOfInt = new int[3];
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(this.jdField_a_of_type_JavaUtilDate);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    localCalendar2.set(14, 0);
    localCalendar1.set(11, 0);
    localCalendar1.set(12, 0);
    localCalendar1.set(13, 0);
    localCalendar1.set(14, 0);
    arrayOfInt[0] = ((int)((localCalendar1.getTimeInMillis() - localCalendar2.getTimeInMillis()) / 86400000L));
    localCalendar2 = a(new int[] { arrayOfInt[0] });
    localCalendar1.setTimeInMillis(paramLong);
    arrayOfInt[1] = (localCalendar1.get(11) - localCalendar2.get(11));
    localCalendar2 = a(new int[] { arrayOfInt[0], arrayOfInt[1] });
    arrayOfInt[2] = ((localCalendar1.get(12) - localCalendar2.get(12)) / TroopPickerViewHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper));
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuj
 * JD-Core Version:    0.7.0.1
 */