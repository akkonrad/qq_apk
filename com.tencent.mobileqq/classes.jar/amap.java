import android.database.DataSetObserver;
import com.tencent.widget.AdapterViewPagerAdapter;

public class amap
  extends DataSetObserver
{
  public amap(AdapterViewPagerAdapter paramAdapterViewPagerAdapter) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amap
 * JD-Core Version:    0.7.0.1
 */