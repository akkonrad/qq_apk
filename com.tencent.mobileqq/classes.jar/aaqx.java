import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aaqx
  extends ArkAppCGI.ArkAppCGICallback
{
  public aaqx(ArkActionAppMgr paramArkActionAppMgr, WeakReference paramWeakReference, QQAppInterface paramQQAppInterface) {}
  
  public void a(boolean paramBoolean, Object paramObject, ArrayList paramArrayList)
  {
    ThreadManager.post(new aaqy(this, paramArrayList), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqx
 * JD-Core Version:    0.7.0.1
 */