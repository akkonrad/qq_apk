import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

public class krt
  extends PublicAccountObserver
{
  public krt(AccountDetailActivity paramAccountDetailActivity) {}
  
  void a()
  {
    if (this.a.jdField_l_of_type_Boolean) {
      this.a.D();
    }
    this.a.jdField_l_of_type_Boolean = true;
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    super.a(paramInt, paramPublicAccountInfo);
    a();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    super.a(paramBoolean, paramInt);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter == null) {
      return;
    }
    this.a.t = true;
    if (paramInt == 0)
    {
      AccountDetailDynamicInfo localAccountDetailDynamicInfo = AccountDetailDynamicDataManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.a.d);
      if (localAccountDetailDynamicInfo != null)
      {
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a(localAccountDetailDynamicInfo.b(), localAccountDetailDynamicInfo.a);
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a(localAccountDetailDynamicInfo.b());
      }
    }
    if (paramBoolean) {
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a() == 0)
      {
        paramBoolean = bool1;
        if (paramBoolean) {
          this.a.u();
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.b(paramBoolean);
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "onDynamicListGet: --hasMoreData=" + paramBoolean);
          bool1 = paramBoolean;
        }
        label172:
        if (paramInt != 1) {
          break label246;
        }
      }
    }
    for (this.a.jdField_l_of_type_Int = AccountDetailActivity.j;; this.a.jdField_l_of_type_Int = AccountDetailActivity.k) {
      label246:
      do
      {
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b(this.a.jdField_l_of_type_Int);
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.notifyDataSetChanged();
        return;
        paramBoolean = true;
        break;
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.notifyDataSetChanged();
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.b();
        bool1 = bool2;
        break label172;
      } while ((paramInt != 4) && ((paramInt != 0) || (bool1)));
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     krt
 * JD-Core Version:    0.7.0.1
 */