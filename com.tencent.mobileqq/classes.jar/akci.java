import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class akci
  implements Runnable
{
  public akci(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, 0L, 0L, new HashMap(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akci
 * JD-Core Version:    0.7.0.1
 */