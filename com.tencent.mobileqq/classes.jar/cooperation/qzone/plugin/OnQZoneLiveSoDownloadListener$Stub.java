package cooperation.qzone.plugin;

import amwz;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class OnQZoneLiveSoDownloadListener$Stub
  extends Binder
  implements OnQZoneLiveSoDownloadListener
{
  public OnQZoneLiveSoDownloadListener$Stub()
  {
    attachInterface(this, "cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
  }
  
  public static OnQZoneLiveSoDownloadListener a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
    if ((localIInterface != null) && ((localIInterface instanceof OnQZoneLiveSoDownloadListener))) {
      return (OnQZoneLiveSoDownloadListener)localIInterface;
    }
    return new amwz(paramIBinder);
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
      paramParcel2.writeString("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
      return true;
    case 1: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
      a();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
      a(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
      c();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
      b();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
    a(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener.Stub
 * JD-Core Version:    0.7.0.1
 */