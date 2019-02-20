<template> 
    <div>
        <NavHeader v-on:ghUsernameInput="onUsernameInput"/>
        <Page :data="data"/>
    </div>
</template>

<script>
import NavHeader from './TopHeader.vue'
import Page from './Page.vue'

export default {
  name: 'Main',
  props: {
    msg: String
  },
  components: {
      NavHeader,
      Page
  },
  data() {
      return {
          data: {
              name: 'test',
          }
      }
  },
  methods : {
      onUsernameInput(value) {
          this.data.name = value
      }
  }
}
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>