import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.intervideo.now.NowProxy.ListNameData;
import com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public final class agat
  implements Runnable
{
  public agat(QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    if (AppUtil.a("com.tencent.now"))
    {
      new NowDataReporter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b("10888", "auto_enter_answer", "1");
      QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom----NOW APP is Exist, will Launch It!");
      localObject1 = new Intent("android.intent.action.VIEW", Uri.parse("tnow://openpage/enterroom?roomid=" + this.jdField_a_of_type_Long + "&roomtype=8001&source=10888&anchorId=" + NowAnswerPreloadManager.a() + "&timestamp=" + System.currentTimeMillis()));
      ((Intent)localObject1).setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity((Intent)localObject1);
      return;
    }
    new NowDataReporter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b("10888", "auto_enter_answer", "2");
    QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom----NOW APP is not Exist, will Launch Plugin!");
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject1 = (NowProxy)((QQAppInterface)localObject1).getManager(181);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("roomtype", "8001");
    Object localObject3 = new ArrayList();
    ((ArrayList)localObject3).add("");
    localObject3 = new NowProxy.ListNameData((ArrayList)localObject3, 0);
    NowFromData localNowFromData = new NowFromData();
    localNowFromData.a = "10888";
    localNowFromData.b = "10000";
    ((NowProxy)localObject1).a((NowProxy.ListNameData)localObject3, NowAnswerPreloadManager.b(), localNowFromData, 2, (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agat
 * JD-Core Version:    0.7.0.1
 */