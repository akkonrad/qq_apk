package com.tencent.mobileqq.activity.bless;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.InputStream;
import wen;
import wes;
import wet;
import wev;
import wew;

public class BlessActivity
  extends BlessTypeActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public BlessActivity.AnimationDrawable2 a;
  private QQVideoView jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView;
  private String jdField_a_of_type_JavaLangString = "BlessActivity";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stopPlayingStarVideo mNeedShowStarVideo=" + this.jdField_a_of_type_Boolean + ", mIsPlayingStarVideo=" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (paramBoolean)
      {
        View localView = findViewById(2131363368);
        localView.setVisibility(0);
        localView.bringToFront();
        findViewById(2131363370).bringToFront();
        findViewById(2131363378).bringToFront();
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.isPlaying()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.stopPlayback();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = null;
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   9: invokevirtual 146	com/tencent/mobileqq/activity/bless/BlessManager:j	()Ljava/lang/String;
    //   12: astore 9
    //   14: aload_0
    //   15: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   18: invokevirtual 149	com/tencent/mobileqq/activity/bless/BlessManager:k	()Ljava/lang/String;
    //   21: astore 8
    //   23: aload 8
    //   25: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: istore 5
    //   30: iload 5
    //   32: ifeq +37 -> 69
    //   35: iconst_0
    //   36: ifeq +11 -> 47
    //   39: new 157	java/lang/NullPointerException
    //   42: dup
    //   43: invokespecial 158	java/lang/NullPointerException:<init>	()V
    //   46: athrow
    //   47: return
    //   48: astore 6
    //   50: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq -6 -> 47
    //   56: aload_0
    //   57: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   60: iconst_2
    //   61: ldc 160
    //   63: aload 6
    //   65: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: return
    //   69: new 165	java/io/File
    //   72: dup
    //   73: aload 9
    //   75: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 7
    //   80: new 165	java/io/File
    //   83: dup
    //   84: aload 8
    //   86: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 171	java/io/File:exists	()Z
    //   92: ifne +22 -> 114
    //   95: aload 7
    //   97: invokevirtual 171	java/io/File:exists	()Z
    //   100: ifeq +14 -> 114
    //   103: aload 7
    //   105: invokevirtual 174	java/io/File:getPath	()Ljava/lang/String;
    //   108: aload 8
    //   110: iconst_0
    //   111: invokestatic 179	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   114: new 181	java/io/FileInputStream
    //   117: dup
    //   118: aload 9
    //   120: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   123: astore 7
    //   125: new 184	android/graphics/BitmapFactory$Options
    //   128: dup
    //   129: invokespecial 185	android/graphics/BitmapFactory$Options:<init>	()V
    //   132: astore 6
    //   134: aload 6
    //   136: aload 7
    //   138: aload_0
    //   139: getfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   142: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   145: getfield 194	android/view/ViewGroup$LayoutParams:width	I
    //   148: aload_0
    //   149: getfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   152: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   155: getfield 197	android/view/ViewGroup$LayoutParams:height	I
    //   158: invokestatic 202	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   161: d2i
    //   162: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   165: aload_0
    //   166: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   169: invokevirtual 209	com/tencent/mobileqq/activity/bless/BlessManager:m	()I
    //   172: istore_3
    //   173: iload_3
    //   174: iconst_m1
    //   175: if_icmpne +87 -> 262
    //   178: new 66	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   185: aload 8
    //   187: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iconst_1
    //   191: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 214
    //   196: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload 6
    //   204: invokestatic 219	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: astore 6
    //   209: aload_0
    //   210: getfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   213: new 221	wep
    //   216: dup
    //   217: aload_0
    //   218: aload 6
    //   220: invokespecial 224	wep:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;Landroid/graphics/Bitmap;)V
    //   223: ldc2_w 225
    //   226: invokevirtual 230	android/widget/ImageView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   229: pop
    //   230: aload 7
    //   232: ifnull -185 -> 47
    //   235: aload 7
    //   237: invokevirtual 235	java/io/InputStream:close	()V
    //   240: return
    //   241: astore 6
    //   243: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -199 -> 47
    //   249: aload_0
    //   250: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   253: iconst_2
    //   254: ldc 160
    //   256: aload 6
    //   258: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: return
    //   262: new 165	java/io/File
    //   265: dup
    //   266: aload 8
    //   268: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   271: astore 9
    //   273: aload 9
    //   275: invokevirtual 238	java/io/File:isDirectory	()Z
    //   278: istore 5
    //   280: iload 5
    //   282: ifne +35 -> 317
    //   285: aload 7
    //   287: ifnull -240 -> 47
    //   290: aload 7
    //   292: invokevirtual 235	java/io/InputStream:close	()V
    //   295: return
    //   296: astore 6
    //   298: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq -254 -> 47
    //   304: aload_0
    //   305: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: iconst_2
    //   309: ldc 160
    //   311: aload 6
    //   313: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: return
    //   317: aload 9
    //   319: invokevirtual 242	java/io/File:list	()[Ljava/lang/String;
    //   322: arraylength
    //   323: istore_2
    //   324: aload_0
    //   325: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   328: invokevirtual 245	com/tencent/mobileqq/activity/bless/BlessManager:n	()I
    //   331: istore 4
    //   333: aload_0
    //   334: new 247	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2
    //   337: dup
    //   338: aload_0
    //   339: invokespecial 249	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   342: putfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   345: iload_1
    //   346: iload_2
    //   347: if_icmpge +67 -> 414
    //   350: new 66	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   357: aload 8
    //   359: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload_1
    //   363: iconst_1
    //   364: iadd
    //   365: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: ldc 214
    //   370: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: aload 6
    //   378: invokestatic 219	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   381: astore 9
    //   383: aload_0
    //   384: getfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   387: new 253	android/graphics/drawable/BitmapDrawable
    //   390: dup
    //   391: aload_0
    //   392: invokevirtual 257	com/tencent/mobileqq/activity/bless/BlessActivity:getResources	()Landroid/content/res/Resources;
    //   395: aload 9
    //   397: invokespecial 260	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   400: iload 4
    //   402: iload_2
    //   403: idiv
    //   404: invokevirtual 264	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   407: iload_1
    //   408: iconst_1
    //   409: iadd
    //   410: istore_1
    //   411: goto -66 -> 345
    //   414: iload_3
    //   415: ifne +62 -> 477
    //   418: aload_0
    //   419: getfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   422: iconst_0
    //   423: invokevirtual 267	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:setOneShot	(Z)V
    //   426: aload_0
    //   427: getfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   430: new 269	wer
    //   433: dup
    //   434: aload_0
    //   435: invokespecial 270	wer:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   438: ldc2_w 225
    //   441: invokevirtual 230	android/widget/ImageView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   444: pop
    //   445: aload 7
    //   447: ifnull -400 -> 47
    //   450: aload 7
    //   452: invokevirtual 235	java/io/InputStream:close	()V
    //   455: return
    //   456: astore 6
    //   458: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq -414 -> 47
    //   464: aload_0
    //   465: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   468: iconst_2
    //   469: ldc 160
    //   471: aload 6
    //   473: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   476: return
    //   477: aload_0
    //   478: getfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   481: iconst_1
    //   482: invokevirtual 267	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:setOneShot	(Z)V
    //   485: aload_0
    //   486: getfield 251	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2	Lcom/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2;
    //   489: new 272	weq
    //   492: dup
    //   493: aload_0
    //   494: invokespecial 273	weq:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   497: invokevirtual 276	com/tencent/mobileqq/activity/bless/BlessActivity$AnimationDrawable2:a	(Lcom/tencent/mobileqq/activity/bless/BlessActivity$IAnimationFinishListener;)V
    //   500: goto -74 -> 426
    //   503: astore 8
    //   505: aload 7
    //   507: astore 6
    //   509: aload 8
    //   511: astore 7
    //   513: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq +16 -> 532
    //   519: aload_0
    //   520: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   523: iconst_2
    //   524: ldc_w 278
    //   527: aload 7
    //   529: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   532: aload 6
    //   534: ifnull -487 -> 47
    //   537: aload 6
    //   539: invokevirtual 235	java/io/InputStream:close	()V
    //   542: return
    //   543: astore 6
    //   545: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq -501 -> 47
    //   551: aload_0
    //   552: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   555: iconst_2
    //   556: ldc 160
    //   558: aload 6
    //   560: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   563: return
    //   564: astore 6
    //   566: aconst_null
    //   567: astore 7
    //   569: aload 7
    //   571: ifnull +8 -> 579
    //   574: aload 7
    //   576: invokevirtual 235	java/io/InputStream:close	()V
    //   579: aload 6
    //   581: athrow
    //   582: astore 7
    //   584: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq -8 -> 579
    //   590: aload_0
    //   591: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   594: iconst_2
    //   595: ldc 160
    //   597: aload 7
    //   599: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   602: goto -23 -> 579
    //   605: astore 6
    //   607: goto -38 -> 569
    //   610: astore 8
    //   612: aload 6
    //   614: astore 7
    //   616: aload 8
    //   618: astore 6
    //   620: goto -51 -> 569
    //   623: astore 7
    //   625: goto -112 -> 513
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	BlessActivity
    //   1	410	1	i	int
    //   323	81	2	j	int
    //   172	243	3	k	int
    //   331	73	4	m	int
    //   28	253	5	bool	boolean
    //   3	1	6	localObject1	Object
    //   48	16	6	localException1	Exception
    //   132	87	6	localObject2	Object
    //   241	16	6	localException2	Exception
    //   296	81	6	localException3	Exception
    //   456	16	6	localException4	Exception
    //   507	31	6	localObject3	Object
    //   543	16	6	localException5	Exception
    //   564	16	6	localObject4	Object
    //   605	8	6	localObject5	Object
    //   618	1	6	localObject6	Object
    //   78	497	7	localObject7	Object
    //   582	16	7	localException6	Exception
    //   614	1	7	localObject8	Object
    //   623	1	7	localException7	Exception
    //   21	337	8	str	String
    //   503	7	8	localException8	Exception
    //   610	7	8	localObject9	Object
    //   12	384	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   39	47	48	java/lang/Exception
    //   235	240	241	java/lang/Exception
    //   290	295	296	java/lang/Exception
    //   450	455	456	java/lang/Exception
    //   125	173	503	java/lang/Exception
    //   178	230	503	java/lang/Exception
    //   262	280	503	java/lang/Exception
    //   317	345	503	java/lang/Exception
    //   350	407	503	java/lang/Exception
    //   418	426	503	java/lang/Exception
    //   426	445	503	java/lang/Exception
    //   477	500	503	java/lang/Exception
    //   537	542	543	java/lang/Exception
    //   5	30	564	finally
    //   69	114	564	finally
    //   114	125	564	finally
    //   574	579	582	java/lang/Exception
    //   125	173	605	finally
    //   178	230	605	finally
    //   262	280	605	finally
    //   317	345	605	finally
    //   350	407	605	finally
    //   418	426	605	finally
    //   426	445	605	finally
    //   477	500	605	finally
    //   513	532	610	finally
    //   5	30	623	java/lang/Exception
    //   69	114	623	java/lang/Exception
    //   114	125	623	java/lang/Exception
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    Object localObject1 = (RelativeLayout)findViewById(2131362840);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = ((QQVideoView)findViewById(2131363369));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVideoPath(this.jdField_b_of_type_JavaLangString);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int j = this.jdField_d_of_type_Int;
    int i = (int)(j / 900 * 700 + 0.5F);
    if (i % 2 == 1) {
      i += 1;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      d();
      Object localObject2 = (RelativeLayout.LayoutParams)findViewById(2131363368).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = j;
      ((RelativeLayout.LayoutParams)localObject2).height = i;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363367));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      try
      {
        localObject2 = new FileInputStream(this.jdField_c_of_type_JavaLangString);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject2, j, i));
        localObject2 = BitmapManager.a(this.jdField_c_of_type_JavaLangString, localOptions);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = j;
        ((RelativeLayout.LayoutParams)localObject2).height = i;
        this.jdField_a_of_type_AndroidWidgetImageView.bringToFront();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode mVideoCoverPath error = " + localException.getMessage());
          }
        }
      }
      findViewById(2131363378).bringToFront();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setDimension(j, i);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getLayoutParams()).setMargins(0, 0, 0, 0);
      this.jdField_b_of_type_AndroidViewView = new View(this);
      ((RelativeLayout)localObject1).addView(this.jdField_b_of_type_AndroidViewView);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, (int)(localDisplayMetrics.density * 31.0F + 0.5F), 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(localDisplayMetrics.density * 60.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(localDisplayMetrics.density * 60.0F + 0.5F));
      this.jdField_b_of_type_AndroidViewView.bringToFront();
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new wes(this));
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnPreparedListener(new wet(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnCompletionListener(new wev(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnErrorListener(new wew(this));
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new wen(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 420
    //   4: invokevirtual 94	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   7: checkcast 114	android/widget/ImageView
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   15: invokevirtual 422	com/tencent/mobileqq/activity/bless/BlessManager:a	()Ljava/lang/String;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +125 -> 145
    //   23: new 181	java/io/FileInputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: new 184	android/graphics/BitmapFactory$Options
    //   35: dup
    //   36: invokespecial 185	android/graphics/BitmapFactory$Options:<init>	()V
    //   39: astore 4
    //   41: aload 4
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   48: getfield 194	android/view/ViewGroup$LayoutParams:width	I
    //   51: aload_1
    //   52: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   55: getfield 197	android/view/ViewGroup$LayoutParams:height	I
    //   58: invokestatic 202	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   61: d2i
    //   62: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   65: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +53 -> 121
    //   71: aload_0
    //   72: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   75: iconst_2
    //   76: new 66	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 424
    //   86: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   93: getfield 194	android/view/ViewGroup$LayoutParams:width	I
    //   96: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 426
    //   102: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 189	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   109: getfield 197	android/view/ViewGroup$LayoutParams:height	I
    //   112: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_3
    //   122: aload 4
    //   124: invokestatic 219	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore_3
    //   128: aload_3
    //   129: ifnull +8 -> 137
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 331	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 235	java/io/InputStream:close	()V
    //   145: aload_0
    //   146: getfield 75	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_Boolean	Z
    //   149: ifeq +30 -> 179
    //   152: aload_0
    //   153: ldc_w 283
    //   156: invokevirtual 94	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   159: checkcast 285	android/widget/RelativeLayout
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 430	android/widget/RelativeLayout:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   167: new 432	wem
    //   170: dup
    //   171: aload_0
    //   172: aload_1
    //   173: invokespecial 435	wem:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;Landroid/widget/RelativeLayout;)V
    //   176: invokevirtual 441	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   179: aload_0
    //   180: getfield 141	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager	Lcom/tencent/mobileqq/activity/bless/BlessManager;
    //   183: invokevirtual 444	com/tencent/mobileqq/activity/bless/BlessManager:a	()Ljava/lang/Boolean;
    //   186: invokevirtual 449	java/lang/Boolean:booleanValue	()Z
    //   189: ifeq +32 -> 221
    //   192: aload_0
    //   193: aload_0
    //   194: ldc_w 450
    //   197: invokevirtual 94	com/tencent/mobileqq/activity/bless/BlessActivity:findViewById	(I)Landroid/view/View;
    //   200: checkcast 114	android/widget/ImageView
    //   203: putfield 47	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   206: new 452	weo
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 453	weo:<init>	(Lcom/tencent/mobileqq/activity/bless/BlessActivity;)V
    //   214: bipush 10
    //   216: aconst_null
    //   217: iconst_1
    //   218: invokestatic 459	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   221: return
    //   222: astore_1
    //   223: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq -81 -> 145
    //   229: aload_0
    //   230: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   233: iconst_2
    //   234: ldc 160
    //   236: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: goto -94 -> 145
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_1
    //   245: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +14 -> 262
    //   251: aload_0
    //   252: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   255: iconst_2
    //   256: ldc_w 461
    //   259: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_1
    //   263: ifnull -118 -> 145
    //   266: aload_1
    //   267: invokevirtual 235	java/io/InputStream:close	()V
    //   270: goto -125 -> 145
    //   273: astore_1
    //   274: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -132 -> 145
    //   280: aload_0
    //   281: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   284: iconst_2
    //   285: ldc 160
    //   287: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: goto -145 -> 145
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_2
    //   296: aload_2
    //   297: ifnull +7 -> 304
    //   300: aload_2
    //   301: invokevirtual 235	java/io/InputStream:close	()V
    //   304: aload_1
    //   305: athrow
    //   306: astore_2
    //   307: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq -6 -> 304
    //   313: aload_0
    //   314: getfield 29	com/tencent/mobileqq/activity/bless/BlessActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   317: iconst_2
    //   318: ldc 160
    //   320: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: goto -19 -> 304
    //   326: astore_1
    //   327: goto -31 -> 296
    //   330: astore_3
    //   331: aload_1
    //   332: astore_2
    //   333: aload_3
    //   334: astore_1
    //   335: goto -39 -> 296
    //   338: astore_1
    //   339: aload_2
    //   340: astore_1
    //   341: goto -96 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	BlessActivity
    //   10	163	1	localObject1	Object
    //   222	1	1	localException1	Exception
    //   242	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   244	23	1	localObject2	Object
    //   273	1	1	localException2	Exception
    //   293	12	1	localObject3	Object
    //   326	6	1	localObject4	Object
    //   334	1	1	localObject5	Object
    //   338	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   340	1	1	localObject6	Object
    //   31	270	2	localFileInputStream	FileInputStream
    //   306	1	2	localException3	Exception
    //   332	8	2	localObject7	Object
    //   18	116	3	localObject8	Object
    //   330	4	3	localObject9	Object
    //   39	84	4	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   141	145	222	java/lang/Exception
    //   23	32	242	java/io/FileNotFoundException
    //   266	270	273	java/lang/Exception
    //   23	32	293	finally
    //   300	304	306	java/lang/Exception
    //   32	121	326	finally
    //   121	128	326	finally
    //   132	137	326	finally
    //   245	262	330	finally
    //   32	121	338	java/io/FileNotFoundException
    //   121	128	338	java/io/FileNotFoundException
    //   132	137	338	java/io/FileNotFoundException
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968711);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.h())
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c();
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.d();
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    this.jdField_a_of_type_Float = 0.6933333F;
    this.jdField_c_of_type_Int = 1;
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(false);
    this.jdField_e_of_type_Boolean = getIntent().getBooleanExtra("PARAM_IS_FROM_SEARCH", false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.isRunning())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.stop();
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause");
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      if (!this.jdField_d_of_type_Boolean) {
        break label48;
      }
      a(true);
    }
    for (;;)
    {
      super.doOnPause();
      return;
      label48:
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.pause();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getCurrentPosition();
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.seekTo(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.start();
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  protected boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onBackEvent");
    }
    a(false);
    if (!this.jdField_e_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if (this.jdField_a_of_type_Boolean) {
        a(true);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity
 * JD-Core Version:    0.7.0.1
 */