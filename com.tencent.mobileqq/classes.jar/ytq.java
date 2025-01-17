import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.mobileqq.apollo.store.ApolloImageShareLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class ytq
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final int jdField_b_of_type_Int;
  private final WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private final int c;
  
  public ytq(ApolloImageShareLayout paramApolloImageShareLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloImageShareLayout);
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBitmap);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference == null)) {}
    do
    {
      return;
      localApolloImageShareLayout = (ApolloImageShareLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localApolloImageShareLayout == null) || (ApolloImageShareLayout.a(localApolloImageShareLayout) == null) || (localApolloImageShareLayout.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null));
    for (;;)
    {
      try
      {
        Object localObject1 = (Bitmap)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if (localObject1 == null) {
          continue;
        }
        Object localObject3 = Bitmap.createBitmap(ApolloImageShareLayout.a(localApolloImageShareLayout).getWidth(), ApolloImageShareLayout.a(localApolloImageShareLayout).getHeight(), Bitmap.Config.ARGB_8888);
        if (localObject3 == null) {
          continue;
        }
        Canvas localCanvas = new Canvas((Bitmap)localObject3);
        Bitmap localBitmap = ApolloImageShareLayout.a(localApolloImageShareLayout).getDrawingCache();
        if (localBitmap != null) {
          localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
        }
        localCanvas.drawBitmap((Bitmap)localObject1, (ApolloImageShareLayout.a(localApolloImageShareLayout).getWidth() - ((Bitmap)localObject1).getWidth()) / 2, ApolloImageShareLayout.a(localApolloImageShareLayout), null);
        localObject1 = ImageUtil.a((Bitmap)localObject3);
        localObject3 = localApolloImageShareLayout.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(this.jdField_a_of_type_Int);
        ((Message)localObject3).obj = localObject1;
        ((Message)localObject3).sendToTarget();
      }
      catch (Exception localException)
      {
        QLog.e("ApolloImageShareLayout", 2, localException.getMessage());
        return;
        QLog.e("ApolloImageShareLayout", 2, "error! bitmap null");
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ApolloImageShareLayout", 2, localOutOfMemoryError.getMessage());
        return;
      }
      finally
      {
        localApolloImageShareLayout.jdField_a_of_type_Boolean = false;
      }
      localApolloImageShareLayout.jdField_a_of_type_Boolean = false;
      return;
      QLog.e("ApolloImageShareLayout", 2, "error! layout.mBackLayout.getDrawingCache() null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ytq
 * JD-Core Version:    0.7.0.1
 */