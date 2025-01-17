package com.tencent.av.gvideo;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.IAVServiceCallback.Stub;
import jjk;

public abstract class IGVServiceForQQ$Stub
  extends Binder
  implements IGVServiceForQQ
{
  public IGVServiceForQQ$Stub()
  {
    attachInterface(this, "com.tencent.av.gvideo.IGVServiceForQQ");
  }
  
  public static IGVServiceForQQ a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.gvideo.IGVServiceForQQ");
    if ((localIInterface != null) && ((localIInterface instanceof IGVServiceForQQ))) {
      return (IGVServiceForQQ)localIInterface;
    }
    return new jjk(paramIBinder);
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
      paramParcel2.writeString("com.tencent.av.gvideo.IGVServiceForQQ");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      a(IAVServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      a(paramParcel1.createByteArray());
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label168;
        }
      }
      for (paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        bool = false;
        break;
      }
    case 4: 
      label168:
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      paramInt1 = a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.gvideo.IGVServiceForQQ.Stub
 * JD-Core Version:    0.7.0.1
 */