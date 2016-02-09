<HTML>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--   https://localhost:10032/MPA/jsp/WCMSimpleSearch.jsp -->
<STYLE type="text/css">  
* { margin:0px; padding 0px;} 
body {
    /*font-family:Consolas,Menlo,Monaco,Lucida Console,Liberation Mono,DejaVu Sans Mono,Bitstream Vera Sans Mono,Courier New,monospace,sans-serif;*/
	font-family: arial,helvetica;
    font-size:15px;
}
	textarea.database {
	position: absolute;
	left: -2000px;
	offsetHeight: -20;
	visibility: hidden;
}
.container  , .requestContainer2 {
    margin:10px;
	width : 80%;
	/*height: 80%;*/
    border: 2px CornflowerBlue  solid;
	background: Cornsilk;
	font-family:Helvetica, cursive, serif;border-radius:5px; font-size:18px;padding:10px;
	color:green;
    line-height:0.2em;
}
.container h5 {
    line-height:0.2em; margin-bottom:10px;
}
.requestContainer2 {
    width : 50%;
	/*height: 50%;*/
}
.defaultLevelOneDropdown {
  display:none;
}
.defaultAdditionalLevel {
  display:none;
}
.defaultResults {
 display:none;
}
.levelOneCat , .levelTwoCat , .searchResults{
    border: 2px CornflowerBlue  solid;
    background:Cornsilk;/*   greenyellow;*/
    border-radius:5px;
	font-family:Helvetica, cursive, serif; font-size:18px;padding:10px;
	color:green;
  
   /*border-radius:10px;*/
 }
 .levelOneCatMore {
    width:50%;
     height:50%;
 }
.levelOneCat h5 {
  line-height:0.2em;margin-bottom:10px;
}
#checkLevelCat {
  margin:5px;
}

.levelTwoCat {
   margin:3px;
   /* left: 35%;*/
   position:relative;
   /* top: -78px;*/
}
 .searchResults {
   /*  width:90%; */
   /*  height:45%;*/
 }
 .leftAligned { 
   /*left: 180%;*/
   /*float:right;*/
   position:relative;
   /*top: -50px; */
   width: 70%;
   /*height : 60%;*/
 }
 .menuResult{
    border: 2px CornflowerBlue  solid;
    background:Cornsilk;
    border-radius:5px;
   font-family:Helvetica, cursive, serif; font-size:12px;
	color:green;
  }
.menuResult table {
   font-family:Helvetica, cursive, serif; font-size:12px;
}
#container img {
    display:block;
	width: 30%;
	height:30%;
    margin:auto;
    border:2px orange solid;
	border-radius:10px;
 }
.warning {  background-color: red; padding: 2px; }
.formContainer {background-color: #eee;font-family:Consolas,Menlo,Monaco,Lucida Console,Liberation Mono,DejaVu Sans Mono,Bitstream Vera Sans Mono,Courier New,monospace,sans-serif;
 font-size:13px;word-wrap:break-word; width:1100px;margin:10px;
  }
.wcmresponse {
font-family:Consolas,Menlo,Monaco,Lucida Console,Liberation Mono,DejaVu Sans Mono,Bitstream Vera Sans Mono,Courier New,monospace,sans-serif;
     background-color: #F8F8FF; /*GhostWhite */
	 float:right;
	 width:30%;
	 margin:0 auto;
	 font-size:9px;
	 
 }
 .wcmresponse  td {
   padding: 0px; margin:0px;
   font-family:Helvetica, cursive, serif;
   font-size:9px;
   border:1 solid #eee;
 }
 .wcmsearch {
    font-family:Consolas,Menlo,Monaco,Lucida Console,Liberation Mono,DejaVu Sans Mono,Bitstream Vera Sans Mono,Courier New,monospace,sans-serif;
	 background-color: HoneyDew ; /*GhostWhite */
	 float:right;/**/
	 width:20%;
	 margin:0 auto;
	 font-size:9px;
 }
  .wcmsearch  td {
   padding: 0px; margin:0px;
   font-family:Helvetica, cursive, serif;
   font-size:9px;
   border:1 solid #eee;
 }
 .wcmcontentsearch {
   font-family:Consolas,Menlo,Monaco,Lucida Console,Liberation Mono,DejaVu Sans Mono,Bitstream Vera Sans Mono,Courier New,monospace,sans-serif;
     /* background-color: #F8F8FF;GhostWhite */
	 font-size:9px; 
 }
 
 
 input[type="submit"], input[type="button"], button, .button, a.button, a.button:visited, .btn {
    background: #009afd none repeat scroll 0 0;
    border: 1px solid #1777b7;
    border-radius: 3px;
    box-shadow: 0 1px 0 rgba(255, 255, 255, 0.3) inset, 0 1px 1px rgba(100, 100, 100, 0.3);
    color: #fff;
    cursor: pointer;
    display: inline-block;
    line-height: 1;
    padding: 0.6em 0.8em;
    text-align: center;
    transition: background 0.15s ease 0s, color 0.15s ease 0s;
} 
.content_snippet {
    background: transparent linear-gradient(#ffffff, #f5f5f5) repeat scroll 0 0;
    border: 1px solid #dddddd;
    border-radius: 7px;
    margin: 0 0 30px;
    padding: 15px;
}
.content_snippet {
    margin-bottom: 15px;
    width: 60%; /*418px;    */
	margin: 0 30px 30px;
   font-family: arial,helvetica;
}
.content_snippet  table {
    font-size:13px;
	font-family: arial,helvetica;
}
.content_snippet table   {
   width : 100%;
   /*  border: 1px solid #d2d2d2;
    border-radius: 7px;*/
}
.content_snippet table tr td {
   /*border: 1px solid #d2d2d2;
   border-radius: 7px;*/
}
.content_snippet  table tr:first-child {
    font-size:15px;
    font-weight:bold;
}
.content_snippet  table  tr  td:last-child {
  /*width: 40%;*/col-span:2;
 }
.content_snippet  table  tr  td #container img {
  width: 30%; height : 30%; 
 }
/*
*::-moz-placeholder {
   color: #999;
}
*::-moz-selection {
  background: #ff4020 none repeat scroll 0 0;
  color:#fff;
} */
</STYLE>   
<script src="js/jquery-1.10.2.js"></script> 
<body>
<form action="#" id="wcmsearchinput" name="circle_taxonomy">
<div class="formContainer" id="containerId">  <!--  START DIV Container -------------------------------------------START -->
 <table> 
   <tr><td>
    <table><tr><th align="left">Search Text</th></tr>
        <tr><td> <p>
	     <input type="text" placeholder="Duis" name="searchText" id="searchText1"></p>
	 </td><td><p>
	     <input type="text" placeholder="Sed" name="searchText" id="searchText2"></p>
	 </td><td><p>
	     <input type="text" placeholder="Donec" name="searchText" id="searchText3"></p>
	 </td><td><p>
	     <input type="text" placeholder="Augue" name="searchText" id="searchText4"></p>
	 </td>
	 <td><p>
	     <input type="text" placeholder="Pellentesque" name="searchText" id="searchText5"></p>
	 </td>
	  <td><p>
	     <input type="text" placeholder="Pellentesque" name="searchText" id="searchText5"></p>
	 </td>
	 </tr>
    </table> 
    </td>
	 
    </tr>    
   </table>
 
  <div id="wcmOutContainer" class="wcmresponse" >
         
  </div>
   
  <div id="submitContainer" style="margin: 0px 5px; ">
         <input type="button" style="margin: 1em 0 1em 0.5em; float: none;" value="Send Parameters" id="submitContent">
  </div>
  <div id="searchContainer" style="margin: 0px 5px; ">
         <input type="button" style="margin: 1em 0 1em 0.5em; float: none;" value="Search Content" id="searchContent">
  </div>
   <div id="wcmResultCont" class="wcmsearch" >
         
  </div>
 
</div> <!--  END DIV Container -------------------------------------------END -->
 <div id="wcmContent">
          
  </div>

</form>

<script type="text/javascript"> 

$(document).ready(function () {
     initPageData();
     validateForm();
	 attachHandlers();
  });
function initPageData(){ 
    pageData = { isValid:"false", taxonomy:"",category:"",siteAreas:"",templateId:""};
	formFields = [ "isValid","taxonomy","category","siteAreas","templateId" ];
	
	$("#searchContent").hide();
}
function validateForm(){ 
   $('#wcmsearchinput input').blur(function()
   {if( $(this).val().length === 0 ) {
        $(this).parents('p').addClass('warning');
		
    }else { $(this).parents('p').removeClass('warning'); pageData.isValid="true";
	    var fld = $(this).attr('name');
	    pageData[fld]=$(this).val();
   	 }
   });
}
function attachHandlers(){ 
   $('#submitContent').click(function() {
        log(" submit content clicked ");
        if (pageData.isValid=="true") { ajaxSubmit(); } else {log(" page data invalid "); }
     } );
	$('#searchContent').click(function() {
        log(" search content clicked ");
        if (pageData.isValid=="true") { ajaxSearch(); } else {log(" page data invalid "); }
     } );
}
function log(msg){ if (console) { console.log(msg);}} 
function prepareFormData(formID){
    // {“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ 
    var formFields = document.getElementById(formID).elements;
     var formData =""; var fld =""; var values= [];
    for (var k =0; k< formFields.length; k++){
	     fld = formFields[k].value;
	    values.push(fld);
	}
	//var integralVals =   values.substring(0, values.length-1);
	formData = {searchText: values}
	/*return formData;   */
	var formData = JSON.stringify(formData);
	return formData;/**/
}
function ajaxSubmit(){
       var postData =  prepareFormData("wcmsearchinput");
    // Make an ajax call to WCMSimpleOut.jsp
	   $.ajax({
		 type: "post",
		 url: '/SpringSecurityRest/counter-api/search',
		 data: postData,
		 contentType : "application/json",
		 crossDomain: true,
		 dataType: "json",
		 processData: false,
		 beforeSend : function (xhr) {
			document.getElementById("wcmOutContainer").style.display = 'block';
			    document.getElementById("wcmOutContainer").innerHTML ="Loading.....";
			 },
		 success: function(data,textStatus,jqXHR ) {
			if(console){ console.log(data); }
			 if(textStatus=="success" ) {
			  var xmlData = new String(jqXHR.responseText); //arguments[3].responseXML;
			  
			  document.getElementById("wcmOutContainer").innerHTML =jqXHR.responseText;
			  document.getElementById("submitContent").disabled="disabled";
			  $("#searchContent").show();
			  if(xmlData) {
				console.log("xmlData " +xmlData);
			 }
			}// if success 
		  }
	 });
}
function ajaxSearch(){
       var postData =  prepareFormData();
    // Make an ajax call to WCMSimpleOut.jsp
	   $.ajax({
		 type: "post",
		 url: '/MPA/jsp/WCMContentSearch.jsp',
		 data: postData,
		 contentType: "application/x-www-form-urlencoded",
		 crossDomain: true,
		 dataType: "html",
		 processData: false,
		 beforeSend : function (xhr) {
			document.getElementById("wcmContent").style.display = 'block';
			    document.getElementById("wcmContent").innerHTML ="Loading.....";
			 },
		 success: function(data,textStatus,jqXHR ) {
			if(console){ console.log(data); }
			 if(textStatus=="success" ) {
			  var xmlData = new String(jqXHR.responseText); //arguments[3].responseXML;
			  
			  document.getElementById("wcmContent").innerHTML =jqXHR.responseText;
			  document.getElementById("searchContent").disabled="disabled";
			  $("#searchContent").hide();
			  if(xmlData) {
				console.log("xmlData " +xmlData);
			 }
			}// if success 
		  }
	 });
}


</script>
</body>
 </HTML>
