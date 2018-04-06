<template>
<div id="main_block">
  <div class="text_block">
    <button class="create_button" onclick="">Добавить статью</button>
    <h3>Catalog of articles: all articles (or tag name here)</h3>
    <hr>
    <div class="row">
      <div class="column">
        <h4>Article 1 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 2 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 3 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 4 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 5 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 6 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 7 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 8 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 9 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 10 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
        <h4>Article 11 (link)</h4>
        <p>Article description article description article description article description article description article description article description article description.</p>
      </div>
      <div class="small_column">
        <p>#tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag #tag </p>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'CatalogPage'
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
  margin-top: 30px;
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
