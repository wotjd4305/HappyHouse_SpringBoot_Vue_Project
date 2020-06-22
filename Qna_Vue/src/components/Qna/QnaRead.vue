<template>
    <div>
        <h2 class="text-center">QnA 게시판</h2>
        <table class="table table-bordered table-condensed">
            <tr>
                <th>번호</th>
                <td>{{board.qna_no}}</td>
            </tr>
            <tr>
                <th>글쓴이</th>
                <td>{{board.qna_userid}}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>{{board.qna_title}}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>{{board.qna_content}}</td>
            </tr>
            <tr>
                <th>날짜</th>
                <td>{{board.qna_datetime}}</td>
            </tr>
        </table>
        <div class="text-right">
            <button class="btn btn-primary" @click="dataDelete">삭제</button>
            <router-link :to="'/qnamodify/' + board.qna_no"><button class="btn btn-primary">수정</button></router-link>
            <router-link to="/qnalist"><button class="btn btn-primary">목록</button></router-link>
        </div>
        <br>
        <div class="text-center">
            <input v-model="contents" class="form-control" placeholder="댓글 남기세요 ^-^" type="text">
            <br>
            <button class="btn btn-primary" @click="comentAdd">댓글 남기기</button>
        </div>

        <div v-if="commentArr.length">
            <table class="table table-bordered">
            <colgroup>
                    <col width="20%" />
                    <col width="70%" />
                </colgroup>
                  <tr>
                    <th>댓글번호</th>
                    <!--<th>작성자</th>-->
                    <th>내  용</th>
                    <th>작 성 자</th>
                </tr>
                <tr v-for="(comment, index) in commentArr" :key="index + '_items'"><!--v-for-->
                    <td>{{comment.no}} </td>
                    <!--<td>{{comment.writer}}</td>-->
                    <td>{{comment.contents}}</td>
                    <td>{{comment.writer}}</td>
                </tr>
            </table>
        </div>
        <div v-else>
            답글이 없습니다.
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name:"QnaRead"
    , data:function(){
        return{
            no:0
            , board:{}
            , commentArr:[]
            , contents:""
            , boardNo :""
            , writer : ""
            , user:[]
        }
    }//data
    , created(){
        this.no = this.$route.params.no;
        this.user = this.$session.get("userinfo");
        this.commentArr = []
        axios.get('http://localhost:9999/vue/api/qna/'+this.no)
        .then((response) => {this.board = response.data;})
        .catch((error) => {});

        axios.get('http://localhost:9999/vue/api/qna/comment/'+this.no)
        .then((response)=>{this.commentArr = response.data;})
        .catch((error)=>{});


    }//created
    , methods:{
        dataDelete(){
            axios.delete('http://localhost:9999/vue/api/qna/'+this.no)
            .then(() => {alert('삭제가 완료되었습니다.');
                         this.$router.push("/qnalist");})
            .catch((error)=>{});
        }//search
        ,
          comentAdd(){
            axios.post('http://localhost:9999/vue/api/qna/comment/'
                        ,{boardNo : this.no, contents: this.contents, no: 12, writer: this.user.id})
            .then(() => {alert('댓글 작성이 완료되었습니다.');
                         axios.get('http://localhost:9999/vue/api/qna/comment/'+this.no)
                         .then((response) => {this.commentArr = response.data;})
                         .catch((error) => {});
                        })
            .catch((error)=>{});
        }//search
    }//methods
}
</script>

<style>

</style>