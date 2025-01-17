package dov.com.qq.im.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class BoldTextItem
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private float jdField_b_of_type_Float;
  private StaticLayout jdField_b_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
  
  public BoldTextItem(int paramInt, @NonNull List paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    if (paramTypeface != null)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
      this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(22.0F, BaseApplicationImpl.getContext().getResources()));
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
      this.jdField_b_of_type_AndroidTextTextPaint.setStrokeJoin(Paint.Join.ROUND);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(22.0F, BaseApplicationImpl.getContext().getResources()));
      this.jdField_b_of_type_AndroidTextTextPaint.setColor(-16777216);
      this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(AIOUtils.a(6.0F, BaseApplicationImpl.getContext().getResources()));
      if (!paramList.isEmpty()) {
        a(0, (String)paramList.get(0));
      }
      return;
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
      this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    paramInt = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("最多十个字最多十个字");
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
    this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_b_of_type_AndroidTextTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
    this.jdField_a_of_type_Float = a(this.jdField_a_of_type_AndroidTextStaticLayout);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null)
    {
      paramCanvas.save();
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.right = a(this.jdField_a_of_type_AndroidTextStaticLayout);
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      paramCanvas.restore();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.BoldTextItem
 * JD-Core Version:    0.7.0.1
 */