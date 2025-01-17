package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;
import com.tencent.token.fn;
import com.tencent.token.global.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class UtilsMbInfoItemActivity
  extends BaseActivity
{
  private RelativeLayout mDelSuccView;
  private Handler mHandler = new aez(this);
  private boolean mIsDelSucc = false;
  private MbInfoResult.MbInfoItem mItem = null;
  private RelativeLayout mItemView;
  private int mPosition;
  
  private View createTableCol1(String paramString)
  {
    View localView = getLayoutInflater().inflate(2130903241, null);
    TextView localTextView = (TextView)localView.findViewById(2131297246);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(Html.fromHtml(paramString));
    }
    return localView;
  }
  
  private View createTableCol2(String paramString)
  {
    View localView = getLayoutInflater().inflate(2130903242, null);
    TextView localTextView = (TextView)localView.findViewById(2131297247);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(Html.fromHtml(paramString));
    }
    return localView;
  }
  
  private void initUI()
  {
    if ((this.mItem == null) || (this.mItem.mDetail == null)) {
      return;
    }
    setTitle(this.mItem.mName);
    this.mItemView = ((RelativeLayout)findViewById(2131297241));
    this.mDelSuccView = ((RelativeLayout)findViewById(2131297244));
    if ((this.mItem.mDetail.mBtnText != null) && (this.mItem.mDetail.mBtnText.length() > 0)) {
      ((TextView)findViewById(2131296396)).setText(getResources().getString(2131362207) + this.mItem.mDetail.mBtnText + this.mItem.mName + "!");
    }
    findViewById(2131296398).setOnClickListener(new afa(this));
    this.mItemView.setVisibility(0);
    this.mDelSuccView.setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131296903);
    if ((this.mItem.mDetail.mDesc != null) && (this.mItem.mDetail.mDesc.length() > 0))
    {
      Object localObject = Html.fromHtml(this.mItem.mDetail.mDesc);
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      localObject = (URLSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), URLSpan.class);
      if ((localObject != null) && (localObject.length > 0)) {
        localTextView.setOnClickListener(new afb(this, localObject[0].getURL()));
      }
    }
    for (;;)
    {
      insertTableRows((TableLayout)findViewById(2131297242));
      setActionButton();
      setRightBtn();
      return;
      localTextView.setVisibility(8);
    }
  }
  
  private void insertTableRows(TableLayout paramTableLayout)
  {
    for (;;)
    {
      JSONArray localJSONArray;
      int i;
      Object localObject;
      TableRow localTableRow;
      int j;
      try
      {
        localJSONArray = new JSONArray(this.mItem.mDetail.mTable);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONArray(i);
          localTableRow = new TableRow(this);
          j = 0;
          if (j < ((JSONArray)localObject).length()) {
            if (j == 0) {
              localTableRow.addView(createTableCol1(((JSONArray)localObject).getString(j)));
            } else {
              localTableRow.addView(createTableCol2(((JSONArray)localObject).getString(j)));
            }
          }
        }
      }
      catch (JSONException paramTableLayout)
      {
        paramTableLayout.printStackTrace();
      }
      for (;;)
      {
        return;
        paramTableLayout.addView(localTableRow);
        i += 1;
        break;
        localObject = (ViewGroup.MarginLayoutParams)this.mItemView.getLayoutParams();
        i = (int)(localJSONArray.length() * 50 * IndexActivity.S_DENSITY);
        j = IndexActivity.S_RES_WIDTH;
        int k = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        int m = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        paramTableLayout.getLayoutParams().height = i;
        if (localJSONArray.length() > 1)
        {
          i = 0;
          while (i < localJSONArray.length() - 1)
          {
            paramTableLayout = new ImageView(this);
            paramTableLayout.setBackgroundColor(getResources().getColor(2131165213));
            localObject = new RelativeLayout.LayoutParams(j - k - m, (int)IndexActivity.S_DENSITY);
            ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)((i + 1) * 50 * IndexActivity.S_DENSITY));
            this.mItemView.addView(paramTableLayout, (ViewGroup.LayoutParams)localObject);
            i += 1;
          }
        }
      }
      j += 1;
    }
  }
  
  private void setActionButton()
  {
    if ((this.mItem == null) || (this.mItem.mDetail == null)) {
      return;
    }
    Button localButton1 = (Button)findViewById(2131296904);
    Button localButton2 = (Button)findViewById(2131297243);
    setButton(localButton1, this.mItem.mDetail.mBtnStatus, this.mItem.mDetail.mBtnText, this.mItem.mDetail.mBtnType);
    setButton(localButton2, this.mItem.mDetail.mBtnExtStatus, this.mItem.mDetail.mBtnExtText, this.mItem.mDetail.mBtnExtType);
  }
  
  private void setButton(Button paramButton, int paramInt1, String paramString, int paramInt2)
  {
    if (paramButton == null) {
      return;
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramButton.setVisibility(4);
      return;
    }
    paramButton.setVisibility(0);
    boolean bool;
    if (paramInt1 == 1)
    {
      bool = true;
      if (paramString.length() != 2) {
        break label144;
      }
    }
    label144:
    for (String str = paramString.substring(0, 1) + "  " + paramString.substring(1, 2);; str = paramString)
    {
      paramButton.setText(str);
      paramButton.setEnabled(bool);
      if ((!bool) || (paramInt2 == 0))
      {
        paramButton.setVisibility(4);
        paramButton.setTextColor(getResources().getColor(2131165214));
      }
      paramButton.setOnClickListener(new afc(this, bool, paramInt2, paramString));
      return;
      bool = false;
      break;
    }
  }
  
  private void setRightBtn()
  {
    if (this.mItem == null) {
      return;
    }
    int i;
    switch (this.mItem.mId)
    {
    default: 
      i = 0;
    }
    while (i != 0)
    {
      setRightTitleImage(2130837951, new aff(this, i));
      return;
      i = 2131362228;
      continue;
      i = 2131362226;
      continue;
      i = 2131362229;
      continue;
      i = 2131362227;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsDelSucc) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903240);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    this.mPosition = paramBundle.getInt("position", -1);
    paramBundle = fn.a().c();
    if ((this.mPosition == -1) || (paramBundle == null) || (paramBundle.mMbInfoItems == null) || (paramBundle.mMbInfoItems.size() <= this.mPosition))
    {
      finish();
      return;
    }
    this.mItem = ((MbInfoResult.MbInfoItem)paramBundle.mMbInfoItems.get(this.mPosition));
    initUI();
  }
  
  public void onDestroy()
  {
    af.a().a(getClass().getName());
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsMbInfoItemActivity
 * JD-Core Version:    0.7.0.1
 */