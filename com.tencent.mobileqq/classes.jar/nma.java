import android.os.Handler;
import com.tencent.biz.qqstory.playmode.child.VidListPlayMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.VideoInfoListEvent;

public class nma
  implements BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback
{
  public nma(VidListPlayMode paramVidListPlayMode) {}
  
  public void a(BatchGetVideoInfoHandler.VideoInfoListEvent paramVideoInfoListEvent)
  {
    this.a.a.post(new nmb(this, paramVideoInfoListEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nma
 * JD-Core Version:    0.7.0.1
 */