import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.CommentLikeObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter.SecondCommentOperationCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public final class ljt
  implements ArticleCommentModule.CommentLikeObserver
{
  public ljt(int paramInt, ReadInJoySecondCommentListAdapter.SecondCommentOperationCallback paramSecondCommentOperationCallback) {}
  
  public void a(ArticleInfo paramArticleInfo, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentUtils", 2, "zan cancel success,comment type =" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter$SecondCommentOperationCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter$SecondCommentOperationCallback.a(paramString, null, 4, null);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentUtils", 2, "zan cancel failed,comment type =" + this.jdField_a_of_type_Int + "comment id =" + paramString1 + "err code = " + paramInt + "errMsg =" + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljt
 * JD-Core Version:    0.7.0.1
 */