package com.tencent.biz.qqstory.newshare.callback;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class OnSimpleShareListener
  implements OnShareListener
{
  public void a() {}
  
  public void a(int paramInt)
  {
    if (paramInt == 6) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131438798, 0).a();
    }
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void c() {}
  
  public void c(int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), "分享失败，请稍后重试", 0).a();
  }
  
  public void d() {}
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener
 * JD-Core Version:    0.7.0.1
 */