package com.tencent.biz.pubaccount.readinjoy.data;

import com.tencent.mobileqq.app.automator.AsyncStep;

public class ReadInJoyDAUReport
  extends AsyncStep
{
  /* Error */
  protected int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 27	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 33	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 4
    //   15: ldc 35
    //   17: monitorenter
    //   18: aload 4
    //   20: ldc 35
    //   22: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   30: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   33: bipush 50
    //   35: invokevirtual 44	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   38: checkcast 46	com/tencent/mobileqq/app/FriendsManager
    //   41: astore 5
    //   43: aload 5
    //   45: ifnull +614 -> 659
    //   48: aload 5
    //   50: aload_0
    //   51: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   54: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   57: invokevirtual 50	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   60: invokevirtual 54	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +592 -> 659
    //   70: aload 5
    //   72: getfield 60	com/tencent/mobileqq/data/Card:shGender	S
    //   75: istore_2
    //   76: aload 5
    //   78: getfield 64	com/tencent/mobileqq/data/Card:age	B
    //   81: istore_1
    //   82: aload_3
    //   83: ifnull +562 -> 645
    //   86: aload_3
    //   87: invokeinterface 69 1 0
    //   92: ifle +553 -> 645
    //   95: aload_3
    //   96: invokeinterface 73 1 0
    //   101: astore_3
    //   102: aload_3
    //   103: invokeinterface 79 1 0
    //   108: ifeq +537 -> 645
    //   111: aload_3
    //   112: invokeinterface 83 1 0
    //   117: checkcast 35	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo
    //   120: astore 5
    //   122: new 85	java/util/HashMap
    //   125: dup
    //   126: iconst_2
    //   127: invokespecial 88	java/util/HashMap:<init>	(I)V
    //   130: astore 6
    //   132: aload 6
    //   134: ldc 90
    //   136: aload 5
    //   138: getfield 93	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   141: invokevirtual 97	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload 6
    //   147: ldc 99
    //   149: aload 5
    //   151: getfield 102	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:count	I
    //   154: invokestatic 108	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   157: invokevirtual 97	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: aload 6
    //   163: ldc 110
    //   165: iload_2
    //   166: invokestatic 108	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   169: invokevirtual 97	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: aload 6
    //   175: ldc 111
    //   177: iload_1
    //   178: invokestatic 108	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   181: invokevirtual 97	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: pop
    //   185: aload 6
    //   187: ldc 113
    //   189: aload 5
    //   191: getfield 115	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   194: invokevirtual 97	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +92 -> 293
    //   204: ldc 122
    //   206: iconst_2
    //   207: new 124	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   214: ldc 127
    //   216: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   223: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   226: invokevirtual 50	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   229: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   232: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 136
    //   237: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 5
    //   242: getfield 139	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   245: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 141
    //   250: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 143
    //   255: iconst_1
    //   256: anewarray 145	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: invokestatic 150	com/tencent/common/config/AppSetting:c	()Ljava/lang/String;
    //   264: aastore
    //   265: invokestatic 154	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   268: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc 156
    //   273: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 5
    //   278: getfield 160	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   281: invokestatic 166	java/lang/Long:toString	(J)Ljava/lang/String;
    //   284: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aconst_null
    //   294: ldc 174
    //   296: ldc 176
    //   298: ldc 176
    //   300: ldc 178
    //   302: ldc 178
    //   304: iconst_0
    //   305: iconst_0
    //   306: aload 5
    //   308: getfield 160	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   311: invokestatic 166	java/lang/Long:toString	(J)Ljava/lang/String;
    //   314: aload 5
    //   316: getfield 139	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   319: ldc 143
    //   321: iconst_1
    //   322: anewarray 145	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: invokestatic 150	com/tencent/common/config/AppSetting:c	()Ljava/lang/String;
    //   330: aastore
    //   331: invokestatic 154	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   334: aconst_null
    //   335: invokestatic 183	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_0
    //   339: aload 5
    //   341: getfield 115	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   344: invokevirtual 186	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 6
    //   349: aload 5
    //   351: getfield 93	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   354: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifne +158 -> 515
    //   360: aload 5
    //   362: getfield 93	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   365: ldc 194
    //   367: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   370: ifeq +145 -> 515
    //   373: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +92 -> 468
    //   379: ldc 122
    //   381: iconst_2
    //   382: new 124	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   389: ldc 200
    //   391: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   398: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   401: invokevirtual 50	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   404: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   407: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc 136
    //   412: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload 5
    //   417: getfield 139	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   420: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc 141
    //   425: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc 143
    //   430: iconst_1
    //   431: anewarray 145	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: invokestatic 150	com/tencent/common/config/AppSetting:c	()Ljava/lang/String;
    //   439: aastore
    //   440: invokestatic 154	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   443: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc 156
    //   448: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 5
    //   453: getfield 160	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   456: invokestatic 166	java/lang/Long:toString	(J)Ljava/lang/String;
    //   459: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aconst_null
    //   469: ldc 174
    //   471: ldc 176
    //   473: ldc 176
    //   475: ldc 202
    //   477: ldc 202
    //   479: iconst_0
    //   480: iconst_0
    //   481: aload 5
    //   483: getfield 160	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   486: invokestatic 166	java/lang/Long:toString	(J)Ljava/lang/String;
    //   489: aload 5
    //   491: getfield 139	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   494: ldc 143
    //   496: iconst_1
    //   497: anewarray 145	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: invokestatic 150	com/tencent/common/config/AppSetting:c	()Ljava/lang/String;
    //   505: aastore
    //   506: invokestatic 154	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   509: invokestatic 205	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:c	()Ljava/lang/String;
    //   512: invokestatic 183	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload 5
    //   517: getfield 93	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   520: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   523: ifne -421 -> 102
    //   526: aload 6
    //   528: ifnull -426 -> 102
    //   531: aload 6
    //   533: ldc 194
    //   535: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   538: ifeq -436 -> 102
    //   541: aload 5
    //   543: getfield 93	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   546: ldc 207
    //   548: invokevirtual 210	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   551: ifeq -449 -> 102
    //   554: aconst_null
    //   555: ldc 174
    //   557: ldc 176
    //   559: ldc 176
    //   561: ldc 202
    //   563: ldc 202
    //   565: iconst_0
    //   566: iconst_0
    //   567: aload 5
    //   569: getfield 160	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   572: invokestatic 166	java/lang/Long:toString	(J)Ljava/lang/String;
    //   575: aload 5
    //   577: getfield 139	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   580: ldc 143
    //   582: iconst_1
    //   583: anewarray 145	java/lang/Object
    //   586: dup
    //   587: iconst_0
    //   588: invokestatic 150	com/tencent/common/config/AppSetting:c	()Ljava/lang/String;
    //   591: aastore
    //   592: invokestatic 154	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   595: invokestatic 205	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:c	()Ljava/lang/String;
    //   598: invokestatic 183	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   601: goto -499 -> 102
    //   604: astore_3
    //   605: ldc 35
    //   607: monitorexit
    //   608: aload_3
    //   609: athrow
    //   610: astore_3
    //   611: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq +52 -> 666
    //   617: ldc 122
    //   619: iconst_2
    //   620: new 124	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   627: ldc 212
    //   629: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload_3
    //   633: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: goto +24 -> 666
    //   645: aload 4
    //   647: ldc 35
    //   649: invokevirtual 218	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   652: pop
    //   653: ldc 35
    //   655: monitorexit
    //   656: bipush 7
    //   658: ireturn
    //   659: iconst_m1
    //   660: istore_1
    //   661: iconst_m1
    //   662: istore_2
    //   663: goto -581 -> 82
    //   666: aconst_null
    //   667: astore_3
    //   668: goto -642 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	ReadInJoyDAUReport
    //   81	580	1	i	int
    //   75	588	2	j	int
    //   25	87	3	localObject1	java.lang.Object
    //   604	5	3	localObject2	java.lang.Object
    //   610	23	3	localException	java.lang.Exception
    //   667	1	3	localObject3	java.lang.Object
    //   13	633	4	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   41	535	5	localObject4	java.lang.Object
    //   130	402	6	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   18	26	604	finally
    //   26	43	604	finally
    //   48	65	604	finally
    //   70	82	604	finally
    //   86	102	604	finally
    //   102	293	604	finally
    //   293	468	604	finally
    //   468	515	604	finally
    //   515	526	604	finally
    //   531	601	604	finally
    //   605	608	604	finally
    //   611	642	604	finally
    //   645	656	604	finally
    //   18	26	610	java/lang/Exception
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        paramString = paramString.split("\\|");
      } while (paramString == null);
      paramString = paramString[(paramString.length - 1)].split(".");
    } while ((paramString == null) || (paramString.length <= 1));
    return paramString[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUReport
 * JD-Core Version:    0.7.0.1
 */