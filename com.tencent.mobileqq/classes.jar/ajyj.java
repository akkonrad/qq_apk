import com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter;
import java.util.Map;

public class ajyj
  implements Runnable
{
  public ajyj(UnifiedTraceRouter paramUnifiedTraceRouter, String paramString, long paramLong, Map paramMap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   4: aload_0
    //   5: getfield 17	ajyj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokevirtual 35	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:a	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_3
    //   12: new 37	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   25: astore 5
    //   27: aload 5
    //   29: aload 4
    //   31: aload 5
    //   33: getfield 41	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 47
    //   45: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: putfield 41	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   58: getfield 54	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_Float	F
    //   61: fstore_2
    //   62: aload_3
    //   63: ldc 56
    //   65: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +14 -> 82
    //   71: fload_2
    //   72: fstore_1
    //   73: aload_3
    //   74: ldc 64
    //   76: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   79: ifeq +43 -> 122
    //   82: fload_2
    //   83: fstore_1
    //   84: aload_0
    //   85: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   88: getfield 67	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   91: bipush 32
    //   93: if_icmpne +29 -> 122
    //   96: aload_0
    //   97: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   100: aload_3
    //   101: invokevirtual 70	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:d	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 4
    //   106: fload_2
    //   107: fstore_1
    //   108: aload 4
    //   110: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +9 -> 122
    //   116: aload 4
    //   118: invokestatic 81	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   121: fstore_1
    //   122: new 83	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo
    //   125: dup
    //   126: aload_0
    //   127: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   130: aload_0
    //   131: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   134: aload_3
    //   135: invokevirtual 85	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:b	(Ljava/lang/String;)Ljava/lang/String;
    //   138: fload_1
    //   139: invokespecial 88	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:<init>	(Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;Ljava/lang/String;F)V
    //   142: astore 4
    //   144: aload 4
    //   146: aload_0
    //   147: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   150: getfield 67	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   153: putfield 90	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_Int	I
    //   156: aload 4
    //   158: aload 4
    //   160: getfield 91	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   163: invokestatic 97	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   166: invokevirtual 100	java/net/InetAddress:getHostName	()Ljava/lang/String;
    //   169: putfield 101	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   176: getfield 104	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   179: aload 4
    //   181: invokeinterface 110 2 0
    //   186: pop
    //   187: aload_3
    //   188: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +100 -> 291
    //   194: aload_0
    //   195: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   198: getfield 104	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   201: aload_0
    //   202: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   205: getfield 104	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   208: invokeinterface 114 1 0
    //   213: iconst_1
    //   214: isub
    //   215: invokeinterface 118 2 0
    //   220: checkcast 83	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo
    //   223: astore_3
    //   224: aload_3
    //   225: getfield 91	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   228: aload_0
    //   229: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   232: getfield 119	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   235: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +338 -> 576
    //   241: aload_0
    //   242: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   245: getfield 67	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   248: bipush 32
    //   250: if_icmpge +132 -> 382
    //   253: aload_0
    //   254: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   257: bipush 32
    //   259: putfield 67	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   262: aload_0
    //   263: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   266: getfield 104	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   269: aload_3
    //   270: invokeinterface 125 2 0
    //   275: pop
    //   276: aload_0
    //   277: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   280: getfield 128	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   283: aload_0
    //   284: ldc2_w 129
    //   287: invokevirtual 136	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   290: pop
    //   291: return
    //   292: astore_3
    //   293: ldc 138
    //   295: iconst_1
    //   296: new 37	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   303: ldc 140
    //   305: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_3
    //   309: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload_0
    //   322: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   325: getfield 152	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   328: bipush 93
    //   330: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   333: checkcast 160	com/tencent/mobileqq/secspy/SecSpyFileManager
    //   336: aload_0
    //   337: getfield 19	ajyj:jdField_a_of_type_Long	J
    //   340: aload_3
    //   341: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   344: invokevirtual 163	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLjava/lang/String;)V
    //   347: return
    //   348: astore 5
    //   350: ldc 138
    //   352: iconst_1
    //   353: new 37	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   360: ldc 165
    //   362: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 5
    //   367: invokevirtual 166	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   370: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: goto -207 -> 172
    //   382: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +112 -> 497
    //   388: aload_0
    //   389: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   392: getfield 104	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   395: invokeinterface 174 1 0
    //   400: astore_3
    //   401: aload_3
    //   402: invokeinterface 179 1 0
    //   407: ifeq +90 -> 497
    //   410: aload_3
    //   411: invokeinterface 183 1 0
    //   416: checkcast 83	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo
    //   419: astore 4
    //   421: ldc 138
    //   423: iconst_2
    //   424: new 37	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   431: ldc 185
    //   433: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 4
    //   438: getfield 90	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_Int	I
    //   441: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc 190
    //   446: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload 4
    //   451: getfield 101	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   454: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc 190
    //   459: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 4
    //   464: getfield 91	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   467: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc 190
    //   472: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload 4
    //   477: getfield 191	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_Float	F
    //   480: invokevirtual 194	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   483: ldc 196
    //   485: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: goto -93 -> 401
    //   497: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +16 -> 516
    //   503: ldc 138
    //   505: iconst_2
    //   506: aload_0
    //   507: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   510: getfield 41	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   513: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: aload_0
    //   517: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   520: getfield 152	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   523: bipush 93
    //   525: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   528: checkcast 160	com/tencent/mobileqq/secspy/SecSpyFileManager
    //   531: aload_0
    //   532: getfield 19	ajyj:jdField_a_of_type_Long	J
    //   535: aload_0
    //   536: getfield 17	ajyj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   539: aload_0
    //   540: getfield 21	ajyj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   543: aload_0
    //   544: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   547: getfield 104	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   550: invokevirtual 201	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLjava/lang/String;Ljava/util/Map;Ljava/util/List;)V
    //   553: aload_0
    //   554: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   557: iconst_1
    //   558: putfield 67	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   561: aload_0
    //   562: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   565: new 203	java/util/ArrayList
    //   568: dup
    //   569: invokespecial 204	java/util/ArrayList:<init>	()V
    //   572: putfield 104	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   575: return
    //   576: aload_0
    //   577: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   580: getfield 67	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   583: bipush 32
    //   585: if_icmpge -294 -> 291
    //   588: aload_0
    //   589: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   592: astore_3
    //   593: aload_3
    //   594: aload_3
    //   595: getfield 67	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   598: iconst_1
    //   599: iadd
    //   600: putfield 67	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   603: aload_0
    //   604: getfield 15	ajyj:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedTraceRouter	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   607: getfield 128	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   610: aload_0
    //   611: ldc2_w 129
    //   614: invokevirtual 136	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   617: pop
    //   618: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	ajyj
    //   72	67	1	f1	float
    //   61	46	2	f2	float
    //   11	259	3	localObject1	Object
    //   292	49	3	localException	java.lang.Exception
    //   400	195	3	localObject2	Object
    //   19	457	4	localObject3	Object
    //   25	7	5	localUnifiedTraceRouter	UnifiedTraceRouter
    //   348	18	5	localUnknownHostException	java.net.UnknownHostException
    // Exception table:
    //   from	to	target	type
    //   0	54	292	java/lang/Exception
    //   156	172	348	java/net/UnknownHostException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyj
 * JD-Core Version:    0.7.0.1
 */