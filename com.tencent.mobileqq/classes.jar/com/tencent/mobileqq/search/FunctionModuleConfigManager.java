package com.tencent.mobileqq.search;

import ahqt;
import ahqu;
import ahqv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FunctionModuleConfigManager
  implements Manager
{
  public static HashMap a;
  public static HashMap b = new HashMap();
  protected Handler a;
  QQAppInterface a;
  public ISearchResultModel a;
  public NetSearchTemplateBaseItem a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public FunctionModuleConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static String a(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((Long)paramList.next()).longValue()).append("&");
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: ldc 89
    //   6: astore_1
    //   7: aload_1
    //   8: areturn
    //   9: new 91	java/io/BufferedReader
    //   12: dup
    //   13: new 93	java/io/InputStreamReader
    //   16: dup
    //   17: new 95	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 98	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: ldc 100
    //   27: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   30: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_3
    //   34: ldc 89
    //   36: astore_2
    //   37: aload_3
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +32 -> 79
    //   50: aload_3
    //   51: astore_1
    //   52: new 49	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   59: aload_2
    //   60: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 4
    //   65: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore 4
    //   73: aload 4
    //   75: astore_2
    //   76: goto -39 -> 37
    //   79: aload_3
    //   80: astore_1
    //   81: aload_3
    //   82: invokevirtual 112	java/io/BufferedReader:close	()V
    //   85: aload_2
    //   86: astore_1
    //   87: aload_3
    //   88: ifnull -81 -> 7
    //   91: aload_3
    //   92: invokevirtual 112	java/io/BufferedReader:close	()V
    //   95: aload_2
    //   96: areturn
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   102: aload_2
    //   103: areturn
    //   104: astore 4
    //   106: aconst_null
    //   107: astore_3
    //   108: ldc 89
    //   110: astore_2
    //   111: aload_3
    //   112: astore_1
    //   113: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +16 -> 132
    //   119: aload_3
    //   120: astore_1
    //   121: ldc 122
    //   123: iconst_2
    //   124: aload 4
    //   126: invokevirtual 123	java/io/IOException:toString	()Ljava/lang/String;
    //   129: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_2
    //   133: astore_1
    //   134: aload_3
    //   135: ifnull -128 -> 7
    //   138: aload_3
    //   139: invokevirtual 112	java/io/BufferedReader:close	()V
    //   142: aload_2
    //   143: areturn
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   149: aload_2
    //   150: areturn
    //   151: astore_2
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 112	java/io/BufferedReader:close	()V
    //   162: aload_2
    //   163: athrow
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   169: goto -7 -> 162
    //   172: astore_2
    //   173: goto -19 -> 154
    //   176: astore 4
    //   178: goto -67 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	FunctionModuleConfigManager
    //   0	181	1	paramArrayOfByte	byte[]
    //   36	114	2	localObject1	Object
    //   151	12	2	localObject2	Object
    //   172	1	2	localObject3	Object
    //   33	106	3	localBufferedReader	java.io.BufferedReader
    //   43	31	4	str	String
    //   104	21	4	localIOException1	java.io.IOException
    //   176	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   91	95	97	java/io/IOException
    //   9	34	104	java/io/IOException
    //   138	142	144	java/io/IOException
    //   9	34	151	finally
    //   158	162	164	java/io/IOException
    //   39	45	172	finally
    //   52	73	172	finally
    //   81	85	172	finally
    //   113	119	172	finally
    //   121	132	172	finally
    //   39	45	176	java/io/IOException
    //   52	73	176	java/io/IOException
    //   81	85	176	java/io/IOException
  }
  
  public static String a(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfLong[i]).append("&");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private List b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.FunctionModuleConfigManager", 2, "getFunctionItemList !!! no data,just use local data");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(1, "QQ会员", "https://pub.idqqimg.com/pc/misc/files/20170321/a89cb3ba283040058367d36b0a1f5aad.png", "https://h5.vip.qq.com/p/sonic/mc/vipcenterv5?_bid=193&_wvSb=1&asyncMode=3&_wwv=64&_nav_alpha=true&_wwv=4&pay_src=10&platform=1&type=20001&networkInfo=1&status=-1&number=0&path=100400"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(2, "QQ钱包", "https://pub.idqqimg.com/pc/misc/files/20170310/e3f2c05439d745c6b39505c757468bcc.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(3, "个性装扮", "https://pub.idqqimg.com/pc/misc/files/20170321/f8b7922d137b4174a32408c2a874d439.png", "https://zb.vip.qq.com/sonic/index?_wv=16778243&asyncMode=3&_wwv=68&_nav_txtclr=ffffff&_nav_titleclr=ffffff&btest=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(4, "我的收藏", "https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(5, "相册", "https://pub.idqqimg.com/pc/misc/files/20170310/a601d5f50db940ee9cf8d30e915671ce.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(6, "我的文件", "https://pub.idqqimg.com/pc/misc/files/20170310/2490d524bbf84417929137e35d93b0c2.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(7, "QQ达人", "https://pub.idqqimg.com/pc/misc/files/20170321/b38bddc6e6a24a1eb5253f6505fb349e.png", "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(8, "手机通讯录", "https://pub.idqqimg.com/pc/misc/files/20170310/5765374679c8415894d31ff020f5558a.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(9, "QQ空间", "https://pub.idqqimg.com/pc/misc/files/20170310/5aaef4e89ac540ff9d0e1a4c3f0aee65.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(10, "附近", "https://pub.idqqimg.com/pc/misc/files/20170310/c88ccef2e6d44e3f94357ac7cecd04b4.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(11, "厘米秀", "https://pub.idqqimg.com/pc/misc/files/20170310/c83498c5dfd54489af3147b027c091b0.png", "http://cmshow.qq.com/apollo/html/intro.html?_wv=3&adtag=search"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(12, "兴趣部落", "https://pub.idqqimg.com/pc/misc/files/20170310/e8310f3460fa41b487b5922a0df671c5.png", "https://buluo.qq.com/mobile/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&plg_auth=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(13, "游戏", "https://pub.idqqimg.com/pc/misc/files/20170310/ee1b6352ec7340bba07949a15b9adc19.png", "https://m.gamecenter.qq.com/directout/index?st=1489458002385&uin=3043939851&status=-1&number=0&path=489&plat=qq&gamecenter=1&_wv=1031&gc_version=2&ADTAG=neisou&_nav_bgclr=18b4ed&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=255&asyncMode=3&_wwv=64"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(14, "日迹", "https://pub.idqqimg.com/pc/misc/files/20170310/6a09f5f91fff46e0ada71ff7b2a667f4.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(15, "QQ看点", "https://sqimg.qq.com/qq_product_operations/kan/images/QQkandian_symbol.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(16, "京东购物", "https://pub.idqqimg.com/pc/misc/files/20170310/43121a2425204707868e3e271a9969a7.png", "https://wq.jd.com/mcoss/wxmall/home?ptype=4&_wv=67113987&fetchCode=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(17, "阅读", "https://pub.idqqimg.com/pc/misc/files/20170310/cd28b2e8ba7f4d9e98a2d244ced31789.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(18, "动漫", "https://pub.idqqimg.com/pc/misc/files/20170310/6727610036b648c3bc3aaa4d0c047ec3.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(19, "音乐", "https://pub.idqqimg.com/pc/misc/files/20170310/ee8e56925bb646f9b6ae831afcbb0aca.png", "https://y.qq.com/m/mqq/music/index.html?plg_auth=1&plg_dev=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(20, "NOW直播", "https://pub.idqqimg.com/pc/misc/files/20170321/fd790f79230e4776a33c608c9557ae0b.png", "https://now.qq.com/qq/hall.html?_bid=2374&_wv=16778245&from=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(21, "吃喝玩乐", "https://pub.idqqimg.com/pc/misc/files/20170321/5657f0d4fd6f49858d10bca7451d91a8.png", "https://imgcache.qq.com/zzapp/chwl/prev/html/shop.html?max_age=0&_wv=3"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(22, "同城服务", "https://pub.idqqimg.com/pc/misc/files/20170310/0291fa0854954779a9eeeb9d843f0157.png", "https://tcsh.qq.com/58/html/home.html?_wv=1027&plg_auth=1&plg_dev=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(23, "腾讯新闻", "https://pub.idqqimg.com/pc/misc/files/20170310/3a4608e81a5e4158a07d92e4ae8a7b7a.png", "https://info.3g.qq.com/g/s?aid=index&g_ut=3&_wv=1&g_f=22580&plg_auth=1&plg_dev=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(24, "运动", "https://pub.idqqimg.com/pc/misc/files/20170310/35fa7f030fe44507a9732f6d034677e3.png", "https://yundong.qq.com/?_wv=2172899&asyncMode=1&crashFrom=40501"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(25, "腾讯课堂", "https://pub.idqqimg.com/pc/misc/files/20170310/26cee3d3d78a4c7e8be121cce7ce1df5.png", "https://m.ke.qq.com/index.html?_bid=167&_wv=5121"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(26, "企鹅辅导", "https://pub.idqqimg.com/pc/misc/files/20170321/30e65ca21a2a42529c90a83a46630ce1.png", "https://fudao.qq.com/rn2web/coursebreak.html?_wv=5123&_bid=2356&n_r=1&from=dongtai&plg_auth=1&plg_dev=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(27, "公众号", "https://pub.idqqimg.com/pc/misc/files/20170310/f668a11f690c49bc82210b5773e9f27b.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(28, "我的电脑", "https://pub.idqqimg.com/pc/misc/files/20170310/25b9983be4dd4092bf03f6cac00e0095.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(30, "面对面快传", "https://pub.idqqimg.com/pc/misc/files/20170321/831513c842904cdda53780b36110478e.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(31, "扫一扫", "https://pub.idqqimg.com/pc/misc/files/20170310/9f15b7bd262c42b28a285e3e12a49808.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(32, "付款", "https://pub.idqqimg.com/pc/misc/files/20170310/4fedf2b96f4d4acda93fe619d9cb925e.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(33, "面对面红包", "https://pub.idqqimg.com/pc/misc/files/20170321/9cd89480b0284a27a8938318dbc897df.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(35, "群助手", "https://pub.idqqimg.com/pc/misc/files/20170310/6f2aad7545014d13a230cb237390b567.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(36, "购物号", "https://pub.idqqimg.com/pc/misc/files/20170310/43121a2425204707868e3e271a9969a7.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(37, "群通知", "https://pub.idqqimg.com/pc/misc/files/20170310/5cba92c8405749bbb66d13cd2f42c7b5.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(38, "应用宝", "https://pub.idqqimg.com/pc/misc/files/20170322/3152361128324bfd97776b10c803f73c.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(39, "QQ红包", "https://pub.idqqimg.com/pc/misc/files/20170310/96d80f6c7cef4e3aa8d45237cc301295.png", "https://mqq.tenpay.com/mqq/hongbao/index.shtml?_wv=2098179&_wvNb=D12928&f=17&_vacf=qw&_wvNt=FFFFFF&_wvSb=1"));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(40, "我的其他QQ帐号", "https://pub.idqqimg.com/pc/misc/files/20170510/e74d00a108ba43e8b7e324ad425dc85c.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(41, "新朋友", "https://pub.idqqimg.com/pc/misc/files/20170510/9a58b5bdda80403cb3a2923d8f96f519.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(42, "打招呼", "https://pub.idqqimg.com/pc/misc/files/20170510/a6ebe42f38fc49e6a61ad504bef8d885.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(43, "服务号", "https://pub.idqqimg.com/pc/misc/files/20170510/445bcc0024c24add97831ec6e987d5a8.png", ""));
    localArrayList.add(new FunctionModuleConfigManager.FunctionItem(44, "一声问候", "https://pub.idqqimg.com/pc/misc/files/20170510/439579e680cc45789586480ff897aad2.png", ""));
    return localArrayList;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("Q.uniteSearch.FunctionModuleConfigManager", 0).getString("contentUrl", "");
  }
  
  public List a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("Q.uniteSearch.FunctionModuleConfigManager", 0).getString("content", "");
    ArrayList localArrayList1 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1).optJSONArray("functionList");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          break label268;
        }
        int i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label268;
        }
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        int k = ((JSONObject)localObject2).optInt("fid");
        String str1 = ((JSONObject)localObject2).optString("name");
        String str2 = ((JSONObject)localObject2).optString("headUrl");
        String str3 = ((JSONObject)localObject2).optString("androidJumpUrl");
        localObject2 = ((JSONObject)localObject2).optJSONArray("tag");
        ArrayList localArrayList2 = new ArrayList();
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            String str4 = ((JSONArray)localObject2).optString(j);
            if (TextUtils.isEmpty(str4)) {
              break label271;
            }
            localArrayList2.add(str4);
            break label271;
          }
        }
        localArrayList1.add(new FunctionModuleConfigManager.FunctionItem(k, str1, str2, str3, localArrayList2));
        i += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break label268;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.uniteSearch.FunctionModuleConfigManager", 2, localJSONException, new Object[0]);
        }
        return null;
      }
      QLog.i("Q.uniteSearch.FunctionModuleConfigManager", 2, "parseServletConfigContent param configContent is null");
      label268:
      return localJSONException;
      label271:
      j += 1;
    }
  }
  
  public List a(String paramString, int paramInt)
  {
    Object localObject1 = a();
    if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
      localObject1 = b();
    }
    for (;;)
    {
      ArrayList localArrayList1 = new ArrayList(((List)localObject1).size() + 1);
      ArrayList localArrayList2 = new ArrayList(((List)localObject1).size() + 1);
      ArrayList localArrayList3 = new ArrayList();
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        FunctionModuleConfigManager.FunctionItem localFunctionItem = (FunctionModuleConfigManager.FunctionItem)((Iterator)localObject2).next();
        int[] arrayOfInt = SearchUtils.a(paramString, localFunctionItem.jdField_a_of_type_JavaLangString, true);
        if ((arrayOfInt != null) && (arrayOfInt.length >= 3) && (arrayOfInt[0] > -1) && ((!ReadInJoyHelper.h()) || (!localFunctionItem.jdField_a_of_type_JavaLangString.contains("看点"))))
        {
          GroupBaseNetSearchModelItem localGroupBaseNetSearchModelItem = new GroupBaseNetSearchModelItem(paramString, localFunctionItem.jdField_a_of_type_Int + "", localFunctionItem.jdField_a_of_type_JavaLangString, localFunctionItem.b, localFunctionItem.c, "", 268435456L, null, paramInt);
          localGroupBaseNetSearchModelItem.a = arrayOfInt;
          if (localFunctionItem.jdField_a_of_type_JavaLangString.equals(paramString)) {
            localArrayList2.add(0, localGroupBaseNetSearchModelItem);
          } else {
            localArrayList2.add(localGroupBaseNetSearchModelItem);
          }
        }
      }
      localObject1 = ((List)localObject1).iterator();
      label534:
      label535:
      for (;;)
      {
        boolean bool;
        int i;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FunctionModuleConfigManager.FunctionItem)((Iterator)localObject1).next();
          if ((((FunctionModuleConfigManager.FunctionItem)localObject2).jdField_a_of_type_JavaUtilList == null) || (((FunctionModuleConfigManager.FunctionItem)localObject2).jdField_a_of_type_JavaUtilList.size() == 0)) {
            continue;
          }
          bool = false;
          i = 0;
          label312:
          if (i >= ((FunctionModuleConfigManager.FunctionItem)localObject2).jdField_a_of_type_JavaUtilList.size()) {
            break label534;
          }
          bool = paramString.contains((CharSequence)((FunctionModuleConfigManager.FunctionItem)localObject2).jdField_a_of_type_JavaUtilList.get(i));
          if (!bool) {}
        }
        for (;;)
        {
          if ((!bool) || ((ReadInJoyHelper.h()) && (((FunctionModuleConfigManager.FunctionItem)localObject2).jdField_a_of_type_JavaLangString.contains("看点")))) {
            break label535;
          }
          localArrayList3.add(new GroupBaseNetSearchModelItem(paramString, ((FunctionModuleConfigManager.FunctionItem)localObject2).jdField_a_of_type_Int + "", ((FunctionModuleConfigManager.FunctionItem)localObject2).jdField_a_of_type_JavaLangString, ((FunctionModuleConfigManager.FunctionItem)localObject2).b, ((FunctionModuleConfigManager.FunctionItem)localObject2).c, "", 268435456L, null, paramInt));
          break;
          i += 1;
          break label312;
          Collections.sort(localArrayList2, new ahqt(this));
          Collections.sort(localArrayList3, new ahqu(this));
          localArrayList1.addAll(localArrayList2);
          localArrayList1.addAll(localArrayList3);
          i = localArrayList1.size();
          paramInt = 0;
          while (paramInt < i)
          {
            SearchViewUtils.a((ISearchResultModel)localArrayList1.get(paramInt), i, paramInt);
            paramInt += 1;
          }
          return localArrayList1;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("Q.uniteSearch.FunctionModuleConfigManager", 0);
    localSharedPreferences.edit().putString("content", paramString);
    localSharedPreferences.edit().commit();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(a())) {
      return;
    }
    ThreadManager.post(new ahqv(this, paramString), 8, null, false);
  }
  
  public void c(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("Q.uniteSearch.FunctionModuleConfigManager", 0);
    localSharedPreferences.edit().putString("contentUrl", paramString);
    localSharedPreferences.edit().commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.FunctionModuleConfigManager
 * JD-Core Version:    0.7.0.1
 */