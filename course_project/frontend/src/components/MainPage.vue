<template>
  <div id="main_block">
    <top-button-component
      v-bind:status="false"
      role="guest"
    ></top-button-component>
    <div class="text_block" id="left">
      <h3>Недавно добавленные статьи</h3>
      <hr>
      <h4>Article 1</h4>
      <p>This article doesn't really explain a fuck yet is completely filled with author's miserable jokes and memes and is mostly aimed at compensating absense of his social life and rising his own self-conceit by imitating a sence of usefulness and belonging.</p>
      <hr>
      <h4>Article 2</h4>
      <p>This article doesn't really explain a fuck yet is completely filled with author's miserable jokes and memes and is mostly aimed at compensating absense of his social life and rising his own self-conceit by imitating a sence of usefulness and belonging.</p>
      <hr>
      <h4>Article 3</h4>
      <p>This article doesn't really explain a fuck yet is completely filled with author's miserable jokes and memes and is mostly aimed at compensating absense of his social life and rising his own self-conceit by imitating a sence of usefulness and belonging.</p>
      <hr>
      <h4>Article 4</h4>
      <p>This article doesn't really explain a fuck yet is completely filled with author's miserable jokes and memes and is mostly aimed at compensating absense of his social life and rising his own self-conceit by imitating a sence of usefulness and belonging.</p>
    </div>
    <div class="text_block">
      <h3>Топ-5 лучших статей</h3>
      <hr>
      <h4>Article 1</h4>
      <p>This article doesn't really explain a fuck yet is completely filled with author's miserable jokes and memes and is mostly aimed at compensating absense of his social life and rising his own self-conceit by imitating a sence of usefulness and belonging.</p>
      <hr>
      <h4>Article 2</h4>
      <p>This article doesn't really explain a fuck yet is completely filled with author's miserable jokes and memes and is mostly aimed at compensating absense of his social life and rising his own self-conceit by imitating a sence of usefulness and belonging.</p>
      <hr>
      <h4>Article 3</h4>
      <p>This article doesn't really explain a fuck yet is completely filled with author's miserable jokes and memes and is mostly aimed at compensating absense of his social life and rising his own self-conceit by imitating a sence of usefulness and belonging.</p>
      <hr>
      <h4>Article 4</h4>
      <p>This article doesn't really explain a fuck yet is completely filled with author's miserable jokes and memes and is mostly aimed at compensating absense of his social life and rising his own self-conceit by imitating a sence of usefulness and belonging.</p>
    </div>
  </div>
</template>

<script>
import TopButtonComponent from './elements/TopButtonComponent'

export default {
  name: 'HelloWorld',
  components: {
    'top-button-component': TopButtonComponent
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
  float: left;
  display: inline-block;
  width: 464px;
  background-color: #202020;
  color: white;
  padding-left: 10px;
  padding-right: 10px;
}

#left {
  margin-right: 4px;
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

  #left {
    margin-right: 0px;
  }

}

</style>
