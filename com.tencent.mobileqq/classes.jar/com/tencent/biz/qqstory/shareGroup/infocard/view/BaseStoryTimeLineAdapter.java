package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.DataSortedComparator;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView.OnInnerListRefreshListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseStoryTimeLineAdapter
  extends BaseAdapter
{
  private final int a;
  protected Context a;
  protected MyMemoriesListView.OnUIClickListener a;
  protected VideoCollectionItem.DataSortedComparator a;
  protected MemoriesInnerListView.OnInnerListRefreshListener a;
  protected ArrayList a;
  
  public BaseStoryTimeLineAdapter(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$DataSortedComparator = new VideoCollectionItem.DataSortedComparator();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().heightPixels - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 60.0F));
    a(true);
  }
  
  private VideoCollectionItem a(int paramInt)
  {
    SLog.c("Q.qqstory.home.BaseStoryTimeLineAdapter", "getSimpleFakeItem");
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionId = String.valueOf(paramInt);
    localVideoCollectionItem.collectionTime = -1L;
    localVideoCollectionItem.key = "local_empty_item";
    localVideoCollectionItem.isEmptyFakeItem = true;
    return localVideoCollectionItem;
  }
  
  protected abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  public VideoCollectionItem a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      VideoCollectionItem localVideoCollectionItem2 = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      VideoCollectionItem localVideoCollectionItem1;
      if (localVideoCollectionItem2.isEmptyFakeItem)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 2)
        {
          localVideoCollectionItem1 = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
          if (TextUtils.isEmpty(localVideoCollectionItem1.collectionId)) {}
        }
      }
      else {
        do
        {
          return localVideoCollectionItem1;
          localVideoCollectionItem1 = localVideoCollectionItem2;
        } while (!TextUtils.isEmpty(localVideoCollectionItem2.collectionId));
      }
    }
    return null;
  }
  
  public void a()
  {
    b();
    a(VideoCollectionItem.getProfilePlaceholderItem(QQStoryContext.a().b()));
  }
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SLog.a("Q.qqstory.home.BaseStoryTimeLineAdapter", "bindview. postion=%d", Integer.valueOf(paramInt));
    paramViewGroup = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((BaseStoryTimeLineAdapter.BaseViewHolder)paramView.getTag()).a(paramViewGroup, paramView, paramInt);
  }
  
  protected void a(VideoCollectionItem paramVideoCollectionItem)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramVideoCollectionItem) > 0) {
      SLog.b("Q.qqstory.home.BaseStoryTimeLineAdapter", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
    }
    do
    {
      return;
      i = Collections.binarySearch(this.jdField_a_of_type_JavaUtilArrayList, paramVideoCollectionItem, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$DataSortedComparator);
    } while (i >= 0);
    int i = -i;
    this.jdField_a_of_type_JavaUtilArrayList.add(i - 1, paramVideoCollectionItem);
  }
  
  public void a(MemoriesInnerListView.OnInnerListRefreshListener paramOnInnerListRefreshListener, MyMemoriesListView.OnUIClickListener paramOnUIClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewMemoriesInnerListView$OnInnerListRefreshListener = paramOnInnerListRefreshListener;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener = paramOnUIClickListener;
  }
  
  public abstract void a(String paramString, List paramList);
  
  public void a(List paramList, boolean paramBoolean)
  {
    SLog.a("Q.qqstory.home.BaseStoryTimeLineAdapter", "setData, dataList size=%d", Integer.valueOf(paramList.size()));
    b();
    b(paramList, paramBoolean);
    notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    a(VideoCollectionItem.getProfilePlaceholderItem(QQStoryContext.a().b()));
    if ((a()) && (paramBoolean))
    {
      a(VideoCollectionItem.getCurrentYearFakeItem(QQStoryContext.a().b()));
      a(VideoCollectionItem.getTodayFakeItem(QQStoryContext.a().b()));
      int i = this.jdField_a_of_type_Int;
      int j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
      int k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 65.0F);
      int m = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 150.0F);
      this.jdField_a_of_type_JavaUtilArrayList.add(a(i - j - k - m));
    }
  }
  
  protected abstract boolean a();
  
  public abstract boolean a(boolean paramBoolean);
  
  protected void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  protected void b(List paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      a(true);
    }
    int j;
    int i;
    do
    {
      return;
      a(false);
      j = this.jdField_a_of_type_Int - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
      Iterator localIterator = paramList.iterator();
      i = j;
      while (localIterator.hasNext())
      {
        VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
        a(localVideoCollectionItem);
        if (paramList.size() <= 3)
        {
          if (localVideoCollectionItem.collectionType == 0) {
            i -= UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 65.0F);
          }
          for (;;)
          {
            break;
            if (!TextUtils.isEmpty(com.tencent.biz.qqstory.utils.DateUtils.a(localVideoCollectionItem.collectionTime)[0])) {
              i -= UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 190.0F);
            } else {
              i -= UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 150.0F);
            }
          }
        }
      }
    } while ((a(paramBoolean)) || (i == j) || (i <= 0));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(i));
  }
  
  public void c(List paramList, boolean paramBoolean)
  {
    d(paramList, paramBoolean);
    notifyDataSetChanged();
  }
  
  protected void d(List paramList, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      localObject1 = localObject2;
      if (localVideoCollectionItem.isEmptyFakeItem)
      {
        SLog.d("Q.qqstory.home.BaseStoryTimeLineAdapter", "addData, has fake");
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
        localObject1 = localVideoCollectionItem;
      }
    }
    SLog.a("Q.qqstory.home.BaseStoryTimeLineAdapter", "addData, new dataList=%s", paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((VideoCollectionItem)paramList.next());
    }
    if (localObject1 != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      SLog.b("Q.qqstory.home.BaseStoryTimeLineAdapter", "add fake item.");
    }
    a(paramBoolean);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).collectionType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    if (localView != null) {
      a(paramInt, localView, paramViewGroup);
    }
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return VideoCollectionItem.TYPE_ORDER.length;
  }
  
  public boolean isEmpty()
  {
    return getCount() <= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.BaseStoryTimeLineAdapter
 * JD-Core Version:    0.7.0.1
 */