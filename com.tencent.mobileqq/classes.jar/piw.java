import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.photogif.NewAnimationDrawable;
import com.tencent.component.media.utils.LruCache;

public class piw
  extends LruCache
{
  public piw(NewAnimationDrawable paramNewAnimationDrawable, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, BitmapReference paramBitmapReference)
  {
    return paramBitmapReference.getAllocSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     piw
 * JD-Core Version:    0.7.0.1
 */