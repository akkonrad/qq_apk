import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

public class mbi
  implements Runnable
{
  public mbi(VideoFeedsAdapter paramVideoFeedsAdapter, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(Boolean.valueOf(this.jdField_a_of_type_Boolean));
    if (!this.jdField_a_of_type_Boolean)
    {
      VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.k();
    }
    while (VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).c()) {
      return;
    }
    VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbi
 * JD-Core Version:    0.7.0.1
 */