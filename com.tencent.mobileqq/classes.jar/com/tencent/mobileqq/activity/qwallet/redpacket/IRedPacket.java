package com.tencent.mobileqq.activity.qwallet.redpacket;

import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public abstract interface IRedPacket
{
  public abstract JSONObject getPopAd(int paramInt1, int paramInt2);
  
  public abstract List getReadyResList();
  
  public abstract void getSkin(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener);
  
  public abstract JSONObject getTail(int paramInt1, int paramInt2);
  
  public abstract void getVoiceRateRes(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener);
  
  public abstract boolean isRiskSwitchOpen();
  
  public abstract void onActiveAccount();
  
  public abstract void onUpdate(int paramInt);
  
  public abstract void registRedPacketSkinListObserver(BusinessObserver paramBusinessObserver);
  
  public abstract void reqGroupAvailableList(String paramString, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener);
  
  public abstract void requestRedPacketSkinList();
  
  public abstract void setSelectedSkin(int paramInt, BusinessObserver paramBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket
 * JD-Core Version:    0.7.0.1
 */