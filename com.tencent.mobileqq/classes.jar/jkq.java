import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class jkq
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  public int b;
  String b;
  String c;
  public String d;
  String e = "client";
  
  public jkq(RandomWebProtocol paramRandomWebProtocol)
  {
    this.jdField_a_of_type_Int = 0;
    String str = RandomWebProtocol.a(paramRandomWebProtocol).getAccount();
    paramRandomWebProtocol = (TicketManager)RandomWebProtocol.a(paramRandomWebProtocol).getManager(2);
    if (paramRandomWebProtocol == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = "7.6.3";
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(str);
      this.jdField_b_of_type_JavaLangString = paramRandomWebProtocol.getSkey(str);
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_OrgJsonJSONObject = null;
      this.c = null;
      this.d = null;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] init Req error: failed parse self_uin: " + str);
        }
      }
    }
  }
  
  jkq(RandomWebProtocol paramRandomWebProtocol, jkq paramjkq)
  {
    this.jdField_a_of_type_Int = paramjkq.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramjkq.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramjkq.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Long = paramjkq.jdField_a_of_type_Long;
    this.jdField_b_of_type_JavaLangString = paramjkq.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_Int = paramjkq.jdField_b_of_type_Int;
    this.jdField_a_of_type_OrgJsonJSONObject = paramjkq.jdField_a_of_type_OrgJsonJSONObject;
    this.c = paramjkq.c;
    this.d = paramjkq.d;
    this.e = paramjkq.e;
  }
  
  String a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return "";
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("reqtype", this.jdField_a_of_type_Int).put("qqversion", this.jdField_a_of_type_JavaLangString).put("isdebug", this.jdField_a_of_type_Boolean).put("self_uin", this.jdField_a_of_type_Long).put("self_skey", this.jdField_b_of_type_JavaLangString).put("self_gender", this.jdField_b_of_type_Int).put("reqbody", this.jdField_a_of_type_OrgJsonJSONObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkq
 * JD-Core Version:    0.7.0.1
 */