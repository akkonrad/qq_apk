import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class acoy
  extends FMObserver
{
  public acoy(VerifyPwdView paramVerifyPwdView) {}
  
  protected void a(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      VerifyPwdView.a(this.a);
      return;
    }
    VerifyPwdView.b(this.a);
  }
  
  protected void b(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
    VerifyPwdView.c(this.a);
  }
  
  protected void e()
  {
    VerifyPwdView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acoy
 * JD-Core Version:    0.7.0.1
 */