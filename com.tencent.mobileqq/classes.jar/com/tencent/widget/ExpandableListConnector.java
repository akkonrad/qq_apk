package com.tencent.widget;

import ambk;
import android.annotation.TargetApi;
import android.database.DataSetObserver;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Collections;

public class ExpandableListConnector
  extends BaseAdapter
  implements Filterable
{
  private int jdField_a_of_type_Int;
  private final DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new ExpandableListConnector.MyDataSetObserver(this);
  private ExpandableListAdapter jdField_a_of_type_AndroidWidgetExpandableListAdapter;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b = 2147483647;
  
  public ExpandableListConnector(ExpandableListAdapter paramExpandableListAdapter)
  {
    a(paramExpandableListAdapter);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = localArrayList.size();
    this.jdField_a_of_type_Int = 0;
    int j = i;
    int n;
    int k;
    ExpandableListConnector.GroupMetadata localGroupMetadata;
    int m;
    if (paramBoolean2)
    {
      n = i - 1;
      k = 0;
      if (n >= 0)
      {
        localGroupMetadata = (ExpandableListConnector.GroupMetadata)localArrayList.get(n);
        int i2 = a(localGroupMetadata.jdField_a_of_type_Long, localGroupMetadata.c);
        m = i;
        if (i2 == localGroupMetadata.c) {
          break label289;
        }
        j = i;
        if (i2 == -1)
        {
          localArrayList.remove(n);
          j = i - 1;
        }
        localGroupMetadata.c = i2;
        m = j;
        if (k != 0) {
          break label289;
        }
        k = 1;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      n -= 1;
      k = j;
      break;
      j = i;
      if (k != 0)
      {
        Collections.sort(localArrayList);
        j = i;
      }
      k = 0;
      m = 0;
      i = i1;
      if (i < j)
      {
        localGroupMetadata = (ExpandableListConnector.GroupMetadata)localArrayList.get(i);
        if ((localGroupMetadata.b == -1) || (paramBoolean1)) {}
        for (n = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(localGroupMetadata.c);; n = localGroupMetadata.b - localGroupMetadata.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_Int += n;
          m += localGroupMetadata.c - k;
          k = localGroupMetadata.c;
          localGroupMetadata.jdField_a_of_type_Int = m;
          m = n + m;
          localGroupMetadata.b = m;
          i += 1;
          break;
        }
      }
      return;
      label289:
      j = k;
      i = m;
    }
  }
  
  int a(long paramLong, int paramInt)
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupCount();
    int m;
    if (i1 == 0)
    {
      m = -1;
      return m;
    }
    if (paramLong == -9223372036854775808L) {
      return -1;
    }
    paramInt = Math.min(i1 - 1, Math.max(0, paramInt));
    long l = SystemClock.uptimeMillis();
    int i = 0;
    ExpandableListAdapter localExpandableListAdapter = a();
    label66:
    int n;
    int j;
    if (localExpandableListAdapter == null)
    {
      return -1;
      if ((n != 0) || ((i != 0) && (m == 0)))
      {
        j += 1;
        i = 0;
        paramInt = j;
      }
    }
    for (;;)
    {
      int k;
      if (SystemClock.uptimeMillis() <= l + 100L)
      {
        m = paramInt;
        if (localExpandableListAdapter.getGroupId(paramInt) == paramLong) {
          break;
        }
        if (j != i1 - 1) {
          break label154;
        }
        m = 1;
        if (k != 0) {
          break label160;
        }
      }
      label154:
      label160:
      for (n = 1;; n = 0)
      {
        if ((m == 0) || (n == 0)) {
          break label164;
        }
        return -1;
        m = 0;
        break;
      }
      label164:
      break label66;
      if ((m != 0) || ((i == 0) && (n == 0)))
      {
        k -= 1;
        i = 1;
        paramInt = k;
        continue;
        k = paramInt;
        m = paramInt;
        j = paramInt;
        paramInt = m;
      }
    }
  }
  
  ExpandableListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter;
  }
  
  ExpandableListConnector.PositionMetadata a(int paramInt)
  {
    int k = 0;
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int i = ((ArrayList)localObject).size();
    if (i == 0) {
      return ExpandableListConnector.PositionMetadata.a(paramInt, 2, paramInt, -1, null, 0);
    }
    for (;;)
    {
      int j;
      if (i <= j)
      {
        int m = (j - i) / 2 + i;
        ExpandableListConnector.GroupMetadata localGroupMetadata = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(m);
        if (paramInt > localGroupMetadata.b)
        {
          i = m + 1;
          k = m;
        }
        else if (paramInt < localGroupMetadata.jdField_a_of_type_Int)
        {
          j = m - 1;
          k = m;
        }
        else
        {
          if (paramInt == localGroupMetadata.jdField_a_of_type_Int) {
            return ExpandableListConnector.PositionMetadata.a(paramInt, 2, localGroupMetadata.c, -1, localGroupMetadata, m);
          }
          k = m;
          if (paramInt <= localGroupMetadata.b)
          {
            i = localGroupMetadata.jdField_a_of_type_Int;
            return ExpandableListConnector.PositionMetadata.a(paramInt, 1, localGroupMetadata.c, paramInt - (i + 1), localGroupMetadata, m);
          }
        }
      }
      else
      {
        if (i > k)
        {
          localObject = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(i - 1);
          k = paramInt - ((ExpandableListConnector.GroupMetadata)localObject).b + ((ExpandableListConnector.GroupMetadata)localObject).c;
          j = i;
        }
        for (i = k;; i = ((ExpandableListConnector.GroupMetadata)localObject).c - (((ExpandableListConnector.GroupMetadata)localObject).jdField_a_of_type_Int - paramInt))
        {
          return ExpandableListConnector.PositionMetadata.a(paramInt, 2, i, -1, null, j);
          if (j >= k) {
            break;
          }
          j += 1;
          localObject = (ExpandableListConnector.GroupMetadata)((ArrayList)localObject).get(j);
        }
        throw new RuntimeException("Unknown state");
        j = i - 1;
        i = 0;
      }
    }
  }
  
  ExpandableListConnector.PositionMetadata a(ambk paramambk)
  {
    int j = 0;
    Object localObject2 = null;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = localArrayList.size();
    Object localObject1;
    if (i == 0)
    {
      localObject1 = ExpandableListConnector.PositionMetadata.a(paramambk.jdField_a_of_type_Int, paramambk.d, paramambk.jdField_a_of_type_Int, paramambk.b, null, 0);
      return localObject1;
    }
    for (;;)
    {
      if (k <= i)
      {
        int m = (i - k) / 2 + k;
        ExpandableListConnector.GroupMetadata localGroupMetadata = (ExpandableListConnector.GroupMetadata)localArrayList.get(m);
        if (paramambk.jdField_a_of_type_Int > localGroupMetadata.c)
        {
          k = m + 1;
          j = m;
          continue;
        }
        if (paramambk.jdField_a_of_type_Int < localGroupMetadata.c)
        {
          i = m - 1;
          j = m;
          continue;
        }
        j = m;
        if (paramambk.jdField_a_of_type_Int != localGroupMetadata.c) {
          continue;
        }
        if (paramambk.d == 2) {
          return ExpandableListConnector.PositionMetadata.a(localGroupMetadata.jdField_a_of_type_Int, paramambk.d, paramambk.jdField_a_of_type_Int, paramambk.b, localGroupMetadata, m);
        }
        localObject1 = localObject2;
        if (paramambk.d != 1) {
          break;
        }
        return ExpandableListConnector.PositionMetadata.a(localGroupMetadata.jdField_a_of_type_Int + paramambk.b + 1, paramambk.d, paramambk.jdField_a_of_type_Int, paramambk.b, localGroupMetadata, m);
      }
      localObject1 = localObject2;
      if (paramambk.d != 2) {
        break;
      }
      if (k > j)
      {
        localObject1 = (ExpandableListConnector.GroupMetadata)localArrayList.get(k - 1);
        i = ((ExpandableListConnector.GroupMetadata)localObject1).b;
        return ExpandableListConnector.PositionMetadata.a(paramambk.jdField_a_of_type_Int - ((ExpandableListConnector.GroupMetadata)localObject1).c + i, paramambk.d, paramambk.jdField_a_of_type_Int, paramambk.b, null, k);
      }
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      i += 1;
      localObject1 = (ExpandableListConnector.GroupMetadata)localArrayList.get(i);
      return ExpandableListConnector.PositionMetadata.a(((ExpandableListConnector.GroupMetadata)localObject1).jdField_a_of_type_Int - (((ExpandableListConnector.GroupMetadata)localObject1).c - paramambk.jdField_a_of_type_Int), paramambk.d, paramambk.jdField_a_of_type_Int, paramambk.b, null, i);
      i -= 1;
      int k = 0;
    }
  }
  
  ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(ExpandableListAdapter paramExpandableListAdapter)
  {
    if (this.jdField_a_of_type_AndroidWidgetExpandableListAdapter != null) {
      this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    this.jdField_a_of_type_AndroidWidgetExpandableListAdapter = paramExpandableListAdapter;
    paramExpandableListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
  }
  
  void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (this.jdField_a_of_type_AndroidWidgetExpandableListAdapter == null)) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupCount();
    int i = paramArrayList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label55;
      }
      if (((ExpandableListConnector.GroupMetadata)paramArrayList.get(i)).c >= j) {
        break;
      }
      i -= 1;
    }
    label55:
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    a(true, false);
  }
  
  boolean a(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = a(ambk.a(2, paramInt, -1, -1));
    if (localPositionMetadata == null) {
      return false;
    }
    boolean bool = a(localPositionMetadata);
    localPositionMetadata.a();
    return bool;
  }
  
  boolean a(ExpandableListConnector.PositionMetadata paramPositionMetadata)
  {
    if (paramPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata);
    a(false, false);
    notifyDataSetChanged();
    this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.onGroupCollapsed(paramPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.c);
    return true;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.areAllItemsEnabled();
  }
  
  public boolean b(int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      if (((ExpandableListConnector.GroupMetadata)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  boolean b(ExpandableListConnector.PositionMetadata paramPositionMetadata)
  {
    if (paramPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int < 0) {
      throw new RuntimeException("Need group");
    }
    if (this.b == 0) {
      return false;
    }
    if (paramPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata != null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.b)
    {
      localGroupMetadata = (ExpandableListConnector.GroupMetadata)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localGroupMetadata);
      a(localGroupMetadata.c);
      if (paramPositionMetadata.jdField_a_of_type_Int > i) {
        paramPositionMetadata.jdField_a_of_type_Int -= 1;
      }
    }
    ExpandableListConnector.GroupMetadata localGroupMetadata = ExpandableListConnector.GroupMetadata.a(-1, -1, paramPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupId(paramPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramPositionMetadata.jdField_a_of_type_Int, localGroupMetadata);
    a(false, false);
    notifyDataSetChanged();
    this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.onGroupExpanded(localGroupMetadata.c);
    return true;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupCount() + this.jdField_a_of_type_Int;
  }
  
  public Filter getFilter()
  {
    ExpandableListAdapter localExpandableListAdapter = a();
    if ((localExpandableListAdapter instanceof Filterable)) {
      return ((Filterable)localExpandableListAdapter).getFilter();
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = a(paramInt);
    if (localPositionMetadata.jdField_a_of_type_Ambk.d == 2) {}
    for (Object localObject = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroup(localPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int);; localObject = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChild(localPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int, localPositionMetadata.jdField_a_of_type_Ambk.b))
    {
      localPositionMetadata.a();
      return localObject;
      if (localPositionMetadata.jdField_a_of_type_Ambk.d != 1) {
        break;
      }
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  public long getItemId(int paramInt)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = a(paramInt);
    long l1 = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupId(localPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int);
    if (localPositionMetadata.jdField_a_of_type_Ambk.d == 2) {}
    long l2;
    for (l1 = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getCombinedGroupId(l1);; l1 = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getCombinedChildId(l1, l2))
    {
      localPositionMetadata.a();
      return l1;
      if (localPositionMetadata.jdField_a_of_type_Ambk.d != 1) {
        break;
      }
      l2 = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildId(localPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int, localPositionMetadata.jdField_a_of_type_Ambk.b);
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  @TargetApi(8)
  public int getItemViewType(int paramInt)
  {
    ambk localambk = a(paramInt).jdField_a_of_type_Ambk;
    HeterogeneousExpandableList localHeterogeneousExpandableList;
    if ((VersionUtils.b()) && ((this.jdField_a_of_type_AndroidWidgetExpandableListAdapter instanceof HeterogeneousExpandableList)))
    {
      localHeterogeneousExpandableList = (HeterogeneousExpandableList)this.jdField_a_of_type_AndroidWidgetExpandableListAdapter;
      if (localambk.d == 2) {
        paramInt = localHeterogeneousExpandableList.getGroupType(localambk.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      localambk.a();
      return paramInt;
      paramInt = localHeterogeneousExpandableList.getChildType(localambk.jdField_a_of_type_Int, localambk.b);
      paramInt = localHeterogeneousExpandableList.getGroupTypeCount() + paramInt;
      continue;
      if (localambk.d == 2) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    ExpandableListConnector.PositionMetadata localPositionMetadata = a(paramInt);
    if (localPositionMetadata.jdField_a_of_type_Ambk.d == 2)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupView(localPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int, localPositionMetadata.a(), paramView, paramViewGroup);
      localPositionMetadata.a();
      return paramView;
    }
    if (localPositionMetadata.jdField_a_of_type_Ambk.d == 1)
    {
      if (localPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.b == paramInt) {}
      for (;;)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildView(localPositionMetadata.jdField_a_of_type_Ambk.jdField_a_of_type_Int, localPositionMetadata.jdField_a_of_type_Ambk.b, bool, paramView, paramViewGroup);
        break;
        bool = false;
      }
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  @TargetApi(8)
  public int getViewTypeCount()
  {
    if ((VersionUtils.b()) && ((this.jdField_a_of_type_AndroidWidgetExpandableListAdapter instanceof HeterogeneousExpandableList)))
    {
      HeterogeneousExpandableList localHeterogeneousExpandableList = (HeterogeneousExpandableList)this.jdField_a_of_type_AndroidWidgetExpandableListAdapter;
      int i = localHeterogeneousExpandableList.getGroupTypeCount();
      return localHeterogeneousExpandableList.getChildTypeCount() + i;
    }
    return 2;
  }
  
  public boolean hasStableIds()
  {
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    ExpandableListAdapter localExpandableListAdapter = a();
    if (localExpandableListAdapter != null) {
      return localExpandableListAdapter.isEmpty();
    }
    return true;
  }
  
  public boolean isEnabled(int paramInt)
  {
    boolean bool = true;
    ambk localambk = a(paramInt).jdField_a_of_type_Ambk;
    if (localambk.d == 1) {
      bool = this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.isChildSelectable(localambk.jdField_a_of_type_Int, localambk.b);
    }
    localambk.a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector
 * JD-Core Version:    0.7.0.1
 */