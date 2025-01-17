import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class roq
  extends FriendListObserver
{
  private roq(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramString1)) {
      return;
    }
    if (paramBoolean)
    {
      if ((!AutoRemarkActivity.a(this.a.b)) && (!this.a.jdField_a_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo remark = " + paramString2);
        }
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString2);
      }
      try
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
        if (AppSetting.b) {
          AutoRemarkActivity.a(this.a).setContentDescription(this.a.getResources().getString(2131433493) + this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        }
        this.a.c = paramInt;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.a.app, this.a.c));
        return;
      }
      catch (IndexOutOfBoundsException paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
          }
        }
      }
    }
    this.a.c = 0;
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.a.app, this.a.c));
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((this.a.jdField_a_of_type_Int == 1) && (TextUtils.equals(paramString1, this.a.jdField_a_of_type_JavaLangString)))
    {
      this.a.getIntent().getLongExtra("k_msg_key", 0L);
      if ((paramBoolean) && (NetworkUtil.d(this.a)))
      {
        this.a.e = 0;
        this.a.jdField_a_of_type_JavaLangString = paramString1;
        this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_a_of_type_JavaLangString, (byte)this.a.c, (byte)0);
      }
    }
    else
    {
      return;
    }
    if ((this.a.e == 2) || (!NetworkUtil.d(this.a)))
    {
      AutoRemarkActivity.f(this.a);
      AutoRemarkActivity.a(this.a, this.a.getString(2131434460));
      return;
    }
    paramString2 = this.a;
    paramString2.e += 1;
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(paramString1, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.equals(paramString, this.a.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (paramBoolean1)
      {
        if (paramBundle.getInt("resultCode") == 0)
        {
          int i = paramBundle.getInt("friend_setting");
          if (paramBundle.getString("nick_name") == null) {}
          switch (i)
          {
          default: 
            AutoRemarkActivity.c(this.a);
            QQToast.a(this.a, 2, 2131434461, 0).b(this.a.getTitleBarHeight());
            this.a.a();
          }
          for (;;)
          {
            ((BabyQHandler)this.a.app.a(53)).a(this.a.getIntent());
            return;
            AutoRemarkActivity.a(this.a);
            QQToast.a(this.a, 2, 2131435282, 0).b(this.a.getTitleBarHeight());
            this.a.a();
            continue;
            AutoRemarkActivity.b(this.a);
            QQToast.a(this.a, 2, 2131434461, 0).b(this.a.getTitleBarHeight());
            this.a.a();
          }
        }
        AutoRemarkActivity.d(this.a);
        paramBundle = paramBundle.getString("ErrorString");
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "add friend response error and ErroString = " + paramBundle);
        }
        paramString = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          paramString = this.a.getString(2131434460);
        }
        AutoRemarkActivity.a(this.a, paramString);
        return;
      }
      AutoRemarkActivity.e(this.a);
      AutoRemarkActivity.a(this.a, this.a.getString(2131434460));
    } while (!QLog.isColorLevel());
    QLog.d("AutoRemarkActivity", 2, "add friend response error and isSuccuss = NO");
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.jdField_a_of_type_Int == 1)
    {
      if (paramString != null) {
        break label40;
      }
      AutoRemarkActivity.g(this.a);
      AutoRemarkActivity.a(this.a, this.a.getString(2131434460));
    }
    label40:
    while (!paramString.equals(this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.setResult(-1);
    this.a.finish();
    this.a.overridePendingTransition(2131034131, 2131034382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     roq
 * JD-Core Version:    0.7.0.1
 */