package cooperation.qlink;

import amna;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IQlinkService$Stub
  extends Binder
  implements IQlinkService
{
  public IQlinkService$Stub()
  {
    attachInterface(this, "cooperation.qlink.IQlinkService");
  }
  
  public static IQlinkService a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qlink.IQlinkService");
    if ((localIInterface != null) && ((localIInterface instanceof IQlinkService))) {
      return (IQlinkService)localIInterface;
    }
    return new amna(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("cooperation.qlink.IQlinkService");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qlink.IQlinkService");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (SendMsg)SendMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.IQlinkService.Stub
 * JD-Core Version:    0.7.0.1
 */