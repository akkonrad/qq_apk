import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ktd
  extends Handler
{
  public ktd(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                return;
                i = paramMessage.arg1;
              } while (PublicAccountAdvertisementActivity.a(this.a) == null);
              PublicAccountAdvertisementActivity.a(this.a).a(i);
              if ((i > 0) && (i < 100))
              {
                PublicAccountAdvertisementActivity.a(this.a).c(true);
                return;
              }
            } while (i != 100);
            PublicAccountAdvertisementActivity.a(this.a).c(false);
            return;
            switch (paramMessage.arg1)
            {
            case 201: 
            case 202: 
            case 203: 
            default: 
              this.a.a(2131438964);
              return;
            case -24: 
              this.a.b(this.a.getString(2131438965));
              return;
            }
            this.a.a(2131438962);
            return;
            this.a.b(this.a.getString(2131438966));
            return;
          } while (PublicAccountAdvertisementActivity.a(this.a) == null);
          VideoCoverFragment localVideoCoverFragment = PublicAccountAdvertisementActivity.a(this.a);
          if (paramMessage.arg1 == 1) {}
          for (;;)
          {
            localVideoCoverFragment.c(bool);
            return;
            bool = false;
          }
        } while (!this.a.isResume());
        paramMessage = this.a.getSupportFragmentManager().beginTransaction();
        PublicAccountAdvertisementActivity.a(this.a, WebpageFragment.a(this.a.getIntent()));
        PublicAccountAdvertisementActivity.a(this.a).a(PublicAccountAdvertisementActivity.a(this.a));
        paramMessage.add(2131365598, PublicAccountAdvertisementActivity.a(this.a));
        paramMessage.commit();
      } while (!ThemeUtil.isInNightMode(this.a.getAppRuntime()));
      paramMessage = this.a.findViewById(2131366983);
    } while (paramMessage == null);
    paramMessage.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ktd
 * JD-Core Version:    0.7.0.1
 */