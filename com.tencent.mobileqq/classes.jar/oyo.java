import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.biz.troop.file.ZipFilesListAdapter.FilesViewHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oyo
  implements View.OnClickListener
{
  public oyo(ZipFilesListAdapter paramZipFilesListAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject3 = (ZipFilesListAdapter.FilesViewHolder)paramView.getTag();
    if (((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_Boolean)
    {
      paramView = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, TroopFileZipPreviewActivity.class);
      paramView.putExtra("str_download_dns", this.a.jdField_a_of_type_JavaLangString);
      paramView.putExtra("int32_server_port", this.a.jdField_b_of_type_JavaLangString);
      paramView.putExtra("string_download_url", this.a.c);
      paramView.putExtra("str_cookie_val", this.a.d);
      paramView.putExtra("filepath", this.a.e + ((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_JavaLangString);
      paramView.putExtra("filename", "" + ((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_JavaLangString);
      paramView.putExtra("nSessionId", this.a.jdField_b_of_type_Long);
      paramView.putExtra("troop_uin", this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramView, 10099);
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long);
    localForwardFileInfo.d(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_JavaLangString);
    localForwardFileInfo.d(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_Long);
    localForwardFileInfo.b("");
    Object localObject2;
    if (this.a.jdField_a_of_type_Long == 0L)
    {
      localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      Object localObject4 = ((QQAppInterface)localObject2).a().b(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long);
      localObject1 = ((QQAppInterface)localObject2).a().e(((FileManagerEntity)localObject4).zipInnerPath);
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = ((QQAppInterface)localObject2).a().a((String)((FileManagerEntity)localObject4).mContext, ((FileManagerEntity)localObject4).zipInnerPath);
      }
      if (paramView != null) {
        ((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long = paramView.nSessionId;
      }
      localForwardFileInfo.b(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long);
      if (localForwardFileInfo.d() == 0L)
      {
        FMToastUtil.a("该文件为空，不支持查看。");
        return;
      }
      localObject3 = new ArrayList();
      localObject4 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)((Iterator)localObject4).next();
        if ((FileManagerUtil.a(localFileData.jdField_a_of_type_JavaLangString) == 0) && (localFileData.jdField_a_of_type_Long != 0L))
        {
          FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject2).a().b(localFileData.jdField_b_of_type_Long);
          localObject1 = ((QQAppInterface)localObject2).a().e(localFileManagerEntity.zipInnerPath);
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = ((QQAppInterface)localObject2).a().a((String)localFileManagerEntity.mContext, localFileManagerEntity.zipInnerPath);
          }
          if (paramView != null)
          {
            paramView.mContext = localFileManagerEntity.mContext;
            localFileData.jdField_b_of_type_Long = paramView.nSessionId;
          }
          ((ArrayList)localObject3).add(Long.valueOf(localFileData.jdField_b_of_type_Long));
        }
      }
      localForwardFileInfo.a((ArrayList)localObject3);
      localForwardFileInfo.d(1);
      localForwardFileInfo.b(10001);
      paramView = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, FileBrowserActivity.class);
      paramView.putExtra("fileinfo", localForwardFileInfo);
      paramView.putExtra("last_time", 0);
      paramView.putExtra("is_in_zip", true);
      this.a.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      return;
    }
    paramView = new ArrayList();
    Object localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ZipFilePresenter.FileData)((Iterator)localObject1).next();
      if (FileManagerUtil.a(((ZipFilePresenter.FileData)localObject2).jdField_a_of_type_JavaLangString) == 0) {
        paramView.add(Long.valueOf(((ZipFilePresenter.FileData)localObject2).jdField_b_of_type_Long));
      }
    }
    localForwardFileInfo.a(paramView);
    localForwardFileInfo.d(4);
    localForwardFileInfo.b(10000);
    paramView = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, TroopFileDetailBrowserActivity.class);
    paramView.putExtra("fileinfo", localForwardFileInfo);
    paramView.putExtra("forward_from_troop_file", true);
    paramView.putExtra("not_forward", true);
    paramView.putExtra("last_time", 0);
    paramView.putExtra("is_in_zip", true);
    this.a.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyo
 * JD-Core Version:    0.7.0.1
 */