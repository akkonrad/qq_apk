import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;

public class mra
  extends View
{
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = -16777216;
  
  public mra(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void f(int paramInt)
  {
    this.g = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      VirtualViewUtils.b(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, getWidth(), getHeight(), this.f, this.jdField_b_of_type_Int, this.c, this.d, this.e);
    }
    super.onDraw(paramCanvas);
    if (this.f > 0)
    {
      if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.g);
      VirtualViewUtils.a(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPaint, getWidth(), getHeight(), this.f, this.jdField_b_of_type_Int, this.c, this.d, this.e);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mra
 * JD-Core Version:    0.7.0.1
 */