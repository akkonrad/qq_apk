import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

public class akzw
  implements Runnable
{
  public akzw(AuthorityActivity paramAuthorityActivity, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap3 = null;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources(), 2130839132);
      localBitmap3 = AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, localBitmap1, 63, 63);
      if (localBitmap1 != null) {
        localBitmap1.recycle();
      }
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.runOnUiThread(new akzx(this, localBitmap3));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Bitmap localBitmap2 = localBitmap3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorityActivity", 2, "initUI decodeResource has OutOfMemoryError!");
          localBitmap2 = localBitmap3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akzw
 * JD-Core Version:    0.7.0.1
 */