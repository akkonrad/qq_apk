import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import java.lang.ref.WeakReference;

public class aapl
  implements Runnable
{
  public aapl(ArkAppModuleReg.ModuleQQ paramModuleQQ, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.jdField_a_of_type_Long);
    if (localObject == null) {}
    ArkFullScreenAppActivity localArkFullScreenAppActivity;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity));
        localArkFullScreenAppActivity = (ArkFullScreenAppActivity)BaseActivity.sTopActivity;
        localObject = ArkAppContainer.a((ark.Container)localObject);
      } while (localObject == null);
      localObject = (ArkAppContainer)((WeakReference)localObject).get();
    } while (localObject == null);
    localArkFullScreenAppActivity.a((ArkAppContainer)localObject, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapl
 * JD-Core Version:    0.7.0.1
 */