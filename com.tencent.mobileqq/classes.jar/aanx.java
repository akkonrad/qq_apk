import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.MotionCallback;

class aanx
  implements ArkAppEventObserverManager.MotionCallback
{
  aanx(aanw paramaanw, long paramLong) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_Aanw.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArkAppDeviceModule.a(this.jdField_a_of_type_Aanw.a, this.jdField_a_of_type_Long, paramBoolean, "Motion", paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aanx
 * JD-Core Version:    0.7.0.1
 */