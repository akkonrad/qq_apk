import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;

public class aksi
  extends TroopObserver
{
  public aksi(WerewolvesHostInterface paramWerewolvesHostInterface, QQAppInterface paramQQAppInterface) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface.manager.a().a(6, new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2) });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksi
 * JD-Core Version:    0.7.0.1
 */