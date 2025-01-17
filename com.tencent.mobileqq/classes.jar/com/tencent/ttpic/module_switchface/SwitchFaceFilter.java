package com.tencent.ttpic.module_switchface;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.av.switchface.SwitchFaceProcessorItem;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.ttpic.filters.SwitchFaceFilterBase;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.SwitchFaceUtil;
import com.tencent.ttpic.util.SwitchFaceUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;

public class SwitchFaceFilter
  extends SwitchFaceFilterBase
{
  private int b;
  private int c;
  private float[] d = new float[276];
  private float[] e = new float[276];
  private float[] f = new float[276];
  
  public SwitchFaceFilter()
  {
    this("attribute vec4 position;\r\nattribute vec2 inputTextureCoordinate;\r\nattribute vec2 inputGrayTextureCoordinate;\r\nvarying vec2 canvasCoordinate;\r\nvarying vec2 textureCoordinate;\r\nvarying vec2 grayTextureCoordinate;\r\n\r\nuniform vec2 canvasSize;\r\nuniform float positionRotate;\r\n\r\nmat4 posMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\r\n                         0.0, 1.0, 0.0, 0.0,\r\n                         0.0, 0.0, 1.0, 0.0,\r\n                         0.0, 0.0, 0.0, 1.0);\r\n\r\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\r\n    /*\r\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\r\n M = |  cxsz            cxcz           -sx    0 |\r\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\r\n     |  0               0               0     1 |\r\n\r\n     where cA = cos(A), sA = sin(A) for A = x,y,z\r\n     */\r\n\r\n    float cx = cos(xRadians);\r\n    float sx = sin(xRadians);\r\n    float cy = cos(yRadians);\r\n    float sy = sin(yRadians);\r\n    float cz = cos(zRadians);\r\n    float sz = sin(zRadians);\r\n\r\n    m[0][0] = (cy * cz) + (sx * sy * sz);\r\n    m[0][1] = cx * sz;\r\n    m[0][2] = (cy * sx * sz) - (cz * sy);\r\n    m[0][3] = 0.0;\r\n\r\n    m[1][0] = (cz * sx * sy) - (cy * sz);\r\n    m[1][1] = cx * cz;\r\n    m[1][2] = (cy * cz * sx) + (sy * sz);\r\n    m[1][3] = 0.0;\r\n\r\n    m[2][0] = cx * sy;\r\n    m[2][1] = -sx;\r\n    m[2][2] = cx * cy;\r\n    m[2][3] = 0.0;\r\n\r\n    m[3][0] = 0.0;\r\n    m[3][1] = 0.0;\r\n    m[3][2] = 0.0;\r\n    m[3][3] = 1.0;\r\n\r\n    return m;\r\n}\r\n\r\nvoid main(){\r\n    vec4 framePos = position;\r\n\r\n    framePos.x = framePos.x * canvasSize.x * 0.5;\r\n    framePos.y = framePos.y * canvasSize.y * 0.5;\r\n    posMatRotate = mat4RotationYXZ(posMatRotate, 0.0, 0.0, positionRotate);\r\n    framePos = posMatRotate * framePos;\r\n    framePos.x = framePos.x * 2.0 / canvasSize.x;\r\n    framePos.y = framePos.y * 2.0 / canvasSize.y;\r\n\r\n    gl_Position = framePos;\r\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\r\n    textureCoordinate = inputTextureCoordinate;\r\n    grayTextureCoordinate = inputGrayTextureCoordinate;\r\n}", "precision mediump float;\r\nvarying vec2 canvasCoordinate;\r\nvarying vec2 textureCoordinate;\r\nvarying vec2 grayTextureCoordinate;\r\n\r\nuniform sampler2D inputImageTexture;\r\nuniform sampler2D inputImageTexture2;\r\nuniform sampler2D inputImageTexture3;\r\n\r\nuniform float alpha;\r\nuniform int enableFaceOff;\r\nuniform int enableAlphaFromGray;\r\nuniform vec3 diffRGB;\r\nuniform vec3 userRGB;\r\n\r\nvoid main(void) {\r\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\r\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\r\n    float ry;\r\n    float ri;\r\n    float rq;\r\n    if (texColor.r <= userRGB.r) {\r\n        ry = texColor.r + diffRGB.r * (texColor.r / userRGB.r);\r\n    } else {\r\n        ry = texColor.r + diffRGB.r * ((1.0 - texColor.r) / (1.0 - userRGB.r));\r\n    }\r\n    if (texColor.g <= userRGB.g) {\r\n        ri = texColor.g + diffRGB.g * (texColor.g / userRGB.g);\r\n    } else {\r\n        ri = texColor.g + diffRGB.g * ((1.0 - texColor.g) / (1.0 - userRGB.g));\r\n    }\r\n    if (texColor.b <= userRGB.b) {\r\n        rq = texColor.b + diffRGB.b * (texColor.b / userRGB.b);\r\n    } else {\r\n        rq = texColor.b + diffRGB.b * ((1.0 - texColor.b) / (1.0 - userRGB.b));\r\n    }\r\n    vec3 refineRGB = vec3(ry, ri, rq);\r\n    texColor = vec4(clamp(refineRGB, 0.0, 1.0), 1.0);\r\n    vec4 grayColor = texture2D(inputImageTexture3, grayTextureCoordinate);\r\n\r\n    if (enableFaceOff == 1) {\r\n        if(enableAlphaFromGray == 1){\r\n            texColor.a = 1.0 - grayColor.b;\r\n        } else{\r\n            if (texColor.a > 0.0) {\r\n                texColor = texColor / vec4(texColor.a, texColor.a, texColor.a, 1.0);\r\n            }\r\n        }\r\n        texColor.a = texColor.a * alpha;\r\n    }\r\n\r\n    texColor.rgb = texColor.rgb * texColor.a;\r\n\r\n    if(texColor.a > 0.0) {\r\n    texColor.rgb = texColor.rgb / texColor.a;\r\n    }\r\n    vec3 resultFore = texColor.rgb;\r\n    gl_FragColor = vec4(resultFore * texColor.a, texColor.a);\r\n }", null);
    b();
  }
  
  private SwitchFaceFilter(String paramString1, String paramString2, StickerItem paramStickerItem)
  {
    super(paramString1, paramString2, paramStickerItem);
  }
  
  float a(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  PointF a(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  List a(List paramList)
  {
    if (paramList.size() != 97) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 19)
    {
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    localArrayList.add(paramList.get(90));
    localArrayList.add(paramList.get(91));
    localArrayList.add(paramList.get(92));
    localArrayList.add(paramList.get(93));
    localArrayList.add(paramList.get(94));
    localArrayList.add(paramList.get(95));
    localArrayList.add(paramList.get(96));
    PointF localPointF1 = a((PointF)paramList.get(56), (PointF)paramList.get(62));
    float f1 = (float)Math.atan((((PointF)paramList.get(9)).x - localPointF1.x) / (-((PointF)paramList.get(9)).y + localPointF1.y));
    PointF localPointF2 = new PointF();
    float f2 = a((PointF)paramList.get(9), localPointF1);
    localPointF2.x = (((PointF)paramList.get(9)).x + 2.0F * f2 / 8.0F * (float)Math.sin(f1));
    localPointF2.y = (((PointF)paramList.get(9)).y - 2.0F * f2 / 8.0F * (float)Math.cos(f1));
    localArrayList.add(localPointF2);
    localPointF2 = new PointF();
    i = 1;
    while (i < 6)
    {
      localPointF2.x = (((PointF)paramList.get(9)).x + (i + 2) * f2 / 8.0F * (float)Math.sin(f1));
      localPointF2.y = (((PointF)paramList.get(9)).y - (i + 2) * f2 / 8.0F * (float)Math.cos(f1));
      localArrayList.add(localPointF2);
      i += 1;
    }
    localArrayList.add(localPointF1);
    localArrayList.add(paramList.get(83));
    localArrayList.add(paramList.get(84));
    localArrayList.add(a((PointF)paramList.get(89), (PointF)paramList.get(84)));
    localArrayList.add(paramList.get(89));
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    a(SwitchFaceUtil.initMaterialFaceTexCoords(a(SwitchFaceUtil.getFullCoords(SwitchFaceUtil.getGrayCoords(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY))), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.f));
    a(true);
    a(138);
  }
  
  public void a(SwitchFaceProcessorItem paramSwitchFaceProcessorItem1, SwitchFaceProcessorItem paramSwitchFaceProcessorItem2)
  {
    addParam(new Param.TextureParam("inputImageTexture2", paramSwitchFaceProcessorItem2.jdField_a_of_type_Int, 33986));
    addParam(new Param.Float2fParam("canvasSize", paramSwitchFaceProcessorItem1.jdField_b_of_type_Int, paramSwitchFaceProcessorItem1.jdField_c_of_type_Int));
    addParam(new Param.FloatsParam("diffRGB", new float[] { paramSwitchFaceProcessorItem2.d, paramSwitchFaceProcessorItem2.e, paramSwitchFaceProcessorItem2.f }));
    addParam(new Param.FloatsParam("userRGB", new float[] { paramSwitchFaceProcessorItem2.jdField_a_of_type_Float, paramSwitchFaceProcessorItem2.jdField_b_of_type_Float, paramSwitchFaceProcessorItem2.jdField_c_of_type_Float }));
    List localList2 = SwitchFaceUtil.getFullCoords(VideoMaterialUtil.copyList(paramSwitchFaceProcessorItem1.jdField_a_of_type_JavaUtilList));
    List localList1 = SwitchFaceUtil.getFullCoords(VideoMaterialUtil.copyList(paramSwitchFaceProcessorItem2.jdField_a_of_type_JavaUtilList));
    localList2 = a(localList2);
    setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(a(localList1), paramSwitchFaceProcessorItem2.jdField_b_of_type_Int, paramSwitchFaceProcessorItem2.jdField_c_of_type_Int, this.e));
    setPositions(SwitchFaceUtil.initFacePositions(localList2, paramSwitchFaceProcessorItem1.jdField_b_of_type_Int, paramSwitchFaceProcessorItem1.jdField_c_of_type_Int, this.d));
    a(138);
    OnDrawFrameGLSL();
    renderTexture(paramSwitchFaceProcessorItem1.jdField_a_of_type_Int, paramSwitchFaceProcessorItem1.jdField_b_of_type_Int, paramSwitchFaceProcessorItem1.jdField_c_of_type_Int);
  }
  
  public void b()
  {
    Bitmap localBitmap = SwitchFaceUtil.getGrayBitmap(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY);
    if (VideoBitmapUtil.isLegal(localBitmap))
    {
      this.jdField_b_of_type_Int = localBitmap.getWidth();
      this.jdField_c_of_type_Int = localBitmap.getHeight();
      addParam(new Param.TextureParam("inputImageTexture2", -1, 33986));
      addParam(new Param.TextureBitmapParam("inputImageTexture3", localBitmap, 33987, true));
      addParam(new Param.IntParam("enableFaceOff", 1));
      addParam(new Param.FloatParam("alpha", 1.0F));
      addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
      addParam(new Param.FloatParam("positionRotate", 0.0F));
      addParam(new Param.IntParam("enableAlphaFromGray", 1));
      addParam(new Param.FloatsParam("diffRGB", new float[] { 0.0F, 0.0F, 0.0F }));
      addParam(new Param.FloatsParam("userRGB", new float[] { 0.5F, 0.0F, 0.0F }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.ttpic.module_switchface.SwitchFaceFilter
 * JD-Core Version:    0.7.0.1
 */