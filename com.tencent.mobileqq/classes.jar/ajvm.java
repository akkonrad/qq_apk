import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.Options;

public class ajvm
  implements Action.OnActionEndListener
{
  public ajvm(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView) {}
  
  public void a()
  {
    if (TroopGiftToAllSurfaceView.a(this.a).d == 0) {
      this.a.a(1, TroopGiftToAllSurfaceView.a(this.a));
    }
    for (;;)
    {
      if ((TroopGiftToAllSurfaceView.a(this.a) instanceof VideoSprite)) {
        ((VideoSprite)TroopGiftToAllSurfaceView.a(this.a)).b(TroopGiftToAllSurfaceView.a(this.a));
      }
      return;
      this.a.a(0, TroopGiftToAllSurfaceView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvm
 * JD-Core Version:    0.7.0.1
 */