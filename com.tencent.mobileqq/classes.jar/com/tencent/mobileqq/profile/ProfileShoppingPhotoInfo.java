package com.tencent.mobileqq.profile;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileShoppingPhotoInfo
  extends Entity
{
  public static final int FOLLOW_TYPE_CANCEL_CARE = 3;
  public static final int FOLLOW_TYPE_NORMAL_CARE = 1;
  public static final int FOLLOW_TYPE_NOT_CARE = 2;
  public static final String TAG = "ProfileShoppingPhotoInfo";
  private static Object mLock = new Object();
  public static LRULinkedHashMap photoWinCache = new LRULinkedHashMap(20);
  public int accountFlag;
  public String bindShoppingNo;
  public int certifiedGrade;
  public int followType;
  public byte[] picByteData;
  public int seqNo;
  public String shopName;
  @unique
  public String uin;
  
  public static byte[] converPhoto2RawData(List paramList)
  {
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ShoppingPhotoItemInfo localShoppingPhotoItemInfo = (ShoppingPhotoItemInfo)paramList.next();
      if (localShoppingPhotoItemInfo != null) {
        ((List)localObject).add(localShoppingPhotoItemInfo.a());
      }
    }
    paramList = Parcel.obtain();
    paramList.setDataPosition(0);
    paramList.writeList((List)localObject);
    localObject = paramList.marshall();
    paramList.recycle();
    return localObject;
  }
  
  public static ProfileShoppingPhotoInfo getPhotoInfo(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileShoppingPhotoInfo", 2, "func getPhotoInfo begins");
    }
    for (;;)
    {
      synchronized (mLock)
      {
        localProfileShoppingPhotoInfo = (ProfileShoppingPhotoInfo)photoWinCache.get(paramString);
        if (localProfileShoppingPhotoInfo != null)
        {
          paramQQAppInterface = localProfileShoppingPhotoInfo;
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileShoppingPhotoInfo", 2, "func getPhotoInfo ends, in cache." + localProfileShoppingPhotoInfo.getPrintInfo());
            paramQQAppInterface = localProfileShoppingPhotoInfo;
          }
          return paramQQAppInterface;
        }
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      ProfileShoppingPhotoInfo localProfileShoppingPhotoInfo = (ProfileShoppingPhotoInfo)paramQQAppInterface.a(ProfileShoppingPhotoInfo.class, paramString);
      paramQQAppInterface.a();
      paramQQAppInterface = mLock;
      if ((localProfileShoppingPhotoInfo != null) && (paramString != null)) {}
      try
      {
        photoWinCache.put(paramString, localProfileShoppingPhotoInfo);
        paramQQAppInterface = localProfileShoppingPhotoInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramQQAppInterface = "";
        if (localProfileShoppingPhotoInfo != null) {
          paramQQAppInterface = localProfileShoppingPhotoInfo.getPrintInfo();
        }
        QLog.d("ProfileShoppingPhotoInfo", 2, "func getPhotoInfo ends, read from db." + paramQQAppInterface);
        return localProfileShoppingPhotoInfo;
      }
      finally {}
    }
  }
  
  public static List parseShoppingPhotoJson(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("config_arr");
        if ((paramString != null) && (paramString.length() != 0))
        {
          int k = paramString.length();
          int i = 0;
          while (i < k)
          {
            Object localObject = paramString.getJSONObject(i);
            if (1 == ((JSONObject)localObject).getInt("type"))
            {
              localObject = ((JSONObject)localObject).getJSONArray("config");
              if ((localObject != null) && (((JSONArray)localObject).length() > 0))
              {
                int m = ((JSONArray)localObject).length();
                int j = 0;
                while (j < m)
                {
                  ShoppingPhotoItemInfo localShoppingPhotoItemInfo = new ShoppingPhotoItemInfo();
                  localShoppingPhotoItemInfo.b = ((JSONArray)localObject).getJSONObject(j).getString("url");
                  localShoppingPhotoItemInfo.a = ((JSONArray)localObject).getJSONObject(j).getJSONArray("pic_url").getString(0);
                  localArrayList.add(localShoppingPhotoItemInfo);
                  j += 1;
                }
              }
            }
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Exception paramString) {}
    }
    QLog.w("ProfileShoppingPhotoInfo", 2, "parse json err:" + paramString.getMessage());
    return localArrayList;
  }
  
  public static void savePhotoInfo2DB(ProfileShoppingPhotoInfo paramProfileShoppingPhotoInfo, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileShoppingPhotoInfo", 2, "func savePhotoInfo2DB begins, photoInfo:" + paramProfileShoppingPhotoInfo);
    }
    if (paramProfileShoppingPhotoInfo == null) {
      return;
    }
    Object localObject = mLock;
    if (paramProfileShoppingPhotoInfo != null) {}
    for (;;)
    {
      try
      {
        if (paramProfileShoppingPhotoInfo.uin != null) {
          photoWinCache.put(paramProfileShoppingPhotoInfo.uin, paramProfileShoppingPhotoInfo);
        }
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (paramProfileShoppingPhotoInfo.getStatus() == 1000)
        {
          paramQQAppInterface.a(paramProfileShoppingPhotoInfo);
          paramQQAppInterface.a();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ProfileShoppingPhotoInfo", 2, "func savePhotoInfo2DB ends." + paramProfileShoppingPhotoInfo.getPrintInfo());
          return;
        }
      }
      finally {}
      paramQQAppInterface.a(paramProfileShoppingPhotoInfo);
    }
  }
  
  /* Error */
  public List getPhotoFromRawData()
  {
    // Byte code:
    //   0: new 51	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 52	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 245	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   12: ifnonnull +5 -> 17
    //   15: aload_3
    //   16: areturn
    //   17: invokestatic 84	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   20: astore_2
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 245	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 245	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   31: arraylength
    //   32: invokevirtual 249	android/os/Parcel:unmarshall	([BII)V
    //   35: aload_2
    //   36: iconst_0
    //   37: invokevirtual 87	android/os/Parcel:setDataPosition	(I)V
    //   40: aload_2
    //   41: aload_0
    //   42: invokevirtual 253	java/lang/Object:getClass	()Ljava/lang/Class;
    //   45: invokevirtual 259	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   48: invokevirtual 263	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +15 -> 70
    //   58: aload 4
    //   60: invokeinterface 266 1 0
    //   65: istore_1
    //   66: iload_1
    //   67: ifne +9 -> 76
    //   70: aload_2
    //   71: invokevirtual 98	android/os/Parcel:recycle	()V
    //   74: aload_3
    //   75: areturn
    //   76: aload 4
    //   78: invokeinterface 58 1 0
    //   83: astore 4
    //   85: aload 4
    //   87: invokeinterface 64 1 0
    //   92: ifeq +87 -> 179
    //   95: aload 4
    //   97: invokeinterface 68 1 0
    //   102: checkcast 268	java/lang/String
    //   105: astore 5
    //   107: new 70	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo
    //   110: dup
    //   111: invokespecial 197	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo:<init>	()V
    //   114: astore 6
    //   116: aload 6
    //   118: aload 5
    //   120: invokevirtual 270	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo:a	(Ljava/lang/String;)V
    //   123: aload_3
    //   124: aload 6
    //   126: invokeinterface 78 2 0
    //   131: pop
    //   132: goto -47 -> 85
    //   135: astore 4
    //   137: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +33 -> 173
    //   143: ldc 15
    //   145: iconst_2
    //   146: new 117	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 272
    //   156: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 4
    //   161: invokevirtual 218	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 221	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_2
    //   174: invokevirtual 98	android/os/Parcel:recycle	()V
    //   177: aload_3
    //   178: areturn
    //   179: aload_2
    //   180: invokevirtual 98	android/os/Parcel:recycle	()V
    //   183: goto -6 -> 177
    //   186: astore_3
    //   187: aload_2
    //   188: invokevirtual 98	android/os/Parcel:recycle	()V
    //   191: aload_3
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	ProfileShoppingPhotoInfo
    //   65	2	1	i	int
    //   20	168	2	localParcel	Parcel
    //   7	171	3	localArrayList	ArrayList
    //   186	6	3	localObject1	Object
    //   51	45	4	localObject2	Object
    //   135	25	4	localException	Exception
    //   105	14	5	str	String
    //   114	11	6	localShoppingPhotoItemInfo	ShoppingPhotoItemInfo
    // Exception table:
    //   from	to	target	type
    //   21	53	135	java/lang/Exception
    //   58	66	135	java/lang/Exception
    //   76	85	135	java/lang/Exception
    //   85	132	135	java/lang/Exception
    //   21	53	186	finally
    //   58	66	186	finally
    //   76	85	186	finally
    //   85	132	186	finally
    //   137	173	186	finally
  }
  
  public String getPrintInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/n Info->[uin]:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(",[seqNo]:");
    localStringBuilder.append(this.seqNo);
    localStringBuilder.append(",[followType]:");
    localStringBuilder.append(this.followType);
    localStringBuilder.append(",[accountFlag]:");
    localStringBuilder.append(this.accountFlag);
    localStringBuilder.append(",[shopName]:");
    localStringBuilder.append(this.shopName);
    localStringBuilder.append(",[bindShoppingNo]:");
    localStringBuilder.append(this.bindShoppingNo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo
 * JD-Core Version:    0.7.0.1
 */