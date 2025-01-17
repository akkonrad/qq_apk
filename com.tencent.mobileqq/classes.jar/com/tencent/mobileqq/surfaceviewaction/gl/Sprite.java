package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Sprite
  extends Node
{
  protected Texture a;
  protected FloatBuffer a;
  protected ShortBuffer a;
  protected final float[] a;
  protected final short[] a;
  protected FloatBuffer b;
  protected float[] b;
  private final float[] c;
  
  public Sprite()
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F };
    this.jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 3, 4, 5 };
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    f();
  }
  
  public Sprite(SpriteGLView paramSpriteGLView)
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F };
    this.jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 3, 4, 5 };
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    f();
  }
  
  public Sprite(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F };
    this.jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 3, 4, 5 };
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(paramSpriteGLView, paramBitmap);
    g();
    f();
  }
  
  public Texture a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_c_of_type_Float = paramFloat1;
    this.d = paramFloat2;
  }
  
  public void a(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, paramBitmap);
    g();
  }
  
  public void a(Texture paramTexture)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = paramTexture;
    g();
  }
  
  public int b()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.b();
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
    }
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return (int)this.jdField_a_of_type_Float;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) {
      GLES20.glUseProgram(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.c);
    }
    GLES20.glBindTexture(3553, b());
    GLES20.glEnableVertexAttribArray(paramInt3);
    GLES20.glVertexAttribPointer(paramInt3, 3, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(paramInt4);
    GLES20.glVertexAttribPointer(paramInt4, 2, 5126, false, 0, this.jdField_b_of_type_JavaNioFloatBuffer);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, -1.0E-004F);
    Object localObject = a();
    float f2 = paramInt1 / paramInt2;
    float f3 = paramInt1 / this.jdField_a_of_type_Float / (this.e * a());
    float f4 = (2.0F * ((Point)localObject).jdField_a_of_type_Float * a() - paramInt1) / paramInt2;
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b)) {
      f1 = -paramInt2;
    }
    for (float f1 = (((Point)localObject).jdField_b_of_type_Float * 2.0F * a() + f1) / paramInt2;; f1 = (paramInt2 - ((Point)localObject).jdField_b_of_type_Float * 2.0F * a()) / paramInt2)
    {
      Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, f4, f1, 0.0F);
      Matrix.rotateM(this.jdField_b_of_type_ArrayOfFloat, 0, -this.f, 0.0F, 0.0F, 1.0F);
      Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, f2 / f3, f2 / f3 * (this.jdField_b_of_type_Float / this.jdField_a_of_type_Float), 1.0F);
      localObject = new float[16];
      Matrix.multiplyMM((float[])localObject, 0, paramArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
      GLES20.glUniformMatrix4fv(paramInt5, 1, false, (float[])localObject, 0);
      GLES20.glUniform1i(paramInt6, 0);
      GLES20.glUniform1f(paramInt7, this.jdField_b_of_type_Int * e_() / 255.0F / 255.0F);
      GLES20.glDrawElements(4, this.jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
      GLES20.glDisableVertexAttribArray(paramInt3);
      GLES20.glDisableVertexAttribArray(paramInt4);
      return;
    }
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return (int)this.jdField_b_of_type_Float;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_c_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.jdField_c_of_type_ArrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    this.jdField_a_of_type_JavaNioShortBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfShort.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(this.jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
    this.jdField_b_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return;
    }
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Sprite
 * JD-Core Version:    0.7.0.1
 */