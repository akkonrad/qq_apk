import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

public class lti
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  public lti(FeedItemCell paramFeedItemCell) {}
  
  public void a(View paramView, int paramInt, ArrayList paramArrayList, Object paramObject)
  {
    FeedItemCell.a(this.a, (IReadInJoyModel)this.a.a, paramInt, paramArrayList, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lti
 * JD-Core Version:    0.7.0.1
 */