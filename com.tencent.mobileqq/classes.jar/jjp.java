import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.qphone.base.util.QLog;

public class jjp
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  int d = 0;
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    String str;
    StringBuilder localStringBuilder;
    if ((paramArrayOfByte == null) || (this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2) || (this.c != paramInt3) || (this.d != paramInt4) || (this.jdField_a_of_type_Long != paramLong1) || (this.jdField_a_of_type_Boolean != paramBoolean)) {
      if (QLog.isColorLevel())
      {
        str = EffectsRenderController.a;
        localStringBuilder = new StringBuilder().append("onProcessFrame, data[");
        if (paramArrayOfByte == null) {
          break label285;
        }
      }
    }
    label285:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 1, bool + "], debugSeq[" + paramLong2 + "], width[" + this.jdField_a_of_type_Int + "->" + paramInt1 + "], height[" + this.b + "->" + paramInt2 + "], format[" + this.c + "->" + paramInt3 + "], angle[" + this.d + "->" + paramInt4 + "], FPS[" + this.jdField_a_of_type_Long + "->" + paramLong1 + "], isFront[" + this.jdField_a_of_type_Boolean + "->" + paramBoolean + "]");
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjp
 * JD-Core Version:    0.7.0.1
 */