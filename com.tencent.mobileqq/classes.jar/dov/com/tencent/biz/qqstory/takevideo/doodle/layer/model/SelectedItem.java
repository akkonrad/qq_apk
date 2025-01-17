package dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class SelectedItem
{
  public final int a;
  public final Drawable a;
  public final String a;
  public final String b;
  
  public SelectedItem(@NonNull String paramString1, @NonNull String paramString2, Drawable paramDrawable, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SelectedItem{");
    localStringBuilder.append("category='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", name='").append(this.b).append('\'');
    localStringBuilder.append(", drawable=").append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStringBuilder.append(", isDynamic=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem
 * JD-Core Version:    0.7.0.1
 */