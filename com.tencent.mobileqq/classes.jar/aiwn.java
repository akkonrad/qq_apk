import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

class aiwn
  implements AdapterView.OnItemSelectedListener
{
  aiwn(aiwl paramaiwl) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (TroopAvatarWallPreviewActivity.a(this.a.a.a).isReport)
    {
      TroopAvatarWallPreviewActivity.a(this.a.a.a).addPicIndex(paramInt);
      paramAdapterView = TroopAvatarWallPreviewActivity.a(this.a.a.a);
      paramAdapterView.slide_number += 1;
    }
    this.a.a.a.jdField_a_of_type_Int = paramInt;
    paramAdapterView = this.a.a.a.jdField_a_of_type_Int + 1 + "/" + this.a.a.a.jdField_b_of_type_Int;
    this.a.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdapterView);
    boolean bool1;
    if (this.a.a.a.c)
    {
      ReportController.b(this.a.a.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.a.jdField_a_of_type_JavaLangString, "0", "", "");
      if (this.a.a.a.jdField_b_of_type_Boolean) {
        TroopAvatarWallPreviewActivity.a(this.a.a.a, this.a.a.a.jdField_a_of_type_Int);
      }
      boolean bool2 = this.a.a.a.f;
      if ((TroopAvatarWallPreviewActivity.a(this.a.a.a) != null) && (TroopAvatarWallPreviewActivity.a(this.a.a.a).getBoolean("from_personality_label", false)))
      {
        paramAdapterView = this.a.a.a;
        if (Long.valueOf((String)this.a.a.a.jdField_b_of_type_JavaUtilArrayList.get(this.a.a.a.jdField_a_of_type_Int)).longValue() == -1L) {
          break label530;
        }
        bool1 = true;
        label363:
        paramAdapterView.f = bool1;
      }
      if (bool2 != this.a.a.a.f)
      {
        paramAdapterView = this.a.a.a.jdField_a_of_type_AndroidWidgetImageView;
        if (!this.a.a.a.f) {
          break label536;
        }
      }
    }
    label530:
    label536:
    for (paramInt = 0;; paramInt = 8)
    {
      paramAdapterView.setVisibility(paramInt);
      if (this.a.a.a.k) {
        TroopAvatarWallPreviewActivity.b(this.a.a.a);
      }
      TroopAvatarWallPreviewActivity.b(this.a.a.a, this.a.a.a.jdField_a_of_type_Int);
      return;
      ReportController.b(this.a.a.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.a.jdField_a_of_type_JavaLangString, "1", "", "");
      break;
      bool1 = false;
      break label363;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwn
 * JD-Core Version:    0.7.0.1
 */