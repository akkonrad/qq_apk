import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager.OnVideoCompositeListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class lym
  implements ReadInJoyVideoCompositeManager.OnVideoCompositeListener
{
  public lym(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onError: code - " + paramInt + " msg - " + paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new lyo(this));
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onSuccess: outputPath - " + paramString);
    ReadInJoyDeliverVideoActivity.b(this.a, paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new lyn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lym
 * JD-Core Version:    0.7.0.1
 */