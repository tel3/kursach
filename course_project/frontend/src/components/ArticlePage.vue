<template>
  <div id="main_block">
    <div class="text_block" id="text_field">
      <h3>Article title</h3>
      <p>Here lies text of this article, as ruthless as it is pointless. Here lies text of this article, as ruthless as it is pointless. Here lies text of this article, as ruthless as it is pointless. Here lies text of this article, as ruthless as it is pointless. Here lies text of this article, as ruthless as it is pointless.</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <p>Here lies text of this article, as ruthless as it is pointless.</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <p>Here lies text of this article, as ruthless as it is pointless.</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <p>Here lies text of this article, as ruthless as it is pointless.</p>
      <p>COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL! COPYPASTE SHALL PREVAIL!</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <p>Here lies text of this article, as ruthless as it is pointless.</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <p>Here lies text of this article, as ruthless as it is pointless.</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <p>Here lies text of this article, as ruthless as it is pointless.</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <p>Here lies text of this article, as ruthless as it is pointless.</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <p>Here lies text of this article, as ruthless as it is pointless.</p>
      <p>No hints shell be given, no help shall be given. This text bares no sence whatsoever.</p>
      <button class="font_button">Like article</button>
      <button class="font_button">Edit article</button>
      <button class="font_button">Delete article</button>
    </div>  
    <div class="comments" id="comments_field">
      <h3>Comments:</h3>
      <hr>
      <h5>СОМЯАДЕ TEL3 <span>07-03-2018</span></h5>
      <p>Лёня хуй</p>
      <p>-delete- -edit- (для одменов)</p>
      <hr>
      <h5>Axis <span>07-03-2018</span></h5>
      <p>Полностью поддерживаю предыдущего комментатора</p>
      <p>-delete- -edit- (для одменов)</p>
      <hr>
      <h5>Fairy <span>07-03-2018</span></h5>
      <p>Харе хернёй страдать курсач делайте блять (((((((((0000000</p>
      <p>-delete- -edit- (для одменов)</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ArticlePage'
}
</script>

<style scoped>
h3 {
	font-size: 20pt;
}

h4 {
	font-size: 16pt;
}

h5 {
	font-size: 14pt;
	margin-bottom: 10px;
}

#main_block {
	margin: auto;
	margin-top: 5px;
	width: 972px;
	height: auto;
	padding-bottom: 150px;
}

.text_block {
	width: 892px;
	background-color: #202020;
	color: white;
	padding-top: 5px;
	padding-left: 40px;
	padding-right: 40px;
	margin-bottom: 15px;
	overflow: auto;
	padding-bottom: 10px;
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

.button:hover, .font_button:hover {
	background-color: #444444;
}

.button:active, .font_button:active {
	background-color: #303030;
}

.font_button {
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

.comments {
	margin: auto;
	width: 892px;
	border: none;
	background-color: #202020;
	color: white;
	margin-top: 20px;
	padding-top: 5px;
	padding-left: 40px;
	padding-right: 40px;
	padding-bottom: 30px;
}

.comments p {
	margin-left: 10px;
}

h5 span {
	font-size: 10pt;
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

	.comments {
		padding-left: 2%;
		padding-right: 2%;
		width: 96%;
	}
}
</style>
