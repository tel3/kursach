<template>
  <div class="top_bar">
    <router-link to="/">
      <button v-bind:class="[buttonClass, currentRole == 'admin' ? adminClass : '']">Главная страница</button>
    </router-link>
    <router-link to="/catalog/">
      <button v-bind:class="[buttonClass, currentRole == 'admin' ? adminClass : '']">Каталог</button>
    </router-link>
    <router-link v-if="!currentStatus" to="/login/">
      <button v-bind:class="[buttonClass, currentRole == 'admin' ? adminClass : '']">Войти</button>
    </router-link>
    <router-link v-else to="/">
      <button v-bind:class="[buttonClass, currentRole == 'admin' ? adminClass : '']" v-on-click="logout">Выйти</button>
    </router-link>
    <router-link v-if="currentRole == 'admin'" to="/">
      <button v-bind:class="[buttonClass, adminClass]">Панель управления</button>
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'TopButtonComponent',
  props: {
    role: {
      type: String,
      required: true
    },
    status: {
      type: Boolean,
      required: true
    }
  },
  data: function () {
    return {
      currentRole: localStorage.getItem('logged_in'),
      currentStatus: localStorage.getItem('status'),
      buttonClass: 'button',
      adminClass: 'admin_button'
    }
  },
  methods: {
    logout () {
      this.currentRole = 'user'
      this.currentStatus = false
      localStorage.removeItem('logged_in')
      localStorage.removeItem('status')
    },
    makeAdmin () {
      if (this.currentRole === 'user') {
        this.currentRole = 'admin'
      }
    },
    makeUser () {
      if (this.currentRole === 'admin') {
        this.currentRole = 'user'
      }
    }
  }
}

</script>

<style scoped>
.top_bar {
  text-align: center;
  margin: auto;
  margin-top: 50px;
  width: 974px;
}

.button {
  width: 33%;
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

.admin_button {
  width: 24.6%;
}

.button:hover {
  background-color: #444444;
}

.button:active {
  background-color: #303030;
}

@media screen and (max-width: 671px) {
  .top_bar {
    width: 100%;
    overflow: auto;
  }

  .button {
    margin-bottom: 1px;
    width: 100%;
  }

  .admin_button {
    width: 100%;
  }
}
</style>
