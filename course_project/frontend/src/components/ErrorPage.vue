<template>
<div id="main_block">
</div>
</template>

<script>
export default {
  name: 'ErrorPage'
}
</script>

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

select {
  margin-bottom: 10px;
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
