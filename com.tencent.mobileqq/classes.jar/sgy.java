import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class sgy
  extends TroopObserver
{
  public sgy(Conversation paramConversation) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0)
      {
        TroopAssistantManager.a().c(this.a.a);
        this.a.a(8, paramString, 1);
        this.a.a(8, AppConstants.B, 5000);
        this.a.a(8, AppConstants.aC, 5001);
      }
    }
    while ((paramInt1 != 2) || (paramInt2 != 0)) {
      return;
    }
    TroopAssistantManager.a().b(paramString, this.a.a);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_ontroopmanagersuccess");
    }
    this.a.a(8, paramString, 1);
    this.a.a(8, AppConstants.B, 5000);
    this.a.a(8, AppConstants.aC, 5001);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, 1);
  }
  
  protected void a(boolean paramBoolean)
  {
    TroopAssistantManager.a().c(this.a.a);
  }
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.a.a(8, AppConstants.B, 5000);
      this.a.a(8, AppConstants.aC, 5001);
      if (paramTroopInfo != null) {
        this.a.a(8, paramTroopInfo.troopuin, 1);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.a(8, paramString, 1);
      this.a.a(8, AppConstants.B, 5000);
      this.a.a(8, AppConstants.aC, 5001);
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (TroopMemberCardInfo)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        this.a.a(8, paramArrayList.troopuin, 1);
        this.a.a(8, paramArrayList.memberuin, -2147483648);
        this.a.a(8, AppConstants.B, 5000);
        this.a.a(8, AppConstants.aC, 5001);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation.onGetTroopMemberCard isSuccess=" + paramBoolean + " data=" + paramObject);
    }
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      this.a.a(8, String.valueOf(l), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgy
 * JD-Core Version:    0.7.0.1
 */