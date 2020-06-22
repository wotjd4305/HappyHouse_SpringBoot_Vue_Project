<template>
  <div>
        <h2 class="text-center">QnA 게시판</h2>
        <div class="form-group">
            <label for="writer">작성자</label>
            <input readonly type="text" value="긴냥"  class="form-control" id="writer" placeholder="작성자를 입력하세요" v-model="qna_userid">
        </div>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요" v-model="qna_title">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea type="text" class="form-control" id="contnet" placeholder="내용을 입력하세요" v-model="qna_content"></textarea>
        </div>
        <div class="text-right">
            <button class="btn btn-primary" @click="dataCheck">등록</button>
            <router-link to="/QnaList"><button class="btn btn-primary">목록</button></router-link>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name:"QnaWrite"
    , data:function(){
        return{
            qna_userid:""
            , qna_title:""
            , qna_content:""
            , user:[]
        }
    }//data
    ,
    beforeCreate(){
    }
    ,
    created(){
        this.no = this.$route.params.no;
        this.user = this.$session.get("userinfo");   
         this.qna_userid = this.user.id;
    }//created
    ,
    methods:{
        dataCheck() {
            let err = false;
            let msg = '';
            !this.qna_userid && (msg = '작성자를 입력해주세요', err = true);
            !err && !this.qna_title && (msg = '제목 입력해주세요', err = true);
            !err && !this.qna_content && (msg = '내용 입력해주세요', err = true);
            if (err) alert(msg);
            else this.dataSend();
        }//dataCheck
        , dataSend() {
            axios.post('http://localhost:9999/vue/api/qna'
                        , {qna_userid: this.qna_userid, qna_title: this.qna_title, qna_content: this.qna_content})
            .then(() => {alert('등록이 완료되었습니다.');
                        this.$router.push("/qnalist");})
            .catch((error)=>{});
        }//dataSend
    }//methods
}
</script>

<style>

</style>