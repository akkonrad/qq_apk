import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.vas.ColorRingPlayer;

public class akhn
  implements Runnable
{
  public akhn(ColorRingPlayer paramColorRingPlayer, String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("subAction", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("actionName", this.b);
    localBundle.putLong("id", this.jdField_a_of_type_Long);
    localBundle.putInt("result", this.jdField_a_of_type_Int);
    localBundle = DataFactory.a("reportColorRing", "", this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a.key, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhn
 * JD-Core Version:    0.7.0.1
 */