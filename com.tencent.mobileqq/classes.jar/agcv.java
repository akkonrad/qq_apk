import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

public final class agcv
  implements Parcelable.Creator
{
  public OcrRecogResult a(Parcel paramParcel)
  {
    return new OcrRecogResult(paramParcel);
  }
  
  public OcrRecogResult[] a(int paramInt)
  {
    return new OcrRecogResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcv
 * JD-Core Version:    0.7.0.1
 */