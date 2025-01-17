import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.IconReqDetails;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.portal.RedPacketServlet;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class agmv
  extends BroadcastReceiver
{
  private agmv(PortalManager paramPortalManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 1;
    int i = 1;
    int k = paramIntent.getIntExtra("portal_type_key", -1);
    int m = paramIntent.getIntExtra("bc_seq", -1);
    paramContext = paramIntent.getStringExtra("portal_agrs");
    if (QLog.isColorLevel()) {
      QLog.i("PortalManager", 2, "PortalSwictherReceiver, " + paramIntent.getExtras());
    }
    Object localObject;
    int n;
    switch (k)
    {
    default: 
    case 1010: 
    case 1011: 
      do
      {
        return;
        try
        {
          paramContext = new JSONObject();
          paramIntent = paramContext.put("errorCode", 0);
          if (this.a.a() != -1)
          {
            paramIntent.put("result", i);
            PortalManager.a(this.a, k, paramContext.toString(), m);
            return;
          }
        }
        catch (JSONException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            try
            {
              paramContext = new JSONObject();
              paramContext.put("errorCode", -1);
              PortalManager.a(this.a, k, paramContext.toString(), m);
              return;
            }
            catch (JSONException paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
            i = 0;
          }
          if (!TextUtils.isEmpty(paramContext)) {
            break;
          }
          PortalManager.a(this.a, k, m, null, -1, "params is null");
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e("PortalManager", 2, "", paramContext);
      return;
      paramContext = new JSONObject(paramContext);
      paramIntent = paramContext.getString("key");
      localObject = PortalUtils.b(paramIntent);
      localObject = ContactUtils.m(PortalManager.a(this.a), (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext.put("errorCode", 0).put("result", localObject).put("key", paramIntent);
      }
      for (;;)
      {
        PortalManager.a(this.a, k, paramContext.toString(), m);
        return;
        paramContext.put("errorCode", -1).put("key", paramIntent);
      }
    case 1008: 
      if (TextUtils.isEmpty(paramContext))
      {
        PortalManager.a(this.a, k, m, null, -1, "params is null");
        return;
      }
      paramContext = new JSONObject(paramContext);
      int i1 = paramContext.getInt("type");
      n = paramContext.getInt("count");
      i = j;
      switch (i1)
      {
      }
      break;
    }
    for (;;)
    {
      RedPacketServlet.a(PortalManager.a(this.a), i, n, k, m);
      return;
      if (TextUtils.isEmpty(paramContext))
      {
        PortalManager.a(this.a, k, m, null, -1, "params is null");
        return;
      }
      paramContext = new JSONObject(paramContext).getString("key");
      if (!TextUtils.isEmpty(paramContext))
      {
        paramIntent = PortalUtils.b(paramContext);
        localObject = PortalManager.a(this.a).a(paramIntent, false);
        if (localObject != null)
        {
          paramIntent = PortalUtils.a((Bitmap)localObject);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("errorCode", 0);
          ((JSONObject)localObject).put("key", paramContext);
          ((JSONObject)localObject).put("result", paramIntent);
          PortalManager.a(this.a, k, ((JSONObject)localObject).toString(), m);
          return;
        }
        localObject = new PortalManager.IconReqDetails();
        ((PortalManager.IconReqDetails)localObject).jdField_a_of_type_JavaLangString = paramContext;
        ((PortalManager.IconReqDetails)localObject).b = k;
        ((PortalManager.IconReqDetails)localObject).jdField_a_of_type_Int = m;
        this.a.a.put(paramIntent, localObject);
        if ((PortalManager.a(this.a).a(paramIntent, true) != null) || (!QLog.isColorLevel())) {
          break;
        }
        paramIntent = ContactUtils.l(PortalManager.a(this.a), String.valueOf(paramIntent));
        QLog.d("PortalManager", 2, "昵称为" + paramIntent + "，本地不存在头像，key = " + paramContext);
        return;
      }
      PortalManager.a(this.a, k, m, null, -1, "key is null");
      return;
      i = j;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmv
 * JD-Core Version:    0.7.0.1
 */