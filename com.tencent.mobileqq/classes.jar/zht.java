import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.FaceScoreWording;

public class zht
  implements Runnable
{
  public zht(NearbyGrayTipsManager.FaceScoreWording paramFaceScoreWording1, NearbyGrayTipsManager.FaceScoreWording paramFaceScoreWording2) {}
  
  public void run()
  {
    String str = NearbyGrayTipsManager.FaceScoreWording.getPath(this.a.id);
    NearbyGrayTipsManager.a(this.a, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zht
 * JD-Core Version:    0.7.0.1
 */