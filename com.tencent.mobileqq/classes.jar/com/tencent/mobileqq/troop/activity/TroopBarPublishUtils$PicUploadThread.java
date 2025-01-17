package com.tencent.mobileqq.troop.activity;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class TroopBarPublishUtils$PicUploadThread
  implements Runnable
{
  private long a;
  protected Handler a;
  protected String a;
  protected final ArrayList a;
  protected WeakReference a;
  protected boolean a;
  protected String b;
  
  public TroopBarPublishUtils$PicUploadThread(BaseActivity paramBaseActivity, Handler paramHandler, ArrayList paramArrayList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = "2";
  }
  
  public TroopBarPublishUtils$PicUploadThread(BaseActivity paramBaseActivity, Handler paramHandler, ArrayList paramArrayList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt1);
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void run()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (BaseActivity localBaseActivity = null; this.jdField_a_of_type_JavaUtilArrayList.size() == 0; localBaseActivity = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "PicUploadThread path list is null!");
      }
      a(1001, null, -2, 0);
      return;
    }
    if ((localBaseActivity == null) || (localBaseActivity.app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "PicUploadThread activity is null!");
      }
      a(1001, this.jdField_a_of_type_JavaUtilArrayList.get(0), -1, 0);
      return;
    }
    String str1 = localBaseActivity.app.getCurrentAccountUin();
    String str2 = ((TicketManager)localBaseActivity.app.getManager(2)).getSkey(str1);
    if (TextUtils.isEmpty(str2))
    {
      a(1001, this.jdField_a_of_type_JavaUtilArrayList.get(0), 1000, 0);
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(str3) == null)
      {
        if ((localBaseActivity.isFinishing()) || (this.jdField_a_of_type_Boolean))
        {
          a(1001, str3, 1003, 0);
          return;
        }
        Object localObject = MediaApiPlugin.a(str3, 0);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          a(1001, str3, 1001, 0);
          if (QLog.isColorLevel()) {
            QLog.d("TroopBarPublishUtils", 2, "scalePublishImage failed: path = " + str3);
          }
        }
        else
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("type", this.b);
          localObject = TroopBarUtils.a(this.jdField_a_of_type_JavaLangString, localBaseActivity, (String)localObject, str1, str2, localHashMap);
          if (localObject != null)
          {
            localObject = new TroopBarPublishActivity.Pic_list((JSONObject)localObject);
            TroopBarUtils.a.put(str3, localObject);
          }
          else
          {
            a(1001, str3, 1002, 0);
            if (QLog.isColorLevel()) {
              QLog.d("TroopBarPublishUtils", 2, "singleUploadImage failed: path = " + str3);
            }
          }
        }
      }
    }
    a(1003, this.jdField_a_of_type_JavaUtilArrayList.get(0), 0, (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.PicUploadThread
 * JD-Core Version:    0.7.0.1
 */