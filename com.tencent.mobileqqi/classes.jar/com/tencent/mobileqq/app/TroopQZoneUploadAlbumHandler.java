package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QzonePluginProxyActivity;
import flt;
import flu;
import flv;
import flw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopQZoneUploadAlbumHandler
  extends BusinessHandler
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "UploadPhoto";
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new flu(this);
  public Handler a;
  public Messenger a;
  public SparseArray a;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public Messenger b;
  
  TroopQZoneUploadAlbumHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_b_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidOsHandler = new flt(this, Looper.getMainLooper(), paramQQAppInterface);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsMessenger == null) {
      return;
    }
    Message localMessage = Message.obtain(null, 998, paramInt, 0);
    localMessage.replyTo = this.jdField_b_of_type_AndroidOsMessenger;
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private void a(int paramInt1, flw paramflw, int paramInt2, int paramInt3)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), paramflw, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) };
    localMessage.sendToTarget();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      a();
    }
    while (this.jdField_a_of_type_AndroidOsMessenger == null) {
      return;
    }
    Message localMessage = Message.obtain(null, 999, paramInt, 0);
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Intent localIntent = QzonePluginProxyActivity.a();
    BaseApplication.getContext().startService(localIntent);
    this.jdField_a_of_type_Boolean = BaseApplication.getContext().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  protected Class a()
  {
    return TroopQZoneUploadAlbumObserver.class;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      BaseApplication.getContext().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    flw localflw = (flw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2, null);
    if (localflw == null) {
      return;
    }
    a(paramInt2, localflw, paramInt1, paramInt3);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, new flw(this, paramString, paramLong));
    d();
    a(paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (flv)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((flv)localObject).a();
      localObject = ((flv)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((TroopQZoneUploadAlbumHandler.Callback)localObject).a(localView, paramLong, paramInt1, paramInt2);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
    }
  }
  
  public void a(View paramView, TroopQZoneUploadAlbumHandler.Callback paramCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      flv localflv = (flv)localIterator.next();
      if (localflv.a() == paramView)
      {
        localflv.b = new WeakReference(paramCallback);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new flv(this, paramView, paramCallback));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject1 = paramQQAppInterface.a().a(paramString, 1, paramLong);
    if (localObject1 == null)
    {
      b(paramInt1);
      return;
    }
    if (((MessageRecord)localObject1).msgtype == -2011)
    {
      localObject2 = ((MessageForStructing)localObject1).structingMsg;
      if (!(localObject2 instanceof StructMsgForGeneralShare)) {}
    }
    for (Object localObject2 = (StructMsgForGeneralShare)localObject2;; localObject2 = null)
    {
      if ((localObject2 == null) || (((StructMsgForGeneralShare)localObject2).getProgress() < 0))
      {
        b(paramInt1);
        return;
      }
      if ((paramInt2 == 1001) && (((MessageRecord)localObject1).extraflag != 32768))
      {
        ((StructMsgForGeneralShare)localObject2).setSummary(BaseApplication.getContext().getResources().getString(2131563145));
        ((StructMsgForGeneralShare)localObject2).setProgress(paramInt3);
        return;
      }
      paramInt1 = 32772;
      localObject1 = BaseApplication.getContext().getResources().getString(2131563142);
      if ((paramInt2 == 1000) || (paramInt2 == 1004))
      {
        localObject1 = BaseApplication.getContext().getResources().getString(2131563142);
        paramInt1 = 32772;
      }
      for (;;)
      {
        ((StructMsgForGeneralShare)localObject2).setProgress(100);
        ((StructMsgForGeneralShare)localObject2).setSummary((String)localObject1);
        ((StructMsgForGeneralShare)localObject2).mMsgBrief = ("图片" + (String)localObject1);
        paramQQAppInterface.a().d(paramString, 1, paramLong);
        paramQQAppInterface.a().a(paramString, 1, paramLong, paramInt1, 0);
        paramQQAppInterface.a().a(paramString, 1, paramLong, ((StructMsgForGeneralShare)localObject2).getBytes());
        a(999, true, paramString);
        return;
        if (paramInt2 == 1003)
        {
          localObject1 = BaseApplication.getContext().getResources().getString(2131563146);
          paramInt1 = 32768;
        }
        else if (paramInt2 == 1005)
        {
          localObject1 = BaseApplication.getContext().getResources().getString(2131563140);
          paramInt1 = 32770;
          ((StructMsgForGeneralShare)localObject2).mMsgActionData = "";
          ((StructMsgForGeneralShare)localObject2).mMsg_A_ActionData = "";
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public boolean a()
  {
    a();
    Intent localIntent = QzonePluginProxyActivity.a();
    try
    {
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void c()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler
 * JD-Core Version:    0.7.0.1
 */