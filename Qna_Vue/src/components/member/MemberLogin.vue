<template>
  <div class="container login" align="center">
	<div class="col-lg-6" align="center">
			<div class="form-group" align="left">
				<div class="form-row"><div class="name">ID</div></div>
				<input type="text" class="form-control" id="id" name="id" placeholder="" v-model="id">
			</div>
			<div class="form-group" align="left">
				<div class="form-row"><div class="name">PASSWORD</div></div>
				<input type="password" class="form-control" id="pass" name="pass" placeholder="" v-model="pass">
			</div>
			<div class="form-group form-check" align="right">
			</div>
			<div class="form-group" align="center">
				<button class="btn btn-warning btn-text-white" @click="dataCheck" >로그인</button>
			</div>
	</div>
</div>
</template>

<script>
import axios from 'axios';
import EventBus from '@/components/eventBus/EventBus.js'

export default {
    props:['parentMessage'],
    name:"MemberLogin"
    , data:function(){
        return{
            id:""
            , pass:""
            , childMessage:'자식'
        }
    }//data
    ,
    props:{
       parentMessage : String
    }
    ,
    created(){
        childMessage: '이것은 자식 데이터이다'
        parentMessage: "ㅇ아녕"
    }
    , methods:{
        dataCheck() {
            let err = false;
            let msg = '';
            !this.id && (msg = '아이디를 입력해주세요', err = true);
            !err && !this.pass && (msg = '비밀번호 입력해주세요', err = true);
            if (err) alert(msg);
            else this.dataSend();
        }//dataCheck
        , dataSend() {
            axios.post('http://localhost:9999/vue/api/member/login'
                        , {id: this.id, pass: this.pass})
			.then((res) => {alert('로그인이 완료되었습니다.');
						this.$session.set("userinfo",res.data);
                        this.$store.commit('login',res.data.id);
                        //var bus = new Vue();
                        EventBus.$emit('msg', res.data.id);
                        this.$router.push("/dummy");})
            .catch((error)=>{alert("아이디 혹은 비밀번호 틀림")});
        }//dataSend
    }//methods
}
</script>

<style>
 .login{
     margin-top: auto;
     margin-bottom: auto;   
 }

</style>