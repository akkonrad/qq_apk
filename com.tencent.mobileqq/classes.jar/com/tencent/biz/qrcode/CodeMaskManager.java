package com.tencent.biz.qrcode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import osf;
import osh;
import osi;

public class CodeMaskManager
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath() + "/qbiz/qrcode/";
  protected int a;
  public Activity a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  public Thread a;
  protected List a;
  public boolean a;
  protected int b;
  protected List b;
  
  static
  {
    if (SystemUtil.a())
    {
      jdField_a_of_type_JavaLangString = AppConstants.aJ + "qbiz/qrcode/";
      return;
    }
  }
  
  public CodeMaskManager(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaUtilList = new Vector();
    a(paramInt);
    this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
    b(a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getString("tpl_json", null);
      if (localObject == null) {
        return 0;
      }
      localObject = new JSONObject((String)localObject);
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("tpls");
      if (localJSONArray.length() > 0)
      {
        a(localJSONArray);
        int i = ((JSONObject)localObject).getInt("t");
        return i;
      }
    }
    catch (JSONException localJSONException) {}
    return 0;
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    if (paramInt < 1) {
      throw new IllegalArgumentException("qrcode mask build-in list should have at least 1 item");
    }
    if (paramInt == 1) {
      paramInt = i;
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      return this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Int == -1)
      {
        int j = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getInt("lastIndex", 0);
        if (j >= 0)
        {
          i = j;
          if (j < paramInt) {}
        }
        else
        {
          i = 0;
        }
        paramInt = i;
      }
      else
      {
        i = (int)(Math.random() * (paramInt - 1));
        paramInt = i;
        if (i >= this.jdField_a_of_type_Int) {
          paramInt = i + 1;
        }
      }
    }
  }
  
  /* Error */
  private Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ifnull +12 -> 16
    //   7: aload_1
    //   8: ldc 161
    //   10: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +7 -> 20
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_2
    //   19: areturn
    //   20: aload_1
    //   21: astore 6
    //   23: aload_1
    //   24: ldc 169
    //   26: invokevirtual 173	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   29: ifne +24 -> 53
    //   32: new 23	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   39: ldc 175
    //   41: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 6
    //   53: aload 6
    //   55: invokestatic 181	com/tencent/mobileqq/transfile/AbsDownloader:c	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 7
    //   60: new 183	java/io/FileInputStream
    //   63: dup
    //   64: new 23	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   71: getstatic 43	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 7
    //   79: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: new 186	java/io/BufferedInputStream
    //   92: dup
    //   93: aload_2
    //   94: sipush 8192
    //   97: invokespecial 189	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   100: astore_1
    //   101: aload_1
    //   102: astore 4
    //   104: aload_2
    //   105: astore_3
    //   106: aload_1
    //   107: invokestatic 195	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   110: astore 5
    //   112: aload 5
    //   114: astore_3
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 198	java/io/BufferedInputStream:close	()V
    //   123: aload_3
    //   124: astore_1
    //   125: aload_2
    //   126: ifnull +9 -> 135
    //   129: aload_2
    //   130: invokevirtual 199	java/io/FileInputStream:close	()V
    //   133: aload_3
    //   134: astore_1
    //   135: aload_1
    //   136: astore_2
    //   137: aload_1
    //   138: ifnonnull -120 -> 18
    //   141: aload_0
    //   142: getfield 69	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   145: ldc 201
    //   147: aload 6
    //   149: invokestatic 206	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   152: ldc 208
    //   154: aconst_null
    //   155: aconst_null
    //   156: invokestatic 213	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   159: astore_2
    //   160: aload_2
    //   161: ifnull +11 -> 172
    //   164: aload_2
    //   165: iconst_0
    //   166: aload_2
    //   167: arraylength
    //   168: invokestatic 217	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   171: astore_1
    //   172: aload_1
    //   173: ifnonnull +96 -> 269
    //   176: new 159	java/io/IOException
    //   179: dup
    //   180: ldc 219
    //   182: invokespecial 220	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   185: athrow
    //   186: astore 5
    //   188: aconst_null
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_1
    //   193: astore 4
    //   195: aload_2
    //   196: astore_3
    //   197: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +19 -> 219
    //   203: aload_1
    //   204: astore 4
    //   206: aload_2
    //   207: astore_3
    //   208: ldc 227
    //   210: iconst_2
    //   211: aload 5
    //   213: invokevirtual 230	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   216: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 198	java/io/BufferedInputStream:close	()V
    //   227: aload_2
    //   228: ifnull +95 -> 323
    //   231: aload_2
    //   232: invokevirtual 199	java/io/FileInputStream:close	()V
    //   235: aconst_null
    //   236: astore_1
    //   237: goto -102 -> 135
    //   240: astore_1
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -108 -> 135
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_2
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 198	java/io/BufferedInputStream:close	()V
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 199	java/io/FileInputStream:close	()V
    //   267: aload_1
    //   268: athrow
    //   269: aload_0
    //   270: aload 7
    //   272: aload_2
    //   273: invokespecial 237	com/tencent/biz/qrcode/CodeMaskManager:a	(Ljava/lang/String;[B)Z
    //   276: pop
    //   277: aload_1
    //   278: areturn
    //   279: astore_1
    //   280: goto -157 -> 123
    //   283: astore_1
    //   284: aload_3
    //   285: astore_1
    //   286: goto -151 -> 135
    //   289: astore_1
    //   290: goto -63 -> 227
    //   293: astore_3
    //   294: goto -35 -> 259
    //   297: astore_2
    //   298: goto -31 -> 267
    //   301: astore_1
    //   302: goto -53 -> 249
    //   305: astore_1
    //   306: aload_3
    //   307: astore_2
    //   308: goto -59 -> 249
    //   311: astore 5
    //   313: aconst_null
    //   314: astore_1
    //   315: goto -123 -> 192
    //   318: astore 5
    //   320: goto -128 -> 192
    //   323: aconst_null
    //   324: astore_1
    //   325: goto -190 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	CodeMaskManager
    //   0	328	1	paramString	String
    //   17	256	2	localObject1	Object
    //   297	1	2	localIOException1	java.io.IOException
    //   307	1	2	localObject2	Object
    //   105	180	3	localObject3	Object
    //   293	14	3	localIOException2	java.io.IOException
    //   1	254	4	str1	String
    //   110	3	5	localBitmap	Bitmap
    //   186	26	5	localException1	Exception
    //   311	1	5	localException2	Exception
    //   318	1	5	localException3	Exception
    //   21	127	6	str2	String
    //   58	213	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   60	89	186	java/lang/Exception
    //   231	235	240	java/io/IOException
    //   60	89	246	finally
    //   119	123	279	java/io/IOException
    //   129	133	283	java/io/IOException
    //   223	227	289	java/io/IOException
    //   254	259	293	java/io/IOException
    //   263	267	297	java/io/IOException
    //   89	101	301	finally
    //   106	112	305	finally
    //   197	203	305	finally
    //   208	219	305	finally
    //   89	101	311	java/lang/Exception
    //   106	112	318	java/lang/Exception
  }
  
  private Bundle a()
  {
    int i = a(this.jdField_b_of_type_JavaUtilList.size());
    return a((Bundle)this.jdField_b_of_type_JavaUtilList.get(i));
  }
  
  private Bundle a(Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("bkgRes"))
    {
      i = paramBundle.getInt("bkgRes");
      paramBundle.remove("bkg");
      if (i == 0) {}
    }
    try
    {
      paramBundle.putParcelable("bkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
      label47:
      if (paramBundle.containsKey("qrbkgRes"))
      {
        i = paramBundle.getInt("qrbkgRes");
        paramBundle.remove("qrbkg");
        if (i == 0) {}
      }
      try
      {
        paramBundle.putParcelable("qrbkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
        label94:
        return (Bundle)paramBundle.clone();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        break label94;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label47;
    }
  }
  
  private void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramInt == 1)
    {
      localBundle.putInt("qrbkgRes", 2130840924);
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", 0);
      localBundle.putInt("W", -1);
      localBundle.putParcelable("qrloc", new Rect(126, 156, 413, 443));
      localBundle.putInt("head", 0);
      localBundle.putInt("type", 1);
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList.add(localBundle);
      return;
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", -16777216);
      localBundle.putInt("W", 16777215);
      localBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
      localBundle.putInt("head", 1);
      localBundle.putInt("type", 1);
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList = new Vector(this.jdField_b_of_type_JavaUtilList);
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          Bundle localBundle = new Bundle();
          if (localJSONObject.has("bkg")) {
            localBundle.putString("bkgUrl", localJSONObject.getString("bkg"));
          }
          localBundle.putInt("nameClr", (int)Long.parseLong(localJSONObject.getString("nameClr"), 16));
          localBundle.putInt("tipsClr", (int)Long.parseLong(localJSONObject.getString("tipsClr"), 16));
          if (localJSONObject.has("qrbkg")) {
            localBundle.putString("qrbkgUrl", localJSONObject.getString("qrbkg"));
          }
          Object localObject;
          int k;
          int m;
          int n;
          int i1;
          if (localJSONObject.has("qrloc"))
          {
            localObject = localJSONObject.getJSONArray("qrloc");
            j = ((JSONArray)localObject).getInt(0);
            k = ((JSONArray)localObject).getInt(1);
            m = ((JSONArray)localObject).getInt(0);
            n = ((JSONArray)localObject).getInt(2);
            i1 = ((JSONArray)localObject).getInt(1);
            localBundle.putParcelable("qrloc", new Rect(j, k, m + n, ((JSONArray)localObject).getInt(3) + i1));
          }
          if (localJSONObject.has("qrsz")) {
            localBundle.putInt("qrsz", localJSONObject.getInt("qrsz"));
          }
          if (localJSONObject.has("clip"))
          {
            localObject = new ArrayList();
            JSONArray localJSONArray1 = localJSONObject.getJSONArray("clip");
            j = 0;
            while (j < localJSONArray1.length())
            {
              JSONArray localJSONArray2 = localJSONArray1.getJSONArray(j);
              k = localJSONArray2.getInt(0);
              m = localJSONArray2.getInt(1);
              n = localJSONArray2.getInt(0);
              i1 = localJSONArray2.getInt(2);
              int i2 = localJSONArray2.getInt(1);
              ((ArrayList)localObject).add(new Rect(k, m, n + i1, localJSONArray2.getInt(3) + i2));
              j += 1;
            }
            localBundle.putParcelableArrayList("clip", (ArrayList)localObject);
          }
          localBundle.putInt("B", (int)Long.parseLong(localJSONObject.getString("B"), 16));
          if (localJSONObject.has("W")) {
            localBundle.putInt("W", (int)Long.parseLong(localJSONObject.getString("W"), 16));
          }
          for (;;)
          {
            try
            {
              localBundle.putInt("head", localJSONObject.getInt("head"));
              localBundle.putInt("v", localJSONObject.getInt("v"));
              localBundle.putInt("type", 2);
              this.jdField_a_of_type_JavaUtilList.add(localBundle);
            }
            catch (Exception localException)
            {
              if (!localJSONObject.getBoolean("head")) {
                break;
              }
            }
            localBundle.putInt("W", 16777215);
          }
          for (int j = 1;; j = 0)
          {
            localBundle.putInt("head", j);
            break;
          }
        }
        catch (JSONException localJSONException)
        {
          label560:
          break label560;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_2
    //   9: ifnull +90 -> 99
    //   12: new 57	java/io/File
    //   15: dup
    //   16: getstatic 43	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokespecial 376	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 379	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 57	java/io/File
    //   29: dup
    //   30: new 23	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   37: getstatic 43	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 376	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 382	java/io/File:exists	()Z
    //   58: ifne +8 -> 66
    //   61: aload_1
    //   62: invokevirtual 385	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: new 387	java/io/FileOutputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 390	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: aload_1
    //   76: aload_2
    //   77: invokevirtual 394	java/io/FileOutputStream:write	([B)V
    //   80: iconst_1
    //   81: istore 4
    //   83: iload 4
    //   85: istore_3
    //   86: aload_1
    //   87: ifnull +10 -> 97
    //   90: aload_1
    //   91: invokevirtual 395	java/io/FileOutputStream:close	()V
    //   94: iload 4
    //   96: istore_3
    //   97: iload_3
    //   98: ireturn
    //   99: iconst_0
    //   100: ifeq -3 -> 97
    //   103: new 397	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 398	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: astore_1
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: aload 6
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull -22 -> 97
    //   122: aload_1
    //   123: invokevirtual 395	java/io/FileOutputStream:close	()V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_1
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_1
    //   132: aload 5
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 395	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_2
    //   149: goto -6 -> 143
    //   152: astore 5
    //   154: aload_1
    //   155: astore_2
    //   156: aload 5
    //   158: astore_1
    //   159: goto -24 -> 135
    //   162: astore_2
    //   163: goto -45 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	CodeMaskManager
    //   0	166	1	paramString	String
    //   0	166	2	paramArrayOfByte	byte[]
    //   1	97	3	bool1	boolean
    //   81	14	4	bool2	boolean
    //   3	130	5	localObject1	Object
    //   152	5	5	localObject2	Object
    //   6	110	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   103	111	111	java/io/IOException
    //   12	66	114	java/io/IOException
    //   66	75	114	java/io/IOException
    //   122	126	128	java/io/IOException
    //   12	66	131	finally
    //   66	75	131	finally
    //   90	94	145	java/io/IOException
    //   139	143	148	java/io/IOException
    //   75	80	152	finally
    //   75	80	162	java/io/IOException
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).edit();
    localEditor.putInt("lastIndex", this.jdField_a_of_type_Int);
    localEditor.commit();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {}
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0);
      l = localSharedPreferences.getLong("updateTemplate2", 0L);
    } while (System.currentTimeMillis() - l < 86400000L);
    Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getHeight();
    this.jdField_a_of_type_JavaLangThread = new osf(this, localSharedPreferences, localDisplay.getWidth(), i, paramInt);
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Bundle)localIterator.next();
      Bitmap localBitmap = (Bitmap)((Bundle)localObject).getParcelable("bkg");
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      localObject = (Bitmap)((Bundle)localObject).getParcelable("qrbkg");
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(CodeMaskManager.Callback paramCallback, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt == 2) || (paramInt == 1)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        this.jdField_a_of_type_AndroidOsBundle = new Bundle();
        this.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
        this.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
        this.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
        this.jdField_a_of_type_AndroidOsBundle.putInt("B", 0);
        this.jdField_a_of_type_AndroidOsBundle.putInt("W", -9947128);
        if (paramInt != 2) {
          break label150;
        }
        this.jdField_a_of_type_AndroidOsBundle.putInt("head", 3);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("type", 1);
        paramCallback.a(a(this.jdField_a_of_type_AndroidOsBundle));
        return;
        label150:
        if (paramInt == 1) {
          this.jdField_a_of_type_AndroidOsBundle.putInt("head", 4);
        }
      }
    }
    int i = a(this.jdField_a_of_type_JavaUtilList.size());
    if (i >= 0)
    {
      paramInt = i;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {}
    }
    else
    {
      paramInt = 0;
    }
    Object localObject = (Bundle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((Bundle)localObject).getInt("type") == 1)
    {
      paramCallback.a(a((Bundle)localObject));
      b();
      return;
    }
    localObject = new osi(this, paramCallback, (Bundle)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new osh(this, (osi)localObject, paramCallback), 10000L);
    ((osi)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager
 * JD-Core Version:    0.7.0.1
 */