import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanelSoundWaveView;
import com.tencent.av.ui.QavPanelWave;
import java.util.Iterator;
import java.util.List;
import mqq.app.BaseActivity;

public class jzo
  implements Runnable
{
  public jzo(QavPanelSoundWaveView paramQavPanelSoundWaveView) {}
  
  public void run()
  {
    if (this.a.getVisibility() != 0)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      return;
    }
    Object localObject;
    float f;
    int j;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      localObject = this.a;
      ((QavPanelSoundWaveView)localObject).c += -this.a.jdField_a_of_type_Float * 0.00048F;
      localObject = this.a.getContext();
      if (!(localObject instanceof BaseActivity)) {
        break label330;
      }
      localObject = ((BaseActivity)localObject).getAppRuntime();
      if (!(localObject instanceof VideoAppInterface)) {
        break label330;
      }
      localObject = ((VideoAppInterface)localObject).a();
      f = ((VideoController)localObject).i() * 0.05F;
      if ((((VideoController)localObject).a().d != 3) && (!((VideoController)localObject).a().f())) {
        break label325;
      }
      j = 1;
    }
    for (;;)
    {
      if ((j != 0) && (!this.a.jdField_a_of_type_Boolean))
      {
        this.a.c = 0.0F;
        f = 0.0F;
      }
      for (;;)
      {
        localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
        int i = 1;
        label190:
        if (((Iterator)localObject).hasNext())
        {
          QavPanelWave localQavPanelWave = (QavPanelWave)((Iterator)localObject).next();
          localQavPanelWave.a(this.a.c, f);
          if (i == 0) {
            break label319;
          }
          if (Float.compare(localQavPanelWave.d, 0.0F) == 0) {
            i = 1;
          }
        }
        label319:
        for (;;)
        {
          break label190;
          localObject = this.a;
          ((QavPanelSoundWaveView)localObject).c += -this.a.jdField_a_of_type_Float * 0.00067F;
          break;
          i = 0;
          continue;
          if ((j == 0) || (i == 0)) {
            this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 66L);
          }
          this.a.invalidate();
          return;
        }
      }
      label325:
      j = 0;
      continue;
      label330:
      j = 0;
      f = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzo
 * JD-Core Version:    0.7.0.1
 */