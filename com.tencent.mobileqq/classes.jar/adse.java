import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.mobileqq.hotpic.RecyclerFooterWrapperAdapter;

public class adse
  extends RecyclerView.AdapterDataObserver
{
  public adse(RecyclerFooterWrapperAdapter paramRecyclerFooterWrapperAdapter) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.notifyDataSetChanged();
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    super.onItemRangeChanged(paramInt1, paramInt2);
    this.a.notifyItemRangeChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    super.onItemRangeInserted(paramInt1, paramInt2);
    this.a.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    this.a.notifyItemRangeChanged(paramInt1, paramInt2 + paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    super.onItemRangeRemoved(paramInt1, paramInt2);
    this.a.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adse
 * JD-Core Version:    0.7.0.1
 */