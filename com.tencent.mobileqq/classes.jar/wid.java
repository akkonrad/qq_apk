import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;

public class wid
  implements Runnable
{
  public wid(ClassificationSearchFragment paramClassificationSearchFragment, SearchResult paramSearchResult) {}
  
  public void run()
  {
    ClassificationSearchFragment localClassificationSearchFragment;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult != null)
    {
      localClassificationSearchFragment = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.a) {
        break label30;
      }
    }
    label30:
    for (int i = 1;; i = 0)
    {
      ClassificationSearchFragment.a(localClassificationSearchFragment, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wid
 * JD-Core Version:    0.7.0.1
 */