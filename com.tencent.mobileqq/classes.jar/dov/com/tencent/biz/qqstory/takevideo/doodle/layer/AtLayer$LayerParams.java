package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.PointF;
import android.support.annotation.NonNull;

public class AtLayer$LayerParams
{
  public float a;
  public int a;
  public PointF a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d;
  public int d;
  public int e;
  
  public AtLayer$LayerParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(new PointF(0.0F, 0.0F), 1.0F, 0.0F, 0.0F, 0.0F, paramInt1, paramInt2, paramInt5, paramInt3, paramInt4);
  }
  
  public AtLayer$LayerParams(PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = paramPointF;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.jdField_d_of_type_Float = paramFloat4;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.e = paramInt5;
  }
  
  public static LayerParams a(@NonNull LayerParams paramLayerParams)
  {
    return new LayerParams(paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF, paramLayerParams.jdField_a_of_type_Float, paramLayerParams.jdField_b_of_type_Float, paramLayerParams.jdField_c_of_type_Float, paramLayerParams.jdField_d_of_type_Float, paramLayerParams.jdField_a_of_type_Int, paramLayerParams.jdField_b_of_type_Int, paramLayerParams.jdField_c_of_type_Int, paramLayerParams.jdField_d_of_type_Int, paramLayerParams.e);
  }
  
  public String toString()
  {
    return "LayerParams{centerP=" + this.jdField_a_of_type_AndroidGraphicsPointF + ", scale=" + this.jdField_a_of_type_Float + ", rotate=" + this.jdField_b_of_type_Float + ", translateXValue=" + this.jdField_c_of_type_Float + ", translateYValue=" + this.jdField_d_of_type_Float + ", width=" + this.jdField_a_of_type_Int + ", height=" + this.jdField_b_of_type_Int + ", textColor=" + this.jdField_d_of_type_Int + ", textSize=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer.LayerParams
 * JD-Core Version:    0.7.0.1
 */