import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;

public class aoey
{
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public aoey(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372035));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372036));
    this.b = ((TextView)paramView.findViewById(2131372037));
    this.c = ((TextView)paramView.findViewById(2131372039));
    this.d = ((TextView)paramView.findViewById(2131372038));
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramString);
  }
  
  public void a(TagItem paramTagItem1, TagItem paramTagItem2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramTagItem1.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.jdField_a_of_type_JavaLangString);
    a(this.b, paramTagItem1.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.b);
    if (paramTagItem1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramTagItem1.jdField_a_of_type_JavaLangString);
      if (!paramTagItem1.equals(paramTagItem2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843751);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFA34B"));
      return;
      a(this.c, paramTagItem1.jdField_a_of_type_Int + "人参与");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843755);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoey
 * JD-Core Version:    0.7.0.1
 */