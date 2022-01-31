package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import jmr;

public abstract class IAVServiceCallback$Stub
  extends Binder
  implements IAVServiceCallback
{
  public IAVServiceCallback$Stub()
  {
    attachInterface(this, "com.tencent.av.service.IAVServiceCallback");
  }
  
  public static IAVServiceCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IAVServiceCallback))) {
      return (IAVServiceCallback)localIInterface;
    }
    return new jmr(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.service.IAVServiceCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceCallback");
    a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.service.IAVServiceCallback.Stub
 * JD-Core Version:    0.7.0.1
 */