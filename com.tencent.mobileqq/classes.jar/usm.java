import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.doodle.LineLayer;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;

public class usm
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public final String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int b = -1;
  
  public usm(LineLayer paramLineLayer, int paramInt1, int paramInt2, Bitmap paramBitmap, utd paramutd)
  {
    this.jdField_a_of_type_JavaLangString = (AppConstants.bM + "temp" + File.separator);
    QLog.d("SaveTempFileJob", 2, "SaveTempFileJob begin:");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramutd);
    if (paramBitmap == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          continue;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        paramLineLayer = new Paint();
        paramLineLayer.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, paramLineLayer);
      }
      catch (Exception paramLineLayer)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SaveTempFileJob", 2, "SaveTempFileJob exception:" + paramLineLayer);
        continue;
      }
      catch (OutOfMemoryError paramLineLayer)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SaveTempFileJob", 2, "SaveTempFileJob OOM:" + paramLineLayer.toString());
        continue;
      }
      QLog.d("SaveTempFileJob", 2, "SaveTempFileJob end:");
      return;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != paramBitmap.getHeight()) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != paramBitmap.getWidth()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      }
    }
  }
  
  private String a(int paramInt, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    do
    {
      return null;
      try
      {
        String str = this.jdField_a_of_type_JavaLangString + paramInt + ".tmp";
        if (FileUtils.a(str)) {
          FileUtils.d(str);
        }
        FileOutputStream localFileOutputStream = new FileOutputStream(str);
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        return str;
      }
      catch (Exception paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("SaveTempFileJob", 2, "saveFileCache exception:" + paramBitmap);
    return null;
  }
  
  private void a()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("SaveTempFileJobdownloading", 2, "makedir execption: " + localException);
    }
  }
  
  private void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new usn(this, paramString));
  }
  
  public void run()
  {
    if (LineLayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer) == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        a(null);
        return;
      }
      a();
      a(a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap));
    } while (this.jdField_a_of_type_AndroidGraphicsBitmap == null);
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     usm
 * JD-Core Version:    0.7.0.1
 */