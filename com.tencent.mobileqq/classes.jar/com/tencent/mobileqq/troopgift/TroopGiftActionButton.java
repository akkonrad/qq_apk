package com.tencent.mobileqq.troopgift;

import ajuq;
import ajut;
import ajuv;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import org.json.JSONObject;

public class TroopGiftActionButton
  extends RelativeLayout
{
  private ajuv jdField_a_of_type_Ajuv;
  public AnimationDrawable a;
  public Handler a;
  public View.OnClickListener a;
  public ImageView a;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public TroopGiftActionButton(Context paramContext, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Ajuv = new ajuv(this, getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a(getContext(), 68.0F), DisplayUtil.a(getContext(), 68.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(getContext(), 53.5F);
    addView(this.jdField_a_of_type_Ajuv, (ViewGroup.LayoutParams)localObject1);
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(1);
    ((GradientDrawable)localObject2).setCornerRadius(DisplayUtil.a(getContext(), 56.0F));
    ((GradientDrawable)localObject2).setColor(Color.parseColor(this.jdField_a_of_type_OrgJsonJSONObject.optString("buttonColor")));
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setText(this.jdField_a_of_type_OrgJsonJSONObject.optString("buttonText"));
    ((TextView)localObject1).setTextColor(Color.parseColor(this.jdField_a_of_type_OrgJsonJSONObject.optString("buttonTextColor")));
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.a(getContext(), 56.0F), DisplayUtil.a(getContext(), 56.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.a(getContext(), 59.5F);
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((TextView)localObject1).setOnTouchListener(new ajuq(this, (TextView)localObject1));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ajut(this, paramString));
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_Ajuv.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftActionButton
 * JD-Core Version:    0.7.0.1
 */