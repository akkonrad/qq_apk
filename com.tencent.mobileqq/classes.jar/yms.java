import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;

public class yms
  implements Runnable
{
  public yms(ApolloSurfaceView paramApolloSurfaceView, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    try
    {
      ApolloSurfaceView.nativeTouchInput(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSurfaceView", 1, "send touch event err e=" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yms
 * JD-Core Version:    0.7.0.1
 */