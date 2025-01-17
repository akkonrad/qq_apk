package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import com.tencent.open.base.LengthInputFilter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.widget.IKeyboardChanged;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;

public class ChallengeActivity
  extends ChallengeBragBase
  implements View.OnClickListener, ImageLoader.ImageLoadListener, IKeyboardChanged
{
  protected static final int a = 100;
  protected static final String a;
  protected static final int b = 12;
  public static final int c = 10;
  public static final int d = 10;
  public static final int e = 255;
  public static final int f = 20;
  public static final int g = 30;
  public static final int h = 5;
  public static final int i = 55;
  public static final int j = 145;
  protected ImageView a;
  protected ScrollView a;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] a;
  protected ImageView b;
  protected ScrollView b;
  protected String b;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ChallengeActivity.class.getName();
  }
  
  public void a(int paramInt)
  {
    int k = super.b(this, paramInt) - 10 - 10;
    if ((this.jdField_a_of_type_AndroidWidgetScrollView != null) && (k < 255))
    {
      paramInt = k - 20 - 30 - 5 - 145;
      k = k - 20 - 5 - 145;
      if ((paramInt > 0) && (paramInt < 55))
      {
        this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = super.a(this, paramInt);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
        this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = super.a(this, 30.0F);
        this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    if ((paramInt <= 0) && (k > 0) && (k < 30))
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().height = super.a(this, k);
      this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
    this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(8);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_b_of_type_JavaLangString.equals(paramString)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    while (!this.jdField_c_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131232140));
    this.jdField_b_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131232142));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232143));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131232139));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131232144));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232152));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232151));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232146));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232148));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new LengthInputFilter(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.j);
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    for (;;)
    {
      try
      {
        a(this.i);
        this.jdField_b_of_type_JavaLangString = QZonePortraitData.a(this.d, this.e);
        this.jdField_c_of_type_JavaLangString = QZonePortraitData.a(this.d, this.i);
        Bitmap localBitmap1 = ImageLoader.a().a(this.jdField_b_of_type_JavaLangString);
        Bitmap localBitmap2 = ImageLoader.a().a(this.jdField_c_of_type_JavaLangString);
        if (localBitmap1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
          if (localBitmap2 == null) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap2);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "getNickName error. " + localException.getMessage(), localException);
        f();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838008);
      ImageLoader.a().a(this.jdField_b_of_type_JavaLangString, this);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838008);
    ImageLoader.a().a(this.jdField_c_of_type_JavaLangString, this);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null)
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = super.a(this, 55.0F);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = super.a(this, 30.0F);
      this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
      this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.getWindow().requestFeature(1);
    super.setContentView(2130903338);
    super.c();
    d();
    StaticAnalyz.a("100", "ANDROIDQQ.PK.FS", this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeActivity
 * JD-Core Version:    0.7.0.1
 */