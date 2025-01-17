package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_search_word_rsp
  extends JceStruct
{
  static ArrayList cache_vec_hotword;
  static ArrayList cache_vec_tab = new ArrayList();
  public int iRetCode;
  public ArrayList vec_hotword;
  public ArrayList vec_tab;
  
  static
  {
    s_search_word locals_search_word = new s_search_word();
    cache_vec_tab.add(locals_search_word);
    cache_vec_hotword = new ArrayList();
    locals_search_word = new s_search_word();
    cache_vec_hotword.add(locals_search_word);
  }
  
  public mobile_search_word_rsp() {}
  
  public mobile_search_word_rsp(int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.iRetCode = paramInt;
    this.vec_tab = paramArrayList1;
    this.vec_hotword = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRetCode = paramJceInputStream.read(this.iRetCode, 0, false);
    this.vec_tab = ((ArrayList)paramJceInputStream.read(cache_vec_tab, 1, false));
    this.vec_hotword = ((ArrayList)paramJceInputStream.read(cache_vec_hotword, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRetCode, 0);
    if (this.vec_tab != null) {
      paramJceOutputStream.write(this.vec_tab, 1);
    }
    if (this.vec_hotword != null) {
      paramJceOutputStream.write(this.vec_hotword, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_search_word_rsp
 * JD-Core Version:    0.7.0.1
 */