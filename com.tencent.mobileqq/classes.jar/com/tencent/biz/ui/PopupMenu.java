package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.List;
import ozx;

public class PopupMenu
  extends PopupWindows
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public CustomMenuBar.OnMenuItemClickListener a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public PopupMenu(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    a(2130968982);
    this.b = 4;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramInt3 > paramInt1)
    {
      if (paramInt3 > paramInt2 * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 - i / 2);
        return;
      }
      if (paramInt3 > (paramInt4 - paramInt2) * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 + paramInt3 - paramInt4 - i / 2);
        return;
      }
      localLayoutParams.addRule(14);
      return;
    }
    localLayoutParams.addRule(14);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (this.b)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131624142);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131364578));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364579));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    super.b(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(View paramView)
  {
    a();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    this.jdField_a_of_type_AndroidViewView.measure(-2, -2);
    int i = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int k = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getWidth();
    int m = arrayOfInt[0];
    int n = (paramView.getWidth() - i) / 2;
    int i1 = localRect.top;
    a(paramView.getWidth(), localRect.centerX(), i, k);
    a(k, localRect.centerX(), true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, m + n, i1 - j - 10);
  }
  
  public void a(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void a(MenuItem paramMenuItem)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
    String str = paramMenuItem.a();
    Drawable localDrawable = paramMenuItem.a();
    if (this.jdField_a_of_type_Int != 0)
    {
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject1).setBackgroundResource(2130838911);
      localObject2 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      ((LinearLayout.LayoutParams)localObject2).setMargins(AIOUtils.a(15.0F, ((ImageView)localObject1).getResources()), 0, AIOUtils.a(15.0F, ((ImageView)localObject1).getResources()), 0);
      this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968981, null);
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131364574);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131364575);
    if (localDrawable != null)
    {
      ((ImageView)localObject2).setImageDrawable(localDrawable);
      if (str == null) {
        break label267;
      }
      if (SubString.a(str) <= 18) {
        break label258;
      }
      localTextView.setText(SubString.a(str, 18, "..."));
    }
    for (;;)
    {
      ((View)localObject1).setOnClickListener(new ozx(this, paramMenuItem.b(), paramMenuItem.a()));
      ((View)localObject1).setFocusable(true);
      ((View)localObject1).setClickable(true);
      paramMenuItem = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      paramMenuItem.gravity = 17;
      ((View)localObject1).setLayoutParams(paramMenuItem);
      this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1);
      this.jdField_a_of_type_Int += 1;
      return;
      ((ImageView)localObject2).setVisibility(8);
      break;
      label258:
      localTextView.setText(str);
      continue;
      label267:
      localTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.PopupMenu
 * JD-Core Version:    0.7.0.1
 */