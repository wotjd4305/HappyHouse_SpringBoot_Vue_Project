<template>
	<div class="container" align="center">
	  <div class="col-lg-8" align="center">
	  <h2>매매 목록</h2>
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="center">
		  	  <select class="form-control" name="key" id="key" v-model="key">
			    <option value="dong" selected="selected">동별 매매</option>
			    <option value="apt">아파트별 매매</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력." name="word" id="word" v-model="word">
			  <button class="btn btn-primary" @click="dataSend">검색</button>
		
			</td>
	  	</tr>
	  </table>
	  </div>
	
	  
<!-- <c:if test="${listinfo.size() != 0}"> -->
<div v-if="DealArray.length">
	<div style="width:100%; height:500px; overflow:auto">
 	<table class="table" id="tableList">
 		<thead>
		  <tr>
			  <th>건물명</th>
			  <th>가격</th>
			  <th>동</th>
		  </tr>
	  	</thead>
	    <tbody>
	  		

 				<tr v-for="(house, index) in DealArray" :key="index + '_items'"><!--v-for-->
                    <td><router-link :to="'houseDealDetail/' + house.no">{{house.aptName}}</router-link></td>
                   	<td>{{house.dealAmount}}</td>
                    <td>{{house.dong}}</td>
                </tr>

	    </tbody>
	  </table>
	</div>
</div>
<div v-else>
<!-- </c:if> -->
    
	  <!-- <c:if test="${listinfo.size() == 0}"> -->
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info" align="center">
	        <td>등록된 매물이 없습니다.</td>
	      </tr>
	    </tbody>
	  </table>
	  <!-- </c:if> -->
	  
</div>
</div>
</template>

<script>
import axios from 'axios';
export default {
    name:"HouseDealSearch"
    , data:function(){
        return {
			DealArray:[],
			key:"",
			word:""
        }
    }//data
    , created(){
        axios.get('http://localhost:9999/vue/api/house/' + this.key +"/" + this.word)
        .then((response)=>{this.DealArray = response.data;})
        .catch((error)=>{});

	},
	methods:{
        dataSend(){
             axios.get('http://localhost:9999/vue/api/house/' + this.key +"/" + this.word)
        	.then((response)=>{this.DealArray = response.data;})
        	.catch((error)=>{});
		}//search
		
    }//methods
}//export default
</script>

<style>

</style>