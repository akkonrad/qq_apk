package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class LocationFacePackage
  extends FacePackage
{
  public List a;
  public boolean b;
  public String f;
  
  public LocationFacePackage(@NonNull String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      LocationFacePackage.Item localItem = new LocationFacePackage.Item(paramJSONArray.getJSONObject(i));
      localArrayList.add(localItem);
      if (QLog.isColorLevel()) {
        QLog.d("LocationFacePackage", 2, "getItemFromJsonArray " + localItem);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public LocationFacePackage.Item a(String paramString)
  {
    if ((!StringUtil.a(paramString)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LocationFacePackage.Item localItem = (LocationFacePackage.Item)localIterator.next();
        if (paramString.equals(localItem.f)) {
          return localItem;
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return "LocationFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((LocationFacePackage.Item)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    }
    throw new IndexOutOfBoundsException("getThumbUri with illegal index : " + paramInt + ", the item size is : " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((LocationFacePackage.Item)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b;
    }
    throw new IndexOutOfBoundsException("getCategory with illegal index : " + paramInt + ", the item size is : " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocationFacePackage{");
    localStringBuffer.append("id='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append("logoUrl='").append(this.c).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).append('\'');
    localStringBuffer.append("items=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", isLocating=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage
 * JD-Core Version:    0.7.0.1
 */