import android.media.MediaFormat;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.qphone.base.util.QLog;

class aiby
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  
  aiby(aibu paramaibu) {}
  
  void a()
  {
    a("releaseMuxer[resetValidData]");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  void a(MediaFormat paramMediaFormat)
  {
    if ((paramMediaFormat.containsKey("csd-0")) && (paramMediaFormat.containsKey("csd-1"))) {
      this.d = true;
    }
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVHwEncoder", 2, paramString + ": mHasKeyFrame=" + this.jdField_a_of_type_Boolean + " mVideoFirst=" + this.jdField_b_of_type_Boolean + " mFirstIsKey=" + this.c + " mVideoConfigOK=" + this.d + " mAudioConfigOK=" + this.e + " mVideoMuxeredframeCount=" + aibu.a(this.jdField_a_of_type_Aibu) + " mAudioMuxeredframeCount=" + aibu.b(this.jdField_a_of_type_Aibu) + " mVideoOrderError=" + this.f + " mAudioOrderError=" + this.g + " mVideoOrderErrorCnt=" + this.jdField_a_of_type_Int + " mAudioOrderErrorCnt=" + this.jdField_b_of_type_Int);
    }
  }
  
  boolean a()
  {
    this.jdField_a_of_type_Aibu.a.a("releaseMuxer[audioSpecOK]", "mNeedEncodeAudio=" + aibu.a(this.jdField_a_of_type_Aibu) + " mAudioConfigOK=" + this.e);
    if (aibu.a(this.jdField_a_of_type_Aibu)) {
      return this.e;
    }
    return true;
  }
  
  boolean a(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Long <= paramLong) {
        break label83;
      }
      this.f = true;
      this.jdField_a_of_type_Int += 1;
    }
    label83:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      this.jdField_a_of_type_Long = paramLong;
      return paramBoolean;
      if (this.jdField_b_of_type_Long > paramLong)
      {
        this.g = true;
        this.jdField_b_of_type_Int += 1;
      }
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        this.jdField_b_of_type_Long = paramLong;
        return paramBoolean;
      }
    }
  }
  
  void b(MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat.containsKey("csd-0")) {
      this.e = true;
    }
  }
  
  boolean b()
  {
    this.jdField_a_of_type_Aibu.a.a("releaseMuxer[videoSpecOK]", "mNeedEncodeVideo=" + aibu.b(this.jdField_a_of_type_Aibu) + " mVideoConfigOK=" + this.d);
    return (!aibu.b(this.jdField_a_of_type_Aibu)) || ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.c) && (this.d) && (!this.f));
  }
  
  boolean c()
  {
    return (a()) && (b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aiby
 * JD-Core Version:    0.7.0.1
 */