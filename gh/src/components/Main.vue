<template> 
    <div>
        <NavHeader v-on:ghUsernameInput="onUsernameInput"/>
        <Sidebar :data="data" v-on:selectedGhRepo="onRepoSelect"/>
        <Page :data="data"/>
    </div>
</template>

<script>
import NavHeader from './TopHeader.vue'
import Sidebar from './Sidebar.vue'
import Page from './Page.vue'

export default {
  name: 'Main',
  components: {
      NavHeader,
      Sidebar,
      Page
  },
  data() {
      return {
          data: {
              name: 'test',
              repoName: '',
          },
      }
  },
  methods : {
      onUsernameInput(value) {
        this.data.name = value
      },
      onRepoSelect(value) {
        this.data.repoName = value
      },
  },
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