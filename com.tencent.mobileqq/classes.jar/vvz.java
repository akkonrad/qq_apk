import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class vvz
  extends ShieldListObserver
{
  public vvz(NearbyChatPie paramNearbyChatPie) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    ChatActivityUtils.b();
    Object localObject = this.a.jdField_a_of_type_AndroidContentContext;
    Context localContext = this.a.jdField_a_of_type_AndroidContentContext;
    int i;
    if (paramBoolean)
    {
      i = 2131434508;
      QQToast.a((Context)localObject, 2, localContext.getString(i), 0).b(this.a.a());
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label69;
      }
    }
    label69:
    do
    {
      int k;
      do
      {
        return;
        i = 2131434510;
        break;
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        if (paramList == null) {}
        for (i = 0;; i = paramList.size())
        {
          int j = 0;
          k = 0;
          while ((k == 0) && (j < i))
          {
            if (Utils.a(String.valueOf(paramList.get(j)), localObject)) {
              k = 1;
            }
            j += 1;
          }
        }
      } while (k == 0);
      ChatActivityUtils.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramBoolean, false);
    } while (!paramBoolean);
    this.a.k();
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    int k = 0;
    ChatActivityUtils.b();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    do
    {
      do
      {
        return;
        String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        if (paramList == null) {}
        for (int i = 0;; i = paramList.size())
        {
          int j = 0;
          while ((k == 0) && (j < i))
          {
            if (Utils.a(String.valueOf(paramList.get(j)), str)) {
              k = 1;
            }
            j += 1;
          }
        }
      } while (k == 0);
      ChatActivityUtils.b();
    } while (!paramBoolean);
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vvz
 * JD-Core Version:    0.7.0.1
 */