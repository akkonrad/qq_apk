import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IAVServiceCallback;

public class jmr
  implements IAVServiceCallback
{
  private IBinder a;
  
  public jmr(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceCallback");
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      localParcel.writeInt(paramInt3);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmr
 * JD-Core Version:    0.7.0.1
 */