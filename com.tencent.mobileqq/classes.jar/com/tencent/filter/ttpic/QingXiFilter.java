package com.tencent.filter.ttpic;

import com.tencent.filter.Param.TextureResParam;

public class QingXiFilter
  extends GPUImageLookupFilter
{
  public QingXiFilter()
  {
    addParam(new Param.TextureResParam("inputImageTexture2", "sh/qingxi_lf.png", 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.QingXiFilter
 * JD-Core Version:    0.7.0.1
 */