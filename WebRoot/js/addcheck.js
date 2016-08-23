function checkarea(){
	if($("#aname").val().length<=0){
		alert("请输入赛区名称！");
		return false;
	}
}
function checkschool(){
	if($("#sname").val().length<=0){
		alert("请输入学校名称！");
		return false;
	}
}
function checktype(){
	if($("#tyname").val().length<=0){
		alert("请输入类别名称！");
		return false;
	}
}
function checkitem(){
	if($("#itname").val().length<=0){
		alert("请输入项目名称！");
		return false;
	}
	if($("#itremark").val().length<=0){
		alert("请输入学生人数下限");
		return false;
	}
	else if(!/^\+?[1-9][0-9]*$/.test($("#itremark").val()))
	{
		alert("学生人数下限只能为正整数！");
		return false;
	}
	if($("#itlimit").val().length<=0){
		alert("请输入学生人数上限");
		return false;
	}
	else if(!/^\+?[1-9][0-9]*$/.test($("#itlimit").val()))
	{
		alert("学生人数上限只能为正整数！");
		return false;
	}
	if($("#ittealim").val().length<=0){
		alert("请输入教师人数下限");
		return false;
	}
	else if(!/^\+?[1-9][0-9]*$/.test($("#ittealim").val()))
	{
		alert("教师人数下限只能为正整数！");
		return false;
	}
	if($("#itteacap").val().length<=0){
		alert("请输入教师人数上限");
		return false;
	}
	else if(!/^\+?[1-9][0-9]*$/.test($("#itteacap").val()))
	{
		alert("教师人数上限只能为正整数！");
		return false;
	}
}
function checkadmin(){
	if($("#adname").val().length<=0){
		alert("请输入管理员名称！");
		return false;
	}
	if($("#adpwd").val().length<=0){
		alert("请输入初始密码！");
		return false;
	}
	else if($("#adpwd").val().length<6){
		alert("初始密码不能少于6个字符！");
		return false;
	}
	else if($("#adpwd").val().length>20){
		alert("初始密码不能大于20个字符！");
		return false;
	}
	if($("#adpwd").val()!=$("#repwd").val()){
		alert("两次输入的密码不一致！");
		return false;
	}
}
function checkimage(o){
	var name=o.value;
	if(name=="")
		return;
	var end=name.lastIndexOf(".");
	var type=name.substring(end);
	if(!(type==".jpg"||type==".png"||type==".gif"))
	{	
		alert("请上传合法的图片格式（jpg、png、gif）！");
		//清空选中的不合法文件
		//ie有效，谷歌无效
		o.select();  
		document.selection.clear();
		o.value="";
	}
}

function checkimg(){
	if($("#title").val().length<=0){
		alert("请输入图片标题！");
		return false;
	}
}