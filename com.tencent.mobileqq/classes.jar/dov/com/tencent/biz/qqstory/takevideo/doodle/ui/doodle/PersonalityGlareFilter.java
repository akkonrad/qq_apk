package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleItem;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.Float3fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.Mat4Param;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonalityGlareFilter
  extends VideoFilterBase
{
  public int a;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  protected Param.TextureBitmapParam a;
  private String jdField_a_of_type_JavaLangString = "doodle_image";
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  List b;
  public int c = 1080;
  public int d = 1440;
  
  public PersonalityGlareFilter(DoodleItem paramDoodleItem, String paramString)
  {
    super(VideoFilterUtil.VERTEX_SHADER_COMMON, VideoFilterUtil.FRAGMENT_SHADER_COMMON, paramDoodleItem);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 320;
    this.jdField_b_of_type_Int = 480;
    initParams();
    a(paramString);
    this.item.width = 25;
    this.item.height = 25;
    super.setDrawPartial(true);
  }
  
  private void a()
  {
    Bitmap localBitmap = (Bitmap)this.jdField_b_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam != null)
    {
      this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam.swapTextureBitmap(localBitmap);
      return;
    }
    this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam = new Param.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, false);
    this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam.initialParams(super.getmProgramIds());
    super.addParam(this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam);
  }
  
  private void a(String paramString)
  {
    paramString = VideoBitmapUtil.decodeSampledBitmapFromFile(VideoUtil.getRealPath(paramString + "/" + this.jdField_a_of_type_JavaLangString + "/" + this.jdField_a_of_type_JavaLangString + "_0.png"), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
    if (VideoBitmapUtil.isLegal(paramString)) {
      this.jdField_b_of_type_JavaUtilList.add(paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Personality", 2, "PersonalityGlareFilter init bitmap is null");
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      super.ApplyGLSLFilter();
    }
  }
  
  PointF a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, float paramFloat)
  {
    PointF localPointF1 = new PointF((paramPointF3.x - paramPointF1.x) * 0.5F, (paramPointF3.y - paramPointF1.y) * 0.5F);
    PointF localPointF2 = new PointF((paramPointF3.x - paramPointF2.x) * 3.0F - (paramPointF4.x - paramPointF2.x) * 0.5F - 2.0F * 0.5F * (paramPointF3.x - paramPointF1.x), (paramPointF3.y - paramPointF2.y) * 3.0F - (paramPointF4.y - paramPointF2.y) * 0.5F - 2.0F * 0.5F * (paramPointF3.y - paramPointF1.y));
    float f1 = paramPointF3.x;
    float f2 = paramPointF2.x;
    float f3 = paramPointF4.x;
    float f4 = paramPointF2.x;
    float f5 = paramPointF3.x;
    float f6 = paramPointF1.x;
    float f7 = paramPointF3.y;
    float f8 = paramPointF2.y;
    float f9 = paramPointF4.y;
    float f10 = paramPointF2.y;
    paramPointF1 = new PointF((f1 - f2) * -2.0F + (f3 - f4) * 0.5F + (f5 - f6) * 0.5F, 0.5F * (paramPointF3.y - paramPointF1.y) + ((f7 - f8) * -2.0F + (f9 - f10) * 0.5F));
    f1 = paramPointF1.x;
    f2 = localPointF2.x;
    f3 = localPointF1.x;
    f4 = paramPointF2.x;
    f5 = paramPointF1.y;
    f6 = localPointF2.y;
    return new PointF(f1 * paramFloat * paramFloat * paramFloat + f2 * paramFloat * paramFloat + f3 * paramFloat + f4, localPointF1.y * paramFloat + (f6 * paramFloat * paramFloat + f5 * paramFloat * paramFloat * paramFloat) + paramPointF2.y);
  }
  
  void a(ArrayList paramArrayList)
  {
    float f3 = this.item.width * this.width / this.c;
    int i = 3;
    float f1;
    float f2;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      f1 = (float)PersonalityUtils.a((PointF)this.jdField_a_of_type_JavaUtilList.get(i - 3), (PointF)this.jdField_a_of_type_JavaUtilList.get(i - 2));
      f2 = (float)PersonalityUtils.a((PointF)this.jdField_a_of_type_JavaUtilList.get(i - 2), (PointF)this.jdField_a_of_type_JavaUtilList.get(i - 1));
      f1 = 1.0F / ((int)(((float)PersonalityUtils.a((PointF)this.jdField_a_of_type_JavaUtilList.get(i - 1), (PointF)this.jdField_a_of_type_JavaUtilList.get(i)) + (f1 + f2)) / (f3 * 1.5F)) * 12 * 1.0F);
      if (f1 > 0.1F) {
        f1 = 0.1F;
      }
    }
    label286:
    for (;;)
    {
      f2 = 0.0F;
      for (;;)
      {
        if (f2 < 1.0F)
        {
          paramArrayList.add(a((PointF)this.jdField_a_of_type_JavaUtilList.get(i - 3), (PointF)this.jdField_a_of_type_JavaUtilList.get(i - 2), (PointF)this.jdField_a_of_type_JavaUtilList.get(i - 1), (PointF)this.jdField_a_of_type_JavaUtilList.get(i), f2));
          f2 += f1;
          continue;
          if (f1 >= 0.01F) {
            break label286;
          }
          f1 = 0.01F;
          break;
        }
      }
      i += 1;
      break;
      return;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_b_of_type_JavaUtilList.size() < 1) {}
    for (;;)
    {
      return;
      a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        localPointF = new PointF(localPointF.x + this.jdField_a_of_type_AndroidGraphicsPoint.x, localPointF.y + this.jdField_a_of_type_AndroidGraphicsPoint.y);
        this.jdField_a_of_type_JavaUtilList.add(localPointF);
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1)) {
      return false;
    }
    System.currentTimeMillis();
    PersonalityUtils.a(2);
    float f1 = this.item.width * this.width / this.c * 1.5F;
    float f2 = this.item.height * this.height / this.d * 1.5F;
    ArrayList localArrayList = new ArrayList();
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() <= 3)
    {
      i = 3;
      j = 0;
    }
    float f3;
    float f4;
    for (;;)
    {
      if ((j >= this.jdField_a_of_type_JavaUtilList.size()) || (j >= i)) {
        break label343;
      }
      if (j > 0)
      {
        localObject1 = (PointF)this.jdField_a_of_type_JavaUtilList.get(j - 1);
        localObject2 = (PointF)this.jdField_a_of_type_JavaUtilList.get(j);
        int m = (int)((float)PersonalityUtils.a((PointF)localObject1, (PointF)localObject2) / f1 * 18.0F) + 1;
        int k = m;
        if (m < 6) {
          k = 6;
        }
        f3 = (((PointF)localObject2).x - ((PointF)localObject1).x) / (k * 1.0F);
        f4 = (((PointF)localObject2).y - ((PointF)localObject1).y) / (k * 1.0F);
        m = 0;
        for (;;)
        {
          if (m < k)
          {
            localArrayList.add(new PointF(((PointF)localObject1).x + m * f3, ((PointF)localObject1).y + m * f4));
            m += 1;
            continue;
            i = 2;
            break;
          }
        }
        if (!((PointF)localArrayList.get(localArrayList.size() - 1)).equals(((PointF)localObject2).x, ((PointF)localObject2).y)) {
          localArrayList.add(localObject1);
        }
      }
      j += 1;
    }
    label343:
    if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
      a(localArrayList);
    }
    Object localObject1 = new float[localArrayList.size() * 8];
    Object localObject2 = new float[localArrayList.size() * 8];
    int i = 0;
    while (i < localArrayList.size())
    {
      PointF localPointF = (PointF)localArrayList.get(i);
      float f6 = localPointF.x - f1 / 2.0F;
      float f5 = this.height - localPointF.y + f2 / 2.0F;
      f3 = f6 / this.width * 2.0F - 1.0F;
      f4 = f5 / this.height * 2.0F - 1.0F;
      f6 = (f6 + f1) / this.width * 2.0F - 1.0F;
      f5 = (f5 - f2) / this.height * 2.0F - 1.0F;
      localObject1[(i * 8 + 0)] = f3;
      localObject1[(i * 8 + 1)] = f5;
      localObject1[(i * 8 + 2)] = f6;
      localObject1[(i * 8 + 3)] = f5;
      localObject1[(i * 8 + 4)] = f3;
      localObject1[(i * 8 + 5)] = f4;
      localObject1[(i * 8 + 6)] = f6;
      localObject1[(i * 8 + 7)] = f4;
      localObject2[(i * 8 + 0)] = 0.0F;
      localObject2[(i * 8 + 1)] = 1.0F;
      localObject2[(i * 8 + 2)] = 1.0F;
      localObject2[(i * 8 + 3)] = 1.0F;
      localObject2[(i * 8 + 4)] = 0.0F;
      localObject2[(i * 8 + 5)] = 0.0F;
      localObject2[(i * 8 + 6)] = 1.0F;
      localObject2[(i * 8 + 7)] = 0.0F;
      i += 1;
    }
    super.setPositions((float[])localObject1);
    super.setTexCords((float[])localObject2);
    super.addParam(new Param.Float2fParam("texAnchor", -this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y));
    super.addParam(new Param.FloatParam("texScale", 1.0F));
    super.addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.OnDrawFrameGLSL();
    GLES20.glDrawArrays(5, 0, localArrayList.size() * 4);
    GLES20.glFlush();
    PersonalityUtils.a(0);
    System.currentTimeMillis();
    return true;
  }
  
  public void initParams()
  {
    super.addParam(new Param.IntParam("texNeedTransform", 1));
    super.addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    super.addParam(new Param.Float2fParam("texAnchor", 0.0F, 0.0F));
    super.addParam(new Param.FloatParam("texScale", 1.0F));
    super.addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.addParam(new Param.FloatParam("positionRotate", 0.0F));
    if (this.item != null) {
      super.addParam(new Param.IntParam("blendMode", this.item.blendMode));
    }
    super.addParam(new Param.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public void updatePreview(List paramList, float[] paramArrayOfFloat, Map paramMap, float paramFloat, long paramLong) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(paramInt1 / 2, paramInt2 / 2);
    super.addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityGlareFilter
 * JD-Core Version:    0.7.0.1
 */