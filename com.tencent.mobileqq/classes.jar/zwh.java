import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public final class zwh
  extends SosoInterface.OnLocationListener
{
  public zwh(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "onLocationFinish() lock.notifyAll()");
    }
    synchronized (SosoInterface.a)
    {
      SosoInterface.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwh
 * JD-Core Version:    0.7.0.1
 */