import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mobileqq.troop.utils.RollangleImageView;

public class eqc
  extends AsyncTask
{
  private RollangleImageView b;
  
  public eqc(RollangleImageView paramRollangleImageView) {}
  
  protected Bitmap a(Boolean... paramVarArgs)
  {
    return RollangleImageView.a(this.a, paramVarArgs[0].booleanValue());
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqc
 * JD-Core Version:    0.7.0.1
 */