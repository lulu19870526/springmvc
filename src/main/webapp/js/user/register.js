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
                   if(res == "success")
                     alert("注册用户成功");
                    else
                      alert("注册用户失败");
                },
                error: function(){
                    alert("注册用户不成功error");
                }
            });
        }
    }
    });