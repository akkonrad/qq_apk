import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;

public final class aiun
  implements Parcelable.Creator
{
  public MediaPreviewInfo a(Parcel paramParcel)
  {
    MediaPreviewInfo localMediaPreviewInfo = new MediaPreviewInfo();
    localMediaPreviewInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localMediaPreviewInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localMediaPreviewInfo.b = paramParcel.readString();
    localMediaPreviewInfo.c = paramParcel.readString();
    return localMediaPreviewInfo;
  }
  
  public MediaPreviewInfo[] a(int paramInt)
  {
    return new MediaPreviewInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiun
 * JD-Core Version:    0.7.0.1
 */