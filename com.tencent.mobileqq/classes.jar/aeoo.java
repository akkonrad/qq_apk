import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class aeoo
  implements WerewolvesHandler.Callback
{
  public aeoo(GameRoomInviteActivity paramGameRoomInviteActivity, WerewolvesHandler paramWerewolvesHandler) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      GameRoomInviteActivity localGameRoomInviteActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity;
      if ((!paramRspBody.uint64_leader_uin.has()) || (paramRspBody.uint64_leader_uin.get() == this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.app.getLongAccountUin())) {}
      for (boolean bool = true;; bool = false)
      {
        localGameRoomInviteActivity.a(bool, paramRspBody.string_invite_id.get().toStringUtf8(), null, "当前正在组队中，无法加入");
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.b(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a, this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.b, new aeop(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeoo
 * JD-Core Version:    0.7.0.1
 */