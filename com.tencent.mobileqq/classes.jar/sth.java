import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.app.CardHandler.NowOnliveGallayCallback;
import com.tencent.mobileqq.data.NowShowVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary.RspBody.PhotoInfo;

public class sth
  extends CardHandler.NowOnliveGallayCallback
{
  public sth(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "onGetNowOnliveGallay errorCode:" + paramInt);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "onGetNowOnliveGallay size:" + paramList.size());
    }
    FriendProfileMoreInfoActivity.a(this.a).clear();
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      Object localObject = (NowLiveGallary.RspBody.PhotoInfo)paramList.get(paramInt);
      localObject = new NowShowVideoInfo(((NowLiveGallary.RspBody.PhotoInfo)localObject).cover.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject).video.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject).timestamp.get());
      FriendProfileMoreInfoActivity.a(this.a).add(localObject);
      paramInt += 1;
    }
    this.a.a.sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sth
 * JD-Core Version:    0.7.0.1
 */