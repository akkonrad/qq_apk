import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abqw
  implements IphonePickerView.PickerViewAdapter
{
  public abqw(LocationSelectActivity paramLocationSelectActivity) {}
  
  public int getColumnCount()
  {
    return this.a.jdField_a_of_type_Int;
  }
  
  public int getRowCount(int paramInt)
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangObject[paramInt] != null) {
      return ((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[paramInt]).size();
    }
    return 0;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.a.jdField_a_of_type_ArrayOfJavaLangObject[paramInt1] != null)
      {
        if (((BaseAddress)((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[paramInt1]).get(paramInt2)).code.equals("0")) {
          return "----";
        }
        String str = ((BaseAddress)((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[paramInt1]).get(paramInt2)).name;
        return str;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationSelectActivity", 2, "", localIndexOutOfBoundsException);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqw
 * JD-Core Version:    0.7.0.1
 */