package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import java.util.List;

public class CameraActItem
  extends FrameSourceItem
{
  private Frame cameraFrame;
  
  public CameraActItem(BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
  }
  
  public void clear() {}
  
  public int getOrigHeight(int paramInt)
  {
    return this.cameraFrame.height;
  }
  
  public int getOrigWidth(int paramInt)
  {
    return this.cameraFrame.width;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return this.cameraFrame.getTextureId();
  }
  
  public void init() {}
  
  public void reset() {}
  
  public void update(Frame paramFrame, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, int paramInt)
  {
    super.update(paramFrame, paramLong, paramList, paramList1, paramDouble, paramInt);
    this.cameraFrame = paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.CameraActItem
 * JD-Core Version:    0.7.0.1
 */