import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller.GetMemoryCollectionKeyEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;

public class nxg
  extends SimpleJob
{
  public nxg(MemoryDataPuller paramMemoryDataPuller, String paramString) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (MemoryManager)SuperManager.a(19);
    paramVarArgs = paramJobContext.a(DateCollectionListPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.b));
    MemoryDataPuller.GetMemoryCollectionKeyEvent localGetMemoryCollectionKeyEvent = new MemoryDataPuller.GetMemoryCollectionKeyEvent(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.c);
    ArrayList localArrayList = new ArrayList();
    localGetMemoryCollectionKeyEvent.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localGetMemoryCollectionKeyEvent.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localGetMemoryCollectionKeyEvent.jdField_a_of_type_Boolean = bool;
      Dispatchers.get().dispatch(localGetMemoryCollectionKeyEvent);
      SLog.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localGetMemoryCollectionKeyEvent.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxg
 * JD-Core Version:    0.7.0.1
 */