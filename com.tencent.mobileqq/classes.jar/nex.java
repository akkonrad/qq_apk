import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader.OnPreloaderListener;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nex
  implements MsgTabStoryVideoPreloader.OnPreloaderListener
{
  private long jdField_a_of_type_Long;
  
  public nex(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate) {}
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      StoryReportor.b("msgtab", "preload_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nex
 * JD-Core Version:    0.7.0.1
 */