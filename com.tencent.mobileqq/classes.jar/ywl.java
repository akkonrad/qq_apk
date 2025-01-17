import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.ApolloGameItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloGameItemBuilder.GameHolder;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;

public final class ywl
  implements Runnable
{
  public ywl(WeakReference paramWeakReference, MessageForApollo paramMessageForApollo, Bundle paramBundle, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break label293;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo == null) {
          return;
        }
        localAbsListView = (AbsListView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localAbsListView == null) {
          break label293;
        }
        j = localAbsListView.getFirstVisiblePosition();
        k = localAbsListView.getLastVisiblePosition();
        if (!QLog.isColorLevel()) {
          break label294;
        }
        QLog.d("ApolloGameUtil", 2, new Object[] { "[notifyUIUpdate] firstVPos:", Integer.valueOf(j), ",lastVPos:", Integer.valueOf(k) });
      }
      catch (Throwable localThrowable)
      {
        AbsListView localAbsListView;
        int k;
        Object localObject;
        MessageForApollo localMessageForApollo;
        localThrowable.printStackTrace();
        QLog.e("ApolloGameUtil", 1, "[notifyUIUpdate],errInfo->" + localThrowable.getMessage());
      }
      if (i <= k)
      {
        localObject = localAbsListView.getChildAt(i - j);
        if (localObject != null)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject instanceof ArkAppItemBubbleBuilder.Holder))
          {
            localObject = (ApolloGameItemBuilder.GameHolder)localObject;
            localMessageForApollo = (MessageForApollo)((ApolloGameItemBuilder.GameHolder)localObject).a;
            if ((ApolloGameUtil.a(localMessageForApollo.msgType)) && (localMessageForApollo.roomId == this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.roomId))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameUtil", 2, new Object[] { "find the view with the same roomId,", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.roomId) });
              }
              if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getInt("type") == 1)) {
                ApolloGameItemBuilder.a((ApolloGameItemBuilder.GameHolder)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getInt("gameId"), this.jdField_a_of_type_AndroidOsBundle.getInt("process"));
              }
            }
          }
        }
      }
      else
      {
        label293:
        return;
        label294:
        i = j;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywl
 * JD-Core Version:    0.7.0.1
 */