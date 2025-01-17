package com.tencent.open.agent.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.adapter.CommonDataAdapter;

public class ReportDatabaseHelper
  extends SQLiteOpenHelper
{
  protected static ReportDatabaseHelper a;
  protected static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "key" };
  }
  
  public ReportDatabaseHelper(Context paramContext)
  {
    super(paramContext, "agent_report.db", null, 2);
  }
  
  public static ReportDatabaseHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper == null) {
        jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper = new ReportDatabaseHelper(CommonDataAdapter.a().a());
      }
      ReportDatabaseHelper localReportDatabaseHelper = jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper;
      return localReportDatabaseHelper;
    }
    finally {}
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: invokevirtual 47	com/tencent/open/agent/report/ReportDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 5
    //   23: aload 5
    //   25: ifnonnull +8 -> 33
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -17 -> 13
    //   33: aload 5
    //   35: ldc 49
    //   37: getstatic 15	com/tencent/open/agent/report/ReportDatabaseHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   40: ldc 51
    //   42: iconst_1
    //   43: anewarray 11	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 57	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore 4
    //   58: aload 4
    //   60: ifnull +69 -> 129
    //   63: aload 4
    //   65: invokeinterface 63 1 0
    //   70: istore_2
    //   71: aload 4
    //   73: ifnull +10 -> 83
    //   76: aload 4
    //   78: invokeinterface 66 1 0
    //   83: aload 5
    //   85: ifnull +49 -> 134
    //   88: aload 5
    //   90: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   93: goto +41 -> 134
    //   96: aload 4
    //   98: ifnull +10 -> 108
    //   101: aload 4
    //   103: invokeinterface 66 1 0
    //   108: aload 5
    //   110: ifnull +8 -> 118
    //   113: aload 5
    //   115: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: goto -30 -> 96
    //   129: iconst_0
    //   130: istore_2
    //   131: goto -60 -> 71
    //   134: goto -121 -> 13
    //   137: astore_1
    //   138: aconst_null
    //   139: astore 4
    //   141: goto -45 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	ReportDatabaseHelper
    //   0	144	1	paramString	String
    //   12	119	2	i	int
    //   6	2	3	bool	boolean
    //   56	84	4	localCursor	android.database.Cursor
    //   21	93	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	7	120	finally
    //   17	23	120	finally
    //   76	83	120	finally
    //   88	93	120	finally
    //   101	108	120	finally
    //   113	118	120	finally
    //   118	120	120	finally
    //   63	71	125	finally
    //   33	58	137	finally
  }
  
  /* Error */
  public java.util.List a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 72	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 74	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: invokevirtual 77	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 5
    //   17: aload 5
    //   19: ldc 79
    //   21: aconst_null
    //   22: invokevirtual 83	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +56 -> 83
    //   30: aload_2
    //   31: invokeinterface 87 1 0
    //   36: ifeq +47 -> 83
    //   39: aload_2
    //   40: aload_2
    //   41: ldc 89
    //   43: invokeinterface 92 2 0
    //   48: invokeinterface 96 2 0
    //   53: astore_3
    //   54: aload 4
    //   56: aload_3
    //   57: invokestatic 102	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   60: invokevirtual 105	java/lang/Integer:intValue	()I
    //   63: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: invokeinterface 114 2 0
    //   71: pop
    //   72: aload_2
    //   73: invokeinterface 117 1 0
    //   78: istore_1
    //   79: iload_1
    //   80: ifne -41 -> 39
    //   83: aload 5
    //   85: ifnull +8 -> 93
    //   88: aload 5
    //   90: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   93: aload 4
    //   95: astore_3
    //   96: aload_2
    //   97: ifnull +12 -> 109
    //   100: aload_2
    //   101: invokeinterface 66 1 0
    //   106: aload 4
    //   108: astore_3
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_3
    //   112: areturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_2
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   126: aload_2
    //   127: ifnull +51 -> 178
    //   130: aload_2
    //   131: invokeinterface 66 1 0
    //   136: goto +42 -> 178
    //   139: aload 5
    //   141: ifnull +8 -> 149
    //   144: aload 5
    //   146: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   149: aload_2
    //   150: ifnull +9 -> 159
    //   153: aload_2
    //   154: invokeinterface 66 1 0
    //   159: aload_3
    //   160: athrow
    //   161: astore_2
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_2
    //   165: athrow
    //   166: astore_3
    //   167: goto -28 -> 139
    //   170: astore_3
    //   171: goto -55 -> 116
    //   174: astore_3
    //   175: goto -103 -> 72
    //   178: aconst_null
    //   179: astore_3
    //   180: goto -71 -> 109
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_2
    //   186: goto -47 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	ReportDatabaseHelper
    //   78	2	1	bool	boolean
    //   25	76	2	localCursor	android.database.Cursor
    //   113	1	2	localException1	java.lang.Exception
    //   115	39	2	localObject1	Object
    //   161	4	2	localObject2	Object
    //   185	1	2	localObject3	Object
    //   53	107	3	localObject4	Object
    //   166	1	3	localObject5	Object
    //   170	1	3	localException2	java.lang.Exception
    //   174	1	3	localException3	java.lang.Exception
    //   179	1	3	localObject6	Object
    //   183	1	3	localObject7	Object
    //   9	98	4	localArrayList	java.util.ArrayList
    //   15	130	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   17	26	113	java/lang/Exception
    //   2	17	161	finally
    //   88	93	161	finally
    //   100	106	161	finally
    //   121	126	161	finally
    //   130	136	161	finally
    //   144	149	161	finally
    //   153	159	161	finally
    //   159	161	161	finally
    //   30	39	166	finally
    //   39	54	166	finally
    //   54	72	166	finally
    //   72	79	166	finally
    //   30	39	170	java/lang/Exception
    //   39	54	170	java/lang/Exception
    //   72	79	170	java/lang/Exception
    //   54	72	174	java/lang/Exception
    //   17	26	183	finally
  }
  
  /* Error */
  public java.util.List a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 72	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 74	java/util/ArrayList:<init>	()V
    //   9: astore 6
    //   11: aload_1
    //   12: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +8 -> 25
    //   20: aload_0
    //   21: monitorexit
    //   22: aload 6
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 47	com/tencent/open/agent/report/ReportDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 5
    //   31: aload 5
    //   33: ifnonnull +6 -> 39
    //   36: goto -16 -> 20
    //   39: aload 5
    //   41: ldc 49
    //   43: aconst_null
    //   44: ldc 51
    //   46: iconst_1
    //   47: anewarray 11	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: invokevirtual 57	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +104 -> 168
    //   67: aload 4
    //   69: invokeinterface 63 1 0
    //   74: ifle +94 -> 168
    //   77: aload 4
    //   79: invokeinterface 87 1 0
    //   84: pop
    //   85: new 122	java/io/ByteArrayInputStream
    //   88: dup
    //   89: aload 4
    //   91: aload 4
    //   93: ldc 124
    //   95: invokeinterface 92 2 0
    //   100: invokeinterface 128 2 0
    //   105: invokespecial 131	java/io/ByteArrayInputStream:<init>	([B)V
    //   108: astore 7
    //   110: new 133	java/io/ObjectInputStream
    //   113: dup
    //   114: aload 7
    //   116: invokespecial 136	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 140	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   124: checkcast 142	java/io/Serializable
    //   127: astore_3
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 143	java/io/ObjectInputStream:close	()V
    //   136: aload 7
    //   138: invokevirtual 144	java/io/ByteArrayInputStream:close	()V
    //   141: aload_3
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +12 -> 156
    //   147: aload 6
    //   149: aload_1
    //   150: invokeinterface 114 2 0
    //   155: pop
    //   156: aload 4
    //   158: invokeinterface 117 1 0
    //   163: istore_2
    //   164: iload_2
    //   165: ifne -80 -> 85
    //   168: aload 4
    //   170: ifnull +10 -> 180
    //   173: aload 4
    //   175: invokeinterface 66 1 0
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   190: iconst_0
    //   191: ifeq +11 -> 202
    //   194: new 146	java/lang/NullPointerException
    //   197: dup
    //   198: invokespecial 147	java/lang/NullPointerException:<init>	()V
    //   201: athrow
    //   202: goto -182 -> 20
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 143	java/io/ObjectInputStream:close	()V
    //   216: aload 7
    //   218: invokevirtual 144	java/io/ByteArrayInputStream:close	()V
    //   221: aconst_null
    //   222: astore_1
    //   223: goto -80 -> 143
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_1
    //   229: goto -86 -> 143
    //   232: astore_3
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 143	java/io/ObjectInputStream:close	()V
    //   243: aload 7
    //   245: invokevirtual 144	java/io/ByteArrayInputStream:close	()V
    //   248: aload_3
    //   249: athrow
    //   250: astore_1
    //   251: aload 4
    //   253: astore_3
    //   254: aload_3
    //   255: ifnull +9 -> 264
    //   258: aload_3
    //   259: invokeinterface 66 1 0
    //   264: aload 5
    //   266: ifnull +8 -> 274
    //   269: aload 5
    //   271: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   274: iconst_0
    //   275: ifeq +11 -> 286
    //   278: new 146	java/lang/NullPointerException
    //   281: dup
    //   282: invokespecial 147	java/lang/NullPointerException:<init>	()V
    //   285: athrow
    //   286: aload_1
    //   287: athrow
    //   288: astore_1
    //   289: aload_0
    //   290: monitorexit
    //   291: aload_1
    //   292: athrow
    //   293: astore_1
    //   294: aload_1
    //   295: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   298: goto -96 -> 202
    //   301: astore_3
    //   302: aload_3
    //   303: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   306: goto -20 -> 286
    //   309: astore_1
    //   310: goto -174 -> 136
    //   313: astore_1
    //   314: aload_3
    //   315: astore_1
    //   316: goto -173 -> 143
    //   319: astore_1
    //   320: goto -104 -> 216
    //   323: astore_1
    //   324: goto -81 -> 243
    //   327: astore_1
    //   328: goto -80 -> 248
    //   331: astore_1
    //   332: aconst_null
    //   333: astore_3
    //   334: goto -80 -> 254
    //   337: astore_3
    //   338: goto -103 -> 235
    //   341: astore_3
    //   342: goto -134 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	ReportDatabaseHelper
    //   0	345	1	paramString	String
    //   15	150	2	bool	boolean
    //   127	15	3	localSerializable	java.io.Serializable
    //   232	17	3	localObject1	Object
    //   253	6	3	localCursor1	android.database.Cursor
    //   301	14	3	localIOException	java.io.IOException
    //   333	1	3	localObject2	Object
    //   337	1	3	localObject3	Object
    //   341	1	3	localException	java.lang.Exception
    //   60	192	4	localCursor2	android.database.Cursor
    //   29	241	5	localSQLiteDatabase	SQLiteDatabase
    //   9	139	6	localArrayList	java.util.ArrayList
    //   108	136	7	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   110	120	205	java/lang/Exception
    //   216	221	226	java/io/IOException
    //   110	120	232	finally
    //   67	85	250	finally
    //   85	110	250	finally
    //   132	136	250	finally
    //   136	141	250	finally
    //   147	156	250	finally
    //   156	164	250	finally
    //   212	216	250	finally
    //   216	221	250	finally
    //   239	243	250	finally
    //   243	248	250	finally
    //   248	250	250	finally
    //   2	16	288	finally
    //   25	31	288	finally
    //   173	180	288	finally
    //   185	190	288	finally
    //   194	202	288	finally
    //   258	264	288	finally
    //   269	274	288	finally
    //   278	286	288	finally
    //   286	288	288	finally
    //   294	298	288	finally
    //   302	306	288	finally
    //   194	202	293	java/io/IOException
    //   278	286	301	java/io/IOException
    //   132	136	309	java/io/IOException
    //   136	141	313	java/io/IOException
    //   212	216	319	java/io/IOException
    //   239	243	323	java/io/IOException
    //   243	248	327	java/io/IOException
    //   39	62	331	finally
    //   120	128	337	finally
    //   120	128	341	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 77	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull -9 -> 11
    //   23: aload_3
    //   24: ldc 49
    //   26: ldc 51
    //   28: iconst_1
    //   29: anewarray 11	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: invokevirtual 155	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   39: pop
    //   40: aload_3
    //   41: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   44: goto -33 -> 11
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ReportDatabaseHelper
    //   0	52	1	paramString	String
    //   6	2	2	bool	boolean
    //   18	23	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	19	47	finally
    //   23	44	47	finally
  }
  
  /* Error */
  public void a(String paramString, java.util.List paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokeinterface 159 1 0
    //   11: istore_3
    //   12: aload_1
    //   13: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: istore 5
    //   18: iload 5
    //   20: ifne +7 -> 27
    //   23: iload_3
    //   24: ifne +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: iload_3
    //   31: bipush 20
    //   33: if_icmpgt +150 -> 183
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 161	com/tencent/open/agent/report/ReportDatabaseHelper:a	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: invokevirtual 77	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore 8
    //   47: aload 8
    //   49: ifnull -22 -> 27
    //   52: aload 8
    //   54: invokevirtual 164	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   57: new 166	android/content/ContentValues
    //   60: dup
    //   61: invokespecial 167	android/content/ContentValues:<init>	()V
    //   64: astore 10
    //   66: iconst_0
    //   67: istore 4
    //   69: iload 4
    //   71: iload_3
    //   72: if_icmpge +182 -> 254
    //   75: aload_2
    //   76: iload 4
    //   78: invokeinterface 171 2 0
    //   83: checkcast 142	java/io/Serializable
    //   86: astore 11
    //   88: aload 11
    //   90: ifnull +79 -> 169
    //   93: aload 10
    //   95: ldc 89
    //   97: aload_1
    //   98: invokevirtual 175	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: new 177	java/io/ByteArrayOutputStream
    //   104: dup
    //   105: sipush 512
    //   108: invokespecial 180	java/io/ByteArrayOutputStream:<init>	(I)V
    //   111: astore 9
    //   113: new 182	java/io/ObjectOutputStream
    //   116: dup
    //   117: aload 9
    //   119: invokespecial 185	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   122: astore 6
    //   124: aload 6
    //   126: aload 11
    //   128: invokevirtual 189	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   131: aload 6
    //   133: ifnull +8 -> 141
    //   136: aload 6
    //   138: invokevirtual 190	java/io/ObjectOutputStream:close	()V
    //   141: aload 9
    //   143: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   146: aload 10
    //   148: ldc 124
    //   150: aload 9
    //   152: invokevirtual 195	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   155: invokevirtual 198	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   158: aload 8
    //   160: ldc 49
    //   162: aconst_null
    //   163: aload 10
    //   165: invokevirtual 202	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   168: pop2
    //   169: aload 10
    //   171: invokevirtual 205	android/content/ContentValues:clear	()V
    //   174: iload 4
    //   176: iconst_1
    //   177: iadd
    //   178: istore 4
    //   180: goto -111 -> 69
    //   183: bipush 20
    //   185: istore_3
    //   186: goto -150 -> 36
    //   189: astore 6
    //   191: aconst_null
    //   192: astore 6
    //   194: aload 6
    //   196: ifnull +8 -> 204
    //   199: aload 6
    //   201: invokevirtual 190	java/io/ObjectOutputStream:close	()V
    //   204: aload 9
    //   206: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   209: goto -63 -> 146
    //   212: astore 6
    //   214: goto -68 -> 146
    //   217: astore_1
    //   218: aload 7
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 190	java/io/ObjectOutputStream:close	()V
    //   229: aload 9
    //   231: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   234: aload_1
    //   235: athrow
    //   236: astore_1
    //   237: aload 8
    //   239: invokevirtual 208	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   242: aload 8
    //   244: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: aload_0
    //   251: monitorexit
    //   252: aload_1
    //   253: athrow
    //   254: aload 8
    //   256: invokevirtual 211	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   259: aload 8
    //   261: invokevirtual 208	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   264: aload 8
    //   266: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   269: goto -242 -> 27
    //   272: astore 6
    //   274: goto -133 -> 141
    //   277: astore 6
    //   279: goto -133 -> 146
    //   282: astore 6
    //   284: goto -80 -> 204
    //   287: astore_2
    //   288: goto -59 -> 229
    //   291: astore_2
    //   292: goto -58 -> 234
    //   295: astore_1
    //   296: aload 6
    //   298: astore_2
    //   299: goto -78 -> 221
    //   302: astore 11
    //   304: goto -110 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	ReportDatabaseHelper
    //   0	307	1	paramString	String
    //   0	307	2	paramList	java.util.List
    //   11	175	3	i	int
    //   67	112	4	j	int
    //   16	3	5	bool	boolean
    //   122	15	6	localObjectOutputStream	java.io.ObjectOutputStream
    //   189	1	6	localIOException1	java.io.IOException
    //   192	8	6	localObject1	Object
    //   212	1	6	localIOException2	java.io.IOException
    //   272	1	6	localIOException3	java.io.IOException
    //   277	1	6	localIOException4	java.io.IOException
    //   282	15	6	localIOException5	java.io.IOException
    //   1	218	7	localObject2	Object
    //   45	220	8	localSQLiteDatabase	SQLiteDatabase
    //   111	119	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   64	106	10	localContentValues	android.content.ContentValues
    //   86	41	11	localSerializable	java.io.Serializable
    //   302	1	11	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   113	124	189	java/io/IOException
    //   204	209	212	java/io/IOException
    //   113	124	217	finally
    //   57	66	236	finally
    //   75	88	236	finally
    //   93	113	236	finally
    //   136	141	236	finally
    //   141	146	236	finally
    //   146	169	236	finally
    //   169	174	236	finally
    //   199	204	236	finally
    //   204	209	236	finally
    //   225	229	236	finally
    //   229	234	236	finally
    //   234	236	236	finally
    //   254	259	236	finally
    //   5	18	249	finally
    //   36	47	249	finally
    //   52	57	249	finally
    //   237	249	249	finally
    //   259	269	249	finally
    //   136	141	272	java/io/IOException
    //   141	146	277	java/io/IOException
    //   199	204	282	java/io/IOException
    //   225	229	287	java/io/IOException
    //   229	234	291	java/io/IOException
    //   124	131	295	finally
    //   124	131	302	java/io/IOException
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */