package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class KeyingBase
{
  public static final float[] a;
  public float a;
  public CylinderSide a;
  public FrameBuffer a;
  public KeyingBase.UserInterface a;
  public Plane a;
  public String a;
  private boolean a;
  public short[] a;
  public float b;
  public String b;
  public float[] b;
  public float c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public int n = -1;
  public int o = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  public KeyingBase(int paramInt)
  {
    this.jdField_c_of_type_JavaLangString = "//宏定义";
    this.jdField_d_of_type_JavaLangString = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES samplerOES;\nuniform sampler2D sampler2d1;\nuniform sampler2D sampler2d2;\nuniform sampler2D sampler2d3;\nuniform vec4 u_screenColor;\nvarying vec2 vTextureCoord;\n";
    this.jdField_e_of_type_JavaLangString = "//抠像算法相关定义片段\n";
    this.jdField_f_of_type_JavaLangString = "//用户自己定义变量及方法相关片段\n";
    this.jdField_g_of_type_JavaLangString = "void main() {\n    vec2 position = vTextureCoord;\n";
    this.jdField_h_of_type_JavaLangString = "    //用户定义片段，用于在获取颜色值前处理, 如纹理坐标改变\n";
    this.jdField_i_of_type_JavaLangString = "    gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n    #if defined(TEXTURE_TYPE_OES)\n        gl_FragColor = texture2D(samplerOES, position);\n    #endif\n    #if defined(TEXTURE_TYPE_SAMPLER2D)\n        gl_FragColor = texture2D(sampler2d1, position);\n    #endif\n    #if defined(TEXTURE_TYPE_Y_U_V)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        yuv.y = texture2D(sampler2d2, position).r-0.5;\n        yuv.z = texture2D(sampler2d3, position).r-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;\n        gl_FragColor.a = 1.0;\n    #endif\n    #if defined(TEXTURE_TYPE_Y_UV)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        vec2 uv = texture2D(sampler2d2, position).ra;\n        yuv.y = uv.x-0.5;\n        yuv.z = uv.y-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;//yuv->rgb\n        gl_FragColor.a = 1.0;\n    #endif\n";
    this.jdField_j_of_type_JavaLangString = KeyingUtil.jdField_a_of_type_JavaLangString;
    this.jdField_k_of_type_JavaLangString = KeyingUtil.jdField_b_of_type_JavaLangString;
    this.jdField_l_of_type_JavaLangString = KeyingUtil.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = "precision mediump float;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n   gl_Position = uMVPMatrix * aPosition;\n   vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}";
    this.o = paramInt;
  }
  
  private final int a(KeyingParams paramKeyingParams, boolean paramBoolean)
  {
    int i1 = 0;
    a(paramKeyingParams);
    if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface.a();
    }
    if (this.n == 1) {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingCylinderSide.a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    for (;;)
    {
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      KeyingUtil.a("keyingHandleAfter");
      if (paramBoolean) {
        i1 = this.jdField_a_of_type_ComTencentMobileqqArKeyingFrameBuffer.a();
      }
      return i1;
      this.jdField_a_of_type_ComTencentMobileqqArKeyingPlane.a();
    }
  }
  
  private final void a(KeyingParams paramKeyingParams, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(-1, 0.0F, 0.0F, 0.0F);
    }
    GLES20.glUseProgram(this.jdField_d_of_type_Int);
    KeyingUtil.a("glUseProgram");
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingFrameBuffer.a(paramInt1, paramInt2);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
    }
    if (this.n == 1) {}
    for (;;)
    {
      GLES20.glUniformMatrix4fv(this.jdField_g_of_type_Int, 1, false, paramArrayOfFloat1, 0);
      GLES20.glUniformMatrix4fv(this.jdField_h_of_type_Int, 1, false, paramArrayOfFloat2, 0);
      if (this.m != -1) {
        GLES20.glUniform4f(this.m, paramKeyingParams.jdField_a_of_type_Float, paramKeyingParams.jdField_b_of_type_Float, paramKeyingParams.jdField_c_of_type_Float, 1.0F);
      }
      KeyingUtil.a("keyingHandleBefore");
      return;
      this.jdField_a_of_type_ComTencentMobileqqArKeyingPlane.a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
  }
  
  public final int a(int[] paramArrayOfInt, KeyingParams paramKeyingParams, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return a(paramArrayOfInt, paramKeyingParams, paramArrayOfFloat1, paramArrayOfFloat2, false, 0, 0);
  }
  
  public final int a(int[] paramArrayOfInt, KeyingParams paramKeyingParams, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null) {
      throw new IllegalArgumentException("textureIds can not be null!");
    }
    a(paramKeyingParams, paramArrayOfFloat1, paramArrayOfFloat2, paramBoolean, paramInt1, paramInt2);
    switch (this.o)
    {
    }
    for (;;)
    {
      KeyingUtil.a("keyingTexture");
      return a(paramKeyingParams, paramBoolean);
      if (paramArrayOfInt.length < 1) {
        throw new IllegalArgumentException("textureIds.size should >= 1!");
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramArrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.jdField_i_of_type_Int, 0);
      continue;
      if (paramArrayOfInt.length < 1) {
        throw new IllegalArgumentException("textureIds.size should >= 1!");
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramArrayOfInt[0]);
      GLES20.glTexParameterf(36197, 10241, 9728.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameteri(36197, 10242, 33071);
      GLES20.glTexParameteri(36197, 10243, 33071);
      GLES20.glUniform1i(this.jdField_l_of_type_Int, 0);
      continue;
      if (paramArrayOfInt.length < 2) {
        throw new IllegalArgumentException("textureIds.size should >= 2!");
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramArrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.jdField_i_of_type_Int, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, paramArrayOfInt[1]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.jdField_j_of_type_Int, 1);
      if (this.o == 3)
      {
        if (paramArrayOfInt.length < 3) {
          throw new IllegalArgumentException("textureIds.size should >= 3!");
        }
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, paramArrayOfInt[2]);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glUniform1i(this.jdField_k_of_type_Int, 2);
      }
    }
  }
  
  protected String a()
  {
    this.jdField_c_of_type_JavaLangString = KeyingUtil.a(this.o);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString).append(this.jdField_d_of_type_JavaLangString).append(this.jdField_e_of_type_JavaLangString).append(this.jdField_f_of_type_JavaLangString).append(this.jdField_g_of_type_JavaLangString).append(this.jdField_h_of_type_JavaLangString).append(this.jdField_i_of_type_JavaLangString).append(this.jdField_j_of_type_JavaLangString).append(this.jdField_k_of_type_JavaLangString).append(this.jdField_l_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  protected abstract void a();
  
  public final void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    long l1 = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("mVertexShader can not be empty!");
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.n = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.jdField_b_of_type_JavaLangString = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("KeyingBase", 4, "init. markerType = " + this.n + ", markerWidth = " + this.jdField_a_of_type_Float + ", markerHeight = " + this.jdField_b_of_type_Float + ", mFragmentShader = \n" + this.jdField_b_of_type_JavaLangString);
    }
    if (this.n == 1) {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingCylinderSide = new CylinderSide(1.0F, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingFrameBuffer = new FrameBuffer();
      this.jdField_d_of_type_Int = KeyingUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      KeyingUtil.a("createProgram");
      if (this.jdField_d_of_type_Int == 0) {
        break;
      }
      this.jdField_e_of_type_Int = GLES20.glGetAttribLocation(this.jdField_d_of_type_Int, "aPosition");
      KeyingUtil.a("glGetAttribLocation aPosition");
      if (this.jdField_e_of_type_Int != -1) {
        break label303;
      }
      throw new RuntimeException("Could not get attrib location for aPosition");
      if ((this.jdField_b_of_type_ArrayOfFloat != null) && (this.jdField_a_of_type_ArrayOfShort != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArKeyingPlane = new Plane(this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfShort);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqArKeyingPlane = new Plane();
      }
    }
    label303:
    this.jdField_f_of_type_Int = GLES20.glGetAttribLocation(this.jdField_d_of_type_Int, "aTextureCoord");
    KeyingUtil.a("glGetAttribLocation aTextureCoord");
    if (this.jdField_f_of_type_Int == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    this.jdField_g_of_type_Int = GLES20.glGetUniformLocation(this.jdField_d_of_type_Int, "uMVPMatrix");
    KeyingUtil.a("glGetUniformLocation uMVPMatrix");
    this.jdField_h_of_type_Int = GLES20.glGetUniformLocation(this.jdField_d_of_type_Int, "uSTMatrix");
    KeyingUtil.a("glGetUniformLocation uSTMatrix");
    this.jdField_l_of_type_Int = GLES20.glGetUniformLocation(this.jdField_d_of_type_Int, "samplerOES");
    KeyingUtil.a("glGetUniformLocation samplerOES");
    this.jdField_i_of_type_Int = GLES20.glGetUniformLocation(this.jdField_d_of_type_Int, "sampler2d1");
    KeyingUtil.a("glGetUniformLocation sampler2d1");
    this.jdField_j_of_type_Int = GLES20.glGetUniformLocation(this.jdField_d_of_type_Int, "sampler2d2");
    KeyingUtil.a("glGetUniformLocation sampler2d2");
    this.jdField_k_of_type_Int = GLES20.glGetUniformLocation(this.jdField_d_of_type_Int, "sampler2d3");
    KeyingUtil.a("glGetUniformLocation sampler2d3");
    this.m = GLES20.glGetUniformLocation(this.jdField_d_of_type_Int, "u_screenColor");
    KeyingUtil.a("glGetUniformLocation u_screenColor");
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface.a(this.jdField_d_of_type_Int);
    }
    QLog.i("KeyingBase", 2, " init need " + (System.currentTimeMillis() - l1) + "ms");
  }
  
  protected abstract void a(KeyingParams paramKeyingParams);
  
  public void a(String paramString1, String paramString2, String paramString3, KeyingBase.UserInterface paramUserInterface)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_f_of_type_JavaLangString = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_h_of_type_JavaLangString = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      this.jdField_k_of_type_JavaLangString = paramString3;
    }
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface = paramUserInterface;
  }
  
  public void a(float[] paramArrayOfFloat, short[] paramArrayOfShort)
  {
    this.jdField_b_of_type_ArrayOfFloat = paramArrayOfFloat;
    this.jdField_a_of_type_ArrayOfShort = paramArrayOfShort;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      GLES20.glDeleteProgram(this.jdField_d_of_type_Int);
    } while (this.jdField_a_of_type_ComTencentMobileqqArKeyingFrameBuffer == null);
    this.jdField_a_of_type_ComTencentMobileqqArKeyingFrameBuffer.a();
    this.jdField_a_of_type_ComTencentMobileqqArKeyingFrameBuffer = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.KeyingBase
 * JD-Core Version:    0.7.0.1
 */