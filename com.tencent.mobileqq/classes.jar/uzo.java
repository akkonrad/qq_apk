import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;

public class uzo
  implements FileManagerUtil.TipsClickedInterface
{
  public uzo(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString) {}
  
  public void a(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, ChatHistoryFileActivity.class);
    paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    paramView.putExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    FileManagerReporter.a("0X800506C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uzo
 * JD-Core Version:    0.7.0.1
 */