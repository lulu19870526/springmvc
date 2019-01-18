var registerVue =new Vue({
    el: '#registerVue',
    data: {
      username :'',
      password :'',
      age :''
    },
    methods:{
     submitRegister:function(){
             if(registerVue.username == ''){
               alert("请填写用户名");
               return;
             }
              if(registerVue.password == ''){
                alert("请填写密码");
                return;
              }
              if(registerVue.age == ''){
                  alert("请填写年龄");
                  return;
                }

            jQuery.ajax({
                type: "POST",
                url: "/user/register",
                data:{userName:registerVue.username,password:registerVue.password,age:registerVue.age},
                success: function(res){
                   if(res != "fail"){
                    registerVue.setCookie("uid",res,7);
                    alert("注册用户成功,且用户id是"+res);
                    window.location.href = "/user/registersuccess?id="+res+"&userName="
                        +registerVue.username+"&password="+registerVue.password+"&age="+registerVue.age;
                   }
                    else
                      alert("注册用户失败");
                },
                error: function(){
                    alert("注册用户不成功error");
                }
            });
        },

     setCookie:function(name,value,day) {
           var exp = new Date();
           if(!day){
            day = 30;
           }
           exp.setTime(exp.getTime() + day*24*60*60*1000);
           document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
       },

     getCookie:function(name) {
           var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
           if(arr=document.cookie.match(reg))
               return unescape(arr[2]);
           else
               return null;
       }
    }
    });