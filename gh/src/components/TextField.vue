<template>
    <div> 
        <label>
            {{label}} <input v-model="userInput" v-on:keyup.enter="emitToParent"/>
        </label>
    </div>
</template>

<script>
export default {
    name: 'TextField',
    props: {
        label: String
    },
    data() {
        return {
            userInput: ''
        }
    },
    methods: {
        emitToParent () {
            this.$emit('onInputEnter', this.userInput)
        }
    }
}
</script>

<style scoped>
input {
    width: '100%'
}
</style>