package com.tencent.mobileqq.troop.homework.config;

import ajgi;
import ajgj;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BeginnerGuideDownloadManager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public BeginnerGuideDownloadManager(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    int i = j;
    if (!TextUtils.isEmpty(this.b))
    {
      if (!TextUtils.isEmpty(this.c)) {
        break label71;
      }
      i = j;
    }
    while (i != 0)
    {
      throw new IllegalArgumentException("args error");
      label71:
      i = j;
      if (a(this.jdField_a_of_type_JavaLangString)) {
        i = 0;
      }
    }
  }
  
  private static File a()
  {
    return new File(AppConstants.aJ + "homework_troop");
  }
  
  private void a(Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    ThreadManager.postImmediately(new ajgi(this, paramHandler, paramInt, paramBoolean), null, true);
    paramHandler.sendEmptyMessage(1111);
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    label162:
    label193:
    for (;;)
    {
      TroopManager localTroopManager;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.parseConfig");
        }
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        paramString = HomeworkConfig.a(paramString, "config.cfg");
        if (!paramBoolean) {
          break label162;
        }
        switch (paramInt)
        {
        case 5: 
        case 6: 
          if (QLog.isColorLevel()) {
            QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.parseConfig Publish not match");
          }
          label86:
          return;
        }
      }
      finally {}
      localTroopManager.a.a = paramString;
      continue;
      localTroopManager.a.b = paramString;
      continue;
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label193;
        }
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.parseConfig Submit not match");
        break label86;
        localTroopManager.a.c = paramString;
        break label86;
        localTroopManager.a.d = paramString;
        break label86;
        break;
        switch (paramInt)
        {
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    try
    {
      new URL(paramString);
      return true;
    }
    catch (MalformedURLException paramString) {}
    return false;
  }
  
  private static String b(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = MD5FileUtil.a(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, new Object[] { "BeginnerGuideDownloadManager$calcMD5", " md5:" + paramString + ", cost:" + (System.currentTimeMillis() - l) });
    }
    return paramString;
  }
  
  private boolean b(Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.postDownload");
    }
    File localFile1 = a();
    File localFile2 = new File(localFile1, this.b);
    Object localObject = this.b.substring(0, this.b.lastIndexOf("."));
    localFile1 = new File(localFile1, (String)localObject + "_src");
    if ((!localFile1.exists()) && (!localFile1.mkdirs()))
    {
      paramHandler.sendEmptyMessage(1120);
      return false;
    }
    localObject = new ArrayList();
    String[] arrayOfString = localFile1.list();
    String str = localFile1.getAbsolutePath();
    Message localMessage = Message.obtain();
    localMessage.what = 1110;
    localMessage.arg1 = paramInt;
    localMessage.obj = str;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.postDownload begin unzip");
      }
      ((ArrayList)localObject).addAll(ZipUtils.a(localFile2));
      if (Arrays.asList(arrayOfString).containsAll((Collection)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "zip file already unzip");
        }
        a(str, paramInt, paramBoolean);
        paramHandler.sendMessage(localMessage);
        return true;
      }
      ZipUtils.b(localFile2.getAbsolutePath(), localFile1.getAbsolutePath());
      if (Arrays.asList(localFile1.list()).containsAll((Collection)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "zip file unzip success");
        }
        a(str, paramInt, paramBoolean);
        paramHandler.sendMessage(localMessage);
        return true;
      }
      throw new Exception("trigger catch");
    }
    catch (Exception localException)
    {
      paramHandler.sendEmptyMessage(1120);
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "zip file unzip error ", localException);
      }
      paramHandler = ((ArrayList)localObject).iterator();
      while (paramHandler.hasNext())
      {
        File localFile3 = new File(localFile1, (String)paramHandler.next());
        if ((localFile3.exists()) && (!localFile3.delete()) && (QLog.isColorLevel())) {
          QLog.d("BeginnerGuideDownloadManager", 2, "zip file unzip del error");
        }
      }
    }
    return false;
  }
  
  public boolean a(Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.startDownload");
    }
    File localFile = a();
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return false;
    }
    localFile = new File(localFile, this.b);
    if ((localFile.exists()) && (this.c.equalsIgnoreCase(b(localFile.getAbsolutePath()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.startDownload: file exists, no need to start download again");
      }
      a(paramHandler, paramInt, paramBoolean);
      return true;
    }
    INetEngine localINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_Boolean = true;
    localHttpNetReq.jdField_e_of_type_Boolean = true;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ajgj(this, paramHandler, paramInt, paramBoolean);
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localHttpNetReq.c = localFile.getAbsolutePath();
    localHttpNetReq.jdField_e_of_type_Int = 0;
    localINetEngine.a(localHttpNetReq);
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.startDownload sendReq success");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager
 * JD-Core Version:    0.7.0.1
 */