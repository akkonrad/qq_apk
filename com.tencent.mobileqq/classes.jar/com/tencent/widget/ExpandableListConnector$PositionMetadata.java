package com.tencent.widget;

import ambk;
import java.util.ArrayList;

public class ExpandableListConnector$PositionMetadata
{
  private static ArrayList a;
  public int a;
  public ambk a;
  public ExpandableListConnector.GroupMetadata a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private static PositionMetadata a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localPositionMetadata = (PositionMetadata)jdField_a_of_type_JavaUtilArrayList.remove(0);
        localPositionMetadata.b();
        return localPositionMetadata;
      }
      PositionMetadata localPositionMetadata = new PositionMetadata();
      return localPositionMetadata;
    }
  }
  
  static PositionMetadata a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    PositionMetadata localPositionMetadata = a();
    localPositionMetadata.jdField_a_of_type_Ambk = ambk.a(paramInt2, paramInt3, paramInt4, paramInt1);
    localPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
    localPositionMetadata.jdField_a_of_type_Int = paramInt5;
    return localPositionMetadata;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Ambk = null;
    this.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.size() < 5) {
        jdField_a_of_type_JavaUtilArrayList.add(this);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector.PositionMetadata
 * JD-Core Version:    0.7.0.1
 */