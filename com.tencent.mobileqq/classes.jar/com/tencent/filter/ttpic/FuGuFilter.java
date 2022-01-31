package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class FuGuFilter
  extends BaseFilter
{
  public FuGuFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_SCREEN_BLEND);
    localBaseFilter2.addParam(new Param.FloatsParam("color2", new float[] { 0.1803922F, 0.1490196F, 0.07450981F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatParam("transparency", 1.0F));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter1.addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.02352941F, 0.1058824F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new Param.IntParam("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_OVERLAY_BLEND2_SHADER);
    localBaseFilter2.addParam(new Param.FloatsParam("color2", new float[] { 0.3960784F, 0.254902F, 0.1843137F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatParam("transparency", 0.87F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter1.addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.05490196F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.05490196F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.03137255F, 0.05490196F, -0.2431373F }));
    localBaseFilter1.addParam(new Param.IntParam("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    localBaseFilter2.addParam(new Param.FloatParam("contrast", 1.0F));
    localBaseFilter2.addParam(new Param.FloatParam("saturation", 0.6F));
    localBaseFilter2.addParam(new Param.FloatParam("brightness", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/fugu_curve.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_HSVADJUSTER_SHADER);
    localBaseFilter2.addParam(new Param.FloatParam("inputH", 1.0F));
    localBaseFilter2.addParam(new Param.FloatParam("inputS", 1.0F));
    localBaseFilter2.addParam(new Param.FloatParam("inputV", 0.974F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_DARKEN_BLEND);
    localBaseFilter1.addParam(new Param.FloatsParam("color2", new float[] { 0.9490196F, 0.9098039F, 0.8039216F, 1.0F }));
    localBaseFilter1.addParam(new Param.FloatParam("transparency", 0.5F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.FuGuFilter
 * JD-Core Version:    0.7.0.1
 */