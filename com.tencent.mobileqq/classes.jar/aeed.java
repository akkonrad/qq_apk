import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.qphone.base.util.QLog;

public class aeed
  implements SoundPool.OnLoadCompleteListener
{
  public aeed(SoundPoolUtil paramSoundPoolUtil, int paramInt, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a.play(paramInt1, 1.0F, 1.0F, 0, this.jdField_a_of_type_Int, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeed
 * JD-Core Version:    0.7.0.1
 */