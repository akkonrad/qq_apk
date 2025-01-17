import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class zgk
{
  public int a;
  public long a;
  private String a;
  public int b;
  public long b;
  public int c;
  public long c;
  public long d;
  public long e;
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.d = 0L;
    this.e = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).getString(this.jdField_a_of_type_JavaLangString, null);
      if ((paramString == null) || (paramString.length() == 0))
      {
        a();
        return;
      }
      paramString = new DataInputStream(new ByteArrayInputStream(Base64Util.decode(paramString, 0)));
      this.jdField_a_of_type_Int = paramString.readInt();
      this.jdField_a_of_type_Long = paramString.readLong();
      this.jdField_b_of_type_Long = paramString.readLong();
      this.jdField_c_of_type_Long = paramString.readLong();
      this.d = paramString.readLong();
      this.e = paramString.readLong();
      this.jdField_b_of_type_Int = paramString.readInt();
      this.jdField_c_of_type_Int = paramString.readInt();
      return;
    }
    catch (Exception paramString)
    {
      paramString = new HashMap(3);
      paramString.put("type", "wrong-value");
      paramString.put("file", "MemoryManagerMemoryStat");
      paramString.put("key", "MemoryInfomation");
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "evSpError", true, 0L, 0L, paramString, null);
      a();
    }
  }
  
  public void b()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt(this.jdField_a_of_type_Int);
      localDataOutputStream.writeLong(this.jdField_a_of_type_Long);
      localDataOutputStream.writeLong(this.jdField_b_of_type_Long);
      localDataOutputStream.writeLong(this.jdField_c_of_type_Long);
      localDataOutputStream.writeLong(this.d);
      localDataOutputStream.writeLong(this.e);
      localDataOutputStream.writeInt(this.jdField_b_of_type_Int);
      localDataOutputStream.writeInt(this.jdField_c_of_type_Int);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).edit().putString(this.jdField_a_of_type_JavaLangString, Base64Util.encodeToString((byte[])localObject, 0)).commit();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.Memory.MemoryManager", 2, "StatMemory.save exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zgk
 * JD-Core Version:    0.7.0.1
 */