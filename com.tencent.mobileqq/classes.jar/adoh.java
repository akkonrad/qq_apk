import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;

public class adoh
  implements ActionMode.Callback
{
  public adoh(BlockableEditTextView paramBlockableEditTextView) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (BlockableEditTextView.a(this.a) == 0) {
      return true;
    }
    return BlockableEditTextView.a(this.a);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adoh
 * JD-Core Version:    0.7.0.1
 */