<template>
  <div id="main_block">
    <div class="text_block" id="left">
      <h4>Войти:</h4>
        <form>
          <input type="text" class="sign_form" id="username_in" placeholder="Введите логин"> <br>
          <input type="password" class="sign_form" id="password_in" placeholder="Введите пароль"> <br>
        </form>
        <button class="sign_button" name="sign_in" v-on:click="loginButton">Войти</button>
      </div>
      <div class="text_block">
        <h4>Зарегистрироваться:</h4>
        <form>
          <input type="text" class="sign_form" id="username_up" placeholder="Введите действительный адрес электронной почты"> <br>
          <input type="password" class="sign_form" id="password_up" placeholder="Введите свой пароль"> <br>
          <input type="password" class="sign_form" id="password_up_confirm" placeholder="Введите пароль повторно"> <br>
        </form>
        <button class="sign_button" name="sign_in" v-on:click="registerButton">Зарегистрироваться</button>
      </div>
  </div>
</template>

<script>
import axios from 'axios'
import { login } from '../utils/auth.js'

export default {
  name: 'LoginPage',
  methods: {
    loginButton: function () {
      const user_login = document.getElementById("username_in").value;
      const user_password = document.getElementById("password_in").value;
      // login(user_login, user_password);
      if (user_login != localStorage.getItem('login') || user_password != localStorage.getItem('password')) {
        alert ("Неверный логин или пароль")
      }
      else {
        localStorage.setItem('logged_in', true);
        localStorage.setItem('status', 'user')
        this.$router.push('/');
      }
    },
    registerButton: function () {
      const user_login = document.getElementById("username_up").value;
      const user_password = document.getElementById("password_up").value;
      const user_password_confirm = document.getElementById("password_up_confirm").value;
      if (user_password != user_password_confirm) {
        alert ("Пароли не совпадают!")
      }
      else {
        localStorage.setItem('login', user_login);
        localStorage.setItem('password', user_password);
        this.$router.push('/');
      }
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

#top_bar {
  margin: auto;
  margin-top: 50px;
    width: 974px;
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
  width: 424px;
  background-color: #202020;
  color: white;
  height: 280px;
  padding-left: 50px;
  padding-top: 20px;
  padding-right: 10px;
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

.sign_form {
  margin-bottom: 12px;
  width: 350px;
  height: 25px;
  border-radius: 4px;
}

.sign_button {
  width: 160px;
  height: 25px;
  border-radius: 4px;
}

@media screen and (max-width: 671px) {
  #main_block {
    width: 80%;
  }

  .text_block {
    padding-left: 2%;
    padding-right: 2%;
    width: 96%;
    float: none;
    position: relative;
    margin-bottom: 1px;
  }

  #top_bar {
    width: 80%;
    overflow: auto;
  }

  .button {
    margin-bottom: 1px;
    width: 100%;
    display: inline;

  }

  #left {
    margin-right: 0px;
  }
}
</style>
