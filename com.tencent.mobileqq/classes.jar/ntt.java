import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.qphone.base.util.QLog;

public class ntt
  extends GetRedPointExObserver
{
  public ntt(QQStoryMainController paramQQStoryMainController) {}
  
  protected void a(Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    MessageNotifySegment localMessageNotifySegment;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQStoryMainController", 2, "refresh red point if needed");
      }
      paramObject = ((TroopRedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).a(49);
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "更新小黑条红点:" + TroopRedTouchManager.a(paramObject));
      }
      localMessageNotifySegment = (MessageNotifySegment)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a("MessageNotifySegment");
    } while (localMessageNotifySegment == null);
    localMessageNotifySegment.a(paramObject);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntt
 * JD-Core Version:    0.7.0.1
 */