<template>
  <div id="main_block">
    <div class="text_block">
      <h4>Создать статью:</h4>
      <form>
        <input type="text" class="name_form" id="article_name" placeholder="Введите название статьи"> <br>
        <input type="text" class="name_form" id="tag" placeholder="Введите тег для статьи"> <br>
        <input type="text" class="name_form" id="author" placeholder="Введите автора статьи"> <br>
        <textarea id="text_area" class="article_form" placeholder="Текст статьи" rows="20"></textarea><br>
      </form>
      <button class="submit_button" v-on:click="sendData">Отправить статью</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
/* eslint-disable */
export default {
  name: 'EditPage',
  methods: {
    sendData: function () {
      let formData = new FormData();
      const data = document.getElementById("text_area").value;
      const name = document.getElementById("article_name").value;
      const author = document.getElementById("author").value;
      const tag = document.getElementById("tag").value;;
      formData.append("file", data);
      formData.append("name", name);
      formData.append("author", author);
      formData.append("tag", tag);
      axios.post("/api/article/upload_article", formData)
        .then(function (response) {
          console.log(response);
          this.redirectOnSuccess();
        })
        .catch(function (error) {
          console.log(error);
          this.redirectOnError();
        }); 
      },  
    redirectOnError: function () {
      alert("Ошибка при загрузке статьи!")
    },
    redirectOnSuccess: function () {
      alert("Статья успешно загружена на сервер!")
    }  
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  font-size: 20pt;
}

h4 {
  font-size: 16pt;
}

#main_block {
  margin: auto;
  margin-top: 5px;
  width: 972px;
  margin-bottom: 150px;
  overflow: auto;
}

.text_block {
  float: left;
  display: inline-block;
  width: 892px;
  background-color: #202020;
  color: white;
  padding-left: 40px;
  padding-top: 20px;
  padding-right: 40px;
  overflow: auto;
}

#left {
  margin-right: 4px;
}

.button {
  width: 240px;
  height: 50px;
  background-color: #303030;
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius: 4px;
}

.button:hover {
  background-color: #444444;
}

.button:active {
  background-color: #303030;
}

.name_form {
  margin-bottom: 12px;
  width: 350px;
  height: 25px;
  border-radius: 4px;
}

.submit_button {
  width: 160px;
  height: 25px;
  border-radius: 4px;
  margin-top: 7px;
  margin-bottom: 10px;
}

.article_form {
  resize: none;
  width: 95%;
}

@media screen and (max-width: 671px) {
  #main_block {
    width: 80%;
  }

  .name_form {
    margin-bottom: 12px;
    width: 95%;
    height: 25px;
    border-radius: 4px;
  }

  .text_block {
    padding-left: 2%;
    padding-right: 2%;
    width: 96%;
    float: none;
    position: relative;
    margin-bottom: 1px;
  }

  .button {
    margin-bottom: 1px;
    width: 100%;
  }

  #left {
    margin-right: 0px;
  }

}
</style>
