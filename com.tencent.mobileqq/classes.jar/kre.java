import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import org.json.JSONObject;

public class kre
  implements HttpWebCgiAsyncTask.Callback
{
  public kre(AccountDetailGroupListContainer paramAccountDetailGroupListContainer) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    AccountDetailGroupListContainer.a(this.a, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kre
 * JD-Core Version:    0.7.0.1
 */