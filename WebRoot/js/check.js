function checkUser() {
	if($("#tname").val().length<=0){
		alert("请输入队名！");
		$(".nullcss").removeClass("nullcss");
		$("#tname").addClass("nullcss");
		return false;
	}
	else if($("#tname").val().length<2){
		alert("队名不能小于2个字符！");
		$(".nullcss").removeClass("nullcss");
		$("#tname").addClass("nullcss");
		return false;
	}
	else if($("#tname").val().length>20){
		alert("队名长度不能超过20！");
		$(".nullcss").removeClass("nullcss");
		$("#tname").addClass("nullcss");
		return false;
	}
	if($("#tpwd").val().length<=0){
		alert("请输入密码！");
		$(".nullcss").removeClass("nullcss");
		$("#tpwd").addClass("nullcss");
		return false;
	}
	else if($("#tpwd").val().length<6){
		alert("密码不能小于6个字符！");
		$(".nullcss").removeClass("nullcss");
		$("#tpwd").addClass("nullcss");
		return false;
	}
	else if($("#tpwd").val().length>20){
		alert("密码不能超过20个字符！");
		$(".nullcss").removeClass("nullcss");
		$("#tpwd").addClass("nullcss");
		return false;
	}
	if($("#retpwd").val()!=$("#tpwd").val()){
		alert("两次输入的密码不一致！");
		$(".nullcss").removeClass("nullcss");
		$("#tpwd").addClass("nullcss");
		$("#retpwd").addClass("nullcss");
		return false;
	}
	if($("#tuniversity").val().length<=0){
		alert("请选择学校！");
		$(".nullcss").removeClass("nullcss");
		$("#tuniversity").addClass("nullcss");
		return false;
	}
	if($("#temail").val().length<=0){
		alert("请输入邮箱！");
		$(".nullcss").removeClass("nullcss");
		$("#temail").addClass("nullcss");
		return false;
	}
	else if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test($("#temail").val())){
		alert("邮箱格式不正确！");
		$(".nullcss").removeClass("nullcss");
		$("#temail").addClass("nullcss");
		return false;
	}
}
function checkupdate()
{
	if($("#tname").val().length<=0){
		alert("请输入队名！");
		return false;
	}
	else if($("#tname").val().length<2){
		alert("队名不能小于2个字符！");
		return false;
	}
	else if($("#tname").val().length>15){
		alert("队名不能超过15个字符！");
		return false;
	}
	if($("#tuniversity").val().length<=0){
		alert("请选择学校！");
		return false;
	}
	if($("#temail").val().length<=0){
		alert("请输入邮箱！");
		return false;
	}
	else if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test($("#temail").val())){
		alert("邮箱格式不正确！");
		return false;
	}
}
function checkmember(){
	if($("#mname").val().length<=0){
		alert("请输入姓名！");
		return false;
	}
	else if($("#mname").val().length>15){
		alert("姓名不能超过15个字符！");
		return false;
	}
	if($("#mphone").val().length<=0){
		alert("请输入手机号码！");
		return false;
	}
	else if(!/^1[3|4|5|8][0-9]\d{4,8}$/.test($("#mphone").val())){
		alert("手机号格式不正确！");
		return false;
	}
	if($("#memail").val().length<=0){
		alert("请输入邮箱！");
		return false;
	}
	else if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test($("#memail").val())){
		alert("邮箱格式不正确！");
		return false;
	}
}
function checkfilename(o){
	var name=o.value;
	if(name=="")
		return;
	var end=name.lastIndexOf(".");
	var type=name.substring(end);
	if(!(type==".txt"||type==".jpg"||type==".png"||type==".gif"||type==".doc"
		||type==".docx"||type==".pdf"||type==".ppt"||type==".pptx"||type==".xls"
			||type==".xlsx"||type==".zip"||type==".rar"))
	{	
		alert("选择的文件类型不合法，请重新选择，或者打包后上传。");
		//清空选中的不合法文件
		//ie有效，谷歌无效
		o.select();  
		document.selection.clear();
		o.value="";
	}
}

function checkpassword(){
	if($("#oldpwd").val().length<=0)
	{
		alert("请输入原密码！");
		return false;
	}
	if($("#newpwd").val().length<6)
	{
		alert("密码长度不能小于6！");
		return false;
	}
	if($("#newpwd").val()!=$("#repwd").val())
	{
		alert("两次输入的密码不一致！");
		return false;
	}
}
function checkadpwd(){
	if($("#oldpwd1").val().length<=0)
	{
		alert("请输入原密码！");
		return false;
	}
	if($("#newpwd1").val().length<=0)
	{
		alert("请输入新密码！");
		return false;
	}
	else if($("#newpwd1").val().length<6)
	{
		alert("新密码长度不能小于6！");
		return false;
	}
	else if($("#newpwd1").val().length>20)
	{
		alert("新密码长度不能大于20！");
		return false;
	}
	if($("#newpwd1").val()!=$("#repwd1").val())
	{
		alert("两次输入的密码不一致！");
		return false;
	}
}

function checkarticle(){
	if($("#mtitle").val().length<=0)
	{
		alert("请输入文章标题！");
		return false;
	}
	if($("#mtitle").val().length>50)
	{
		alert("文章标题太长，请不要超过50个字符！");
		return false;
	}
	if($("#mcontent").val().length<=0)
	{
		alert("请输入文章内容！");
		return false;
	}
}
function checkadmin(){
	if($("#adminname").val().length<=0){
		alert("请输入用户名！");
		return false;
	}	
	if($("#adminemail").val().length<=0){
		alert("请输入邮箱！");
		return false;
	}	
	else if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test($("#adminemail").val())){
		alert("邮箱格式不正确！");
		return false;		
	}
}
