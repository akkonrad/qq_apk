import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class acsw
  implements View.OnClickListener
{
  acsw(acsv paramacsv, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof ImageHolder))
    {
      localObject = (FileManagerEntity)((ImageHolder)localObject).a;
      if (paramView.getId() != 2131362740) {
        break label105;
      }
      paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_Acsv.a.a, null);
      paramView.a("删除文件记录及云端记录");
      paramView.a("删除", 3);
      paramView.d("取消");
      paramView.a(new acsx(this, (FileManagerEntity)localObject, paramView));
      paramView.show();
    }
    label105:
    while (paramView.getId() != 2131375590)
    {
      return;
      localObject = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject).a;
      break;
    }
    ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Acsv.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsw
 * JD-Core Version:    0.7.0.1
 */