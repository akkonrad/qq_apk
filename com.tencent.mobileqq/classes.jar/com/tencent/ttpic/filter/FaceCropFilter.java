package com.tencent.ttpic.filter;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceCropItem.CropFrame;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FaceCropFilter
  extends VideoFilterBase
{
  private float[] attrPositions = new float[8];
  private float[] attrTexCoords = new float[8];
  private FaceCropItem faceCropItem;
  private boolean needRender;
  private List<NormalVideoFilter> normalFilters;
  
  public FaceCropFilter(VideoMaterial paramVideoMaterial)
  {
    super(VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceCropVertexShader.dat"), VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceCropFragmentShader.dat"), null);
    this.faceCropItem = paramVideoMaterial.getFaceCropItem();
  }
  
  private void updateParams(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    Object localObject1 = (FaceCropItem.CropFrame)this.faceCropItem.frameList.get(paramInt);
    float f2 = (float)Math.min(((FaceCropItem.CropFrame)localObject1).width / this.width, ((FaceCropItem.CropFrame)localObject1).height / this.height);
    paramFloat = (float)(((FaceCropItem.CropFrame)localObject1).width / f2);
    float f1 = (float)(((FaceCropItem.CropFrame)localObject1).height / f2);
    Object localObject2 = new PointF((paramFloat - this.width) / 2.0F, (f1 - this.height) / 2.0F);
    f1 = (float)(((FaceCropItem.CropFrame)localObject1).faceWidth / f2);
    paramFloat = (float)(((FaceCropItem.CropFrame)localObject1).noseX / f2 - ((PointF)localObject2).x);
    f2 = (float)(((FaceCropItem.CropFrame)localObject1).noseY / f2 - ((PointF)localObject2).y);
    localObject2 = FaceOffUtil.getFullCoords(paramList, 3.0F);
    paramList = ((List)localObject2).iterator();
    PointF localPointF;
    while (paramList.hasNext())
    {
      localPointF = (PointF)paramList.next();
      localPointF.x = ((float)(localPointF.x / this.mScreenScale));
      localPointF.y = ((float)(localPointF.y / this.mScreenScale));
    }
    float f5 = DISTANCE_OF((PointF)((List)localObject2).get(0), (PointF)((List)localObject2).get(18));
    float f3 = ((PointF)((List)localObject2).get(64)).x;
    float f4 = ((PointF)((List)localObject2).get(64)).y;
    paramList = new ArrayList();
    paramList.add(((List)localObject2).get(99));
    paramList.add(((List)localObject2).get(105));
    paramList.add(((List)localObject2).get(101));
    paramList.add(((List)localObject2).get(103));
    f1 /= f5;
    localObject2 = new Matrix();
    ((Matrix)localObject2).reset();
    ((Matrix)localObject2).postRotate(RADIANS2DEGREES((float)(paramArrayOfFloat[2] - ((FaceCropItem.CropFrame)localObject1).faceAngle)), f3, f4);
    ((Matrix)localObject2).postScale(f1, f1, f3, f4);
    ((Matrix)localObject2).postTranslate(paramFloat - f3, f2 - f4);
    paramArrayOfFloat = new ArrayList();
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localPointF = (PointF)((Iterator)localObject1).next();
      float[] arrayOfFloat = new float[2];
      ((Matrix)localObject2).mapPoints(arrayOfFloat, new float[] { localPointF.x, localPointF.y });
      paramArrayOfFloat.add(new PointF(arrayOfFloat[0], arrayOfFloat[1]));
    }
    int i = 0;
    paramInt = 0;
    while (paramInt < 4)
    {
      localObject1 = (PointF)paramArrayOfFloat.get(paramInt);
      this.attrPositions[i] = (2.0F * ((PointF)localObject1).x / this.width - 1.0F);
      this.attrPositions[(i + 1)] = (2.0F * ((PointF)localObject1).y / this.height - 1.0F);
      localObject1 = (PointF)paramList.get(paramInt);
      this.attrTexCoords[i] = (((PointF)localObject1).x / this.width);
      this.attrTexCoords[(i + 1)] = (((PointF)localObject1).y / this.height);
      i += 2;
      paramInt += 1;
    }
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLE_STRIP);
    setPositions(this.attrPositions);
    setTexCords(this.attrTexCoords);
  }
  
  final float DISTANCE_OF(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  final float RADIANS2DEGREES(float paramFloat)
  {
    return 180.0F * paramFloat / 3.14159F;
  }
  
  public void initParams() {}
  
  public boolean isNeedRender()
  {
    return this.needRender;
  }
  
  public void setNormalFilters(List<NormalVideoFilter> paramList)
  {
    this.normalFilters = paramList;
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    if (this.faceCropItem == null) {}
    int i;
    do
    {
      return;
      this.needRender = true;
      i = 0;
      int j = 0;
      if (this.normalFilters != null)
      {
        Iterator localIterator = this.normalFilters.iterator();
        i = j;
        if (localIterator.hasNext())
        {
          NormalVideoFilter localNormalVideoFilter = (NormalVideoFilter)localIterator.next();
          localNormalVideoFilter.updatePreview(paramList, paramArrayOfFloat, paramMap, paramFloat, paramLong);
          if ((this.needRender) && (localNormalVideoFilter.isRenderReady())) {}
          for (boolean bool = true;; bool = false)
          {
            this.needRender = bool;
            i = localNormalVideoFilter.getLastFrameIndex();
            break;
          }
        }
      }
    } while (!this.needRender);
    updateParams(paramList, paramArrayOfFloat, paramFloat, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceCropFilter
 * JD-Core Version:    0.7.0.1
 */