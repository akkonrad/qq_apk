import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import mqq.os.MqqHandler;

public class swz
  implements Runnable
{
  public swz(Leba paramLeba) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swz
 * JD-Core Version:    0.7.0.1
 */