webpackJsonp([14],{P7ry:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=a("Dd8w"),s=a.n(i),r=a("NYxO"),o={data:function(){return{email:"",password:"",dialog:!1,e1:!1,msg:""}},computed:{},methods:s()({},Object(r.c)(["adduser"]),{doLogin:function(){var t=this;if(!this.email||!this.password)return this.msg="用户名和密码不能为空",this.dialog=!0,!1;this.$http.post("/User/adminlogin",this.$qs.stringify({email:this.email,password:this.password})).then(function(e){t.adduser(e.data),t.$router.push("/index")}).catch(function(e){t.msg="账号密码错误或者权限不足",t.dialog=!0,console.log(e)})}})},n={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-app",[a("v-content",[a("v-container",{attrs:{fluid:"","fill-height":""}},[a("v-layout",{attrs:{"align-center":"","justify-center":""}},[a("v-flex",{attrs:{xs12:"",sm8:"",md4:""}},[a("v-card",{staticClass:"elevation-12"},[a("v-toolbar",{attrs:{dark:"",color:"primary"}},[a("v-toolbar-title",[t._v("Ororus商城后台管理")]),t._v(" "),a("v-spacer")],1),t._v(" "),a("v-card-text",[a("v-form",[a("v-text-field",{attrs:{"prepend-icon":"person",label:"用户名",type:"text"},model:{value:t.email,callback:function(e){t.email=e},expression:"email"}}),t._v(" "),a("v-text-field",{attrs:{"prepend-icon":"lock",label:"密码",id:"password","append-icon":t.e1?"visibility":"visibility_off","append-icon-cb":function(){return t.e1=!t.e1},type:t.e1?"text":"password"},model:{value:t.password,callback:function(e){t.password=e},expression:"password"}})],1)],1),t._v(" "),a("v-card-actions",[a("v-spacer"),t._v(" "),a("v-btn",{attrs:{color:"primary"},on:{click:t.doLogin}},[t._v("登录")])],1)],1)],1)],1)],1)],1),t._v(" "),a("v-dialog",{attrs:{width:"300px"},model:{value:t.dialog,callback:function(e){t.dialog=e},expression:"dialog"}},[a("v-alert",{attrs:{icon:"warning",color:"error",value:!0}},[t._v("\n    "+t._s(t.msg)+"\n    ")])],1)],1)},staticRenderFns:[]},l=a("VU/8")(o,n,!1,null,null,null);e.default=l.exports}});
//# sourceMappingURL=14.4d6cc5e2706f25e7a9cc.js.map