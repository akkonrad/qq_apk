import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

public final class umo
  extends TroopObserver
{
  public umo(SessionInfo paramSessionInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      QWalletHelper.saveLastUpdateToopMemberNumTime(this.a.a);
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "onOIDB0X88D_0_Ret 群uin：" + this.a.a + " 群成员个数：" + paramTroopInfo.wMemberNum);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umo
 * JD-Core Version:    0.7.0.1
 */