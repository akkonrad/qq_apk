import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;

public class bfk
  extends FriendListObserver
{
  public bfk(QQSettingMe paramQQSettingMe) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new bfl(this));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      this.a.a(paramString);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1) && (this.a.b)) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new bfm(this));
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    int k = 0;
    String str;
    int i;
    if ((paramBoolean) && (this.a.b) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (str != null)
      {
        j = k;
        if (i < paramArrayOfString.length)
        {
          if (!str.equals(paramArrayOfString[i])) {
            break label97;
          }
          j = 1;
        }
      }
      if (j != 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new bfn(this));
      }
      return;
      label97:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bfk
 * JD-Core Version:    0.7.0.1
 */