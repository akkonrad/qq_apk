import android.os.Handler.Callback;
import android.os.Message;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public final class amqx
  extends WtloginObserver
{
  public amqx(Handler.Callback paramCallback) {}
  
  public void OnException(String paramString, int paramInt)
  {
    paramString = Message.obtain();
    paramString.what = 1001;
    if (this.a != null) {
      this.a.handleMessage(paramString);
    }
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    paramString = Message.obtain();
    paramString.what = 1000;
    if (this.a != null) {
      this.a.handleMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqx
 * JD-Core Version:    0.7.0.1
 */