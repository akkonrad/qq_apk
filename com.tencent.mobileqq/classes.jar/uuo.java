import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class uuo
  implements Runnable
{
  public uuo(ArkAppItemBubbleBuilder.Holder paramHolder1, String paramString, ArkAppItemBubbleBuilder.Holder paramHolder2) {}
  
  public void run()
  {
    String str = ArkAppCenter.b(this.jdField_a_of_type_JavaLangString);
    ArkAppCenter.a().postToMainThread(new uup(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uuo
 * JD-Core Version:    0.7.0.1
 */