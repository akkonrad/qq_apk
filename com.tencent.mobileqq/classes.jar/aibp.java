import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrDownload;
import com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aibp
  extends BroadcastReceiver
{
  public aibp(GestureMgrDownload paramGestureMgrDownload) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if (!"tencent.video.gesturemgr.notify".equals(paramIntent.getAction())) {
        continue;
      }
      int i = paramIntent.getIntExtra("Event_Progress", 0);
      if ((i == 100) || (i < 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.a();
        int j = this.a.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_Int = GestureUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo);
        boolean bool;
        if ((i == 100) && (this.a.jdField_a_of_type_Int != 11))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("QavGesture", 2, String.format("receive notify, lastStatus[%s], progress[%s], mStatusGesture[%s], data[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo }));
          }
          paramIntent = new ArrayList();
        }
        synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
        {
          paramIntent.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
          ??? = paramIntent.iterator();
          while (???.hasNext()) {
            ((GestureMgr.GestureStatusListener)???.next()).a(bool, this.a.b(), this.a.jdField_a_of_type_Int);
          }
          bool = false;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("receive notify, progress[%s]", new Object[] { Integer.valueOf(i) }));
      }
      paramIntent = new ArrayList();
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        paramIntent.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
        ??? = paramIntent.iterator();
        if (!???.hasNext()) {
          continue;
        }
        ((GestureMgr.GestureStatusListener)???.next()).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aibp
 * JD-Core Version:    0.7.0.1
 */