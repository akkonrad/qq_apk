import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class myb
  implements Runnable
{
  public myb(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a)) {}
    PublicAccountDataManager localPublicAccountDataManager;
    do
    {
      return;
      localPublicAccountDataManager = (PublicAccountDataManager)this.a.app.getManager(55);
    } while (localPublicAccountDataManager == null);
    PublicAccountImageCollectionMainActivity.c(this.a, localPublicAccountDataManager.a(Long.valueOf(this.a.a)));
    PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new myc(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myb
 * JD-Core Version:    0.7.0.1
 */