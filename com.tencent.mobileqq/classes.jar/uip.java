import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.WebSecurityPlugin;
import java.util.HashMap;
import java.util.Map;

public final class uip
  implements Runnable
{
  public uip(String paramString, Intent paramIntent, Context paramContext) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = WebAccelerator.a();
    int i;
    if (WebAccelerator.c(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = ((WebAccelerator)localObject2).a(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", (String)localObject1);
        i = 1;
      }
    }
    for (;;)
    {
      if ((!WebSecurityPlugin.a(this.jdField_a_of_type_AndroidContentContext)) && (((WebAccelerator)localObject2).a((String)localObject1))) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("key_isReadModeEnabled", false);
      }
      for (int j = 1;; j = 0)
      {
        localObject1 = (Long)WebAccelerator.a((WebAccelerator)localObject2).remove(this.jdField_a_of_type_JavaLangString);
        if ((localObject1 != null) && (SystemClock.uptimeMillis() - ((Long)localObject1).longValue() < 180000L))
        {
          ((WebAccelerator)localObject2).a("bank_download_key");
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("count", "1");
          StatisticCollector.a(BaseApplication.getContext()).a(null, "AIOWebPreDownloadHit", false, 0L, 0L, (HashMap)localObject1, "", false);
        }
        if ((j != 0) || (i != 0))
        {
          ((WebAccelerator)localObject2).a("bankSize");
          localObject1 = WebAccelerator.a().a();
          localObject2 = ((SharedPreferences)localObject1).edit();
          if (i != 0) {
            ((SharedPreferences.Editor)localObject2).putInt("hit_shortLink", ((SharedPreferences)localObject1).getInt("hit_shortLink", 0) + 1);
          }
          if (j != 0) {
            ((SharedPreferences.Editor)localObject2).putInt("hit_safeCheck", ((SharedPreferences)localObject1).getInt("hit_safeCheck", 0) + 1);
          }
          ((SharedPreferences.Editor)localObject2).commit();
        }
        if (!WebAccelerator.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentIntent)) {
          this.jdField_a_of_type_AndroidContentContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
        }
        return;
        localObject1 = this.jdField_a_of_type_JavaLangString;
        i = 0;
        break;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uip
 * JD-Core Version:    0.7.0.1
 */