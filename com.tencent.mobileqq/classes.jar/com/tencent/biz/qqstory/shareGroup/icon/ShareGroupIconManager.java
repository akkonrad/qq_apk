package com.tencent.biz.qqstory.shareGroup.icon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.ITrimmable;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import nrl;
import nrs;
import nrt;
import nru;
import org.json.JSONArray;

public class ShareGroupIconManager
  implements IManager, ITrimmable
{
  private int jdField_a_of_type_Int = Math.min(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), 200);
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private final LruCache jdField_a_of_type_AndroidUtilLruCache = new nrs(this, 40);
  private UrlBitmapDownloader jdField_a_of_type_ComTencentBizQqstoryShareGroupIconUrlBitmapDownloader = new ShareGroupIconManager.UrlBitmapDownloaderImp();
  private AtomicReference jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private AtomicReference b = new AtomicReference();
  
  private Bitmap a()
  {
    this.b.compareAndSet(null, Bitmap.createBitmap(ImageUtil.c()));
    return (Bitmap)this.b.get();
  }
  
  private Stream a(List paramList, String paramString)
  {
    return Stream.of(paramList).map(new ThreadOffFunction(2)).map(new UidListToUrlListSegment(paramString)).map(new UrlListToBitmapListSegment(a(), paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupIconUrlBitmapDownloader)).map(new BitmapListToIconSegment(this.jdField_a_of_type_AndroidContentContext, paramString, this.jdField_a_of_type_Int)).map(new UIThreadOffFunction(null));
  }
  
  @NonNull
  public static String a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      throw new IllegalArgumentException("unionIdList should not be null");
    }
    List localList = Collections.unmodifiableList(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while ((i < 5) && (i < localList.size()))
    {
      localStringBuilder.append((String)paramList.get(i)).append('.');
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private List a(List paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("unionIdList should not be null");
    }
    if (paramList.size() <= 5) {
      return Collections.unmodifiableList(paramList);
    }
    return Collections.unmodifiableList(paramList.subList(0, 5));
  }
  
  public Drawable a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(null, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), a()));
    return (Drawable)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
  }
  
  public Drawable a(List paramList)
  {
    return a(paramList, null);
  }
  
  public Drawable a(List paramList, String paramString)
  {
    List localList = a(paramList);
    if (localList.isEmpty())
    {
      IconLog.c("story.icon.ShareGroupIconManager", "getIconDrawable unionIdList is empty");
      return a();
    }
    String str = a(localList);
    nrl localnrl = (nrl)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
    paramList = localnrl;
    if (localnrl == null) {}
    synchronized (this.jdField_a_of_type_AndroidUtilLruCache)
    {
      localnrl = (nrl)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
      paramList = localnrl;
      if (localnrl == null)
      {
        paramList = new nrl(str, this.jdField_a_of_type_AndroidContentContext, a());
        paramList.a(new nru(this, localList, String.valueOf(System.identityHashCode(paramList)) + "." + paramString));
        this.jdField_a_of_type_AndroidUtilLruCache.put(str, paramList);
        IconLog.c("story.icon.ShareGroupIconManager", "create share group state for uid list, state=%s, uid=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
      }
      return paramList.newDrawable();
    }
  }
  
  @Nullable
  public RestrictedBitmap a(List paramList)
  {
    paramList = a(paramList);
    if (paramList.isEmpty())
    {
      IconLog.c("story.icon.ShareGroupIconManager", "getBitmap unionIdList is empty");
      return new RestrictedBitmap(a());
    }
    paramList = a(paramList);
    paramList = (nrl)this.jdField_a_of_type_AndroidUtilLruCache.get(paramList);
    if (paramList != null)
    {
      paramList = paramList.a();
      if (paramList != null) {
        return new RestrictedBitmap(paramList);
      }
    }
    return null;
  }
  
  public void a()
  {
    IconLog.a("story.icon.ShareGroupIconManager", "onInit");
    ((TrimmableManager)SuperManager.a(26)).a(this);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case 1: 
      do
      {
        return;
        SLog.d("story.icon.ShareGroupIconManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      this.jdField_a_of_type_AndroidUtilLruCache.trimToSize(5);
      return;
    }
    SLog.d("story.icon.ShareGroupIconManager", "clearAllMemory");
    c();
  }
  
  public void a(List paramList, @NonNull ShareGroupIconManager.LoadBitmapCallBack paramLoadBitmapCallBack)
  {
    List localList = a(paramList);
    if (localList.isEmpty())
    {
      IconLog.c("story.icon.ShareGroupIconManager", "addLoadBitmapCallBack unionIdList is empty");
      paramLoadBitmapCallBack.a(new RestrictedBitmap(a()));
      return;
    }
    String str = a(a(paramList));
    nrl localnrl = (nrl)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
    paramList = localnrl;
    if (localnrl == null) {}
    synchronized (this.jdField_a_of_type_AndroidUtilLruCache)
    {
      localnrl = (nrl)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
      paramList = localnrl;
      if (localnrl == null)
      {
        paramList = new nrl(str, this.jdField_a_of_type_AndroidContentContext, a());
        paramList.a(new nrt(this, localList, String.valueOf(System.identityHashCode(paramList))));
        this.jdField_a_of_type_AndroidUtilLruCache.put(str, paramList);
        IconLog.c("story.icon.ShareGroupIconManager", "create share group state for uin list for callback, state=%s, uin=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
      }
      paramList.a(paramLoadBitmapCallBack);
      paramList.b();
      return;
    }
  }
  
  public void b()
  {
    IconLog.a("story.icon.ShareGroupIconManager", "onDestroy");
    c();
    ((TrimmableManager)SuperManager.a(26)).b(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(null);
    this.b.set(null);
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager
 * JD-Core Version:    0.7.0.1
 */