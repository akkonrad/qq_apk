import com.tencent.mobileqq.profile.vote.VoteHelper;

public class agsx
  implements Runnable
{
  public agsx(VoteHelper paramVoteHelper, String paramString, int paramInt, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	agsx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 32	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   7: invokevirtual 36	java/lang/Long:longValue	()J
    //   10: lstore_2
    //   11: aload_0
    //   12: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   15: getfield 41	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   21: invokevirtual 53	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   24: astore 7
    //   26: aload 7
    //   28: ldc 55
    //   30: ldc 57
    //   32: iconst_2
    //   33: anewarray 59	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: lload_2
    //   39: invokestatic 63	java/lang/Long:toString	(J)Ljava/lang/String;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: iconst_3
    //   46: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   49: aastore
    //   50: invokevirtual 73	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   53: checkcast 55	com/tencent/mobileqq/data/CardProfile
    //   56: astore 8
    //   58: aload 8
    //   60: ifnull +421 -> 481
    //   63: iconst_1
    //   64: istore 4
    //   66: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +53 -> 122
    //   72: ldc 81
    //   74: iconst_2
    //   75: new 83	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   82: ldc 86
    //   84: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 17	agsx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 92
    //   96: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 19	agsx:jdField_a_of_type_Int	I
    //   103: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc 97
    //   108: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 4
    //   113: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   116: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_0
    //   123: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   126: getfield 110	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   129: lload_2
    //   130: invokestatic 113	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   133: invokeinterface 119 2 0
    //   138: checkcast 121	com/tencent/util/Pair
    //   141: astore 9
    //   143: getstatic 124	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   146: astore 6
    //   148: aload 6
    //   150: monitorenter
    //   151: iconst_0
    //   152: istore_1
    //   153: iload_1
    //   154: aload_0
    //   155: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   158: getfield 127	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   161: getfield 133	com/tencent/mobileqq/activity/VisitorsActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   164: invokevirtual 139	java/util/ArrayList:size	()I
    //   167: if_icmpge +384 -> 551
    //   170: aload_0
    //   171: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   174: getfield 127	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   177: getfield 133	com/tencent/mobileqq/activity/VisitorsActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   180: iload_1
    //   181: invokevirtual 142	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   184: checkcast 55	com/tencent/mobileqq/data/CardProfile
    //   187: astore 5
    //   189: aload 5
    //   191: ifnull +296 -> 487
    //   194: aload 5
    //   196: getfield 146	com/tencent/mobileqq/data/CardProfile:lEctID	J
    //   199: lload_2
    //   200: lcmp
    //   201: ifne +286 -> 487
    //   204: aload 5
    //   206: ifnull +339 -> 545
    //   209: aload 5
    //   211: invokevirtual 150	com/tencent/mobileqq/data/CardProfile:clone	()Lcom/tencent/mobileqq/data/CardProfile;
    //   214: astore 5
    //   216: aload 9
    //   218: ifnull +49 -> 267
    //   221: aload 5
    //   223: aload 5
    //   225: getfield 153	com/tencent/mobileqq/data/CardProfile:bAvailableCnt	J
    //   228: aload 9
    //   230: getfield 156	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   233: checkcast 158	java/util/concurrent/atomic/AtomicInteger
    //   236: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   239: i2l
    //   240: ladd
    //   241: putfield 153	com/tencent/mobileqq/data/CardProfile:bAvailableCnt	J
    //   244: aload 5
    //   246: aload 5
    //   248: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   251: aload 9
    //   253: getfield 156	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   256: checkcast 158	java/util/concurrent/atomic/AtomicInteger
    //   259: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   262: i2l
    //   263: lsub
    //   264: putfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   267: aload 5
    //   269: aload 5
    //   271: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   274: l2i
    //   275: i2s
    //   276: putfield 167	com/tencent/mobileqq/data/CardProfile:bVoteCnt	S
    //   279: aload 6
    //   281: monitorexit
    //   282: aload 5
    //   284: ifnull +67 -> 351
    //   287: iload 4
    //   289: ifeq +44 -> 333
    //   292: aload 8
    //   294: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   297: aload 5
    //   299: getfield 163	com/tencent/mobileqq/data/CardProfile:bTodayVotedCnt	J
    //   302: lcmp
    //   303: ifne +30 -> 333
    //   306: aload 8
    //   308: getfield 153	com/tencent/mobileqq/data/CardProfile:bAvailableCnt	J
    //   311: aload 5
    //   313: getfield 153	com/tencent/mobileqq/data/CardProfile:bAvailableCnt	J
    //   316: lcmp
    //   317: ifne +16 -> 333
    //   320: aload 8
    //   322: getfield 167	com/tencent/mobileqq/data/CardProfile:bVoteCnt	S
    //   325: aload 5
    //   327: getfield 167	com/tencent/mobileqq/data/CardProfile:bVoteCnt	S
    //   330: if_icmpeq +21 -> 351
    //   333: aload 5
    //   335: invokevirtual 170	com/tencent/mobileqq/data/CardProfile:getStatus	()I
    //   338: sipush 1000
    //   341: if_icmpne +161 -> 502
    //   344: aload 7
    //   346: aload 5
    //   348: invokevirtual 173	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   351: aload_0
    //   352: getfield 21	agsx:jdField_a_of_type_Boolean	Z
    //   355: ifeq +158 -> 513
    //   358: aload_0
    //   359: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   362: getfield 175	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   365: astore 5
    //   367: getstatic 177	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   370: astore 6
    //   372: aload 6
    //   374: monitorenter
    //   375: iconst_0
    //   376: istore_1
    //   377: iload_1
    //   378: aload 5
    //   380: invokevirtual 139	java/util/ArrayList:size	()I
    //   383: if_icmpge +157 -> 540
    //   386: aload 5
    //   388: iload_1
    //   389: invokevirtual 142	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   392: checkcast 28	java/lang/Long
    //   395: invokevirtual 36	java/lang/Long:longValue	()J
    //   398: lload_2
    //   399: lcmp
    //   400: ifne +125 -> 525
    //   403: iconst_0
    //   404: istore_1
    //   405: iload_1
    //   406: ifeq +13 -> 419
    //   409: aload 5
    //   411: lload_2
    //   412: invokestatic 113	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   415: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   418: pop
    //   419: aload 6
    //   421: monitorexit
    //   422: iload_1
    //   423: ifeq +57 -> 480
    //   426: new 135	java/util/ArrayList
    //   429: dup
    //   430: invokespecial 182	java/util/ArrayList:<init>	()V
    //   433: astore 5
    //   435: aload 5
    //   437: aload_0
    //   438: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   441: getfield 175	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   444: invokeinterface 188 2 0
    //   449: pop
    //   450: aload 5
    //   452: aload_0
    //   453: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   456: getfield 189	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   459: invokeinterface 188 2 0
    //   464: pop
    //   465: aload_0
    //   466: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   469: getfield 127	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity	Lcom/tencent/mobileqq/activity/VisitorsActivity;
    //   472: getfield 192	com/tencent/mobileqq/activity/VisitorsActivity:a	Lcom/tencent/mobileqq/app/CardHandler;
    //   475: aload 5
    //   477: invokevirtual 197	com/tencent/mobileqq/app/CardHandler:b	(Ljava/util/List;)V
    //   480: return
    //   481: iconst_0
    //   482: istore 4
    //   484: goto -418 -> 66
    //   487: iload_1
    //   488: iconst_1
    //   489: iadd
    //   490: istore_1
    //   491: goto -338 -> 153
    //   494: astore 5
    //   496: aload 6
    //   498: monitorexit
    //   499: aload 5
    //   501: athrow
    //   502: aload 7
    //   504: aload 5
    //   506: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   509: pop
    //   510: goto -159 -> 351
    //   513: aload_0
    //   514: getfield 15	agsx:jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper	Lcom/tencent/mobileqq/profile/vote/VoteHelper;
    //   517: getfield 189	com/tencent/mobileqq/profile/vote/VoteHelper:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   520: astore 5
    //   522: goto -155 -> 367
    //   525: iload_1
    //   526: iconst_1
    //   527: iadd
    //   528: istore_1
    //   529: goto -152 -> 377
    //   532: astore 5
    //   534: aload 6
    //   536: monitorexit
    //   537: aload 5
    //   539: athrow
    //   540: iconst_1
    //   541: istore_1
    //   542: goto -137 -> 405
    //   545: aconst_null
    //   546: astore 5
    //   548: goto -269 -> 279
    //   551: aconst_null
    //   552: astore 5
    //   554: goto -350 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	this	agsx
    //   152	390	1	i	int
    //   10	402	2	l	long
    //   64	419	4	bool	boolean
    //   187	289	5	localObject1	Object
    //   494	11	5	localEntity	com.tencent.mobileqq.persistence.Entity
    //   520	1	5	localArrayList	java.util.ArrayList
    //   532	6	5	localObject2	Object
    //   546	7	5	localObject3	Object
    //   146	389	6	localObject4	Object
    //   24	479	7	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   56	265	8	localCardProfile	com.tencent.mobileqq.data.CardProfile
    //   141	111	9	localPair	com.tencent.util.Pair
    // Exception table:
    //   from	to	target	type
    //   153	189	494	finally
    //   194	204	494	finally
    //   209	216	494	finally
    //   221	267	494	finally
    //   267	279	494	finally
    //   279	282	494	finally
    //   496	499	494	finally
    //   377	403	532	finally
    //   409	419	532	finally
    //   419	422	532	finally
    //   534	537	532	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agsx
 * JD-Core Version:    0.7.0.1
 */