package com.tencent.mobileqq.dating;

import abxv;
import abxw;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.CustomHandler;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class StrangerHdHeadUrlFetcher
  implements Handler.Callback
{
  public long a;
  private FriendListObserver a;
  public QQAppInterface a;
  protected EntityManager a;
  public Set a;
  public ConcurrentHashMap a;
  public MqqHandler a;
  public boolean a;
  
  public StrangerHdHeadUrlFetcher(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new abxw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_a_of_type_JavaUtilSet = new HashSet(20);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    if (paramInt1 == 4) {
      localStringBuilder.append("troop_").append(paramString);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt1 == 32) {
        localStringBuilder.append("stranger_").append(paramInt2).append("_").append(paramString);
      } else if (paramInt1 == 16) {
        localStringBuilder.append("qcall_").append(paramInt2).append("_").append(paramString);
      } else {
        localStringBuilder.append(paramString);
      }
    }
  }
  
  public static String a(int paramInt, String paramString, byte paramByte1, byte paramByte2)
  {
    return MsfSdkUtils.insertMtype("QQHeadIcon", paramString + String.valueOf(640));
  }
  
  private void a(String paramString)
  {
    localSet = this.jdField_a_of_type_JavaUtilSet;
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilSet.clear();
        if (this.jdField_a_of_type_JavaUtilSet.isEmpty())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          this.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || ((paramInt != 200) && (paramInt != 202) && (paramInt != 204)))
    {
      DatingUtil.a("StrangerHdHeadUrlFetcher", new Object[] { "uinOrMobileNum is null or empty" });
      return "";
    }
    String str2 = a(32, paramInt, paramString);
    String str1 = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
    if (TextUtils.isEmpty(str1))
    {
      ??? = (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, str2);
      if ((??? != null) && (!TextUtils.isEmpty(((Setting)???).url)))
      {
        str1 = a(32, ((Setting)???).url, ((Setting)???).bHeadType, ((Setting)???).bFaceFlags);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, str1);
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        this.jdField_a_of_type_JavaUtilSet.remove(str2);
        ThreadManager.post(new abxv(this, paramString, paramInt, paramBoolean, str2), 8, null, false);
        return str1;
      }
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilSet.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
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
      long l = Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if ((l < 0L) || (l > 60000L)) {
        a(null);
      } else if (!this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageAtTime(1, 60000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher
 * JD-Core Version:    0.7.0.1
 */