import com.tencent.biz.qqstory.takevideo.EditMusicExport;
import com.tencent.biz.qqstory.takevideo.EditSubtitleExport;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

public class ohg
  implements Runnable
{
  public ohg(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    Object localObject = (EditMusicExport)this.a.a(EditMusicExport.class);
    if (localObject != null) {
      ((EditMusicExport)localObject).b();
    }
    localObject = (EditSubtitleExport)this.a.a(EditSubtitleExport.class);
    if (localObject != null) {
      ((EditSubtitleExport)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohg
 * JD-Core Version:    0.7.0.1
 */