import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class nnw
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  int c = 0;
  
  public nnw(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.c + this.jdField_a_of_type_Int >= this.b))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.b) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.a(3);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.a(1);
    nnz.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.a);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnw
 * JD-Core Version:    0.7.0.1
 */