import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

public final class aisu
  extends SimpleObserver
{
  public aisu(aisv paramaisv) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    QLog.d("tribe_publish_TakeVideoHelper", 4, "generate video manifest success.");
    this.a.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    QLog.d("tribe_publish_TakeVideoHelper", 4, "generate video manifest failed.");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisu
 * JD-Core Version:    0.7.0.1
 */