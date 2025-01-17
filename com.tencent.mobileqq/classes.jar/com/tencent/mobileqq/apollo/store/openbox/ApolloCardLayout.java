package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ApolloCardLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AnimationableProgressView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView;
  private ApolloBoxData.ApolloBoxDataItem jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem;
  private MultiURLImageView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView;
  private int jdField_b_of_type_Int;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private int jdField_c_of_type_Int;
  private Path jdField_c_of_type_AndroidGraphicsPath;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private URLImageView jdField_d_of_type_ComTencentImageURLImageView;
  
  public ApolloCardLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ApolloCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  }
  
  public void a(int paramInt1, ApolloBoxData.ApolloBoxDataItem paramApolloBoxDataItem, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem = paramApolloBoxDataItem;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem == null) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView == null)
    {
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView = new AnimationableProgressView(getContext());
      super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView, paramApolloBoxDataItem);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, AIOUtils.a(48.0F, getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
      paramApolloBoxDataItem.addRule(3, 2131362441);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramApolloBoxDataItem.topMargin = AIOUtils.a(9.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(49);
      this.jdField_d_of_type_AndroidWidgetTextView.setMaxLines(2);
      this.jdField_d_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      super.addView(this.jdField_d_of_type_AndroidWidgetTextView, paramApolloBoxDataItem);
    }
    label483:
    int k;
    int j;
    label597:
    Object localObject;
    if (this.jdField_c_of_type_Int == 1)
    {
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.getLayoutParams();
      paramApolloBoxDataItem.width = ((int)(paramInt2 * 0.535F));
      paramApolloBoxDataItem.height = ((int)(paramInt2 * 0.113F));
      paramApolloBoxDataItem.addRule(14);
      paramApolloBoxDataItem.addRule(12);
      paramApolloBoxDataItem.bottomMargin = ((int)(paramInt3 * 0.129F));
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      paramApolloBoxDataItem.width = ((int)(paramInt2 * 0.78F));
      paramApolloBoxDataItem.addRule(14);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
        paramApolloBoxDataItem.addRule(14);
        paramApolloBoxDataItem.addRule(10);
        paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.703F));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131362441);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
        super.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramApolloBoxDataItem);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_JavaLangString);
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(paramInt2 * 0.8F));
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 1) {
        break label1635;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("哎呀，拿到空卡了");
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.806F));
      if (this.jdField_c_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_c_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.addView(this.jdField_c_of_type_ComTencentImageURLImageView, paramApolloBoxDataItem);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 1) {
        break label1948;
      }
      paramApolloBoxDataItem = getContext().getResources().getDrawable(2130838025);
      k = paramApolloBoxDataItem.getIntrinsicWidth();
      j = paramApolloBoxDataItem.getIntrinsicHeight();
      if (this.jdField_c_of_type_Int != 2) {
        break label1881;
      }
      i = (int)(k * 0.55F);
      paramInt1 = (int)(j * 0.55F);
      localObject = new RelativeLayout.LayoutParams(i, paramInt1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.588F) - paramInt1 / 2);
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
      this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.addView(this.jdField_b_of_type_ComTencentImageURLImageView, paramApolloBoxDataItem);
      }
      paramInt1 = (int)(paramInt2 * 0.2F);
      i = (int)(paramInt2 * 0.252F);
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramApolloBoxDataItem.addRule(11);
      paramApolloBoxDataItem.addRule(10);
      paramApolloBoxDataItem.rightMargin = ((int)(0.103F * paramInt2));
      paramApolloBoxDataItem.topMargin = ((int)(0.074F * paramInt3));
      paramApolloBoxDataItem.width = paramInt1;
      paramApolloBoxDataItem.height = i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_JavaLangString)) {
        break label2474;
      }
      paramApolloBoxDataItem = ApolloImageDownloader.a(Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_JavaLangString), null, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_JavaLangString);
      label814:
      this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
        paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
        super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramApolloBoxDataItem);
      }
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramApolloBoxDataItem.addRule(14);
      paramApolloBoxDataItem.addRule(12);
      paramApolloBoxDataItem.bottomMargin = ((int)(paramInt3 * 0.073F));
      if (this.jdField_d_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_d_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_d_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_ComTencentImageURLImageView, paramApolloBoxDataItem);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        paramInt1 = (int)(paramInt2 * 0.15F);
        paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_d_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramApolloBoxDataItem.addRule(15);
        paramApolloBoxDataItem.addRule(9);
        paramApolloBoxDataItem.width = paramInt1;
        paramApolloBoxDataItem.height = paramInt1;
        this.jdField_d_of_type_ComTencentImageURLImageView.setBackgroundResource(2130838048);
        this.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        this.jdField_d_of_type_ComTencentImageURLImageView.setPadding(1, 1, 1, 1);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_JavaLangString)))
      {
        paramApolloBoxDataItem = URLDrawable.URLDrawableOptions.obtain();
        paramApolloBoxDataItem.mLoadingDrawable = ImageUtil.b();
        paramApolloBoxDataItem.mFailedDrawable = paramApolloBoxDataItem.mLoadingDrawable;
        localObject = new ApolloImageDownloader.ApolloDrawableExtraInfo();
        ((ApolloImageDownloader.ApolloDrawableExtraInfo)localObject).jdField_a_of_type_Int = ApolloImageDownloader.jdField_a_of_type_Int;
        paramApolloBoxDataItem.mExtraInfo = localObject;
        paramApolloBoxDataItem = ApolloImageDownloader.a(Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_JavaLangString), paramApolloBoxDataItem, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_JavaLangString);
        this.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramApolloBoxDataItem);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(paramInt2 * 0.5F));
        paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        paramApolloBoxDataItem.addRule(9);
        paramApolloBoxDataItem.addRule(10);
        paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.017F));
        paramApolloBoxDataItem.leftMargin = ((int)(paramInt2 * 0.2F));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, paramApolloBoxDataItem);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        paramApolloBoxDataItem.addRule(9);
        paramApolloBoxDataItem.addRule(10);
        paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.065F));
        paramApolloBoxDataItem.leftMargin = ((int)(paramInt2 * 0.2F));
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        super.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      }
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramApolloBoxDataItem.addRule(11);
      paramApolloBoxDataItem.addRule(10);
      paramApolloBoxDataItem.width = (paramInt3 * 130 / 760);
      paramApolloBoxDataItem.height = (paramInt3 * 142 / 760);
      paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.45F));
      paramApolloBoxDataItem.rightMargin = (paramInt3 * 25 / 760);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 1) {
        break label2651;
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label2639;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label1545:
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
      }
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label1635:
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int + "个金币");
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.697F));
        break label483;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int + "个厘米石");
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.697F));
        break label483;
      }
      paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.703F));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        break label483;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        break label483;
      }
      if (this.jdField_c_of_type_Int == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        break label483;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(8.0F);
      break label483;
      label1881:
      if (this.jdField_c_of_type_Int == 3)
      {
        i = (int)(k * 0.38F);
        paramInt1 = (int)(j * 0.38F);
        break label597;
      }
      paramInt1 = j;
      i = k;
      if (this.jdField_c_of_type_Int != 4) {
        break label597;
      }
      i = (int)(k * 0.28F);
      paramInt1 = (int)(j * 0.28F);
      break label597;
      label1948:
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 2)
      {
        paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_card_gold_icon.png", null, ApolloImageDownloader.a("apollo_card_gold_icon.png"));
        paramInt1 = (int)(paramInt3 * 0.38F);
        localObject = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.574F) - paramInt1 / 2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
        this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 3) {
          break label2151;
        }
        paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_card_crystal_image.png", null, ApolloImageDownloader.a("apollo_card_crystal_image.png"));
        paramApolloBoxDataItem.startDownload();
        paramInt1 = (int)(paramInt3 * 0.363F);
        localObject = new RelativeLayout.LayoutParams((int)(paramInt3 * 0.3F), paramInt1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.574F) - paramInt1 / 2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
        this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label2151:
    paramInt1 = (int)(paramInt2 * 0.488F);
    int i = (int)(paramInt3 * 0.531F);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Short == 3) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.h == 1))
    {
      paramInt1 = (int)(paramInt2 * 0.714F);
      i = (int)(paramInt3 * 0.497F);
    }
    for (;;)
    {
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramApolloBoxDataItem.addRule(12);
      paramApolloBoxDataItem.addRule(14);
      paramApolloBoxDataItem.width = paramInt1;
      paramApolloBoxDataItem.height = i;
      paramApolloBoxDataItem.bottomMargin = ((int)(paramInt3 * 0.373F));
      if ((3 == this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Short) || ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_JavaLangString.endsWith(".gif"))))
      {
        paramApolloBoxDataItem = URLDrawable.URLDrawableOptions.obtain();
        paramApolloBoxDataItem.mLoadingDrawable = URLDrawableHelper.a;
        paramApolloBoxDataItem.mFailedDrawable = URLDrawableHelper.a;
        paramApolloBoxDataItem.mExtraInfo = null;
        paramApolloBoxDataItem.mPlayGifImage = true;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_JavaLangString))
        {
          localObject = paramApolloBoxDataItem;
          if (paramApolloBoxDataItem == null) {
            localObject = URLDrawable.URLDrawableOptions.obtain();
          }
          if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.a;
          }
          if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.a;
          }
        }
        for (paramApolloBoxDataItem = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);; paramApolloBoxDataItem = ApolloImageDownloader.a("task_detail" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Short) + "_" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Int), paramApolloBoxDataItem, ApolloImageDownloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Int)))
        {
          this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
          break;
        }
        label2474:
        if ("A".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString))
        {
          paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_box_card_a_2016_09_20.png", null, ApolloImageDownloader.a("apollo_box_card_a_2016_09_20.png"));
          break label814;
        }
        if ("B".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString))
        {
          paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_box_card_b_2016_09_20.png", null, ApolloImageDownloader.a("apollo_box_card_b_2016_09_20.png"));
          break label814;
        }
        if ("C".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString))
        {
          paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_box_card_c_2016_09_20.png", null, ApolloImageDownloader.a("apollo_box_card_c_2016_09_20.png"));
          break label814;
        }
        if ("S".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString))
        {
          paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_box_card_s_2016_09_20.png", null, ApolloImageDownloader.a("apollo_box_card_s_2016_09_20.png"));
          break label814;
        }
        if ("V".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString))
        {
          paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_box_card_v_2017_11_03.png", null, ApolloImageDownloader.a("apollo_box_card_v_2017_11_03.png"));
          break label814;
          label2639:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1545;
          label2651:
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 3))
          {
            if (this.jdField_c_of_type_Int == 1) {
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                if (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) {
                  break label3395;
                }
                this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
                this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Int != 1)) {
                  break label3417;
                }
                this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                this.jdField_c_of_type_AndroidWidgetTextView.setText(TimeFormatterUtils.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_Long * 1000L));
                localObject = this.jdField_b_of_type_AndroidWidgetTextView;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_JavaLangString)) {
                  break label3406;
                }
                paramApolloBoxDataItem = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long);
                ((TextView)localObject).setText(paramApolloBoxDataItem);
                this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
                if (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) {
                  break label3440;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long) {
                  break label3429;
                }
                paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_self_stolen_got_2016_9_22.png", null, ApolloImageDownloader.a("apollo_self_stolen_got_2016_9_22.png"));
                this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView = new MultiURLImageView(getContext());
                  super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView);
                }
                paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.getLayoutParams();
                paramApolloBoxDataItem.addRule(11);
                paramApolloBoxDataItem.addRule(12);
                paramApolloBoxDataItem.rightMargin = (paramInt3 * 155 / 760);
                paramApolloBoxDataItem.bottomMargin = (paramInt3 * 320 / 760);
                paramApolloBoxDataItem = new ArrayList();
                localObject = new MultiURLImageView.ViewLayoutData();
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 46 / 760);
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 68 / 760);
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.FIT_END;
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 2) {
                  break label3465;
                }
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = "apollo_card_gold_add.png";
                label3038:
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_JavaLangString = ApolloImageDownloader.a(((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString);
                paramApolloBoxDataItem.add(localObject);
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int >= 10)
                {
                  paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int % 100 / 10;
                  localObject = new MultiURLImageView.ViewLayoutData();
                  if (paramInt1 != 1) {
                    break label3487;
                  }
                  ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 35 / 760);
                  ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
                  if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 2) {
                    break label3518;
                  }
                  ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_gold_" + paramInt1 + ".png");
                  label3170:
                  ((MultiURLImageView.ViewLayoutData)localObject).jdField_c_of_type_Int = (-paramInt3 * 4 / 760);
                  ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_JavaLangString = ApolloImageDownloader.a(((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString);
                  paramApolloBoxDataItem.add(localObject);
                }
                paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int % 10;
                localObject = new MultiURLImageView.ViewLayoutData();
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_c_of_type_Int = (-paramInt3 * 4 / 760);
                if (paramInt1 != 1) {
                  break label3563;
                }
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 35 / 760);
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 2) {
                  break label3594;
                }
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_gold_" + paramInt1 + ".png");
              }
            }
            for (;;)
            {
              ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_JavaLangString = ApolloImageDownloader.a(((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString);
              paramApolloBoxDataItem.add(localObject);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setOrientation(0);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setViewLayoutDatas(paramApolloBoxDataItem);
              if (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) {
                break label3639;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(0);
              return;
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
              break;
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              break;
              this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(4);
              break label2717;
              paramApolloBoxDataItem = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_JavaLangString;
              break label2821;
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              break label2827;
              label3429:
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
              break label2885;
              label3440:
              paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_other_stolen_got_2016_9_22.png", null, ApolloImageDownloader.a("apollo_other_stolen_got_2016_9_22.png"));
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
              break label2885;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 3) {
                break label3038;
              }
              ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = "apollo_card_crystal_add.png";
              break label3038;
              ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 55 / 760);
              ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
              break label3128;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 3) {
                break label3170;
              }
              ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_crystal_" + paramInt1 + ".png");
              break label3170;
              label3563:
              ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 55 / 760);
              ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
              break label3273;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 3) {
                ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_crystal_" + paramInt1 + ".png");
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
            return;
          }
          label2717:
          label2885:
          label3273:
          label3406:
          label3417:
          this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
          label2821:
          label2827:
          label3128:
          label3395:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          label3465:
          label3487:
          label3518:
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          label3594:
          label3639:
          this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long)
            {
              paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_self_stolen_got_2016_9_22.png", null, ApolloImageDownloader.a("apollo_self_stolen_got_2016_9_22.png"));
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
              if (this.jdField_c_of_type_Int == 1)
              {
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_Long);
                if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_JavaLangString)) {
                  break label3861;
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
                this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_JavaLangString);
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              label3834:
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null) {
                break label3986;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
              return;
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
              break;
              label3861:
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
              this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
          if (this.jdField_c_of_type_Int == 1)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            label3906:
            this.jdField_c_of_type_AndroidWidgetTextView.setText(TimeFormatterUtils.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_Long * 1000L));
            localObject = this.jdField_b_of_type_AndroidWidgetTextView;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_JavaLangString)) {
              break label4000;
            }
          }
          label3986:
          label4000:
          for (paramApolloBoxDataItem = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long);; paramApolloBoxDataItem = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_JavaLangString)
          {
            ((TextView)localObject).setText(paramApolloBoxDataItem);
            paramApolloBoxDataItem = ApolloImageDownloader.a("apollo_other_stolen_got_2016_9_22.png", null, ApolloImageDownloader.a("apollo_other_stolen_got_2016_9_22.png"));
            this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
            break label3834;
            break;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            break label3906;
          }
        }
        paramApolloBoxDataItem = null;
        break label814;
        paramApolloBoxDataItem = null;
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis();
    int i = paramCanvas.saveLayer(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, null, 1);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 3)) {
        break label407;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) {
        break label288;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPath != null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(654311423);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 0))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_Int == -1) {
        break label446;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_Int);
      label200:
      if (this.jdField_c_of_type_Int != 1) {
        break label459;
      }
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int * 0.78F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      super.drawChild(paramCanvas, this.jdField_a_of_type_ComTencentImageURLImageView, getDrawingTime());
      paramCanvas.restoreToCount(i);
      if (QLog.isColorLevel()) {
        QLog.e("ApolloCardWindow", 2, "ApolloCardLayout onDraw use" + (System.currentTimeMillis() - l));
      }
      return;
      label288:
      super.drawChild(paramCanvas, this.jdField_c_of_type_ComTencentImageURLImageView, getDrawingTime());
      super.drawChild(paramCanvas, this.jdField_a_of_type_AndroidWidgetTextView, getDrawingTime());
      super.drawChild(paramCanvas, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView, getDrawingTime());
      if (this.jdField_b_of_type_AndroidGraphicsPath != null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1778384896);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_c_of_type_AndroidGraphicsPath == null) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.drawPath(this.jdField_c_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
      label407:
      if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
      label446:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1728053248);
      break label200;
      label459:
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      }
      paramInt1 = (int)(this.jdField_a_of_type_Int * 0.037F);
      paramInt2 = (int)(this.jdField_a_of_type_Int * 0.047F);
      paramInt3 = (int)(this.jdField_b_of_type_Int * 0.026F);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramInt2 + paramInt1, this.jdField_b_of_type_Int - paramInt3);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(paramInt2, this.jdField_b_of_type_Int - paramInt1 * 2 - paramInt3, paramInt1 * 2 + paramInt2, this.jdField_b_of_type_Int - paramInt3), 90.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(paramInt2, paramInt3, paramInt1 * 2 + paramInt2, paramInt1 * 2 + paramInt3), 180.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - paramInt1 * 2 - paramInt2, paramInt3, this.jdField_a_of_type_Int - paramInt2, paramInt1 * 2 + paramInt3), -90.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - paramInt1 * 2 - paramInt2, this.jdField_b_of_type_Int - paramInt1 * 2 - paramInt3, this.jdField_a_of_type_Int - paramInt2, this.jdField_b_of_type_Int - paramInt3), 0.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      if (this.jdField_b_of_type_AndroidGraphicsPath == null) {
        this.jdField_b_of_type_AndroidGraphicsPath = new Path();
      }
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      paramInt4 = (int)(this.jdField_b_of_type_Int * 0.78F);
      this.jdField_b_of_type_AndroidGraphicsPath.moveTo(paramInt2, paramInt4);
      this.jdField_b_of_type_AndroidGraphicsPath.arcTo(new RectF(paramInt2, paramInt3, paramInt1 * 2 + paramInt2, paramInt1 * 2 + paramInt3), 180.0F, 90.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - paramInt1 * 2 - paramInt2, paramInt3, this.jdField_a_of_type_Int - paramInt2, paramInt1 * 2 + paramInt3), -90.0F, 90.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int - paramInt2, paramInt4);
      this.jdField_b_of_type_AndroidGraphicsPath.close();
      if (this.jdField_c_of_type_AndroidGraphicsPath == null) {
        this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      }
      this.jdField_c_of_type_AndroidGraphicsPath.reset();
      this.jdField_c_of_type_AndroidGraphicsPath.moveTo(paramInt2 + paramInt1, this.jdField_b_of_type_Int - paramInt3);
      this.jdField_c_of_type_AndroidGraphicsPath.arcTo(new RectF(paramInt2, this.jdField_b_of_type_Int - paramInt1 * 2 - paramInt3, paramInt1 * 2 + paramInt2, this.jdField_b_of_type_Int - paramInt3), 90.0F, 90.0F);
      this.jdField_c_of_type_AndroidGraphicsPath.lineTo(paramInt2, paramInt4);
      this.jdField_c_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int - paramInt2, paramInt4);
      this.jdField_c_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - paramInt1 * 2 - paramInt2, this.jdField_b_of_type_Int - paramInt1 * 2 - paramInt3, this.jdField_a_of_type_Int - paramInt2, this.jdField_b_of_type_Int - paramInt3), 0.0F, 90.0F);
      this.jdField_c_of_type_AndroidGraphicsPath.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardLayout
 * JD-Core Version:    0.7.0.1
 */