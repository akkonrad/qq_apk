import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class akle
  implements MediaPlayer.OnErrorListener
{
  public akle(int paramInt, VipFunCallMediaListener paramVipFunCallMediaListener, VideoView paramVideoView, boolean paramBoolean) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "playing onError what=" + paramInt1 + ", extra=" + paramInt2 + ", funcallid=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener.a(paramInt1, paramInt2, this.jdField_a_of_type_Int);
    }
    paramMediaPlayer = VipFunCallManager.a(null, this.jdField_a_of_type_Int, 7, null);
    if (TextUtils.isEmpty(paramMediaPlayer)) {}
    label159:
    RelativeLayout localRelativeLayout;
    do
    {
      for (;;)
      {
        return true;
        if (new File(paramMediaPlayer).exists())
        {
          paramMediaPlayer = BitmapManager.a(paramMediaPlayer);
          if (paramMediaPlayer != null) {}
          for (paramMediaPlayer = new BitmapDrawable(paramMediaPlayer); (paramMediaPlayer != null) && (this.jdField_a_of_type_AndroidWidgetVideoView != null); paramMediaPlayer = null)
          {
            if (this.jdField_a_of_type_Boolean != true) {
              break label159;
            }
            this.jdField_a_of_type_AndroidWidgetVideoView.setBackgroundDrawable(paramMediaPlayer);
            return true;
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetVideoView.setVisibility(8);
      localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetVideoView.getParent();
    } while (localRelativeLayout == null);
    localRelativeLayout.setBackgroundDrawable(paramMediaPlayer);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akle
 * JD-Core Version:    0.7.0.1
 */