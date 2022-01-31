package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import eoa;
import java.util.List;

public class TroopAioTips
  extends TroopAioAgent
{
  public static final int d = 200;
  public long a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = null;
  TroopAioMsgNavigateBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar = new TroopAioMsgNavigateBar();
  TroopAioNewMessageBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar = new TroopAioNewMessageBar();
  public long b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  
  public TroopAioTips()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.d();
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramBoolean;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null)) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    j();
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, AIOTipsController paramAIOTipsController, String paramString1, String paramString2, String paramString3)
  {
    if (this.d) {
      return;
    }
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", "", "sys_msg", "exp_notice", 0, 0, paramString1, "", "", "");
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(paramList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.b();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new eoa(this));
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a();
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a();
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a();
    }
    return false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.f();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.e();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.g();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.jdField_b_of_type_Boolean = true;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.jdField_b_of_type_Boolean = false;
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioTips
 * JD-Core Version:    0.7.0.1
 */