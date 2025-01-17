package com.tencent.mobileqq.troop.data;

import ajdt;
import ajdu;
import ajdv;
import ajdx;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;

public class TroopEntranceBar
  extends Observable
  implements View.OnClickListener
{
  public int a;
  public long a;
  public Context a;
  private LightingColorFilter jdField_a_of_type_AndroidGraphicsLightingColorFilter;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ChatAdapter1 a;
  public SessionInfo a;
  protected FriendListObserver a;
  public QQAppInterface a;
  public ChatXListView a;
  protected FaceDecoder a;
  public List a;
  public Map a;
  public Observer a;
  public boolean a;
  public int b;
  private LightingColorFilter jdField_b_of_type_AndroidGraphicsLightingColorFilter;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  public List b;
  public int c;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_c_of_type_AndroidViewView;
  private int d;
  private int e;
  
  public TroopEntranceBar()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ajdx(this);
  }
  
  public void a()
  {
    deleteObservers();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_JavaUtilObserver = null;
  }
  
  public void a(long paramLong, int paramInt)
  {
    oidb_0x487.ReqBody localReqBody = new oidb_0x487.ReqBody();
    localReqBody.uint32_channel.set(1);
    localReqBody.uint64_subscribe_code.set(paramLong);
    ProtoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ajdv(this, paramLong), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_Int <= 0) && (this.jdField_a_of_type_Int <= 0))
    {
      this.jdField_c_of_type_Int = -1;
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    Object localObject1 = ((TroopManager)paramQQAppInterface.getManager(51)).a();
    try
    {
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).longValue();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          if (((TroopInfo)localObject2).associatePubAccount == l)
          {
            this.jdField_b_of_type_Int += 1;
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
            if (paramQQAppInterface.b(((TroopInfo)localObject2).troopuin) == 3) {
              this.jdField_b_of_type_JavaUtilList.add(((TroopInfo)localObject2).troopuin);
            }
            this.jdField_a_of_type_JavaUtilMap.put(((TroopInfo)localObject2).troopuin, Integer.valueOf(paramQQAppInterface.a().a(((TroopInfo)localObject2).troopuin, 1)));
          }
        }
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d(".troop.troop_pubaccount", 2, "publicAccount uin format exception. sessionInfo.curFriendUin is not long. value is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      d();
      e();
      paramQQAppInterface.a().b(this.jdField_b_of_type_JavaUtilList);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1, ChatXListView paramChatXListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363508);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramChatXListView;
    this.jdField_a_of_type_JavaUtilObserver = paramObserver;
    deleteObservers();
    addObserver(paramObserver);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.d = paramContext.getResources().getColor(2131493587);
    this.e = paramContext.getResources().getColor(2131493588);
    this.jdField_a_of_type_AndroidGraphicsLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), this.d);
    this.jdField_b_of_type_AndroidGraphicsLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), this.e);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView == null) {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969851, null);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131363508);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 41.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131368277);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368279));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368280));
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
    ((LinearLayout.LayoutParams)localObject).height = i;
    ((LinearLayout.LayoutParams)localObject).width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130846272);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841274);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_Boolean = true;
      c();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      ThreadManager.post(new ajdt(this), 8, null, true);
      return;
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130846273);
    }
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368278);
    localImageView.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
    localLayoutParams.height = -2;
    localLayoutParams.width = -2;
    localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
    localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841275);
    localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 11.0F);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable.getConstantState().newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources()).mutate();
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsLightingColorFilter);
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.d);
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources()).mutate();
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsLightingColorFilter);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131430771);
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((Integer)localIterator.next()).intValue() + l) {}
    this.jdField_a_of_type_Long = l;
  }
  
  public void e()
  {
    String str1;
    QQAppInterface localQQAppInterface;
    if (this.jdField_b_of_type_Int <= 0)
    {
      this.jdField_c_of_type_Int = 0;
      str1 = "entry_none";
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label128;
      }
    }
    label128:
    for (String str2 = "";; str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_public", "", "oper", str1, 0, 0, "", "", "", str2);
      return;
      if (this.jdField_b_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_Long <= 0L) {}
        for (this.jdField_c_of_type_Int = 3;; this.jdField_c_of_type_Int = 1)
        {
          str1 = "entry_one";
          break;
        }
      }
      if (this.jdField_a_of_type_Long <= 0L) {}
      for (this.jdField_c_of_type_Int = 4;; this.jdField_c_of_type_Int = 2)
      {
        str1 = "entry_more";
        break;
      }
    }
  }
  
  public void f()
  {
    Object localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a();
    try
    {
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).longValue();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          if (((TroopInfo)localObject2).associatePubAccount == l)
          {
            this.jdField_b_of_type_Int += 1;
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d(".troop.troop_pubaccount", 2, "publicAccount uin format exception. sessionInfo.curFriendUin is not long. value is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.post(new ajdu(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar
 * JD-Core Version:    0.7.0.1
 */