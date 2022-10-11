import axios from 'axios'

const url = import.meta.env.VITE_API_BASE


export const axiosInstance= axios.create({
    baseURL:url
})



