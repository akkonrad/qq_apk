import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

public class xdv
  implements Runnable
{
  public xdv(QzoneHbFragment paramQzoneHbFragment, String paramString) {}
  
  public void run()
  {
    Object localObject1 = HbThemeConfigManager.a().a();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(new String(Base64.decode(((String)localObject1).toString(), 0)));
        if (localObject1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment.a((JSONObject)localObject1);
          return;
        }
      }
      catch (Exception localException1)
      {
        HbThemeConfigManager.a().a("");
        localException1.printStackTrace();
      }
      Object localObject2 = new File(this.jdField_a_of_type_JavaLangString);
      if (!((File)localObject2).exists()) {
        continue;
      }
      for (;;)
      {
        try
        {
          localObject4 = new byte[1024];
          StringBuilder localStringBuilder = new StringBuilder();
          localObject2 = new FileInputStream((File)localObject2);
          try
          {
            int i = ((FileInputStream)localObject2).read((byte[])localObject4);
            if (i > 0)
            {
              localStringBuilder.append(new String((byte[])localObject4, 0, i));
              continue;
              if (localObject2 == null) {}
            }
          }
          catch (Exception localException2) {}
        }
        catch (Exception localException3)
        {
          Object localObject4;
          Object localObject3 = null;
          continue;
        }
        try
        {
          ((FileInputStream)localObject2).close();
          localException2.printStackTrace();
          return;
          ((FileInputStream)localObject2).close();
          localObject4 = new JSONObject(new String(Base64.decode(localException2.toString(), 0)));
          if (localObject4 == null) {
            break;
          }
          HbThemeConfigManager.a().a(localException2.toString());
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment.a((JSONObject)localObject4);
          return;
        }
        catch (Exception localException4)
        {
          localException4.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdv
 * JD-Core Version:    0.7.0.1
 */