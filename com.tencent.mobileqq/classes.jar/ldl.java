import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar.Tab;
import com.tencent.qphone.base.util.QLog;

public class ldl
  extends ReadInJoyObserver
{
  public ldl(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onGetFollowAndFansResultAndForbidden retCode:" + paramInt1 + ", followCnt:" + paramInt2 + ", fansCnt:" + paramInt3 + ", isForbidden" + paramBoolean);
    }
    if (paramInt1 == 0)
    {
      ReadInJoyBaseFragment localReadInJoyBaseFragment = ReadInJoyNewFeedsActivity.a(this.a).a(ReadInJoyNewFeedsActivity.a(this.a)).a();
      if ((localReadInJoyBaseFragment != null) && ((localReadInJoyBaseFragment instanceof ReadInJoySelfFragment))) {
        ((ReadInJoySelfFragment)localReadInJoyBaseFragment).a(paramInt2, paramInt3, paramBoolean);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onComponentLastReadShow");
    }
    this.a.runOnUiThread(new ldm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldl
 * JD-Core Version:    0.7.0.1
 */