import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class lrn
  implements Runnable
{
  public lrn(ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule).get(this.jdField_a_of_type_JavaLangString) != null) {
      QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams return ahead of time, do not load db or network request, because the userInfo is loading.");
    }
    do
    {
      return;
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
      localObject = ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule).a(this.jdField_a_of_type_JavaLangString);
    } while ((localObject != null) && (((List)localObject).size() > 0));
    Object localObject = new ArrayList();
    ((List)localObject).add(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a((List)localObject, this.jdField_a_of_type_Int, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrn
 * JD-Core Version:    0.7.0.1
 */