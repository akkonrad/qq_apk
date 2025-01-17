package com.tencent.av.opengl.texture;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.opengl.config.RendererConfig;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.ui.GLVideoView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;

public class YuvFboTexture
  extends YUVTexture
{
  private static String jdField_a_of_type_JavaLangString;
  private static String b;
  private static boolean c;
  private static boolean d;
  public static int n = 480;
  private static int o = 1;
  private FrameBufferCenterTexture jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture;
  private GLVideoView jdField_a_of_type_ComTencentAvUiGLVideoView;
  
  public YuvFboTexture(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public YuvFboTexture(Context paramContext, GLVideoView paramGLVideoView, String paramString)
  {
    super(paramContext, paramString);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView = paramGLVideoView;
  }
  
  private static void a(Context paramContext)
  {
    int i = 0;
    if (c) {}
    for (;;)
    {
      return;
      c = true;
      if (jdField_a_of_type_JavaLangString == null) {
        jdField_a_of_type_JavaLangString = DeviceInfoUtil.d();
      }
      paramContext = RendererConfig.a();
      d = false;
      if ((paramContext == null) || (paramContext.jdField_a_of_type_Int != 1)) {
        continue;
      }
      n = paramContext.b;
      o = paramContext.c;
      jdField_b_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
      try
      {
        if ((TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))) {
          continue;
        }
        paramContext = jdField_b_of_type_JavaLangString.split("\\.");
        String[] arrayOfString = jdField_a_of_type_JavaLangString.split("\\.");
        while ((i < 3) && (i < paramContext.length) && (i < arrayOfString.length))
        {
          if (Integer.valueOf(arrayOfString[i]).intValue() > Integer.valueOf(paramContext[i]).intValue())
          {
            d = true;
            return;
          }
          if (Integer.valueOf(arrayOfString[i]).intValue() < Integer.valueOf(paramContext[i]).intValue())
          {
            d = false;
            return;
          }
          if (i == 2) {
            d = true;
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    if (a() > b())
    {
      i = a();
      a(this.jdField_a_of_type_AndroidContentContext);
      if ((!d) || (getImgWidth() > n) || (i <= ((GLES20Canvas)paramGLCanvas).c() / 3 * 2) || (getImgWidth() >= i) || (getImgWidth() == 0) || (this.jdField_a_of_type_ComTencentAvUiGLVideoView.a().size() != 0) || (VideoController.a().a().d != 2)) {
        break label211;
      }
    }
    label211:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture == null) {
          this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture = FrameBufferCenterTexture.a();
        }
        super.a(paramGLCanvas);
        if (super.a() != null) {
          this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture.a(paramGLCanvas, getImgWidth(), getImgHeight(), ((GLES20Canvas)paramGLCanvas).c(), ((GLES20Canvas)paramGLCanvas).d(), a()[0], a()[1], a()[2], this.jdField_b_of_type_ArrayOfFloat, this.k, o);
        }
        return TextureProgramFactory.a(0).a();
        i = b();
        break;
      }
      return super.a(paramGLCanvas);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture != null) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture.a();
    }
    c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YuvFboTexture
 * JD-Core Version:    0.7.0.1
 */