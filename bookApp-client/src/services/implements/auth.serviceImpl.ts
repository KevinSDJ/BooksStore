import { AuthService,login,register } from "../auth.service";
import axios from 'axios'
const baseApi = import.meta.env.VITE_API_BASE

class AuthServiceImpl implements AuthService {

    constructor(){
        
    }
    signIn(data: login, cb: Function) {
        axios.post(baseApi+'/auth/login',data)
        .then(r=>{
            cb(r)
        })
        .catch(error=>{
            cb(error)
        })
    }
    signUp(data: register, cb: Function) {
        axios.post(baseApi+"/auth/register",data)
        .then(r=>{
            cb(r)
        })
        .catch(error=>{
            cb(error)
        })
    }
    
}

export const authService= new AuthServiceImpl()


