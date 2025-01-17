package cooperation.plugin;

import ammh;
import ammi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.startup.step.UpdatePluginVersion;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class PluginInstaller
  implements Handler.Callback
{
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = Build.FINGERPRINT;
  }
  
  public PluginInstaller(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramContext = null;
    Object localObject = null;
    if (0 == 0)
    {
      paramContext = localObject;
      if (0 != 0) {}
    }
    try
    {
      paramContext = ThreadManager.newFreeHandlerThread("QQ_PLUGIN", 0);
      paramContext.start();
      paramContext = new Handler(paramContext.getLooper(), this);
      this.jdField_a_of_type_AndroidOsHandler = paramContext;
      this.b = paramString;
      this.jdField_a_of_type_CooperationPluginBuiltinPluginManager = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidContentContext);
      a();
      return;
    }
    finally {}
  }
  
  static File a(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      return "";
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  private void a(PluginInfo paramPluginInfo)
  {
    PluginInfoUtil.a(paramPluginInfo, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void a(String paramString)
  {
    PluginInfoUtil.a(paramString, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (TextUtils.isEmpty(this.b)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "verifyDownloadPath." + this.b + ", " + bool);
      }
      return bool;
      if (new File(this.b).exists()) {
        bool = true;
      }
    }
  }
  
  private boolean a(PluginInfo paramPluginInfo)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (paramPluginInfo != null)
    {
      bool2 = bool1;
      if (paramPluginInfo.mInstalledPath != null)
      {
        File localFile = new File(paramPluginInfo.mInstalledPath);
        bool1 = bool3;
        if (localFile != null)
        {
          bool1 = bool3;
          if (localFile.exists())
          {
            bool1 = bool3;
            if (localFile.isFile())
            {
              if (!PluginInfoUtil.a(paramPluginInfo, localFile)) {
                break label137;
              }
              bool1 = true;
              paramPluginInfo.mState = 4;
              paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
            }
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "verifyInstalledPlugin :" + paramPluginInfo.mID + "," + bool1);
        bool2 = bool1;
      }
      return bool2;
      label137:
      d(paramPluginInfo.mID);
      paramPluginInfo.mState = 0;
      bool1 = bool3;
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 170	com/tencent/mobileqq/pluginsdk/PluginUtils:isOsNeedReleaseDex	()Z
    //   3: ifne +5 -> 8
    //   6: iconst_1
    //   7: ireturn
    //   8: aload_0
    //   9: invokestatic 175	cooperation/plugin/PluginAdapterImpl:a	(Ljava/lang/String;)I
    //   12: istore_3
    //   13: iconst_1
    //   14: istore 4
    //   16: iload_3
    //   17: iconst_1
    //   18: if_icmple -12 -> 6
    //   21: getstatic 181	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   24: astore 16
    //   26: new 183	com/tencent/commonsdk/soload/DexReleasor
    //   29: dup
    //   30: aload_1
    //   31: new 107	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   38: aload 16
    //   40: invokestatic 76	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   43: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 186	java/io/File:separator	Ljava/lang/String;
    //   52: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokespecial 189	com/tencent/commonsdk/soload/DexReleasor:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore 18
    //   63: iconst_1
    //   64: istore_2
    //   65: iload 4
    //   67: istore 5
    //   69: iload_2
    //   70: iload_3
    //   71: if_icmpge +158 -> 229
    //   74: ldc 191
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: iload_2
    //   83: iconst_1
    //   84: iadd
    //   85: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokestatic 203	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_0
    //   94: iload_2
    //   95: iconst_1
    //   96: iadd
    //   97: invokestatic 207	com/tencent/mobileqq/pluginsdk/PluginUtils:getMultiDexJarName	(Ljava/lang/String;I)Ljava/lang/String;
    //   100: astore 16
    //   102: ldc2_w 208
    //   105: aload 18
    //   107: aload_1
    //   108: invokevirtual 213	com/tencent/commonsdk/soload/DexReleasor:getEntryCrcCode	(Ljava/lang/String;)J
    //   111: lcmp
    //   112: ifne +44 -> 156
    //   115: ldc 105
    //   117: iconst_1
    //   118: new 107	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   125: ldc 215
    //   127: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc 217
    //   136: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: iload_2
    //   150: iconst_1
    //   151: iadd
    //   152: istore_2
    //   153: goto -88 -> 65
    //   156: aload 18
    //   158: aload 16
    //   160: aload_1
    //   161: invokevirtual 221	com/tencent/commonsdk/soload/DexReleasor:releaseDex	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   164: astore 19
    //   166: aload 19
    //   168: ifnull +11 -> 179
    //   171: aload 19
    //   173: invokevirtual 133	java/io/File:exists	()Z
    //   176: ifne +67 -> 243
    //   179: new 107	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   186: ldc 223
    //   188: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload_2
    //   192: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc 217
    //   197: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: astore_1
    //   201: aload 19
    //   203: ifnull +34 -> 237
    //   206: aload 19
    //   208: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   211: astore_0
    //   212: ldc 105
    //   214: iconst_1
    //   215: aload_1
    //   216: aload_0
    //   217: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iconst_0
    //   227: istore 5
    //   229: aload 18
    //   231: invokevirtual 229	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   234: iload 5
    //   236: ireturn
    //   237: ldc 217
    //   239: astore_0
    //   240: goto -28 -> 212
    //   243: ldc2_w 208
    //   246: lstore 10
    //   248: aload 18
    //   250: aload_1
    //   251: invokevirtual 213	com/tencent/commonsdk/soload/DexReleasor:getEntryCrcCode	(Ljava/lang/String;)J
    //   254: lstore 6
    //   256: new 231	com/tencent/commonsdk/zip/QZipFile
    //   259: dup
    //   260: aload 19
    //   262: invokespecial 234	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   265: astore_1
    //   266: aload_1
    //   267: astore 16
    //   269: aload_1
    //   270: ldc 236
    //   272: invokevirtual 240	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   275: astore 17
    //   277: lload 10
    //   279: lstore 8
    //   281: aload 17
    //   283: ifnull +13 -> 296
    //   286: aload_1
    //   287: astore 16
    //   289: aload 17
    //   291: invokevirtual 246	java/util/zip/ZipEntry:getCrc	()J
    //   294: lstore 8
    //   296: aload 17
    //   298: ifnull +130 -> 428
    //   301: lload 6
    //   303: lload 8
    //   305: lcmp
    //   306: ifne +122 -> 428
    //   309: lload 6
    //   311: lstore 12
    //   313: lload 8
    //   315: lstore 14
    //   317: iload 4
    //   319: istore 5
    //   321: aload_1
    //   322: ifnull +19 -> 341
    //   325: aload_1
    //   326: invokevirtual 249	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   329: iload 4
    //   331: istore 5
    //   333: lload 8
    //   335: lstore 14
    //   337: lload 6
    //   339: lstore 12
    //   341: new 107	java/lang/StringBuilder
    //   344: dup
    //   345: sipush 256
    //   348: invokespecial 252	java/lang/StringBuilder:<init>	(I)V
    //   351: astore_1
    //   352: aload_1
    //   353: ldc 254
    //   355: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_1
    //   360: iload 5
    //   362: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_1
    //   367: ldc 217
    //   369: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_1
    //   374: aload 19
    //   376: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   379: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_1
    //   384: ldc 217
    //   386: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_1
    //   391: lload 12
    //   393: invokevirtual 257	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload_1
    //   398: ldc 217
    //   400: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_1
    //   405: lload 14
    //   407: invokevirtual 257	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: ldc 105
    //   413: iconst_1
    //   414: aload_1
    //   415: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: iload 5
    //   423: istore 4
    //   425: goto -276 -> 149
    //   428: iconst_0
    //   429: istore 4
    //   431: goto -122 -> 309
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   439: lload 6
    //   441: lstore 12
    //   443: lload 8
    //   445: lstore 14
    //   447: iload 4
    //   449: istore 5
    //   451: goto -110 -> 341
    //   454: astore 17
    //   456: aconst_null
    //   457: astore_1
    //   458: ldc2_w 208
    //   461: lstore 6
    //   463: aload_1
    //   464: astore 16
    //   466: aload 19
    //   468: invokevirtual 263	java/io/File:delete	()Z
    //   471: pop
    //   472: aload_1
    //   473: astore 16
    //   475: ldc 105
    //   477: iconst_1
    //   478: ldc_w 265
    //   481: aload 17
    //   483: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: lload 6
    //   488: lstore 12
    //   490: lload 10
    //   492: lstore 14
    //   494: iload 4
    //   496: istore 5
    //   498: aload_1
    //   499: ifnull -158 -> 341
    //   502: aload_1
    //   503: invokevirtual 249	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   506: lload 6
    //   508: lstore 12
    //   510: lload 10
    //   512: lstore 14
    //   514: iload 4
    //   516: istore 5
    //   518: goto -177 -> 341
    //   521: astore_1
    //   522: aload_1
    //   523: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   526: lload 6
    //   528: lstore 12
    //   530: lload 10
    //   532: lstore 14
    //   534: iload 4
    //   536: istore 5
    //   538: goto -197 -> 341
    //   541: astore_0
    //   542: aconst_null
    //   543: astore 16
    //   545: aload 16
    //   547: ifnull +8 -> 555
    //   550: aload 16
    //   552: invokevirtual 249	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   555: aload_0
    //   556: athrow
    //   557: astore_1
    //   558: aload_1
    //   559: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   562: goto -7 -> 555
    //   565: astore_0
    //   566: goto -21 -> 545
    //   569: astore 17
    //   571: aconst_null
    //   572: astore_1
    //   573: goto -110 -> 463
    //   576: astore 17
    //   578: goto -115 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	paramString1	String
    //   0	581	1	paramString2	String
    //   64	128	2	i	int
    //   12	60	3	j	int
    //   14	521	4	bool1	boolean
    //   67	470	5	bool2	boolean
    //   254	273	6	l1	long
    //   279	165	8	l2	long
    //   246	285	10	l3	long
    //   311	218	12	l4	long
    //   315	218	14	l5	long
    //   24	527	16	localObject	Object
    //   275	22	17	localZipEntry	java.util.zip.ZipEntry
    //   454	28	17	localException1	Exception
    //   569	1	17	localException2	Exception
    //   576	1	17	localException3	Exception
    //   61	188	18	localDexReleasor	com.tencent.commonsdk.soload.DexReleasor
    //   164	303	19	localFile	File
    // Exception table:
    //   from	to	target	type
    //   325	329	434	java/io/IOException
    //   248	256	454	java/lang/Exception
    //   502	506	521	java/io/IOException
    //   248	256	541	finally
    //   256	266	541	finally
    //   550	555	557	java/io/IOException
    //   269	277	565	finally
    //   289	296	565	finally
    //   466	472	565	finally
    //   475	486	565	finally
    //   256	266	569	java/lang/Exception
    //   269	277	576	java/lang/Exception
    //   289	296	576	java/lang/Exception
  }
  
  private void c(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    int i = 1;
    String str = paramPluginInfo.mID;
    QLog.d("plugin_tag", 1, "doSetupPlugin." + str);
    if (PluginInfoUtil.a(paramPluginInfo, this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.d("plugin_tag", 1, "plugin still running");
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str);
      }
      return;
    }
    if (!c(str)) {}
    while (i != 0)
    {
      a(str, paramOnPluginSetupListener);
      return;
      i = 0;
    }
    a(paramPluginInfo, paramOnPluginSetupListener);
  }
  
  private boolean c(String paramString)
  {
    if (!a()) {}
    do
    {
      return false;
      paramString = new File(this.b).list(new ammh(this, paramString));
    } while ((paramString == null) || (paramString.length <= 0));
    return true;
  }
  
  private boolean d(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localPluginInfo != null) && (PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidContentContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    a(paramString);
    if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
    {
      paramString = new File(localPluginInfo.mInstalledPath);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
    return true;
  }
  
  public PluginInfo a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    return (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    File localFile1 = a(this.jdField_a_of_type_AndroidContentContext);
    boolean bool = PluginInfoUtil.a(localFile1);
    File[] arrayOfFile = PluginInfoUtil.a(localFile1);
    int i;
    File localFile2;
    Object localObject;
    if (arrayOfFile != null)
    {
      int k = arrayOfFile.length;
      i = 0;
      if (i < k)
      {
        localFile2 = arrayOfFile[i];
        if (localFile2.isFile())
        {
          if (!bool) {
            break label141;
          }
          localObject = UpdatePluginVersion.a;
          int m = localObject.length;
          j = 0;
          label70:
          if (j >= m) {
            break label243;
          }
          String str = localObject[j];
          if (!localFile2.getName().equals(str + ".cfg")) {
            break label134;
          }
          d(str);
        }
      }
    }
    label134:
    label141:
    label243:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {}
      for (;;)
      {
        i += 1;
        break;
        j += 1;
        break label70;
        localObject = PluginInfoUtil.a(localFile2);
        if (localObject != null)
        {
          if (a((PluginInfo)localObject)) {
            this.jdField_a_of_type_JavaUtilHashMap.put(((PluginInfo)localObject).mID, localObject);
          }
        }
        else {
          localFile2.delete();
        }
      }
      if (bool) {
        PluginInfoUtil.a(localFile1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "load installed plugin info. size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(66816, paramPluginInfo).sendToTarget();
  }
  
  public void a(String paramString, File paramFile)
  {
    int i = 1;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFile);
    if ((PluginUtils.isOsNeedReleaseDex()) && (PluginAdapterImpl.a(paramString) > 1)) {
      localArrayList.add(PluginUtils.getMultiDexSecondDex(this.jdField_a_of_type_AndroidContentContext, paramString));
    }
    for (;;)
    {
      try
      {
        paramFile = Dex2Oat.a();
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "dex2Oat targetISA = " + paramFile + " " + paramString + " " + localArrayList.size());
        }
        if (!TextUtils.isEmpty(paramFile))
        {
          File localFile = new File(PluginUtils.getOptimizedDexPath(this.jdField_a_of_type_AndroidContentContext).getCanonicalPath());
          long l = System.currentTimeMillis();
          boolean bool = Dex2Oat.a(localArrayList, localFile, true, paramFile, new ammi(this));
          l = System.currentTimeMillis() - l;
          paramFile = new StringBuilder("dex2Oat ");
          paramFile.append(l);
          paramFile.append(", ");
          paramFile.append(bool);
          paramFile.append(", ");
          paramFile.append(paramString);
          QLog.w("plugin_tag", 1, paramFile.toString());
          if (!bool) {
            break label277;
          }
          PluginStatisticsCollector.a(paramString, i, l);
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "install finish " + paramString);
          }
        }
        else
        {
          PluginStatisticsCollector.a(paramString, 3, 0L);
          continue;
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      label277:
      i = 2;
    }
  }
  
  public boolean a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (paramPluginInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installDownLoadPlugin. info null.");
      }
      throw new NullPointerException("specified PluginInfo is null");
    }
    String str1 = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installDownLoadPlugin." + str1);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str1);
      }
      return false;
    }
    File localFile = new File(PluginUtils.getPluginInstallDir(this.jdField_a_of_type_AndroidContentContext), str1);
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
    int i;
    if ((localObject != null) && (!paramPluginInfo.mMD5.equals(((PluginInfo)localObject).mMD5)))
    {
      i = 1;
      label144:
      if (!localFile.exists()) {
        break label626;
      }
    }
    label621:
    label626:
    for (boolean bool = a((PluginInfo)localObject);; bool = false)
    {
      if ((bool) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "plugin installed.");
        }
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
        i = 0;
        break label144;
      }
      if (!a())
      {
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      localObject = new File(new File(this.b), str1);
      if (!PluginInfoUtil.a(paramPluginInfo, (File)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. download file invalid.");
        }
        ((File)localObject).delete();
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      paramPluginInfo.mState = 3;
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
      FileUtils.a((File)localObject, localFile);
      if (!PluginInfoUtil.a(paramPluginInfo, localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. copy file invalid.");
        }
        localFile.delete();
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(false, str1);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
        return false;
      }
      for (;;)
      {
        try
        {
          String str2 = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, str1).getCanonicalPath();
          str2 = PluginUtils.extractLibs(localFile.getCanonicalPath(), str2);
          if (str2 == null) {
            break label621;
          }
          QLog.d("plugin_tag", 1, "extractLibs " + str2);
          i = 1;
        }
        catch (Throwable localThrowable)
        {
          QLog.d("plugin_tag", 1, "extractLibs ", localThrowable);
          i = 1;
          continue;
          int j = 0;
          continue;
          if (!PluginManagerV2.a()) {
            continue;
          }
          a(str1, localFile);
          paramPluginInfo.mState = 4;
          paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
          paramPluginInfo.mFingerPrint = a();
          this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
          a(paramPluginInfo);
          if (!((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).delete();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("plugin_tag", 2, "install finish.");
          if (paramOnPluginSetupListener == null) {
            continue;
          }
          paramOnPluginSetupListener.b(true, str1);
          return true;
        }
        j = i;
        if (i == 0)
        {
          if (!a(str1, localFile.getAbsolutePath())) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            continue;
          }
          localFile.delete();
          if (paramOnPluginSetupListener != null) {
            paramOnPluginSetupListener.b(false, str1);
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
          return false;
        }
        i = 0;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    paramString = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString != null) && (paramString.mState == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "isPluginInstalled installed = " + bool);
      }
      return bool;
    }
  }
  
  /* Error */
  public boolean a(String paramString, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    // Byte code:
    //   0: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 105
    //   8: iconst_2
    //   9: new 107	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 476
    //   19: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 313	cooperation/plugin/PluginInstaller:jdField_a_of_type_Boolean	Z
    //   36: ifne +16 -> 52
    //   39: aload_2
    //   40: ifnull +10 -> 50
    //   43: aload_2
    //   44: aload_1
    //   45: invokeinterface 282 2 0
    //   50: iconst_0
    //   51: ireturn
    //   52: aload_0
    //   53: getfield 68	cooperation/plugin/PluginInstaller:jdField_a_of_type_CooperationPluginBuiltinPluginManager	Lcooperation/plugin/BuiltinPluginManager;
    //   56: aload_1
    //   57: invokevirtual 478	cooperation/plugin/BuiltinPluginManager:a	(Ljava/lang/String;)Z
    //   60: ifne +31 -> 91
    //   63: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +12 -> 78
    //   69: ldc 105
    //   71: iconst_2
    //   72: ldc_w 480
    //   75: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_2
    //   79: ifnull -29 -> 50
    //   82: aload_2
    //   83: aload_1
    //   84: invokeinterface 282 2 0
    //   89: iconst_0
    //   90: ireturn
    //   91: new 128	java/io/File
    //   94: dup
    //   95: aload_0
    //   96: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   99: invokestatic 76	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   102: aload_1
    //   103: invokespecial 429	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   106: astore 7
    //   108: aload_0
    //   109: getfield 35	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: aload_1
    //   113: invokevirtual 305	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 136	cooperation/plugin/PluginInfo
    //   119: astore 10
    //   121: aload_0
    //   122: getfield 68	cooperation/plugin/PluginInstaller:jdField_a_of_type_CooperationPluginBuiltinPluginManager	Lcooperation/plugin/BuiltinPluginManager;
    //   125: aload_1
    //   126: invokevirtual 482	cooperation/plugin/BuiltinPluginManager:a	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   129: astore 8
    //   131: aload 8
    //   133: ifnonnull +26 -> 159
    //   136: ldc 105
    //   138: iconst_1
    //   139: ldc_w 484
    //   142: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_2
    //   146: ifnull -96 -> 50
    //   149: aload_2
    //   150: iconst_0
    //   151: aload_1
    //   152: invokeinterface 449 3 0
    //   157: iconst_0
    //   158: ireturn
    //   159: aload 8
    //   161: ifnull +82 -> 243
    //   164: aload 10
    //   166: ifnull +77 -> 243
    //   169: aload 8
    //   171: getfield 432	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   174: aload 10
    //   176: getfield 432	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   179: invokevirtual 333	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifne +61 -> 243
    //   185: iconst_1
    //   186: istore 4
    //   188: aload 7
    //   190: invokevirtual 133	java/io/File:exists	()Z
    //   193: ifeq +646 -> 839
    //   196: aload_0
    //   197: aload 10
    //   199: invokespecial 338	cooperation/plugin/PluginInstaller:a	(Lcooperation/plugin/PluginInfo;)Z
    //   202: istore 6
    //   204: iload 6
    //   206: ifeq +43 -> 249
    //   209: iload 4
    //   211: ifne +38 -> 249
    //   214: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +12 -> 229
    //   220: ldc 105
    //   222: iconst_2
    //   223: ldc_w 486
    //   226: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_2
    //   230: ifnull +11 -> 241
    //   233: aload_2
    //   234: iconst_1
    //   235: aload_1
    //   236: invokeinterface 449 3 0
    //   241: iconst_1
    //   242: ireturn
    //   243: iconst_0
    //   244: istore 4
    //   246: goto -58 -> 188
    //   249: aload_2
    //   250: ifnull +10 -> 260
    //   253: aload_2
    //   254: aload_1
    //   255: invokeinterface 439 2 0
    //   260: aload 8
    //   262: invokevirtual 489	cooperation/plugin/PluginInfo:a	()Lcooperation/plugin/PluginInfo;
    //   265: astore 11
    //   267: aload 11
    //   269: iconst_3
    //   270: putfield 149	cooperation/plugin/PluginInfo:mState	I
    //   273: aload_0
    //   274: getfield 35	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   277: aload_1
    //   278: aload 11
    //   280: invokevirtual 342	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: ldc 79
    //   286: astore 9
    //   288: aload_1
    //   289: iconst_0
    //   290: aload_1
    //   291: ldc_w 491
    //   294: invokevirtual 494	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   297: invokevirtual 498	java/lang/String:substring	(II)Ljava/lang/String;
    //   300: astore 12
    //   302: aload_0
    //   303: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   306: aload 12
    //   308: invokestatic 504	com/tencent/commonsdk/soload/SoLoadCore:getReleasedSoFilePath	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   311: astore 8
    //   313: aload 8
    //   315: ifnonnull +521 -> 836
    //   318: aload_0
    //   319: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   322: aload 12
    //   324: invokestatic 507	com/tencent/commonsdk/soload/SoLoadCore:releaseSo	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   327: astore 8
    //   329: aload 8
    //   331: ifnull +494 -> 825
    //   334: new 128	java/io/File
    //   337: dup
    //   338: aload 8
    //   340: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: astore 8
    //   345: aload 11
    //   347: getfield 432	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   350: astore 7
    //   352: aload 11
    //   354: getfield 432	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   357: astore 9
    //   359: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +41 -> 403
    //   365: ldc 105
    //   367: iconst_2
    //   368: new 107	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 509
    //   378: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 9
    //   383: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: ldc_w 511
    //   389: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 7
    //   394: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: aload 7
    //   405: aload 9
    //   407: invokevirtual 333	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   410: istore 6
    //   412: iconst_0
    //   413: ifne +276 -> 689
    //   416: iload 6
    //   418: ifeq +271 -> 689
    //   421: aload_0
    //   422: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   425: aload_1
    //   426: invokestatic 452	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   429: invokevirtual 388	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   432: astore 9
    //   434: aload 8
    //   436: invokevirtual 388	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   439: aload 9
    //   441: invokestatic 456	com/tencent/mobileqq/pluginsdk/PluginUtils:extractLibs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   444: astore 9
    //   446: aload 9
    //   448: ifnull +371 -> 819
    //   451: ldc 105
    //   453: iconst_1
    //   454: new 107	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 458
    //   464: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 9
    //   469: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: iconst_1
    //   479: istore 4
    //   481: iload 4
    //   483: istore 5
    //   485: iload 4
    //   487: ifne +18 -> 505
    //   490: aload_1
    //   491: aload 8
    //   493: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   496: invokestatic 460	cooperation/plugin/PluginInstaller:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   499: ifne +184 -> 683
    //   502: iconst_1
    //   503: istore 5
    //   505: iload 5
    //   507: ifeq +207 -> 714
    //   510: aload 8
    //   512: invokevirtual 263	java/io/File:delete	()Z
    //   515: pop
    //   516: aload_2
    //   517: ifnull +11 -> 528
    //   520: aload_2
    //   521: iconst_0
    //   522: aload_1
    //   523: invokeinterface 449 3 0
    //   528: aload_0
    //   529: getfield 35	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   532: aload_1
    //   533: aload 10
    //   535: invokevirtual 342	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   538: pop
    //   539: iconst_0
    //   540: ireturn
    //   541: astore 8
    //   543: aload 7
    //   545: astore 8
    //   547: aload 9
    //   549: astore 7
    //   551: ldc_w 513
    //   554: aload_1
    //   555: invokevirtual 333	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   558: ifeq +83 -> 641
    //   561: aload 9
    //   563: astore 7
    //   565: aload_0
    //   566: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   569: aload_1
    //   570: aload 8
    //   572: iconst_1
    //   573: invokestatic 518	com/tencent/mobileqq/startup/step/InstallPlugins:a	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Z)Ljava/lang/String;
    //   576: astore 9
    //   578: aload 9
    //   580: astore 7
    //   582: iconst_0
    //   583: invokestatic 520	com/tencent/mobileqq/startup/step/InstallPlugins:a	(I)V
    //   586: aload 9
    //   588: astore 7
    //   590: goto -238 -> 352
    //   593: astore 9
    //   595: invokestatic 523	com/tencent/mobileqq/utils/FileUtils:a	()F
    //   598: fstore_3
    //   599: ldc 105
    //   601: iconst_1
    //   602: new 107	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 525
    //   612: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload 8
    //   617: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   620: ldc_w 530
    //   623: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: fload_3
    //   627: invokevirtual 533	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   630: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: aload 9
    //   635: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   638: goto -286 -> 352
    //   641: aload 9
    //   643: astore 7
    //   645: aload_0
    //   646: getfield 30	cooperation/plugin/PluginInstaller:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   649: aload_1
    //   650: aload 8
    //   652: invokestatic 537	com/tencent/mobileqq/pluginsdk/PluginUtils:extractPluginAndGetMd5Code	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Ljava/lang/String;
    //   655: astore 9
    //   657: aload 9
    //   659: astore 7
    //   661: goto -309 -> 352
    //   664: astore 9
    //   666: ldc 105
    //   668: iconst_1
    //   669: ldc_w 458
    //   672: aload 9
    //   674: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   677: iconst_1
    //   678: istore 4
    //   680: goto -199 -> 481
    //   683: iconst_0
    //   684: istore 5
    //   686: goto -181 -> 505
    //   689: aload_2
    //   690: ifnull +11 -> 701
    //   693: aload_2
    //   694: iconst_0
    //   695: aload_1
    //   696: invokeinterface 449 3 0
    //   701: aload_0
    //   702: getfield 35	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   705: aload_1
    //   706: aload 10
    //   708: invokevirtual 342	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   711: pop
    //   712: iconst_0
    //   713: ireturn
    //   714: invokestatic 463	cooperation/plugin/PluginManagerV2:a	()Z
    //   717: ifeq +10 -> 727
    //   720: aload_0
    //   721: aload_1
    //   722: aload 8
    //   724: invokevirtual 464	cooperation/plugin/PluginInstaller:a	(Ljava/lang/String;Ljava/io/File;)V
    //   727: aload 11
    //   729: aload 8
    //   731: invokevirtual 540	java/io/File:length	()J
    //   734: putfield 544	cooperation/plugin/PluginInfo:mLength	J
    //   737: aload 11
    //   739: iconst_4
    //   740: putfield 149	cooperation/plugin/PluginInfo:mState	I
    //   743: aload 11
    //   745: aload 8
    //   747: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   750: putfield 139	cooperation/plugin/PluginInfo:mInstalledPath	Ljava/lang/String;
    //   753: aload 11
    //   755: aload 7
    //   757: putfield 432	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   760: aload 11
    //   762: invokestatic 465	cooperation/plugin/PluginInstaller:a	()Ljava/lang/String;
    //   765: putfield 468	cooperation/plugin/PluginInfo:mFingerPrint	Ljava/lang/String;
    //   768: aload_0
    //   769: getfield 35	cooperation/plugin/PluginInstaller:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   772: aload_1
    //   773: aload 11
    //   775: invokevirtual 342	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   778: pop
    //   779: aload_0
    //   780: aload 11
    //   782: invokespecial 470	cooperation/plugin/PluginInstaller:a	(Lcooperation/plugin/PluginInfo;)V
    //   785: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   788: ifeq +12 -> 800
    //   791: ldc 105
    //   793: iconst_2
    //   794: ldc_w 546
    //   797: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: aload_2
    //   801: ifnull +11 -> 812
    //   804: aload_2
    //   805: iconst_1
    //   806: aload_1
    //   807: invokeinterface 449 3 0
    //   812: iconst_1
    //   813: ireturn
    //   814: astore 7
    //   816: goto -269 -> 547
    //   819: iconst_0
    //   820: istore 4
    //   822: goto -341 -> 481
    //   825: aload 7
    //   827: astore 8
    //   829: aload 9
    //   831: astore 7
    //   833: goto -481 -> 352
    //   836: goto -507 -> 329
    //   839: iconst_0
    //   840: istore 6
    //   842: goto -638 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	845	0	this	PluginInstaller
    //   0	845	1	paramString	String
    //   0	845	2	paramOnPluginSetupListener	PluginInstaller.OnPluginSetupListener
    //   598	29	3	f	float
    //   186	635	4	i	int
    //   483	202	5	j	int
    //   202	639	6	bool	boolean
    //   106	650	7	localObject1	Object
    //   814	12	7	localException1	Exception
    //   831	1	7	localObject2	Object
    //   129	382	8	localObject3	Object
    //   541	1	8	localException2	Exception
    //   545	283	8	localObject4	Object
    //   286	301	9	str1	String
    //   593	49	9	localException3	Exception
    //   655	3	9	str2	String
    //   664	166	9	localThrowable	Throwable
    //   119	588	10	localPluginInfo1	PluginInfo
    //   265	516	11	localPluginInfo2	PluginInfo
    //   300	23	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   288	313	541	java/lang/Exception
    //   318	329	541	java/lang/Exception
    //   334	345	541	java/lang/Exception
    //   551	561	593	java/lang/Exception
    //   565	578	593	java/lang/Exception
    //   582	586	593	java/lang/Exception
    //   645	657	593	java/lang/Exception
    //   421	446	664	java/lang/Throwable
    //   451	478	664	java/lang/Throwable
    //   345	352	814	java/lang/Exception
  }
  
  public void b(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(67072, paramPluginInfo).sendToTarget();
  }
  
  public boolean b(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    String str = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDex2OatPlugin." + str);
    }
    PluginInfo localPluginInfo = a(str);
    if ((localPluginInfo != null) && (localPluginInfo.mState == 4)) {
      QLog.d("plugin_tag", 1, "doDex2OatPlugin. already " + str);
    }
    for (;;)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.b(true, str);
      }
      return true;
      if (PluginInfoUtil.a(paramPluginInfo, this.jdField_a_of_type_AndroidContentContext))
      {
        QLog.d("plugin_tag", 1, "doDex2OatPlugin. isPluginRunning " + str);
      }
      else
      {
        a(str, new File(PluginUtils.getPluginInstallDir(this.jdField_a_of_type_AndroidContentContext), str));
        paramPluginInfo.mState = 4;
        paramPluginInfo.mFingerPrint = a();
        a(paramPluginInfo);
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "doDex2OatPlugin finish");
        }
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "uninstallPlugin." + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return d(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 66816: 
      paramMessage = (Pair)paramMessage.obj;
      c((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
      return true;
    }
    paramMessage = (Pair)paramMessage.obj;
    b((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.PluginInstaller
 * JD-Core Version:    0.7.0.1
 */