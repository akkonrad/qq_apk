package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.Float3fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.Mat4Param;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonalityImageFilter
  extends VideoFilterBase
{
  int jdField_a_of_type_Int;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  DoodleItem jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem;
  protected Param.TextureBitmapParam a;
  private String jdField_a_of_type_JavaLangString = "doodle_image";
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  List b;
  public int c = 480;
  public int d = 1080;
  public int e = 1440;
  
  public PersonalityImageFilter(DoodleItem paramDoodleItem, String paramString)
  {
    super(VideoFilterUtil.VERTEX_SHADER_COMMON, VideoFilterUtil.FRAGMENT_SHADER_COMMON, paramDoodleItem);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 320;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem = paramDoodleItem;
    initParams();
    a(paramString);
    super.setDrawPartial(true);
  }
  
  private double a(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  private void a()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    localObject = (Bitmap)((List)localObject).get(i % this.jdField_b_of_type_JavaUtilList.size());
    if (this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam != null)
    {
      this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam.swapTextureBitmap((Bitmap)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam = new Param.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject, 33986, false);
    this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam.initialParams(super.getmProgramIds());
    super.addParam(this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam);
  }
  
  private void a(String paramString)
  {
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    if (i < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem.jdField_a_of_type_Int)
    {
      Bitmap localBitmap = VideoBitmapUtil.decodeSampledBitmapFromFile(VideoUtil.getRealPath(paramString + "/" + this.jdField_a_of_type_JavaLangString + "/" + this.jdField_a_of_type_JavaLangString + "_" + i + ".png"), 80, 80);
      if (VideoBitmapUtil.isLegal(localBitmap)) {
        this.jdField_b_of_type_JavaUtilList.add(localBitmap);
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Personality", 2, "PersonalityImageFilter unlegal bitmap " + i);
        }
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      super.ApplyGLSLFilter();
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    if (this.jdField_b_of_type_JavaUtilList.size() < 1) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localArrayList.add(new PointF(localPointF.x + this.jdField_a_of_type_AndroidGraphicsPoint.x, localPointF.y + this.jdField_a_of_type_AndroidGraphicsPoint.y));
    }
    this.jdField_a_of_type_JavaUtilList.add(localArrayList);
  }
  
  public void initAttribParams()
  {
    setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
  }
  
  public void initParams()
  {
    super.addParam(new Param.IntParam("texNeedTransform", 1));
    super.addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    super.addParam(new Param.Float2fParam("texAnchor", 0.0F, 0.0F));
    super.addParam(new Param.FloatParam("texScale", 1.0F));
    super.addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.addParam(new Param.FloatParam("positionRotate", 0.0F));
    super.addParam(new Param.IntParam("blendMode", this.item.blendMode));
    super.addParam(new Param.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1) || (((List)this.jdField_a_of_type_JavaUtilList.get(0)).size() < 1)) {
      return false;
    }
    this.jdField_a_of_type_Int = 0;
    Object localObject = null;
    paramInt2 = 0;
    while (paramInt2 < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramInt3 = 0;
      if (paramInt3 < ((List)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).size())
      {
        PointF localPointF = (PointF)((List)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).get(paramInt3);
        if ((localObject != null) && (a(localPointF, (PointF)localObject) <= Math.max(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem.width, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem.height) * 1.2D)) {}
        for (;;)
        {
          paramInt3 += 1;
          break;
          a();
          float f1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem.width * this.width / this.d * 1.5F;
          float f2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem.height * this.height / this.e * 1.5F;
          float f3 = localPointF.x - f1 / 2.0F;
          float f4 = this.height - localPointF.y + f2 / 2.0F;
          super.setPositions(AlgoUtils.calPositions(f3, f4, f1 + f3, f4 - f2, this.width, this.height));
          super.addParam(new Param.Float2fParam("texAnchor", -this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y));
          super.addParam(new Param.FloatParam("texScale", 1.0F));
          super.addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
          GLES20.glFlush();
          super.OnDrawFrameGLSL();
          super.renderTexture(paramInt1, this.width, this.height);
          localObject = localPointF;
        }
      }
      paramInt2 += 1;
    }
    return true;
  }
  
  public void updatePreview(List paramList, float[] paramArrayOfFloat, Map paramMap, float paramFloat, long paramLong) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(paramInt1 / 2, paramInt2 / 2);
    super.addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityImageFilter
 * JD-Core Version:    0.7.0.1
 */