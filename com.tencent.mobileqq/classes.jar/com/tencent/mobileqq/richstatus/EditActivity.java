package com.tencent.mobileqq.richstatus;

import ahpi;
import ahpj;
import ahpk;
import ahpl;
import ahpm;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.widget.ClickableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class EditActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  public static int a;
  public static boolean a;
  public static int b;
  public long a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ahpj(this);
  protected View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new ahpi(this);
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private RichStatusEditText.RichStatusEditListener jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener = new ahpl(this);
  private RichStatusEditText jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private ClickableImageSpan jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan;
  long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 47;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  
  public EditActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahpk(this);
  }
  
  private Drawable a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    if (QLog.isColorLevel()) {
      QLog.d("EditActivity", 2, "tv.getWidth() = " + paramView.getWidth() + ",tv.getHeight()" + paramView.getHeight());
    }
    try
    {
      Object localObject = new Canvas(Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888));
      ((Canvas)localObject).translate(-paramView.getScrollX(), -paramView.getScrollY());
      paramView.draw((Canvas)localObject);
      paramView.setDrawingCacheEnabled(true);
      localObject = paramView.getDrawingCache();
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("EditActivity", 2, "cacheBm is null");
          return null;
        }
      }
      else
      {
        localObject = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
        paramView.destroyDrawingCache();
        paramView = new BitmapDrawable(getResources(), (Bitmap)localObject);
        paramView.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        return paramView;
      }
    }
    catch (OutOfMemoryError paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditActivity", 2, paramView.getMessage());
      }
    }
    return null;
  }
  
  private Drawable a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130969041, null);
    localView.setPadding(0, 0, 0, 0);
    ImageView localImageView = (ImageView)localView.findViewById(2131364838);
    TextView localTextView = (TextView)localView.findViewById(2131364839);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText != null) {
      localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText;
    }
    localObject2 = localObject1;
    if (((String)localObject1).length() > 10) {
      localObject2 = ((String)localObject1).substring(0, 9) + "...";
    }
    localTextView.setText((CharSequence)localObject2);
    if (paramBoolean2) {
      localTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
    }
    for (;;)
    {
      localImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId, 200));
      localView.setBackgroundResource(2130845463);
      return a(localView);
      if (localSignatureManager.a != null) {
        localTextView.setTextColor(Color.parseColor(localSignatureManager.a.e));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, true, true);
      }
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = a(false, paramBoolean);
        localObject2 = a(true, paramBoolean);
      } while ((localObject1 == null) || (localObject2 == null));
      localObject1 = new ClickableImageSpan((Drawable)localObject1, (Drawable)localObject2);
      if (this.d != 1) {
        ((ClickableImageSpan)localObject1).a(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.getDrawable() != null)) {
        ((ClickableImageSpan)localObject1).getDrawable().setState(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.getDrawable().getState());
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getEditableText();
    } while (localObject2 == null);
    if (((ImageSpan[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), ClickableImageSpan.class)).length > 0) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, (ClickableImageSpan)localObject1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = ((ClickableImageSpan)localObject1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().insert(0, "[S]");
      int i = "[S]".length();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setSpan((ImageSpan)localObject1, 0, i);
    }
  }
  
  private void d()
  {
    Object localObject = (SignatureManager)this.app.getManager(57);
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {}
    for (int i = Math.max(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().getSpanEnd(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan), 0);; i = 0)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().length();
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList();
        while (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.size() < 2) {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add(null);
        }
      }
      if ((((SignatureManager)localObject).a == null) || (((SignatureManager)localObject).a.a == null))
      {
        if (this.d != 1) {
          break label279;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().subSequence(i, j).toString().trim());
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(1, null);
        j = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.countLength();
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText != null)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == 0) {
              i = j - 7;
            }
          }
        }
        localObject = Integer.toString(this.jdField_c_of_type_Int - i);
        if (i <= this.jdField_c_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-65536);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        label279:
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().subSequence(i, j).toString());
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void a()
  {
    if (this.d == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.countLength() > this.jdField_c_of_type_Int) {
        a(2131436470);
      }
    }
    else {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("param_new_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.encode());
    setResult(-1, localIntent);
    super.finish();
  }
  
  protected void a(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  void b()
  {
    new Handler().postDelayed(new ahpm(this), 500L);
  }
  
  void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    RichStatus localRichStatus;
    if ((paramInt2 == -1) && (paramInt1 == 17))
    {
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        break label149;
      }
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = ((int)this.jdField_a_of_type_AndroidContentIntent.getLongExtra("k_action_id", 0L));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_action_text");
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId);
        localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        if (localObject == null) {
          break label161;
        }
      }
    }
    label149:
    label161:
    for (Object localObject = ((ActionInfo)localObject).d;; localObject = " ")
    {
      localRichStatus.actionText = ((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId = ((int)paramIntent.getLongExtra("k_data_id", 0L));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = paramIntent.getStringExtra("k_data_text");
      a(false);
      return;
      this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
      break;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.d = getIntent().getIntExtra("param_entry", 0);
    int i = getIntent().getIntExtra("max_word_count", -1);
    if (i != -1) {
      this.jdField_c_of_type_Int = i;
    }
    if (this.d == 1) {
      super.setContentView(2130971582);
    }
    for (;;)
    {
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      jdField_a_of_type_Int = paramBundle.heightPixels;
      jdField_b_of_type_Int = paramBundle.widthPixels;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
        break;
      }
      a(2131434215);
      super.finish();
      return false;
      super.setContentViewNoTitle(2130971582);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a())
    {
      a(2131436468);
      super.finish();
      return false;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#dedede"));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131375121));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131375128);
    if (this.d == 1)
    {
      LayoutInflater.from(this).inflate(2130971583, this.jdField_a_of_type_AndroidWidgetLinearLayout, true);
      setTitle("交友宣言");
      this.leftView.setText(2131432414);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363448));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494269));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText = ((RichStatusEditText)super.findViewById(2131375132));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setHint("你想对附近的人说点什么？");
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener);
      paramBundle = getIntent().getByteArrayExtra("param_old_xuan_yan");
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatus.parseStatus(paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText;
        if (paramBundle != null) {
          break label564;
        }
        paramBundle = new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = paramBundle;
      }
    }
    label564:
    for (;;)
    {
      if (paramBundle.size() < 2)
      {
        paramBundle.add(null);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setText("");
      a(false);
      if (paramBundle.get(0) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)paramBundle.get(0));
      }
      if (paramBundle.get(1) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)paramBundle.get(1));
      }
      d();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131375133);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((RelativeLayout)super.findViewById(2131375122)).setVisibility(8);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(null);
    }
    c();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.jdField_b_of_type_Boolean = false;
    c();
    super.doOnPause();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    this.jdField_c_of_type_Boolean = false;
    super.doOnRestoreInstanceState(paramBundle);
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.d == 1) {
      b();
    }
    super.doOnResume();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) {
      paramBundle.putByteArray("param_rich_status", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.encode());
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void doOnStart()
  {
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    if ((localSignatureManager.a != null) && (localSignatureManager.a.a == null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(0);
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(4);
    }
    super.doOnStop();
  }
  
  protected boolean isWrapContent()
  {
    return this.d == 1;
  }
  
  protected boolean onBackEvent()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.d == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.countLength() > this.jdField_c_of_type_Int)
      {
        a(2131436470);
        return true;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("param_new_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.encode());
      setResult(-1, localIntent);
      super.finish();
      return super.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    paramView.getId();
    if (paramView.getId() != 2131375132) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity
 * JD-Core Version:    0.7.0.1
 */