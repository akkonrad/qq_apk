import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.ApolloGifDownloader;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class utv
  implements View.OnClickListener
{
  public utv(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (ApolloItemBuilder.a(this.a)) {}
    ApolloItemBuilder.Holder localHolder;
    do
    {
      return;
      localHolder = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    } while ((localHolder == null) || (localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (localHolder.jdField_a_of_type_ComTencentImageURLImageView == null));
    int i = localHolder.e;
    Object localObject1;
    if ((paramView instanceof TextView))
    {
      Object localObject2;
      int j;
      if (ApolloManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
      {
        ApolloUtil.a(paramView.getContext(), null, "aio", ApolloConstant.X, null);
        paramView = "1";
        localObject1 = ((ApolloManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = ApolloUtil.b(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
        j = localHolder.e;
        if (localObject1 != null) {
          break label302;
        }
      }
      label302:
      for (localObject1 = "0";; localObject1 = ((ApolloBaseInfo)localObject1).apolloStatus + "")
      {
        VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "clk_icon", i, 0, new String[] { String.valueOf(j), localObject1, paramView, ApolloManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + "" });
        return;
        if (!ApolloManager.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {}
        for (localObject1 = ApolloConstant.K;; localObject1 = ApolloConstant.L + i)
        {
          localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), (String)localObject1, -1L, (Intent)localObject2, false, -1);
          paramView = "0";
          break;
        }
      }
    }
    if (new File(ApolloItemBuilder.ApolloGifDownloader.a(i)).exists()) {
      ApolloItemBuilder.a(this.a.jdField_a_of_type_AndroidContentContext, localHolder.jdField_a_of_type_ComTencentImageURLImageView, (MessageForApollo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (paramView = "0";; paramView = "1")
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_gif", ApolloUtil.b(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop), 0, new String[] { String.valueOf(i), paramView, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      localObject1 = localHolder.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof URLDrawable)))
      {
        localObject1 = (URLDrawable)localObject1;
        if ((((URLDrawable)localObject1).getStatus() == 3) || (((URLDrawable)localObject1).getStatus() == 2))
        {
          if (!NetworkUtil.g(paramView.getContext())) {
            break;
          }
          this.a.a(localHolder, paramView.getResources(), true);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utv
 * JD-Core Version:    0.7.0.1
 */