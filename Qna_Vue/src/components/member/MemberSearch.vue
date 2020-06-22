<template>
<div align="center">
  	<!--<c:if test="${userid != null && userid != ''}">
		${userid}님 반갑습니다.
	</c:if>-->
<h1> 나의 정보 </h1>
	<table class="table table-bordered table-condensed">
		  <colgroup>
                    <col width="20%" />
                    <col width="10%" />
                    <col width="40%" />
                    <col width="30%" />
        </colgroup>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>주소</th>
				<th>핸드폰 번호</th>
				
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>{{this.user.id}}</td>
					<td>{{this.user.name}}</td>
					<td>{{this.user.address}}</td>
					<td>{{this.user.phonenum}}</td>
				</tr>
		</tbody>
	</table>
	<br><br>
    </div>
</template>

<script>

import axios from 'axios';
export default {
    name:"MemberSearch"
    , data:function(){
        return{
			user:[],
			id:""
        }
    }//data
    , created(){
     	this.id = this.$session.get("userinfo").id;
        axios.get('http://localhost:9999/vue/api/member/'+this.id)
        .then((response) => {this.user = response.data;})
        .catch((error) => {});


    }//created
}
</script>

<style>

</style>