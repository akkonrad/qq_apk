import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.doodle.LineLayer;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class usk
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private int b = -1;
  
  public usk(LineLayer paramLineLayer, int paramInt1, Map paramMap, int paramInt2, ust paramust)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramust);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
    this.b = paramInt2;
  }
  
  public void run()
  {
    localObject3 = null;
    j = 0;
    try
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label157;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        Object localObject1 = localObject3;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("UndoJob", 2, "exception :" + localException);
          localObject1 = localObject3;
          i = j;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        label157:
        Object localObject2 = localObject3;
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("UndoJob", 2, "OOM!!");
          localObject2 = localObject3;
          i = j;
        }
      }
    }
    if (((Iterator)localObject1).hasNext())
    {
      k = ((Integer)((Iterator)localObject1).next()).intValue();
      if ((k > i) && (k <= this.jdField_a_of_type_Int)) {
        i = k;
      }
    }
    else
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i != 0)) {
        localObject1 = BitmapFactory.decodeFile((String)localObject1);
      }
      for (;;)
      {
        new Handler(Looper.getMainLooper()).post(new usl(this, i, (Bitmap)localObject1));
        return;
        i = this.jdField_a_of_type_Int;
        break;
        localObject1 = null;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     usk
 * JD-Core Version:    0.7.0.1
 */