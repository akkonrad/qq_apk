import android.text.TextUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qphone.base.util.QLog;

public class jvp
  extends GAudioUIObserver
{
  public jvp(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(long paramLong, int paramInt)
  {
    QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onDestroyInviteUI, groupId[" + paramLong + "], reason[" + paramInt + "], mIsDoubleVideoMeeting[" + this.a.jdField_a_of_type_Boolean + "], mPeerUin[" + this.a.c + "], mGroupId[" + this.a.jdField_a_of_type_Long + "]");
    if (this.a.jdField_a_of_type_Boolean) {
      if (TextUtils.equals(this.a.c, String.valueOf(paramLong)))
      {
        this.a.b("onDestroyInviteUI_DoubleVideoMeeting");
        this.a.b(paramInt);
      }
    }
    while ((this.a.jdField_a_of_type_Long != paramLong) && (0L != paramLong)) {
      return;
    }
    this.a.b("onDestroyInviteUI");
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.e.equals(paramString))) {
      this.a.finish();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString + ".troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_b_of_type_Long + ", mGroupId:" + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.finish();
    }
  }
  
  protected void g(long paramLong)
  {
    this.a.b("notifyCloseAllGroupVideoInviteMsgBox");
    this.a.finish();
  }
  
  protected void h(long paramLong)
  {
    if (this.a.jdField_a_of_type_Long == paramLong)
    {
      this.a.b("notifyCloseGroupVideoInviteMsgBox");
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvp
 * JD-Core Version:    0.7.0.1
 */