package com.tencent.biz.addContactTroopView;

import NearbyGroup.Color;
import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.pb.addcontacts.AccountSearchPb.Color;
import com.tencent.pb.addcontacts.AccountSearchPb.Label;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.group.group_label.GroupLabel.Color;
import tencent.im.group.group_label.GroupLabel.Label;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.RgroupInfo;
import tencent.im.troop_search_searchtab.searchtab.Item1;

public class GroupViewAdapter
{
  public static String a = GroupViewAdapter.class.getSimpleName();
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramContext = NearbyTroops.a(paramContext, paramViewGroup, paramInt2);
    paramViewGroup = (NearbyTroops.CustomViewHolder)paramContext.getTag();
    paramViewGroup.a.setMaxLabelCount(paramInt1);
    paramViewGroup.a.setmIsNeedPriority(paramBoolean);
    return paramContext;
  }
  
  public static ArrayList a(RecommendTroopItem paramRecommendTroopItem)
  {
    if (paramRecommendTroopItem == null) {}
    for (;;)
    {
      return null;
      Object localObject;
      if ((paramRecommendTroopItem.labelList == null) && (paramRecommendTroopItem.x9fbRgroupInfo != null)) {
        localObject = new oidb_0x9fb.RgroupInfo();
      }
      try
      {
        ((oidb_0x9fb.RgroupInfo)localObject).mergeFrom(paramRecommendTroopItem.x9fbRgroupInfo);
        if (((oidb_0x9fb.RgroupInfo)localObject).rpt_group_label.has()) {
          paramRecommendTroopItem.labelList = ((oidb_0x9fb.RgroupInfo)localObject).rpt_group_label.get();
        }
        if ((paramRecommendTroopItem.labelList == null) || (paramRecommendTroopItem.labelList.size() <= 0)) {
          continue;
        }
        localObject = new ArrayList();
        paramRecommendTroopItem = paramRecommendTroopItem.labelList.iterator();
        while (paramRecommendTroopItem.hasNext())
        {
          oidb_0x9fb.Label localLabel = (oidb_0x9fb.Label)paramRecommendTroopItem.next();
          GroupLabel localGroupLabel = new GroupLabel();
          Color localColor = new Color();
          localColor.R = localLabel.edging_color.uint32_r.get();
          localColor.G = localLabel.edging_color.uint32_g.get();
          localColor.B = localLabel.edging_color.uint32_b.get();
          localGroupLabel.edging_color = localColor;
          localColor = new Color();
          localColor.R = localLabel.text_color.uint32_r.get();
          localColor.G = localLabel.text_color.uint32_g.get();
          localColor.B = localLabel.text_color.uint32_b.get();
          localGroupLabel.text_color = localColor;
          localGroupLabel.strWording = localLabel.bytes_name.get().toStringUtf8();
          localGroupLabel.type = localLabel.uint32_label_attr.get();
          ((ArrayList)localObject).add(localGroupLabel);
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        return localInvalidProtocolBufferMicroException;
      }
    }
  }
  
  public static void a(View paramView, Context paramContext, ShowExternalTroop paramShowExternalTroop)
  {
    if (paramShowExternalTroop == null) {
      return;
    }
    GroupInfo localGroupInfo = new GroupInfo();
    try
    {
      localGroupInfo.lCode = Long.valueOf(paramShowExternalTroop.troopUin).longValue();
      localGroupInfo.strName = paramShowExternalTroop.troopName;
      if (!TextUtils.isEmpty(paramShowExternalTroop.troopDesText)) {
        localGroupInfo.strIntro = paramShowExternalTroop.troopDesText;
      }
      if ((paramShowExternalTroop.labelList != null) && (paramShowExternalTroop.labelList.size() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        paramShowExternalTroop = paramShowExternalTroop.labelList.iterator();
        while (paramShowExternalTroop.hasNext())
        {
          GroupLabel.Label localLabel = (GroupLabel.Label)paramShowExternalTroop.next();
          GroupLabel localGroupLabel = new GroupLabel();
          Color localColor = new Color();
          localColor.R = localLabel.edging_color.uint32_r.get();
          localColor.G = localLabel.edging_color.uint32_g.get();
          localColor.B = localLabel.edging_color.uint32_b.get();
          localGroupLabel.edging_color = localColor;
          localColor = new Color();
          localColor.R = localLabel.text_color.uint32_r.get();
          localColor.G = localLabel.text_color.uint32_g.get();
          localColor.B = localLabel.text_color.uint32_b.get();
          localGroupLabel.text_color = localColor;
          localGroupLabel.strWording = localLabel.bytes_name.get().toStringUtf8();
          localGroupLabel.type = localLabel.uint32_label_attr.get();
          localArrayList.add(localGroupLabel);
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "fillCustomView NumberFormatException");
        }
      }
      localGroupInfo.labels = localNumberFormatException;
      NearbyTroops.a(paramView, localGroupInfo, paramContext, false, false);
    }
  }
  
  public static void a(View paramView, Context paramContext, AccountSearchPb.record paramrecord)
  {
    if (paramrecord == null) {
      return;
    }
    GroupInfo localGroupInfo = new GroupInfo();
    try
    {
      localGroupInfo.lCode = paramrecord.code.get();
      localGroupInfo.strName = paramrecord.name.get();
      if ((paramrecord.brief.has()) && (!TextUtils.isEmpty(paramrecord.brief.get()))) {
        localGroupInfo.strIntro = paramrecord.brief.get();
      }
      if ((paramrecord.msg_group_labels.has()) && (!paramrecord.msg_group_labels.isEmpty()))
      {
        ArrayList localArrayList = new ArrayList();
        paramrecord = paramrecord.msg_group_labels.get().iterator();
        while (paramrecord.hasNext())
        {
          AccountSearchPb.Label localLabel = (AccountSearchPb.Label)paramrecord.next();
          GroupLabel localGroupLabel = new GroupLabel();
          Color localColor = new Color();
          localColor.R = localLabel.edging_color.uint32_r.get();
          localColor.G = localLabel.edging_color.uint32_g.get();
          localColor.B = localLabel.edging_color.uint32_b.get();
          localGroupLabel.edging_color = localColor;
          localColor = new Color();
          localColor.R = localLabel.text_color.uint32_r.get();
          localColor.G = localLabel.text_color.uint32_g.get();
          localColor.B = localLabel.text_color.uint32_b.get();
          localGroupLabel.text_color = localColor;
          localGroupLabel.strWording = localLabel.bytes_name.get().toStringUtf8();
          localGroupLabel.type = localLabel.uint32_label_attr.get();
          localArrayList.add(localGroupLabel);
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "fillCustomView NumberFormatException");
        }
      }
      localGroupInfo.labels = localNumberFormatException;
      NearbyTroops.a(paramView, localGroupInfo, paramContext, false);
    }
  }
  
  public static void a(View paramView, Context paramContext, searchtab.Item1 paramItem1)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.lCode = paramItem1.uint64_group_code.get();
    localGroupInfo.strName = paramItem1.str_name.get();
    if (paramItem1.bytes_group_finger_memo.has()) {
      localGroupInfo.strIntro = paramItem1.bytes_group_finger_memo.get().toStringUtf8();
    }
    localGroupInfo.iMemberCnt = paramItem1.uint32_mem_cnt.get();
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramItem1.rpt_msg_group_label.has())
    {
      localObject2 = new ArrayList();
      Iterator localIterator = paramItem1.rpt_msg_group_label.get().iterator();
      paramItem1 = (searchtab.Item1)localObject1;
      if (localIterator.hasNext())
      {
        GroupLabel.Label localLabel = (GroupLabel.Label)localIterator.next();
        localObject1 = new GroupLabel();
        Color localColor = new Color();
        localColor.R = localLabel.edging_color.uint32_r.get();
        localColor.G = localLabel.edging_color.uint32_g.get();
        localColor.B = localLabel.edging_color.uint32_b.get();
        ((GroupLabel)localObject1).edging_color = localColor;
        localColor = new Color();
        localColor.R = localLabel.text_color.uint32_r.get();
        localColor.G = localLabel.text_color.uint32_g.get();
        localColor.B = localLabel.text_color.uint32_b.get();
        ((GroupLabel)localObject1).text_color = localColor;
        ((GroupLabel)localObject1).strWording = localLabel.bytes_name.get().toStringUtf8();
        ((GroupLabel)localObject1).type = localLabel.uint32_label_attr.get();
        if (localLabel.uint32_label_type.get() != 9) {
          break label392;
        }
        paramItem1 = ((GroupLabel)localObject1).strWording;
      }
    }
    label392:
    for (;;)
    {
      ((ArrayList)localObject2).add(localObject1);
      break;
      localGroupInfo.labels = ((ArrayList)localObject2);
      localObject2 = paramItem1;
      NearbyTroops.a(paramView, localGroupInfo, paramContext, false);
      paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramView.e.setText((CharSequence)localObject2);
        paramView.e.setVisibility(0);
        return;
      }
      paramView.e.setVisibility(8);
      return;
    }
  }
  
  public static View b(Context paramContext, ViewGroup paramViewGroup, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramContext = NearbyTroops.a(paramContext, paramViewGroup, paramInt2, 2130970600);
    paramViewGroup = (NearbyTroops.CustomViewHolder)paramContext.getTag();
    paramViewGroup.a.setMaxLabelCount(paramInt1);
    paramViewGroup.a.setmIsNeedPriority(paramBoolean);
    paramViewGroup.b = 1;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.GroupViewAdapter
 * JD-Core Version:    0.7.0.1
 */