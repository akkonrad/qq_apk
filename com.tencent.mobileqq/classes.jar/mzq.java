import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.StoryBoss;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class mzq
  extends FutureListener.SimpleFutureListener
{
  public mzq(StoryBoss paramStoryBoss, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Object paramObject)
  {
    Dispatchers.get().dispatch(new JobController.DoneEvent(this.jdField_a_of_type_ComTribeAsyncAsyncWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzq
 * JD-Core Version:    0.7.0.1
 */