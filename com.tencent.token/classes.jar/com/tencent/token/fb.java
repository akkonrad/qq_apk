package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class fb
  extends bm
{
  private long c;
  private String d;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("mobile_code", this.d);
      localObject = s.b(((JSONObject)localObject).toString().getBytes());
      if (localObject == null)
      {
        this.a.a(10000, null, null);
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      this.a.a(10000, null, null);
      return null;
    }
    finally
    {
      if (s.b(((JSONObject)localObject).toString().getBytes()) == null)
      {
        this.a.a(10000, null, null);
        return null;
      }
    }
    String str3 = "?uin=" + this.c + "&aq_base_sid=" + str2 + "&data=" + (String)localObject;
    return b.c() + "/cn/mbtoken3/mbtoken3_mbop_verify_mobile_code" + str3;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((String)paramfs.c.get("param.mbmobile.vrycode"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fb
 * JD-Core Version:    0.7.0.1
 */