<template>
    <div class='container'>
        <h1>{{data.name}}</h1>
        <li v-for="(item) in repos" :key="item.name">
            <a v-on:click="onRepoSelect(item.name)">{{ item.name }}</a>
        </li>
    </div>
</template>

<script>
export default {
    name: 'Sidebar', 
    props: {
        data: Object
    },
    data() {
        return {
            repos: [],
        }
    },
    methods: {
        onRepoSelect(value) {
            this.$emit('selectedGhRepo', value)
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
    width: 20%;
    height: 800px;
    float: left;
    text-align: left;
    padding: 20px;
}
</style>