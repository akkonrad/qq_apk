import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.nearby.smooth.ItemManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class afml
  implements AbsListView.OnScrollListener
{
  private afml(ItemManager paramItemManager) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((this.a.jdField_a_of_type_Int == 2) && (paramInt != 2))
    {
      i = 1;
      if (i == 0) {
        break label136;
      }
      localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, this.a);
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (!this.a.b) {
        break label129;
      }
      i = j;
      label66:
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, i);
      this.a.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = paramInt;
      localObject = this.a.jdField_a_of_type_Afmi.a();
      if (localObject != null) {
        ((AbsListView.OnScrollListener)localObject).a(paramAbsListView, paramInt);
      }
      return;
      i = 0;
      break;
      label129:
      i = 550;
      break label66;
      label136:
      if (paramInt == 2)
      {
        this.a.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.a.jdField_a_of_type_Afmi.a();
    if (localOnScrollListener != null) {
      localOnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afml
 * JD-Core Version:    0.7.0.1
 */