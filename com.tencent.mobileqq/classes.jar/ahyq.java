import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ahyq
  implements Runnable
{
  public ahyq(PtvTemplateManager paramPtvTemplateManager) {}
  
  public void run()
  {
    if (PtvTemplateManager.b == null) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = PtvTemplateManager.b.listFiles();
    } while ((arrayOfFile == null) || (arrayOfFile.length == 0));
    int k = arrayOfFile.length;
    int i = 0;
    label32:
    File localFile;
    if (i < k)
    {
      localFile = arrayOfFile[i];
      if ((localFile != null) && (localFile.isFile())) {
        break label63;
      }
    }
    label63:
    label208:
    for (;;)
    {
      i += 1;
      break label32;
      break;
      Object localObject = localFile.getName();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).contains(".")))
      {
        localObject = this.a.a.doodleInfos.iterator();
        PtvTemplateManager.DoodleInfo localDoodleInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localDoodleInfo = (PtvTemplateManager.DoodleInfo)((Iterator)localObject).next();
        } while ((localDoodleInfo == null) || (TextUtils.isEmpty(localDoodleInfo.doodleName)) || (!localFile.getName().equalsIgnoreCase(localDoodleInfo.doodleName)));
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            break label208;
          }
          localFile.deleteOnExit();
          new File(PtvTemplateManager.c + localFile.getName()).deleteOnExit();
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahyq
 * JD-Core Version:    0.7.0.1
 */