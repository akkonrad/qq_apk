import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class xzg
  implements View.OnClickListener
{
  public xzg(PhoneContactSelectActivity paramPhoneContactSelectActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(this.a))
    {
      QQToast.a(this.a, this.a.getString(2131433009), 0).b(this.a.c.getHeight());
      return;
    }
    PstnManager localPstnManager = (PstnManager)this.a.app.getManager(142);
    Object localObject;
    if ((this.a.d == 0) && (this.a.a.getBooleanExtra("sendToVideo", false)) && (localPstnManager.d() == 1) && (PstnUtils.a(this.a.app, 2)) && (!localPstnManager.b()))
    {
      paramView = this.a.i.iterator();
      do
      {
        if (!paramView.hasNext()) {
          break;
        }
        localObject = (ResultRecord)paramView.next();
      } while ((((ResultRecord)localObject).jdField_a_of_type_Int != 0) || (!ChatActivityUtils.a(this.a.app, 0, ((ResultRecord)localObject).jdField_a_of_type_JavaLangString)));
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.a.f != null))
      {
        paramView = this.a.f.iterator();
        while (paramView.hasNext())
        {
          localObject = (String)paramView.next();
          if (ChatActivityUtils.a(this.a.app, 0, (String)localObject)) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if ((i != 0) || (NetworkUtil.b(this.a) == 2))
        {
          paramView = this.a.app.getApplication().getResources().getString(2131438411);
          localObject = this.a.app.getApplication().getResources().getString(2131438412);
          String str2 = localPstnManager.a("pstn_multi_trans_wording");
          String str1 = localPstnManager.a("pstn_multi_trans_check_wording");
          if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str1)) {
              break label369;
            }
          }
          for (;;)
          {
            DialogUtil.a(this.a, 230, "确认呼叫方式", paramView, (String)localObject, "取消", "呼叫", null, new xzh(this, localPstnManager), new xzi(this)).show();
            return;
            paramView = str2;
            break;
            label369:
            localObject = str1;
          }
        }
        if (PhoneContactSelectActivity.a(this.a)) {
          break;
        }
        this.a.a();
        return;
        if (PhoneContactSelectActivity.a(this.a)) {
          break;
        }
        if (this.a.e == 1005)
        {
          DialogUtil.a(this.a, 230, this.a.getResources().getString(2131429579), this.a.getResources().getString(2131429580), this.a.getResources().getString(2131429581), this.a.getResources().getString(2131429582), new xzj(this), new xzk(this)).show();
          return;
        }
        this.a.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzg
 * JD-Core Version:    0.7.0.1
 */