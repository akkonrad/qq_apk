package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoPTVItemBuilder$EncodeHandler
  extends Handler
{
  public ShortVideoPTVItemBuilder$EncodeHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        return;
        i = paramMessage.arg1;
        paramMessage = paramMessage.getData();
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "ret is " + i);
      QLog.i("ShortVideoPTVItemBuilder", 2, "data is " + paramMessage);
      return;
      i = paramMessage.arg1;
      switch (paramMessage.arg1)
      {
      default: 
        return;
      }
      paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "ret is " + i);
    QLog.i("ShortVideoPTVItemBuilder", 2, "targetFile is " + paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.EncodeHandler
 * JD-Core Version:    0.7.0.1
 */