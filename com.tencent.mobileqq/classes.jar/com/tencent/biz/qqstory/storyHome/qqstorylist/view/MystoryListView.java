package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.TraceUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import mqq.os.MqqHandler;
import nzv;
import nzw;
import nzx;
import nzy;
import nzz;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class MystoryListView
  extends SegmentList
  implements FeedSegment.InputViewHideListener, IEventReceiver
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Activity a;
  private View jdField_a_of_type_AndroidViewView;
  private StoryConfigManager jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
  public IMyStoryListView a;
  private MystoryListView.FakeVideoCreateRec jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$FakeVideoCreateRec;
  private MystoryListView.PullRefreshListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$PullRefreshListener;
  private ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  public Runnable a;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private AbsListView.OnScrollListener jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener = new nzv(this);
  private boolean c;
  private boolean d;
  private boolean e;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public MystoryListView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public MystoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MystoryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = null;
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a()
  {
    QQStoryContext.a();
    Object localObject = QQStoryContext.a();
    if (localObject != null)
    {
      localObject = ((TroopRedTouchManager)((QQAppInterface)localObject).getManager(69)).a();
      if ((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid.has())) {
        switch (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get())
        {
        }
      }
    }
    for (;;)
    {
      return 0;
      return 1;
      return 2;
      return 3;
      return 4;
      SLog.e("Q.qqstory.home.MyStoryListView", "Get the QQAppInterface is null,we dont know the red point state");
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super.setOnScrollListener(this.jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this);
  }
  
  private void v()
  {
    String str1;
    String str2;
    if (FeedSegment.a(FeedSegment.a(getContext())))
    {
      str1 = "1";
      if (QQStoryMainActivity.jdField_a_of_type_Long <= 0L) {
        break label104;
      }
      str2 = String.valueOf(System.currentTimeMillis() - QQStoryMainActivity.jdField_a_of_type_Long);
      label35:
      if (!this.c) {
        break label110;
      }
    }
    label104:
    label110:
    for (String str3 = "2";; str3 = "1")
    {
      StoryReportor.b("story_home_dev", "exp", 0, 0, new String[] { str3, str1, str2 });
      InfoPrinter.b("Q.qqstory.home.MyStoryListView", new Object[] { "listViewExposure auto_play_switch=", str1, ",cost=", str2 });
      return;
      str1 = "0";
      break;
      str2 = "-1";
      break label35;
    }
  }
  
  private void w()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    if (localQQAppInterface != null) {
      ((TroopRedTouchManager)localQQAppInterface.getManager(69)).a();
    }
  }
  
  protected void a()
  {
    super.setActTAG("list_qqstory_home");
    ((MystoryListView.MystoryListConfigApplier)StoryApi.a(MystoryListView.MystoryListConfigApplier.class, new Object[0])).a(this);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setContentBackground(2130838583);
  }
  
  public void a(Activity paramActivity, IMyStoryListView paramIMyStoryListView, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView = paramIMyStoryListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    this.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_have_show_click_to_top", Integer.valueOf(0))).intValue();
  }
  
  public void a(@NonNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(true);
    super.a(paramString);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    if (paramBoolean) {
      w();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(false);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$PullRefreshListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$PullRefreshListener.a(paramBoolean, false);
    }
    String str;
    if (this.jdField_b_of_type_Long > 0L)
    {
      str = String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      if (!paramBoolean) {
        break label149;
      }
    }
    label149:
    for (int m = 1;; m = 2)
    {
      StoryReportor.b("story_home_dev", "ref_cost", 2, m, new String[] { String.valueOf(paramInt), str });
      this.jdField_b_of_type_Long = 0L;
      InfoPrinter.b("Q.qqstory.home.MyStoryListView", new Object[] { "autoRefreshCompleted=", Boolean.valueOf(paramBoolean), ",errorCode=", Integer.valueOf(paramInt), ",cost time=", str });
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.a(paramInt, paramView, paramListView);
    if (paramInt == 0)
    {
      this.e = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$PullRefreshListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$PullRefreshListener.m();
      }
    }
    while (paramInt != 1) {
      return true;
    }
    return true;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().postDelayed(new nzz(this), 300L);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.j();
  }
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    if (paramBoolean) {
      w();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(false);
    SLog.a("Q.qqstory.home.MyStoryListView", "pullRefreshCompleted success=%s,isManualPullRefresh=%s", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.e));
    String str;
    if (this.e)
    {
      this.e = false;
      if (paramBoolean)
      {
        str = "1";
        StoryReportor.a("home_page", "refresh", 0, 0, new String[] { str });
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$PullRefreshListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$PullRefreshListener.a(paramBoolean, this.e);
      }
      if (this.jdField_b_of_type_Long > 0L)
      {
        str = String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long);
        if (!paramBoolean) {
          break label218;
        }
      }
    }
    label218:
    for (int m = 1;; m = 2)
    {
      StoryReportor.b("story_home_dev", "ref_cost", 1, m, new String[] { String.valueOf(paramInt), str });
      this.jdField_b_of_type_Long = 0L;
      InfoPrinter.b("Q.qqstory.home.MyStoryListView", new Object[] { "pullToRefreshCompleted=", Boolean.valueOf(paramBoolean), ",errorCode=", Integer.valueOf(paramInt), ",cost time=", str });
      return;
      str = "2";
      break;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.k();
  }
  
  public void d()
  {
    if (this.c)
    {
      int m = UIUtils.a(getContext(), 232.0F);
      super.smoothScrollBy(-m, -m);
    }
  }
  
  public void e()
  {
    if (this.c)
    {
      int m = UIUtils.a(getContext(), 232.0F);
      super.smoothScrollBy(m, m);
    }
  }
  
  public void f()
  {
    if (this.c)
    {
      int m = UIUtils.a(getContext(), 36.0F);
      super.smoothScrollBy(m, m);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Long > 0L)
    {
      localObject = String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      int m = getCount();
      StoryReportor.b("story_home_dev", "local_cost", 0, m, new String[] { localObject });
      this.jdField_a_of_type_Long = 0L;
      InfoPrinter.b("Q.qqstory.home.MyStoryListView", new Object[] { "onLoadCacheCompile getCount=", Integer.valueOf(m), ",cost time=", localObject });
    }
    v();
    if (!this.jdField_f_of_type_Boolean)
    {
      ThreadManager.getUIHandler().postDelayed(new nzw(this), 500L);
      return;
    }
    Object localObject = (FeedManager)SuperManager.a(11);
    SLog.a("Q.qqstory.home.position", "start auto jump position:%d, offset:%d", Integer.valueOf(((FeedManager)localObject).jdField_a_of_type_Int), Integer.valueOf(((FeedManager)localObject).jdField_b_of_type_Int));
    if ((((FeedManager)localObject).jdField_a_of_type_Int != 0) && (((FeedManager)localObject).jdField_b_of_type_Int != 0)) {
      setSelectionFromTop(((FeedManager)localObject).jdField_a_of_type_Int, ((FeedManager)localObject).jdField_b_of_type_Int);
    }
    SLog.a("Q.qqstory.home.position", "mDisableAutoRefresh：%b", Boolean.valueOf(this.jdField_f_of_type_Boolean));
    h();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void h()
  {
    super.h();
    QQStoryContext.a();
    Object localObject = QQStoryContext.a();
    oidb_0x791.RedDotInfo localRedDotInfo;
    label48:
    label74:
    int n;
    if (localObject != null)
    {
      localRedDotInfo = ((TroopRedTouchManager)((QQAppInterface)localObject).getManager(69)).a();
      if (((FeedSegment)a("FeedSegment")).a() <= 0) {
        break label291;
      }
      m = 1;
      String str = StoryReportor.a("home_page-exp-d4");
      localObject = str;
      if (str == null)
      {
        if (!this.c) {
          break label296;
        }
        localObject = "2";
      }
      StoryReportor.a("home_page-exp-d4", null);
      if (this.jdField_a_of_type_Int != 0) {
        break label302;
      }
      n = a();
      label93:
      StoryReportor.a("home_page", "exp", n, m, new String[] { "", "", "", localObject });
      StoryReportor.a("home_page", "network", 0, 0, new String[] { "", "", StoryReportor.a(getContext()) });
      this.jdField_a_of_type_Int = 0;
      if ((localRedDotInfo != null) && ((localRedDotInfo.uint32_appid.get() == 49) || (localRedDotInfo.uint32_appid.get() == 28)))
      {
        localObject = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label310;
        }
        m = 1;
        label232:
        if (m == 0) {
          break label315;
        }
      }
    }
    label291:
    label296:
    label302:
    label310:
    label315:
    for (int m = 1;; m = 2)
    {
      StoryReportor.a("play_video", "exp_grey", m, 0, new String[] { "", "", "", "" });
      return;
      SLog.e("Q.qqstory.home.MyStoryListView", "Get the QQAppInterface is null,we dont know the red point state");
      localRedDotInfo = null;
      break;
      m = 2;
      break label48;
      localObject = "1";
      break label74;
      n = this.jdField_a_of_type_Int;
      break label93;
      m = 0;
      break label232;
    }
  }
  
  public void i()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(true);
    super.setSelection(0);
    super.i();
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void j()
  {
    SLog.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), mOverScrollHeight %d firstVisiblePostion %d childCount %d", new Object[] { Integer.valueOf(this.mOverScrollHeight), Integer.valueOf(getFirstVisiblePosition()), Integer.valueOf(getChildCount()) });
    int[] arrayOfInt1 = new int[7];
    int[] tmp48_47 = arrayOfInt1;
    tmp48_47[0] = 0;
    int[] tmp52_48 = tmp48_47;
    tmp52_48[1] = 2;
    int[] tmp56_52 = tmp52_48;
    tmp56_52[2] = 2;
    int[] tmp60_56 = tmp56_52;
    tmp60_56[3] = 2;
    int[] tmp64_60 = tmp60_56;
    tmp64_60[4] = 2;
    int[] tmp68_64 = tmp64_60;
    tmp68_64[5] = 2;
    int[] tmp72_68 = tmp68_64;
    tmp72_68[6] = 1;
    tmp72_68;
    float[] arrayOfFloat = new float[7];
    arrayOfFloat[0] = (getHeight() / 2.0F);
    arrayOfFloat[1] = (getHeight() / 2.0F + 0.5F * this.mOverScrollHeight);
    arrayOfFloat[2] = (getHeight() / 2.0F + 1.0F * this.mOverScrollHeight);
    arrayOfFloat[3] = (getHeight() / 2.0F + 1.5F * this.mOverScrollHeight);
    arrayOfFloat[4] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.0F);
    arrayOfFloat[5] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.5F);
    arrayOfFloat[6] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.5F);
    int[] arrayOfInt2 = new int[7];
    int[] tmp226_224 = arrayOfInt2;
    tmp226_224[0] = 0;
    int[] tmp230_226 = tmp226_224;
    tmp230_226[1] = 50;
    int[] tmp235_230 = tmp230_226;
    tmp235_230[2] = 50;
    int[] tmp240_235 = tmp235_230;
    tmp240_235[3] = 50;
    int[] tmp245_240 = tmp240_235;
    tmp245_240[4] = 50;
    int[] tmp250_245 = tmp245_240;
    tmp250_245[5] = 50;
    int[] tmp255_250 = tmp250_245;
    tmp255_250[6] = 800;
    tmp255_250;
    if ((arrayOfInt1.length == arrayOfFloat.length) && (arrayOfFloat.length == arrayOfInt2.length)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      this.jdField_a_of_type_JavaLangRunnable = new nzx(this, arrayOfInt1, arrayOfInt2, arrayOfFloat);
      if ((getFirstVisiblePosition() == 0) && (getChildCount() > 0))
      {
        int m = getChildAt(0).getTop();
        SLog.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), child(0).top = %d", new Object[] { Integer.valueOf(m) });
        if (m >= 0)
        {
          post(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_JavaLangRunnable = null;
        }
      }
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        SLog.d("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), smoothScrollToPostion(0)!");
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, 0, new nzy(this));
      }
      return;
    }
  }
  
  public void k()
  {
    super.k();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$FakeVideoCreateRec = new MystoryListView.FakeVideoCreateRec(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$FakeVideoCreateRec);
  }
  
  public void l()
  {
    super.l();
    URLDrawable.resume();
    StoryInputBarView localStoryInputBarView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
    if (StoryDepends.b())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localStoryInputBarView.c();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(false);
  }
  
  protected void layoutChildren()
  {
    TraceUtils.a("MystoryList.layoutChildren");
    super.layoutChildren();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      FeedSegment localFeedSegment = (FeedSegment)a("FeedSegment");
      if (localFeedSegment != null) {
        localFeedSegment.b(0);
      }
    }
    TraceUtils.a();
  }
  
  public void m()
  {
    super.m();
    URLDrawable.resume();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$FakeVideoCreateRec != null)
    {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$FakeVideoCreateRec);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$FakeVideoCreateRec = null;
    }
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_Int != 1)
    {
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_have_show_click_to_top", Integer.valueOf(1));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.b(false);
    super.setSelection(0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    StoryInputBarView localStoryInputBarView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
    if (localStoryInputBarView.getVisibility() == 0)
    {
      ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(localStoryInputBarView.getWindowToken(), 0);
      localStoryInputBarView.clearFocus();
      localStoryInputBarView.setVisibility(8);
      b();
      int m;
      if (localStoryInputBarView.a != null)
      {
        paramMotionEvent = localStoryInputBarView.a.a;
        m = StoryReportor.a(paramMotionEvent.getOwner());
        if (!paramMotionEvent.getOwner().isMe()) {
          break label129;
        }
      }
      label129:
      for (paramMotionEvent = "1";; paramMotionEvent = "2")
      {
        StoryReportor.a("home_page", "cancel_reply", m, 0, new String[] { paramMotionEvent, "1", "", "" });
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (paramInt == 2)
    {
      URLDrawable.pause();
      return;
    }
    URLDrawable.resume();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setDisableAutoRefresh(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNowTab(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setPullRefreshListener(MystoryListView.PullRefreshListener paramPullRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$PullRefreshListener = paramPullRefreshListener;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    FeedSegment localFeedSegment = (FeedSegment)a("FeedSegment");
    if (localFeedSegment == null) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    localFeedSegment.c(1);
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    localFeedSegment.c(0);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView
 * JD-Core Version:    0.7.0.1
 */