webpackJsonp([18],{jnmG:function(t,s,e){"use strict";Object.defineProperty(s,"__esModule",{value:!0});e("3f40"),e("4qOc"),e("+cgv");var a=e("QmSG"),i=e("G0J2"),l={name:"v-editor",props:{value:{type:String},uploadUrl:{type:String,default:"/"},fileName:{type:String,default:"file"},maxUploadSize:{type:Number,default:524288e3}},data:function(){return{content:"",editorOption:{modules:{toolbar:"#toolbar"}}}},methods:{onChange:function(){this.$emit("input",this.content)},onFileChange:function(t){var s=this,e=t.target;if(0!==e.files.length){this.editor.focus(),e.files[0].size>this.maxUploadSize&&this.$alert("图片不能大于500KB","图片尺寸过大",{confirmButtonText:"确定",type:"warning"});var i=new FormData;i.append(this.fileName,e.files[0]),this.$http.post(this.uploadUrl,i).then(function(t){t.data&&(s.editor.insertEmbed(s.editor.getSelection().index,"image",a.a.imgurl+t.data),s.$emit("input",s.content))})}},imgClick:function(){if(this.uploadUrl){var t=document.createElement("input");t.type="file",t.name=this.fileName,t.accept="image/jpeg,image/png,image/jpg,image/gif",t.onchange=this.onFileChange,t.click()}else console.log("no editor uploadUrl")}},computed:{editor:function(){return this.$refs.myTextEditor.quill}},components:{quilleditor:i.quillEditor},mounted:function(){this.content=this.value},watch:{value:function(t,s){this.editor&&t!==this.content&&(this.content=t)}}},n={render:function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",[e("quilleditor",{ref:"myTextEditor",attrs:{options:t.editorOption},on:{change:t.onChange},model:{value:t.content,callback:function(s){t.content=s},expression:"content"}},[e("div",{attrs:{slot:"toolbar",id:"toolbar"},slot:"toolbar"},[e("select",{staticClass:"ql-size"},[e("option",{attrs:{value:"small"}}),t._v(" "),e("option",{attrs:{selected:""}}),t._v(" "),e("option",{attrs:{value:"large"}}),t._v(" "),e("option",{attrs:{value:"huge"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-script",attrs:{value:"sub"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-script",attrs:{value:"super"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-bold",attrs:{type:"button"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-italic",attrs:{type:"button"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-blockquote",attrs:{type:"button"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-list",attrs:{type:"button",value:"ordered"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-list",attrs:{type:"button",value:"bullet"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-link",attrs:{type:"button"}})]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticStyle:{outline:"none"},attrs:{type:"button"},on:{click:t.imgClick}},[e("svg",{attrs:{viewBox:"0 0 18 18"}},[e("rect",{staticClass:"ql-stroke",attrs:{height:"10",width:"12",x:"3",y:"4"}}),t._v(" "),e("circle",{staticClass:"ql-fill",attrs:{cx:"6",cy:"7",r:"1"}}),t._v(" "),e("polyline",{staticClass:"ql-even ql-fill",attrs:{points:"5 12 5 11 7 9 8 10 11 7 13 9 13 12 5 12"}})])])]),t._v(" "),e("span",{staticClass:"ql-formats"},[e("button",{staticClass:"ql-video",attrs:{type:"button"}})])])])],1)},staticRenderFns:[]},o=e("VU/8")(l,n,!1,null,null,null);s.default=o.exports}});
//# sourceMappingURL=18.8588aa4ad53fe5ec5e2e.js.map