package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.TextureResParam;
import com.tencent.filter.art.BaibianFilter;
import java.util.HashMap;
import java.util.Map;

public class WeiZhiDaoFilters
{
  public static class KaFeiFilter
    extends BaseFilter
  {
    public KaFeiFilter()
    {
      super();
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      BaibianFilter localBaibianFilter = new BaibianFilter(GLSLRender.FILTER_SHADER_NONE, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
      Object localObject = new HashMap();
      ((Map)localObject).put("intensity", Float.valueOf(0.65F));
      localBaibianFilter.setParameterDic((Map)localObject);
      setNextFilter(localBaibianFilter, null);
      localObject = new GPUImageLookupFilter();
      ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "weizhidao/kafei_lf.png", 33986));
      localBaibianFilter.setNextFilter((BaseFilter)localObject, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public static class MeiWeiFilter
    extends BaseFilter
  {
    public MeiWeiFilter()
    {
      super();
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      BaibianFilter localBaibianFilter = new BaibianFilter(GLSLRender.FILTER_SHADER_NONE, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
      Object localObject = new HashMap();
      ((Map)localObject).put("intensity", Float.valueOf(0.65F));
      localBaibianFilter.setParameterDic((Map)localObject);
      setNextFilter(localBaibianFilter, null);
      localObject = new GPUImageLookupFilter();
      ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "weizhidao/meiwei_lf.png", 33986));
      localBaibianFilter.setNextFilter((BaseFilter)localObject, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public static class TianPinFilter
    extends BaseFilter
  {
    public TianPinFilter()
    {
      super();
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      BaibianFilter localBaibianFilter = new BaibianFilter(GLSLRender.FILTER_SHADER_NONE, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
      Object localObject = new HashMap();
      ((Map)localObject).put("intensity", Float.valueOf(0.65F));
      localBaibianFilter.setParameterDic((Map)localObject);
      setNextFilter(localBaibianFilter, null);
      localObject = new GPUImageLookupFilter();
      ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "weizhidao/tianpin_lf.png", 33986));
      localBaibianFilter.setNextFilter((BaseFilter)localObject, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public static class XiCanFilter
    extends BaseFilter
  {
    public XiCanFilter()
    {
      super();
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      BaibianFilter localBaibianFilter = new BaibianFilter(GLSLRender.FILTER_SHADER_NONE, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
      Object localObject = new HashMap();
      ((Map)localObject).put("intensity", Float.valueOf(0.65F));
      localBaibianFilter.setParameterDic((Map)localObject);
      setNextFilter(localBaibianFilter, null);
      localObject = new GPUImageLookupFilter();
      ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "weizhidao/xican_lf.png", 33986));
      localBaibianFilter.setNextFilter((BaseFilter)localObject, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public static class XinXianFilter
    extends BaseFilter
  {
    public XinXianFilter()
    {
      super();
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      BaibianFilter localBaibianFilter = new BaibianFilter(GLSLRender.FILTER_SHADER_NONE, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
      Object localObject = new HashMap();
      ((Map)localObject).put("intensity", Float.valueOf(0.65F));
      localBaibianFilter.setParameterDic((Map)localObject);
      setNextFilter(localBaibianFilter, null);
      localObject = new GPUImageLookupFilter();
      ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "weizhidao/xinxian_lf.png", 33986));
      localBaibianFilter.setNextFilter((BaseFilter)localObject, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.WeiZhiDaoFilters
 * JD-Core Version:    0.7.0.1
 */