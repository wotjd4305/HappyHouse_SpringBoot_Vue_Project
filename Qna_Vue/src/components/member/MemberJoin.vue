<template>
  
<div class="container" align="center">
		<div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Registration Form</h2>
                </div>
                <div class="card-body">
			
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="input--style-5" id="user_id" name="user_id" placeholder="" v-model="id">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="input--style-5" id="user_pw" name="user_pw" placeholder="" v-model="pass">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호재입력</label>
				<input type="password" class="input--style-5" id="passcheck" name="passcheck" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="input--style-5" id="user_name" name="user_name" placeholder="" v-model="name">
			</div>
			<div class="form-group" align="left">
				<label for="name">주소</label>
				<input type="text" class="input--style-5" id="user_address" name="user_address" placeholder="" v-model="address">
			</div>
			<div class="form-group" align="left">
				<label for="name">전화번호</label>
				<input type="text" class="input--style-5" id="user_phoneNumber" name="user_phoneNumber" placeholder="010-xxxx-xxxx" v-model="phonenum">
			</div>
			<div class="form-group col-6" align="center">
				<input @click="dataCheck" class="btn btn--red btn-text-white" value="가 입">
			</div>
    </div>
	</div>
</div>
</template>

<script>
import axios from 'axios';
export default {
    name:"MemberJoin"
    , data:function(){
        return{
            id:""
			, pass:""
			, name:""
			, address:""
			, phonenum:""
        }
    }//data
    , methods:{
        dataCheck() {
            let err = false;
            let msg = '';
            !this.id && (msg = '아이디를 입력해주세요', err = true);
			!err && !this.pass && (msg = '비밀번호 입력해주세요', err = true);
			!err && !this.name && (msg = '이름을 입력해주세요', err = true);
			!err && !this.address && (msg = '주소를 입력해주세요', err = true);
			!err && !this.phonenum && (msg = '폰번호 입력해주세요', err = true);
			
            if (err) alert(msg);
            else this.dataSend();
        }//dataCheck
        , dataSend() {
            axios.post('http://localhost:9999/vue/api/member/'
						, {id: this.id, pass: this.pass,
						name: this.name, address:this.address, phonenum:this.phonenum})
			.then((res) => {alert('회원가입이 완료되었습니다.');;
                        this.$router.push("/dummy");})
            .catch((error)=>{alert("오류")});
        }//dataSend
    }//methods
}
</script>

<style>

</style>