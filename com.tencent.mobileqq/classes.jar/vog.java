import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import java.util.ArrayList;

public class vog
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  public AIORichMediaInfo a;
  public boolean a;
  AIORichMediaInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  
  public vog(AIOImageListScene paramAIOImageListScene, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo[])paramArrayList.toArray(new AIORichMediaInfo[0]));
  }
  
  /* Error */
  protected Integer a(Integer... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +1135 -> 1138
    //   6: ldc 44
    //   8: iconst_2
    //   9: new 46	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   16: ldc 49
    //   18: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: goto +1107 -> 1138
    //   34: iload_3
    //   35: aload_1
    //   36: arraylength
    //   37: if_icmpge +1088 -> 1125
    //   40: aload_1
    //   41: iload_3
    //   42: aaload
    //   43: invokevirtual 70	java/lang/Integer:intValue	()I
    //   46: istore 4
    //   48: aload_0
    //   49: getfield 19	vog:jdField_a_of_type_Boolean	Z
    //   52: ifne +8 -> 60
    //   55: iconst_1
    //   56: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: areturn
    //   60: aload_0
    //   61: iconst_1
    //   62: anewarray 66	java/lang/Integer
    //   65: dup
    //   66: iconst_0
    //   67: iload_3
    //   68: bipush 100
    //   70: imul
    //   71: aload_1
    //   72: arraylength
    //   73: idiv
    //   74: ldc 75
    //   76: iand
    //   77: iload 4
    //   79: bipush 16
    //   81: ishl
    //   82: ior
    //   83: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: invokevirtual 79	vog:publishProgress	([Ljava/lang/Object;)V
    //   90: iload 4
    //   92: tableswitch	default:+1053 -> 1145, 0:+1060->1152, 1:+413->505, 2:+1060->1152
    //   121: aload_0
    //   122: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   125: arraylength
    //   126: if_icmpge +1038 -> 1164
    //   129: aload_0
    //   130: getfield 19	vog:jdField_a_of_type_Boolean	Z
    //   133: ifne +8 -> 141
    //   136: iconst_1
    //   137: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: areturn
    //   141: aload_0
    //   142: iconst_1
    //   143: anewarray 66	java/lang/Integer
    //   146: dup
    //   147: iconst_0
    //   148: iload_3
    //   149: bipush 100
    //   151: imul
    //   152: aload_1
    //   153: arraylength
    //   154: idiv
    //   155: iload_2
    //   156: bipush 100
    //   158: imul
    //   159: aload_1
    //   160: arraylength
    //   161: idiv
    //   162: aload_0
    //   163: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   166: arraylength
    //   167: idiv
    //   168: iadd
    //   169: ldc 75
    //   171: iand
    //   172: iload 4
    //   174: bipush 16
    //   176: ishl
    //   177: ior
    //   178: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: invokevirtual 79	vog:publishProgress	([Ljava/lang/Object;)V
    //   185: aload_0
    //   186: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   189: iload_2
    //   190: aaload
    //   191: astore 8
    //   193: ldc 81
    //   195: aload 8
    //   197: getfield 84	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   200: invokevirtual 90	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   203: ifeq +289 -> 492
    //   206: aload 8
    //   208: getfield 84	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   211: checkcast 81	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   214: astore 7
    //   216: aload 7
    //   218: getfield 94	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   221: astore 9
    //   223: ldc 96
    //   225: aload 9
    //   227: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +6 -> 236
    //   233: goto +924 -> 1157
    //   236: aload_0
    //   237: aload 8
    //   239: putfield 103	vog:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   242: aload_0
    //   243: getfield 19	vog:jdField_a_of_type_Boolean	Z
    //   246: ifeq +164 -> 410
    //   249: aload 9
    //   251: ifnull +18 -> 269
    //   254: new 105	java/io/File
    //   257: dup
    //   258: aload 9
    //   260: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   263: invokevirtual 111	java/io/File:exists	()Z
    //   266: ifne +144 -> 410
    //   269: aload_0
    //   270: getfield 103	vog:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   273: iconst_1
    //   274: putfield 112	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Boolean	Z
    //   277: aload_0
    //   278: getfield 14	vog:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;
    //   281: getfield 117	com/tencent/mobileqq/activity/aio/photo/AIOImageListScene:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   284: aload 7
    //   286: getfield 121	com/tencent/mobileqq/activity/aio/photo/AIOImageData:g	J
    //   289: aload 7
    //   291: getfield 124	com/tencent/mobileqq/activity/aio/photo/AIOImageData:f	I
    //   294: iconst_2
    //   295: invokeinterface 129 5 0
    //   300: aload_0
    //   301: getfield 103	vog:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   304: astore 8
    //   306: aload 8
    //   308: monitorenter
    //   309: aload_0
    //   310: getfield 103	vog:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   313: getfield 112	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Boolean	Z
    //   316: ifeq +10 -> 326
    //   319: aload_0
    //   320: getfield 103	vog:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   323: invokevirtual 134	java/lang/Object:wait	()V
    //   326: aload 8
    //   328: monitorexit
    //   329: aload 7
    //   331: getfield 136	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   334: ifeq +76 -> 410
    //   337: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +41 -> 381
    //   343: ldc 44
    //   345: iconst_2
    //   346: new 46	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   353: ldc 138
    //   355: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload_2
    //   359: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 143
    //   364: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 7
    //   369: getfield 94	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   372: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload_0
    //   382: aload_0
    //   383: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   386: arraylength
    //   387: iload_2
    //   388: isub
    //   389: putfield 145	vog:jdField_a_of_type_Int	I
    //   392: bipush 11
    //   394: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: areturn
    //   398: astore_1
    //   399: aload 8
    //   401: monitorexit
    //   402: aload_1
    //   403: athrow
    //   404: astore_1
    //   405: iconst_2
    //   406: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   409: areturn
    //   410: aload_0
    //   411: getfield 19	vog:jdField_a_of_type_Boolean	Z
    //   414: ifne +8 -> 422
    //   417: iconst_1
    //   418: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: areturn
    //   422: aload 7
    //   424: iconst_2
    //   425: invokevirtual 148	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   428: ifnonnull +729 -> 1157
    //   431: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +41 -> 475
    //   437: ldc 44
    //   439: iconst_2
    //   440: new 46	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   447: ldc 150
    //   449: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: iload_2
    //   453: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: ldc 143
    //   458: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 7
    //   463: getfield 94	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   466: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload_0
    //   476: aload_0
    //   477: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   480: arraylength
    //   481: iload_2
    //   482: isub
    //   483: putfield 145	vog:jdField_a_of_type_Int	I
    //   486: bipush 11
    //   488: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: areturn
    //   492: ldc 152
    //   494: aload 8
    //   496: invokevirtual 90	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   499: ifeq +658 -> 1157
    //   502: goto +655 -> 1157
    //   505: invokestatic 157	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   508: ldc 159
    //   510: invokevirtual 163	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   513: ifne +23 -> 536
    //   516: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +11 -> 530
    //   522: ldc 44
    //   524: iconst_2
    //   525: ldc 165
    //   527: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   530: bipush 23
    //   532: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   535: areturn
    //   536: new 105	java/io/File
    //   539: dup
    //   540: getstatic 170	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   543: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   546: astore 9
    //   548: aload 9
    //   550: invokevirtual 111	java/io/File:exists	()Z
    //   553: ifne +629 -> 1182
    //   556: aload 9
    //   558: invokevirtual 173	java/io/File:mkdirs	()Z
    //   561: pop
    //   562: goto +620 -> 1182
    //   565: iload_2
    //   566: aload_0
    //   567: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   570: arraylength
    //   571: if_icmpge +537 -> 1108
    //   574: aload_0
    //   575: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   578: iload_2
    //   579: aaload
    //   580: astore 7
    //   582: aload_0
    //   583: getfield 19	vog:jdField_a_of_type_Boolean	Z
    //   586: ifne +8 -> 594
    //   589: iconst_1
    //   590: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   593: areturn
    //   594: ldc 81
    //   596: aload 7
    //   598: getfield 84	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   601: invokevirtual 90	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   604: ifeq +222 -> 826
    //   607: aload 7
    //   609: getfield 84	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   612: checkcast 81	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   615: astore 7
    //   617: aload_0
    //   618: iconst_1
    //   619: anewarray 66	java/lang/Integer
    //   622: dup
    //   623: iconst_0
    //   624: iload_3
    //   625: bipush 100
    //   627: imul
    //   628: aload_1
    //   629: arraylength
    //   630: idiv
    //   631: iload_2
    //   632: bipush 100
    //   634: imul
    //   635: aload_1
    //   636: arraylength
    //   637: idiv
    //   638: aload_0
    //   639: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   642: arraylength
    //   643: idiv
    //   644: iadd
    //   645: ldc 75
    //   647: iand
    //   648: iload 4
    //   650: bipush 16
    //   652: ishl
    //   653: ior
    //   654: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   657: aastore
    //   658: invokevirtual 79	vog:publishProgress	([Ljava/lang/Object;)V
    //   661: aload 7
    //   663: iconst_2
    //   664: invokevirtual 148	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   667: astore 7
    //   669: aload 7
    //   671: ifnull +516 -> 1187
    //   674: invokestatic 177	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   677: invokestatic 183	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   680: lstore 5
    //   682: aload 7
    //   684: invokevirtual 187	java/io/File:length	()J
    //   687: lload 5
    //   689: lcmp
    //   690: ifle +23 -> 713
    //   693: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq +11 -> 707
    //   699: ldc 44
    //   701: iconst_2
    //   702: ldc 189
    //   704: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: bipush 22
    //   709: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   712: areturn
    //   713: new 105	java/io/File
    //   716: dup
    //   717: aload 9
    //   719: new 46	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   726: aload 7
    //   728: invokevirtual 192	java/io/File:getName	()Ljava/lang/String;
    //   731: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: ldc 194
    //   736: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   745: astore 8
    //   747: aload 7
    //   749: aload 8
    //   751: invokestatic 202	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   754: ifne +54 -> 808
    //   757: invokestatic 157	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   760: ldc 159
    //   762: invokevirtual 163	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   765: ifne +23 -> 788
    //   768: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   771: ifeq +11 -> 782
    //   774: ldc 44
    //   776: iconst_2
    //   777: ldc 204
    //   779: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: bipush 24
    //   784: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   787: areturn
    //   788: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +11 -> 802
    //   794: ldc 44
    //   796: iconst_2
    //   797: ldc 206
    //   799: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   802: bipush 21
    //   804: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   807: areturn
    //   808: aload_0
    //   809: getfield 14	vog:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;
    //   812: invokestatic 209	com/tencent/mobileqq/activity/aio/photo/AIOImageListScene:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;)Landroid/app/Activity;
    //   815: aload 8
    //   817: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   820: invokestatic 217	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   823: goto +364 -> 1187
    //   826: ldc 219
    //   828: aload 7
    //   830: getfield 84	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   833: invokevirtual 90	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   836: ifeq +259 -> 1095
    //   839: aload 7
    //   841: getfield 84	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   844: checkcast 219	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   847: astore 10
    //   849: aload_0
    //   850: iconst_1
    //   851: anewarray 66	java/lang/Integer
    //   854: dup
    //   855: iconst_0
    //   856: iload_3
    //   857: bipush 100
    //   859: imul
    //   860: aload_1
    //   861: arraylength
    //   862: idiv
    //   863: iload_2
    //   864: bipush 100
    //   866: imul
    //   867: aload_1
    //   868: arraylength
    //   869: idiv
    //   870: aload_0
    //   871: getfield 30	vog:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   874: arraylength
    //   875: idiv
    //   876: iadd
    //   877: ldc 75
    //   879: iand
    //   880: iload 4
    //   882: bipush 16
    //   884: ishl
    //   885: ior
    //   886: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   889: aastore
    //   890: invokevirtual 79	vog:publishProgress	([Ljava/lang/Object;)V
    //   893: aload 10
    //   895: bipush 20
    //   897: invokevirtual 220	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   900: astore 8
    //   902: aload 8
    //   904: astore 7
    //   906: aload 8
    //   908: ifnonnull +227 -> 1135
    //   911: aload 10
    //   913: bipush 18
    //   915: invokevirtual 220	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   918: astore 8
    //   920: aload 8
    //   922: astore 7
    //   924: aload 8
    //   926: ifnonnull +209 -> 1135
    //   929: aload 10
    //   931: bipush 16
    //   933: invokevirtual 220	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   936: astore 7
    //   938: aload 7
    //   940: ifnull +247 -> 1187
    //   943: invokestatic 177	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   946: invokestatic 183	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   949: lstore 5
    //   951: aload 7
    //   953: invokevirtual 187	java/io/File:length	()J
    //   956: lload 5
    //   958: lcmp
    //   959: ifle +23 -> 982
    //   962: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq +11 -> 976
    //   968: ldc 44
    //   970: iconst_2
    //   971: ldc 189
    //   973: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: bipush 22
    //   978: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   981: areturn
    //   982: new 105	java/io/File
    //   985: dup
    //   986: aload 9
    //   988: new 46	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   995: aload 7
    //   997: invokevirtual 192	java/io/File:getName	()Ljava/lang/String;
    //   1000: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc 194
    //   1005: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1014: astore 8
    //   1016: aload 7
    //   1018: aload 8
    //   1020: invokestatic 202	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   1023: ifne +54 -> 1077
    //   1026: invokestatic 157	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   1029: ldc 159
    //   1031: invokevirtual 163	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1034: ifne +23 -> 1057
    //   1037: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1040: ifeq +11 -> 1051
    //   1043: ldc 44
    //   1045: iconst_2
    //   1046: ldc 204
    //   1048: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1051: bipush 24
    //   1053: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1056: areturn
    //   1057: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq +11 -> 1071
    //   1063: ldc 44
    //   1065: iconst_2
    //   1066: ldc 206
    //   1068: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1071: bipush 21
    //   1073: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1076: areturn
    //   1077: aload_0
    //   1078: getfield 14	vog:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;
    //   1081: invokestatic 222	com/tencent/mobileqq/activity/aio/photo/AIOImageListScene:b	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;)Landroid/app/Activity;
    //   1084: aload 8
    //   1086: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1089: invokestatic 217	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   1092: goto +95 -> 1187
    //   1095: ldc 152
    //   1097: aload 7
    //   1099: invokevirtual 90	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   1102: ifeq +85 -> 1187
    //   1105: goto +82 -> 1187
    //   1108: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1111: ifeq +83 -> 1194
    //   1114: ldc 44
    //   1116: iconst_2
    //   1117: ldc 224
    //   1119: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: goto +72 -> 1194
    //   1125: iload_2
    //   1126: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1129: areturn
    //   1130: astore 9
    //   1132: goto -806 -> 326
    //   1135: goto -192 -> 943
    //   1138: iconst_0
    //   1139: istore_3
    //   1140: iconst_0
    //   1141: istore_2
    //   1142: goto -1108 -> 34
    //   1145: iload_3
    //   1146: iconst_1
    //   1147: iadd
    //   1148: istore_3
    //   1149: goto -1115 -> 34
    //   1152: iconst_0
    //   1153: istore_2
    //   1154: goto -1034 -> 120
    //   1157: iload_2
    //   1158: iconst_1
    //   1159: iadd
    //   1160: istore_2
    //   1161: goto -1041 -> 120
    //   1164: iload 4
    //   1166: iconst_2
    //   1167: if_icmpne +9 -> 1176
    //   1170: bipush 30
    //   1172: istore_2
    //   1173: goto -28 -> 1145
    //   1176: bipush 10
    //   1178: istore_2
    //   1179: goto -34 -> 1145
    //   1182: iconst_0
    //   1183: istore_2
    //   1184: goto -619 -> 565
    //   1187: iload_2
    //   1188: iconst_1
    //   1189: iadd
    //   1190: istore_2
    //   1191: goto -626 -> 565
    //   1194: bipush 20
    //   1196: istore_2
    //   1197: goto -52 -> 1145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1200	0	this	vog
    //   0	1200	1	paramVarArgs	Integer[]
    //   120	1077	2	i	int
    //   34	1115	3	j	int
    //   46	1122	4	k	int
    //   680	277	5	l	long
    //   214	884	7	localObject1	java.lang.Object
    //   221	766	9	localObject3	java.lang.Object
    //   1130	1	9	localInterruptedException	java.lang.InterruptedException
    //   847	83	10	localAIOFilePicData	com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
    // Exception table:
    //   from	to	target	type
    //   309	326	398	finally
    //   326	329	398	finally
    //   399	402	398	finally
    //   0	31	404	java/lang/Throwable
    //   34	60	404	java/lang/Throwable
    //   60	90	404	java/lang/Throwable
    //   120	141	404	java/lang/Throwable
    //   141	233	404	java/lang/Throwable
    //   236	249	404	java/lang/Throwable
    //   254	269	404	java/lang/Throwable
    //   269	309	404	java/lang/Throwable
    //   329	381	404	java/lang/Throwable
    //   381	392	404	java/lang/Throwable
    //   402	404	404	java/lang/Throwable
    //   410	422	404	java/lang/Throwable
    //   422	475	404	java/lang/Throwable
    //   475	492	404	java/lang/Throwable
    //   492	502	404	java/lang/Throwable
    //   505	530	404	java/lang/Throwable
    //   530	536	404	java/lang/Throwable
    //   536	562	404	java/lang/Throwable
    //   565	594	404	java/lang/Throwable
    //   594	669	404	java/lang/Throwable
    //   674	707	404	java/lang/Throwable
    //   707	713	404	java/lang/Throwable
    //   713	782	404	java/lang/Throwable
    //   782	788	404	java/lang/Throwable
    //   788	802	404	java/lang/Throwable
    //   802	808	404	java/lang/Throwable
    //   808	823	404	java/lang/Throwable
    //   826	902	404	java/lang/Throwable
    //   911	920	404	java/lang/Throwable
    //   929	938	404	java/lang/Throwable
    //   943	976	404	java/lang/Throwable
    //   976	982	404	java/lang/Throwable
    //   982	1051	404	java/lang/Throwable
    //   1051	1057	404	java/lang/Throwable
    //   1057	1071	404	java/lang/Throwable
    //   1071	1077	404	java/lang/Throwable
    //   1077	1092	404	java/lang/Throwable
    //   1095	1105	404	java/lang/Throwable
    //   1108	1122	404	java/lang/Throwable
    //   309	326	1130	java/lang/InterruptedException
  }
  
  protected void a(Integer paramInteger)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.b(paramInteger.intValue(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_Vog = null;
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[(paramVarArgs.length - 1)].intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.c(i >> 16, 0xFFFF & i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vog
 * JD-Core Version:    0.7.0.1
 */