package com.tencent.av.opengl.glrenderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.av.opengl.program.DrawProgram;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

@TargetApi(8)
public class GLES20Canvas
  implements GLCanvas
{
  private static final GLId jdField_a_of_type_ComTencentAvOpenglGlrendererGLId = new GLES20Id();
  private static final float[] jdField_b_of_type_ArrayOfFloat = { -0.5F, -0.5F, 0.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private float jdField_a_of_type_Float = 3.0F;
  private int jdField_a_of_type_Int;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private DrawProgram jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram;
  private IntArray jdField_a_of_type_ComTencentAvOpenglUtilsIntArray = new IntArray();
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(12);
  float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private final int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private float[][] jdField_a_of_type_Array2dOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 16 });
  private float jdField_b_of_type_Float = 180.0F;
  private int jdField_b_of_type_Int;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private final IntArray jdField_b_of_type_ComTencentAvOpenglUtilsIntArray = new IntArray();
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private final IntArray jdField_c_of_type_ComTencentAvOpenglUtilsIntArray = new IntArray();
  private float[] jdField_c_of_type_ArrayOfFloat = new float[8];
  private int jdField_d_of_type_Int;
  private float[] jdField_d_of_type_ArrayOfFloat = new float[16];
  private int jdField_e_of_type_Int;
  private float[] jdField_e_of_type_ArrayOfFloat = new float[16];
  private int jdField_f_of_type_Int = -1;
  private float[] jdField_f_of_type_ArrayOfFloat;
  private int jdField_g_of_type_Int;
  private final float[] jdField_g_of_type_ArrayOfFloat = new float[32];
  private int jdField_h_of_type_Int;
  private final float[] jdField_h_of_type_ArrayOfFloat = new float[4];
  private int jdField_i_of_type_Int;
  private final float[] jdField_i_of_type_ArrayOfFloat = new float[16];
  
  public GLES20Canvas()
  {
    Matrix.setIdentityM(this.jdField_i_of_type_ArrayOfFloat, 0);
    this.jdField_c_of_type_ArrayOfFloat[this.jdField_a_of_type_Int] = 1.0F;
    this.jdField_e_of_type_Int = a(a(jdField_b_of_type_ArrayOfFloat));
    this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram = new DrawProgram();
    GLES20.glBlendFunc(1, 771);
    Utils.a();
  }
  
  private int a(Buffer paramBuffer, int paramInt)
  {
    jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.a(1, this.jdField_a_of_type_ArrayOfInt, 0);
    Utils.a();
    int j = this.jdField_a_of_type_ArrayOfInt[0];
    GLES20.glBindBuffer(34962, j);
    Utils.a();
    GLES20.glBufferData(34962, paramBuffer.capacity() * paramInt, paramBuffer, 35044);
    Utils.a();
    return j;
  }
  
  private static FloatBuffer a(float[] paramArrayOfFloat)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat, 0, paramArrayOfFloat.length).position(0);
    return localFloatBuffer;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix.frustumM(this.jdField_d_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat)
  {
    GLES20.glUseProgram(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a());
    Utils.a();
    if (paramFloat > 0.0F)
    {
      GLES20.glLineWidth(paramFloat);
      Utils.a();
    }
    float[] arrayOfFloat = a(paramInt2);
    if (arrayOfFloat[3] < 1.0F) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      if (bool)
      {
        GLES20.glBlendColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
        Utils.a();
      }
      GLES20.glUniform4fv(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a()[2].jdField_a_of_type_Int, 1, arrayOfFloat, 0);
      a(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a(), paramInt1);
      Utils.a();
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, float paramFloat5)
  {
    a(paramInt2, paramInt4, paramFloat5);
    a(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a(), paramInt1, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    a(paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGLPaint.a(), paramGLPaint.a());
  }
  
  private void a(RectF paramRectF)
  {
    this.jdField_i_of_type_ArrayOfFloat[0] = paramRectF.width();
    this.jdField_i_of_type_ArrayOfFloat[5] = paramRectF.height();
    this.jdField_i_of_type_ArrayOfFloat[12] = paramRectF.left;
    this.jdField_i_of_type_ArrayOfFloat[13] = paramRectF.top;
  }
  
  private static void a(RectF paramRectF, BasicTexture paramBasicTexture)
  {
    int j = paramBasicTexture.e();
    int k = paramBasicTexture.f();
    paramRectF.left /= j;
    paramRectF.right /= j;
    paramRectF.top /= k;
    paramRectF.bottom /= k;
  }
  
  private void a(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    a(paramRectF1);
    a(paramBasicTexture, this.jdField_i_of_type_ArrayOfFloat, paramRectF2);
  }
  
  private void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, RectF paramRectF)
  {
    ShaderParameter[] arrayOfShaderParameter = paramBasicTexture.a(this);
    a(arrayOfShaderParameter, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].jdField_a_of_type_Int, 1, false, paramArrayOfFloat, 0);
    Utils.a();
    if (paramBasicTexture.a())
    {
      a(2);
      a(0.0F, paramRectF.centerY());
      b(1.0F, -1.0F, 1.0F);
      a(0.0F, -paramRectF.centerY());
    }
    a(arrayOfShaderParameter, 5, 4, paramRectF.left, paramRectF.top, paramRectF.width(), paramRectF.height());
    if (paramBasicTexture.a()) {
      c();
    }
    this.jdField_g_of_type_Int += 1;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      Utils.a();
      return;
    }
    GLES20.glDisable(3042);
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    f();
    a(paramFloat1, paramFloat2, 0.0F);
    b(paramFloat3, paramFloat4, 1.0F);
    GLES20.glUniformMatrix4fv(paramArrayOfShaderParameter[1].jdField_a_of_type_Int, 1, false, a(), 0);
    g();
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, int paramInt)
  {
    GLES20.glBindBuffer(34962, this.jdField_e_of_type_Int);
    Utils.a();
    GLES20.glVertexAttribPointer(paramArrayOfShaderParameter[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramInt * 8);
    Utils.a();
    GLES20.glBindBuffer(34962, 0);
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramArrayOfShaderParameter, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    int j = paramArrayOfShaderParameter[0].jdField_a_of_type_Int;
    if (!QavVideoRecordUICtrl.b) {
      GLES20.glBindFramebuffer(36160, 0);
    }
    GLES20.glEnableVertexAttribArray(j);
    Utils.a();
    GLES20.glDrawArrays(paramInt1, 0, paramInt2);
    Utils.a();
    GLES20.glDisableVertexAttribArray(j);
    Utils.a();
  }
  
  private float[] a()
  {
    Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_e_of_type_ArrayOfFloat, 0, this.jdField_f_of_type_ArrayOfFloat, 0);
    Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_d_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  private float[] a(int paramInt)
  {
    float f1 = (paramInt >>> 24 & 0xFF) / 255.0F * a();
    float f2 = (paramInt >>> 16 & 0xFF) / 255.0F;
    float f3 = (paramInt >>> 8 & 0xFF) / 255.0F;
    float f4 = (paramInt & 0xFF) / 255.0F;
    this.jdField_h_of_type_ArrayOfFloat[0] = (f2 * f1);
    this.jdField_h_of_type_ArrayOfFloat[1] = (f3 * f1);
    this.jdField_h_of_type_ArrayOfFloat[2] = (f4 * f1);
    this.jdField_h_of_type_ArrayOfFloat[3] = f1;
    return this.jdField_h_of_type_ArrayOfFloat;
  }
  
  public float a()
  {
    return this.jdField_c_of_type_ArrayOfFloat[this.jdField_a_of_type_Int];
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(FloatBuffer paramFloatBuffer)
  {
    return a(paramFloatBuffer, 4);
  }
  
  public GLId a()
  {
    return jdField_a_of_type_ComTencentAvOpenglGlrendererGLId;
  }
  
  public void a()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Utils.a();
    GLES20.glClear(16384);
    Utils.a();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_ArrayOfFloat[this.jdField_a_of_type_Int] = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, 0.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.jdField_f_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix.rotateM(this.jdField_f_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.jdField_c_of_type_Float = paramFloat3;
    Matrix.setLookAtM(this.jdField_e_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    a(5, 0, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 0.0F);
    this.jdField_h_of_type_Int += 1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    a(3, 4, 2, paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, paramGLPaint);
    this.jdField_i_of_type_Int += 1;
  }
  
  @TargetApi(9)
  public void a(int paramInt)
  {
    int k = 0;
    int j;
    float f1;
    if ((paramInt & 0x1) == 1)
    {
      j = 1;
      if (j != 0)
      {
        f1 = a();
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_c_of_type_ArrayOfFloat.length <= this.jdField_a_of_type_Int) {
          if (Build.VERSION.SDK_INT < 9) {
            break label113;
          }
        }
      }
    }
    label113:
    float[] arrayOfFloat;
    for (this.jdField_c_of_type_ArrayOfFloat = Arrays.copyOf(this.jdField_c_of_type_ArrayOfFloat, this.jdField_c_of_type_ArrayOfFloat.length * 2);; this.jdField_c_of_type_ArrayOfFloat = arrayOfFloat)
    {
      this.jdField_c_of_type_ArrayOfFloat[this.jdField_a_of_type_Int] = f1;
      j = k;
      if ((paramInt & 0x2) == 2) {
        j = 1;
      }
      if (j != 0) {
        f();
      }
      this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray.a(paramInt);
      return;
      j = 0;
      break;
      arrayOfFloat = new float[this.jdField_c_of_type_ArrayOfFloat.length * 2];
      j = 0;
      while (j < this.jdField_c_of_type_ArrayOfFloat.length)
      {
        arrayOfFloat[j] = this.jdField_c_of_type_ArrayOfFloat[j];
        j += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    e();
    a(-paramInt1 / 4, paramInt1 / 4, -paramInt2 / 4, paramInt2 / 4, paramInt2, 1000000.0F);
    a(0.0F, 0.0F, paramInt2 * 2, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    a(0.0F, paramInt2 / 2, 0.0F);
    b(1.0F, -1.0F, 1.0F);
    a(-paramInt1 / 2, 0.0F, 0.0F);
    Utils.a();
  }
  
  public void a(BasicTexture paramBasicTexture)
  {
    int k = paramBasicTexture.g();
    int[] arrayOfInt = paramBasicTexture.a();
    int j = 0;
    while (j < arrayOfInt.length)
    {
      GLES20.glBindTexture(k, paramBasicTexture.a()[j]);
      j += 1;
    }
    Utils.a();
    GLES20.glTexParameteri(k, 10242, 33071);
    GLES20.glTexParameteri(k, 10243, 33071);
    GLES20.glTexParameterf(k, 10241, 9729.0F);
    GLES20.glTexParameterf(k, 10240, 9729.0F);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2)
  {
    int k = paramBasicTexture.g();
    int[] arrayOfInt = paramBasicTexture.a();
    int j = 0;
    while (j < arrayOfInt.length)
    {
      GLES20.glBindTexture(k, paramBasicTexture.a()[j]);
      j += 1;
    }
    Utils.a();
    GLES20.glTexImage2D(k, 0, paramInt1, paramBasicTexture.e(), paramBasicTexture.f(), 0, paramInt1, paramInt2, null);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    Rect localRect = paramBasicTexture.a();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    a(this.jdField_a_of_type_AndroidGraphicsRectF, paramBasicTexture);
    a(paramBasicTexture, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    int k = paramBasicTexture.g();
    int[] arrayOfInt = paramBasicTexture.a();
    int j = 0;
    while (j < arrayOfInt.length)
    {
      GLES20.glBindTexture(k, paramBasicTexture.a()[j]);
      j += 1;
    }
    Utils.a();
    GLUtils.texSubImage2D(k, 0, paramInt1, paramInt2, paramBitmap, paramInt3, paramInt4);
  }
  
  public void a(BasicTexture paramBasicTexture, Bitmap paramBitmap)
  {
    int k = paramBasicTexture.g();
    int[] arrayOfInt = paramBasicTexture.a();
    int j = 0;
    while (j < arrayOfInt.length)
    {
      GLES20.glBindTexture(k, paramBasicTexture.a()[j]);
      j += 1;
    }
    Utils.a();
    GLUtils.texImage2D(k, 0, paramBitmap, 0);
  }
  
  public void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    a(paramBasicTexture, paramArrayOfFloat, this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public boolean a(BasicTexture paramBasicTexture)
  {
    boolean bool = paramBasicTexture.c();
    if (bool) {}
    for (;;)
    {
      synchronized (this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray)
      {
        paramBasicTexture = paramBasicTexture.a();
        if (paramBasicTexture != null) {
          break label68;
        }
        return bool;
        if (j < paramBasicTexture.length)
        {
          this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray.a(paramBasicTexture[j]);
          j += 1;
          continue;
        }
        return bool;
      }
      return bool;
      label68:
      int j = 0;
    }
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void b()
  {
    a(-1);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.jdField_f_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c()
  {
    int k = 1;
    int m = this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray.a();
    if ((m & 0x1) == 1)
    {
      j = 1;
      if (j != 0) {
        this.jdField_a_of_type_Int -= 1;
      }
      if ((m & 0x2) != 2) {
        break label67;
      }
    }
    label67:
    for (int j = k;; j = 0)
    {
      if (j != 0)
      {
        this.jdField_b_of_type_Int -= 16;
        g();
      }
      return;
      j = 0;
      break;
    }
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void d()
  {
    synchronized (this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray)
    {
      IntArray localIntArray2 = this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray;
      if (this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray.b() > 0)
      {
        jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.a(null, localIntArray2.b(), localIntArray2.a(), 0);
        localIntArray2.a();
      }
      localIntArray2 = this.jdField_c_of_type_ComTencentAvOpenglUtilsIntArray;
      if (localIntArray2.b() > 0)
      {
        jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.b(null, localIntArray2.b(), localIntArray2.a(), 0);
        localIntArray2.a();
      }
      return;
    }
  }
  
  public void e()
  {
    this.jdField_f_of_type_ArrayOfFloat = new float[16];
    Matrix.setRotateM(this.jdField_f_of_type_ArrayOfFloat, 0, 0.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void f()
  {
    this.jdField_f_of_type_Int += 1;
    int j = 0;
    while (j < 16)
    {
      this.jdField_a_of_type_Array2dOfFloat[this.jdField_f_of_type_Int][j] = this.jdField_f_of_type_ArrayOfFloat[j];
      j += 1;
    }
  }
  
  public void g()
  {
    int j = 0;
    while (j < 16)
    {
      this.jdField_f_of_type_ArrayOfFloat[j] = this.jdField_a_of_type_Array2dOfFloat[this.jdField_f_of_type_Int][j];
      j += 1;
    }
    this.jdField_f_of_type_Int -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.glrenderer.GLES20Canvas
 * JD-Core Version:    0.7.0.1
 */