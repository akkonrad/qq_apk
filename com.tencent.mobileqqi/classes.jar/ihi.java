import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureCutInfo;

public final class ihi
  implements Parcelable.Creator
{
  public PhotoInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localPhotoInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localPhotoInfo.c = paramParcel.readString();
    localPhotoInfo.d = paramParcel.readString();
    localPhotoInfo.e = paramParcel.readString();
    localPhotoInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localPhotoInfo.jdField_g_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoInfo.jdField_a_of_type_Boolean = bool1;
      localPhotoInfo.f = paramParcel.readString();
      localPhotoInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_i_of_type_JavaLangString = paramParcel.readString();
      localPhotoInfo.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoInfo.jdField_h_of_type_Int = paramParcel.readInt();
      localPhotoInfo.jdField_i_of_type_Int = paramParcel.readInt();
      localPhotoInfo.j = paramParcel.readInt();
      localPhotoInfo.jdField_a_of_type_CooperationQzoneModelPictureCutInfo = ((PictureCutInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localPhotoInfo.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage = ((GpsInfo4LocalImage)paramParcel.readParcelable(getClass().getClassLoader()));
      if (paramParcel.readInt() != 1) {
        break label258;
      }
    }
    label258:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoInfo.jdField_b_of_type_Boolean = bool1;
      localPhotoInfo.jdField_a_of_type_Long = paramParcel.readLong();
      localPhotoInfo.jdField_b_of_type_Long = paramParcel.readLong();
      return localPhotoInfo;
      bool1 = false;
      break;
    }
  }
  
  public PhotoInfo[] a(int paramInt)
  {
    return new PhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ihi
 * JD-Core Version:    0.7.0.1
 */