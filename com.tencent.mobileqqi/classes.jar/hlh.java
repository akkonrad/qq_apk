import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class hlh
  extends Handler
{
  public hlh(QQMapView paramQQMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint;
    if ((paramMessage != null) && (paramMessage.obj != null) && (this.a.a != null)) {
      localGeoPoint = (GeoPoint)paramMessage.obj;
    }
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 0: 
      this.a.a.b(localGeoPoint);
      return;
    }
    this.a.a.c(localGeoPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hlh
 * JD-Core Version:    0.7.0.1
 */