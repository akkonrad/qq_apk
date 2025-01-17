package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import wow;
import wox;
import woy;
import woz;
import wpa;
import wpb;
import wpc;
import wpd;
import wpe;
import wpf;
import wpg;

public class EmoticonGroupStoreFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private View jdField_a_of_type_AndroidViewView;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FilterAdapter jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter;
  private PicSelectAdapter jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new wow(this);
  private EmoticonFromGroupManager jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("    ");
  public List a;
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new wox(this);
  private View jdField_b_of_type_AndroidViewView;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private List jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map jdField_b_of_type_JavaUtilMap;
  private volatile boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private List jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private volatile boolean jdField_c_of_type_Boolean;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private List jdField_d_of_type_JavaUtilList;
  private Button jdField_e_of_type_AndroidWidgetButton;
  private List jdField_e_of_type_JavaUtilList = new ArrayList();
  private View jdField_f_of_type_AndroidViewView;
  private Button jdField_f_of_type_AndroidWidgetButton;
  private List jdField_f_of_type_JavaUtilList = new ArrayList();
  private View jdField_g_of_type_AndroidViewView;
  private Button jdField_g_of_type_AndroidWidgetButton;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private View i;
  private View j;
  private View k;
  
  public EmoticonGroupStoreFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
      if (localEmoticonFromGroupEntity != null) {
        if (localEmoticonFromGroupEntity.msg == null)
        {
          MessageForPic localMessageForPic = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(localEmoticonFromGroupEntity);
          if (localMessageForPic != null)
          {
            localEmoticonFromGroupEntity.msg = localMessageForPic;
            this.jdField_b_of_type_JavaUtilList.add(localEmoticonFromGroupEntity);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.b(localEmoticonFromGroupEntity);
            this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(localEmoticonFromGroupEntity);
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilList.add(localEmoticonFromGroupEntity);
        }
      }
    }
  }
  
  private void b(List paramList)
  {
    Object localObject1 = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(148);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Fragment", 2, "call getFavEmoticonList from EmoticonGroupStoreFragment.filterFavEmo");
    }
    Object localObject2 = ((FavroamingDBManager)localObject1).a();
    localObject1 = new ArrayList();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      int m = 0;
      while (m < ((List)localObject2).size())
      {
        if ((TextUtils.isEmpty(((CustomEmotionData)((List)localObject2).get(m)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)((List)localObject2).get(m)).RomaingType))) {
          ((List)localObject1).add(((List)localObject2).get(m));
        }
        m += 1;
      }
    }
    localObject2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((List)localObject1, localEmoticonFromGroupEntity.bigURL))
      {
        localEmoticonFromGroupEntity.status = 0;
        ((List)localObject2).add(localEmoticonFromGroupEntity);
      }
    }
    this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject2);
  }
  
  private void c(List paramList)
  {
    int m = 3;
    int n;
    if (paramList == null) {
      n = 0;
    }
    while ((getActivity() != null) && (n != 0))
    {
      ArrayList localArrayList = new ArrayList();
      String str = String.format(getString(2131438030), new Object[] { Integer.valueOf(n) });
      if (n < 3) {
        m = paramList.size();
      }
      n = 0;
      for (;;)
      {
        if (n < m)
        {
          URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((EmoticonFromGroupEntity)paramList.get(n), 65537, ScreenUtil.a(11.0F), null);
          int i1 = n + 1;
          n = i1;
          if (localURLDrawable != null)
          {
            localArrayList.add(localURLDrawable);
            this.jdField_a_of_type_JavaLangStringBuilder.append(" ");
            n = i1;
            if (1 != localURLDrawable.getStatus())
            {
              localURLDrawable.startDownload();
              localURLDrawable.setURLDrawableListener(new wpg(this));
              n = i1;
              continue;
              n = paramList.size();
              break;
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangStringBuilder + str);
      paramList = new OverlapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramList.a(localArrayList, ScreenUtil.a(11.0F));
      paramList.setBounds(0, 0, ScreenUtil.a(33.0F), ScreenUtil.a(22.0F));
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ImageSpan(paramList, 0), 0, this.jdField_a_of_type_JavaLangStringBuilder.length() - 4, 17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131372337));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_e_of_type_AndroidViewView.findViewById(2131372338));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_e_of_type_AndroidViewView.findViewById(2131372340));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131372341));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_e_of_type_AndroidViewView.findViewById(2131372342));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext()).inflate(2130970956, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372345);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372346);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131372350));
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372349);
    this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372351);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372354));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372355));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    Object localObject = new LinearLayoutManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, false);
    ((LinearLayoutManager)localObject).setRecycleChildrenOnDetach(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131372339));
    this.jdField_h_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_h_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_h_of_type_AndroidViewView.setBackgroundColor(Color.parseColor(getString(2131492914)));
    try
    {
      this.i = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext()).inflate(2130970951, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.j = this.i.findViewById(2131372326);
      this.j.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.i.findViewById(2131372328));
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new woz(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter = new FilterAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.i.findViewById(2131372327));
      this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.i.findViewById(2131372330));
      this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.i.findViewById(2131372331));
      this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.k = this.jdField_e_of_type_AndroidViewView.findViewById(2131372343);
      ((URLImageView)this.k.findViewById(2131372344)).setImageDrawable(URLDrawable.getDrawable("http://imgcache.gtimg.cn/ACT/svip_act/act_img/public/201802/m1517913373_empty_img_1.png"));
      this.jdField_g_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_g_of_type_AndroidWidgetButton.setId(2131362472);
      localObject = new RelativeLayout.LayoutParams(ScreenUtil.a(21.0F), ScreenUtil.a(20.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 8;
      this.jdField_g_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.addView(this.jdField_g_of_type_AndroidWidgetButton);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("EmoticonFromGroup_Fragment", 2, "oom error occur!");
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131438029);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131492971));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130839142));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131492971));
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130839119);
    this.jdField_g_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new wpa(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    f();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.k.setVisibility(8);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter = new PicSelectAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(), this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidSupportV4ViewViewPager, this.jdField_b_of_type_AndroidWidgetButton);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new wpb(this));
  }
  
  private void g()
  {
    ThreadManager.post(new wpc(this), 5, null, true);
  }
  
  private void h()
  {
    ThreadManager.getUIHandler().post(new wpd(this));
  }
  
  private void i()
  {
    ThreadManager.getUIHandler().post(new wpe(this));
  }
  
  private void n()
  {
    ThreadManager.getUIHandler().post(new wpf(this));
  }
  
  private void o()
  {
    ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    ConcurrentHashMap localConcurrentHashMap2 = new ConcurrentHashMap();
    Object localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonFromGroupEntity)((Iterator)localObject1).next();
      if (localConcurrentHashMap1.containsKey(((EmoticonFromGroupEntity)localObject2).troopUin))
      {
        ((List)localConcurrentHashMap1.get(((EmoticonFromGroupEntity)localObject2).troopUin)).add(localObject2);
      }
      else
      {
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject2);
        localConcurrentHashMap1.put(((EmoticonFromGroupEntity)localObject2).troopUin, localObject3);
      }
    }
    Object localObject3 = localConcurrentHashMap1.entrySet().iterator();
    Map.Entry localEntry;
    FilterAdapter.FilterItemContent localFilterItemContent;
    EmoticonFromGroupEntity localEmoticonFromGroupEntity;
    if (((Iterator)localObject3).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject3).next();
      localFilterItemContent = new FilterAdapter.FilterItemContent();
      localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((List)localEntry.getValue()).get(0);
      if (1 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4, localEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonFromGroupEntity.troopUin, true);
      }
    }
    for (;;)
    {
      localFilterItemContent.jdField_a_of_type_JavaLangString = localEmoticonFromGroupEntity.troopUin;
      localFilterItemContent.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      localFilterItemContent.jdField_a_of_type_Boolean = false;
      localFilterItemContent.b = ((String)localObject1);
      localFilterItemContent.jdField_a_of_type_Int = ((List)localEntry.getValue()).size();
      localCopyOnWriteArrayList.add(localFilterItemContent);
      localConcurrentHashMap2.put(localFilterItemContent.jdField_a_of_type_JavaLangString, localFilterItemContent);
      break;
      if (3000 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(101, localEmoticonFromGroupEntity.troopUin, (byte)1, false, (byte)1, 0);
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localEmoticonFromGroupEntity.troopUin);
        continue;
        this.jdField_a_of_type_JavaUtilMap = localConcurrentHashMap1;
        this.jdField_d_of_type_JavaUtilList = localCopyOnWriteArrayList;
        this.jdField_b_of_type_JavaUtilMap = localConcurrentHashMap2;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          ThreadManager.getUIHandler().post(new woy(this));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter.a(this.jdField_d_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter.notifyDataSetChanged();
        this.jdField_h_of_type_AndroidWidgetTextView.setText("筛选（共" + this.jdField_b_of_type_JavaUtilList.size() + "个表情）");
      }
      else
      {
        localObject1 = null;
        localObject2 = null;
      }
    }
  }
  
  private void p()
  {
    if ((this.i != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout == this.i.getParent()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout == this.i.getParent()))
    {
      this.jdField_h_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
      this.i.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void q()
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((FilterAdapter.FilterItemContent)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_e_of_type_JavaUtilList.isEmpty()) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
  }
  
  private void r()
  {
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130839119);
    this.jdField_g_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void s()
  {
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130839120);
    this.jdField_g_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  protected int a()
  {
    return 2130970954;
  }
  
  protected void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init start.");
    }
    super.a(paramBundle);
    super.a("群聊表情");
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBundle;
      paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppInterface();
      if (!(paramBundle instanceof QQAppInterface)) {
        break label200;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager = ((VasExtensionManager)paramBundle.getManager(234)).jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager;
      paramBundle = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102);
      if (paramBundle != null) {
        paramBundle.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      d();
      e();
      g();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "PageView", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init end.");
      }
      return;
      QLog.e("EmoticonFromGroup_Fragment", 1, "activity is null");
      c();
      break;
      label200:
      QLog.e("EmoticonFromGroup_Fragment", 1, "app is null");
      c();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      localObject = null;
      m = 0;
      if (m >= localViewGroup.getChildCount()) {
        break label113;
      }
      View localView = localViewGroup.getChildAt(m);
      localObject = localView;
      if ((localView instanceof DragFrameLayout)) {
        localObject = ((DragFrameLayout)localView).getChildAt(0);
      }
      if (!(localObject instanceof TopGestureLayout)) {
        break label106;
      }
    }
    label106:
    label113:
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
      }
      return;
      m += 1;
      break;
    }
  }
  
  void b()
  {
    if (c() != null)
    {
      c().setBackgroundResource(0);
      c().setBackgroundColor(-1);
    }
    SystemBarCompact localSystemBarCompact;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof PublicFragmentActivity)))
    {
      localSystemBarCompact = ((PublicFragmentActivity)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (b()) && (a()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime())) {
          break label122;
        }
        if ((SystemUtil.b()) || (SystemUtil.d())) {
          break label109;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    return;
    label109:
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label122:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  protected void c()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonFromGroupEntity)localIterator.next()).status = -1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
      r();
      a(true);
      j();
      return true;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == this.jdField_a_of_type_AndroidViewView.getParent())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidViewView);
      a(true);
      return true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      q();
      p();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return true;
    }
    c();
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      paramIntent = new Bundle(paramIntent.getExtras());
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putBoolean("PhotoConst.IS_FORWARD", true);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      localIntent.putExtras(paramIntent);
      String str = paramIntent.getString("GALLERY.FORWORD_LOCAL_PATH");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str);
      paramInt1 = paramIntent.getInt("PhotoConst.SEND_SIZE_SPEC", 0);
      PhotoUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, localArrayList, paramInt1, true);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    case 2131372346: 
    default: 
    case 2131372340: 
    case 2131372342: 
    case 2131372345: 
    case 2131372349: 
    case 2131372351: 
    case 2131372354: 
    case 2131372355: 
    case 2131362472: 
      do
      {
        do
        {
          return;
          if (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() == 0) {
            this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          s();
          a(false);
          b("取消", this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131492971));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBFBFBF"));
          this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130841700));
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMutiSel", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean = false;
          this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.d(new ArrayList(this.jdField_a_of_type_JavaUtilList));
          paramView = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramView.hasNext()) {
            ((EmoticonFromGroupEntity)paramView.next()).status = 0;
          }
          paramView = (EmoticonFromGroupDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(258);
          paramView.b -= this.jdField_a_of_type_JavaUtilList.size();
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
          r();
          a(true);
          j();
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "AddMutibq", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          return;
        } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout != this.jdField_a_of_type_AndroidViewView.getParent());
        AbstractGifImage.pauseAll();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidViewView);
        a(true);
        return;
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.arrowScroll(17);
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        return;
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.arrowScroll(66);
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        return;
        paramView = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if ((paramView != null) && (paramView.msg != null)) {
          AIOGalleryScene.a(new AIORichMediaInfo(AIOGalleryUtils.a(paramView.msg)), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        }
        for (;;)
        {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SendFriend", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          return;
          QLog.e("EmoticonFromGroup_Fragment.msgnull", 1, "preview send msg is null.");
        }
        paramView = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(paramView))
        {
          this.jdField_c_of_type_JavaUtilList.add(paramView);
          this.jdField_d_of_type_AndroidWidgetButton.setText("已添加");
          this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
          this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130841700));
          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
        }
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "Addbq", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        return;
        if (this.i != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("EmoticonFromGroup_Fragment", 2, "click right img useless, filterView is null.");
      return;
      a(false);
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != this.jdField_h_of_type_AndroidViewView.getParent()) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_h_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != this.i.getParent()) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.i);
      }
      this.jdField_h_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.i.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      paramView = this.jdField_f_of_type_JavaUtilList.iterator();
      while (paramView.hasNext())
      {
        localObject = (String)paramView.next();
        this.jdField_e_of_type_JavaUtilList.add(localObject);
        ((FilterAdapter.FilterItemContent)this.jdField_b_of_type_JavaUtilMap.get(localObject)).jdField_a_of_type_Boolean = true;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        o();
      }
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilter", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    case 2131372326: 
      q();
      p();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    case 2131372331: 
      if (!this.jdField_f_of_type_JavaUtilList.isEmpty()) {
        this.jdField_f_of_type_JavaUtilList.clear();
      }
      int m = this.jdField_e_of_type_JavaUtilList.size();
      if (m == 0)
      {
        paramView = new ArrayList(this.jdField_b_of_type_JavaUtilList);
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(paramView);
        if (localObject != null)
        {
          c(paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a((Map)localObject, paramView);
        }
      }
      for (;;)
      {
        q();
        p();
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterConfirm", "0", 1, 0, 0, "", "", "" + m, "", "", "", "", 0, 0, 0, 0);
        return;
        paramView = new ArrayList();
        localObject = this.jdField_e_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.jdField_f_of_type_JavaUtilList.add(str);
          paramView.addAll((Collection)this.jdField_a_of_type_JavaUtilMap.get(str));
        }
        Collections.sort(paramView);
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(paramView);
        if (localObject != null)
        {
          c(paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a((Map)localObject, paramView);
        }
      }
    }
    q();
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter.notifyDataSetChanged();
    VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReset", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.b(this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.c(this.jdField_c_of_type_JavaUtilList);
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10).sendToTarget();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    AbstractGifImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
    }
    if (this.jdField_g_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("emo_tip_sp", 0).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "emo_store_hint", true);
      if (!this.jdField_a_of_type_Boolean) {
        break label247;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("emo_tip_sp", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "emo_store_hint", false).apply();
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.jdField_d_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null))
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if (localEmoticonFromGroupEntity != null)
        {
          if (localEmoticonFromGroupEntity.status != 0) {
            break;
          }
          this.jdField_d_of_type_AndroidWidgetButton.setText("已添加");
          this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
          this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130841700));
          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
        }
      }
      return;
      label247:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_d_of_type_AndroidWidgetButton.setText("添加到表情");
    this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
    this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130841699));
    this.jdField_d_of_type_AndroidWidgetButton.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment
 * JD-Core Version:    0.7.0.1
 */