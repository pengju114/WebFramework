<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="request" value="${contextPath}/images/admin" var="imgPath" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            body { margin:0 auto; padding:0; border:0;}
            td {  overflow:hidden;}
            *{ font:12px "宋体"; color:#004C7E;}
            a { color:#004C7E; text-decoration:none;}
            a:hover { color: #090; text-decoration:underline;}
            .title{
                background:url(../images/admin/list_task.jpg) repeat-x center;
                height:22px;
                padding:10px 0 0 12px;
            }
            .title a{
                font-size:14px;
                padding: 0px;
            }
            .title a:hover{
                font-size:14px;
                 text-decoration:none;
            }
            ul{
                padding:0px;
                margin:0px 0px 0 12px;
                list-style-type: yellow;
                overflow:hidden;
            }
            li{
                overflow:hidden;
                margin:3px 0px 0px 12px;
            }
            div{
                overflow:hidden;
            }
        </style>
        <script type="text/javascript" src="../scripts/pj-2.4.mini.js"></script>
    </head>
    <body>
        <table width="166" height="100%" cellpadding="0" cellspacing="0">
            <tr>
                <td align="center" valign="top" bgcolor="D4ECFC">
                    <table width="162" height="100%" cellpadding="0" cellspacing="0">
                        <tr>
                            <td style="background:url(../imgs/admin/images/list_top.gif) no-repeat left top;" height="28"></td>
                        </tr>

                        <tr>
                            <td valign="top" align="left">
                                <div>
                                    <div class="title">
                                        <a class="trigger" index="0" href="javascript:void(0)">管理员管理</a>
                                    </div>
                                    <div class="item">
                                        <ul>
                                            <li><a target="I2" href="${contextPath}/admin/addAdmin.do">创建管理员</a></li>
                                            <li><a target="I2" href="${contextPath}/admin/listAdmins.do">查找管理员</a></li>
                                        </ul>
                                    </div>
                                    
                                    <div class="title">
                                        <a class="trigger" index="1" href="javascript:void(0)">权限管理</a>
                                    </div>
                                    <div class="item">
                                        <ul>
                                            <li><a target="I2" href="${contextPath}/admin/findRole.do">角色管理</a></li>
                                            <li><a target="I2" href="${contextPath}/admin/findAuthority.do">权限</a></li>
                                        </ul>
                                    </div>
                                    
                                </div>

                                

                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <script type="text/javascript">
            var uls=pj("div.item").array().get();
            pj("a.trigger").each(function(i){
                if(i!=0)uls[i].style.display="none";
            }).click(function(){
                var index= parseInt(this.getAttribute("index"));
                if(uls[index]){
                    if(pj(uls[index]).isVisible()){
                        pj(uls[index]).slideUp(300);
                    }else{
                        pj(uls[index]).slideDown(300);
                    }
                }
            });
        
        pj("div.item a").click(function(){ 
            var title=pj(this).parent().parent().parent().prev().children().single().html();
            var category = pj(this).html();
            
            window.top.nav= {"title":title,"category":category};
            return false; 
        });
        </script>
    </body>
</html>
