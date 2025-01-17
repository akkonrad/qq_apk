package com.tencent.mobileqq.earlydownload.handler;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.xmldata.SystemFaceData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class SystemFaceHandler
  extends EarlyHandler
  implements Handler.Callback
{
  public static final String c = SystemFaceData.class.getSimpleName();
  private Handler a = new Handler(Looper.getMainLooper(), this);
  private ArrayList b;
  
  public SystemFaceHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.face.gifv9", paramQQAppInterface);
  }
  
  private void c(String paramString)
  {
    int j = 0;
    int i = j;
    try
    {
      int m = Integer.parseInt(paramString);
      i = j;
      int k = com.tencent.mobileqq.text.EmotcationConstants.a[m];
      i = j;
      j = com.tencent.mobileqq.text.EmotcationConstants.b[m];
      i = j;
      localURL = new URL("emotion", BaseApplicationImpl.getContext().getResources().getResourceEntryName(k), "");
      i = j;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject;
      do
      {
        for (;;)
        {
          URL localURL;
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, "reloadFaceOnUI() ", localMalformedURLException);
          }
          localObject = null;
        }
        Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(i);
        localObject = URLDrawable.getDrawable((URL)localObject, localDrawable, localDrawable, true);
        if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, "reloadFaceOnUI() idx=" + paramString + " d.status!=successed||loading. go to restartDownload");
          }
          ((URLDrawable)localObject).addHeader("faceIdx", paramString);
          ((URLDrawable)localObject).restartDownload();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(c, 2, "reloadFaceOnUI() idx=" + paramString + " d.status=" + ((URLDrawable)localObject).getStatus() + " do nothing..");
    }
    if (localURL == null) {
      return;
    }
  }
  
  public int a()
  {
    return 10055;
  }
  
  public Class a()
  {
    return SystemFaceData.class;
  }
  
  public String a()
  {
    return "actEarlySysFaceGif";
  }
  
  public void a(String paramString)
  {
    try
    {
      File localFile = BaseApplicationImpl.getContext().getDir("systemface", 0);
      FileUtils.a(paramString, localFile.getAbsolutePath(), true);
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "doOnDownloadFinish() uncompressZip to:" + localFile.getAbsolutePath());
      }
      super.a(paramString);
      this.a.sendEmptyMessage(196864);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(String paramString)
  {
    EarlyDownloadManager.a.lock();
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (!this.b.contains(paramString))
      {
        this.b.add(0, paramString);
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "addWaittingFace idx=" + paramString);
        }
      }
      return;
    }
    finally
    {
      EarlyDownloadManager.a.unlock();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = null;
      if ((this.b == null) || (this.b.size() <= 0)) {
        continue;
      }
      EarlyDownloadManager.a.lock();
      try
      {
        if (this.b.size() > 0) {
          paramMessage = (String)this.b.remove(0);
        }
        EarlyDownloadManager.a.unlock();
        if ((paramMessage == null) || (paramMessage.length() <= 0)) {
          continue;
        }
        c(paramMessage);
        if (this.b.size() <= 0) {
          continue;
        }
        this.a.sendEmptyMessageDelayed(196864, 2000L);
        return false;
      }
      finally
      {
        EarlyDownloadManager.a.unlock();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler
 * JD-Core Version:    0.7.0.1
 */