package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import gim;

public class PicTypeNormal
  extends PicType
{
  PicTypeNormal(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected PicQuality a()
  {
    switch (this.a.g)
    {
    default: 
      return null;
    case 0: 
    case 1: 
      return new gim(this, this);
    }
    return new PicQualityOriginal(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeNormal
 * JD-Core Version:    0.7.0.1
 */