import com.tencent.widget.AdapterView;

public class amao
  implements Runnable
{
  private amao(AdapterView paramAdapterView) {}
  
  public void run()
  {
    if (this.a.mDataChanged)
    {
      if (this.a.getAdapter() != null) {
        this.a.post(this);
      }
      return;
    }
    AdapterView.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amao
 * JD-Core Version:    0.7.0.1
 */