import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;

class xth
  implements Runnable
{
  xth(xtf paramxtf, int paramInt) {}
  
  public void run()
  {
    if (QzDynamicVideoPreviewActivity.d(this.jdField_a_of_type_Xtf.a)) {
      QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_Xtf.a);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_Int != -1)
      {
        QQToast.a(this.jdField_a_of_type_Xtf.a, "合成错误(" + this.jdField_a_of_type_Int + ")，请稍后重试", 0).a();
        return;
      }
      break;
    case 4: 
    case 5: 
      QQToast.a(this.jdField_a_of_type_Xtf.a, "存在不支持格式的素材，合成错误(" + this.jdField_a_of_type_Int + ")", 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Xtf.a, "合成错误，请稍后重试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xth
 * JD-Core Version:    0.7.0.1
 */