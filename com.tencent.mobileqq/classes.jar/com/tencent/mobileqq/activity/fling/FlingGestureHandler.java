package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.lang.ref.WeakReference;

public class FlingGestureHandler
  extends FlingHandler
  implements TopGestureLayout.OnGestureListener
{
  private View a;
  public TopGestureLayout mTopLayout;
  
  public FlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private ViewGroup a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    paramActivity = localViewGroup;
    if (localView != null)
    {
      paramActivity = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        paramActivity = (ViewGroup)localView;
      }
    }
    return paramActivity;
  }
  
  public void a()
  {
    if (!b()) {}
    ViewGroup localViewGroup;
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      localViewGroup = a((Activity)localObject);
      if (this.mTopLayout == null)
      {
        this.jdField_a_of_type_AndroidViewView = localViewGroup.getChildAt(0);
        View localView = this.jdField_a_of_type_AndroidViewView;
        this.mTopLayout = new TopGestureLayout((Context)localObject);
        localObject = this.mTopLayout;
        ((TopGestureLayout)localObject).setOnFlingGesture(this);
        localViewGroup.addView((View)localObject);
        ((ViewGroup)localView.getParent()).removeView(localView);
        ((TopGestureLayout)localObject).addView(localView);
        return;
      }
    } while (a());
    localViewGroup.addView(this.mTopLayout);
    localViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
    this.mTopLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public boolean a()
  {
    return (this.mTopLayout != null) && (this.mTopLayout.getParent() != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() == this.mTopLayout);
  }
  
  protected void b()
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = a((Activity)localObject);
      } while ((!a()) || (!this.mTopLayout.getParent().equals(localObject)));
      ((ViewGroup)localObject).removeView(this.mTopLayout);
    } while (!this.jdField_a_of_type_AndroidViewView.getParent().equals(this.mTopLayout));
    this.mTopLayout.removeView(this.jdField_a_of_type_AndroidViewView);
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void flingLToR()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null) {
      localActivity.onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public void setTopLayout(TopGestureLayout paramTopGestureLayout)
  {
    if ((!b()) && (paramTopGestureLayout == null)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localActivity == null);
    if (a())
    {
      b();
      this.jdField_a_of_type_AndroidViewView = a(localActivity).getChildAt(0);
      this.mTopLayout = paramTopGestureLayout;
      paramTopGestureLayout.setOnFlingGesture(this);
      a();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a(localActivity).getChildAt(0);
    this.mTopLayout = paramTopGestureLayout;
    paramTopGestureLayout.setOnFlingGesture(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingGestureHandler
 * JD-Core Version:    0.7.0.1
 */