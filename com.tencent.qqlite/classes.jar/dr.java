import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

public class dr
  implements URLDrawable.URLDrawableListener
{
  public dr(AsyncImageView paramAsyncImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("AsyncImageView", 1, "canceled ");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("AsyncImageView", 1, "urldrawable load failed ");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.setImageDrawable(null);
    this.a.setImageDrawable(paramURLDrawable);
    QLog.d("AsyncImageView", 1, "successed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dr
 * JD-Core Version:    0.7.0.1
 */