import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtViewStatus.Listener;
import com.tencent.gdtad.views.freeflip.GdtFreeFlipView;

public class qmq
  implements GdtViewStatus.Listener
{
  public qmq(GdtFreeFlipView paramGdtFreeFlipView) {}
  
  public void a()
  {
    GdtLog.b("GdtFreeFlipView", "onViewResume");
    GdtFreeFlipView.a(this.a);
  }
  
  public void b()
  {
    GdtLog.b("GdtFreeFlipView", "onViewPause");
    GdtFreeFlipView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qmq
 * JD-Core Version:    0.7.0.1
 */