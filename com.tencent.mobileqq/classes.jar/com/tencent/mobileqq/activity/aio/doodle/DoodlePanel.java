package com.tencent.mobileqq.activity.aio.doodle;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.ColorPickerData;
import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import uru;
import urv;
import urw;
import ury;
import urz;

public class DoodlePanel
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static int a;
  public static final int b;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private DoodleLayout jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout;
  private DoodlePanel.DoodlePanelListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$DoodlePanelListener;
  private ColorPicker jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker;
  private GifTemplatePicker jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker;
  public QQAppInterface a;
  private boolean jdField_a_of_type_Boolean;
  private Button b;
  
  static
  {
    jdField_a_of_type_Int = -1;
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    int i = (int)(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 1.0F / 1.132931F);
    jdField_b_of_type_Int = AIOUtils.a(81.0F, localResources) + i;
  }
  
  public DoodlePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public DoodlePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  /* Error */
  private boolean a(String paramString, DoodleItem paramDoodleItem)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_1
    //   10: ifnull +14 -> 24
    //   13: aload_2
    //   14: ifnull +10 -> 24
    //   17: aload_1
    //   18: invokevirtual 97	java/lang/String:length	()I
    //   21: ifne +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload 7
    //   28: astore 5
    //   30: new 99	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload 7
    //   41: astore 5
    //   43: aload_1
    //   44: invokevirtual 106	java/io/File:getParentFile	()Ljava/io/File;
    //   47: invokevirtual 110	java/io/File:exists	()Z
    //   50: ifne +15 -> 65
    //   53: aload 7
    //   55: astore 5
    //   57: aload_1
    //   58: invokevirtual 106	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 113	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload 7
    //   67: astore 5
    //   69: new 115	java/io/BufferedOutputStream
    //   72: dup
    //   73: new 117	java/io/FileOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 123	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore_1
    //   85: aload_2
    //   86: new 125	usb
    //   89: dup
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 128	usb:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodlePanel;Ljava/io/OutputStream;)V
    //   95: invokestatic 133	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodleItem;Lcom/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator$TranslatorListener;)Z
    //   98: pop
    //   99: aload_1
    //   100: invokevirtual 138	java/io/OutputStream:close	()V
    //   103: iconst_0
    //   104: ifeq +11 -> 115
    //   107: new 140	java/lang/NullPointerException
    //   110: dup
    //   111: invokespecial 142	java/lang/NullPointerException:<init>	()V
    //   114: athrow
    //   115: iconst_1
    //   116: istore_3
    //   117: ldc 144
    //   119: iconst_2
    //   120: new 146	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   127: ldc 149
    //   129: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   135: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   138: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: iload_3
    //   145: ireturn
    //   146: astore_1
    //   147: ldc 144
    //   149: iconst_2
    //   150: new 146	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   157: ldc 174
    //   159: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: iload 4
    //   174: istore_3
    //   175: goto -58 -> 117
    //   178: astore_2
    //   179: aload 6
    //   181: astore_1
    //   182: aload_1
    //   183: astore 5
    //   185: aload_2
    //   186: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   189: aload_1
    //   190: astore 5
    //   192: ldc 144
    //   194: iconst_2
    //   195: new 146	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   202: ldc 182
    //   204: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: iload 4
    //   219: istore_3
    //   220: aload_1
    //   221: ifnull -104 -> 117
    //   224: aload_1
    //   225: invokevirtual 138	java/io/OutputStream:close	()V
    //   228: iload 4
    //   230: istore_3
    //   231: goto -114 -> 117
    //   234: astore_1
    //   235: ldc 144
    //   237: iconst_2
    //   238: new 146	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   245: ldc 174
    //   247: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_1
    //   251: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: iload 4
    //   262: istore_3
    //   263: goto -146 -> 117
    //   266: astore_1
    //   267: aload 5
    //   269: astore_2
    //   270: aload_2
    //   271: ifnull +7 -> 278
    //   274: aload_2
    //   275: invokevirtual 138	java/io/OutputStream:close	()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_2
    //   281: ldc 144
    //   283: iconst_2
    //   284: new 146	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   291: ldc 174
    //   293: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_2
    //   297: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: goto -28 -> 278
    //   309: astore 5
    //   311: aload_1
    //   312: astore_2
    //   313: aload 5
    //   315: astore_1
    //   316: goto -46 -> 270
    //   319: astore_2
    //   320: goto -138 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	DoodlePanel
    //   0	323	1	paramString	String
    //   0	323	2	paramDoodleItem	DoodleItem
    //   116	147	3	bool1	boolean
    //   7	254	4	bool2	boolean
    //   28	240	5	localObject1	java.lang.Object
    //   309	5	5	localObject2	java.lang.Object
    //   4	176	6	localObject3	java.lang.Object
    //   1	65	7	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   107	115	146	java/lang/Exception
    //   30	39	178	java/lang/Exception
    //   43	53	178	java/lang/Exception
    //   57	65	178	java/lang/Exception
    //   69	85	178	java/lang/Exception
    //   224	228	234	java/lang/Exception
    //   30	39	266	finally
    //   43	53	266	finally
    //   57	65	266	finally
    //   69	85	266	finally
    //   185	189	266	finally
    //   192	217	266	finally
    //   274	278	280	java/lang/Exception
    //   85	103	309	finally
    //   85	103	319	java/lang/Exception
  }
  
  private void e()
  {
    boolean bool2 = true;
    Button localButton;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a(false, false);
      if (this.jdField_a_of_type_AndroidWidgetButton != null)
      {
        localButton = this.jdField_a_of_type_AndroidWidgetButton;
        if (i <= 0) {
          break label70;
        }
        bool1 = true;
        localButton.setEnabled(bool1);
      }
      if (this.jdField_b_of_type_AndroidWidgetButton != null)
      {
        localButton = this.jdField_b_of_type_AndroidWidgetButton;
        if (i <= 0) {
          break label75;
        }
      }
    }
    label70:
    label75:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localButton.setEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int a(boolean paramBoolean)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a(false, paramBoolean);
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$DoodlePanelListener = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        d();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624516);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399)).setText(paramInt);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.b("PIC_TAG_ERROR", "DoodlePanel showProgress ", paramContext.toString());
    }
  }
  
  public void a(Bitmap paramBitmap, DoodleItem paramDoodleItem, int paramInt)
  {
    QLog.d("Scribble", 2, "sendDoodleMessage begin:" + System.currentTimeMillis());
    if ((paramBitmap == null) || (paramDoodleItem == null)) {
      return;
    }
    a(getContext(), 2131436145);
    QLog.d("Scribble", 2, "sendDoodleMessage before SendPapScribbleMsg:" + System.currentTimeMillis());
    ScribbleMsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBitmap, paramInt, new urz(this, paramDoodleItem));
  }
  
  public void a(ColorPicker.ColorPickerData paramColorPickerData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout == null) || (paramColorPickerData == null)) {
      return;
    }
    if (paramColorPickerData.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.setColor(paramColorPickerData.c);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.setTexture(paramColorPickerData.jdField_b_of_type_Int);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, long paramLong, int paramInt, XPanelContainer paramXPanelContainer, DoodlePanel.DoodlePanelListener paramDoodlePanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$DoodlePanelListener = paramDoodlePanelListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    QLog.d("Scribble", 2, "mOriginPanelHeight:" + jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker = ((ColorPicker)super.findViewById(2131362972));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.setListener(new uru(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362975));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker = ((GifTemplatePicker)findViewById(2131362973));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.setListener(new urv(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131362974));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout = ((DoodleLayout)findViewById(2131362971));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.setDoodleLayoutListener(new urw(this));
    paramQQAppInterface = SharePreferenceUtils.a(getContext(), "aio_doodle_colorpicker_select");
    int i;
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      paramQQAppInterface = paramQQAppInterface.split(";");
      if (paramQQAppInterface.length == 3)
      {
        paramInt = Integer.valueOf(paramQQAppInterface[0]).intValue();
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        int j = Integer.valueOf(paramQQAppInterface[2]).intValue();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.b(new ColorPicker.ColorPickerData(paramInt, i, j), false);
      }
    }
    for (;;)
    {
      paramQQAppInterface = SharePreferenceUtils.a(getContext(), "aio_doodle_template_picker_select");
      try
      {
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break;
        }
        i = Integer.valueOf(paramQQAppInterface).intValue();
        paramInt = i;
        if (i == -1) {
          paramInt = 0;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramInt = 1;
          continue;
          paramInt = 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.a(paramInt, false);
      e();
      if (AppSetting.b)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("发送");
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("撤销");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.setContentDescription("画板，点击开始涂鸦");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.a(0, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Scribble", 2, "onHide");
    }
    if (!paramBoolean) {
      XPanelContainer.jdField_a_of_type_Int = jdField_a_of_type_Int;
    }
    QLog.d("Scribble", 2, "set mExternalPanelheight :" + XPanelContainer.jdField_a_of_type_Int);
    setVisibility(8);
  }
  
  public void b()
  {
    jdField_a_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    QLog.d("Scribble", 2, "mOriginPanelHeight:" + jdField_a_of_type_Int);
    XPanelContainer.jdField_a_of_type_Int = jdField_b_of_type_Int;
    QLog.d("Scribble", 2, "set mExternalPanelheight :" + XPanelContainer.jdField_a_of_type_Int);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081B3", "0X80081B3", 1, 0, "", "", "", "");
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a(true, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.a(), false);
    }
    e();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Scribble", 2, "cancelProgressDialog " + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131362974)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.b();
      }
      e();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081B6", "0X80081B6", 1, 0, "", "", "", "");
    }
    while ((i != 2131362975) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$DoodlePanelListener == null)) {
      return;
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a();
    if (localBitmap == null)
    {
      QLog.d("Scribble", 2, " onsend error : bitmap is null");
      return;
    }
    DoodleItem localDoodleItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a();
    if (localDoodleItem == null)
    {
      QLog.d("Scribble", 2, " onsend error : doodleParam is null");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081BB", "0X80081BB", 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a(false, true), "", "", "", "");
    i = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a();
    paramView = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a() != null) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a().a();
    }
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008326", "0X8008326", 0, 0, "", "", String.valueOf(i), paramView);
      a(localBitmap, localDoodleItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$DoodlePanelListener.a(localBitmap, localDoodleItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a());
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131362974)
    {
      paramView = new ury(this);
      DialogUtil.a(getContext(), 230, null, getContext().getString(2131439073), getContext().getString(2131439075), getContext().getString(2131439074), paramView, paramView).show();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081B7", "0X80081B7", 1, 0, "", "", "", "");
    return true;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel
 * JD-Core Version:    0.7.0.1
 */