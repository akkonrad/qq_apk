function clientCallback(f,i){try{if(f&&f!=""){f=f.replace(/(\r|\n|\t)/gi,"");f=JSON.parse(f)}}catch(d){f={r:-200}}accountSearch.sdk.ajaxCallback(i,f)}function iosCallback(f,i){clientCallback(f,i.token)}function getLocationCallback(f){typeof f!="undefined"&&f!=null&&accountSearch.sdk.setGpsLocation(f)}function getIosLocationCallback(f,i,d){f==0&&accountSearch.sdk.setGpsLocation(i+","+d)}
J.$package("accountSearch",function(f){function i(a,b,c){a=a.target;c=c||6;for(b=b||"cmd";a&&c-- >0;){if(a==document)break;if(a.getAttribute(b))return a;else a=a.parentNode}return null}var d=f.dom,g=f.event,y=f.http,o=typeof iOSQQApi=="object"||typeof publicAccount=="object",p=typeof iOSQQApi=="object"||false,q=typeof publicAccount=="object"||false,r="",u="0,0",s=1;if(p)s=2;else if(q)s=3;var l=false;if(p){var v=navigator.userAgent.match(/[\d]\_[\d]\_[\d]/gi);try{v==null||v.toString().split("_")}catch(B){}}f.platform.android&&
d.addClass(d.id("search_bar"),"andSearch");f=function(a,b){var c=RegExp("(?:\\?|#|&)"+a+"=([^&]*)(?:$|&|#)","i").exec(window.location.href);c=c?c[1]:"";return!b?decodeURIComponent(c):c};var w=function(a){a=a.replace(/&/g,"&amp;");a=a.replace(/>/g,"&gt;");a=a.replace(/</g,"&lt;");a=a.replace(/"/g,"&quot;");a=a.replace(/'/g,"&#39;");a=a.replace(/=/g,"&#61;");return a=a.replace(/`/g,"&#96;")},z=function(a,b){if(o){var c=null;g.on(a,"touchstart",function(e){if(e=i(e,"param"))c=e;l=true});g.on(a,"touchmove",
function(){c=null});g.on(a,"touchend",function(e){var h=i(e,"param");h==c&&b(h,e)})}else g.on(a,"click",function(e){var h=i(e,"param");h&&b(h,e)})};if(o)r=f("token");var j={dom:{},loadPage:0,init:function(){this.dom.main=d.id("mask");this.dom.list=d.id("list")},lockWindow:function(a){if(a){g.on(window,"touchstart",this.stopEvent);g.on(window,"scroll",this.stopEvent)}else{g.off(window,"touchstart",this.stopEvent);g.off(window,"scroll",this.stopEvent)}},show:function(a){this.loadPage=a;if(a==0){this.dom.main.style.display=
"block";this.lockWindow(true)}else this.addLoading()},addLoading:function(){if(!this.checkLoading()){var a=document.createElement("li");a.className="loadingResult";a.innerHTML='<div class="pageLoading"></div>';this.dom.list.appendChild(a)}},checkLoading:function(){var a=d.className("loadingResult",this.dom.list);if(a&&a.length>0)return true;return false},hide:function(){if(this.loadPage==0){this.dom.main.style.display="none";this.lockWindow(false)}var a=d.className("loadingResult",this.dom.list);
if(a&&a.length>0)for(var b=0,c=a.length;b<c;b++){var e=a[b];e.parentNode.removeChild(e)}},stopEvent:function(a){a.stopPropagation();a.preventDefault()}},k={dom:{},init:function(){this.dom.input=d.id("search_input");this.dom.clear=d.id("clear_btn");this.dom.submit=d.id("search_sumit");var a=this;g.on(this.dom.clear,"click",function(){a.dom.input.value="";a.hideClear()});g.on(this.dom.submit,"click",function(){a.doSearch()});g.on(this.dom.input,"keyup",function(b){var c=k;c.checkShowClear();b.keyCode==
13&&c.doSearch()});g.on(this.dom.input,"blur",function(){k.checkShowClear()})},checkShowClear:function(){var a=k;a.dom.input.value==""?a.hideClear():a.showClear()},showClear:function(){if(this.dom.clear.style.display=="none")this.dom.clear.style.display="block"},hideClear:function(){if(this.dom.clear.style.display!="none")this.dom.clear.style.display="none"},doSearch:function(){this.getValue()!=""&&m.search()},getValue:function(){return this.dom.input.value.replace(/(^\s*)|(\s*$)/g,"")}},t={callbackCount:0,
callback:{},timer:{},ajax:function(a){var b=a.url;this.callbackCount++;var c=this.callbackCount++,e=a.overtime||1E4;this.callback[c]=a.success;if(typeof publicAccount=="object")this.callAndroid(b,a,r,c);else if(typeof iOSQQApi=="object")this.callIos(b,a,r,c);else return false;if(a.timeout)this.timer[c]=setTimeout(function(){a.timeout&&a.timeout()},e)},callAndroid:function(a,b,c,e){b=JSON.stringify(b);publicAccount.getJson(a,b,c,e)},callIos:function(a,b,c,e){iOSQQApi.data.fetchJson(a,b.param,b,"iosCallback",
{token:e})},ajaxCallback:function(a,b){var c=this.callback[a];if(typeof c!="undefined"&&c){c(b);this.callback[a]=null}c=this.timer[a];if(typeof c!="undefined"&&c!=null){clearTimeout(c);this.timer[a]=null}},getLocation:function(){},setGpsLocation:function(a){u=a}};this.sdk=t;var m={dom:{},total:0,page:0,loadPage:0,pageNum:20,isEnd:false,lock:false,clickLock:false,reportTime:0,init:function(){this.dom.list=d.id("list");var a=this;g.on(window,"scroll",function(){var b=document.body,c=document.documentElement.scrollTop+
window.innerHeight;c=b.scrollTop+window.innerHeight;if(b.scrollHeight>window.innerHeight&&b.scrollHeight<=c+50)if(!a.isEnd){j.addLoading();a.getData(a.page+1)}});if(q){z(this.dom.list,this.onListClick);g.on(this.dom.list,"click",function(b){b.preventDefault();l=true})}else g.on(this.dom.list,"click",function(b){b.preventDefault();l=true;var c=i(b,"param");a.onListClick(c,b)});this.search()},onListClick:function(a){if(a)if(!this.clickLock){this.clickLock=true;a=a.getAttribute("param");p&&iOSQQApi.nav.showOfficalAccountDetail(a);
q&&publicAccount.viewAccount(a);var b=this;setTimeout(function(){b.clickLock=false},500)}},search:function(){this.isEnd=false;this.getData(0)},getData:function(a){if(!this.lock){this.lock=true;var b=k.getValue();this.loadPage=a;if(!a||a<1)a=0;j.show(a);var c=this;a={url:"http://s.p.qq.com/pub/query_mp",method:"GET",param:{begin:a*this.pageNum,keyword:b,limit:this.pageNum,locate:n.getLocate(),type:1,gps:u,hver:10018,pf:s,t:Date.now()},overtime:1E4,success:this.getDataSuc,error:function(){c.lock=false;
j.hide();c.showError()},timeout:function(){c.lock=false;j.hide();c.showError()}};if(this.reportTime>=0)this.reportTime=new Date-0;o?t.ajax(a):y.ajax(a)}},getDataSuc:function(a){var b=m;if(b.reportTime>0){b.reportTime=new Date-b.reportTime;var c=b.reportTime,e=new Image,h="click_10994_"+(T[1]-T[0]);h+="|click_11015_"+c;e.src="http://cgi.qplus.com/report/report?log="+h+"&tag=0&t="+(new Date-0);b.reportTime=-1}if(a.r==0){if(a.total==0)b.isEnd=true;b.fillData(a);typeof a.code!="undefined"&&a.code!=0&&
n.updateLocation(a.code);b.page=b.loadPage;j.hide()}else if(a.r==1E5){j.hide();b.showError("\u8fde\u63a5\u5931\u8d25")}else{b.showError("\u8fde\u63a5\u5931\u8d25");j.hide()}b.lock=false;if(b.page==0){document.body.scrollTop=0;b.hackScroll()}},hackScroll:function(){setTimeout(function(){if(!l)document.body.scrollTop=0},1500)},fillData:function(a){this.total=a.total||0;var b="";a=a.info||[];for(var c=0,e=a.length;c<e;c++){var h=a[c],A=h.f_grade>0?'<span class="authIcon"></span>':"";b+='<li param="'+
h.f_uin+'"><div>\t\t\t  \t\t\t\t<div class="iconImg" style=" background:url('+(h.face_url||"")+') no-repeat;background-size: 50px 50px;"></div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="accountName '+(h.f_grade>0?"vipUser":"")+'">\t\t\t\t\t\t\t\t<div class="nameTxt">'+w(h.f_name||"")+A+'</div>\t\t\t\t\t\t\t\t<div class="accountDesc">'+w(h.f_desc||"")+"</div>\t\t\t\t\t\t\t</div></div>\t\t\t\t\t\t</li>"}if(this.loadPage==0){if(b=="")b='<li class="noResult"><div class="accountName ">\u6ca1\u6709\u627e\u5230\u5339\u914d\u7ed3\u679c</div></li>';
this.dom.list.innerHTML=b}else this.dom.list.innerHTML+=b;if(this.total<(this.loadPage+1)*this.pageNum){this.isEnd=true;this.dom.list.innerHTML+='<li class="noResult"><div class="accountName coming">\u66f4\u591a\u751f\u6d3b\u670d\u52a1\uff0c\u656c\u8bf7\u671f\u5f85...</div></li>'}},showError:function(a){a=a||"\u8fde\u63a5\u5931\u8d25";if(this.dom.list.innerHTML=="")this.dom.list.innerHTML='<li class="noResult"><div class="accountName ">'+a+"</div></li>";else x.show(a)}},n={dom:{},locate:1,init:function(){this.dom.container=
d.id("body_container");this.dom.main=d.id("city_box");this.dom.list=d.id("city_list");this.dom.sel=d.id("init_sel");this.dom.btn=d.id("city_btn");this.dom.city=d.id("city_name");g.on(this.dom.main,"touchstart",function(b){b.stopPropagation()});var a=this;g.on(this.dom.list,"click",function(b){var c=i(b,"param");c&&a.onListClick(c,b)});g.on(this.dom.btn,"click",function(){a.show()})},onListClick:function(a,b){b.stopPropagation();b.preventDefault();var c=n;if(a){var e=a.getAttribute("param");c.hide();
if(e!=c.locate){c.setLocation(a);c.locate=e;m.search()}}},hide:function(){d.removeClass(this.dom.main,"show");d.removeClass(this.dom.main,"startShow")},show:function(){var a=this;d.addClass(a.dom.main,"startShow");setTimeout(function(){d.addClass(a.dom.main,"show")},100)},getLocate:function(){return this.locate},updateLocation:function(a){var b=d.tagName("li",this.dom.list);if(b&&b.length>0)for(var c=0,e=b.length;c<e;c++){var h=b[c];if(h.getAttribute("param")==a){this.locate=a;this.setLocation(h);
break}}},setLocation:function(a){d.removeClass(this.dom.sel,"citySel");d.addClass(a,"citySel");this.dom.sel=a;this.dom.city.innerHTML=a.innerHTML.replace(/<.+?>/gim,"")}},x={dom:{},timer:null,init:function(){this.dom.main=d.id("tips");this.dom.box=d.id("tips_box");this.dom.txt=d.id("tips_txt")},show:function(a){this.resize();this.timer&&clearTimeout(this.timer);this.dom.main.style.display="block";this.dom.txt.innerHTML=a;var b=this;this.timer=setTimeout(function(){b.dom.main.style.display="none"},
2E3)},resize:function(){var a=(window.innerHeight-150)/2;if(a>0)this.dom.box.style.marginTop=a+"px"}};window.onload=function(){T.push(new Date-0);t.getLocation("getLocationCallback");n.init();k.init();j.init();m.init();x.init()}});