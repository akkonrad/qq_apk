import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.GroundDrawable;

public class aodz
  extends Property
{
  public aodz(GroundDrawable paramGroundDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(GroundDrawable paramGroundDrawable)
  {
    return Float.valueOf(GroundDrawable.c(paramGroundDrawable));
  }
  
  public void a(GroundDrawable paramGroundDrawable, Float paramFloat)
  {
    GroundDrawable.b(paramGroundDrawable, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aodz
 * JD-Core Version:    0.7.0.1
 */