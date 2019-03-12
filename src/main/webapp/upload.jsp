<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"
	language="java" isELIgnored="false"%>


<form id="fileForm" action="${pageContext.request.contextPath}/carousel/upload" enctype="multipart/form-data" method="post">
    <div style="margin:20px;padding:10px;">
        <input type="hidden" name="id"><br>
        
        轮播图名字:<input name="picname"><br>
        轮播图描述:<<input type="text" name="description" /><br><br>
        
        轮播图状态:<select id="cc"  name="status" style="width:150px;">
	                <option value="0" selected>不展示</option>
	                <option value="1">展示</option>
	            </select><br/><br>
        
        上传轮播图:<input style="width:150px" name="source" type="file"/><br><br/>
        &nbsp;&nbsp;&nbsp;
        <input type="submit" value="submit">
    </div>
</form>
