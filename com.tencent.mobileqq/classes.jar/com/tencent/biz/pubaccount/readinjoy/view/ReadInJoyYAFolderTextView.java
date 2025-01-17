package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mjn;

public class ReadInJoyYAFolderTextView
  extends TextView
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { '…' };
  private static final String jdField_c_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
  private int jdField_a_of_type_Int = 5;
  private TextView.BufferType jdField_a_of_type_AndroidWidgetTextView$BufferType;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString = "...";
  private Vector jdField_a_of_type_JavaUtilVector = new Vector();
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "更多";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private int d = -1;
  
  public ReadInJoyYAFolderTextView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = (QQText.EmoticonSpan[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), QQText.EmoticonSpan.class);
    int i = paramSpannableStringBuilder.length();
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[(localObject.length - 1)];
      if (paramSpannableStringBuilder.getSpanEnd(localObject) == i) {
        return new SpannableStringBuilder(paramSpannableStringBuilder, 0, paramSpannableStringBuilder.getSpanStart(localObject));
      }
    }
    return new SpannableStringBuilder(paramSpannableStringBuilder, 0, i - 1);
  }
  
  private void a(DynamicLayout paramDynamicLayout, int paramInt)
  {
    int i = paramDynamicLayout.getLineStart(paramInt - 1);
    paramInt = paramDynamicLayout.getLineEnd(paramInt - 1);
    paramDynamicLayout = paramDynamicLayout.getText();
    String str = paramDynamicLayout.subSequence(i, paramInt).toString();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((str.equals("阅读原文 ".substring(1))) || (str.equals("阅读原文 ".substring(2))) || (str.equals("阅读原文 ".substring(3))))
    {
      localSpannableStringBuilder.append(paramDynamicLayout.subSequence(0, paramDynamicLayout.length() - "阅读原文 ".length())).append('\n').append(paramDynamicLayout.subSequence(paramDynamicLayout.length() - "阅读原文 ".length(), paramDynamicLayout.length()));
      super.setText(localSpannableStringBuilder);
    }
    while (!str.equals(" ")) {
      return;
    }
    localSpannableStringBuilder.append(paramDynamicLayout.subSequence(0, paramDynamicLayout.length() - 1));
    super.setText(localSpannableStringBuilder);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    paramSpannableStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaLangObject != null) {
      paramSpannableStringBuilder.setSpan(this.jdField_a_of_type_JavaLangObject, paramSpannableStringBuilder.length() - this.jdField_b_of_type_JavaLangString.length(), paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void b()
  {
    setMovementMethod(mjn.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext())
      {
        ClickableSpan localClickableSpan = (ClickableSpan)localIterator.next();
        if ((localClickableSpan instanceof ReadInJoyYAFolderTextView.ClickableSpanPressed)) {
          ((ReadInJoyYAFolderTextView.ClickableSpanPressed)localClickableSpan).a(false);
        }
        localIterator.remove();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Int <= 0) || (!this.jdField_b_of_type_Boolean)) {}
    SpannableStringBuilder localSpannableStringBuilder;
    float f1;
    ArrayList localArrayList;
    int i;
    float f2;
    label272:
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = false;
      } while ((this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int <= this.jdField_a_of_type_Int));
      localObject3 = getPaint();
      localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaLangObject != null) {
        localSpannableStringBuilder.setSpan(this.jdField_a_of_type_JavaLangObject, localSpannableStringBuilder.length() - this.jdField_b_of_type_JavaLangString.length(), localSpannableStringBuilder.length(), 33);
      }
      f1 = ((TextPaint)localObject3).measureText(localSpannableStringBuilder, 0, localSpannableStringBuilder.length());
      localSpannableStringBuilder.clear();
      localArrayList = new ArrayList();
      paramInt4 = 0;
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_JavaLangCharSequence.length())
      {
        i = paramInt4;
        if (this.jdField_a_of_type_JavaLangCharSequence.charAt(paramInt2) == '\n')
        {
          localArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(paramInt4, paramInt2));
          i = paramInt2 + 1;
        }
        paramInt2 += 1;
        paramInt4 = i;
      }
      if (paramInt4 != this.jdField_a_of_type_JavaLangCharSequence.length()) {
        localArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(paramInt4, this.jdField_a_of_type_JavaLangCharSequence.length()));
      }
      f2 = paramInt3 - paramInt1;
      paramInt2 = 0;
      i = 0;
      paramInt4 = 0;
      if ((i < this.jdField_a_of_type_Int - 1) && (paramInt2 < localArrayList.size())) {
        break;
      }
    } while (paramInt2 >= localArrayList.size());
    Object localObject1 = (CharSequence)localArrayList.get(paramInt2);
    Object localObject2 = ((CharSequence)localObject1).subSequence(paramInt4, ((CharSequence)localObject1).length());
    Object localObject3 = TextUtils.ellipsize((CharSequence)localObject2, (TextPaint)localObject3, paramInt3 - paramInt1 - f1, TextUtils.TruncateAt.END);
    label389:
    label461:
    int j;
    CharSequence localCharSequence1;
    CharSequence localCharSequence2;
    if (((localObject3 instanceof Spanned)) && (i > 1))
    {
      localObject1 = (ClickableSpan[])((Spanned)localObject3).getSpans(0, ((CharSequence)localObject3).length(), ClickableSpan.class);
      if ((!localObject3.equals(localObject2)) && (((CharSequence)localObject3).length() > 0))
      {
        paramInt3 = localSpannableStringBuilder.length();
        if (((CharSequence)localObject3).charAt(((CharSequence)localObject3).length() - 1) == '…')
        {
          localSpannableStringBuilder.append(((CharSequence)localObject3).subSequence(0, ((CharSequence)localObject3).length() - 1));
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramInt1 = localSpannableStringBuilder.getSpanStart(localObject1[0]);
            paramInt2 = localSpannableStringBuilder.getSpanEnd(localObject1[0]);
            if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 < paramInt3))
            {
              paramInt3 = ((Spanned)localObject3).getSpanStart(localObject1[0]);
              paramInt4 = ((Spanned)localObject3).getSpanEnd(localObject1[0]);
              if ((paramInt3 == 0) && (paramInt4 >= paramInt3))
              {
                paramInt2 = Math.min(paramInt2 + paramInt4 + 1, localSpannableStringBuilder.length());
                localSpannableStringBuilder.setSpan(localObject1[0], paramInt1, paramInt2, 33);
              }
            }
          }
          a(localSpannableStringBuilder);
          super.setText(localSpannableStringBuilder, this.jdField_a_of_type_AndroidWidgetTextView$BufferType);
          return;
          j = i + 1;
          localObject1 = (CharSequence)localArrayList.get(paramInt2);
          localCharSequence1 = ((CharSequence)localObject1).subSequence(paramInt4, ((CharSequence)localObject1).length());
          localObject1 = TextUtils.ellipsize(localCharSequence1, (TextPaint)localObject3, f2, TextUtils.TruncateAt.END);
          if ((((CharSequence)localObject1).length() <= 4) || (!(localObject1 instanceof SpannableStringBuilder))) {
            break label1665;
          }
          localObject2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 3);
          localCharSequence2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
          if ((((CharSequence)localObject1).charAt(((CharSequence)localObject1).length() - 1) != '…') && (((TextPaint)localObject3).measureText(((CharSequence)localObject2).toString()) > paramInt3 - paramInt1)) {
            localObject1 = a((SpannableStringBuilder)localObject2).append(jdField_c_of_type_JavaLangString);
          }
        }
      }
    }
    label1665:
    for (;;)
    {
      label762:
      if (((localObject1 instanceof Spanned)) && (j > 1)) {}
      for (localObject2 = (ClickableSpan[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject1).length(), ClickableSpan.class);; localObject2 = null)
      {
        int k;
        int m;
        if (localObject1.equals(localCharSequence1))
        {
          k = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject1).append('\n');
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            paramInt4 = localSpannableStringBuilder.getSpanStart(localObject2[0]);
            i = localSpannableStringBuilder.getSpanEnd(localObject2[0]);
            if ((paramInt4 >= 0) && (i >= paramInt4) && (i < k))
            {
              k = ((Spanned)localObject1).getSpanStart(localObject2[0]);
              m = ((Spanned)localObject1).getSpanEnd(localObject2[0]);
              if ((k == 0) && (m >= k))
              {
                i = Math.min(i + m + 1, localSpannableStringBuilder.length());
                localSpannableStringBuilder.setSpan(localObject2[0], paramInt4, i, 33);
              }
            }
          }
          paramInt4 = 0;
          paramInt2 += 1;
          i = j;
          break label272;
          if (((TextPaint)localObject3).measureText(localCharSequence2.toString()) <= paramInt3 - paramInt1) {
            break label1665;
          }
          localObject1 = a((SpannableStringBuilder)localCharSequence2).append(jdField_c_of_type_JavaLangString);
          break label762;
        }
        i = paramInt4;
        if (((CharSequence)localObject1).length() > 0)
        {
          k = localSpannableStringBuilder.length();
          if (((CharSequence)localObject1).charAt(((CharSequence)localObject1).length() - 1) != '…') {
            break label1266;
          }
          localSpannableStringBuilder.append(((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1)).append('\n');
          paramInt4 += ((CharSequence)localObject1).length() - 1;
        }
        for (;;)
        {
          i = paramInt4;
          if (localObject2 != null)
          {
            i = paramInt4;
            if (localObject2.length > 0)
            {
              m = localSpannableStringBuilder.getSpanStart(localObject2[0]);
              int n = localSpannableStringBuilder.getSpanEnd(localObject2[0]);
              i = paramInt4;
              if (m >= 0)
              {
                i = paramInt4;
                if (n >= m)
                {
                  i = paramInt4;
                  if (n < k)
                  {
                    k = ((Spanned)localObject1).getSpanStart(localObject2[0]);
                    int i1 = ((Spanned)localObject1).getSpanEnd(localObject2[0]);
                    i = paramInt4;
                    if (k == 0)
                    {
                      i = paramInt4;
                      if (i1 >= k)
                      {
                        i = Math.min(n + i1 + 1, localSpannableStringBuilder.length());
                        localSpannableStringBuilder.setSpan(localObject2[0], m, i, 33);
                        i = paramInt4;
                      }
                    }
                  }
                }
              }
            }
          }
          paramInt4 = i;
          break;
          label1266:
          localSpannableStringBuilder.append(((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 3)).append('\n');
          paramInt4 += ((CharSequence)localObject1).length() - 3;
        }
        localSpannableStringBuilder.append(((CharSequence)localObject3).subSequence(0, ((CharSequence)localObject3).length() - 3));
        break label461;
        if (paramInt2 != localArrayList.size() - 1)
        {
          paramInt3 = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject3);
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramInt1 = localSpannableStringBuilder.getSpanStart(localObject1[0]);
            paramInt2 = localSpannableStringBuilder.getSpanEnd(localObject1[0]);
            if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 < paramInt3))
            {
              paramInt3 = ((Spanned)localObject3).getSpanStart(localObject1[0]);
              paramInt4 = ((Spanned)localObject3).getSpanEnd(localObject1[0]);
              if ((paramInt3 == 0) && (paramInt4 >= paramInt3))
              {
                paramInt2 = Math.min(paramInt2 + paramInt4 + 1, localSpannableStringBuilder.length());
                localSpannableStringBuilder.setSpan(localObject1[0], paramInt1, paramInt2, 33);
              }
            }
          }
          a(localSpannableStringBuilder);
          super.setText(localSpannableStringBuilder, this.jdField_a_of_type_AndroidWidgetTextView$BufferType);
          return;
        }
        if (this.jdField_b_of_type_Int <= this.jdField_a_of_type_Int) {
          break;
        }
        paramInt3 = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append((CharSequence)localObject3);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          paramInt1 = localSpannableStringBuilder.getSpanStart(localObject1[0]);
          paramInt2 = localSpannableStringBuilder.getSpanEnd(localObject1[0]);
          if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 < paramInt3))
          {
            paramInt3 = ((Spanned)localObject3).getSpanStart(localObject1[0]);
            paramInt4 = ((Spanned)localObject3).getSpanEnd(localObject1[0]);
            if ((paramInt3 == 0) && (paramInt4 >= paramInt3))
            {
              paramInt2 = Math.min(paramInt2 + paramInt4 + 1, localSpannableStringBuilder.length());
              localSpannableStringBuilder.setSpan(localObject1[0], paramInt1, paramInt2, 33);
            }
          }
        }
        super.setText(localSpannableStringBuilder, this.jdField_a_of_type_AndroidWidgetTextView$BufferType);
        return;
        localObject1 = null;
        break label389;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Int > 0)
    {
      Object localObject = getLayout();
      if ((localObject instanceof DynamicLayout))
      {
        localObject = (DynamicLayout)localObject;
        this.jdField_b_of_type_Int = ((DynamicLayout)localObject).getLineCount();
        paramInt2 = getCompoundPaddingTop();
        int i = getCompoundPaddingBottom();
        paramInt1 = getMeasuredHeight();
        paramInt2 = paramInt2 + i + this.jdField_a_of_type_Int * getLineHeight() + AIOUtils.a(8.5F, getResources());
        if ((this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int) && (paramInt1 > 0) && (paramInt2 > paramInt1)) {
          setMeasuredDimension(getMeasuredWidth(), paramInt2);
        }
        if (this.jdField_a_of_type_Boolean) {
          a((DynamicLayout)localObject, this.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    for (;;)
    {
      int i;
      try
      {
        i = paramMotionEvent.getActionMasked();
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = getTotalPaddingLeft();
        int n = getTotalPaddingTop();
        int i1 = getScrollX();
        int i2 = getScrollY();
        paramMotionEvent = getLayout();
        j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
        paramMotionEvent = getText();
        if ((TextUtils.isEmpty(paramMotionEvent)) || (!(paramMotionEvent instanceof Spannable))) {
          break label389;
        }
        paramMotionEvent = (Spannable)getText();
        arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(j, j, ClickableSpan.class);
        if ((arrayOfClickableSpan == null) || (arrayOfClickableSpan.length == 0)) {
          break label316;
        }
        if (i != 0) {
          break label394;
        }
        a();
        this.jdField_a_of_type_JavaLangObject = arrayOfClickableSpan[0];
        this.jdField_c_of_type_Int = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
        this.d = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
        if ((this.jdField_c_of_type_Int < 0) || (this.d < this.jdField_c_of_type_Int) || (!(arrayOfClickableSpan[0] instanceof ReadInJoyYAFolderTextView.ClickableSpanPressed))) {
          break label392;
        }
        ((ReadInJoyYAFolderTextView.ClickableSpanPressed)arrayOfClickableSpan[0]).a(true);
        this.jdField_a_of_type_JavaUtilVector.add(arrayOfClickableSpan[0]);
      }
      catch (Exception paramMotionEvent)
      {
        ClickableSpan[] arrayOfClickableSpan;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramMotionEvent.printStackTrace();
        return bool;
      }
      this.jdField_a_of_type_JavaLangObject = null;
      if ((this.jdField_c_of_type_Int >= 0) && (this.d >= this.jdField_c_of_type_Int))
      {
        if ((arrayOfClickableSpan[0] instanceof ReadInJoyYAFolderTextView.ClickableSpanPressed)) {
          ((ReadInJoyYAFolderTextView.ClickableSpanPressed)arrayOfClickableSpan[0]).a(false);
        }
        Selection.removeSelection(paramMotionEvent);
        this.jdField_c_of_type_Int = -1;
        this.d = -1;
      }
      a();
      break label392;
      label316:
      if ((this.jdField_c_of_type_Int >= 0) && (this.d >= this.jdField_c_of_type_Int))
      {
        if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ReadInJoyYAFolderTextView.ClickableSpanPressed)))
        {
          ((ReadInJoyYAFolderTextView.ClickableSpanPressed)this.jdField_a_of_type_JavaLangObject).a(false);
          this.jdField_a_of_type_JavaLangObject = null;
        }
        Selection.removeSelection(paramMotionEvent);
        this.jdField_c_of_type_Int = -1;
        this.d = -1;
      }
      a();
      return false;
      label389:
      return bool;
      label392:
      label394:
      do
      {
        return true;
        if ((i == 1) || (i == 3)) {
          break;
        }
      } while (i != 4);
    }
  }
  
  public void setEllipsis(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMoreSpan(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setSpanText(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if ((paramCharSequence instanceof QQText)) {
      localObject = new SpannableStringBuilder(paramCharSequence);
    }
    super.setText((CharSequence)localObject, paramBufferType);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView$BufferType = paramBufferType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView
 * JD-Core Version:    0.7.0.1
 */