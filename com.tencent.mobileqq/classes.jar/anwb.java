import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExtractAudioListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer;

public class anwb
  implements FFmpegUtils.ExtractAudioListener
{
  public anwb(HWEditImportVideoPlayer paramHWEditImportVideoPlayer) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "extractAudioFromMp4 success");
    }
    this.a.a(new anwc(this), 0L);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "extractAudioFromMp4 fail " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwb
 * JD-Core Version:    0.7.0.1
 */