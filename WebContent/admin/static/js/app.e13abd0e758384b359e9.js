webpackJsonp([20],{"09yM":function(e,n){},"729U":function(e,n){},NHnr:function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var r=t("kV13"),a=t("48sp"),o={render:function(){var e=this.$createElement;return(this._self._c||e)("router-view")},staticRenderFns:[]},s=t("C7Lr")({name:"App"},o,!1,null,null,null).exports,u=t("7LQH");function i(e,n,r,a){return{exact:!0,path:e,name:r,children:a,component:function(){return t("r07X")("./pages"+n)}}}r.default.use(u.a);var c=new u.a({routes:[i("/","/Login","Login"),{path:"/index",component:function(){return t.e(1).then(t.bind(null,"cpAg"))},redirect:"/index/dashboard",children:[i("/index/dashboard","/Dashboard","Dashboard"),i("/item/category","/item/Category","Category"),i("/item/brand","/item/Brand","Brand"),i("/item/list","/item/Goods","Goods"),i("/item/specification","/item/Specification","Specification"),i("/user/UserManage","/user/UserManage","UserManage"),i("/trade/promotion","/trade/Promotion","Promotion")]}]}),p=t("oNd2"),l=t.n(p),d=t("QmSG"),m=t("3cXf"),g=t.n(m),f=t("rVsN"),v=t.n(f),h=t("TcQY"),b={info:function(e){Object(h.Message)({showClose:!0,message:e,type:"info"})},error:function(e){Object(h.Message)({showClose:!0,message:e,type:"error"})},success:function(e){Object(h.Message)({showClose:!0,message:e,type:"success"})},warning:function(e){Object(h.Message)({showClose:!0,message:e,type:"warning"})},confirm:function(e){return new v.a(function(n,t){h.MessageBox.confirm(e,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n()}).catch(function(){t()})})},prompt:function(e){return new v.a(function(n,t){h.MessageBox.prompt(e,"提示",{confirmButtonText:"确定",cancelButtonText:"取消"}).then(function(e){var t=e.value;n(t)}).catch(function(){t()})})}},y={install:function(e){e.component("vTree",function(){return t.e(16).then(t.bind(null,"vXi7"))}),e.component("vCascader",function(){return t.e(15).then(t.bind(null,"a6nq"))}),e.component("vUpload",function(){return t.e(17).then(t.bind(null,"oOAS"))}),e.component("vEditor",function(){return Promise.all([t.e(0),t.e(18)]).then(t.bind(null,"jnmG"))}),e.prototype.$message=b,e.prototype.$format=function(e){if("string"==typeof e){if(isNaN(e))return null;var n=e.lastIndexOf("."),t="";return t=n<0?e+"00":n===t.length-2?e.replace(".","")+"0":e.replace(".",""),parseInt(t)}if("number"==typeof e){if(null==e)return null;var r=e+"";if(0===r.length)return 0;if(1===r.length)return"0.0"+e;if(2===r.length)return"0."+e;var a=r.indexOf(".");if(a<0)return r.substring(0,r.length-2)+"."+r.substring(r.length-2);var o=r.substring(0,a)+r.substring(a+1);if(1===a)return"0.0"+o;if(2===a)return"0."+o;if(a>2)return o.substring(0,a-2)+"."+o.substring(a-2)}}}};Object.deepCopy=function(e){return JSON.parse(g()(e))};var w=y,G=t("84iU"),C=t.n(G);C.a.defaults.baseURL=d.a.api,C.a.defaults.timeout=1e4,C.a.defaults.withCredentials=!0,C.a.defaults.headers["Content-Type"]="application/x-www-form-urlencoded;charset=UTF-8",C.a.interceptors.request.use(function(e){return console.log(e),e},function(e){return console.log(e),v.a.reject(e)}),C.a.interceptors.response.use(function(e){return console.log(e),e},function(e){return console.log(e),v.a.reject(e)}),r.default.prototype.$http=C.a;t("p5dZ");var x=t("atmG"),B=t.n(x);t("09yM"),t("729U");r.default.use(a.a);var P=new a.a.Store({state:{uesr:{}},getters:{getusername:function(e){return e.uesr.name},getuser:function(e){return e.uesr}},mutations:{adduser:function(e,n){e.uesr=n}},actions:{}});r.default.use(l.a,{theme:d.a.theme}),r.default.use(w),r.default.prototype.$qs=B.a,r.default.config.productionTip=!1,new r.default({el:"#app",router:c,store:P,components:{App:s},template:"<App/>"})},QmSG:function(e,n,t){"use strict";var r="http://127.0.0.1:8080/cart",a={locale:"zh-CN",url:r,debug:{http:!1},imgurl:r+"/",api:r+"/Admin",theme:{primary:"#2196F3",secondary:"#455A64",accent:"#9c27b0",error:"#f44336",warning:"#FFC107",info:"#64B5F6",success:"#4caf50"},isDark:!0,unitOption:[{header:"长度"},{value:"mm"},{value:"cm"},{value:"dm"},{value:"m"},{value:"寸"},{value:"英寸"},{value:"尺"},{divider:!0},{header:"重量"},{value:"mg"},{value:"g"},{value:"kg"},{value:"t"},{divider:!0},{header:"像素"},{value:"万像素"},{divider:!0},{header:"频率"},{value:"Hz"},{value:"mHz"},{value:"gHz"},{divider:!0},{header:"存储"},{value:"KB"},{value:"MB"},{value:"GB"},{divider:!0},{header:"电压"},{value:"V"},{value:"KV"},{divider:!0},{header:"电池容量"},{value:"mAh"},{divider:!0},{header:"功率"},{value:"w"},{value:"Kw"},{divider:!0},{header:"电流"},{value:"μA"},{value:"mA"},{value:"A"},{divider:!0},{header:"电阻"},{value:"Ω"},{value:"KΩ"},{value:"A"},{divider:!0}]};n.a=a},p5dZ:function(e,n){},r07X:function(e,n,t){var r={"./pages/Dashboard":["s+3R",2],"./pages/Dashboard.vue":["s+3R",2],"./pages/Layout":["cpAg",1],"./pages/Layout.vue":["cpAg",1],"./pages/Login":["P7ry",14],"./pages/Login.vue":["P7ry",14],"./pages/item/Brand":["ssss",0,5],"./pages/item/Brand.vue":["ssss",0,5],"./pages/item/BrandForm":["RPpC",10],"./pages/item/BrandForm.vue":["RPpC",10],"./pages/item/Category":["DpGy",0,8],"./pages/item/Category.vue":["DpGy",0,8],"./pages/item/Goods":["priW",0,7],"./pages/item/Goods.vue":["priW",0,7],"./pages/item/GoodsForm":["mWTg",0,13],"./pages/item/GoodsForm.vue":["mWTg",0,13],"./pages/item/Specification":["Nmb/",9],"./pages/item/Specification.vue":["Nmb/",9],"./pages/tmp/Goods":["Zusx",3,0],"./pages/tmp/Goods.vue":["Zusx",3,0],"./pages/tmp/GoodsForm":["vsuj",4,0],"./pages/tmp/GoodsForm.vue":["vsuj",4,0],"./pages/trade/Promotion":["OPnq",11],"./pages/trade/Promotion.vue":["OPnq",11],"./pages/user/UserForm":["SG/P",12],"./pages/user/UserForm.vue":["SG/P",12],"./pages/user/UserManage":["DWtw",0,6],"./pages/user/UserManage.vue":["DWtw",0,6]};function a(e){var n=r[e];return n?Promise.all(n.slice(1).map(t.e)).then(function(){return t(n[0])}):Promise.reject(new Error("Cannot find module '"+e+"'."))}a.keys=function(){return Object.keys(r)},a.id="r07X",e.exports=a}},["NHnr"]);
//# sourceMappingURL=app.e13abd0e758384b359e9.js.map