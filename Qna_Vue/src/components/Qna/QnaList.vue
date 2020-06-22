<template>
    <div>
        <h2 class="text-center">QnA 게시판</h2>
        <div v-if="boardArr.length"><!--v-if-->
            <table class="table table-bordered table-condensed">
                <colgroup>
                    <col width="10%" />
                    <col width="50%" />
                    <col width="15%" />
                    <col width="25%" />
                </colgroup>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>날짜</th>
                </tr>
                <tr v-for="(board, index) in boardArr" :key="index + '_items'"><!--v-for-->
                    <td>{{board.qna_no}}</td>
                    <td><router-link :to="'qnaread/' + board.qna_no">{{board.qna_title}}</router-link></td>
                    <td>{{board.qna_userid}}</td>
                    <td>{{board.qna_datetime}}</td>
                </tr>
            </table>
        </div>
        <div v-else>
            게시글이 없습니다.
        </div>
        <div class="text-right">
            <router-link to="/qnawrite"><button class="btn btn-primary">등록</button></router-link>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name:"QnaList"
    , data:function(){
        return {
            boardArr:[]
        }
    }//data
    , created(){
        axios.get('http://localhost:9999/vue/api/qna/')
        .then((response)=>{this.boardArr = response.data;})
        .catch((error)=>{});

    }
}//export default
</script>

<style>

</style>