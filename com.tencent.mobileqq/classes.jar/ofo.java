import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class ofo
  extends SimpleJob
{
  public ofo(EditVideoPartManager paramEditVideoPartManager, String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    StoryReportor.a("video_edit", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ArrayOfJavaLangString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofo
 * JD-Core Version:    0.7.0.1
 */