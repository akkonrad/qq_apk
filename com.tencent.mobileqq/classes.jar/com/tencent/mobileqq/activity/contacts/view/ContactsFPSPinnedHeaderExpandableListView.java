package com.tencent.mobileqq.activity.contacts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;

public class ContactsFPSPinnedHeaderExpandableListView
  extends FPSPinnedHeaderExpandableListView
{
  private boolean a = true;
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactsFPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    if (this.a) {
      super.a(paramInt1, paramInt2, paramView, paramInt3);
    }
  }
  
  public void setChildViewCanAction(boolean paramBoolean)
  {
    ExpandableListAdapter localExpandableListAdapter = a();
    if ((localExpandableListAdapter instanceof BuddyListAdapter)) {
      ((BuddyListAdapter)localExpandableListAdapter).b(paramBoolean);
    }
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.ContactsFPSPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */