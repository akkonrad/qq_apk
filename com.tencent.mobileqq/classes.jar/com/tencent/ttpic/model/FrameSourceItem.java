package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.BenchUtil;
import java.util.List;

public abstract class FrameSourceItem
{
  private static final String TAG = FrameSourceItem.class.getSimpleName();
  protected BaseFilter filter;
  
  public FrameSourceItem(BaseFilter paramBaseFilter)
  {
    this.filter = paramBaseFilter;
  }
  
  public abstract void clear();
  
  public void draw(Frame paramFrame, CanvasItem paramCanvasItem, long paramLong)
  {
    BenchUtil.benchStart(getClass().getSimpleName() + "[draw]");
    int i = getTexture(paramCanvasItem, paramLong);
    float[] arrayOfFloat = ActUtil.calPositions(paramCanvasItem.itemRect, getOrigWidth(paramCanvasItem.index), getOrigHeight(paramCanvasItem.index), paramFrame.width, paramFrame.height, paramCanvasItem.itemResizeMode);
    paramCanvasItem = ActUtil.calTexCords(paramCanvasItem.itemRect, getOrigWidth(paramCanvasItem.index), getOrigHeight(paramCanvasItem.index), paramCanvasItem.itemResizeMode);
    this.filter.setPositions(arrayOfFloat);
    this.filter.setTexCords(paramCanvasItem);
    BenchUtil.benchStart(this.filter.getClass().getSimpleName() + "[draw]");
    this.filter.OnDrawFrameGLSL();
    this.filter.renderTexture(i, paramFrame.width, paramFrame.height);
    BenchUtil.benchEnd(this.filter.getClass().getSimpleName() + "[draw]");
    BenchUtil.benchEnd(getClass().getSimpleName() + "[draw]");
  }
  
  public abstract int getOrigHeight(int paramInt);
  
  public abstract int getOrigWidth(int paramInt);
  
  public abstract int getTexture(CanvasItem paramCanvasItem, long paramLong);
  
  public abstract void init();
  
  public abstract void reset();
  
  public void update(Frame paramFrame, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.FrameSourceItem
 * JD-Core Version:    0.7.0.1
 */