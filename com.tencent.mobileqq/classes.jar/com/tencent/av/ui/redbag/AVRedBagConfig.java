package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.IAVRedPacketCallback;
import kdu;
import kdv;

public class AVRedBagConfig
  extends SubHandleBase
{
  public IAVRedPacketCallback a;
  public AVRedBagConfig.Info a;
  
  AVRedBagConfig(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
    this.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback = new kdu(this);
  }
  
  void a()
  {
    kdv localkdv = new kdv(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localkdv);
  }
  
  public void a(AVRedBagConfig.Info paramInfo)
  {
    AVRedBagMgr localAVRedBagMgr = a();
    if (localAVRedBagMgr == null) {
      return;
    }
    localAVRedBagMgr.a(paramInfo);
  }
  
  public void b(AVRedBagConfig.Info paramInfo)
  {
    AVRedBagMgr localAVRedBagMgr = a();
    if (localAVRedBagMgr == null) {
      return;
    }
    localAVRedBagMgr.b(paramInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagConfig
 * JD-Core Version:    0.7.0.1
 */