import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;

public class xgy
  implements CustomizeStrategyFactory.OnCustomizeListener
{
  public xgy(RedPacketManager paramRedPacketManager, IRedPacket.OnGetSkinListener paramOnGetSkinListener) {}
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener.onGetSkin(paramRedPacketInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgy
 * JD-Core Version:    0.7.0.1
 */