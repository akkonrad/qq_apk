import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;

public class airh
  implements Runnable
{
  public airh(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   4: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   7: getfield 32	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   10: astore_2
    //   11: aload_2
    //   12: ldc 34
    //   14: invokevirtual 40	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   17: astore_3
    //   18: iconst_4
    //   19: aload_3
    //   20: arraylength
    //   21: if_icmpeq +44 -> 65
    //   24: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +28 -> 55
    //   30: ldc 48
    //   32: iconst_2
    //   33: new 50	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   40: ldc 53
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_2
    //   46: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: new 67	java/lang/IllegalArgumentException
    //   58: dup
    //   59: ldc 69
    //   61: invokespecial 72	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   64: athrow
    //   65: aload_0
    //   66: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   69: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   72: aload_3
    //   73: iconst_0
    //   74: aaload
    //   75: putfield 32	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   82: aload_3
    //   83: iconst_1
    //   84: aaload
    //   85: putfield 74	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   92: aload_3
    //   93: iconst_2
    //   94: aaload
    //   95: invokestatic 80	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   98: putfield 84	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_Int	I
    //   101: aload_0
    //   102: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   105: aload_3
    //   106: iconst_3
    //   107: aaload
    //   108: invokestatic 90	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   111: putfield 94	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   114: aload_0
    //   115: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   118: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   121: aload_0
    //   122: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   125: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   128: getfield 97	com/tencent/mobileqq/transfile/TransferRequest:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   131: checkcast 99	com/tencent/mobileqq/data/MessageForShortVideo
    //   134: checkcast 99	com/tencent/mobileqq/data/MessageForShortVideo
    //   137: getfield 102	com/tencent/mobileqq/data/MessageForShortVideo:mLocalMd5	Ljava/lang/String;
    //   140: putfield 105	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   143: aload_0
    //   144: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   147: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   150: getfield 105	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   153: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +60 -> 216
    //   159: aload_0
    //   160: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   163: aload_0
    //   164: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   167: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   170: getfield 105	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   173: invokestatic 90	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   176: putfield 113	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   179: aload_0
    //   180: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   183: astore_2
    //   184: aload_0
    //   185: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   188: getfield 116	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   191: astore_3
    //   192: aload_0
    //   193: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   196: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   199: getfield 105	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   202: astore 4
    //   204: aload_3
    //   205: aload 4
    //   207: putfield 119	com/tencent/mobileqq/transfile/FileMsg:f	Ljava/lang/String;
    //   210: aload_2
    //   211: aload 4
    //   213: putfield 121	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   216: aload_0
    //   217: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   220: getfield 113	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   223: ifnonnull +21 -> 244
    //   226: aload_0
    //   227: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   230: invokevirtual 124	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:e	()Z
    //   233: ifne +11 -> 244
    //   236: aload_0
    //   237: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   240: invokevirtual 126	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   243: return
    //   244: aload_0
    //   245: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   248: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   251: getfield 32	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   254: invokestatic 131	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   257: ifne +23 -> 280
    //   260: aload_0
    //   261: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   264: sipush 9042
    //   267: ldc 133
    //   269: invokevirtual 136	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   272: aload_0
    //   273: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   276: invokevirtual 126	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   279: return
    //   280: aload_0
    //   281: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   284: getfield 139	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   287: ifnonnull +75 -> 362
    //   290: aload_0
    //   291: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   294: new 141	java/io/RandomAccessFile
    //   297: dup
    //   298: aload_0
    //   299: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   302: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   305: getfield 32	com/tencent/mobileqq/transfile/TransferRequest:i	Ljava/lang/String;
    //   308: ldc 143
    //   310: invokespecial 146	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: putfield 139	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   316: aload_0
    //   317: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   320: getfield 139	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   323: ifnonnull +39 -> 362
    //   326: aload_0
    //   327: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   330: sipush 9303
    //   333: ldc 148
    //   335: invokevirtual 136	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   338: aload_0
    //   339: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   342: invokevirtual 126	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   345: return
    //   346: astore_2
    //   347: aload_2
    //   348: invokevirtual 151	java/io/FileNotFoundException:printStackTrace	()V
    //   351: aload_0
    //   352: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   355: aconst_null
    //   356: putfield 139	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   359: goto -43 -> 316
    //   362: aload_0
    //   363: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   366: getfield 94	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   369: ifnonnull +113 -> 482
    //   372: new 153	java/io/FileInputStream
    //   375: dup
    //   376: aload_0
    //   377: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   380: getfield 74	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   386: astore_3
    //   387: aload_3
    //   388: astore_2
    //   389: aload_0
    //   390: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   393: aload_3
    //   394: lconst_0
    //   395: invokestatic 160	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   398: putfield 94	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   401: aload_3
    //   402: astore_2
    //   403: aload_0
    //   404: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   407: getfield 94	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   410: ifnonnull +64 -> 474
    //   413: aload_3
    //   414: astore_2
    //   415: aload_0
    //   416: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   419: sipush 9041
    //   422: new 50	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   429: ldc 162
    //   431: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   438: getfield 74	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   441: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokevirtual 136	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   450: aload_3
    //   451: astore_2
    //   452: aload_0
    //   453: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   456: invokevirtual 126	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   459: aload_3
    //   460: ifnull -217 -> 243
    //   463: aload_3
    //   464: invokevirtual 165	java/io/FileInputStream:close	()V
    //   467: return
    //   468: astore_2
    //   469: aload_2
    //   470: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   473: return
    //   474: aload_3
    //   475: ifnull +7 -> 482
    //   478: aload_3
    //   479: invokevirtual 165	java/io/FileInputStream:close	()V
    //   482: aload_0
    //   483: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   486: getfield 168	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   489: ifnonnull +150 -> 639
    //   492: aload_0
    //   493: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   496: new 141	java/io/RandomAccessFile
    //   499: dup
    //   500: aload_0
    //   501: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   504: getfield 74	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   507: ldc 143
    //   509: invokespecial 146	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: putfield 168	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   515: aload_0
    //   516: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   519: getfield 168	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   522: ifnonnull +117 -> 639
    //   525: aload_0
    //   526: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   529: sipush 9303
    //   532: ldc 170
    //   534: invokevirtual 136	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   537: aload_0
    //   538: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   541: invokevirtual 126	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   544: return
    //   545: astore_2
    //   546: aload_2
    //   547: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   550: goto -68 -> 482
    //   553: astore 4
    //   555: aconst_null
    //   556: astore_3
    //   557: aload_3
    //   558: astore_2
    //   559: aload_0
    //   560: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   563: aconst_null
    //   564: putfield 94	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   567: aload_3
    //   568: astore_2
    //   569: aload_0
    //   570: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   573: aload 4
    //   575: invokevirtual 173	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/io/IOException;)V
    //   578: aload_3
    //   579: astore_2
    //   580: aload_0
    //   581: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   584: invokevirtual 126	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   587: aload_3
    //   588: ifnull -345 -> 243
    //   591: aload_3
    //   592: invokevirtual 165	java/io/FileInputStream:close	()V
    //   595: return
    //   596: astore_2
    //   597: aload_2
    //   598: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   601: return
    //   602: astore_3
    //   603: aconst_null
    //   604: astore_2
    //   605: aload_2
    //   606: ifnull +7 -> 613
    //   609: aload_2
    //   610: invokevirtual 165	java/io/FileInputStream:close	()V
    //   613: aload_3
    //   614: athrow
    //   615: astore_2
    //   616: aload_2
    //   617: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   620: goto -7 -> 613
    //   623: astore_2
    //   624: aload_2
    //   625: invokevirtual 151	java/io/FileNotFoundException:printStackTrace	()V
    //   628: aload_0
    //   629: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   632: aconst_null
    //   633: putfield 168	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   636: goto -121 -> 515
    //   639: new 175	java/io/File
    //   642: dup
    //   643: aload_0
    //   644: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   647: getfield 74	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   650: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   653: astore_2
    //   654: aload_0
    //   655: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   658: aload_2
    //   659: invokevirtual 180	java/io/File:length	()J
    //   662: putfield 183	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Long	J
    //   665: aload_0
    //   666: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   669: aload_0
    //   670: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   673: getfield 74	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   676: invokevirtual 185	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Ljava/lang/String;)V
    //   679: aload_0
    //   680: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   683: invokestatic 188	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   686: ifnull +35 -> 721
    //   689: aload_0
    //   690: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   693: invokestatic 188	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   696: arraylength
    //   697: ifeq +24 -> 721
    //   700: aload_0
    //   701: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   704: invokestatic 190	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   707: ifnull +14 -> 721
    //   710: aload_0
    //   711: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   714: invokestatic 190	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   717: arraylength
    //   718: ifne +163 -> 881
    //   721: ldc 192
    //   723: monitorenter
    //   724: aload_0
    //   725: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   728: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   731: getfield 194	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   734: invokestatic 198	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   737: invokevirtual 202	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   740: ifnull +61 -> 801
    //   743: aload_0
    //   744: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   747: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   750: getfield 194	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   753: invokestatic 198	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   756: invokevirtual 202	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   759: arraylength
    //   760: istore_1
    //   761: aload_0
    //   762: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   765: iload_1
    //   766: newarray byte
    //   768: invokestatic 205	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;[B)[B
    //   771: pop
    //   772: aload_0
    //   773: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   776: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   779: getfield 194	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   782: invokestatic 198	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   785: invokevirtual 202	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   788: iconst_0
    //   789: aload_0
    //   790: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   793: invokestatic 188	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   796: iconst_0
    //   797: iload_1
    //   798: invokestatic 211	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   801: aload_0
    //   802: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   805: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   808: getfield 194	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   811: invokestatic 198	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   814: invokevirtual 214	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   817: ifnull +61 -> 878
    //   820: aload_0
    //   821: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   824: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   827: getfield 194	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   830: invokestatic 198	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   833: invokevirtual 214	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   836: arraylength
    //   837: istore_1
    //   838: aload_0
    //   839: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   842: iload_1
    //   843: newarray byte
    //   845: invokestatic 216	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;[B)[B
    //   848: pop
    //   849: aload_0
    //   850: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   853: getfield 26	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   856: getfield 194	com/tencent/mobileqq/transfile/TransferRequest:b	Ljava/lang/String;
    //   859: invokestatic 198	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   862: invokevirtual 214	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   865: iconst_0
    //   866: aload_0
    //   867: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   870: invokestatic 190	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   873: iconst_0
    //   874: iload_1
    //   875: invokestatic 211	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   878: ldc 192
    //   880: monitorexit
    //   881: aload_0
    //   882: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   885: invokestatic 188	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   888: ifnull +35 -> 923
    //   891: aload_0
    //   892: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   895: invokestatic 188	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   898: arraylength
    //   899: ifeq +24 -> 923
    //   902: aload_0
    //   903: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   906: invokestatic 190	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   909: ifnull +14 -> 923
    //   912: aload_0
    //   913: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   916: invokestatic 190	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   919: arraylength
    //   920: ifne +26 -> 946
    //   923: aload_0
    //   924: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   927: iconst_1
    //   928: invokestatic 219	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;I)I
    //   931: pop
    //   932: aload_0
    //   933: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   936: invokevirtual 222	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:q	()V
    //   939: return
    //   940: astore_2
    //   941: ldc 192
    //   943: monitorexit
    //   944: aload_2
    //   945: athrow
    //   946: aload_0
    //   947: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   950: aload_0
    //   951: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   954: invokestatic 188	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   957: aload_0
    //   958: getfield 12	airh:a	Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;
    //   961: invokestatic 190	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)[B
    //   964: invokevirtual 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	([B[B)V
    //   967: return
    //   968: astore_3
    //   969: goto -364 -> 605
    //   972: astore 4
    //   974: goto -417 -> 557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	977	0	this	airh
    //   760	115	1	i	int
    //   10	201	2	localObject1	Object
    //   346	2	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   388	64	2	localObject2	Object
    //   468	2	2	localIOException1	java.io.IOException
    //   545	2	2	localIOException2	java.io.IOException
    //   558	22	2	localObject3	Object
    //   596	2	2	localIOException3	java.io.IOException
    //   604	6	2	localObject4	Object
    //   615	2	2	localIOException4	java.io.IOException
    //   623	2	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   653	6	2	localFile	java.io.File
    //   940	5	2	localObject5	Object
    //   17	575	3	localObject6	Object
    //   602	12	3	localObject7	Object
    //   968	1	3	localObject8	Object
    //   202	10	4	str	java.lang.String
    //   553	21	4	localIOException5	java.io.IOException
    //   972	1	4	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   290	316	346	java/io/FileNotFoundException
    //   463	467	468	java/io/IOException
    //   478	482	545	java/io/IOException
    //   372	387	553	java/io/IOException
    //   591	595	596	java/io/IOException
    //   372	387	602	finally
    //   609	613	615	java/io/IOException
    //   492	515	623	java/io/FileNotFoundException
    //   724	801	940	finally
    //   801	878	940	finally
    //   878	881	940	finally
    //   941	944	940	finally
    //   389	401	968	finally
    //   403	413	968	finally
    //   415	450	968	finally
    //   452	459	968	finally
    //   559	567	968	finally
    //   569	578	968	finally
    //   580	587	968	finally
    //   389	401	972	java/io/IOException
    //   403	413	972	java/io/IOException
    //   415	450	972	java/io/IOException
    //   452	459	972	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airh
 * JD-Core Version:    0.7.0.1
 */