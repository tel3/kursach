<template>
  <div id="main_block">
    <div class="text_block">
      <h3>Недавно добавленные статьи</h3>
      <hr>
      <template v-for="item in items">
        <h4>{{ item.name }}</h4>
        <h5><router-link :to="'/article/' + item.id">Читать статью</router-link></h5>
      </template>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'MainPage',
  data: function () {
		return {
      items: [],
      content: "",
      articles: [],
      contents: []
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
          itemsNew.push({id: i + 1, name: articlesNew[i].name, content: contentNew})
        }
        this.items = itemsNew.reverse().slice(0, 5);
        console.log(this.items);
      })
      .catch(e => {
				console.log(e)
			})
    },
    
  },
  mounted () {
    this.getPageContent();

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
}

.text_block {
  margin: auto;
  margin-top: 5px;
  display: inline-block;
  width: 464px;
  background-color: #202020;
  color: white;
  padding-left: 10px;
  padding-right: 10px;
  position: center;
}

@media screen and (max-width: 671px) {
  #main_block {
    width: 40%;
  }

  .text_block {
    padding-left: 2%;
    padding-right: 2%;
    width: 96%;
    position: relative;
    margin-bottom: 1px;
  }

  #left {
    margin-right: 0px;
  }

}

</style>
