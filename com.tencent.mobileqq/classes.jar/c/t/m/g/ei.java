package c.t.m.g;

import org.json.JSONException;
import org.json.JSONObject;

final class ei
{
  public double a;
  public double b;
  public double c;
  public float d;
  public String e;
  public String f;
  
  ei() {}
  
  public ei(JSONObject paramJSONObject)
    throws JSONException
  {
    try
    {
      this.a = paramJSONObject.getDouble("latitude");
      this.b = paramJSONObject.getDouble("longitude");
      this.c = paramJSONObject.getDouble("altitude");
      this.d = ((float)paramJSONObject.getDouble("accuracy"));
      this.e = paramJSONObject.optString("name");
      this.f = paramJSONObject.optString("addr");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      f.a.a("TencentJson", "json error", paramJSONObject);
      throw paramJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ei
 * JD-Core Version:    0.7.0.1
 */