import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutNew2;
import java.lang.ref.WeakReference;

public class aijk
  implements View.OnClickListener
{
  String jdField_a_of_type_JavaLangString = null;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  String b = null;
  
  public aijk(StructMsgItemLayoutNew2 paramStructMsgItemLayoutNew2, Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_JavaLangString = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.b = paramString2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    Object localObject;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity)) && (!MultiForwardActivity.class.isInstance(this.jdField_a_of_type_JavaLangRefWeakReference.get())))
    {
      paramView = ((FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getChatFragment();
      if (paramView != null)
      {
        localBaseChatPie = paramView.a();
        ChatActivityFacade.b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString + " +1");
        localObject = "";
        paramView = (View)localObject;
        if (!TextUtils.isEmpty(this.b)) {
          paramView = Uri.parse(this.b);
        }
      }
    }
    try
    {
      paramView = paramView.getQueryParameter("article_id");
      localObject = paramView;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = "";
    }
    PublicAccountReportUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8007239", "0X8007239", 0, 0, paramView, "", "", "");
    PublicAccountReportUtils.a("0X8007239", "", paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijk
 * JD-Core Version:    0.7.0.1
 */