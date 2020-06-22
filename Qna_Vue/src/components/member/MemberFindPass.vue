<template>
  
<div class="container" align="center">
		<div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Find Password</h2>
                </div>
                <div class="card-body">
			
			<div class="form-group" align="left">
					<div class="form-row"><div class="name">아이디</div></div>
				<input type="text" class="input--style-5" id="id" name="user_id" placeholder="" v-model="inId">
			</div>
			<div class="form-group" align="left">
				<div class="form-row"><div class="name">이름</div></div>
				<input type="text" class="input--style-5" id="name" name="user_name" placeholder="" v-model="inName">
			</div>
			<div class="form-group" align="left">
					<div class="form-row"><div class="name">주소</div></div>
				<input type="text" class="input--style-5" id="adrress" name="user_address" placeholder="" v-model="inAddress">
			</div>
			<div class="form-group" align="center">
				<input @click="dataCheck" class="btn btn-warning btn-text-white col-3" value="찾 기">
			</div>
	</div>
</div>
</div>
</template>

<script>
import axios from 'axios';
export default {
    name:"MemberFindPass"
    , data:function(){
        return{
	
        }
    }//data
    , created(){
       
    }//created
    , methods:{
        dataCheck() {
            let err = false;
            let msg = '';
            !this.inId && (msg = '아이디를 입력해주세요', err = true);
            !err && !this.inName && (msg = '이름 입력해주세요', err = true);
            !err && !this.inAddress && (msg = '주소 입력해주세요', err = true);
            if (err) alert(msg);
            else this.dataSend();
        }//dataCheck
        , dataSend() {
			axios.post('http://localhost:9999/vue/api/member/findPass'
						, {id: this.inId, name: this.inName, address: this.inAddress})
            .then((res) => {alert(this.inName +"님의 비밀번호는 " + res.data.pass);
                        this.$router.push({path : '/dummy'})})
			.catch((error)=>{alert("존재하지 않음")});

        }//dataSend
    }//methods
}
</script>

<style>

</style>