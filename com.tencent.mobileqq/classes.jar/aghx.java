import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.binhai.BinHaiObserver;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aghx
  extends BinHaiObserver
{
  public aghx(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.a.post(new aghy(this, paramInt, paramString));
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (paramBoolean) {
      if (paramInt2 == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, "binhai_totalClick=" + ScanTorchActivity.b(this.a));
        }
        this.a.b.reportClickEvent("dc00898", "", this.a.b.getCurrentAccountUin(), "0X8008389", "0X8008389", 0, 0, String.valueOf(ScanTorchActivity.b(this.a)), "", ScanTorchActivity.c(this.a), "");
        ScanTorchActivity.u(this.a);
        ScanTorchActivity.a(this.a, 3, 1, "");
      }
    }
    while ((!ScanTorchActivity.o(this.a)) || (ScanTorchActivity.a(this.a) == null))
    {
      this.a.a.post(new agie(this));
      do
      {
        return;
      } while ((!ScanTorchActivity.o(this.a)) || (ScanTorchActivity.a(this.a) == null));
      ScanTorchActivity.a(this.a, 2, paramInt3, "");
      ScanTorchActivity.g(this.a, paramLong);
      if (ScanTorchActivity.b(this.a) < 1000L) {
        ScanTorchActivity.g(this.a, 1000L);
      }
      this.a.a.removeMessages(337);
      this.a.a.sendEmptyMessageDelayed(337, ScanTorchActivity.b(this.a));
      return;
    }
    this.a.a.removeMessages(337);
    this.a.a.sendEmptyMessageDelayed(337, ScanTorchActivity.b(this.a));
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2)
  {
    this.a.a.sendEmptyMessage(307);
    if (!this.a.isResume()) {
      return;
    }
    this.a.a.post(new aghz(this, paramBoolean, paramString2, paramInt2, paramInt3, paramInt4, paramInt5, paramLong2, paramLong1, paramString1));
  }
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, boolean paramBoolean2, int paramInt2, String paramString2, ArrayList paramArrayList)
  {
    if (paramBoolean1)
    {
      ScanTorchActivity.a(this.a, paramArrayList, ScanTorchActivity.c(this.a), paramString1);
      return;
    }
    this.a.a.post(new agif(this, paramString2, paramBoolean2, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghx
 * JD-Core Version:    0.7.0.1
 */