import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.GetCurrentPositionCallback;

class aaoo
  implements ArkAppEventObserverManager.GetCurrentPositionCallback
{
  aaoo(aaon paramaaon) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.a.a.a.jdField_a_of_type_Aanw.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    ArkAppDeviceModule.a(this.a.a.a.jdField_a_of_type_Aanw.a, this.a.a.a.jdField_a_of_type_Long, paramBoolean, paramDouble1, paramDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaoo
 * JD-Core Version:    0.7.0.1
 */