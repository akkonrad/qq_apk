package com.tencent.mobileqq.activity.aio.photo;

import android.os.IInterface;

public abstract interface IAIOImageProviderCallBack
  extends IInterface
{
  public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean);
  
  public abstract void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack
 * JD-Core Version:    0.7.0.1
 */