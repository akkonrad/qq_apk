package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPostContentEntity;
import com.tencent.mobileqq.data.TroopBarPostEntity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import gzo;

public class TroopBarPostLayout2
  extends TroopBarPostAbsLayout
  implements View.OnClickListener
{
  protected static final int a = 2130903404;
  public static final int b = -1710619;
  
  public View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity)
  {
    gzo localgzo;
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130903404, null);
      localgzo = (gzo)a(paramView);
      paramView.setTag(localgzo);
    }
    for (;;)
    {
      paramTroopBarAbsDataEntity = (TroopBarPostEntity)paramTroopBarAbsDataEntity;
      localgzo.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopBarAbsDataEntity.title);
      paramActivity = paramActivity.getResources();
      TroopBarUtils.a(paramActivity, paramLayoutInflater, localgzo.jdField_b_of_type_AndroidWidgetLinearLayout, paramTroopBarAbsDataEntity.getIconListEntitys());
      ColorDrawable localColorDrawable;
      if (paramTroopBarAbsDataEntity.contentBytes != null)
      {
        paramLayoutInflater = paramTroopBarAbsDataEntity.getContentEntity();
        localColorDrawable = new ColorDrawable(-1710619);
        if (TextUtils.isEmpty(paramLayoutInflater.image1)) {
          break label298;
        }
      }
      try
      {
        localgzo.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(paramLayoutInflater.image1, localColorDrawable, localColorDrawable));
        label122:
        if (!TextUtils.isEmpty(paramTroopBarAbsDataEntity.subscript_addr)) {}
        try
        {
          localgzo.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
          localgzo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(TroopBarPageEntity.sPostCornerImgPrefix + paramTroopBarAbsDataEntity.subscript_addr, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
          label188:
          localgzo.jdField_b_of_type_AndroidWidgetTextView.setText(paramTroopBarAbsDataEntity.brief);
          paramLayoutInflater = paramActivity.getString(2131560693, new Object[] { TroopBarUtils.a(paramTroopBarAbsDataEntity.subscribers) });
          paramActivity = paramActivity.getString(2131560692, new Object[] { TroopBarUtils.a(paramTroopBarAbsDataEntity.total_comment) });
          localgzo.c.setText(paramLayoutInflater);
          localgzo.d.setText(paramActivity);
          localgzo.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131230861, paramTroopBarAbsDataEntity);
          localgzo.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          return paramView;
          localgzo = (gzo)paramView.getTag();
          continue;
          label298:
          localgzo.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localColorDrawable);
        }
        catch (Exception paramLayoutInflater)
        {
          break label188;
        }
      }
      catch (Exception paramLayoutInflater)
      {
        break label122;
      }
    }
  }
  
  public TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView)
  {
    return new gzo(this, paramView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Context localContext;
    do
    {
      return;
      localContext = paramView.getContext();
      paramView = paramView.getTag(2131230861);
    } while ((localContext == null) || (!(paramView instanceof TroopBarPostEntity)));
    paramView = (TroopBarPostEntity)paramView;
    TroopBarPostLayout1.a(localContext, paramView.bid, paramView.id, paramView.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayout2
 * JD-Core Version:    0.7.0.1
 */