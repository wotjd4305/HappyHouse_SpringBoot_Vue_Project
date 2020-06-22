<template>
<div class="container" align="center">
	<br><br>
  	<!--<c:if test="${userid != null && userid != ''}">
		${userid}님 반갑습니다.
	</c:if>-->
<div class="card card-5">
	<div class="card-heading">
                    <h2 class="title">Delete User</h2>
                </div>
<h1>삭제시, 복구할 수 없습니다.</h1>
	<table border="0">
		<div align="center">
		<thead>
			<tr >
				<th colspan="2">정말로 삭제하시겠습니까?</th>
			</tr>
		</thead>
		</div>
		<div class="form-group" align="center">
		<tbody>
			<tr>
				<td>
				<button @click="deleteMember" class="btn-text-white btn btn--red"> 예 </button>
				</td>
				<td>
				<router-link to="/dummy"><button class="btn-text-white btn btn-primary">아니요</button></router-link>
				</td>
			</tr>
		</tbody>
		</div>
	</table>
	<br><br>
		</div>
    </div>
</template>

<script>
import axios from 'axios';

export default{
name : 'MemberDelete',
components: {
  },
	data:function(){
        return {
			delete_id : ""
        }
    },

  created(){
	 this.delete_id = this.$session.get("userinfo");
	}//created
	,
 methods:{
 	deleteMember() {
		
	
		axios.delete('http://localhost:9999/vue/api/member/' +this.delete_id.id)
			.then((res) => {
						this.$router.push("/result");
						})
            .catch((error)=>{alert("서버오류, 다시 시도하세요.")});
			
        }//dataCheck
	}

}	

</script>

<style>

</style>