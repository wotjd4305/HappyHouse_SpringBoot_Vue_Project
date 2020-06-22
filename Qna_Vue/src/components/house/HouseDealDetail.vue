<template>
 <div class="container" align="center">
		<div class="col-md-6" align="center">
			<br>
			<table class="table table-active">
	    	<tbody>
	      		<tr class="table-info">
	        	<th> 번호 : <strong> {{detailinfo.no}} </strong></th>
	        	<th><div align="right">
	        		<button type="button" class="btn btn-primary" onclick="history.back(); return false;">뒤로</button>
	        		</div>
	        		</th>
	      		</tr>
	      		<tr>
	        	<td colspan="2">건물명 :  <strong> {{detailinfo.aptName}} </strong></td>
	     		 </tr>
	      		<tr>
	    		   <td colspan="2"> 가격 : <strong> {{detailinfo.dealAmount}} </strong></td>
	     		 </tr>
	    		  <tr>
	    	    <td colspan="2"> 동 : <strong> {{detailinfo.dong}} </strong></td>
	 		     </tr>
	 		     <tr>
	 		       <td colspan="2"> 코드 : <strong> {{detailinfo.code}} </strong></td>
	  		    </tr>
	 		     <tr>
	 	  	     <td colspan="2"> 건설년도 : <strong> {{detailinfo.buildYear}} </strong></td>
	 		     </tr>
	 		     <tr>
	  	 	     <td colspan="2"> 거래날짜 : <strong> {{detailinfo.dealYear}}년 {{detailinfo.dealMonth}}월  {{detailinfo.dealDay}}일 </strong></td>
	  		    </tr>   
	   		 </tbody>
	 		 </table>
	  </div>
	  </div>
</template>

<script>
import axios from 'axios';
export default {
    name:"HouseDetail"
    , data:function(){
        return{
            no:0
           ,detailinfo:[]
        }
    }//data
    , created(){
        this.no = this.$route.params.no;
        axios.get('http://localhost:9999/vue/api/house/'+this.no)
        .then((response) => {this.detailinfo = response.data;})
        .catch((error) => {});

    }//created
}
</script>

<style>

</style>