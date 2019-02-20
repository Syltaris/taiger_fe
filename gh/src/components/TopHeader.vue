<template>
    <div class="nav-header">
        <TextField label="Github Username: " v-on:onInputEnter="onChildInput" />
    </div>
</template>

<script>
import TextField from './TextField.vue'

export default {
    name: 'NavigationHeader',
    components: {
        TextField
    },
    methods: {
        onChildInput (value) {
            this.$emit('ghUsernameInput', value)
        }
    }
}
</script>

<style scoped>
.nav-header {
    border: 2px solid black;
    width: '100%';
    height: '1000px';
    padding-top: 0;
    margin-top: 0;
}
</style>