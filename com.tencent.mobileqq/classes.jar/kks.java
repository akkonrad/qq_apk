import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.addContactTroopView.TroopCardXingquBuluo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item3;

public class kks
  implements AdapterView.OnItemClickListener
{
  public kks(TroopCardXingquBuluo paramTroopCardXingquBuluo) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (searchtab.Item3)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.a.a(paramAdapterView.str_transfer_url.get());
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_tribe", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kks
 * JD-Core Version:    0.7.0.1
 */