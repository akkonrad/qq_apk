package com.tencent.mobileqq.activity.richmedia.trimvideo.video.mediadevice;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.cache.SDCardMountMonitorReceiver.SDCardMountStateListener;
import java.io.File;

public class StorageManager
  implements SDCardMountMonitorReceiver.SDCardMountStateListener
{
  private static StorageManager jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private StorageManager.OnSdCardChangedListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener;
  private String jdField_a_of_type_JavaLangString = "";
  
  private StorageManager()
  {
    a();
    SDCardMountMonitorReceiver.a().a(this);
  }
  
  public static StorageManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager = new StorageManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = CacheManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "updateStorePath, storeVideoPath=" + this.jdField_a_of_type_JavaLangString);
    }
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StorageManager", 2, "create root path directory error", localException);
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StorageManager", 2, "sdcard mount receiver, isMount=" + paramBoolean);
    }
    String str = CacheManager.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener != null) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener.a(1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoMediadeviceStorageManager$OnSdCardChangedListener.a(0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.mediadevice.StorageManager
 * JD-Core Version:    0.7.0.1
 */