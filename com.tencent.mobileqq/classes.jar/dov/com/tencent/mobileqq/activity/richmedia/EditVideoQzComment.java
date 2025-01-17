package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import aofj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.font.FontManager.DefaultFontInfo;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EditVideoQzComment
  extends EditVideoPart
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public RelativeLayout a;
  private QzEditVideoPartManager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager;
  private String jdField_a_of_type_JavaLangString = a(1);
  
  public EditVideoQzComment(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager)
  {
    super(paramQzEditVideoPartManager);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager = paramQzEditVideoPartManager;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "公开";
    case 1: 
      return "公开";
    case 4: 
      return "好友";
    case 16: 
      return "指定人";
    case 64: 
      return "仅自己";
    }
    return "指定人";
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private boolean a(String paramString)
  {
    try
    {
      paramString = FontInterface.a(Long.valueOf(paramString).longValue());
      if (paramString == null) {
        return false;
      }
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int = paramString.jdField_a_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.e = paramString.b;
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int;
      if (i > 0) {
        return true;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("loadDefaultFontData", 1, "loadDefaultFontData Throwable, errMsg = " + paramString.getMessage());
    }
    return false;
  }
  
  private void j()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    String str = FontInterface.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 134	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 140	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 80	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   15: ldc 142
    //   17: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 148	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   30: aconst_null
    //   31: ldc 150
    //   33: iconst_1
    //   34: anewarray 152	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 158	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +208 -> 255
    //   50: aload_1
    //   51: invokeinterface 164 1 0
    //   56: ifeq +199 -> 255
    //   59: aload_1
    //   60: aload_1
    //   61: ldc 166
    //   63: invokeinterface 170 2 0
    //   68: invokeinterface 173 2 0
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +171 -> 249
    //   81: new 152	java/lang/String
    //   84: dup
    //   85: aload_2
    //   86: invokevirtual 177	java/lang/String:getBytes	()[B
    //   89: ldc 179
    //   91: invokespecial 182	java/lang/String:<init>	([BLjava/lang/String;)V
    //   94: invokestatic 186	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_2
    //   98: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +28 -> 129
    //   104: ldc 191
    //   106: iconst_2
    //   107: new 80	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   114: ldc 193
    //   116: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload_2
    //   130: astore_3
    //   131: aload_1
    //   132: ifnull +11 -> 143
    //   135: aload_1
    //   136: invokeinterface 199 1 0
    //   141: aload_2
    //   142: astore_3
    //   143: aload_3
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: ldc 201
    //   150: astore_1
    //   151: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +31 -> 185
    //   157: ldc 191
    //   159: iconst_2
    //   160: new 80	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   167: ldc 203
    //   169: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_3
    //   173: invokestatic 207	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   176: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_1
    //   186: astore_3
    //   187: aload_2
    //   188: ifnull -45 -> 143
    //   191: aload_2
    //   192: invokeinterface 199 1 0
    //   197: aload_1
    //   198: areturn
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: ifnull +9 -> 212
    //   206: aload_1
    //   207: invokeinterface 199 1 0
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: goto -13 -> 202
    //   218: astore_3
    //   219: aload_2
    //   220: astore_1
    //   221: aload_3
    //   222: astore_2
    //   223: goto -21 -> 202
    //   226: astore_3
    //   227: aload_1
    //   228: astore_2
    //   229: ldc 201
    //   231: astore_1
    //   232: goto -81 -> 151
    //   235: astore 4
    //   237: aload_2
    //   238: astore_3
    //   239: aload_1
    //   240: astore_2
    //   241: aload_3
    //   242: astore_1
    //   243: aload 4
    //   245: astore_3
    //   246: goto -95 -> 151
    //   249: ldc 201
    //   251: astore_2
    //   252: goto -154 -> 98
    //   255: ldc 201
    //   257: astore_2
    //   258: goto -129 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	EditVideoQzComment
    //   0	261	1	paramString	String
    //   6	186	2	localObject1	Object
    //   199	14	2	localObject2	Object
    //   214	6	2	localObject3	Object
    //   222	36	2	localObject4	Object
    //   130	14	3	localObject5	Object
    //   145	28	3	localException1	java.lang.Exception
    //   186	1	3	str	String
    //   218	4	3	localObject6	Object
    //   226	1	3	localException2	java.lang.Exception
    //   238	8	3	localObject7	Object
    //   235	9	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   7	46	145	java/lang/Exception
    //   7	46	199	finally
    //   50	98	214	finally
    //   98	129	214	finally
    //   151	185	218	finally
    //   50	98	226	java/lang/Exception
    //   98	129	235	java/lang/Exception
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131373529));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131373532));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131373530));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131373531));
    this.jdField_a_of_type_AndroidViewView = a(2131373533);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QzoneTextBuilder.b);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.j) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.g) || (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.i))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new aofj(this));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    if (a(QQStoryContext.a().a())) {
      j();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQzComment", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
        }
        if (a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.b = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        c();
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 1009);
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    } while (paramIntent == null);
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle.containsKey("extra_key_bundle_priv_key"))
    {
      paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
        if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = paramIntent.getStringArrayList("uin_list");
        if (localObject != null) {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        }
        if (a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.b = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        c();
      }
    }
    if (localBundle.containsKey("extraIsTopicSyncQzone"))
    {
      boolean bool = localBundle.getBoolean("extraIsTopicSyncQzone");
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
    }
    if (localBundle.containsKey("contentIntentKey"))
    {
      localObject = localBundle.getString("contentIntentKey");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = "";
      }
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.c = paramIntent;
    }
    if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
    {
      paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramIntent);
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.e = localBundle.getInt("extra_key_font_format_type");
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
    j();
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      switch (paramMessage.what)
      {
      default: 
        this.jdField_a_of_type_Int = paramMessage.arg1;
        return super.a(paramMessage);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    this.c = ((Long)paramMessage.obj).longValue();
    return true;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    int j = 0;
    int i = 0;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    case 0: 
    case 7: 
      do
      {
        return;
        paramObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.h) {}
        for (paramInt = i;; paramInt = 8)
        {
          paramObject.setVisibility(paramInt);
          return;
        }
      } while (this.jdField_a_of_type_Int == 1);
      paramObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.h) {}
      for (paramInt = j;; paramInt = 8)
      {
        paramObject.setVisibility(paramInt);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onClick(View paramView)
  {
    if (this.c > System.currentTimeMillis()) {}
    do
    {
      int i;
      Object localObject1;
      Object localObject2;
      do
      {
        return;
        i = paramView.getId();
        if (i == 2131373531)
        {
          paramView = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", QQStoryContext.a().a()).replace("{qua}", QUA.a());
          QzEditVideoPartManager.b("608", "6", "0", true);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("permission_code", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            ((Bundle)localObject1).putStringArrayList("uin_list", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList);
            localObject2 = new ArrayList(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.size());
            Iterator localIterator = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              ((ArrayList)localObject2).add(a((String)localIterator.next()));
            }
            ((Bundle)localObject1).putStringArrayList("key_nicknames", (ArrayList)localObject2);
          }
          if ((a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.b))) {
            ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.b);
          }
          QZoneHelper.a((BaseActivity)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi, paramView, 1, (Bundle)localObject1, "");
          return;
        }
      } while (i != 2131373530);
      QzEditVideoPartManager.b("608", "5", "0", true);
      QZoneHelper.UserInfo.a();
      paramView = new Bundle();
      paramView.putInt("permission_code", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramView.putStringArrayList("uin_list", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList);
        localObject1 = new ArrayList(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.size());
        localObject2 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(a((String)((Iterator)localObject2).next()));
        }
        paramView.putStringArrayList("key_nicknames", (ArrayList)localObject1);
      }
      if ((a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.b))) {
        paramView.putString("key_setting_raw_json", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.b);
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
    this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.EditVideoQzComment
 * JD-Core Version:    0.7.0.1
 */