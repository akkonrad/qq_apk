package com.tencent.mobileqq.data;

import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AccountDetail
  extends Entity
{
  public byte[] accountData;
  public int accountFlag;
  public long accountFlag2;
  @notColumn
  public int cardStyle = 0;
  public String certifiedDescription = "";
  @notColumn
  public String certifiedEnterprise = "";
  public int certifiedGrade;
  @notColumn
  public String certifiedWeixin = "";
  public String configBackgroundColor = "3d7fe3";
  @notColumn
  public String configBackgroundImg = "";
  @notColumn
  public List customConfigAttrs;
  public String displayNumber = "";
  public int followType;
  @notColumn
  public List fullscreenConfigAttrs;
  public int groupId;
  public List groupInfoList;
  public boolean isAgreeSyncLbs;
  public boolean isConfirmed;
  public boolean isRecvMsg;
  public boolean isRecvPush;
  public boolean isShowFollowButton;
  public boolean isShowShareButton;
  public boolean isSyncLbs;
  public boolean isSyncLbsSelected;
  public String lastHistoryMsg;
  public int mShowMsgFlag = -1;
  public String name = "公众帐号";
  public List newGroupInfoList;
  @notColumn
  public List paConfigAttrs;
  public int seqno;
  public int showFlag;
  public String summary = "挺好的";
  @unique
  public String uin;
  @notColumn
  public String unifiedDesrpition;
  
  public AccountDetail() {}
  
  public AccountDetail(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    this.uin = ("" + (paramGetPublicAccountDetailInfoResponse.uin.get() & 0xFFFFFFFF));
    this.seqno = paramGetPublicAccountDetailInfoResponse.seqno.get();
    this.name = paramGetPublicAccountDetailInfoResponse.name.get();
    this.summary = paramGetPublicAccountDetailInfoResponse.summary.get();
    this.isRecvMsg = paramGetPublicAccountDetailInfoResponse.is_recv_msg.get();
    this.isShowFollowButton = paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get();
    this.isShowShareButton = paramGetPublicAccountDetailInfoResponse.is_show_share_button.get();
    this.groupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetPublicAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = paramGetPublicAccountDetailInfoResponse.display_number.get();
    this.groupId = paramGetPublicAccountDetailInfoResponse.group_id.get();
    this.isRecvPush = paramGetPublicAccountDetailInfoResponse.is_recv_push.get();
    this.certifiedGrade = paramGetPublicAccountDetailInfoResponse.certified_grade.get();
    this.showFlag = paramGetPublicAccountDetailInfoResponse.show_flag.get();
    this.accountFlag = paramGetPublicAccountDetailInfoResponse.account_flag.get();
    this.accountFlag2 = paramGetPublicAccountDetailInfoResponse.account_flag2.get();
    this.accountData = paramGetPublicAccountDetailInfoResponse.toByteArray();
    this.configBackgroundColor = paramGetPublicAccountDetailInfoResponse.config_background_color.get();
    this.configBackgroundImg = paramGetPublicAccountDetailInfoResponse.config_background_img.get();
    this.newGroupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
    this.certifiedDescription = paramGetPublicAccountDetailInfoResponse.certified_description.get();
    if (paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.has()) {
      this.unifiedDesrpition = paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get();
    }
    parser();
    this.mShowMsgFlag = -1;
    if (this.unifiedDesrpition != null)
    {
      initShowMsgFlag_v5_9();
      initLbsItem_v5_9();
      return;
    }
    initShowMsgFlag(paramGetPublicAccountDetailInfoResponse);
    initLbsItem(paramGetPublicAccountDetailInfoResponse);
  }
  
  public void clone(AccountDetail paramAccountDetail)
  {
    this.uin = paramAccountDetail.uin;
    this.seqno = paramAccountDetail.seqno;
    this.name = paramAccountDetail.name;
    this.summary = paramAccountDetail.summary;
    this.isRecvMsg = paramAccountDetail.isRecvMsg;
    this.followType = paramAccountDetail.followType;
    this.isShowFollowButton = paramAccountDetail.isShowFollowButton;
    this.accountData = paramAccountDetail.accountData;
    this.groupInfoList = paramAccountDetail.groupInfoList;
    this.displayNumber = paramAccountDetail.displayNumber;
    this.groupId = paramAccountDetail.groupId;
    this.isRecvPush = paramAccountDetail.isRecvPush;
    this.isSyncLbs = paramAccountDetail.isSyncLbs;
    this.certifiedGrade = paramAccountDetail.certifiedGrade;
    this.showFlag = paramAccountDetail.showFlag;
    this.accountFlag = paramAccountDetail.accountFlag;
    this.accountFlag2 = paramAccountDetail.accountFlag2;
    this.mShowMsgFlag = paramAccountDetail.mShowMsgFlag;
    this.configBackgroundColor = paramAccountDetail.configBackgroundColor;
    this.configBackgroundImg = paramAccountDetail.configBackgroundImg;
    this.newGroupInfoList = paramAccountDetail.newGroupInfoList;
    this.certifiedDescription = paramAccountDetail.certifiedDescription;
    this.isAgreeSyncLbs = paramAccountDetail.isAgreeSyncLbs;
    this.isSyncLbsSelected = paramAccountDetail.isSyncLbsSelected;
    this.unifiedDesrpition = paramAccountDetail.unifiedDesrpition;
    this.paConfigAttrs = paramAccountDetail.paConfigAttrs;
    this.customConfigAttrs = paramAccountDetail.customConfigAttrs;
    this.fullscreenConfigAttrs = paramAccountDetail.fullscreenConfigAttrs;
    this.cardStyle = paramAccountDetail.cardStyle;
  }
  
  void initLbsItem(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    int i;
    int k;
    if ((paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) && (!paramGetPublicAccountDetailInfoResponse.config_group_info_new.isEmpty()))
    {
      paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
      if ((paramGetPublicAccountDetailInfoResponse != null) && (paramGetPublicAccountDetailInfoResponse.size() > 0))
      {
        paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.iterator();
        i = 0;
        if (paramGetPublicAccountDetailInfoResponse.hasNext())
        {
          Object localObject = (mobileqq_mp.ConfigGroupInfo)paramGetPublicAccountDetailInfoResponse.next();
          k = i;
          if (((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has())
          {
            k = i;
            if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.isEmpty())
            {
              localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
              int j = i;
              label286:
              do
              {
                k = j;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
                i = j;
                if (localConfigInfo.type.has())
                {
                  i = j;
                  if (localConfigInfo.type.get() == 2)
                  {
                    i = j;
                    if (localConfigInfo.state_id.has())
                    {
                      i = j;
                      if (localConfigInfo.state_id.get() == 3)
                      {
                        this.isSyncLbs = true;
                        if (!localConfigInfo.state.has()) {}
                      }
                    }
                  }
                }
                switch (localConfigInfo.state.get())
                {
                default: 
                  if (QLog.isColorLevel()) {
                    QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + localConfigInfo.state.get());
                  }
                  i = 1;
                  j = i;
                }
              } while (i == 0);
              label292:
              if (i == 0) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.isSyncLbs = false;
      }
      return;
      this.isSyncLbsSelected = false;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label286;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = true;
      i = 1;
      break label286;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label286;
      break;
      i = k;
      break label292;
      continue;
      i = 0;
    }
  }
  
  void initLbsItem_v5_9()
  {
    if (this.paConfigAttrs == null) {
      return;
    }
    Iterator localIterator = this.paConfigAttrs.iterator();
    int i = 0;
    label20:
    int j;
    while (localIterator.hasNext())
    {
      Object localObject = (PaConfigAttr)localIterator.next();
      if ((((PaConfigAttr)localObject).jdField_a_of_type_Int != 1) && (((PaConfigAttr)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        localObject = ((PaConfigAttr)localObject).jdField_a_of_type_JavaUtilList.iterator();
        j = i;
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)((Iterator)localObject).next();
            i = j;
            if (localPaConfigInfo.jdField_a_of_type_Int == 2)
            {
              i = j;
              if (localPaConfigInfo.e == 3) {
                this.isSyncLbs = true;
              }
            }
            switch (localPaConfigInfo.d)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + localPaConfigInfo.d);
              }
              i = 1;
              label191:
              j = i;
              if (i != 0) {
                label197:
                if (i == 0) {}
              }
              break;
            }
          }
        }
      }
    }
    while (i == 0)
    {
      this.isSyncLbs = false;
      return;
      this.isSyncLbsSelected = false;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label191;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = true;
      i = 1;
      break label191;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label191;
      break label20;
      i = j;
      break label197;
    }
  }
  
  void initShowMsgFlag(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    if (paramGetPublicAccountDetailInfoResponse.config_group_info.has()) {
      parserMsgFlag(paramGetPublicAccountDetailInfoResponse.config_group_info.get());
    }
    if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) {
      parserMsgFlag(paramGetPublicAccountDetailInfoResponse.config_group_info_new.get());
    }
  }
  
  void initShowMsgFlag_v5_9()
  {
    if (this.paConfigAttrs == null) {}
    label20:
    label104:
    label124:
    for (;;)
    {
      return;
      Iterator localIterator = this.paConfigAttrs.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = (PaConfigAttr)localIterator.next();
        if ((((PaConfigAttr)localObject).jdField_a_of_type_Int != 1) && (((PaConfigAttr)localObject).jdField_a_of_type_JavaUtilList != null))
        {
          localObject = ((PaConfigAttr)localObject).jdField_a_of_type_JavaUtilList.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)((Iterator)localObject).next();
              if (localPaConfigInfo.e == 5) {
                if (localPaConfigInfo.d == 1)
                {
                  i = 1;
                  this.mShowMsgFlag = i;
                  i = 1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label124;
        }
        break label20;
        break;
        i = 0;
        break label104;
      }
    }
  }
  
  public void parser()
  {
    if (this.unifiedDesrpition == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.unifiedDesrpition);
      this.certifiedDescription = localJSONObject.optString("certified_description");
      this.configBackgroundColor = localJSONObject.optString("background_color");
      this.certifiedEnterprise = localJSONObject.optString("certified_enterprise");
      this.certifiedWeixin = localJSONObject.optString("certified_weixin");
      this.paConfigAttrs = PaConfigAttr.a(localJSONObject.optJSONArray("config_arr"));
      this.customConfigAttrs = PaConfigAttr.a(localJSONObject.optJSONArray("custom_arr"));
      this.fullscreenConfigAttrs = PaConfigAttr.a(localJSONObject.optJSONArray("fullscreen_arr"));
      this.cardStyle = localJSONObject.optInt("card_style");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void parserMsgFlag(List paramList)
  {
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (mobileqq_mp.ConfigGroupInfo)paramList.next();
        if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has()) {
          break label130;
        }
        localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
            if (localConfigInfo.state_id.get() == 5) {
              if (localConfigInfo.state.get() == 1)
              {
                i = 1;
                label110:
                this.mShowMsgFlag = i;
                i = 1;
              }
            }
          }
        }
      }
    }
    label130:
    for (;;)
    {
      if (i != 0)
      {
        return;
        i = 0;
        break label110;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.AccountDetail
 * JD-Core Version:    0.7.0.1
 */