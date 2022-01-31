import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class aahw
  implements INetEngine.IBreakDownFix
{
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
    localHttpNetReq.jdField_a_of_type_Long += paramNetResp.c;
    paramNetResp.c = 0L;
    paramNetResp = "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-";
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
    paramNetResp = localHttpNetReq.jdField_a_of_type_JavaLangString;
    if (paramNetResp.contains("range="))
    {
      paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
      localHttpNetReq.jdField_a_of_type_JavaLangString = (paramNetResp + "range=" + localHttpNetReq.jdField_a_of_type_Long);
    }
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "IBreakDownFix. url = " + ((HttpNetReq)paramNetReq).jdField_a_of_type_JavaLangString + ", offset=" + localHttpNetReq.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahw
 * JD-Core Version:    0.7.0.1
 */