<template>
    <div class='container'>
        <h1>{{data.name}}</h1>
    </div>
</template>

<script>
export default {
    name: 'Page', 
    props: {
        data: Object
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