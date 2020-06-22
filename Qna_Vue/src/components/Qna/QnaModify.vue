<template>
    <div>
        <h2 class="text-center">QnA 게시판</h2>
        <div class="form-group">
            <label for="writer">작성자</label>
            <input type="text" class="form-control" id="writer" placeholder="작성자를 입력하세요" v-model="board.qna_userid">
        </div>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요" v-model="board.qna_title">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea type="text" class="form-control" id="contnet" placeholder="내용을 입력하세요" v-model="board.qna_content"></textarea>
        </div>
        <div class="text-right">
            <button class="btn btn-primary" @click="dataCheck">수정</button>
            <router-link to="/qnalist"><button class="btn btn-primary">목록</button></router-link>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name:"QnaModify"
    , data:function(){
        return{
            no:0
            , board:{}
        }
    }//data
    , created(){
        this.no = this.$route.params.no;
        axios.get('http://localhost:9999/vue/api/qna/'+this.no)
        .then((response) => {this.board = response.data;})
        .catch((error) => {});
    }//created
    , methods:{
        dataCheck() {
            let err = false;
            let msg = '';
            !this.board.qna_userid && (msg = '작성자를 입력해주세요', err = true);
            !err && !this.board.qna_title && (msg = '제목 입력해주세요', err = true);
            !err && !this.board.qna_content && (msg = '내용 입력해주세요', err = true);
            if (err) alert(msg);
            else this.dataSend();
        }//dataCheck
        , dataSend() {
            axios.put('http://localhost:9999/vue/api/qna/'+this.no
                        , {qna_no: this.board.qna_no, qna_userid: this.board.qna_userid
                            , qna_title: this.board.qna_title, qna_content: this.board.qna_content})
            .then(() => {alert('수정이 완료되었습니다.');
                        this.$router.push({path : '/qnalist'})})
            .catch((error)=>{});
        }//dataSend
    }//methods
}
</script>

<style>

</style>