import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.ImageDrawable;

public final class phx
  extends Drawable.ConstantState
{
  public int a;
  public Paint a;
  public BitmapReference a;
  public int b;
  public int c;
  public int d = 160;
  
  public phx(BitmapReference paramBitmapReference, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference = paramBitmapReference;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  }
  
  public phx(phx paramphx)
  {
    this(paramphx.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference, paramphx.jdField_a_of_type_Int, paramphx.b);
    this.c = paramphx.c;
    this.d = paramphx.d;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(paramphx.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getChangingConfigurations()
  {
    return this.c;
  }
  
  public Drawable newDrawable()
  {
    return new ImageDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ImageDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     phx
 * JD-Core Version:    0.7.0.1
 */