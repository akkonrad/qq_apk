import common.qzone.component.cache.common.SoftHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class iec
  implements Iterator
{
  int jdField_a_of_type_Int;
  idz jdField_a_of_type_Idz = null;
  Object jdField_a_of_type_JavaLangObject = null;
  int jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
  idz jdField_b_of_type_Idz = null;
  Object jdField_b_of_type_JavaLangObject = null;
  
  iec(SoftHashMap paramSoftHashMap)
  {
    if (paramSoftHashMap.size() != 0) {}
    for (int i = SoftHashMap.a(paramSoftHashMap).length;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  protected idz a()
  {
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    if ((this.jdField_a_of_type_JavaLangObject == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    this.jdField_b_of_type_Idz = this.jdField_a_of_type_Idz;
    this.jdField_a_of_type_Idz = idz.a(this.jdField_a_of_type_Idz);
    this.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = null;
    return this.jdField_b_of_type_Idz;
  }
  
  public boolean hasNext()
  {
    idz[] arrayOfidz = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    while (this.jdField_a_of_type_JavaLangObject == null)
    {
      idz localidz = this.jdField_a_of_type_Idz;
      int i = this.jdField_a_of_type_Int;
      while ((localidz == null) && (i > 0))
      {
        i -= 1;
        localidz = arrayOfidz[i];
      }
      this.jdField_a_of_type_Idz = localidz;
      this.jdField_a_of_type_Int = i;
      if (localidz == null)
      {
        this.jdField_b_of_type_JavaLangObject = null;
        return false;
      }
      this.jdField_a_of_type_JavaLangObject = localidz.get();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_Idz = idz.a(this.jdField_a_of_type_Idz);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.jdField_b_of_type_Idz == null) {
      throw new IllegalStateException();
    }
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap.remove(this.jdField_b_of_type_JavaLangObject);
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_b_of_type_Idz = null;
    this.jdField_b_of_type_JavaLangObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     iec
 * JD-Core Version:    0.7.0.1
 */