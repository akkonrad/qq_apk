import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub;

class egt
  extends IAIOImageProviderCallBack.Stub
{
  egt(egs paramegs) {}
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    this.a.a.runOnUiThread(new egv(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.a.a.runOnUiThread(new egu(this, paramLong, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt)
  {
    this.a.a.runOnUiThread(new egw(this, paramArrayOfAIOImageData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     egt
 * JD-Core Version:    0.7.0.1
 */