import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.biz.qqstory.takevideo2.GetFirstMediaThumbnailFunction;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryLocalPublishPart;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class aevc
  extends SimpleJob
{
  public aevc(StoryLocalPublishPart paramStoryLocalPublishPart, View paramView) {}
  
  protected Bitmap a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    return new GetFirstMediaThumbnailFunction(this.jdField_a_of_type_AndroidViewView.getContext()).a();
  }
  
  protected void a(@Nullable Bitmap paramBitmap)
  {
    new Handler(Looper.getMainLooper()).post(new aevd(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevc
 * JD-Core Version:    0.7.0.1
 */