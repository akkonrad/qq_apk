package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

public class QQAVImageKaleidoscopeFilter
  extends QQAVImageFilter
{
  private float jdField_a_of_type_Float = 29.4F;
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public QQAVImageKaleidoscopeFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "//万花筒\nprecision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float angle;//旋转角度\nuniform float imageWidth;//从客户端传入的图片宽数据\nuniform float imageHeight;//从客户端传入的图片高数据\nuniform int yScaleDirection;\nuniform int videoRotate;\n\nfloat disX = 0.0;//偏移距离，这里计算中心点到4分之一中心点的距离\nfloat disY = 0.0;\nfloat scale = 1.0;\nvec2 centerInFirst;\n\nvec2 transForTexPosition(vec2 pos)\n{\n    \treturn vec2(pos.x/imageWidth, pos.y/imageHeight);\n}\n\nvec2 getMirror(vec2 textureCoordinate)\n{\n\tvec2 textureCoordinateUse = textureCoordinate;\n\nif (videoRotate == 270) {//原画面旋转了270度，以右边的x为镜像\n\t\tif (textureCoordinateUse.x < 0.5) {\n            \t\ttextureCoordinateUse.x = 1.0 - textureCoordinateUse.x;\n        \t\t}\n\t} else {//已左边的x为镜像\n\t\tif (textureCoordinateUse.x > 0.5) {\n           \t\t textureCoordinateUse.x = 1.0 - textureCoordinateUse.x;\n        \t\t}\n\t}\n\n\t\n       if (videoRotate == 90) {//原画面旋转了90度，则以下边的y为镜像\n\t\tif (textureCoordinateUse.y < 0.5) {\n            \t\ttextureCoordinateUse.y = 1.0 - textureCoordinateUse.y;\n        \t\t}\n       } else {//以上边的y为镜像\n\t\tif (textureCoordinateUse.y > 0.5) {\n            \t\ttextureCoordinateUse.y = 1.0 - textureCoordinateUse.y;\n        \t\t}\n        }        \n    \treturn textureCoordinateUse;\n}\n\nvec2 getRotate(vec2 textureCoordinateUse, float angle)\n{\n\tvec2 pixTexture = vec2(textureCoordinateUse.x * imageWidth, textureCoordinateUse.y * imageHeight); \n\tfloat degree = radians(angle);//转为弧度\n\tfloat c = cos(degree);\n        float s = sin(degree);\n        vec2  temp;\n        temp.x = pixTexture.x * c - pixTexture.y * s;\n        temp.y = pixTexture.x * s + pixTexture.y * c;\n\treturn temp;\n}\n\nvoid checkDis()\n{\n\tvec2 centerAfterRotate = getRotate(vec2(0.5, 0.5), -angle);\n\tdisX = (centerAfterRotate.x - centerInFirst.x) / imageWidth;\n\tdisY = (centerAfterRotate.y - centerInFirst.y) / imageHeight;\n}\n \nvec2 getZoomPosition(vec2 src)\n{\n\tvec2 in_circle_pos = vec2(imageWidth / 2.0, imageHeight / 2.0);\n    \tfloat zoom_x = (src.x - in_circle_pos.x) / scale;\n    \tfloat zoom_y = (src.y - in_circle_pos.y) / scale;\n\tif (yScaleDirection == 0) {\n\t\treturn vec2(in_circle_pos.x + zoom_x, in_circle_pos.y + zoom_y);\n\t} else {\n\t\treturn vec2(in_circle_pos.x + zoom_x, in_circle_pos.y - zoom_y);\n\t}\n}\n\nvec4 getScaleColor(vec2 src)//双线性插值采样\n{\n    vec2 pos = getZoomPosition(src);\n\n    float _x = floor(pos.x);\n\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y)));\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.0)));\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y)));\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y + 1.0)));\n\n    return (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n\nvoid checkScale( )\n{\n\tfloat degree = radians(angle);//转为弧度\n\tfloat c = abs(cos(degree));\n        float s = abs(sin(degree));\n\tvec2 size = vec2(imageWidth / 2.0, imageHeight / 2.0);\n\n\tfloat w = size.x * c + size.y * s; //x方向对角线的距离\n\tfloat scaleX = w / imageWidth;\n\tfloat h = size.x * s + size.y * c; //y方向对角线的距离\n\tfloat scaleY = h / imageHeight;\n\tscale = max(scaleX, scaleY);\n}\n\nvec4 getShrinkColor(vec2 src)\n{\n\tfloat shrinkScale = 1.0 / scale;\n\tvec2 uv = transForTexPosition(src);\n\tvec2 coordinate = (0.5 + -0.5 * shrinkScale +  uv * shrinkScale);\n\tif (yScaleDirection != 0) {\n\t\tcoordinate.y = 1.0 - coordinate.y;\n\t} \n        vec4 r = texture2D(inputImageTexture, coordinate);\n\treturn r;\n}\n\nvoid main()\n{\nif (videoRotate == 90) {\n\t\tcenterInFirst = vec2(imageWidth / 4.0, imageHeight / 4.0 * 3.0);\n\t} else if(videoRotate == 270) {\n\t\tcenterInFirst = vec2(imageWidth / 4.0 * 3.0, imageHeight / 4.0);\n\t} else {\n\t\tcenterInFirst = vec2(imageWidth / 4.0, imageHeight / 4.0);\n\t}\n\tcheckDis();//计算偏移距离\n\n\tcheckScale();//计算缩放比例，试全屏内容最大化显示在4分之一区域\n\n\tvec2 textureCoordinateUse = textureCoordinate;\n\t\n\ttextureCoordinateUse = getMirror(textureCoordinateUse);//镜像转换\n\ttextureCoordinateUse.x += disX;\n\ttextureCoordinateUse.y += disY;\n\n\tvec2 result = getRotate(textureCoordinateUse, angle);//旋转转换\n\t\n\t//缩放转换\n\tvec4 colorFront;\n\tif (scale > 1.0) {\n\t\tcolorFront = getScaleColor(result);\n\t} else {\n\t\tcolorFront = getShrinkColor(result);\n\t}\n\n\tgl_FragColor = colorFront;\n\n}");
    super.setQQAVEffectType(1009);
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    setInteger(this.d, 1);
    super.onDraw2(paramInt1, paramInt2);
  }
  
  public void onInit()
  {
    super.onInit();
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
    this.b = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
    this.c = GLES20.glGetUniformLocation(getProgram(), "angle");
    this.d = GLES20.glGetUniformLocation(getProgram(), "yScaleDirection");
    this.e = GLES20.glGetUniformLocation(getProgram(), "videoRotate");
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.jdField_a_of_type_Int, paramInt1);
    setFloat(this.b, paramInt2);
    setFloat(this.c, this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageKaleidoscopeFilter
 * JD-Core Version:    0.7.0.1
 */