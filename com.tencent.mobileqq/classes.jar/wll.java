import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;

public class wll
  implements Runnable
{
  public wll(TroopActivity paramTroopActivity, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.jdField_a_of_type_Int;
    ((Rect)localObject).bottom += this.b;
    ((Rect)localObject).left -= this.c;
    ((Rect)localObject).right += this.d;
    localObject = new TouchDelegate((Rect)localObject, this.jdField_a_of_type_AndroidViewView);
    if (View.class.isInstance(this.jdField_a_of_type_AndroidViewView.getParent())) {
      ((View)this.jdField_a_of_type_AndroidViewView.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wll
 * JD-Core Version:    0.7.0.1
 */