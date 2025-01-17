package com.tencent.mobileqq.ar.aidl;

import aaes;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IArGlobalConfigManager$Stub
  extends Binder
  implements IArGlobalConfigManager
{
  public IArGlobalConfigManager$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
  }
  
  public static IArGlobalConfigManager a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
    if ((localIInterface != null) && ((localIInterface instanceof IArGlobalConfigManager))) {
      return (IArGlobalConfigManager)localIInterface;
    }
    return new aaes(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
    paramParcel1 = a();
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager.Stub
 * JD-Core Version:    0.7.0.1
 */