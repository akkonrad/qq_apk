import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.confess.ConfessObserver;

public class abrx
  extends ConfessObserver
{
  public abrx(ConfessMsgListFragment paramConfessMsgListFragment) {}
  
  public void a(ConfessConfig paramConfessConfig)
  {
    ConfessMsgListFragment.a(this.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (this.a.isResumed()) {
      this.a.c();
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.a.isResumed()) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrx
 * JD-Core Version:    0.7.0.1
 */