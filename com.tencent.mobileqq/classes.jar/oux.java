import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import com.tencent.biz.qrcode.ipc.VoiceScan;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

public class oux
  implements Runnable
{
  public oux(VoiceScan paramVoiceScan) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(VoiceScan.a(this.a).getString(2131433410));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(VoiceScan.a(this.a).getResources().getColor(2131493062), VoiceScan.a(this.a).getResources().getColor(2131493063)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    VoiceScan.a(this.a, DialogUtil.a(VoiceScan.a(this.a), VoiceScan.a(this.a).getString(2131433409), localSpannableString, 0, 2131433697, null, null, new ouy(this)));
    VoiceScan.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oux
 * JD-Core Version:    0.7.0.1
 */