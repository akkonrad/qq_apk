package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;

public abstract class BaseFaceListAdapter
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected IFaceSelectedListener a;
  protected FacePackage a;
  
  public BaseFaceListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
  }
  
  public void a(FacePackage paramFacePackage)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = paramFacePackage;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceList", 2, "facePkg is null");
      }
      return 0;
    }
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.b();
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a();
    if (j < 1) {
      throw new IllegalArgumentException("per item count < 1 :" + j);
    }
    if ((QLog.isColorLevel()) && (i == 0)) {
      QLog.d("FaceList", 2, "totalFaceCount = 0");
    }
    if (i % j == 0) {
      return i / j;
    }
    return i / j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter
 * JD-Core Version:    0.7.0.1
 */