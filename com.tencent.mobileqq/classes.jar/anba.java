import android.graphics.BitmapFactory.Options;
import cooperation.qzone.util.ResDownloadManger;
import cooperation.qzone.util.ResDownloadManger.ResLoadListener;

public class anba
  implements Runnable
{
  public anba(ResDownloadManger paramResDownloadManger, int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener, BitmapFactory.Options paramOptions) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 38	cooperation/qzone/util/ResDownloadManger:a	()[Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 18	anba:jdField_a_of_type_Int	I
    //   11: aaload
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: getfield 20	anba:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokestatic 41	cooperation/qzone/util/ResDownloadManger:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 44	cooperation/qzone/util/ResDownloadManger:a	(Ljava/io/File;)Z
    //   28: ifeq +207 -> 235
    //   31: aload_0
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 16	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger	Lcooperation/qzone/util/ResDownloadManger;
    //   37: invokestatic 47	cooperation/qzone/util/ResDownloadManger:a	(Lcooperation/qzone/util/ResDownloadManger;)Landroid/support/v4/util/LruCache;
    //   40: new 49	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   47: aload_0
    //   48: getfield 18	anba:jdField_a_of_type_Int	I
    //   51: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc 56
    //   56: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 20	anba:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokevirtual 69	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 71	android/graphics/Bitmap
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +31 -> 108
    //   80: aload_0
    //   81: getfield 22	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger$ResLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   84: ifnull +21 -> 105
    //   87: aload_0
    //   88: getfield 22	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger$ResLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   91: aload_0
    //   92: getfield 18	anba:jdField_a_of_type_Int	I
    //   95: aload_0
    //   96: getfield 20	anba:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: aload_1
    //   100: invokeinterface 76 4 0
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: aload 4
    //   110: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 24	anba:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   117: invokestatic 84	cooperation/qzone/util/ResDownloadManger:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   120: astore_2
    //   121: aload_2
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: ifnull -19 -> 107
    //   129: aload_0
    //   130: getfield 16	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger	Lcooperation/qzone/util/ResDownloadManger;
    //   133: invokestatic 47	cooperation/qzone/util/ResDownloadManger:a	(Lcooperation/qzone/util/ResDownloadManger;)Landroid/support/v4/util/LruCache;
    //   136: new 49	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   143: aload_0
    //   144: getfield 18	anba:jdField_a_of_type_Int	I
    //   147: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: ldc 56
    //   152: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: getfield 20	anba:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: aload_1
    //   166: invokevirtual 88	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: pop
    //   170: aload_0
    //   171: getfield 22	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger$ResLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   174: ifnull -67 -> 107
    //   177: aload_0
    //   178: getfield 22	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger$ResLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   181: aload_0
    //   182: getfield 18	anba:jdField_a_of_type_Int	I
    //   185: aload_0
    //   186: getfield 20	anba:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   189: aload_1
    //   190: invokeinterface 76 4 0
    //   195: return
    //   196: astore_3
    //   197: aload_2
    //   198: astore_1
    //   199: aload_3
    //   200: astore_2
    //   201: ldc 90
    //   203: iconst_1
    //   204: aload_2
    //   205: invokevirtual 91	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   208: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: goto -88 -> 123
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: astore_2
    //   220: aload_3
    //   221: astore_1
    //   222: ldc 90
    //   224: iconst_1
    //   225: aload_2
    //   226: invokevirtual 98	java/lang/Exception:toString	()Ljava/lang/String;
    //   229: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: goto -109 -> 123
    //   235: aload_0
    //   236: getfield 16	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger	Lcooperation/qzone/util/ResDownloadManger;
    //   239: aload_1
    //   240: aload_0
    //   241: getfield 18	anba:jdField_a_of_type_Int	I
    //   244: aload_0
    //   245: getfield 20	anba:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   248: aload_0
    //   249: getfield 22	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger$ResLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   252: invokestatic 101	cooperation/qzone/util/ResDownloadManger:a	(Lcooperation/qzone/util/ResDownloadManger;Ljava/lang/String;ILjava/lang/String;Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;)Lcooperation/qzone/util/ResEntry;
    //   255: astore_2
    //   256: aload_0
    //   257: getfield 16	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger	Lcooperation/qzone/util/ResDownloadManger;
    //   260: aload_1
    //   261: aload_2
    //   262: invokestatic 104	cooperation/qzone/util/ResDownloadManger:a	(Lcooperation/qzone/util/ResDownloadManger;Ljava/lang/String;Lcooperation/qzone/util/ResEntry;)Z
    //   265: ifeq -158 -> 107
    //   268: aload_0
    //   269: getfield 16	anba:jdField_a_of_type_CooperationQzoneUtilResDownloadManger	Lcooperation/qzone/util/ResDownloadManger;
    //   272: aload_2
    //   273: invokestatic 107	cooperation/qzone/util/ResDownloadManger:a	(Lcooperation/qzone/util/ResDownloadManger;Lcooperation/qzone/util/ResEntry;)V
    //   276: return
    //   277: astore_2
    //   278: goto -56 -> 222
    //   281: astore_2
    //   282: goto -81 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	anba
    //   12	187	1	localObject1	Object
    //   214	4	1	localObject2	Object
    //   221	40	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   3	202	2	localObject3	Object
    //   219	7	2	localException1	java.lang.Exception
    //   255	18	2	localResEntry	cooperation.qzone.util.ResEntry
    //   277	1	2	localException2	java.lang.Exception
    //   281	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	1	3	localObject4	Object
    //   196	25	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   21	88	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   33	76	196	java/lang/OutOfMemoryError
    //   33	76	214	finally
    //   80	105	214	finally
    //   105	107	214	finally
    //   108	121	214	finally
    //   123	125	214	finally
    //   201	211	214	finally
    //   215	217	214	finally
    //   222	232	214	finally
    //   33	76	219	java/lang/Exception
    //   80	105	277	java/lang/Exception
    //   108	121	277	java/lang/Exception
    //   80	105	281	java/lang/OutOfMemoryError
    //   108	121	281	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anba
 * JD-Core Version:    0.7.0.1
 */