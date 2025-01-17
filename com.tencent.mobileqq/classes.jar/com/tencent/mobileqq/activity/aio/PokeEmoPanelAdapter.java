package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEItemData;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleImageView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleLinearLayout;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PokeEmoPanelAdapter
  extends BaseAdapter
{
  private float jdField_a_of_type_Float = 1.25F;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public PokeEmoPanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839554);
  }
  
  private int a()
  {
    return 4;
  }
  
  public Drawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    return URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = a();
      return (this.jdField_a_of_type_JavaUtilArrayList.size() + i - 1) / i;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = a();
    int i = (XPanelContainer.jdField_a_of_type_Int - AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) - AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2) / 3;
    int j;
    if (i >= 0)
    {
      j = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (i >= j) {
        break label592;
      }
      i = j;
    }
    label419:
    label571:
    label580:
    label592:
    for (;;)
    {
      int m = (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4) / 8;
      Object localObject1;
      Object localObject2;
      if (paramView == null)
      {
        paramViewGroup = new StickerBubbleLinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setMinimumHeight(AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + i);
        paramViewGroup.setOrientation(0);
        j = 0;
        for (;;)
        {
          paramView = paramViewGroup;
          if (j >= k) {
            break;
          }
          paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setGravity(17);
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          if (j == 0) {
            ((LinearLayout.LayoutParams)localObject1).leftMargin = m;
          }
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          localObject1 = new LinearLayout.LayoutParams(AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).topMargin = (i / 2);
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = (i / 2);
          localObject2 = new StickerBubbleImageView(this.jdField_a_of_type_AndroidContentContext);
          ((View)localObject2).setPadding(14, 14, 14, 14);
          int n = AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int i1 = AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
          localShapeDrawable.setIntrinsicHeight(n);
          localShapeDrawable.setIntrinsicWidth(i1);
          localShapeDrawable.getPaint().setColor(1728053247);
          ((View)localObject2).setBackgroundDrawable(localShapeDrawable);
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramView.addView((View)localObject2);
          paramViewGroup.addView(paramView);
          j += 1;
        }
        i = 0;
        break;
      }
      paramViewGroup = (ViewGroup)paramView;
      if (paramInt == 0)
      {
        paramViewGroup.setPadding(0, i / 2, 0, 0);
        i = 0;
        if (i >= k) {
          break label580;
        }
        j = k * paramInt + i;
        localObject1 = ((ViewGroup)paramViewGroup.getChildAt(i)).getChildAt(0);
        if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label571;
        }
        ((View)localObject1).setVisibility(0);
        localObject2 = (PEItemData)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localObject2 != null) {
          ((ImageView)localObject1).setImageDrawable(a(((PEItemData)localObject2).jdField_a_of_type_JavaLangString));
        }
        ((View)localObject1).setTag(Integer.valueOf(j));
        if (AppSetting.b) {
          ((View)localObject1).setContentDescription("双击或者长按来发送轻互动表情" + PEPanelHelper.a(((PEItemData)localObject2).jdField_a_of_type_Int));
        }
      }
      for (;;)
      {
        i += 1;
        break label419;
        paramViewGroup.setPadding(0, 0, 0, 0);
        break;
        ((View)localObject1).setVisibility(4);
      }
      paramView.setOnLongClickListener(null);
      AccessibilityUtil.a(paramView, false);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokeEmoPanelAdapter
 * JD-Core Version:    0.7.0.1
 */