import android.opengl.GLES20;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.GlUtil;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ahod
{
  private static final ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public float[] a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  private ahod()
  {
    int i = GlUtil.a(1)[0];
    if (i == 0)
    {
      GlUtil.a("glGenTexture");
      throw new Exception("Unable to generate new texture " + Integer.toHexString(GLES20.glGetError()));
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public static ahod a()
  {
    synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue)
    {
      ahod localahod1 = (ahod)jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      ??? = localahod1;
      if (localahod1 != null) {}
    }
    return localahod2;
  }
  
  public static void a()
  {
    try
    {
      SLog.c("FlowEdit_DecodedFrame", "releaseAll");
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue)
      {
        if (!jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
          ((ahod)jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll()).c();
        }
      }
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalStateException("this is an invalid frame");
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalStateException("this is an invalid frame, don't recycle please");
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(this);
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      GlUtil.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = 0;
      return;
    }
    SLog.d("FlowEdit_DecodedFrame", "release duplicate %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 132	java/lang/Object:finalize	()V
    //   4: aload_0
    //   5: getfield 62	ahod:jdField_a_of_type_Int	I
    //   8: ifeq +10 -> 18
    //   11: ldc 72
    //   13: ldc 134
    //   15: invokestatic 136	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 62	ahod:jdField_a_of_type_Int	I
    //   24: ifeq -6 -> 18
    //   27: ldc 72
    //   29: ldc 134
    //   31: invokestatic 136	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 62	ahod:jdField_a_of_type_Int	I
    //   40: ifeq +10 -> 50
    //   43: ldc 72
    //   45: ldc 134
    //   47: invokestatic 136	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ahod
    //   19	1	1	localThrowable	Throwable
    //   35	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	19	java/lang/Throwable
    //   0	4	35	finally
  }
  
  public String toString()
  {
    return "DecodedFrame{textureId=" + this.jdField_a_of_type_Int + ", timeStampUs=" + this.jdField_a_of_type_Long + ", cycleCount=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahod
 * JD-Core Version:    0.7.0.1
 */