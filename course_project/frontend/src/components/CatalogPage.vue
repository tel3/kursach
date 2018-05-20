<template>
<div id="main_block">
  <div class="text_block">
    <router-link to="/edit/">
      <button class="create_button">Добавить статью</button>
    </router-link>
    <h3>Catalog of articles: {{ currentTag }}</h3>
    <hr>
    <div class="row">
      <div class="column">
        <template v-for="item in filteredArticles">
          <h4><router-link :to="'/article/' + item.id">{{ item.name }}</router-link></h4>
        </template>
      </div>
      <div class="small_column">
        <h5>Теги:</h5>
        <a href="#" v-on:click="currentTag = 'All'">Все статьи</a>
        <li v-for="tag in tags">
          <a href="#" v-on:click="changeCurrentTag(tag)">{{ tag }}</a>
        </li>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import axios from 'axios'
/* eslint-disable */
export default {
  name: 'CatalogPage',
  data: function () {
    return {
      items: [],
      tags: [],
      currentTag: 'All'
    }  
  },
  methods: {
    getPageContent: function () {
			axios.get('/api/articles/')
			.then(response => {
        console.log(response.data._embedded.articles);
        let articlesNew = response.data._embedded.articles;
        let itemsNew = [];
        for (let i=0; i<articlesNew.length; i++) {
          let contentNew = decodeURIComponent(atob(articlesNew[i].content).split('').map(function(c) {
					return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    		}).join(''));
          itemsNew.push({id: i + 1, name: articlesNew[i].name, content: contentNew, tag: articlesNew[i].tag})
        }
        this.items = itemsNew.reverse();
        console.log(this.items);
      })
      .catch(e => {
				console.log(e)
			})
    },
    getTagsList: function () {
      axios.get('/api/tags/')
      .then(response => {
        console.log(response);
        this.tags = response.data;
      })
      .catch(e => {
				console.log(e)
			})
    },
    changeCurrentTag: function (tag) {
      this.currentTag = tag
    }
  },
  computed: {
    filteredArticles: function () {
      return this.items.filter((item) => {
        if (item.tag == this.currentTag || this.currentTag == 'All') {
          return true
        }
      })
    }
  },
  mounted () {
    this.getPageContent();
    this.getTagsList();
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
  overflow: auto;
  margin-bottom: 150px;
}

.text_block {
  float: left;
  width: 962px;
  background-color: #202020;
  color: white;
  padding-left: 10px;
  padding-right: 0px;
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

.create_button {
  float: right;
  margin: 20px 20px 0px 20px;
  height: 40px;
  font-size: 12pt;
  background-color: #404040;
  border: none;
  color: white;
  border-radius: 6px;
  width: 200px;
}

.button:hover, .create_button:hover {
  background-color: #444444;
}

.button:active, .create_button:active {
  background-color: #303030;
}

.row {
  display: flex;
}

.column {
    flex: 80%;
    padding: 10px;
}

.small_column {
  flex: 20%;
  background-color: #303030;
  padding-left: 10px;
  padding-bottom: 15px;
  margin-top: 30px;
  margin-bottom: 40px;
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
