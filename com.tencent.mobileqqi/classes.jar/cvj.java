import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.DisplayMode;
import com.tencent.mobileqq.gesturelock.LockPatternView.OnPatternListener;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class cvj
  implements LockPatternView.OnPatternListener
{
  public cvj(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void a() {}
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      String str1 = GesturePWDUtils.getGesturePWD(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      String str2 = MD5.toMD5(GesturePWDUtils.patternToString(paramList));
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((str1 != null) && (((str2 != null) && (str2.equals(str1))) || ((paramList != null) && (paramList.equals(str1)))))
      {
        com.tencent.mobileqq.app.BaseActivity.r = true;
        if (!this.a.c) {}
      }
    }
    try
    {
      paramList = new Intent(this.a, ContactSyncJumpActivity.class);
      paramList.putExtra("key_req_from_lock_screen", true);
      paramList.putExtra("key_orginal_intent", this.a.getIntent().getParcelableExtra("key_orginal_intent"));
      this.a.startActivity(paramList);
      label139:
      this.a.moveTaskToBack(true);
      for (;;)
      {
        this.a.finish();
        GesturePWDUtils.setGestureLocking(this.a, false);
        if ((this.a.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.a.f)))
        {
          paramList = JumpParser.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), this.a.f);
          paramList.b(this.a.g);
          paramList.b();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.gesturelock.unlock", 2, "unlock success.");
        }
        this.a.jdField_b_of_type_Int = 5;
        return;
        this.a.setResult(-1);
      }
      this.a.a.setDisplayMode(LockPatternView.DisplayMode.Wrong);
      paramList = this.a;
      paramList.jdField_b_of_type_Int -= 1;
      if (this.a.jdField_b_of_type_Int > 0)
      {
        this.a.a();
        return;
      }
      this.a.b();
      return;
      this.a.a(1, this.a.getString(2131563296));
      this.a.a.setDisplayMode(LockPatternView.DisplayMode.Wrong);
      paramList = this.a;
      paramList.jdField_b_of_type_Int -= 1;
      if (this.a.jdField_b_of_type_Int > 0)
      {
        this.a.a();
        return;
      }
      this.a.b();
      return;
    }
    catch (Throwable paramList)
    {
      break label139;
    }
  }
  
  public void b() {}
  
  public void b(List paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cvj
 * JD-Core Version:    0.7.0.1
 */