import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.widget.QQToast;

public class dct
  implements Runnable
{
  public dct(AddressData paramAddressData, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      QQToast.a(BaseApplicationImpl.a, "条件搜素配置文件存在不同code对应相同name的问题！！！ name = " + this.jdField_a_of_type_JavaLangString, 1).a();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dct
 * JD-Core Version:    0.7.0.1
 */