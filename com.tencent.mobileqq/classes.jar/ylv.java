import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public final class ylv
  implements View.OnClickListener
{
  public ylv(ApolloRender paramApolloRender, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.getText().toString();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.setText("");
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.queueEvent(new ylw(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ylv
 * JD-Core Version:    0.7.0.1
 */