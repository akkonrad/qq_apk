package com.tencent.mobileqq.emoticonview;

import acdr;
import acds;
import acdt;
import acdu;
import acdv;
import acdw;
import acdx;
import acdy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.model.CommercialDrainageManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class BigEmotionDownloadedAdapter
  extends BaseEmotionAdapter
{
  public ColorDrawable a;
  public Drawable a;
  public URLDrawable.URLDrawableListener a;
  private BaseChatPie a;
  public EmoticonPackage a;
  private int f;
  
  public BigEmotionDownloadedAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new acdy(this);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.f = paramInt4;
    ThreadManager.post(new acdr(this, paramContext), 8, null, true);
  }
  
  private View a(VipIPSiteInfo paramVipIPSiteInfo)
  {
    if (paramVipIPSiteInfo != null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-1513240);
      }
      int i;
      String str3;
      Object localObject5;
      Object localObject4;
      Object localObject3;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      String str2;
      try
      {
        i = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
        String str1 = "";
        switch (i)
        {
        default: 
          str3 = "";
        }
        try
        {
          i = paramVipIPSiteInfo.ipID;
          str3 = String.valueOf(i);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject1;
            RelativeLayout localRelativeLayout;
            ImageView localImageView;
            QLog.e("BigEmotionDownloadedAdapter", 1, "fillIPSiteViewPagerMode ipId error = " + localException2);
            continue;
            ((TextView)localObject10).setText("漫画");
            localImageView.setVisibility(8);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((TextView)localObject7).setMaxWidth(AIOUtils.a(126.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((TextView)localObject8).setMaxWidth(AIOUtils.a(126.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            continue;
            ((TextView)localObject10).setText("动画");
            localImageView.setVisibility(0);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((TextView)localObject7).setMaxWidth(AIOUtils.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((TextView)localObject8).setMaxWidth(AIOUtils.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_comicshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject4;
        }
        localObject5 = new acdt(this, paramVipIPSiteInfo, str1, str3);
        localObject1 = paramVipIPSiteInfo.strType;
        if ("comic".equals(localObject1))
        {
          localObject4 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968972, null, false);
          localObject1 = (TextView)((View)localObject4).findViewById(2131364523);
          localObject3 = (TextView)((View)localObject4).findViewById(2131364525);
          ((RelativeLayout)((View)localObject4).findViewById(2131364547)).setOnClickListener((View.OnClickListener)localObject5);
          localObject5 = (RelativeLayout)((View)localObject4).findViewById(2131364548);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131364550);
          localObject7 = (TextView)((View)localObject4).findViewById(2131364553);
          localObject8 = (TextView)((View)localObject4).findViewById(2131364555);
          localObject9 = (Button)((View)localObject4).findViewById(2131364556);
          localObject10 = (TextView)((View)localObject4).findViewById(2131364554);
          localRelativeLayout = (RelativeLayout)((View)localObject4).findViewById(2131364549);
          localImageView = (ImageView)((View)localObject4).findViewById(2131364551);
          ((TextView)localObject1).setText(paramVipIPSiteInfo.ipName + "作品站");
          ((TextView)localObject3).setText(VasUtils.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject1 = paramVipIPSiteInfo.ipList.get(i);
              IPSiteModel.Comic localComic;
              acdu localacdu;
              if ((localObject1 instanceof IPSiteModel.Comic))
              {
                localComic = (IPSiteModel.Comic)localObject1;
                localacdu = new acdu(this, localComic, str1, str3);
                localObject1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
              }
              switch (localComic.comicType)
              {
              default: 
                ((ImageView)localObject6).setImageDrawable(VasUtils.a(localComic.cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject7).setText(localComic.name);
                ((TextView)localObject8).setText(localComic.desc);
                ((Button)localObject9).setOnClickListener(localacdu);
                ((RelativeLayout)localObject5).setOnClickListener(localacdu);
                i += 1;
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i = 0;
          continue;
          str2 = "2G";
          continue;
          str2 = "3G";
          continue;
          str2 = "4G";
          continue;
          str2 = "wifi";
        }
      }
      for (;;)
      {
        if (paramVipIPSiteInfo != null) {
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_entershow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
        }
        return paramVipIPSiteInfo;
        Object localObject2;
        if ("game".equals(localException2))
        {
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968970, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131364523);
          localObject9 = (TextView)((View)localObject2).findViewById(2131364525);
          ((RelativeLayout)((View)localObject2).findViewById(2131364529)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131364530);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131364531);
          localObject5 = (TextView)((View)localObject2).findViewById(2131364534);
          localObject6 = (TextView)((View)localObject2).findViewById(2131364536);
          localObject7 = (Button)((View)localObject2).findViewById(2131364537);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + "作品站");
          ((TextView)localObject9).setText(VasUtils.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Game))
              {
                localObject8 = (IPSiteModel.Game)localObject8;
                localObject9 = new acdv(this, (IPSiteModel.Game)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(VasUtils.a(((IPSiteModel.Game)localObject8).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject5).setText(((IPSiteModel.Game)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Game)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_gameshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("goods".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968969, null, false);
          localObject3 = (TextView)((View)localObject2).findViewById(2131364523);
          localObject4 = (TextView)((View)localObject2).findViewById(2131364525);
          ((RelativeLayout)((View)localObject2).findViewById(2131364527)).setOnClickListener((View.OnClickListener)localObject5);
          ((TextView)localObject3).setText(paramVipIPSiteInfo.ipName + "作品站");
          ((TextView)localObject4).setText(VasUtils.a(paramVipIPSiteInfo.ipContent));
          localObject3 = (HorizontalListView)((View)localObject2).findViewById(2131364528);
          if (paramVipIPSiteInfo.ipList != null)
          {
            paramVipIPSiteInfo = new IPSiteListGoodsAdapter(this.jdField_a_of_type_AndroidContentContext, paramVipIPSiteInfo.ipList, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), str3, str2);
            ((HorizontalListView)localObject3).setDividerWidth(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((HorizontalListView)localObject3).setAdapter(paramVipIPSiteInfo);
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_productshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("video".equals(localObject2))
        {
          localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968971, null, false);
          localObject2 = (TextView)((View)localObject3).findViewById(2131364523);
          localObject9 = (TextView)((View)localObject3).findViewById(2131364525);
          ((RelativeLayout)((View)localObject3).findViewById(2131364538)).setOnClickListener((View.OnClickListener)localObject5);
          localObject4 = (RelativeLayout)((View)localObject3).findViewById(2131364539);
          localObject5 = (ImageView)((View)localObject3).findViewById(2131364541);
          localObject6 = (TextView)((View)localObject3).findViewById(2131364543);
          localObject7 = (TextView)((View)localObject3).findViewById(2131364545);
          localObject8 = (Button)((View)localObject3).findViewById(2131364546);
          ((TextView)localObject2).setText(paramVipIPSiteInfo.ipName + "作品站");
          ((TextView)localObject9).setText(VasUtils.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            if (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject2 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject2 instanceof IPSiteModel.Video))
              {
                localObject9 = (IPSiteModel.Video)localObject2;
                localObject10 = new acdw(this, (IPSiteModel.Video)localObject9, str2, str3);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).buttonDesc)) {
                  break label1845;
                }
                localObject2 = "去购票";
                label1713:
                ((ImageView)localObject5).setImageDrawable(VasUtils.a(((IPSiteModel.Video)localObject9).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject6).setText(((IPSiteModel.Video)localObject9).name);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).showDate)) {
                  break label1855;
                }
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).desc);
                label1765:
                ((Button)localObject8).setText((CharSequence)localObject2);
                if (!((String)localObject2).equals("去购票")) {
                  break label1887;
                }
                j = 2130838894;
                label1787:
                ((Button)localObject8).setBackgroundResource(j);
                if (!((String)localObject2).equals("去购票")) {
                  break label1894;
                }
              }
              label1845:
              label1855:
              label1887:
              label1894:
              for (int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492894);; j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492879))
              {
                ((Button)localObject8).setTextColor(j);
                ((Button)localObject8).setOnClickListener((View.OnClickListener)localObject10);
                ((RelativeLayout)localObject4).setOnClickListener((View.OnClickListener)localObject10);
                i += 1;
                break;
                localObject2 = ((IPSiteModel.Video)localObject9).buttonDesc;
                break label1713;
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).showDate + "上映");
                break label1765;
                j = 2130838893;
                break label1787;
              }
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_movieshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject3;
        }
        else if ("book".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968973, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131364523);
          localObject9 = (TextView)((View)localObject2).findViewById(2131364525);
          ((RelativeLayout)((View)localObject2).findViewById(2131364557)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131364558);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131364559);
          localObject5 = (TextView)((View)localObject2).findViewById(2131364561);
          localObject6 = (TextView)((View)localObject2).findViewById(2131364563);
          localObject7 = (Button)((View)localObject2).findViewById(2131364564);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + "作品站");
          ((TextView)localObject9).setText(VasUtils.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Book))
              {
                localObject8 = (IPSiteModel.Book)localObject8;
                localObject9 = new acdx(this, (IPSiteModel.Book)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(VasUtils.a(((IPSiteModel.Book)localObject8).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject5).setText(((IPSiteModel.Book)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Book)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_bookshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else
        {
          paramVipIPSiteInfo = null;
        }
      }
    }
    return null;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (BigEmotionDownloadedAdapter.BigEmotionHolder)paramViewHolder;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label1032;
      }
      paramView = EmotionPanelViewPool.a().a(this.c);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.f);
        paramView.setPanelType(EmoticonPanelLinearLayout.b);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        if (paramInt == 0) {
          paramView.setPadding(0, (int)(16.0F * this.jdField_a_of_type_Float), 0, 0);
        }
        for (;;)
        {
          i = 0;
          for (;;)
          {
            paramViewHolder = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramViewHolder = super.a();
            paramViewHolder.setVisibility(8);
            paramViewHolder.setFocusable(true);
            paramViewHolder.setFocusableInTouchMode(true);
            paramView.addView(paramViewHolder);
            i += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      a(this.c, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(localObject1);
    }
    for (;;)
    {
      i = 0;
      if (i < this.jdField_a_of_type_Int)
      {
        int j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localObject1.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setTag(null);
          localObject1.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = localObject1.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i];
          paramViewGroup = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(j);
          long l2 = System.currentTimeMillis();
          super.a(paramView, paramViewGroup);
          if (QLog.isColorLevel()) {
            QLog.d("BigEmotionDownloadedAdapter", 2, "updateUi cost = " + (System.currentTimeMillis() - l2));
          }
        }
      }
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView cost = " + (System.currentTimeMillis() - l1));
        }
        return paramViewHolder;
        paramViewHolder = paramView;
      } while (paramView != null);
      paramViewGroup = (CommercialDrainageManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
      Object localObject2 = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfo;
      if ((paramViewHolder == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes.length > 0)) {
        paramViewHolder = ((EmoticonManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes);
      }
      for (;;)
      {
        if (paramViewGroup != null) {}
        for (boolean bool = paramViewGroup.a(paramViewHolder);; bool = false)
        {
          if (bool)
          {
            paramViewGroup = a(paramViewHolder);
            paramViewHolder = paramView;
            if (paramViewGroup == null) {
              break;
            }
            paramViewGroup.setTag(localObject1);
            paramViewHolder = paramViewGroup;
            break;
          }
          paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(46.0F * this.jdField_a_of_type_Float)));
          localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
          paramViewHolder.addRule(13, -1);
          ((LinearLayout)localObject2).setLayoutParams(paramViewHolder);
          paramViewGroup = EmoticonRecDressup.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true);
          Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout)localObject2).setOrientation(0);
          ((LinearLayout.LayoutParams)localObject3).gravity = 16;
          TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          localTextView.setTextSize(14.0F);
          if (paramViewGroup.a)
          {
            paramViewHolder = "查看更多相关装扮";
            label790:
            localTextView.setText(paramViewHolder);
            localTextView.setTextColor(-8947849);
            ((LinearLayout)localObject2).addView(localTextView, (ViewGroup.LayoutParams)localObject3);
            paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
            paramViewHolder.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
            paramViewHolder.gravity = 16;
            localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject3).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843961));
            ((LinearLayout)localObject2).addView((View)localObject3, paramViewHolder);
            paramView.addView((View)localObject2);
            ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject2);
            ((BigEmotionDownloadedAdapter.BigEmotionHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new acds(this, paramViewGroup));
            paramView.setTag(localObject1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "exp_bq_detail", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "");
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
            if (!paramViewGroup.a) {
              break label1016;
            }
          }
          label1016:
          for (paramViewHolder = "1";; paramViewHolder = "2")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject1, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject2, paramViewHolder);
            paramViewHolder = paramView;
            break;
            paramViewHolder = "查看作者更多作品";
            break label790;
          }
        }
      }
      label1032:
      paramViewHolder = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new BigEmotionDownloadedAdapter.BigEmotionHolder();
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (this.f == 1) {
        return i;
      }
      return i + 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.f == 1) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (this.f == 1) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter
 * JD-Core Version:    0.7.0.1
 */