package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.opengl.GLES20;
import com.tencent.filter.Frame;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class PersonalityLinePath
  extends DoodleLinePath
{
  Frame jdField_a_of_type_ComTencentFilterFrame;
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  volatile boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  volatile boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  volatile boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  boolean e = false;
  
  public PersonalityLinePath(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public Frame a(int paramInt1, int paramInt2)
  {
    this.d = RendererUtils.createTexture();
    this.jdField_a_of_type_ComTencentFilterFrame = new Frame();
    GLES20.glBindTexture(3553, this.d);
    this.jdField_a_of_type_ComTencentFilterFrame.bindFrame(this.d, paramInt1, paramInt2, 1.0D);
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentFilterFrame.getFBO());
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    return this.jdField_a_of_type_ComTencentFilterFrame;
  }
  
  public void a()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentFilterFrame != null) && (!this.e))
    {
      this.e = true;
      this.jdField_a_of_type_ComTencentFilterFrame.clear();
      RendererUtils.clearTexture(this.d);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityLinePath
 * JD-Core Version:    0.7.0.1
 */