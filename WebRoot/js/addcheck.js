function checkarea(){
	if($("#aname").val().length<=0){
		alert("�������������ƣ�");
		return false;
	}
}
function checkschool(){
	if($("#sname").val().length<=0){
		alert("������ѧУ���ƣ�");
		return false;
	}
}
function checktype(){
	if($("#tyname").val().length<=0){
		alert("������������ƣ�");
		return false;
	}
}
function checkitem(){
	if($("#itname").val().length<=0){
		alert("��������Ŀ���ƣ�");
		return false;
	}
	if($("#itremark").val().length<=0){
		alert("������ѧ����������");
		return false;
	}
	else if(!/^\+?[1-9][0-9]*$/.test($("#itremark").val()))
	{
		alert("ѧ����������ֻ��Ϊ��������");
		return false;
	}
	if($("#itlimit").val().length<=0){
		alert("������ѧ����������");
		return false;
	}
	else if(!/^\+?[1-9][0-9]*$/.test($("#itlimit").val()))
	{
		alert("ѧ����������ֻ��Ϊ��������");
		return false;
	}
	if($("#ittealim").val().length<=0){
		alert("�������ʦ��������");
		return false;
	}
	else if(!/^\+?[1-9][0-9]*$/.test($("#ittealim").val()))
	{
		alert("��ʦ��������ֻ��Ϊ��������");
		return false;
	}
	if($("#itteacap").val().length<=0){
		alert("�������ʦ��������");
		return false;
	}
	else if(!/^\+?[1-9][0-9]*$/.test($("#itteacap").val()))
	{
		alert("��ʦ��������ֻ��Ϊ��������");
		return false;
	}
}
function checkadmin(){
	if($("#adname").val().length<=0){
		alert("���������Ա���ƣ�");
		return false;
	}
	if($("#adpwd").val().length<=0){
		alert("�������ʼ���룡");
		return false;
	}
	else if($("#adpwd").val().length<6){
		alert("��ʼ���벻������6���ַ���");
		return false;
	}
	else if($("#adpwd").val().length>20){
		alert("��ʼ���벻�ܴ���20���ַ���");
		return false;
	}
	if($("#adpwd").val()!=$("#repwd").val()){
		alert("������������벻һ�£�");
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
		alert("���ϴ��Ϸ���ͼƬ��ʽ��jpg��png��gif����");
		//���ѡ�еĲ��Ϸ��ļ�
		//ie��Ч���ȸ���Ч
		o.select();  
		document.selection.clear();
		o.value="";
	}
}

function checkimg(){
	if($("#title").val().length<=0){
		alert("������ͼƬ���⣡");
		return false;
	}
}