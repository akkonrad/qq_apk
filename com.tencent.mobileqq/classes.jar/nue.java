import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class nue
  extends SimpleJob
{
  public nue(CommentListPageLoader paramCommentListPageLoader, CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent, boolean paramBoolean) {}
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.b();
    ((CommentManager)SuperManager.a(17)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader$GetFeedCommentEvent.a, CommentListPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader).a, CommentListPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader).a(), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.a("Q.qqstory.detail:CommentListPageLoader");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nue
 * JD-Core Version:    0.7.0.1
 */