import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.DLBaseFileViewActivity.DLFileState;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class ef
  implements DialogInterface.OnClickListener
{
  ef(ee paramee, DataLineMsgRecord paramDataLineMsgRecord, DatalineFilesAdapter.ItemHolder paramItemHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = DatalineFilesAdapter.a(this.jdField_a_of_type_Ee.a).a().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (paramDialogInterface != null) {
      paramDialogInterface.setPaused(false);
    }
    if (this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder.a.a != DLBaseFileViewActivity.DLFileState.SENDFAILED)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.fileMsgStatus == 1L) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)) {
        DataLineReportUtil.e(DatalineFilesAdapter.a(this.jdField_a_of_type_Ee.a));
      }
      DatalineFilesAdapter.a(this.jdField_a_of_type_Ee.a, this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      return;
    }
    DatalineFilesAdapter.b(this.jdField_a_of_type_Ee.a, this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ef
 * JD-Core Version:    0.7.0.1
 */