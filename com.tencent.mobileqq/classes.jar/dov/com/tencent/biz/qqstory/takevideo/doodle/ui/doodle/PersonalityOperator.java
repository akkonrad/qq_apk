package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.view.MotionEvent;
import aoaj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleItem;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class PersonalityOperator
  extends DoodleOperator
{
  protected double a;
  public int a;
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame jdField_a_of_type_ComTencentFilterFrame = new Frame();
  VideoMaterial jdField_a_of_type_ComTencentTtpicModelVideoMaterial;
  DoodleLineListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener;
  PersonalityLinePath jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath = null;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  protected int[] a;
  public int b;
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame jdField_b_of_type_ComTencentFilterFrame = new Frame();
  boolean jdField_b_of_type_Boolean = false;
  int[] jdField_b_of_type_ArrayOfInt = new int[1];
  int jdField_c_of_type_Int = 320;
  Frame jdField_c_of_type_ComTencentFilterFrame = new Frame();
  boolean jdField_c_of_type_Boolean = false;
  int[] jdField_c_of_type_ArrayOfInt = new int[1];
  int jdField_d_of_type_Int = 480;
  Frame jdField_d_of_type_ComTencentFilterFrame = new Frame();
  public boolean d;
  int[] jdField_d_of_type_ArrayOfInt = new int[1];
  int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean = true;
  int jdField_f_of_type_Int = 0;
  boolean jdField_f_of_type_Boolean = false;
  public int g;
  public boolean g;
  
  public PersonalityOperator(DoodleLineListener paramDoodleLineListener)
  {
    this.jdField_a_of_type_Double = 0.75D;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_g_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener = paramDoodleLineListener;
  }
  
  public static VideoFilterBase a(QQVideoMaterial paramQQVideoMaterial)
  {
    if (paramQQVideoMaterial == null) {}
    do
    {
      return null;
      if ((paramQQVideoMaterial.a() == null) && (QLog.isColorLevel())) {
        QLog.w("PersonalityOperator", 2, "material.getDoodleItem is null!");
      }
      if (paramQQVideoMaterial.getShaderType() == 13) {
        return b(paramQQVideoMaterial);
      }
      if (paramQQVideoMaterial.getShaderType() == 15) {
        return c(paramQQVideoMaterial);
      }
    } while (paramQQVideoMaterial.getShaderType() != 14);
    return d(paramQQVideoMaterial);
  }
  
  static VideoFilterBase b(QQVideoMaterial paramQQVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramQQVideoMaterial instanceof QQVideoMaterial))
    {
      DoodleItem localDoodleItem = paramQQVideoMaterial.a();
      localObject1 = localObject2;
      if (localDoodleItem != null) {
        localObject1 = new PersonalityImageFilter(localDoodleItem, paramQQVideoMaterial.getDataPath());
      }
    }
    return localObject1;
  }
  
  static VideoFilterBase c(QQVideoMaterial paramQQVideoMaterial)
  {
    PersonalityFireworksFilter localPersonalityFireworksFilter = null;
    if ((paramQQVideoMaterial instanceof QQVideoMaterial)) {
      localPersonalityFireworksFilter = new PersonalityFireworksFilter();
    }
    return localPersonalityFireworksFilter;
  }
  
  static VideoFilterBase d(QQVideoMaterial paramQQVideoMaterial)
  {
    PersonalityGlareFilter localPersonalityGlareFilter = null;
    if ((paramQQVideoMaterial instanceof QQVideoMaterial)) {
      localPersonalityGlareFilter = new PersonalityGlareFilter(paramQQVideoMaterial.a(), paramQQVideoMaterial.getDataPath());
    }
    return localPersonalityGlareFilter;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = RendererUtils.saveTexture(this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2);
    if (localBitmap != null)
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(1.0F, (float)-this.jdField_a_of_type_Double);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      localBitmap.recycle();
      return BitmapUtils.a((Bitmap)localObject, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, true);
    }
    return null;
  }
  
  public void a()
  {
    c();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.ApplyGLSLFilter();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ApplyGLSLFilter();
    GLES20.glGenTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
    GLES20.glGenTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
    GLES20.glGenTextures(this.jdField_d_of_type_ArrayOfInt.length, this.jdField_d_of_type_ArrayOfInt, 0);
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    paramFloat1 = this.jdField_a_of_type_Int / this.jdField_c_of_type_Int;
    localPointF.x *= paramFloat1;
    localPointF.y = (paramFloat1 * localPointF.y);
    localPointF = new PointF(localPointF.x - this.jdField_a_of_type_Int * 0.5F, localPointF.y - this.jdField_b_of_type_Int * 0.5F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localPointF);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(int paramInt)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_g_of_type_Int = paramInt;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    float f1 = Math.min(720.0F / Math.min(paramInt1, paramInt2), 1.0F);
    this.jdField_a_of_type_Int = ((int)(paramInt1 * f1));
    this.jdField_b_of_type_Int = ((int)(f1 * paramInt2));
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_c_of_type_Boolean) {
      a(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramInt1 / paramInt2 > 0.75D) {
      paramInt2 = (int)(paramInt1 / 0.75D);
    }
    while (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      return;
      paramInt1 = (int)(paramInt2 * 0.75D);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_b_of_type_ArrayOfInt[0]);
    GLES20.glTexImage2D(3553, 0, 6402, paramInt1, paramInt2, 0, 6402, 5123, null);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10241, 9728);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() < 1)) {
      return;
    }
    Frame localFrame = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    VideoFilterUtil.a(true);
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt3, paramInt4, 1.0D);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), paramInt3, paramInt4, paramInt2, 1.0D, localFrame);
    VideoFilterUtil.a(false);
  }
  
  public void a(int paramInt1, int paramInt2, PersonalityLinePath paramPersonalityLinePath)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() < 1)) {
      return;
    }
    Frame localFrame = new Frame(this.jdField_a_of_type_ComTencentFilterFrame.getFBO(), this.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2);
    VideoFilterUtil.a(true);
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentFilterFrame.getFBO());
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramPersonalityLinePath.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2, this.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), 1.0D, localFrame);
    VideoFilterUtil.a(false);
    paramPersonalityLinePath.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Frame paramFrame, int paramInt1, int paramInt2, PersonalityLinePath paramPersonalityLinePath)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() < 1)) {
      return;
    }
    VideoFilterUtil.a(true);
    GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
    ArrayList localArrayList = new ArrayList();
    boolean bool = paramPersonalityLinePath.jdField_d_of_type_Boolean;
    localArrayList.addAll(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    Object localObject = (VideoFilterBase)this.jdField_a_of_type_JavaUtilHashMap.get(paramPersonalityLinePath.jdField_a_of_type_JavaLangString);
    if ((localObject instanceof PersonalityImageFilter))
    {
      localObject = (PersonalityImageFilter)localObject;
      ((PersonalityImageFilter)localObject).a(localArrayList);
      ((PersonalityImageFilter)localObject).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
      if (bool)
      {
        this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
        GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentFilterFrame.getFBO());
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        ((PersonalityImageFilter)localObject).a(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
        ((PersonalityImageFilter)localObject).renderTexture(this.jdField_a_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2);
        paramPersonalityLinePath.b();
      }
    }
    for (;;)
    {
      VideoFilterUtil.a(false);
      if ((!paramPersonalityLinePath.jdField_d_of_type_Boolean) || (!paramPersonalityLinePath.jdField_c_of_type_Boolean)) {
        break;
      }
      paramFrame = paramPersonalityLinePath.a(paramInt1, paramInt2);
      a(paramFrame.getFBO(), paramFrame.getTextureId(), paramInt1, paramInt2);
      return;
      if ((localObject instanceof PersonalityFireworksFilter))
      {
        localObject = (PersonalityFireworksFilter)localObject;
        ((PersonalityFireworksFilter)localObject).a();
        ((PersonalityFireworksFilter)localObject).a(localArrayList, bool, paramPersonalityLinePath);
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
        ((PersonalityFireworksFilter)localObject).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
        if (bool)
        {
          this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
          GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentFilterFrame.getFBO());
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          ((PersonalityFireworksFilter)localObject).a(this.jdField_a_of_type_ComTencentFilterFrame.getTextureId());
          paramPersonalityLinePath.b();
        }
      }
      else if ((localObject instanceof PersonalityGlareFilter))
      {
        localObject = (PersonalityGlareFilter)localObject;
        ((PersonalityGlareFilter)localObject).a(localArrayList);
        PersonalityUtils.a(this.jdField_b_of_type_ComTencentFilterFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2, true);
        ((PersonalityGlareFilter)localObject).a();
        PersonalityUtils.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, paramFrame, this.jdField_b_of_type_ComTencentFilterFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2);
        if (bool)
        {
          ((PersonalityGlareFilter)localObject).a(paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
          this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], paramInt1, paramInt2, 1.0D);
          PersonalityUtils.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, this.jdField_a_of_type_ComTencentFilterFrame, this.jdField_b_of_type_ComTencentFilterFrame, this.jdField_d_of_type_ArrayOfInt[0], paramInt1, paramInt2);
          paramPersonalityLinePath.b();
        }
      }
    }
  }
  
  public void a(QQVideoMaterial paramQQVideoMaterial)
  {
    if (paramQQVideoMaterial != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramQQVideoMaterial.getId()))
      {
        VideoFilterBase localVideoFilterBase = a(paramQQVideoMaterial);
        if (localVideoFilterBase != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramQQVideoMaterial.getId(), localVideoFilterBase);
        }
      }
      this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial = paramQQVideoMaterial;
      paramQQVideoMaterial = new aoaj(this, paramQQVideoMaterial);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(paramQQVideoMaterial);
      }
      return;
    }
    SLog.b("PersonalityOperator", "material is null!");
  }
  
  public void a(PersonalityLinePath paramPersonalityLinePath)
  {
    if ((paramPersonalityLinePath.jdField_d_of_type_Boolean) && (paramPersonalityLinePath.jdField_a_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Boolean);
      if ((!paramPersonalityLinePath.jdField_a_of_type_Boolean) && (paramPersonalityLinePath.jdField_b_of_type_Boolean))
      {
        if (paramPersonalityLinePath.jdField_c_of_type_Boolean) {
          a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramPersonalityLinePath);
        }
        this.jdField_f_of_type_Boolean = true;
        return;
      }
    } while (paramPersonalityLinePath.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 1);
    a(this.jdField_d_of_type_ComTencentFilterFrame, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramPersonalityLinePath);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      return;
    }
    paramString = (VideoFilterBase)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    paramString.ApplyGLSLFilter();
    paramString.setRenderMode(1);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
      }
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      if ((QLog.isColorLevel()) && (paramMotionEvent.getAction() == 0)) {
        QLog.w("PersonalityOperator", 2, "onTouch filterMap is empty");
      }
    }
    do
    {
      return true;
      if ((this.jdField_f_of_type_Int + 1 <= 50) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath.jdField_d_of_type_Boolean)) {
        break;
      }
    } while (paramMotionEvent.getAction() != 0);
    QQStoryContext.a();
    QQToast.a(QQStoryContext.a().getApp(), "个性笔触笔数已达上限", 0).a();
    return true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i;
    if (paramMotionEvent.getAction() == 2) {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath != null)
      {
        a(f1, f2, false);
        i = this.jdField_e_of_type_Int + 1;
        this.jdField_e_of_type_Int = i;
        this.jdField_e_of_type_Int = (i % 4);
        if (this.jdField_e_of_type_Int != 0) {}
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener == null) {
        break;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
      return true;
      if (paramMotionEvent.getAction() == 0)
      {
        if ((this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getId())))
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentTtpicModelVideoMaterial.getId();
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {}
          for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();; i = 0)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath = new PersonalityLinePath(102, paramMotionEvent, i);
            this.jdField_f_of_type_Int += 1;
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath.jdField_c_of_type_Boolean = true;
            if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath);
            }
            a(f1, f2, false);
            this.jdField_e_of_type_Int = 0;
            break;
          }
        }
      }
      else if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityLinePath != null)) {
        a(f1, f2, true);
      }
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_g_of_type_Int = paramInt;
      Bitmap localBitmap = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (localBitmap == null)
      {
        this.jdField_g_of_type_Boolean = false;
        SLog.e("PersonalityOperator", "saveTextureToBitmap failed, bitmapFromTexture is null");
        return;
      }
      localBitmap = BitmapUtils.a(localBitmap, 1.0F * this.jdField_g_of_type_Int / this.jdField_c_of_type_Int, true);
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(localBitmap);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Personality", 2, localOutOfMemoryError, new Object[0]);
      }
    }
  }
  
  public void c()
  {
    this.jdField_f_of_type_Int = 0;
    try
    {
      this.jdField_c_of_type_ComTencentFilterFrame.clear();
      this.jdField_b_of_type_ComTencentFilterBaseFilter.ClearGLSL();
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (localIterator.hasNext()) {
            ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).clearGLSLSelf();
          }
          this.jdField_a_of_type_JavaUtilHashMap.clear();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PersonalityOperator", 2, "clear " + localThrowable.toString());
      }
      return;
    }
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    GLES20.glDeleteTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
    GLES20.glDeleteTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
    GLES20.glDeleteTextures(this.jdField_d_of_type_ArrayOfInt.length, this.jdField_d_of_type_ArrayOfInt, 0);
  }
  
  public void d()
  {
    com.tencent.view.FilterDefault.currentShareIndex = -1;
    this.jdField_d_of_type_ComTencentFilterFrame.bindFrame(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Double);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, this.jdField_a_of_type_Double, this.jdField_c_of_type_ComTencentFilterFrame);
    if (!this.jdField_b_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.jdField_c_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
      PersonalityUtils.a();
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      return;
      label126:
      a(this.jdField_d_of_type_ComTencentFilterFrame.getFBO(), this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 88	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_f_of_type_Boolean	Z
    //   4: ifeq +29 -> 33
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 72	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_ComTencentFilterFrame	Lcom/tencent/filter/Frame;
    //   12: invokevirtual 316	com/tencent/filter/Frame:getFBO	()I
    //   15: aload_0
    //   16: getfield 72	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_ComTencentFilterFrame	Lcom/tencent/filter/Frame;
    //   19: invokevirtual 144	com/tencent/filter/Frame:getTextureId	()I
    //   22: aload_0
    //   23: getfield 90	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_Int	I
    //   26: aload_0
    //   27: getfield 204	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_b_of_type_Int	I
    //   30: invokevirtual 350	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:a	(IIII)V
    //   33: aload_0
    //   34: getfield 68	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_b_of_type_ComTencentFilterBaseFilter	Lcom/tencent/filter/BaseFilter;
    //   37: aload_0
    //   38: getfield 72	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_ComTencentFilterFrame	Lcom/tencent/filter/Frame;
    //   41: invokevirtual 144	com/tencent/filter/Frame:getTextureId	()I
    //   44: aload_0
    //   45: getfield 28	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   48: aload_0
    //   49: getfield 30	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Int	I
    //   52: iconst_0
    //   53: aload_0
    //   54: getfield 34	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_Double	D
    //   57: aload_0
    //   58: getfield 70	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_ComTencentFilterFrame	Lcom/tencent/filter/Frame;
    //   61: invokevirtual 312	com/tencent/filter/BaseFilter:RenderProcess	(IIIIDLcom/tencent/filter/Frame;)V
    //   64: aload_0
    //   65: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   68: ifnull +23 -> 91
    //   71: aload_0
    //   72: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   75: instanceof 540
    //   78: ifeq +13 -> 91
    //   81: aload_0
    //   82: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   85: checkcast 540	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController
    //   88: invokevirtual 542	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController:f	()V
    //   91: aload_0
    //   92: getfield 219	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_g_of_type_Boolean	Z
    //   95: ifeq +285 -> 380
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 219	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_g_of_type_Boolean	Z
    //   103: aconst_null
    //   104: astore 8
    //   106: aconst_null
    //   107: astore 7
    //   109: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +12 -> 124
    //   115: ldc 109
    //   117: iconst_2
    //   118: ldc_w 544
    //   121: invokestatic 546	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: invokestatic 552	java/lang/System:currentTimeMillis	()J
    //   127: lstore_2
    //   128: aload 8
    //   130: astore 6
    //   132: aload_0
    //   133: getfield 28	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   136: aload_0
    //   137: getfield 30	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Int	I
    //   140: imul
    //   141: invokestatic 558	java/nio/IntBuffer:allocate	(I)Ljava/nio/IntBuffer;
    //   144: astore 9
    //   146: aload 8
    //   148: astore 6
    //   150: iconst_0
    //   151: iconst_0
    //   152: aload_0
    //   153: getfield 28	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   156: aload_0
    //   157: getfield 30	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Int	I
    //   160: sipush 6408
    //   163: sipush 5121
    //   166: aload 9
    //   168: invokestatic 562	android/opengl/GLES20:glReadPixels	(IIIIIILjava/nio/Buffer;)V
    //   171: aload 8
    //   173: astore 6
    //   175: aload 9
    //   177: invokevirtual 566	java/nio/IntBuffer:array	()[I
    //   180: astore 10
    //   182: aload 8
    //   184: astore 6
    //   186: aload_0
    //   187: getfield 28	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   190: aload_0
    //   191: getfield 30	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Int	I
    //   194: getstatic 572	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   197: invokestatic 575	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   200: astore 9
    //   202: aload 8
    //   204: astore 6
    //   206: aload 9
    //   208: aload 10
    //   210: invokestatic 579	java/nio/IntBuffer:wrap	([I)Ljava/nio/IntBuffer;
    //   213: invokevirtual 583	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   216: aload 9
    //   218: ifnull +331 -> 549
    //   221: aload 8
    //   223: astore 6
    //   225: aload_0
    //   226: getfield 92	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_g_of_type_Int	I
    //   229: i2f
    //   230: fconst_1
    //   231: fmul
    //   232: aload_0
    //   233: getfield 28	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_c_of_type_Int	I
    //   236: i2f
    //   237: fdiv
    //   238: fstore_1
    //   239: aload 8
    //   241: astore 6
    //   243: new 152	android/graphics/Matrix
    //   246: dup
    //   247: invokespecial 153	android/graphics/Matrix:<init>	()V
    //   250: astore 10
    //   252: aload 8
    //   254: astore 6
    //   256: aload 10
    //   258: ldc_w 584
    //   261: invokevirtual 588	android/graphics/Matrix:postRotate	(F)Z
    //   264: pop
    //   265: aload 8
    //   267: astore 6
    //   269: aload 10
    //   271: ldc_w 589
    //   274: fload_1
    //   275: fmul
    //   276: fload_1
    //   277: fconst_1
    //   278: fmul
    //   279: invokevirtual 157	android/graphics/Matrix:postScale	(FF)Z
    //   282: pop
    //   283: aload 8
    //   285: astore 6
    //   287: aload 9
    //   289: iconst_0
    //   290: iconst_0
    //   291: aload 9
    //   293: invokevirtual 162	android/graphics/Bitmap:getWidth	()I
    //   296: aload 9
    //   298: invokevirtual 165	android/graphics/Bitmap:getHeight	()I
    //   301: aload 10
    //   303: iconst_0
    //   304: invokestatic 169	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   307: astore 8
    //   309: aload 8
    //   311: astore 6
    //   313: aload 6
    //   315: astore 7
    //   317: aload_0
    //   318: iconst_0
    //   319: putfield 453	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_d_of_type_Boolean	Z
    //   322: aload_0
    //   323: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   326: ifnull +14 -> 340
    //   329: aload_0
    //   330: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   333: aload 6
    //   335: invokeinterface 489 2 0
    //   340: invokestatic 552	java/lang/System:currentTimeMillis	()J
    //   343: lstore 4
    //   345: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +32 -> 380
    //   351: ldc 109
    //   353: iconst_2
    //   354: new 506	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 507	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 591
    //   364: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: lload 4
    //   369: lload_2
    //   370: lsub
    //   371: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 546	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: return
    //   381: astore 8
    //   383: aconst_null
    //   384: astore 6
    //   386: aload 6
    //   388: astore 7
    //   390: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +20 -> 413
    //   396: aload 6
    //   398: astore 7
    //   400: ldc_w 491
    //   403: iconst_2
    //   404: aload 8
    //   406: iconst_0
    //   407: anewarray 493	java/lang/Object
    //   410: invokestatic 496	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   413: aload_0
    //   414: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   417: ifnull -77 -> 340
    //   420: aload_0
    //   421: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   424: aload 6
    //   426: invokeinterface 489 2 0
    //   431: goto -91 -> 340
    //   434: astore 8
    //   436: aload 7
    //   438: astore 6
    //   440: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq +35 -> 478
    //   446: aload 7
    //   448: astore 6
    //   450: ldc_w 491
    //   453: iconst_2
    //   454: new 506	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 507	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 596
    //   464: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 8
    //   469: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: aload_0
    //   479: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   482: ifnull -142 -> 340
    //   485: aload_0
    //   486: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   489: aload 7
    //   491: invokeinterface 489 2 0
    //   496: goto -156 -> 340
    //   499: astore 8
    //   501: aload 6
    //   503: astore 7
    //   505: aload 8
    //   507: astore 6
    //   509: aload_0
    //   510: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   513: ifnull +14 -> 527
    //   516: aload_0
    //   517: getfield 94	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/PersonalityOperator:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLineListener;
    //   520: aload 7
    //   522: invokeinterface 489 2 0
    //   527: aload 6
    //   529: athrow
    //   530: astore 6
    //   532: goto -23 -> 509
    //   535: astore 8
    //   537: aload 6
    //   539: astore 7
    //   541: goto -105 -> 436
    //   544: astore 8
    //   546: goto -160 -> 386
    //   549: aconst_null
    //   550: astore 6
    //   552: goto -239 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	this	PersonalityOperator
    //   238	39	1	f1	float
    //   127	243	2	l1	long
    //   343	25	4	l2	long
    //   130	398	6	localObject1	Object
    //   530	8	6	localObject2	Object
    //   550	1	6	localObject3	Object
    //   107	433	7	localObject4	Object
    //   104	206	8	localBitmap	Bitmap
    //   381	24	8	localException1	java.lang.Exception
    //   434	34	8	localOutOfMemoryError1	OutOfMemoryError
    //   499	7	8	localObject5	Object
    //   535	1	8	localOutOfMemoryError2	OutOfMemoryError
    //   544	1	8	localException2	java.lang.Exception
    //   144	153	9	localObject6	Object
    //   180	122	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   132	146	381	java/lang/Exception
    //   150	171	381	java/lang/Exception
    //   175	182	381	java/lang/Exception
    //   186	202	381	java/lang/Exception
    //   206	216	381	java/lang/Exception
    //   225	239	381	java/lang/Exception
    //   243	252	381	java/lang/Exception
    //   256	265	381	java/lang/Exception
    //   269	283	381	java/lang/Exception
    //   287	309	381	java/lang/Exception
    //   132	146	434	java/lang/OutOfMemoryError
    //   150	171	434	java/lang/OutOfMemoryError
    //   175	182	434	java/lang/OutOfMemoryError
    //   186	202	434	java/lang/OutOfMemoryError
    //   206	216	434	java/lang/OutOfMemoryError
    //   225	239	434	java/lang/OutOfMemoryError
    //   243	252	434	java/lang/OutOfMemoryError
    //   256	265	434	java/lang/OutOfMemoryError
    //   269	283	434	java/lang/OutOfMemoryError
    //   287	309	434	java/lang/OutOfMemoryError
    //   132	146	499	finally
    //   150	171	499	finally
    //   175	182	499	finally
    //   186	202	499	finally
    //   206	216	499	finally
    //   225	239	499	finally
    //   243	252	499	finally
    //   256	265	499	finally
    //   269	283	499	finally
    //   287	309	499	finally
    //   440	446	499	finally
    //   450	478	499	finally
    //   317	322	530	finally
    //   390	396	530	finally
    //   400	413	530	finally
    //   317	322	535	java/lang/OutOfMemoryError
    //   317	322	544	java/lang/Exception
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int -= 1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator
 * JD-Core Version:    0.7.0.1
 */