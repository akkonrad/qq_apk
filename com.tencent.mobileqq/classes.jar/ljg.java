import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;

class ljg
  implements Runnable
{
  ljg(ljf paramljf) {}
  
  public void run()
  {
    ZhituManager localZhituManager = ReadInJoyCommentComponentFragment.a(this.a.a);
    if ((localZhituManager != null) && (ReadInJoyCommentComponentFragment.a(this.a.a)))
    {
      localZhituManager.c();
      ReadInJoyCommentComponentFragment.a(this.a.a, false);
      this.a.a.f.setSelected(false);
    }
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ReadInJoyDeliverUGCActivity.a(this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData));
    this.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    ReadInJoyCommentComponentFragment.a(this.a.a);
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      this.a.a.g.setImageResource(2130840760);
      ReadInJoyCommentComponentFragment.b(this.a.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljg
 * JD-Core Version:    0.7.0.1
 */