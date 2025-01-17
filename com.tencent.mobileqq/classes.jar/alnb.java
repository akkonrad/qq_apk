import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.QidianProfileCardActivity;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class alnb
  extends URLDrawableDownListener.Adapter
{
  String jdField_a_of_type_JavaLangString = "";
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = true;
  WeakReference b = null;
  WeakReference c = null;
  WeakReference d = null;
  
  public alnb(QidianProfileCardActivity paramQidianProfileCardActivity, QQAppInterface paramQQAppInterface, URLImageView paramURLImageView, String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramURLImageView);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = new WeakReference(paramQQAppInterface);
    this.c = new WeakReference(paramDrawable);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.d = new WeakReference(paramQidianProfileCardActivity);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramView, paramURLDrawable);
    paramView = (URLImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    QidianProfileCardActivity localQidianProfileCardActivity = (QidianProfileCardActivity)this.d.get();
    if ((paramView != null) && (localQQAppInterface != null) && (localQidianProfileCardActivity != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      paramURLDrawable = new BitmapDrawable(QidianProfileCardActivity.a(localQQAppInterface, paramURLDrawable, this.jdField_a_of_type_Boolean));
      if (this.jdField_a_of_type_Boolean) {
        localQidianProfileCardActivity.b.put(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
      }
      paramView.setImageDrawable(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alnb
 * JD-Core Version:    0.7.0.1
 */