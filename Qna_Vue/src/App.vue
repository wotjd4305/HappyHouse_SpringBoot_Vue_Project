<template>

<div id="app">
<header>
<br>
<p  style="text-decoration:none"><router-link to="/"><strong><font size = "10em" color=white>Happy House</font></strong></router-link></p>
<br><br>
</header>

<!--
<c:if test="${userid == null}">
-->
<div v-if=!this.$store.state.logged><!--v-if-->
	<ul>
 		<li><router-link to="/memberjoin">회원가입</router-link></li>
  		<li><router-link to="/memberFindPass">비밀번호 찾기</router-link></li>
  		<li><router-link to="/memberLogin">로 그 인</router-link></li>
	</ul>
</div>
<!--
</c:if>

<c:if test="${userid != null}">
-->
<div v-else>
	<div  style="background-color:#29293d"><font size=5em color="white">
		<strong>{{show_id.id}}</strong>님 환영합니다.
	</font></div>
	<div>
		<ul>
      <li><router-link to="/MemberSearch">회원정보 조회</router-link></li>
      <li><router-link to="/MemberModify">회원정보 수정</router-link></li>
      <li><router-link to="/MemberDelete">회원정보 삭제</router-link></li>
      <li><router-link to="/houseDealSearch">매매정보 검색</router-link></li>
      <li><a href="#" @click="logout">로그아웃</a></li>
      <li><router-link to="/QnaList">게시판</router-link></li>
      
		</ul>
	</div>
</div>
<div class="main">
  <router-view />

	<br><br>
	
  <!--
</c:if>
-->

</div>
<div id="footer">
  <main-footer/>
</div>




</div>

</template>

<style>


	#app{
		height: 100%;
	}

	.main{
		position: relative;
		height: 100%;
	}

	header{
	background-image: url("../src/assets/mainbg_.jpg");
	background-repeat: no-repeat;
	background-size:100%;
	background-position: center 55%;
	padding: 30px;
	text-align:center;
	}
	
	ul {
 	 list-style-type: none;
 	 margin: 0;
 	 padding: 0;
 	 overflow: hidden;
 	 background-color: #333;
	}

	li {
 	 float: left;
	}
	
	li a {
	display: block;
	color: white;
 	 text-align: center;
 	 padding: 14px 16px;
 	 text-decoration: none;
	}

	/* Change the link color to #111 (black) on hover */
	li a:hover {
  		background-color: #111;
	}

	/* error(result 헤더) */
	.container-result header{
		background-image: url("../src/assets/img_sucess.jpg"); 
		background-repeat : no-repeat;
		opacity:0.8!important;
		background-size : cover;
		filter:alpha(opacity=50);
	} 

	
</style>



<script>
import MainFooter from './components/Footer.vue'
import Login from './components/member/MemberLogin.vue'
import axios from 'axios';
import EventBus from './components/eventBus/EventBus.js'

export default{
name : 'App',
components: {
	'main-footer': MainFooter
  },
	data:function(){
        return {
			show_id : ""
        }
    },
  beforeCreate() {
	
      
  },
  created(){
		EventBus.$on('msg', (payload) =>{
			this.show_id.id = payload;
			consoe.log("LOG : "+payload);
		})
	  
	 if(!this.$store.state.logged){
		 this.$router.push("/");
	 }
	 this.show_id = this.$session.get("userinfo");
	 
	  if($session.has("userinfo")){
		this.$store.commit('login');
		}



	}//created
	,
 methods:{
 	logout() {
		
		this.$store.commit('logout');
		this.$session.remove("userinfo");
		
		this.$session.clear();
		this.$router.push("/");
		
		}//dataCheck
 }
}	

</script>
