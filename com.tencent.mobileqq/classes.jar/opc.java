import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;

class opc
  implements Runnable
{
  opc(opb paramopb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
    }
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opc
 * JD-Core Version:    0.7.0.1
 */