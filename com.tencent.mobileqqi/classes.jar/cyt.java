import android.view.View;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.ViewHolder;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.widget.XListView;

class cyt
  implements Runnable
{
  cyt(cys paramcys, String paramString) {}
  
  public void run()
  {
    int j;
    int i;
    if ((LebaListMgrActivity.a(this.jdField_a_of_type_Cys.a) != null) && (LebaListMgrActivity.a(this.jdField_a_of_type_Cys.a) != null))
    {
      j = LebaListMgrActivity.a(this.jdField_a_of_type_Cys.a).getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        LebaListMgrAdapter.ViewHolder localViewHolder = (LebaListMgrAdapter.ViewHolder)LebaListMgrActivity.a(this.jdField_a_of_type_Cys.a).getChildAt(i).getTag();
        if ((localViewHolder != null) && (localViewHolder.a != null) && (localViewHolder.a.a != null) && (Utils.a(localViewHolder.a.a.strPkgName, this.jdField_a_of_type_JavaLangString))) {
          LebaListMgrActivity.a(this.jdField_a_of_type_Cys.a).a(localViewHolder);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cyt
 * JD-Core Version:    0.7.0.1
 */