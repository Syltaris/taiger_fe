<template>
    <div class='container'>
        <h1>{{data.name}}</h1>
        <li v-for="(item, index) in repos" :key="item.name">
            {{ index }} - {{ item.name }}
        </li>
    </div>
</template>

<script>
export default {
    name: 'Page', 
    props: {
        data: Object
    },
    data() {
        return {
            repos: [],
        }
    },
    methods: {
        fetchGhDetails() {
            fetch(`https://api.github.com/${this.data.name}`)
            .then(res => this.body = res.body)
        }
    },
    watch: {
        data: {
            immediate: true,
            deep: true,
            handler: function(newVal) { // watch it
                this.data = newVal
                fetch(`https://api.github.com/users/${this.data.name}/repos`)
                .then(res => res.json())
                .then(json => this.repos = json)
            }
        }
    }
}
</script>

<style scoped>
.container {
    border: 1px solid black;
    width: 80%;
    height: 800px;
}
</style>