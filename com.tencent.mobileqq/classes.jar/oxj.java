import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class oxj
  extends oxo
{
  oxj(oxe paramoxe, long paramLong, VideoCombineHelper.Callback paramCallback, File paramFile)
  {
    super(paramoxe.a);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxj
 * JD-Core Version:    0.7.0.1
 */