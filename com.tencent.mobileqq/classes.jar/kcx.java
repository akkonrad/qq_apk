import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import java.lang.ref.WeakReference;

public class kcx
  implements Runnable
{
  WeakReference a;
  
  public kcx(EffectFilterPanel paramEffectFilterPanel)
  {
    this.a = new WeakReference(paramEffectFilterPanel);
  }
  
  public void run()
  {
    EffectFilterPanel localEffectFilterPanel = (EffectFilterPanel)this.a.get();
    if (localEffectFilterPanel != null) {
      localEffectFilterPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcx
 * JD-Core Version:    0.7.0.1
 */