import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahti
  extends UniteSearchObserver
{
  public ahti(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.w(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "handleBusiHotWordError code=" + paramInt + " errorMsg;" + paramString);
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    HotWordsForSubBussFragment.jdField_a_of_type_Int = paramInt;
    HotWordsForSubBussFragment.a(this.a, paramList);
    if (QLog.isColorLevel()) {
      QLog.i(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult expireTime;" + HotWordsForSubBussFragment.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahti
 * JD-Core Version:    0.7.0.1
 */