package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import anxa;
import anxb;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;

public final class FaceLayer$FaceAndTextItem
  extends FaceLayer.FaceItem
{
  public int a;
  public Path a;
  public StaticLayout a;
  public final String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt);
    this.jdField_a_of_type_JavaLangString = "...";
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_Int = paramLayerParams.d;
    this.jdField_b_of_type_Int = paramLayerParams.jdField_c_of_type_Int;
    a(paramLayerParams.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt1);
    this.jdField_f_of_type_Int = paramInt2;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.setRepeatCount(2);
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.addUpdateListener(new anxa(this));
    localValueAnimator.addListener(new anxb(this));
    localValueAnimator.start();
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_j_of_type_Boolean))
    {
      if (this.jdField_f_of_type_Boolean) {
        paramCanvas.drawColor(Color.parseColor("#66000000"));
      }
      if ((this.jdField_f_of_type_Boolean) && (this.g))
      {
        float f1 = this.l;
        float f2 = this.jdField_j_of_type_Float;
        float f3 = this.m;
        float f4 = this.jdField_k_of_type_Float;
        float f5 = this.jdField_a_of_type_AndroidGraphicsPointF.x;
        float f6 = this.s;
        float f7 = this.jdField_a_of_type_AndroidGraphicsPointF.y;
        paramCanvas.drawLine(f2 + f1, f4 + f3, f6 + f5, this.t + f7, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.e);
      }
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this));
    DisplayUtil.a();
    paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
      paramCanvas.translate(0.0F, this.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidGraphicsRectF.height());
    paramCanvas.save();
    paramCanvas.translate(6.0F, 16.0F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, 10.0F);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.d.setAlpha(this.d);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.d);
    }
    paramCanvas.restore();
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 32);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.u, 6);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
    int i;
    if (this.jdField_j_of_type_Boolean)
    {
      paramCanvas.save();
      if (this.jdField_k_of_type_Int != 0) {
        break label483;
      }
      i = 2130842009;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a()) {
        break label515;
      }
      if (this.jdField_k_of_type_Int != 0) {
        break label491;
      }
      i = 2130842017;
    }
    label515:
    for (;;)
    {
      label406:
      int j;
      if (this.jdField_k_of_type_Int == 1)
      {
        j = 2130842007;
        label419:
        if (this.jdField_k_of_type_Int != 2) {
          break label507;
        }
      }
      label483:
      label491:
      label507:
      for (int k = 2130842014;; k = 2130842013)
      {
        DisplayUtil.a(paramCanvas, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper, this, i, j, k);
        paramCanvas.restore();
        if (this.jdField_c_of_type_Boolean) {
          DisplayUtil.b(paramCanvas, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper, this, 2130842020, 2130842020, 2130842019);
        }
        return;
        i = 2130842008;
        break;
        i = 2130842015;
        break label406;
        j = 2130842006;
        break label419;
      }
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    float f2 = this.u;
    float f1 = this.v;
    if (f2 * this.q < 200.0F) {
      f2 = 200.0F / this.q;
    }
    if (this.q * f1 < 200.0F) {
      f1 = 200.0F / this.q;
    }
    if (this.e) {
      paramCanvas.drawColor(Color.parseColor("#66000000"));
    }
    paramCanvas.save();
    paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
      paramCanvas.translate(0.0F, this.jdField_c_of_type_Int);
    }
    if ((this.e) && (this.h == 0))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = FaceLayer.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.extractAlpha(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.g, null), null, new Rect((int)-this.p, (int)-this.p, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + (int)this.p, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + (int)this.p), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.g);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidGraphicsRectF.height());
    paramCanvas.save();
    paramCanvas.translate(6.0F, 16.0F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, 10.0F);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.d.setAlpha(this.d);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.d);
      }
      paramCanvas.restore();
    }
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 32);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.u, 6);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramTroopBarPOI;
    if (paramTroopBarPOI != null)
    {
      a(paramTroopBarPOI.a());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(null);
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e(FaceLayer.jdField_a_of_type_JavaLangString, "text is empty.");
      str = "";
    }
    SLog.b(FaceLayer.jdField_a_of_type_JavaLangString, "text:" + str);
    this.jdField_c_of_type_JavaLangString = str;
    this.jdField_b_of_type_JavaLangString = str;
    int j = (int)(this.u - 12.0F);
    int i = j;
    if (j < 0)
    {
      QLog.d(FaceLayer.jdField_a_of_type_JavaLangString, 2, "faceItem setText width < 0");
      i = 0;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 2)
    {
      j = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(1);
      paramString = this.jdField_c_of_type_JavaLangString.substring(0, j);
      SLog.b(FaceLayer.jdField_a_of_type_JavaLangString, "subString : " + this.jdField_c_of_type_JavaLangString + " -> " + paramString);
      this.jdField_c_of_type_JavaLangString = paramString;
      j = this.jdField_c_of_type_JavaLangString.length();
      this.jdField_c_of_type_JavaLangString += "...";
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      j -= 1;
      while ((j > 0) && (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 2))
      {
        paramString = this.jdField_c_of_type_JavaLangString.substring(0, j) + "...";
        SLog.b(FaceLayer.jdField_a_of_type_JavaLangString, "delete last char : " + this.jdField_c_of_type_JavaLangString + " -> " + paramString);
        this.jdField_c_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        j -= 1;
      }
      if (j == 0) {
        SLog.e(FaceLayer.jdField_a_of_type_JavaLangString, "text size is too large :" + this.jdField_a_of_type_Int);
      }
    }
    SLog.b(FaceLayer.jdField_a_of_type_JavaLangString, "final text : " + this.jdField_c_of_type_JavaLangString + " , original text : " + this.jdField_b_of_type_JavaLangString);
    paramString = new Rect();
    this.jdField_a_of_type_AndroidTextStaticLayout.getLineBounds(0, paramString);
    this.jdField_c_of_type_Int = paramString.height();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, this.u, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 12), 4.0F, 4.0F, Path.Direction.CCW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem
 * JD-Core Version:    0.7.0.1
 */