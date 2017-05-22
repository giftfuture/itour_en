<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<title>${rt.title }</title>
</head>
<body>
<%@include file="/front/header.jsp"  %>
<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif"><table width="1100" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="685"><table width="1053" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="32"><img src="images/man.gif" width="32" height="32" /></td>
            <td width="1021"><span class="STYLE148"><span class="STYLE24">来自：</span>台湾 刘先生 <span class="STYLE24">团号：</span>${bean.groupCode } <span class="STYLE149">出团日期：</span>${bean.groupDate }<span class="STYLE149">人数：</span>4大2小 </span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><img src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
</table>
<table width="80%" border="0" align="center" cellpadding="10" cellspacing="0">
  <tr>
    <td class="h1-black">四姑娘山海子沟徒步、长坪沟穿越毕棚沟<span class="STYLE27"> 第一次方案 </span></td>
  </tr>
</table>
<br />
<span class="STYLE10">备注：提前要连接好客人的信息，团号，出团日期，人数几大几小。</span><br />
<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/frame1-1.gif" width="100%" height="7" /></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif"><table width="1100" border="0" align="center" cellpadding="10" cellspacing="0">
        <tr>
          <td width="761" valign="top" class="STYLE126"><span class="STYLE3">简要行程</span><span class="STYLE2">：</span></td>
        </tr>
      </table>
      <table width="80%" border="0" align="center" cellpadding="5" cellspacing="1">
        <tr>
          <td height="31" valign="middle" bgcolor="#F0F0F0" class="STYLE129"><div align="center" class="STYLE18">
            <div align="center"><strong><strong>天数</strong></strong></div>
          </div></td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE23">日期</td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE23">星期</td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE129"><div align="center" class="STYLE18">
            <div align="center"><strong><strong>行程</strong></strong></div>
          </div></td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE129"><div align="center" class="STYLE18">
            <div align="center">里程</div>
          </div></td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE129"><div align="center" class="STYLE18">
            <div align="center">景点</div>
          </div></td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE23"><div align="center">餐食</div></td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE129"><div align="center" class="STYLE18">
            <div align="center">住宿</div>
          </div></td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE23"><div align="center">酒店</div></td>
          <td valign="middle" bgcolor="#F0F0F0" class="STYLE23"><div align="center">元/间</div></td>
        </tr>
        <tr>
          <td width="34" valign="middle" class="STYLE126"><div align="center">1</div></td>
          <td width="55" valign="middle" class="STYLE126">2016-7-2</td>
          <td width="35" valign="middle" class="STYLE126">周六</td>
          <td width="308" valign="middle" class="STYLE126">成都-四姑娘山</td>
          <td width="50" valign="middle" class="STYLE126">310km</td>
          <td width="124" valign="middle" class="STYLE126">【巴郎山】</td>
          <td width="67" valign="middle" class="STYLE126"><input name="checkbox73243" type="checkbox" value="checkbox" checked="CHECKED" />
          <input name="checkbox73244" type="checkbox" value="checkbox" checked="checked" />
          <input name="checkbox73245" type="checkbox" value="checkbox" checked="checked" /></td>
          <td width="57" valign="middle" class="STYLE126">四姑娘山镇</td>
          <td width="171" valign="middle" class="STYLE126"><select name="select6" id="select5">
            <option>选择该城市酒店</option>
            <option>贵山商务酒店</option>
            <option>嘉绒酒店</option>
                    </select>
            <input name="textfield3224322" type="text" size="10" />
            <br />
            *也可自己填写</td>
          <td width="88" valign="middle" class="STYLE126"><input name="textfield322432" type="text" size="6" /></td>
        </tr>
        <tr>
          <td valign="middle" class="STYLE126"><div align="center">2</div></td>
          <td valign="middle" class="STYLE126">2016-7-3</td>
          <td valign="middle" class="STYLE126">周日</td>
          <td valign="middle" class="STYLE126">徒步：海子溝</td>
          <td valign="middle" class="STYLE126">30km</td>
          <td valign="middle" class="STYLE126">【海子沟】</td>
          <td valign="middle" class="STYLE126"><input name="checkbox732432" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732442" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732452" type="checkbox" value="checkbox" checked="checked" /></td>
          <td valign="middle" class="STYLE126">四姑娘山镇</td>
          <td valign="middle" class="STYLE126"><select name="select9" id="select6">
            <option>选择该城市酒店</option>
            <option>贵山商务酒店</option>
            <option>嘉绒酒店</option>
          </select>
          <br />
          <input name="textfield32243222" type="text" size="10" /></td>
          <td valign="middle" class="STYLE126"><input name="textfield322433" type="text" size="6" /></td>
        </tr>
        <tr>
          <td valign="middle" class="STYLE126"><div align="center">3</div></td>
          <td valign="middle" class="STYLE126">2016-7-4</td>
          <td valign="middle" class="STYLE126">周一</td>
          <td valign="middle" class="STYLE126">日隆-10km-喇嘛寺-5km-枯树滩-7km-木骡子</td>
          <td valign="middle" class="STYLE126">22Km</td>
          <td valign="middle" class="STYLE126">【<a href="Destinations-sgnscpg.html" target="_blank">长坪沟</a>】</td>
          <td valign="middle" class="STYLE126"><input name="checkbox732433" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732443" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732453" type="checkbox" value="checkbox" checked="checked" /></td>
          <td valign="middle" class="STYLE126">露营</td>
          <td valign="middle" class="STYLE126"><select name="select10" id="select9">
            <option>选择该城市酒店</option>
            <option>贵山商务酒店</option>
            <option>嘉绒酒店</option>
          </select>
          <input name="textfield32243223" type="text" size="10" /></td>
          <td valign="middle" class="STYLE126"><input name="textfield322434" type="text" size="6" /></td>
        </tr>
        <tr>
          <td valign="middle" class="STYLE126"><div align="center">4</div></td>
          <td valign="middle" class="STYLE126">2016-7-5</td>
          <td valign="middle" class="STYLE126">周二</td>
          <td valign="middle" class="STYLE126">木骡子-3km-水打坝-11m-叉子沟尾营地  </td>
          <td valign="middle" class="STYLE126">14km</td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126"><input name="checkbox732434" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732444" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732454" type="checkbox" value="checkbox" checked="checked" /></td>
          <td valign="middle" class="STYLE126">露营</td>
          <td valign="middle" class="STYLE126"><select name="select11" id="select10">
            <option>选择该城市酒店</option>
            <option>贵山商务酒店</option>
            <option>嘉绒酒店</option>
          </select>
          <input name="textfield32243224" type="text" size="10" /></td>
          <td valign="middle" class="STYLE126"><input name="textfield322435" type="text" size="6" /></td>
        </tr>
        <tr>
          <td valign="middle" class="STYLE126"><div align="center">5</div></td>
          <td valign="middle" class="STYLE126">2016-7-6</td>
          <td valign="middle" class="STYLE126">周三</td>
          <td valign="middle" class="STYLE126">叉子沟尾-垭口-三颗树-白龙瀑布-卓玛湖-上海子接待站-理县</td>
          <td valign="middle" class="STYLE126">23km</td>
          <td valign="middle" class="STYLE126">【毕棚沟】</td>
          <td valign="middle" class="STYLE126"><input name="checkbox732435" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732445" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732455" type="checkbox" value="checkbox" checked="checked" /></td>
          <td valign="middle" class="STYLE126">理县/汶川</td>
          <td valign="middle" class="STYLE126"><select name="select12" id="select11">
            <option>选择该城市酒店</option>
            <option>贵山商务酒店</option>
            <option>嘉绒酒店</option>
          </select>
          <input name="textfield32243225" type="text" size="10" /></td>
          <td valign="middle" class="STYLE126"><input name="textfield322436" type="text" size="6" /></td>
        </tr>
        <tr>
          <td valign="middle" class="STYLE126"><div align="center">6</div></td>
          <td valign="middle" class="STYLE126">2016-7-7</td>
          <td valign="middle" class="STYLE126">周四</td>
          <td valign="middle" class="STYLE126">返回成都</td>
          <td valign="middle" class="STYLE126">200k</td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126"><input name="checkbox732436" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732446" type="checkbox" value="checkbox" checked="checked" />
            <input name="checkbox732456" type="checkbox" value="checkbox" checked="checked" /></td>
          <td valign="middle" class="STYLE126">成都</td>
          <td valign="middle" class="STYLE126"><select name="select13" id="select12">
            <option>选择该城市酒店</option>
            <option>贵山商务酒店</option>
            <option>嘉绒酒店</option>
          </select>
          <input name="textfield32243226" type="text" size="10" /></td>
          <td valign="middle" class="STYLE126"><input name="textfield322437" type="text" size="6" /></td>
        </tr>
        <tr>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126">全选　全不选 </td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
          <td valign="middle" class="STYLE126">*没选则表示不含</td>
          <td valign="middle" class="STYLE126">&nbsp;</td>
        </tr>
      </table>
      <br />
      <br /></td>
  </tr>
  <tr>
    <td><img src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
</table>
<br />
<table width="80%" border="1" align="center" cellpadding="8" cellspacing="2">
  <tr>
    <td width="78"><strong>项目</strong></td>
    <td width="639"><div align="center"><strong>成本及计算</strong></div></td>
    <td width="39"><div align="center">小孩</div></td>
    <td width="360"><div align="center" class="STYLE10"><strong>说明</strong></div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>人数： </strong></div></td>
    <td><label> 大人：<span class="STYLE126">
    <input name="textfield322438" type="text" size="6" />
    </span>人 小孩：<span class="STYLE126">
    <input name="textfield322439" type="text" size="6" />
    </span> 人     
    （
    <input type="radio" name="chd" value="radiobutton" />
      同大人一样
      <input name="chd" type="radio" value="radiobutton" checked="checked" />
      按小孩核算）</label></td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10">。同大人一样则把核算项目中的成人人数变为 成人+小孩 ， 平摊费用 <br />
      。按小孩计算则计算勾选项目，未勾选的项目需在报价上面显示不含这些项目。<br />
      。小数点后面的去零取整</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><p align="right"><strong>门票：</strong></p></td>
    <td><p><span class="STYLE144">根据制定行程时所选的景点，按对应的日期显示景点名称及相应各价格明细 ——如果觉得管理后台太麻烦的话也可以直接手动输入 <span class="STYLE145">？ </span><br />
      </span> <span class="STYLE126"> 1.</span>海子沟
      <input name="checkbox734" type="checkbox" value="checkbox" checked="checked" />
      门票 50元/人
      <input name="checkbox7324" type="checkbox" value="checkbox" checked="checked" />
      户外门票150元/人 <br />
      <span class="STYLE126">2.</span>长坪沟
      <input name="checkbox7342" type="checkbox" value="checkbox" checked="checked" />
      门票50元/人
      <input name="checkbox73242" type="checkbox" value="checkbox" checked="checked" />
      观光车 20元/人 
      <input name="checkbox73246" type="checkbox" value="checkbox" checked="checked" />
      户外门票150元/人 <br />
      <span class="STYLE126">3.毕棚沟
        <input name="checkbox73422" type="checkbox" value="checkbox" checked="checked" />
        门票80元/人
  <input name="checkbox732422" type="checkbox" value="checkbox" checked="checked" />
        观光车 70元/人
  <input name="checkbox732462" type="checkbox" value="checkbox" checked="checked" />
        电瓶车A-B 20</span><span class="STYLE126">元/人 </span><span class="STYLE126">
        <input name="checkbox7324622" type="checkbox" value="checkbox" checked="checked" />
电瓶车B-C 20</span><span class="STYLE126">元/人 </span><br />
        <br />
      手动增加景区： <br />
      1
      .<span class="STYLE126"> 景点名称
        <input name="textfield322223" type="text" size="20" />
        <input name="textfield32243" type="text" size="6" />
        元/人<img src="images/add.gif" width="16" height="16" /></span></p>      </td>
    <td><div align="center">
      <input name="checkbox32" type="checkbox" value="checkbox" />
    </div></td>
    <td><span class="STYLE10">需要进行单独管理（可以按时间点选门票里面的项目，及按日期出来的价格）<br />
      。报价单上面可以显示或不显示门票明细及价格<br />
      后台可以查看到。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>旅行证件</strong></div></td>
    <td><span class="STYLE126">1.
      <input name="textfield322242242332" type="text" value="入藏函" size="20" />
          <input name="textfield3228432" type="text" size="6" />
      </span>元/人　<span class="STYLE126">备注：
        <input name="textfield3222332242322" type="text" size="20" />
        </span> <br />
      <span class="STYLE126">2.
        <input name="textfield3222422423222" type="text" value="边防证" size="20" />
        <input name="textfield32284222" type="text" size="6" />
        元/人</span>　<span class="STYLE126">备注：
          <input name="textfield32223322422222" type="text" size="20" />
        </span>　 <img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox311" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>导游：</strong></div></td>
    <td><span class="STYLE126"> 1.
      <input name="textfield32222" type="text" value="全程" size="10" />
          <select name="select4" id="select2">
            <option>选择语种</option>
            <option value="中文">中文</option>
            <option value="英文">英文</option>
          </select>
      </span> <span class="STYLE126"> </span><span class="STYLE126">
        <input name="textfield322" type="text" value="300" size="6" />
        </span>元/天 <span class="STYLE126">X </span><span class="STYLE126">
          <input name="textfield32" type="text" value="8" size="6" />
          </span>天　备注：<span class="STYLE126">
            <input name="textfield32223" type="text" size="10" />
          </span>　　<img src="images/add.gif" width="16" height="16" /><br /></td>
    <td><div align="center">
      <input name="checkbox33" type="checkbox" value="checkbox" />
    </div></td>
    <td><span class="STYLE10">。多少钱一天在后台根据淡旺季和语种管理<br />
      。天数默认为行程天数<br />
      ——算出总价，平摊到团员</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>酒店：<br />
    </strong></div></td>
    <td>请在概要行程里面填写价格，请<span class="STYLE129">务必注意节假日及会议期间</span>哟。</td>
    <td><div align="center">
      <input name="checkbox35" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10">。后台可选择酒店名称，但无需管理价格。<br />
      。可能会有单房差</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用车：<br />
    </strong></div></td>
    <td><span class="STYLE126"> 1.
      <input name="textfield32224" type="text" value="全程" size="10" />
      </span><span class="STYLE126">
        <input name="textfield3227" type="text" size="6" />
        </span>元/<span class="STYLE126">
          <select name="select4" id="select3">
            <option selected="selected">方式</option>
            <option value="天">天</option>
            <option value="公里">公里 </option>
            <option value="趟">趟</option>
          </select>
          </span><span class="STYLE126">X </span><span class="STYLE126">
            <input name="textfield323" type="text" size="6" />
            </span>数量　备注：<span class="STYLE126">
              <input name="textfield322233" type="text" size="20" />
              </span> <br />
      <span class="STYLE126">2.
        <input name="textfield322243" type="text" size="10" />
      </span><span class="STYLE126">
          <input name="textfield32273" type="text" size="6" />
          </span>元/<span class="STYLE126">
            <select name="select4" id="select4">
              <option selected="selected">方式</option>
              <option value="天">天</option>
              <option value="公里">公里 </option>
              <option value="趟">趟</option>
            </select>
            </span><span class="STYLE126">X </span><span class="STYLE126">
              <input name="textfield3232" type="text" size="6" />
              </span>数量　备注：<span class="STYLE126">
                <input name="textfield3222333" type="text" size="20" />
              </span>　　 <img src="images/add.gif" width="16" height="16" /><br /></td>
    <td><div align="center">
      <input name="checkbox36" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10">——算出总价，平摊到团员。<br />
    方式若选择天的话，自动在后面的数量里面补上1（这个容易被忘掉，那算出来就变成 0了）</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>大交通：<br />
    </strong></div></td>
    <td><span class="STYLE126">
      <label>
        <input type="radio" name="train-ticket" value="train-ticket" />
      </label>
      计入总价
      <label>
        <input name="train-ticket" type="radio" value="train-ticket" checked="checked" />
        另外核算</label>
      （火车票、机票、大巴票等）<br />
      1.
      <input name="textfield322242" type="text" size="20" />
      </span><span class="STYLE126">
        <input name="textfield32272" type="text" size="6" />
        </span>元/<span class="STYLE126">人</span><span class="STYLE126">备注：
          <input name="textfield3222332" type="text" size="20" />
          </span> 　 <span class="STYLE126"><br />
            2.
            <input name="textfield3222423" type="text" size="20" />
            </span><span class="STYLE126">
              <input name="textfield322723" type="text" size="6" />
              </span>元/<span class="STYLE126">人</span><span class="STYLE126">备注：
                <input name="textfield32223323" type="text" size="20" />
              </span> 　 <img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox37" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10">可以不同的几段计入<br />
      另外核算则写在总价后面。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用餐：<br />
              <br />
    </strong></div></td>
    <td><label>
      <input name="checkbox" type="checkbox" value="checkbox" checked="checked" />
      </label>
      餐标：<span class="STYLE126">
        <input name="textfield3224" type="text" value="30" size="6" />
        </span>元/人餐<br />
安排特色餐：<span class="STYLE126"> <br />
</span>
<table border="0" cellspacing="0" cellpadding="2">
  <tr>
    <td rowspan="4">四川</td>
    <td>成都</td>
    <td><span class="STYLE126">
      <input name="checkbox732437" type="checkbox" value="checkbox" />
    </span></td>
    <td><span class="STYLE126">钦善斋药膳火锅 60元/人 </span></td>
    <td><span class="STYLE126">
      <input name="checkbox7324372" type="checkbox" value="checkbox" />
    </span></td>
    <td>道地四川火锅80元/人</td>
    <td><span class="STYLE126">
      <input name="checkbox7324373" type="checkbox" value="checkbox" />
    </span></td>
    <td>四川小吃 50元/人 </td>
  </tr>
  <tr>
    <td>青都</td>
    <td><span class="STYLE126">
      <input name="checkbox7324374" type="checkbox" value="checkbox" />
    </span></td>
    <td>青城四绝60元/人</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>峨乐</td>
    <td><span class="STYLE126">
      <input name="checkbox7324375" type="checkbox" value="checkbox" />
    </span></td>
    <td>峨眉山珍宴60元/人</td>
    <td><span class="STYLE126">
      <input name="checkbox7324378" type="checkbox" value="checkbox" />
    </span></td>
    <td>乐山豆腐宴60元/人</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>九寨</td>
    <td><span class="STYLE126">
      <input name="checkbox7324376" type="checkbox" value="checkbox" />
    </span></td>
    <td>野菌火锅60元/人</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>西藏</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>新疆</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>云南 </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<span class="STYLE126"><br />
第1种方式为后台填好这个名称和价格之后勾选，其实特色用餐的数量也不是很多。<br />
第2种方式就手动在下面填写名称和价格 ：
<br />
1.
<input name="textfield3222222" type="text" size="10" />
      </span><span class="STYLE126">
        <input name="textfield3225" type="text" size="6" />
        </span>元/人餐<br />
        <span class="STYLE126">2.
        <input name="textfield32222222" type="text" size="10" />
        </span><span class="STYLE126">
        <input name="textfield32252" type="text" size="6" />
        </span>元/人餐<br />
        <span class="STYLE126">3.
        <input name="textfield32222223" type="text" size="10" />
        </span><span class="STYLE126">
        <input name="textfield32253" type="text" size="6" />
        </span>元/人餐<br />
        <span class="STYLE126">4.
        <input name="textfield32222224" type="text" size="10" />
        </span><span class="STYLE126">
        <input name="textfield32254" type="text" size="6" />
        </span>元/人餐<img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox34" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10">。后台按勾选来算餐数，特色餐数量需要减出来。<br />
  。特色餐可提前设定，勾选，核算价格的时候需要扣出来已经算入的午餐或晚餐</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>保险：</strong></div></td>
    <td><span class="STYLE126">
      <label></label>
      </span><span class="STYLE126">1.
        <select name="select14" id="select13">
          <option value="人">内宾旅游意外保险</option>
          <option value="团">入境旅游意外保险</option>
                </select>
        </span><span class="STYLE126">
          <input name="textfield32272222" type="text" size="6" />
          </span>元/<span class="STYLE126">人</span><span class="STYLE126">备注：
            <input name="textfield3222332222" type="text" size="20" />
          </span><img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox39" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10">内宾10元，外宾30元 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>综费</strong>：</div></td>
    <td><span class="STYLE126">1.
      <input name="textfield3222422423322" type="text" value="旅行社综合服务费" size="20" />
          <input name="textfield32284322" type="text" size="6" />
      </span>元/人　<span class="STYLE126">备注：
        <input name="textfield32223322423222" type="text" size="20" />
      </span>　 <img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox312" type="checkbox" value="checkbox" />
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>娱乐：</strong></div></td>
    <td><span class="STYLE126">1.
      <input name="textfield32224224233" type="text" size="20" />
          <input name="textfield322843" type="text" size="6" />
      </span>元/人　<span class="STYLE126">备注：
        <input name="textfield322233224232" type="text" size="20" />
        </span>　
      <img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox310" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="4"><div align="center">徒步登山项目</div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>向导</strong></div></td>
    <td><span class="STYLE126"> </span><span class="STYLE126"> 1.
      <input name="textfield322242242" type="text" size="20" />
          <input name="textfield32282" type="text" size="4" />
      向导数 X
      <input name="textfield3228" type="text" size="6" />
      </span>元/天<span class="STYLE126"> X </span><span class="STYLE126">
        <input name="textfield325" type="text" size="4" />
        </span>天　<span class="STYLE126">备注：
          <input name="textfield3222332242" type="text" size="20" />
        </span> 　<img src="images/add.gif" width="16" height="16" /><br /></td>
    <td><div align="center">
      <input name="checkbox313" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10">——算出总价，平摊到团员。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>驮马费</strong></div></td>
    <td><span class="STYLE126">1.
      <input name="textfield3222422425" type="text" size="20" />
          <input name="textfield322824" type="text" size="4" />
      马匹数 X
      <input name="textfield32286" type="text" size="6" />
      </span>元/天<span class="STYLE126"> X </span><span class="STYLE126">
        <input name="textfield3254" type="text" size="4" />
        </span>天　<span class="STYLE126">备注：
          <input name="textfield32223322425" type="text" size="20" />
        </span> 　<img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox314" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10">——算出总价，平摊到团员。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>骑马费</strong></div></td>
    <td><span class="STYLE126">1.
      <input name="textfield32224224242" type="text" size="20" />
          <input name="textfield322852" type="text" size="6" />
      </span>元/天<span class="STYLE126"> X </span><span class="STYLE126">
        <input name="textfield32532" type="text" size="4" />
        </span>天　<span class="STYLE126">备注：
          <input name="textfield322233224242" type="text" size="20" />
          </span> 　
      <img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox315" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10">？若只是部分客人的怎么办？单独写在备注里面</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山注册费</strong></div></td>
    <td><span class="STYLE126">1.
      <input name="textfield3222422423" type="text" size="20" />
          <input name="textfield32284" type="text" size="6" />
      </span>元/人　<span class="STYLE126">备注：
        <input name="textfield32223322423" type="text" size="20" />
      </span> 　<img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox317" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登协联络官</strong></div></td>
    <td><span class="STYLE126">1.
      <input name="textfield3222422424" type="text" size="20" />
          <input name="textfield322823" type="text" value="1" size="4" />
      人数 X
      <input name="textfield32285" type="text" size="6" />
      </span>元/天<span class="STYLE126"> X </span><span class="STYLE126">
        <input name="textfield3253" type="text" size="4" />
        </span>天　<span class="STYLE126">备注：
          <input name="textfield32223322424" type="text" size="20" />
        </span> 　<img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox318" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="4"><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>其它 </strong></div></td>
    <td><span class="STYLE126">1.
      <input name="textfield322244" type="text" size="20" />
      </span><span class="STYLE126">
        <input name="textfield32274" type="text" size="6" />
        </span>元/<span class="STYLE126">
          <select name="select7" id="select7">
            <option selected="selected">方式</option>
            <option value="人">人</option>
            <option value="团">团</option>
          </select>
          </span><span class="STYLE126"> </span>　备注：<span class="STYLE126">
            <input name="textfield3222334" type="text" size="20" />
            </span> <br />
      <span class="STYLE126">2.
        <input name="textfield3222442" type="text" size="20" />
      </span><span class="STYLE126">
          <input name="textfield322734" type="text" size="6" />
          </span>元/<span class="STYLE126">
            <select name="select8" id="select8">
              <option selected="selected">方式</option>
              <option value="人">人</option>
              <option value="团">团</option>
            </select>
            </span><span class="STYLE126"> </span>　备注：<span class="STYLE126">
              <input name="textfield32223334" type="text" size="20" />
            </span>　　 <img src="images/add.gif" width="16" height="16" /></td>
    <td><div align="center">
      <input name="checkbox320" type="checkbox" value="checkbox" checked="checked" />
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td><div align="right"></div></td>
    <td>赠送项目：氧气，每日饮用水。<span class="STYLE144">写在哪儿？</span></td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td><div align="right">核算价格：</div></td>
    <td><label></label>
      <table border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td><input type="submit" name="Submit2" value="芝麻开门" /></td>
        </tr>
        <tr>
          <td><a href="${basePath}hiking/toQuote2">链接</a></td>
        </tr>
      </table></td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10">两种核算价格的方式，出来两个不同的页面</span></td>
  </tr>
  <tr>
    <td><div align="right"></div></td>
    <td>**线路在外面售卖的价格可能通过这套系统来评估<br />
      **可选儿童不占床，不含门票，不含车费。 </td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="4"><p><a href="#" class="STYLE136">算价管理（门票在景点内管理）</a></p>    </td>
  </tr>
</table>
<script type="text/javascript" src="${basePath}js/ux/front/climb/quote_step1.js"></script>
<%@include file="/front/footer.jsp" %>
</body>
</html>

