import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;

public final class nfk
  implements Runnable
{
  public nfk(MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void run()
  {
    MsgTabStoryManager.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfk
 * JD-Core Version:    0.7.0.1
 */