import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkCache;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.qphone.base.util.QLog;

public class lfv
  implements View.OnTouchListener
{
  public lfv(ReadInJoyArkCache paramReadInJoyArkCache, BaseArticleInfo paramBaseArticleInfo, ArkAppContainer paramArkAppContainer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArkCache", 2, "click ArkAppView.");
      }
      ReadInJoyArkCache.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyArkReadInJoyArkCache, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.onTouch(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfv
 * JD-Core Version:    0.7.0.1
 */