package com.tencent.mobileqq.campuscircle;

import abpv;
import abpw;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(12)
public class CampusCircleReplyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, EmoticonCallback, InputMethodRelativeLayout.onSizeChangedListenner
{
  public static LruCache a;
  protected int a;
  protected long a;
  protected Handler a;
  protected Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  protected EditText a;
  protected FrameLayout a;
  protected ImageButton a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected SystemEmoticonPanel a;
  protected InputMethodRelativeLayout a;
  protected String a;
  protected boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected int c;
  protected String c;
  protected boolean c;
  protected int d;
  
  static
  {
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(3);
  }
  
  public CampusCircleReplyActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837571);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130845268);
      return;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130844546);
  }
  
  public void a()
  {
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText).replace("\n", " ");
    Intent localIntent = new Intent();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetCheckBox == null) || (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
          continue;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("CampusCircleReplyActivity", 2, localJSONException, new Object[] { "onSend, exception" });
        continue;
        if (i == 0) {
          continue;
        }
        int i = 1;
        continue;
      }
      localJSONObject.put("anonymous", i);
      localJSONObject.put("text", str);
      localIntent.putExtra("result", localJSONObject.toString());
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "onSend, text=" + str);
      }
      setResult(-1, localIntent);
      this.jdField_c_of_type_Boolean = true;
      finish();
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Int = paramJSONObject.optInt("minlen", 3);
    this.jdField_b_of_type_Int = paramJSONObject.optInt("maxlen", 700);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("hint", "");
    if (paramJSONObject.optInt("emoji", 1) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramJSONObject.optInt("anonymous", 0) != 1) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("from", "default");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("feedId", "");
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      a(0);
    }
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int k = 0;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    this.d = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (str == null) {}
    for (int i = 0;; i = str.length())
    {
      int j = k;
      if (this.jdField_b_of_type_Int > 0)
      {
        j = k;
        if (i > this.jdField_b_of_type_Int)
        {
          j = i - this.jdField_b_of_type_Int;
          paramEditable.delete(this.jdField_c_of_type_Int - j, this.d);
          this.jdField_c_of_type_Int -= j;
          this.d -= j;
        }
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(j + this.jdField_c_of_type_Int);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  protected void d()
  {
    setContentView(2130970274);
    Object localObject = findViewById(2131363244);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131365636));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131366638));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366618));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365527));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366607));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131369920));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369921));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    findViewById(2131366608).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setPressed(false);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 0;
      ((ImageButton)localObject).setVisibility(i);
      if (!this.jdField_b_of_type_Boolean) {
        break label471;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new abpv(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("comment")) {
        break label444;
      }
      localObject = "匿名评论";
      label292:
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "anonymous str=" + (String)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131493372));
    }
    for (;;)
    {
      if (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localObject = (String)jdField_a_of_type_AndroidUtilLruCache.get(this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleReplyActivity", 2, "getDraft, mFeedId=" + this.jdField_b_of_type_JavaLangString + ", draft=" + (String)localObject);
        }
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
        }
      }
      return;
      i = 8;
      break;
      label444:
      if (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("publish"))
      {
        localObject = "匿名发表";
        break label292;
      }
      localObject = "匿名";
      break label292;
      label471:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "bundle is null");
      }
      QQToast.a(this, 1, getString(2131430309, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    paramBundle = paramBundle.getString("options");
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "publish option: " + paramBundle);
      }
      paramBundle = new JSONObject(paramBundle);
      a(paramBundle);
      d();
      return true;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(this, 1, getString(2131430309, new Object[] { Integer.valueOf(999) }), 0).b(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.e("CampusCircleReplyActivity", 2, paramBundle, new Object[] { "onCreate parse json failed" });
      }
      finish();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((!this.jdField_c_of_type_Boolean) && (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (!android.text.TextUtils.isEmpty(str)) {
        jdField_a_of_type_AndroidUtilLruCache.put(this.jdField_b_of_type_JavaLangString, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "save draft, text=" + str);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
    overridePendingTransition(0, 2131034122);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131366608: 
    case 2131366638: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.w("CampusCircleReplyActivity", 2, "transparent_space click!");
        }
        finish();
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
        return;
      }
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new abpw(this), 200L);
      return;
    }
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity
 * JD-Core Version:    0.7.0.1
 */