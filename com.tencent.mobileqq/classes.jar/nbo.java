import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.channel.StoryMsfServlet;
import com.tencent.common.app.AppInterface;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.NewIntent;

public class nbo
  extends SimpleJob
{
  public nbo(QQStoryCmdHandler paramQQStoryCmdHandler, NetworkRequest paramNetworkRequest) {}
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    try
    {
      paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a();
      paramArrayOfObject = Integer.valueOf(QQStoryCmdHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler).getAndIncrement());
      AppInterface localAppInterface = QQStoryContext.a();
      NewIntent localNewIntent = new NewIntent(localAppInterface.getApp(), StoryMsfServlet.class);
      localNewIntent.putExtra("storySeq", paramArrayOfObject);
      localNewIntent.putExtra("cmd", this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a());
      localNewIntent.putExtra("data", paramJobContext);
      localNewIntent.putExtra("start_time", System.currentTimeMillis());
      if (this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler.a.contains(Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a())))
      {
        localNewIntent.putExtra("timeout", 10000L);
        localNewIntent.putExtra("support_retry", true);
      }
      QQStoryCmdHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler).put(paramArrayOfObject, this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest);
      localAppInterface.startServlet(localNewIntent);
      return null;
    }
    catch (QQStoryCmdHandler.IllegalUinException paramJobContext)
    {
      Bosses.get().scheduleJobDelayed(new nbp(this, paramJobContext), 100);
    }
    return null;
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbo
 * JD-Core Version:    0.7.0.1
 */