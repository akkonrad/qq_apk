import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.OnMsgTabNodeListLoadListener;
import java.util.ArrayList;
import java.util.Iterator;

public class nef
  implements Runnable
{
  public nef(MsgTabNodeListLoader paramMsgTabNodeListLoader, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.c.iterator();
    while (localIterator.hasNext()) {
      ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)localIterator.next()).a(this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nef
 * JD-Core Version:    0.7.0.1
 */