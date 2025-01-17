package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankw;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.ComboLockManager;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.List;

public class ComboProviderGridAdapter
  extends BaseAdapter
  implements Handler.Callback
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  public GridView a;
  List jdField_a_of_type_JavaUtilList;
  float b;
  float c;
  
  public ComboProviderGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject2).setId(2131362719);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131369931);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject2).setImageResource(2130841751);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject2).setId(2131362486);
    ((LinearLayout)localObject2).setOrientation(0);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject3).setImageResource(2130841752);
    Object localObject4 = new LinearLayout.LayoutParams(ViewUtils.b(11.0F), ViewUtils.b(4.5F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setId(2131362485);
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492969));
    ((TextView)localObject3).setMaxLines(1);
    ((TextView)localObject3).setLines(1);
    ((TextView)localObject3).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    localObject4 = new LinearLayout.LayoutParams(-2, -2);
    i = ViewUtils.b(5.0F);
    ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
    ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject3).setImageResource(2130841752);
    localObject4 = new LinearLayout.LayoutParams(ViewUtils.b(11.0F), ViewUtils.b(4.5F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131369934);
    ((RelativeLayout)localObject2).setBackgroundResource(2130841879);
    ((RelativeLayout)localObject2).setVisibility(8);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ViewUtils.b(16.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841880), null);
    ((TextView)localObject3).setCompoundDrawablePadding(ViewUtils.b(4.0F));
    ((TextView)localObject3).setText("详情");
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492969));
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131369932);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492969));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ViewUtils.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131369066);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131363403);
    ((ImageView)localObject1).setImageResource(2130843189);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131369936);
    ((ImageView)localObject1).setImageResource(2130843196);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public static void a(ImageView paramImageView, CaptureComboBase paramCaptureComboBase, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    boolean bool1 = VideoFilterTools.a().a(3, paramQIMFilterCategoryItem.jdField_a_of_type_Int, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    int i = paramCaptureComboBase.jdField_a_of_type_Int;
    boolean bool2 = ((CaptureComboManager)QIMManager.a(5)).a().a(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    if ((bool2) || (paramQIMFilterCategoryItem.jdField_a_of_type_Boolean) || (bool1))
    {
      paramImageView.setVisibility(0);
      if (bool2)
      {
        paramImageView.setImageResource(2130841956);
        return;
      }
      if (bool1)
      {
        paramImageView.setImageResource(2130843190);
        return;
      }
      switch (i)
      {
      default: 
        return;
      case 1: 
      case 3: 
        paramImageView.setVisibility(8);
        return;
      }
      paramImageView.setImageResource(2130843189);
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 600L);
  }
  
  public void a(int paramInt)
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a().a;
    if ((localQIMFilterCategoryItem != null) && (localQIMFilterCategoryItem.jdField_a_of_type_Int == paramInt)) {
      a();
    }
  }
  
  public void a(ImageView paramImageView, AnimationDrawable paramAnimationDrawable, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterComboShare", 2, "showUnlockAnimation ");
    }
    ImageView localImageView = new ImageView(paramImageView.getContext());
    PopupWindow localPopupWindow = new PopupWindow(localImageView, -2, -2, true);
    localPopupWindow.setTouchable(true);
    localPopupWindow.setClippingEnabled(false);
    localPopupWindow.setOutsideTouchable(true);
    localPopupWindow.setBackgroundDrawable(new ColorDrawable(16777215));
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationOnScreen(arrayOfInt);
    if (QLog.isColorLevel()) {
      QLog.i("FilterComboShare", 2, "showUnlockAnimation " + arrayOfInt[0] + "," + arrayOfInt[1]);
    }
    int i = ScreenUtil.a(60.0F) - paramImageView.getWidth();
    localPopupWindow.showAtLocation(paramImageView, 8388659, arrayOfInt[0] - i / 2, arrayOfInt[1] - i / 2);
    paramAnimationDrawable.setOneShot(true);
    paramAnimationDrawable = new ComboProviderGridAdapter.LockAnimationDrawable(paramAnimationDrawable, localImageView, localPopupWindow, paramImageView, paramQIMFilterCategoryItem);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ankw(this, paramImageView), 200L);
    localImageView.setImageDrawable(paramAnimationDrawable);
    paramAnimationDrawable.start();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Float <= 0.0F) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Float = paramViewGroup.getMeasuredWidth();
      this.b = ((this.jdField_a_of_type_Float - FilterProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4.0F + 0.5F);
      this.c = (12.0F * this.b / 160.0F);
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = a();
    }
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131369932);
    ImageView localImageView3 = (ImageView)paramViewGroup.findViewById(2131369931);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(2131362719);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131363403);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131362485);
    View localView = paramViewGroup.findViewById(2131362486);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramViewGroup.findViewById(2131369066);
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    paramView = VideoFilterTools.a().a[this.jdField_a_of_type_Int];
    if (paramView != null) {}
    for (paramView = (QIMFilterCategoryItem)paramView.a;; paramView = null)
    {
      boolean bool = false;
      if (paramView != null) {
        bool = TextUtils.equals(paramView.jdField_a_of_type_JavaLangString, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
      }
      if (!bool) {
        if (((paramView == null) || (paramView.b())) && (localQIMFilterCategoryItem.b())) {
          bool = true;
        }
      }
      for (;;)
      {
        paramViewGroup.setTag(localQIMFilterCategoryItem);
        Object localObject = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
        paramView = (View)localObject;
        if (localObject == null)
        {
          paramView = new AbsListView.LayoutParams(-1, -1);
          paramViewGroup.setLayoutParams(paramView);
        }
        paramView.height = ((int)this.b);
        if (localQIMFilterCategoryItem.b())
        {
          localImageView3.setVisibility(8);
          if (bool)
          {
            localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841754));
            label337:
            localImageView2.setVisibility(8);
            localTextView1.setVisibility(0);
            localTextView1.setText("原图");
            localView.setVisibility(8);
          }
        }
        for (;;)
        {
          if ((localCaptureComboManager.a().a != null) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(9))) {}
          QLog.i("harlangetview", 2, "getview " + paramInt);
          return paramViewGroup;
          bool = false;
          break;
          localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841755));
          break label337;
          localTextView1.setVisibility(8);
          paramView = localCaptureComboManager.a(localQIMFilterCategoryItem);
          if (!TextUtils.isEmpty(localQIMFilterCategoryItem.b))
          {
            localView.setVisibility(0);
            localTextView2.setText(localQIMFilterCategoryItem.b);
            label486:
            if (!bool) {
              break label678;
            }
            localImageView3.setImageResource(2130841753);
            localImageView3.setVisibility(0);
            localTextView1.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492976));
          }
          for (;;)
          {
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841750);
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841750);
            ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
            localQIMCommonLoadingView.setMax(10000);
            localObject = URLDrawable.getDrawable(localQIMFilterCategoryItem.c, (URLDrawable.URLDrawableOptions)localObject);
            if (((URLDrawable)localObject).getStatus() == 2) {
              ((URLDrawable)localObject).restartDownload();
            }
            localImageView1.setImageDrawable((Drawable)localObject);
            localTextView1.setText(localQIMFilterCategoryItem.b);
            if (!localQIMFilterCategoryItem.d()) {
              break label710;
            }
            localImageView2.setVisibility(8);
            ((ImageView)paramViewGroup.findViewById(2131369936)).setVisibility(0);
            WeishiGuideUtils.a(localQIMFilterCategoryItem);
            break;
            localTextView2.setText("");
            localView.setVisibility(8);
            break label486;
            label678:
            localImageView3.setVisibility(8);
            localTextView1.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492976));
          }
          label710:
          localQIMCommonLoadingView.setVisibility(0);
          localQIMCommonLoadingView.setCorner(this.c);
          localQIMCommonLoadingView.a(QIMCommonLoadingProgress.a(paramView));
          a(localImageView2, paramView, localQIMFilterCategoryItem);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetGridView == null) || (!this.jdField_a_of_type_ComTencentWidgetGridView.isShown()))
      {
        QLog.i("ComboLockManager", 1, "checkAnim err, ignore");
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "checkAnim");
      }
      int j = this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount();
      paramMessage = (CaptureComboManager)QIMManager.a(5);
      QIMFilterCategoryItem localQIMFilterCategoryItem = paramMessage.a().a;
      int i;
      if (localQIMFilterCategoryItem != null) {
        i = 0;
      }
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (i < j)
        {
          localObject1 = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i);
          localObject2 = ((View)localObject1).getTag();
          if ((!QIMFilterCategoryItem.class.isInstance(localObject2)) || (!((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaLangString.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString))) {}
        }
        else
        {
          try
          {
            localObject1 = (ImageView)((View)localObject1).findViewById(2131363403);
            localObject2 = (AnimationDrawable)((ImageView)localObject1).getContext().getResources().getDrawable(2130842076);
            paramMessage.a().a = null;
            a((ImageView)localObject1, (AnimationDrawable)localObject2, localQIMFilterCategoryItem);
            return true;
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("FilterComboShare", 2, "showUnlockAnimation err", paramMessage);
              }
            }
          }
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.ComboProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */