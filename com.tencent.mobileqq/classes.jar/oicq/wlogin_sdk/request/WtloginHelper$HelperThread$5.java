package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t17b;
import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$5
  implements Runnable
{
  WtloginHelper$HelperThread$5(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    async_context localasync_context = t.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localasync_context._last_err_msg;
    int i = localasync_context._t17b.get_available_msg_cnt();
    int j = localasync_context._t17b.get_time_limit();
    WtloginHelper.access$100(this.this$1.mHelper).OnRefreshSMSData(this.this$1.mUserAccount, this.this$1.mSmsAppid, this.this$1.mUserSigInfo, i, j, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.5
 * JD-Core Version:    0.7.0.1
 */