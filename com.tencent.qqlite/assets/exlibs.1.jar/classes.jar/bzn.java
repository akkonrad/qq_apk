import android.view.View;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;

public class bzn
  implements AdapterView.OnItemClickListener
{
  public bzn(AIOImageListScene paramAIOImageListScene) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    AIOImageInfo localAIOImageInfo = AIOImageListScene.a(this.a).a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + AIOImageListScene.a(this.a).q() + " LastVisiblePosition " + AIOImageListScene.b(this.a).r());
    }
    int i;
    if (AIOImageListScene.a(this.a)) {
      if (localAIOImageInfo.b() == 1)
      {
        i = 1;
        AIOImageListScene localAIOImageListScene = this.a;
        if (i != 0) {
          break label248;
        }
        label116:
        AIOImageListScene.a(localAIOImageListScene, localAIOImageInfo, bool);
        if (!AIOImageListScene.a(this.a, paramView, localAIOImageInfo)) {
          ((AbstractImageAdapter)paramAdapterView.a()).notifyDataSetChanged();
        }
        AIOImageListScene.b(this.a);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + AIOImageListScene.e(this.a).q() + " LastVisiblePosition " + AIOImageListScene.f(this.a).r() + " SelectedIndex = " + AIOImageListScene.a(this.a).b());
      }
      return;
      i = 0;
      break;
      label248:
      bool = false;
      break label116;
      AIOImageListScene.a(this.a).a(paramInt);
      AIOImageListScene.a(this.a).b(AIOImageListScene.c(this.a).q());
      AIOImageListScene.a(this.a).c(AIOImageListScene.d(this.a).r());
      this.a.n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzn
 * JD-Core Version:    0.7.0.1
 */