package com.tencent.mobileqq.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.net.Uri;
import mqq.app.AppContentProvider;

public class FriendListProvider
  extends AppContentProvider
  implements FriendList
{
  private final UriMatcher a = new UriMatcher(-1);
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.a.addURI("qq.friendlist", "group/#", 1000);
    this.a.addURI("qq.friendlist", "friendlist/#", 1001);
    this.a.addURI("qq.friendlist", "trooplist/#", 1002);
    this.a.addURI("qq.friendlist", "troopmemberinfo/#/#/#", 1003);
    this.a.addURI("qq.friendlist", "troopname/#/#", 1004);
    this.a.addURI("qq.friendlist", "discussinfo/#/#", 1005);
    this.a.addURI("qq.friendlist", "discussmenberinfo/#/#/#", 1006);
    this.a.addURI("qq.friendlist", "individuationUserData/#", 1007);
    return true;
  }
  
  /* Error */
  public android.database.Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/content/FriendListProvider:a	Landroid/content/UriMatcher;
    //   4: aload_1
    //   5: invokevirtual 60	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   8: istore 6
    //   10: aload_1
    //   11: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   14: iconst_1
    //   15: invokeinterface 72 2 0
    //   20: checkcast 74	java/lang/String
    //   23: astore 9
    //   25: aload_0
    //   26: aload 9
    //   28: invokevirtual 78	com/tencent/mobileqq/content/FriendListProvider:getRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   31: astore 10
    //   33: new 80	com/tencent/mobileqq/content/ProviderAppRuntimeProxy
    //   36: dup
    //   37: invokespecial 81	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:<init>	()V
    //   40: aload 10
    //   42: aload 9
    //   44: iconst_1
    //   45: invokevirtual 84	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   48: astore 9
    //   50: aload 9
    //   52: ifnonnull +32 -> 84
    //   55: ldc 86
    //   57: iconst_1
    //   58: new 88	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   65: ldc 91
    //   67: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_3
    //   83: areturn
    //   84: iload 6
    //   86: tableswitch	default:+46 -> 132, 1000:+101->187, 1001:+155->241, 1002:+181->267, 1003:+230->316, 1004:+299->385, 1005:+368->454, 1006:+424->510, 1007:+549->635
    //   133: nop
    //   134: ddiv
    //   135: ifeq +28 -> 163
    //   138: ldc 86
    //   140: iconst_2
    //   141: new 88	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   148: ldc 113
    //   150: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_3
    //   167: aload_2
    //   168: ifnull -86 -> 82
    //   171: aload_2
    //   172: aload_0
    //   173: invokevirtual 117	com/tencent/mobileqq/content/FriendListProvider:getContext	()Landroid/content/Context;
    //   176: invokevirtual 123	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   179: aload_1
    //   180: invokeinterface 129 3 0
    //   185: aload_2
    //   186: areturn
    //   187: aload 9
    //   189: new 131	com/tencent/mobileqq/data/Groups
    //   192: dup
    //   193: invokespecial 132	com/tencent/mobileqq/data/Groups:<init>	()V
    //   196: invokevirtual 135	com/tencent/mobileqq/data/Groups:getTableName	()Ljava/lang/String;
    //   199: iconst_5
    //   200: anewarray 74	java/lang/String
    //   203: dup
    //   204: iconst_0
    //   205: ldc 137
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: ldc 139
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: ldc 141
    //   217: aastore
    //   218: dup
    //   219: iconst_3
    //   220: ldc 143
    //   222: aastore
    //   223: dup
    //   224: iconst_4
    //   225: ldc 145
    //   227: aastore
    //   228: aload_3
    //   229: aload 4
    //   231: aload 5
    //   233: aconst_null
    //   234: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   237: astore_2
    //   238: goto -73 -> 165
    //   241: aload 9
    //   243: new 152	com/tencent/mobileqq/data/Friends
    //   246: dup
    //   247: invokespecial 153	com/tencent/mobileqq/data/Friends:<init>	()V
    //   250: invokevirtual 154	com/tencent/mobileqq/data/Friends:getTableName	()Ljava/lang/String;
    //   253: aload_2
    //   254: aload_3
    //   255: aload 4
    //   257: aload 5
    //   259: aconst_null
    //   260: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   263: astore_2
    //   264: goto -99 -> 165
    //   267: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +34 -> 304
    //   273: ldc 155
    //   275: iconst_2
    //   276: new 88	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   283: aload_0
    //   284: invokevirtual 161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   287: invokevirtual 166	java/lang/Class:getName	()Ljava/lang/String;
    //   290: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc 168
    //   295: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 9
    //   306: ldc 173
    //   308: aconst_null
    //   309: invokevirtual 176	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   312: astore_2
    //   313: goto -148 -> 165
    //   316: aload_1
    //   317: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   320: astore_2
    //   321: aload_2
    //   322: invokeinterface 180 1 0
    //   327: iconst_4
    //   328: if_icmplt +660 -> 988
    //   331: aload 9
    //   333: new 182	com/tencent/mobileqq/data/TroopMemberInfo
    //   336: dup
    //   337: invokespecial 183	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   340: invokevirtual 184	com/tencent/mobileqq/data/TroopMemberInfo:getTableName	()Ljava/lang/String;
    //   343: aconst_null
    //   344: ldc 186
    //   346: iconst_2
    //   347: anewarray 74	java/lang/String
    //   350: dup
    //   351: iconst_0
    //   352: aload_2
    //   353: iconst_2
    //   354: invokeinterface 72 2 0
    //   359: checkcast 74	java/lang/String
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: aload_2
    //   366: iconst_3
    //   367: invokeinterface 72 2 0
    //   372: checkcast 74	java/lang/String
    //   375: aastore
    //   376: aconst_null
    //   377: aconst_null
    //   378: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   381: astore_2
    //   382: goto -217 -> 165
    //   385: aload_1
    //   386: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   389: astore_3
    //   390: aload_3
    //   391: invokeinterface 180 1 0
    //   396: iconst_2
    //   397: if_icmplt -234 -> 163
    //   400: new 188	com/tencent/mobileqq/data/TroopInfo
    //   403: dup
    //   404: invokespecial 189	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   407: invokevirtual 190	com/tencent/mobileqq/data/TroopInfo:getTableName	()Ljava/lang/String;
    //   410: astore_2
    //   411: aload_3
    //   412: iconst_2
    //   413: invokeinterface 72 2 0
    //   418: checkcast 74	java/lang/String
    //   421: astore_3
    //   422: aload 9
    //   424: aload_2
    //   425: iconst_1
    //   426: anewarray 74	java/lang/String
    //   429: dup
    //   430: iconst_0
    //   431: ldc 192
    //   433: aastore
    //   434: ldc 194
    //   436: iconst_1
    //   437: anewarray 74	java/lang/String
    //   440: dup
    //   441: iconst_0
    //   442: aload_3
    //   443: aastore
    //   444: aload 5
    //   446: aconst_null
    //   447: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   450: astore_2
    //   451: goto -286 -> 165
    //   454: aload_1
    //   455: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   458: astore_2
    //   459: aload_2
    //   460: invokeinterface 180 1 0
    //   465: iconst_3
    //   466: if_icmplt -303 -> 163
    //   469: aload 9
    //   471: new 196	com/tencent/mobileqq/data/DiscussionInfo
    //   474: dup
    //   475: invokespecial 197	com/tencent/mobileqq/data/DiscussionInfo:<init>	()V
    //   478: invokevirtual 198	com/tencent/mobileqq/data/DiscussionInfo:getTableName	()Ljava/lang/String;
    //   481: aconst_null
    //   482: ldc 200
    //   484: iconst_1
    //   485: anewarray 74	java/lang/String
    //   488: dup
    //   489: iconst_0
    //   490: aload_2
    //   491: iconst_2
    //   492: invokeinterface 72 2 0
    //   497: checkcast 74	java/lang/String
    //   500: aastore
    //   501: aconst_null
    //   502: aconst_null
    //   503: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   506: astore_2
    //   507: goto -342 -> 165
    //   510: aload_1
    //   511: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   514: astore_2
    //   515: aload_2
    //   516: invokeinterface 180 1 0
    //   521: iconst_4
    //   522: if_icmplt -359 -> 163
    //   525: ldc 202
    //   527: aload_2
    //   528: iconst_3
    //   529: invokeinterface 72 2 0
    //   534: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   537: ifeq +44 -> 581
    //   540: aload 9
    //   542: new 208	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   545: dup
    //   546: invokespecial 209	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   549: invokevirtual 210	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   552: aconst_null
    //   553: ldc 212
    //   555: iconst_1
    //   556: anewarray 74	java/lang/String
    //   559: dup
    //   560: iconst_0
    //   561: aload_2
    //   562: iconst_2
    //   563: invokeinterface 72 2 0
    //   568: checkcast 74	java/lang/String
    //   571: aastore
    //   572: aconst_null
    //   573: aconst_null
    //   574: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   577: astore_2
    //   578: goto -413 -> 165
    //   581: aload 9
    //   583: new 208	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   586: dup
    //   587: invokespecial 209	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   590: invokevirtual 210	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   593: aconst_null
    //   594: ldc 214
    //   596: iconst_2
    //   597: anewarray 74	java/lang/String
    //   600: dup
    //   601: iconst_0
    //   602: aload_2
    //   603: iconst_2
    //   604: invokeinterface 72 2 0
    //   609: checkcast 74	java/lang/String
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: aload_2
    //   616: iconst_3
    //   617: invokeinterface 72 2 0
    //   622: checkcast 74	java/lang/String
    //   625: aastore
    //   626: aconst_null
    //   627: aconst_null
    //   628: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   631: astore_2
    //   632: goto -467 -> 165
    //   635: invokestatic 220	android/os/SystemClock:uptimeMillis	()J
    //   638: lstore 7
    //   640: aload 9
    //   642: ldc 222
    //   644: invokevirtual 225	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   647: aconst_null
    //   648: aload_3
    //   649: aload 4
    //   651: ldc 227
    //   653: ldc 229
    //   655: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   658: astore_2
    //   659: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   662: ifeq +28 -> 690
    //   665: ldc 86
    //   667: iconst_2
    //   668: new 88	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   675: ldc 231
    //   677: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_2
    //   681: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload_2
    //   691: ifnull +292 -> 983
    //   694: aload_2
    //   695: invokeinterface 234 1 0
    //   700: ifeq +283 -> 983
    //   703: new 236	android/database/MatrixCursor
    //   706: dup
    //   707: iconst_2
    //   708: anewarray 74	java/lang/String
    //   711: dup
    //   712: iconst_0
    //   713: ldc 238
    //   715: aastore
    //   716: dup
    //   717: iconst_1
    //   718: ldc 240
    //   720: aastore
    //   721: invokespecial 243	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   724: astore_3
    //   725: aload_2
    //   726: aload_2
    //   727: ldc 238
    //   729: invokeinterface 247 2 0
    //   734: invokeinterface 251 2 0
    //   739: astore 4
    //   741: aload_2
    //   742: aload_2
    //   743: ldc 240
    //   745: invokeinterface 247 2 0
    //   750: invokeinterface 251 2 0
    //   755: astore 5
    //   757: aload_3
    //   758: iconst_2
    //   759: anewarray 157	java/lang/Object
    //   762: dup
    //   763: iconst_0
    //   764: aload 4
    //   766: aastore
    //   767: dup
    //   768: iconst_1
    //   769: aload 5
    //   771: aastore
    //   772: invokevirtual 255	android/database/MatrixCursor:addRow	([Ljava/lang/Object;)V
    //   775: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   778: ifeq +56 -> 834
    //   781: ldc 86
    //   783: iconst_2
    //   784: new 88	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   791: ldc_w 257
    //   794: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: aload_2
    //   798: invokeinterface 260 1 0
    //   803: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   806: ldc_w 265
    //   809: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload 4
    //   814: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: ldc_w 267
    //   820: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 5
    //   825: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   834: aload_3
    //   835: astore 4
    //   837: aload_2
    //   838: ifnull +12 -> 850
    //   841: aload_2
    //   842: invokeinterface 270 1 0
    //   847: aload_3
    //   848: astore 4
    //   850: aload 4
    //   852: astore_2
    //   853: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   856: ifeq -691 -> 165
    //   859: ldc 86
    //   861: iconst_2
    //   862: new 88	java/lang/StringBuilder
    //   865: dup
    //   866: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   869: ldc_w 272
    //   872: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokestatic 220	android/os/SystemClock:uptimeMillis	()J
    //   878: lload 7
    //   880: lsub
    //   881: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   884: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   890: aload 4
    //   892: astore_2
    //   893: goto -728 -> 165
    //   896: astore 4
    //   898: aconst_null
    //   899: astore_3
    //   900: aconst_null
    //   901: astore_2
    //   902: ldc 86
    //   904: iconst_1
    //   905: ldc_w 277
    //   908: aload 4
    //   910: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   913: aload_2
    //   914: astore 4
    //   916: aload_3
    //   917: ifnull -67 -> 850
    //   920: aload_3
    //   921: invokeinterface 270 1 0
    //   926: aload_2
    //   927: astore 4
    //   929: goto -79 -> 850
    //   932: astore_1
    //   933: aconst_null
    //   934: astore_2
    //   935: aload_2
    //   936: ifnull +9 -> 945
    //   939: aload_2
    //   940: invokeinterface 270 1 0
    //   945: aload_1
    //   946: athrow
    //   947: astore_1
    //   948: goto -13 -> 935
    //   951: astore_1
    //   952: aload_3
    //   953: astore_2
    //   954: goto -19 -> 935
    //   957: astore 4
    //   959: aload_2
    //   960: astore_3
    //   961: aconst_null
    //   962: astore_2
    //   963: goto -61 -> 902
    //   966: astore 5
    //   968: aload_3
    //   969: astore 4
    //   971: aload_2
    //   972: astore_3
    //   973: aload 4
    //   975: astore_2
    //   976: aload 5
    //   978: astore 4
    //   980: goto -78 -> 902
    //   983: aconst_null
    //   984: astore_3
    //   985: goto -151 -> 834
    //   988: aconst_null
    //   989: astore_2
    //   990: goto -825 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	993	0	this	FriendListProvider
    //   0	993	1	paramUri	Uri
    //   0	993	2	paramArrayOfString1	String[]
    //   0	993	3	paramString1	String
    //   0	993	4	paramArrayOfString2	String[]
    //   0	993	5	paramString2	String
    //   8	77	6	i	int
    //   638	241	7	l	long
    //   23	618	9	localObject	java.lang.Object
    //   31	10	10	localAppRuntime	mqq.app.AppRuntime
    // Exception table:
    //   from	to	target	type
    //   640	659	896	java/lang/Exception
    //   640	659	932	finally
    //   659	690	947	finally
    //   694	775	947	finally
    //   775	834	947	finally
    //   902	913	951	finally
    //   659	690	957	java/lang/Exception
    //   694	775	957	java/lang/Exception
    //   775	834	966	java/lang/Exception
  }
  
  /* Error */
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 86
    //   8: iconst_2
    //   9: new 88	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 284
    //   19: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: ldc_w 286
    //   29: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnonnull +18 -> 61
    //   46: ldc 86
    //   48: iconst_1
    //   49: ldc_w 288
    //   52: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iconst_0
    //   56: istore 5
    //   58: iload 5
    //   60: ireturn
    //   61: aload_1
    //   62: invokevirtual 66	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   65: iconst_1
    //   66: invokeinterface 72 2 0
    //   71: checkcast 74	java/lang/String
    //   74: astore_3
    //   75: aload_3
    //   76: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifeq +14 -> 93
    //   82: ldc 86
    //   84: iconst_1
    //   85: ldc_w 296
    //   88: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_0
    //   94: aload_3
    //   95: invokevirtual 78	com/tencent/mobileqq/content/FriendListProvider:getRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   98: astore 4
    //   100: aload 4
    //   102: ifnonnull +14 -> 116
    //   105: ldc 86
    //   107: iconst_1
    //   108: ldc_w 298
    //   111: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: iconst_0
    //   115: ireturn
    //   116: new 80	com/tencent/mobileqq/content/ProviderAppRuntimeProxy
    //   119: dup
    //   120: invokespecial 81	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:<init>	()V
    //   123: aload 4
    //   125: aload_3
    //   126: iconst_0
    //   127: invokevirtual 84	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   130: astore_3
    //   131: aload_3
    //   132: ifnonnull +14 -> 146
    //   135: ldc 86
    //   137: iconst_1
    //   138: ldc_w 300
    //   141: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: aload_0
    //   147: getfield 19	com/tencent/mobileqq/content/FriendListProvider:a	Landroid/content/UriMatcher;
    //   150: aload_1
    //   151: invokevirtual 60	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   154: tableswitch	default:+18 -> 172, 1007:+20->174
    //   173: ireturn
    //   174: invokestatic 220	android/os/SystemClock:uptimeMillis	()J
    //   177: lstore 7
    //   179: ldc 222
    //   181: invokevirtual 225	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   184: astore 4
    //   186: aload_3
    //   187: aload 4
    //   189: invokevirtual 304	com/tencent/mobileqq/app/SQLiteDatabase:b	(Ljava/lang/String;)Z
    //   192: ifne +68 -> 260
    //   195: aload_3
    //   196: new 222	com/tencent/mobileqq/vas/VasKeyValue
    //   199: dup
    //   200: invokespecial 305	com/tencent/mobileqq/vas/VasKeyValue:<init>	()V
    //   203: invokestatic 310	com/tencent/mobileqq/persistence/TableBuilder:a	(Lcom/tencent/mobileqq/persistence/Entity;)Ljava/lang/String;
    //   206: invokevirtual 312	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   209: istore 11
    //   211: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +30 -> 244
    //   217: ldc 86
    //   219: iconst_2
    //   220: new 88	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 314
    //   230: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 11
    //   235: invokevirtual 317	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   238: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: iload 11
    //   246: ifne +14 -> 260
    //   249: ldc 86
    //   251: iconst_1
    //   252: ldc_w 319
    //   255: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: iconst_0
    //   259: ireturn
    //   260: aload_2
    //   261: ldc 238
    //   263: invokevirtual 325	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 12
    //   268: aload_2
    //   269: ldc 240
    //   271: invokevirtual 325	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore_1
    //   275: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +40 -> 318
    //   281: ldc 86
    //   283: iconst_2
    //   284: new 88	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 327
    //   294: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 12
    //   299: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 329
    //   305: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_1
    //   309: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 12
    //   320: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifeq +14 -> 337
    //   326: ldc 86
    //   328: iconst_1
    //   329: ldc_w 331
    //   332: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: iconst_0
    //   336: ireturn
    //   337: aload_3
    //   338: aload 4
    //   340: aconst_null
    //   341: ldc_w 333
    //   344: iconst_1
    //   345: anewarray 74	java/lang/String
    //   348: dup
    //   349: iconst_0
    //   350: aload 12
    //   352: aastore
    //   353: aconst_null
    //   354: aconst_null
    //   355: invokevirtual 150	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   358: astore_1
    //   359: aload_1
    //   360: ifnull +198 -> 558
    //   363: aload_1
    //   364: invokeinterface 260 1 0
    //   369: ifle +189 -> 558
    //   372: aload_1
    //   373: invokeinterface 234 1 0
    //   378: ifeq +180 -> 558
    //   381: aload_1
    //   382: aload_1
    //   383: ldc 238
    //   385: invokeinterface 247 2 0
    //   390: invokeinterface 251 2 0
    //   395: astore 13
    //   397: aload_1
    //   398: aload_1
    //   399: ldc 240
    //   401: invokeinterface 247 2 0
    //   406: invokeinterface 251 2 0
    //   411: astore 14
    //   413: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   416: ifeq +56 -> 472
    //   419: ldc 86
    //   421: iconst_2
    //   422: new 88	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 335
    //   432: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 13
    //   437: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc_w 337
    //   443: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 14
    //   448: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: ldc_w 339
    //   454: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_1
    //   458: invokeinterface 260 1 0
    //   463: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: aload_3
    //   473: aload 4
    //   475: aload_2
    //   476: ldc_w 333
    //   479: iconst_1
    //   480: anewarray 74	java/lang/String
    //   483: dup
    //   484: iconst_0
    //   485: aload 12
    //   487: aastore
    //   488: invokevirtual 342	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   491: istore 6
    //   493: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +45 -> 541
    //   499: ldc 86
    //   501: iconst_2
    //   502: new 88	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 344
    //   512: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: iload 6
    //   517: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: ldc_w 346
    //   523: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokestatic 220	android/os/SystemClock:uptimeMillis	()J
    //   529: lload 7
    //   531: lsub
    //   532: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: iload 6
    //   543: istore 5
    //   545: aload_1
    //   546: ifnull -488 -> 58
    //   549: aload_1
    //   550: invokeinterface 270 1 0
    //   555: iload 6
    //   557: ireturn
    //   558: aload_3
    //   559: aload 4
    //   561: aconst_null
    //   562: aload_2
    //   563: invokevirtual 349	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   566: lstore 9
    //   568: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +45 -> 616
    //   574: ldc 86
    //   576: iconst_2
    //   577: new 88	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 351
    //   587: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: lload 9
    //   592: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   595: ldc_w 346
    //   598: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokestatic 220	android/os/SystemClock:uptimeMillis	()J
    //   604: lload 7
    //   606: lsub
    //   607: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   610: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: lload 9
    //   618: ldc2_w 352
    //   621: lcmp
    //   622: ifeq +23 -> 645
    //   625: iconst_1
    //   626: istore 6
    //   628: iload 6
    //   630: istore 5
    //   632: aload_1
    //   633: ifnull -575 -> 58
    //   636: aload_1
    //   637: invokeinterface 270 1 0
    //   642: iload 6
    //   644: ireturn
    //   645: iconst_0
    //   646: istore 6
    //   648: goto -20 -> 628
    //   651: astore_2
    //   652: aconst_null
    //   653: astore_1
    //   654: ldc 86
    //   656: iconst_1
    //   657: ldc_w 355
    //   660: aload_2
    //   661: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   664: aload_1
    //   665: ifnull -493 -> 172
    //   668: aload_1
    //   669: invokeinterface 270 1 0
    //   674: goto -502 -> 172
    //   677: astore_2
    //   678: aconst_null
    //   679: astore_1
    //   680: aload_1
    //   681: ifnull +9 -> 690
    //   684: aload_1
    //   685: invokeinterface 270 1 0
    //   690: aload_2
    //   691: athrow
    //   692: astore_2
    //   693: goto -13 -> 680
    //   696: astore_2
    //   697: goto -17 -> 680
    //   700: astore_2
    //   701: goto -47 -> 654
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	FriendListProvider
    //   0	704	1	paramUri	Uri
    //   0	704	2	paramContentValues	ContentValues
    //   0	704	3	paramString	String
    //   0	704	4	paramArrayOfString	String[]
    //   56	575	5	i	int
    //   491	156	6	j	int
    //   177	428	7	l1	long
    //   566	51	9	l2	long
    //   209	36	11	bool	boolean
    //   266	220	12	str1	String
    //   395	41	13	str2	String
    //   411	36	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   337	359	651	java/lang/Exception
    //   337	359	677	finally
    //   363	472	692	finally
    //   472	541	692	finally
    //   558	616	692	finally
    //   654	664	696	finally
    //   363	472	700	java/lang/Exception
    //   472	541	700	java/lang/Exception
    //   558	616	700	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.content.FriendListProvider
 * JD-Core Version:    0.7.0.1
 */