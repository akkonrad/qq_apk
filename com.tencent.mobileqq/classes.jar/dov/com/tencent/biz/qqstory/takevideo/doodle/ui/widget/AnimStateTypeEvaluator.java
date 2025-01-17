package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import aobl;
import java.util.ArrayList;

public class AnimStateTypeEvaluator
  implements TypeEvaluator
{
  private long jdField_a_of_type_Long;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList b = new ArrayList();
  private ArrayList c = new ArrayList();
  private ArrayList d = new ArrayList();
  private ArrayList e = new ArrayList();
  
  public int a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, TimeInterpolator paramTimeInterpolator)
  {
    int i = this.c.size();
    paramString = new aobl(paramLong1, paramLong2, i);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.c.add(Integer.valueOf(paramInt1));
    this.d.add(Integer.valueOf(paramInt2));
    this.e.add(paramTimeInterpolator);
    if (paramLong1 + paramLong2 > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = (paramLong1 + paramLong2);
    }
    return i;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ArrayList a()
  {
    return this.d;
  }
  
  public ArrayList a(float paramFloat, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1.isEmpty()) || (paramArrayList2.isEmpty())) {
      return null;
    }
    if (paramArrayList1.size() != paramArrayList2.size()) {
      return null;
    }
    int j = paramArrayList1.size();
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.clear();
    int i = 0;
    if (i < j)
    {
      int k = ((Integer)paramArrayList1.get(i)).intValue();
      int m = ((Integer)paramArrayList2.get(i)).intValue();
      long l1 = ((aobl)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long;
      long l2 = ((aobl)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b;
      int n = (int)((float)this.jdField_a_of_type_Long * paramFloat);
      if (n < l1) {
        this.b.add(Integer.valueOf(0));
      }
      for (;;)
      {
        i += 1;
        break;
        if (n > l1 + l2)
        {
          this.b.add(Integer.valueOf(m));
        }
        else
        {
          float f1 = ((TimeInterpolator)this.e.get(i)).getInterpolation((float)(n - l1) / (float)l2);
          ArrayList localArrayList = this.b;
          float f2 = k;
          localArrayList.add(Integer.valueOf((int)(f1 * (m - k) + f2)));
        }
      }
    }
    return this.b;
  }
  
  public ArrayList a(long paramLong)
  {
    return a((float)paramLong / (float)this.jdField_a_of_type_Long, this.c, this.d);
  }
  
  public ArrayList b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.AnimStateTypeEvaluator
 * JD-Core Version:    0.7.0.1
 */