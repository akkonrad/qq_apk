package cooperation.qzone;

import amsd;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.share.QZoneShareActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneShareManager
{
  public static int a;
  public static String a;
  private static ConcurrentHashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "UploadFail", "上传失败");
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int i = paramOptions.outWidth;
    if ((j > paramInt2) || (i > paramInt1))
    {
      paramInt2 = Math.round(j / paramInt2);
      paramInt1 = Math.round(i / paramInt1);
      if (paramInt2 < paramInt1) {
        paramInt1 = paramInt2;
      }
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 2;
      }
      return paramInt2;
      continue;
      paramInt1 = 2;
    }
  }
  
  public static final long a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return 0L;
      paramIntent = paramIntent.getBundleExtra("share_data");
    } while (paramIntent == null);
    return paramIntent.getLong("req_share_id", 0L);
  }
  
  public static final Bundle a(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        String str = (String)localArrayList.get(i);
        if ((!HttpUtil.a(str)) && (!FileUtil.a(str))) {
          localArrayList.remove(i);
        }
        i -= 1;
      }
      while (localArrayList.size() > 9) {
        localArrayList.remove(9);
      }
      if (localArrayList.size() > 0)
      {
        if (HttpUtil.a((String)localArrayList.get(0)))
        {
          i = localArrayList.size() - 1;
          while (i >= 0)
          {
            if (!HttpUtil.a((String)localArrayList.get(i))) {
              localArrayList.remove(i);
            }
            i -= 1;
          }
        }
        i = localArrayList.size() - 1;
        while (i >= 0)
        {
          if (i != 0) {
            localArrayList.remove(i);
          }
          i -= 1;
        }
      }
      paramBundle.putStringArrayList("image_url", localArrayList);
    }
    return paramBundle;
  }
  
  public static OpenID a(AppRuntime paramAppRuntime, String paramString, BusinessObserver paramBusinessObserver)
  {
    Object localObject = (OpenID)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "get openid key = " + paramString);
    }
    paramAppRuntime = (AccountManager)paramAppRuntime.getManager(0);
    localObject = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    ((HashMap)localObject).put("RequestCustomSig", localRequestCustomSig);
    ((HashMap)localObject).put("OpenAppid", paramString);
    paramAppRuntime.changeToken((HashMap)localObject, new amsd(paramString, paramBusinessObserver));
    return null;
  }
  
  /* Error */
  public static File a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokestatic 187	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 5
    //   11: aload_0
    //   12: invokestatic 189	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 6
    //   17: new 40	android/graphics/BitmapFactory$Options
    //   20: dup
    //   21: invokespecial 190	android/graphics/BitmapFactory$Options:<init>	()V
    //   24: astore_2
    //   25: aload_2
    //   26: iconst_1
    //   27: putfield 194	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   30: aload_0
    //   31: aload_2
    //   32: invokestatic 200	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   35: pop
    //   36: aload_2
    //   37: aload_2
    //   38: sipush 640
    //   41: sipush 640
    //   44: invokestatic 202	cooperation/qzone/QZoneShareManager:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   47: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   50: aload_2
    //   51: iconst_0
    //   52: putfield 194	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   55: aload_0
    //   56: aload_2
    //   57: invokestatic 200	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: astore_0
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: ifnull +85 -> 149
    //   67: aload_3
    //   68: astore_2
    //   69: aload 5
    //   71: ifnull +78 -> 149
    //   74: aload_0
    //   75: astore_2
    //   76: new 207	java/io/File
    //   79: dup
    //   80: aload 5
    //   82: new 119	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   89: iload_1
    //   90: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: aload 6
    //   95: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore_3
    //   105: aload_0
    //   106: astore_2
    //   107: new 215	java/io/FileOutputStream
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   115: astore 5
    //   117: aload_0
    //   118: astore_2
    //   119: aload_0
    //   120: getstatic 224	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   123: bipush 50
    //   125: aload 5
    //   127: invokevirtual 230	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   130: ifeq +17 -> 147
    //   133: aload_0
    //   134: astore_2
    //   135: aload 5
    //   137: invokevirtual 233	java/io/FileOutputStream:flush	()V
    //   140: aload_0
    //   141: astore_2
    //   142: aload 5
    //   144: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   147: aload_3
    //   148: astore_2
    //   149: aload_2
    //   150: astore_3
    //   151: aload_0
    //   152: ifnull +21 -> 173
    //   155: aload_2
    //   156: astore_3
    //   157: aload_0
    //   158: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   161: ifne +12 -> 173
    //   164: aload_0
    //   165: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   168: invokestatic 247	java/lang/System:gc	()V
    //   171: aload_2
    //   172: astore_3
    //   173: aload_3
    //   174: areturn
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_0
    //   179: astore_2
    //   180: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +14 -> 197
    //   186: aload_0
    //   187: astore_2
    //   188: ldc 117
    //   190: iconst_2
    //   191: ldc 249
    //   193: aload_3
    //   194: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload 4
    //   199: astore_3
    //   200: aload_0
    //   201: ifnull -28 -> 173
    //   204: aload 4
    //   206: astore_3
    //   207: aload_0
    //   208: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   211: ifne -38 -> 173
    //   214: aload_0
    //   215: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   218: invokestatic 247	java/lang/System:gc	()V
    //   221: aconst_null
    //   222: areturn
    //   223: astore_3
    //   224: aconst_null
    //   225: astore_0
    //   226: aload_0
    //   227: astore_2
    //   228: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +14 -> 245
    //   234: aload_0
    //   235: astore_2
    //   236: ldc 117
    //   238: iconst_2
    //   239: ldc 255
    //   241: aload_3
    //   242: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: aload 4
    //   247: astore_3
    //   248: aload_0
    //   249: ifnull -76 -> 173
    //   252: aload 4
    //   254: astore_3
    //   255: aload_0
    //   256: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   259: ifne -86 -> 173
    //   262: aload_0
    //   263: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   266: invokestatic 247	java/lang/System:gc	()V
    //   269: aconst_null
    //   270: areturn
    //   271: astore_0
    //   272: aconst_null
    //   273: astore_2
    //   274: aload_2
    //   275: ifnull +17 -> 292
    //   278: aload_2
    //   279: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   282: ifne +10 -> 292
    //   285: aload_2
    //   286: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   289: invokestatic 247	java/lang/System:gc	()V
    //   292: aload_0
    //   293: athrow
    //   294: astore_0
    //   295: goto -21 -> 274
    //   298: astore_3
    //   299: goto -73 -> 226
    //   302: astore_3
    //   303: goto -125 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramString	String
    //   0	306	1	paramInt	int
    //   24	262	2	localObject1	Object
    //   4	170	3	localObject2	Object
    //   175	19	3	localException1	Exception
    //   199	8	3	localObject3	Object
    //   223	19	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   247	8	3	localObject4	Object
    //   298	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   302	1	3	localException2	Exception
    //   1	252	4	localObject5	Object
    //   9	134	5	localObject6	Object
    //   15	79	6	str	String
    // Exception table:
    //   from	to	target	type
    //   17	61	175	java/lang/Exception
    //   17	61	223	java/lang/OutOfMemoryError
    //   17	61	271	finally
    //   76	105	294	finally
    //   107	117	294	finally
    //   119	133	294	finally
    //   135	140	294	finally
    //   142	147	294	finally
    //   180	186	294	finally
    //   188	197	294	finally
    //   228	234	294	finally
    //   236	245	294	finally
    //   76	105	298	java/lang/OutOfMemoryError
    //   107	117	298	java/lang/OutOfMemoryError
    //   119	133	298	java/lang/OutOfMemoryError
    //   135	140	298	java/lang/OutOfMemoryError
    //   142	147	298	java/lang/OutOfMemoryError
    //   76	105	302	java/lang/Exception
    //   107	117	302	java/lang/Exception
    //   119	133	302	java/lang/Exception
    //   135	140	302	java/lang/Exception
    //   142	147	302	java/lang/Exception
  }
  
  public static final ArrayList a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    jdField_a_of_type_Int = 0;
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        Object localObject2 = (String)paramArrayList.get(i);
        if (!FileUtil.a((String)localObject2)) {
          break label443;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneShare", 4, "local url:" + (String)localObject2);
        }
        Object localObject1 = localObject2;
        if (FileUtil.a((String)localObject2) > 2097152L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 4, "file length:" + FileUtil.a((String)localObject2));
          }
          localObject2 = a((String)localObject2, i);
          if (localObject2 == null) {
            break;
          }
          localObject1 = ((File)localObject2).getAbsolutePath();
          localArrayList.add(localObject2);
        }
        localObject2 = new HashMap();
        ((Map)localObject2).put("Connection", "keep-alive");
        ((Map)localObject2).put("Referer", "http://www.qq.com");
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("type", paramString3);
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("share_image", localObject1);
        localObject1 = HttpUtil.a(MsfSdkUtils.insertMtype("qzPicu", "http://cgi.connect.qq.com/qqconnectopen/upload_share_image"), paramString1, paramString2, localHashMap1, localHashMap2, (Map)localObject2);
        if (localObject1 == null) {
          break label443;
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).getInt("retcode") == 0)
          {
            localObject1 = ((JSONObject)localObject1).getJSONObject("result");
            if (localObject1 != null)
            {
              paramArrayList.set(i, ((JSONObject)localObject1).getString("url"));
              if (QLog.isColorLevel()) {
                QLog.d("QZoneShare", 4, "target url:" + ((JSONObject)localObject1).getString("url"));
              }
            }
          }
          else
          {
            jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("retcode");
            QLog.d("QZoneShare", 1, "upload fail, code = " + jdField_a_of_type_Int);
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            break label443;
          }
        }
        QLog.d("QZoneShare", 4, localJSONException.getMessage());
        break label443;
      }
      a(localArrayList);
      return paramArrayList;
      label443:
      i += 1;
    }
  }
  
  public static final void a(Context paramContext, String paramString1, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt, String paramString2, String paramString3)
  {
    paramString3 = new QZoneShareData();
    paramString3.jdField_b_of_type_JavaLangString = (paramString2 + "正在发放红包");
    paramString3.c = "快来我的空间领取";
    paramString3.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramString3.jdField_a_of_type_JavaUtilArrayList.add("http://qzonestyle.gtimg.cn/aoi/sola/20161111222053_4wlQcl1Eta.png");
    paramString3.d = ("https://h5.qzone.qq.com/redpacket/share?_wv=1&_ws=1&uin=" + paramString1);
    paramString3.jdField_b_of_type_Int = 0;
    paramString3.f = paramString1;
    a(paramContext, paramString1, paramString3, paramOnDismissListener, paramInt);
  }
  
  public static final void a(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "shareToQzone()");
    }
    if ((paramContext == null) || (paramQZoneShareData == null))
    {
      QLog.e("QZoneShare", 1, "shareToQzone() params error");
      return;
    }
    com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
    try
    {
      paramOnDismissListener = new Intent(paramContext, QZoneShareActivity.class);
      paramOnDismissListener.putExtra("qzone_uin", paramString);
      paramOnDismissListener.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      ((Activity)paramContext).startActivityForResult(paramOnDismissListener, paramInt);
      return;
    }
    catch (Exception paramOnDismissListener)
    {
      paramOnDismissListener = new Intent(paramContext, QZoneShareActivity.class);
      paramOnDismissListener.putExtra("qzone_uin", paramString);
      paramOnDismissListener.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      paramOnDismissListener.addFlags(268435456);
      paramContext.startActivity(paramOnDismissListener);
    }
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    a(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "publishToQzone()");
    }
    if ((paramBundle == null) || (paramAppInterface == null))
    {
      QLog.d("QZoneShare", 1, "publishToQzone() params error");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", paramAppInterface.getAccount());
    localIntent.putExtra("key_share_is_third_party", true);
    ArrayList localArrayList = paramBundle.getStringArrayList("images");
    if ((localArrayList != null) && (localArrayList.size() > 9)) {}
    for (String str1 = "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity";; str1 = "com.qzone.publish.ui.activity.QZonePublishMoodActivity")
    {
      if (!a(paramBundle.getString("hulian_appid")))
      {
        String str2 = paramBundle.getString("file_send_path");
        if (((localArrayList != null) && (localArrayList.size() > 0)) || (!TextUtils.isEmpty(str2)))
        {
          paramBundle.putString("summary", "");
          paramBundle.putString("defaultText", "");
        }
      }
      localIntent.putExtras(paramBundle);
      QzonePluginProxyActivity.a(localIntent, str1);
      com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
      try
      {
        paramBundle = QZoneHelper.UserInfo.a();
        paramBundle.jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
        QZoneHelper.a((Activity)paramContext, paramBundle, localIntent, paramInt, paramOnDismissListener);
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface = new Intent(paramContext, TranslucentActivity.class);
        paramAppInterface.addFlags(268435456);
        paramAppInterface.putExtras(localIntent);
        paramContext.startActivity(paramAppInterface);
        return;
      }
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        FileUtil.a((File)localIterator.next());
      }
      paramArrayList.clear();
    }
  }
  
  @Deprecated
  public static final boolean a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return a(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  @Deprecated
  public static final boolean a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if ((paramBundle == null) || (paramAppInterface == null)) {
      return false;
    }
    Object localObject = paramBundle.getString("title");
    String str = paramBundle.getString("desc");
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("qzone_uin", paramAppInterface.getAccount());
      ((Intent)localObject).putExtra("key_share_is_third_party", true);
      ((Intent)localObject).putExtra("share_data", paramBundle);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(268435456);
      QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
      try
      {
        paramBundle = QZoneHelper.UserInfo.a();
        paramBundle.jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
        QZoneHelper.a((Activity)paramContext, paramBundle, (Intent)localObject, paramInt, paramOnDismissListener);
        return true;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          paramAppInterface = new Intent(paramContext, TranslucentActivity.class);
          paramAppInterface.addFlags(268435456);
          paramAppInterface.putExtras((Intent)localObject);
          paramContext.startActivity(paramAppInterface);
        }
      }
    }
    b(paramBundle);
    localObject = new QZoneShareData();
    ((QZoneShareData)localObject).jdField_b_of_type_JavaLangString = paramBundle.getString("title");
    ((QZoneShareData)localObject).c = paramBundle.getString("desc");
    ((QZoneShareData)localObject).jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("image_url");
    ((QZoneShareData)localObject).g = paramBundle.getString("share_qq_ext_str");
    ((QZoneShareData)localObject).jdField_a_of_type_Long = paramBundle.getLong("req_share_id");
    ((QZoneShareData)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("open_id");
    ((QZoneShareData)localObject).e = paramBundle.getString("app_name");
    ((QZoneShareData)localObject).d = paramBundle.getString("detail_url");
    ((QZoneShareData)localObject).jdField_a_of_type_Int = paramBundle.getInt("iUrlInfoFrm", -1);
    ((QZoneShareData)localObject).jdField_b_of_type_Long = paramBundle.getLong("share_begin_time", 0L);
    if (paramBundle.getBoolean("thirdPartShare")) {
      ((QZoneShareData)localObject).jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      ((QZoneShareData)localObject).h = paramBundle.getString("share_action");
      ((QZoneShareData)localObject).j = paramBundle.getString("jfrom");
      ((QZoneShareData)localObject).i = paramBundle.getString("pkg_name");
      ((QZoneShareData)localObject).f = paramBundle.getString("share_uin");
      ((QZoneShareData)localObject).m = paramBundle.getString("shareCurUrl");
      ((QZoneShareData)localObject).l = paramBundle.getString("default_text");
      a(paramContext, paramAppInterface.getCurrentAccountUin(), (QZoneShareData)localObject, paramOnDismissListener, paramInt);
      return true;
      if (paramBundle.getBoolean("from_web")) {
        ((QZoneShareData)localObject).jdField_b_of_type_Int = 2;
      } else {
        ((QZoneShareData)localObject).jdField_b_of_type_Int = 0;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "sharewhitelist", "100733645,1101218289,100497308,1103394134,1106611629,1105705811");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.equals(localObject[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static final Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("desc");
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (localArrayList != null) && (!localArrayList.isEmpty())) {
      paramBundle.remove("detail_url");
    }
    a(paramBundle);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneShareManager
 * JD-Core Version:    0.7.0.1
 */