import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;

public class acpy
  implements View.OnClickListener
{
  public acpy(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.jdField_a_of_type_JavaLangString, 2, "qfilebaserecenttabview del error, tag is null");
      }
      return;
    }
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramView.getTag();
    if (localWeiYunFileInfo != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(null);
      }
      QfileBaseCloudFileTabView.a(this.a).a().a(localWeiYunFileInfo);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(Integer.valueOf(-1));
    paramView.setVisibility(4);
    this.a.setListFooter();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpy
 * JD-Core Version:    0.7.0.1
 */