<div id="beriefTrip">
${beriefTrip}
</div>
<script type="text/javascript">
 	function replaceInput(){
				var div = document.getElementById("beriefTrip");   
				var olist = div.getElementsByTagName('input');// $(html).find("input");// 
			    for(var i=0;i<olist.length;i++){
			        var obj = document.createElement('span');
			        obj.innerText = olist[i].value;
			       // document.body.appendChild(obj);
			        olist[i].parentNode.replaceChild(obj,olist[i]);
			    }
			document.write(div.innerHTML);
			}
</script>