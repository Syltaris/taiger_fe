<template>
    <div class='container'>
        <VueMarkdown v-if="body" :source="body"/>
    </div>
</template>

<script>
import VueMarkdown from 'vue-markdown'

export default {
    name: 'Page', 
    components: {
        VueMarkdown
    },
    props: {
        data: Object
    },
    data() {
        return{
            readmeUrl: '',
            body: '#### test '
        }
    },
    methods: {
        fetchReadme(data) {
            fetch(`https://api.github.com/repos/${data.name}/${data.repoName}/readme`)
            .then(res => res.json())
            .then(json => {
                this.readmeUrl = json.download_url
                fetch(this.readmeUrl)
                .then(res => res.text())
                .then(text => this.body = text)
            })
        },
    },
    watch: {
        data: {
            immediate: true,
            deep: true,
            handler: function(newVal) { // watch it
                this.data = newVal
                if(this.data.repoName === undefined || this.data.repoName.length <= 0) {return}
                this.fetchReadme(this.data)
            }
        }
    }
}
</script>

<style scoped>
.container {
    border: 1px solid black;
    width: 75%;
    height: 100%;
    float: left;
    text-align: left;
    padding-left: 5px;
}
</style>