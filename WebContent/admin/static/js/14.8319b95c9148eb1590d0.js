webpackJsonp([14],{ZiLY:function(e,t){},oOAS:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=i("zL8q"),l=i("QmSG"),a={name:"vUpload",components:{elUpload:s.Upload},props:{url:{type:String},value:{},multiple:{type:Boolean,default:!0},picWidth:{type:Number,default:150},picHeight:{type:Number,default:150}},data:function(){return{showBtn:!1,show:!1,dialogImageUrl:"",baseUrl:l.a.api,avatarStyle:{width:this.picWidth+"px",height:this.picHeight+"px","line-height":this.picHeight+"px"},fileList:[]}},mounted:function(){!this.value||this.value.length<=0||(this.multiple?this.fileList=this.value.map(function(e){return{response:e,url:e}}):this.dialogImageUrl=this.value)},methods:{handleSuccess:function(e,t){this.multiple?(this.fileList.push(t),this.$emit("input",this.fileList.map(function(e){return e.response}))):(this.dialogImageUrl=t.response,this.$emit("input",t.response))},handleRemove:function(e,t){this.fileList=t,this.$emit("input",t.map(function(e){return e.response}))},handlePictureCardPreview:function(e){this.dialogImageUrl=e.response,this.show=!0},removeSingle:function(){this.dialogImageUrl="",this.$refs.singleUpload.clearFiles()}},watch:{value:{deep:!0,handler:function(e,t){t||(this.multiple?this.fileList=e.map(function(e){return{response:e,url:e}}):this.dialogImageUrl=e)}}}},o={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[e.multiple?i("el-upload",{ref:"multiUpload",attrs:{action:e.baseUrl+e.url,"list-type":"picture-card","on-success":e.handleSuccess,"on-preview":e.handlePictureCardPreview,"on-remove":e.handleRemove,"file-list":e.fileList}},[i("i",{staticClass:"el-icon-plus"})]):i("el-upload",{ref:"singleUpload",staticClass:"logo-uploader",style:e.avatarStyle,attrs:{action:e.baseUrl+e.url,"show-file-list":!1,"on-success":e.handleSuccess}},[i("div",{on:{mouseover:function(t){e.showBtn=!0},mouseout:function(t){e.showBtn=!1}}},[i("i",{directives:[{name:"show",rawName:"v-show",value:e.dialogImageUrl&&e.showBtn,expression:"dialogImageUrl && showBtn"}],staticClass:"el-icon-close remove-btn",on:{click:function(t){return t.stopPropagation(),e.removeSingle(t)}}}),e._v(" "),e.dialogImageUrl?i("img",{style:e.avatarStyle,attrs:{src:e.dialogImageUrl}}):i("i",{staticClass:"el-icon-plus logo-uploader-icon",style:e.avatarStyle})])]),e._v(" "),i("v-dialog",{attrs:{"max-width":"500"},model:{value:e.show,callback:function(t){e.show=t},expression:"show"}},[i("img",{attrs:{width:"500px",src:e.dialogImageUrl,alt:""}})])],1)},staticRenderFns:[]};var n=i("VU/8")(a,o,!1,function(e){i("ZiLY")},"data-v-65af3cd2",null);t.default=n.exports}});
//# sourceMappingURL=14.8319b95c9148eb1590d0.js.map