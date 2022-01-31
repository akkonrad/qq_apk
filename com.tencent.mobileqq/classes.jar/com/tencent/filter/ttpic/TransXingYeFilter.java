package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.TextureResParam;

public class TransXingYeFilter
  extends BaseFilter
{
  public TransXingYeFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    GPUImageLookupFilter localGPUImageLookupFilter = new GPUImageLookupFilter();
    localGPUImageLookupFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/rixi2_lf.png", 33986));
    setNextFilter(localGPUImageLookupFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.TransXingYeFilter
 * JD-Core Version:    0.7.0.1
 */