import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;

public class ymy
  implements Runnable
{
  public ymy(ApolloTextureView paramApolloTextureView, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    ApolloSurfaceView.nativeTouchInput(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymy
 * JD-Core Version:    0.7.0.1
 */