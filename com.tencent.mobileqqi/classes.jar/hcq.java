import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;

class hcq
  implements Runnable
{
  hcq(hcp paramhcp, Object paramObject) {}
  
  public void run()
  {
    AvatarWallAdapter.m = 0;
    this.jdField_a_of_type_Hcp.a.n = 0;
    int i = this.jdField_a_of_type_Hcp.a.b - this.jdField_a_of_type_Hcp.a.j;
    if (i >= 8) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (TroopUploadingThread.UploadState)this.jdField_a_of_type_JavaLangObject;
          if (((TroopUploadingThread.UploadState)localObject).a != 1) {
            break;
          }
          this.jdField_a_of_type_Hcp.a.a(i, ((TroopUploadingThread.UploadState)localObject).b, ((TroopUploadingThread.UploadState)localObject).c);
        } while (this.jdField_a_of_type_Hcp.a.a(this.jdField_a_of_type_Hcp.a.g));
        this.jdField_a_of_type_Hcp.a.d = false;
        this.jdField_a_of_type_Hcp.a.b();
        return;
      } while (((TroopUploadingThread.UploadState)localObject).a != 2);
      localObject = this.jdField_a_of_type_Hcp.a.a(((TroopUploadingThread.UploadState)localObject).b);
    } while (localObject == null);
    this.jdField_a_of_type_Hcp.a.a((String)localObject, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hcq
 * JD-Core Version:    0.7.0.1
 */