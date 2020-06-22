<template>
  <div class="container" align="center">
	
	<div class="col-lg-6" align="center">
			<div class="form-group" align="left">
				<div class="form-row"><div class="name">PASSWORD</div></div>
				<input type="password" class="form-control" id="pass" name="user_pw" placeholder="" v-model="pass">
			</div>
			<div class="form-group" align="left">
				<div class="form-row"><div class="name">NAME</div></div>
				<input type="text" class="form-control" id="name" name="user_name" placeholder="" v-model="name">
			</div>
			<div class="form-group" align="left">
				<div class="form-row"><div class="name">ADDRESS</div></div>
				<input type="text" class="form-control" id="adrress" name="user_address" placeholder="" v-model="address">
			</div>
			<div class="form-group" align="left">
				<div class="form-row"><div class="name">PHONE</div></div>
				<input type="text" class="form-control" id="user_phoneNumber" name="user_phoneNumber" placeholder="" v-model="phonenum">
			</div>
			
			<div class="form-group" align="center">
				<button class="btn btn-warning btn-text-white" @click="dataCheck" >수정하기</button>
			</div>
	</div>
</div>
</template>

<script>
import axios from 'axios';
export default {
    name:"MemberModify"
    , data:function(){
        return{
            id:""
			, pass:""
			, name:""
			, address:""
			, phonenum:""
			
        }
	}//data
	,
	 created(){
	
	 this.id = this.$session.get("userinfo").id;
	
	}//created
	
    , methods:{
        dataCheck() {
            let err = false;
            let msg = '';
            !this.pass && (msg = '비밀번호 입력해주세요', err = true);
			!err && !this.name && (msg = '이름을 입력해주세요', err = true);
			!err && !this.address && (msg = '주소를 입력해주세요', err = true);
			!err && !this.phonenum && (msg = '번호를 입력해주세요', err = true);
            if (err) alert(msg);
            else this.dataSend();
        }//dataCheck
        , dataSend() {
            axios.put('http://localhost:9999/vue/api/member'
						, {id: this.id, pass: this.pass, name: this.name,
						 address: this.address,
						 phonenum: this.phonenum})
			.then((res) => {alert('수정이 완료되었습니다.');
                        this.$router.push("/dummy");})
            .catch((error)=>{alert("서버 오류")});
        }//dataSend
    }//methods
}
</script>

<style >

</style>