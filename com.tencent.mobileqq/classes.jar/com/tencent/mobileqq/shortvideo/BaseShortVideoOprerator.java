package com.tencent.mobileqq.shortvideo;

import ahye;
import ahyf;
import ahyg;
import ahyh;
import ahyj;
import ahzf;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements ahzf, DownCallBack, UpCallBack, InfoBuilder
{
  public static int d = 3;
  protected Handler a;
  public QQAppInterface a;
  public MessageRecord a;
  public ShortVideoReq a;
  protected UiCallBack a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new ahye(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ShortVideoReq paramShortVideoReq)
  {
    ThreadManager.post(new ahyf(paramQQAppInterface, paramShortVideoReq), 8, null, false);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramErrInfo;
    localShortVideoResult.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localShortVideoResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.g, this.f, paramErrInfo.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    Logger.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    ShortVideoResult localShortVideoResult = paramShortVideoResult;
    if (paramShortVideoResult == null) {
      localShortVideoResult = new ShortVideoResult();
    }
    localShortVideoResult.jdField_a_of_type_Int = 0;
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    a(paramInt, 0, localShortVideoResult);
    Logger.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.jdField_a_of_type_Int = 0;
    localShortVideoResult.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localShortVideoResult);
  }
  
  public void a(Message paramMessage)
  {
    Logger.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack == null) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        paramMessage = (ShortVideoResult)paramMessage.obj;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (ShortVideoResult)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (ShortVideoResult)paramMessage.obj;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = null;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    if (GoldMsgChatHelper.a(paramMessageRecord.istroop)) {
      GoldMsgChatHelper.a().a(paramMessageRecord);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Logger.a(this.g, this.f, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (paramDownResult == null)
    {
      paramDownResult = new PicInfoInterface.ErrInfo();
      paramDownResult.jdField_b_of_type_JavaLangString = "result == null";
      paramDownResult.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramDownResult);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
    Logger.a(this.g, this.f, "onDownload", "result:" + paramDownResult.jdField_a_of_type_Int);
    Object localObject = new ShortVideoResult();
    ((ShortVideoResult)localObject).jdField_a_of_type_Int = paramDownResult.jdField_a_of_type_Int;
    ((ShortVideoResult)localObject).jdField_a_of_type_JavaLangObject = paramDownResult;
    if (paramDownResult.jdField_a_of_type_Int == 0)
    {
      a(0, (ShortVideoResult)localObject);
      return;
    }
    if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
    {
      localObject = new PicInfoInterface.ErrInfo();
      ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = (paramDownResult.jdField_b_of_type_Int + "_" + paramDownResult.jdField_a_of_type_JavaLangString);
      ((PicInfoInterface.ErrInfo)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (PicInfoInterface.ErrInfo)localObject);
      return;
    }
    a(0, paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    Logger.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramShortVideoDownloadInfo))
    {
      b(paramShortVideoDownloadInfo);
      return;
    }
    DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
    localDownResult.jdField_a_of_type_Int = -1;
    localDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramShortVideoDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    a(localDownResult);
  }
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    Logger.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramShortVideoForwardInfo)) {
      ThreadManager.getSubThreadHandler().post(new ahyg(this, paramShortVideoForwardInfo));
    }
    while (paramShortVideoForwardInfo == null) {
      return;
    }
    a(3, paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    Logger.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramShortVideoUploadInfo)) {
      ThreadManager.getSubThreadHandler().post(new ahyj(this, paramShortVideoUploadInfo));
    }
    while (paramShortVideoUploadInfo == null) {
      return;
    }
    a(2, paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = paramUiCallBack;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseShortVideoOprerator", 2, "multiForwardShortVideo start:" + Thread.currentThread().getId());
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(3, -1, null);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ahyh(this, paramArrayList));
  }
  
  boolean a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    if (paramShortVideoDownloadInfo != null)
    {
      Logger.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + paramShortVideoDownloadInfo);
      return paramShortVideoDownloadInfo.a();
    }
    Logger.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    if (paramShortVideoForwardInfo != null)
    {
      Logger.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + paramShortVideoForwardInfo);
      return paramShortVideoForwardInfo.a();
    }
    Logger.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    if (paramShortVideoUploadInfo != null)
    {
      Logger.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + paramShortVideoUploadInfo);
      return paramShortVideoUploadInfo.a();
    }
    Logger.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(2, null);
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      localObject = new ShortVideoResult();
      ((ShortVideoResult)localObject).jdField_a_of_type_Int = 0;
      ((ShortVideoResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(2, (ShortVideoResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
    a(2, (PicInfoInterface.ErrInfo)localObject);
  }
  
  void b(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    long l = System.currentTimeMillis();
    paramShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = paramShortVideoDownloadInfo.jdField_b_of_type_JavaLangString;
    localTransferRequest.jdField_c_of_type_JavaLangString = paramShortVideoDownloadInfo.jdField_c_of_type_JavaLangString;
    localTransferRequest.d = paramShortVideoDownloadInfo.d;
    localTransferRequest.jdField_a_of_type_Int = paramShortVideoDownloadInfo.jdField_b_of_type_Int;
    localTransferRequest.jdField_a_of_type_Long = paramShortVideoDownloadInfo.jdField_a_of_type_Long;
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.jdField_e_of_type_Int = paramShortVideoDownloadInfo.jdField_a_of_type_Int;
    localTransferRequest.jdField_g_of_type_Int = paramShortVideoDownloadInfo.f;
    localTransferRequest.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramShortVideoDownloadInfo.jdField_g_of_type_Int);
    localTransferRequest.jdField_g_of_type_Boolean = paramShortVideoDownloadInfo.jdField_a_of_type_Boolean;
    if ((paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1001) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1003) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1005) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1002) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1004) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1006)) {
      localTransferRequest.f = paramShortVideoDownloadInfo.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack != null) {
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = this;
    }
    switch (paramShortVideoDownloadInfo.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a != null)) {
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramShortVideoDownloadInfo.jdField_e_of_type_Int + "downloadvideo MD5==" + paramShortVideoDownloadInfo.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
      Logger.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
      return;
      localTransferRequest.jdField_b_of_type_Int = 7;
      localTransferRequest.i = (paramShortVideoDownloadInfo.i + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 16;
      localTransferRequest.i = (paramShortVideoDownloadInfo.i + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 18;
      localTransferRequest.i = (paramShortVideoDownloadInfo.i + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 6;
      localTransferRequest.i = (paramShortVideoDownloadInfo.h + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_c_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 9;
      localTransferRequest.i = (paramShortVideoDownloadInfo.h + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_c_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 17;
      localTransferRequest.i = (paramShortVideoDownloadInfo.h + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */