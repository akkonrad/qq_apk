import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class liz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public liz(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.getWindowVisibleDisplayFrame(localRect);
    int j = localRect.bottom;
    int i = j;
    if (!this.a.d) {
      i = j - this.a.g;
    }
    if (i != this.a.f)
    {
      this.a.f = i;
      this.a.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = this.a.f;
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     liz
 * JD-Core Version:    0.7.0.1
 */