import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import java.util.ArrayList;

public class aeqb
  extends NearbyCardObserver
{
  public aeqb(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new aeqc(this, paramBoolean, paramInt1, paramArrayList));
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new aeqd(this, paramBoolean, paramInt1, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqb
 * JD-Core Version:    0.7.0.1
 */