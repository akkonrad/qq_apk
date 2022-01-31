import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;

public class ajuz
  extends TroopGiftCallback
{
  public ajuz(TroopGiftAnimationController paramTroopGiftAnimationController) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView)
    {
      if ((TroopGiftAnimationController.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    if (paramInt == 20005)
    {
      TroopGiftAnimationController.a(this.a).jdField_a_of_type_Int = 3;
      paramString = (TroopGiftManager)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(112);
      if (this.a.jdField_a_of_type_Int > 3) {
        paramString.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, TroopGiftAnimationController.a(this.a).frienduin, TroopGiftAnimationController.a(this.a).bagId, 3000L, TroopGiftAnimationController.a(this.a));
      }
    }
    String str1;
    String str2;
    label299:
    do
    {
      for (;;)
      {
        return;
        paramString.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, TroopGiftAnimationController.a(this.a).frienduin, TroopGiftAnimationController.a(this.a).bagId, 3000L, TroopGiftAnimationController.a(this.a));
      }
      if (paramInt != -1) {
        break label497;
      }
      str1 = TroopGiftAnimationController.a(this.a).getResources().getString(2131430753);
      str2 = com.tencent.mobileqq.app.AppConstants.c[com.tencent.mobileqq.utils.NetworkUtil.a(TroopGiftAnimationController.a(this.a))];
      if (this.a.jdField_a_of_type_Int < 4) {
        break;
      }
      NearbyFlowerManager.a("cartoon", "timeout", TroopGiftAnimationController.a(this.a).frienduin, TroopGiftUtil.b(TroopGiftAnimationController.a(this.a)) + str2, "", "");
      break label546;
      if (!(this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToAllSurfaceView)) {
        break label549;
      }
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, TroopGiftAnimationController.a(this.a).n, DisplayUtil.a(TroopGiftAnimationController.a(this.a), 16.0F));
      TroopGiftAnimationController.a(this.a).jdField_a_of_type_Int = 2;
    } while (TroopGiftAnimationController.a(this.a).c <= 0L);
    if (TroopGiftAnimationController.a(this.a).b > TroopGiftAnimationController.a(this.a).c + 3000L)
    {
      return;
      if (TroopGiftAnimationController.a(this.a) == null) {
        break label551;
      }
    }
    label546:
    label549:
    label551:
    for (paramString = "0";; paramString = "1")
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, "" + TroopGiftAnimationController.a(this.a).frienduin, "" + TroopGiftUtil.b(TroopGiftAnimationController.a(this.a)), paramString, str2);
      break label546;
      label497:
      paramString = TroopGiftAnimationController.a(this.a).getResources().getString(2131430754);
      break label299;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(TroopGiftAnimationController.a(this.a));
      this.a.a(2000L);
      break;
      paramString = str1;
      break label299;
      break;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView)
    {
      if ((TroopGiftAnimationController.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    TroopGiftAnimationController.a(this.a).b = NetConnInfoCenter.getServerTimeMillis();
    TroopGiftAnimationController.a(this.a).jdField_a_of_type_Int = 2;
    if (TroopGiftAnimationController.a(this.a).c > 0L)
    {
      if (TroopGiftAnimationController.a(this.a).b > TroopGiftAnimationController.a(this.a).c + 3000L) {
        return;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(TroopGiftAnimationController.a(this.a));
      this.a.a(2000L);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt1 <= 0) {
        break label224;
      }
    }
    label224:
    for (paramInt1 = TroopGiftAnimationController.a(this.a).m;; paramInt1 = TroopGiftAnimationController.a(this.a).n)
    {
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, paramInt1, DisplayUtil.a(TroopGiftAnimationController.a(this.a), 16.0F));
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuz
 * JD-Core Version:    0.7.0.1
 */