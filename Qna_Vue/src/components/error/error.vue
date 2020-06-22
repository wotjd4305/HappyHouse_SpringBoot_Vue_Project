<template>
  <div class="container-result">
	  <header>
	   <br><br>
	  <br><br>
  <div class="jumbotron gomiddle">
    <h1>결 과</h1>      
    <p>성공적으로 삭제되었습니다.</p>
    <p><router-link to="/dummy">메 인 으 로 가 기</router-link></p>
	
  </div>
   <br><br>
    <br><br>
	  </header>
</div>
</template>

<script>
import axios from 'axios';

export default{
name : 'MemberDeleteResult',
  created(){
	this.$store.commit('logout');
	this.$session.destory();
	}//created

}	
</script>

<style>
   .container-result {
		width: 100%; height: 100%;
		color:white;
		opacity:0.8!important;
	}
	.gomiddle{
		margin : 5%;		
	} 
	.jumbotron
	{
		background-color: #e9ecef77
	}

</style>